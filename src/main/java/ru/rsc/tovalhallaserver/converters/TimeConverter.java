package ru.rsc.tovalhallaserver.converters;

import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class TimeConverter {

    public static String convertToString(Duration duration){
        return String.format("%sд. %sч. %sмин.", duration.toDaysPart(), duration.toHoursPart(), duration.toMinutesPart());
    }
}
