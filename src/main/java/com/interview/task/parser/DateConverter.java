package com.interview.task.parser;

import com.opencsv.bean.AbstractBeanField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class DateConverter extends AbstractBeanField {

    private static final Map<String, String> DATE_FORMAT_TYPES = new HashMap<>() {{
        put("^\\d{8}$", "yyyyMMdd");
        put("^\\d{1,2}:\\d{1,2}:\\d{4}$", "dd:MM:yyyy");
        put("^\\d{1,2}-\\d{1,2}-\\d{4}$", "dd-MM-yyyy");
        put("^\\d{4}-\\d{1,2}-\\d{1,2}$", "yyyy-MM-dd");
        put("^\\d{1,2}/\\d{1,2}/\\d{4}$", "MM/dd/yyyy");
        put("^\\d{4}/\\d{1,2}/\\d{1,2}$", "yyyy/MM/dd");
        put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}$", "dd MMM yyyy");
        put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}$", "dd MMMM yyyy");
    }};

    @Override
    protected Object convert(String dateString) {
        dateString = dateString.trim();
        LocalDate converted;
        if ("NULL".equals(dateString)) {
            converted = LocalDate.now();
        } else {
            String probedFormat = determineFormat(dateString);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(probedFormat);
            return LocalDate.parse(dateString, formatter);
        }
        return converted;
    }

    private String determineFormat(String dateString) {
        for (String regexp : DATE_FORMAT_TYPES.keySet()) {
            if (dateString.toLowerCase().matches(regexp)) {
                return DATE_FORMAT_TYPES.get(regexp);
            }
        }
        throw new RuntimeException("Can't match to any present date format...");
    }
}