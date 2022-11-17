package ru.rsc.tovalhallaserver.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Duration;

@Converter
public class DurationConverter implements AttributeConverter<Duration, Long> {
    @Override
    public Long convertToDatabaseColumn(Duration attribute) {
        return attribute.toSeconds();
    }

    @Override
    public Duration convertToEntityAttribute(Long dbData) {
        return Duration.ofSeconds(dbData);
    }
}
