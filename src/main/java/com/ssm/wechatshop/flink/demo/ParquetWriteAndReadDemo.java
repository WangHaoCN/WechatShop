
package com.ssm.wechatshop.flink.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.example.data.simple.SimpleGroupFactory;
import org.apache.parquet.hadoop.ParquetFileWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.example.GroupWriteSupport;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.MessageTypeParser;

import java.io.IOException;

/**
 * galileo: ParquetWriteAndReadDemo
 *
 * @author wanghao
 * @version 2019-12-11 10:56
 */
@Slf4j
public class ParquetWriteAndReadDemo {
    //这是一种parse String来制造MessageType的办法
    private static String schemaString = "message schema {"
            + "optional int64 log_id;"
            + "optional binary idc_id;"
            + "optional int64 house_id;"
            + "optional int64 src_ip_long;"
            + "optional int64 dest_ip_long;"
            + "optional int64 src_port;"
            + "optional int64 dest_port;"
            + "optional int32 protocol_type;"
            + "optional binary url64;"
            + "optional binary access_time;"
            + "}";
    private static MessageType schema = MessageTypeParser.parseMessageType(schemaString);

    public static void writeParquetToHDFS(String ipAddr, String port, String filePath, String fileName) {
        //1、声明parquet的messageType
        MessageType messageType = schema;

        //2、声明parquetWriter
        Path path = new Path("hdfs://" + ipAddr + ":" + port + "/" + filePath + "/" + fileName);
        Configuration configuration = new Configuration();
        GroupWriteSupport.setSchema(messageType, configuration);
        GroupWriteSupport writeSupport = new GroupWriteSupport();

        //3、写数据
        ParquetWriter<Group> writer = null;
        try {
            writer = new ParquetWriter<Group>(path,
                    ParquetFileWriter.Mode.OVERWRITE,
                    writeSupport,
                    CompressionCodecName.UNCOMPRESSED,
                    128 * 1024 * 1024,
                    5 * 1024 * 1024,
                    5 * 1024 * 1024,
                    ParquetWriter.DEFAULT_IS_DICTIONARY_ENABLED,
                    ParquetWriter.DEFAULT_IS_VALIDATING_ENABLED,
                    ParquetWriter.DEFAULT_WRITER_VERSION,
                    configuration);

            //4、构建parquet数据，封装成Group。
            for (int i = 0; i < 10; i++) {
                Group group = new SimpleGroupFactory(messageType).newGroup();
                group.append("name", i + "@ximalaya.com")
                        .append("id", i + "@id")
                        .append("age", i)
                        .addGroup("group1")
                        .append("test1", "test1" + i)
                        .append("test2", "test2" + i);
                writer.write(group);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //writeParquetOnDisk("test1.parq");
        //readParquetFromDisk("test1.parq");
        writeParquetToHDFS("127.0.0.1", "9000", "/tmp", "test1.parq");
    }
}
