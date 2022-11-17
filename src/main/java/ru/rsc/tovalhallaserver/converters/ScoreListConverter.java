package ru.rsc.tovalhallaserver.converters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rsc.tovalhallaserver.domain.model.Score;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@Converter
public class ScoreListConverter implements AttributeConverter<List<Score>, String> {

    private final ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(List<Score> attribute) {
        String json = null;

        try {
            json = objectMapper.writeValueAsString(attribute);
        } catch (final IOException e) {
            log.error("JSON reading error", e);
        }

        return json;
    }

    @Override
    public List<Score> convertToEntityAttribute(String dbData) {
        List<Score> scores = null;

        try {
            scores = objectMapper.readValue(dbData, new TypeReference<>() {});
        } catch (final IOException e) {
            log.error("JSON reading error", e);
        }

        return scores;
    }
}
