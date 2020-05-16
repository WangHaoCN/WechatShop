
package com.ssm.wechatshop.flink.writer;

import lombok.extern.slf4j.Slf4j;
import org.apache.flink.streaming.connectors.fs.Writer;
import org.apache.flink.util.Preconditions;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.column.ParquetProperties;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.hadoop.ParquetFileWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.example.ExampleParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.schema.MessageType;

import java.io.IOException;

import static org.apache.parquet.schema.MessageTypeParser.parseMessageType;

/**
 * galileo: SinkParquetWriter
 *
 * @author wanghao
 * @version 2019-12-11 14:23
 */
@Slf4j
public class SinkParquetWriter<T extends Group> implements Writer<T> {
    private static final long serialVersionUID = -975302556515811398L;

    private final String schemaRepresentation;

    private transient MessageType messageType;
    private transient ParquetWriter<Group> writer;
    private transient Path path;

    private int position;

    public SinkParquetWriter(String schemaRepresentation, MessageType messageType) {
        this.schemaRepresentation = Preconditions.checkNotNull(schemaRepresentation);
        this.messageType = messageType;
    }

    @Override
    public void open(FileSystem fs, Path path) throws IOException {
        this.position = 0;
        this.path = path;

        if (writer != null) {
            writer.close();
        }

        writer = createWriter(schemaRepresentation);
    }

    @Override
    public long flush() throws IOException {
        Preconditions.checkNotNull(writer);
        position += writer.getDataSize();
        writer.close();
        writer = createWriter(schemaRepresentation);

        return position;
    }

    @Override
    public long getPos() {
        Preconditions.checkNotNull(writer);
        return position + writer.getDataSize();
    }

    @Override
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }

    @Override
    public void write(T element) throws IOException {
        Preconditions.checkNotNull(writer);
        writer.write(element);
    }

    @Override
    public Writer<T> duplicate() {
        return new SinkParquetWriter<>(schemaRepresentation, messageType);
    }

    private ParquetWriter<Group> createWriter(String schemaStr) throws IOException {
        MessageType parquetSchema = parseMessageType(schemaStr);

        Configuration configuration = new Configuration();
        configuration.set("parquet.example.schema", parquetSchema.toString());

        return ExampleParquetWriter.builder(path)
                .withWriteMode(ParquetFileWriter.Mode.OVERWRITE)
                .withWriterVersion(ParquetProperties.WriterVersion.PARQUET_1_0)
                .withCompressionCodec(CompressionCodecName.SNAPPY)
                .withConf(configuration)
                .withRowGroupSize(128 * 1024 * 1024)
                .withPageSize(50 * 1024 * 1024)
                .withDictionaryPageSize(50 * 1024 * 1024)
                .withType(parquetSchema)
                .build();
    }
}