package com.ssm.wechatshop.flink.bucketing;

import alluxio.shaded.client.com.google.common.primitives.Ints;
import alluxio.shaded.client.org.apache.curator.shaded.com.google.common.primitives.Longs;
import org.apache.flink.streaming.connectors.fs.Clock;
import org.apache.flink.streaming.connectors.fs.bucketing.Bucketer;
import org.apache.flink.util.Preconditions;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.io.api.Binary;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static java.time.Instant.ofEpochSecond;

/**
 * galileo DateTime Bucketer
 *
 * @author wanghao
 * @version 2019-12-13 14:28
 */
public class DateTimeBucketer<T> implements Bucketer<T> {
    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_FORMAT_STRING = "yyyy-MM-dd--HH";

    private final String formatString;

    private final ZoneId zoneId;

    private String eventTimeName;

    private transient DateTimeFormatter dateTimeFormatter;

    private static final int JULIAN_EPOCH_OFFSET_DAYS = 2440588;

    private static final long MILLIS_IN_DAY = TimeUnit.DAYS.toMillis(1);

    private static final long NANOS_PER_MILLISECOND = TimeUnit.MILLISECONDS.toNanos(1);

    /**
     * Creates a new {@code DateTimeBucketer} with format string {@code "yyyy-MM-dd--HH"} using JVM's default timezone.
     */
    public DateTimeBucketer() {
        this(DEFAULT_FORMAT_STRING);
    }

    /**
     * Creates a new {@code DateTimeBucketer} with the given date/time format string using JVM's default timezone.
     *
     * @param formatString The format string that will be given to {@code DateTimeFormatter} to determine
     *                     the bucket path.
     */
    public DateTimeBucketer(String formatString) {
        this(formatString, ZoneId.systemDefault());
    }

    public DateTimeBucketer(String formatString, String eventTimeName) {
        this(formatString, ZoneId.systemDefault());
        this.eventTimeName = eventTimeName;
    }

    /**
     * Creates a new {@code DateTimeBucketer} with format string {@code "yyyy-MM-dd--HH"} using the given timezone.
     *
     * @param zoneId The timezone used to format {@code DateTimeFormatter} for bucket path.
     */
    public DateTimeBucketer(ZoneId zoneId) {
        this(DEFAULT_FORMAT_STRING, zoneId);
    }

    /**
     * Creates a new {@code DateTimeBucketer} with the given date/time format string using the given timezone.
     *
     * @param formatString The format string that will be given to {@code DateTimeFormatter} to determine
     *                     the bucket path.
     * @param zoneId       The timezone used to format {@code DateTimeFormatter} for bucket path.
     */
    public DateTimeBucketer(String formatString, ZoneId zoneId) {
        this.formatString = Preconditions.checkNotNull(formatString);
        this.zoneId = Preconditions.checkNotNull(zoneId);

        this.dateTimeFormatter = DateTimeFormatter.ofPattern(this.formatString).withZone(zoneId);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        this.dateTimeFormatter = DateTimeFormatter.ofPattern(formatString).withZone(zoneId);
    }

    @Override
    public Path getBucketPath(Clock clock, Path basePath, T element) {
        Group group = (Group) element;
        String newDateTimeString = dateTimeFormatter.format(ofEpochSecond(group.getLong(eventTimeName, 0)));

        return new Path(basePath + "/date=" + newDateTimeString);
    }

    @Override
    public String toString() {
        return "DateTimeBucketer{" +
                "formatString='" + formatString + '\'' +
                ", zoneId=" + zoneId +
                '}';
    }

    /**
     * Returns GMT timestamp from binary encoded parquet timestamp (12 bytes - julian date + time of day nanos).
     *
     * @param timestampBinary INT96 parquet timestamp
     * @return timestamp in millis, GMT timezone
     */
    public static long getTimestampMillis(Binary timestampBinary) {
        if (timestampBinary.length() != 12) {
            return 0;
        }
        byte[] bytes = timestampBinary.getBytes();

        long timeOfDayNanos = Longs.fromBytes(bytes[7], bytes[6], bytes[5], bytes[4], bytes[3], bytes[2], bytes[1], bytes[0]);
        int julianDay = Ints.fromBytes(bytes[11], bytes[10], bytes[9], bytes[8]);

        return julianDayToMillis(julianDay) + (timeOfDayNanos / NANOS_PER_MILLISECOND);
    }

    private static long julianDayToMillis(int julianDay) {
        return (julianDay - JULIAN_EPOCH_OFFSET_DAYS) * MILLIS_IN_DAY;
    }
}
