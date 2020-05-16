
package com.ssm.wechatshop.flink.utils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * galileo: StringSplitterUtils
 *
 * @author wanghao
 * @version 2019-12-16 09:54
 */
@UtilityClass
public class StringSplitterUtils {

    /**
     * Split a str with a char, also include the regex char.
     */
    public static List<String> split(String string, char delimiter) {
        int off = 0;
        int next;

        List<String> list = new ArrayList<>();

        while ((next = string.indexOf(delimiter, off)) != -1) {
            list.add(string.substring(off, next));
            off = next + 1;
        }

        // If no match was found, return this
        if (off == 0) {
            return Collections.singletonList(string);
        }

        if (off <= string.length()) {
            // Add remaining segment
            list.add(string.substring(off));
        }

        return list;
    }

    public static List<String> split(String string, String delimiter) {
        if (delimiter.length() == 1) {
            return split(string, delimiter.charAt(0));
        } else {
            int off = 0;
            int next;

            List<String> result = new ArrayList<>();

            while ((next = string.indexOf(delimiter, off)) != -1) {
                result.add(string.substring(off, next));
                off = next + delimiter.length();
            }

            // If no match was found, return this
            if (off == 0) {
                return Collections.singletonList(string);
            }

            if (off <= string.length()) {
                // Add remaining segment
                result.add(string.substring(off));
            }

            return result;
        }
    }

    @NonNull
    public static String setMethodName(String str) {
        StringBuilder stringBuilder = new StringBuilder("set");
        if (!isNullOrEmpty(str)) {
            stringBuilder.append(str.substring(0, 1).toUpperCase()).append(str.substring(1));
        }
        return stringBuilder.toString();
    }

    public static String getSchemaStr(String ckName, Set<ResponseEntity> entitySet) {
        StringBuilder schemaString = new StringBuilder("message ");
        schemaString.append(ckName);
        schemaString.append(" { ");
        schemaString.append(" optional int64 processTime; ");
        schemaString.append(" optional binary dataSource; ");
        for (ResponseEntity entity : entitySet) {
            schemaString.append("optional ");
            schemaString.append("Date".equalsIgnoreCase(entity.getColumn_type()) ? "int64 " : "binary ");
            schemaString.append(entity.getColumn_name());
            schemaString.append(";");
        }
        schemaString.append("}");
        return schemaString.toString();
    }
}
