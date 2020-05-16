package com.ssm.wechatshop.flink.functions;

import org.apache.avro.generic.GenericRecord;
import org.apache.flink.core.io.SimpleVersionedSerializer;
import org.apache.flink.streaming.api.functions.sink.filesystem.BucketAssigner;
import org.apache.flink.streaming.api.functions.sink.filesystem.bucketassigners.SimpleVersionedStringSerializer;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static java.lang.Long.parseLong;

public class EventBucketAssigner implements BucketAssigner<GenericRecord, String> {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("'yyyy_mm_dd='yyyy-MM-dd");

    private final String eventTimeName;

    public EventBucketAssigner(String eventTimeName) {
        this.eventTimeName = eventTimeName;
    }

    @Override
    public String getBucketId(GenericRecord record, Context context) {

        return Instant
                .ofEpochMilli(parseLong(valueOf(record.get(eventTimeName))))
                .atZone(ZoneOffset.UTC)
                .format(DATE_TIME_FORMATTER);
    }

    @Override
    public SimpleVersionedSerializer<String> getSerializer() {
        return SimpleVersionedStringSerializer.INSTANCE;
    }
}
