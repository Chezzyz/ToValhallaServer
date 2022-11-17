package ru.rsc.tovalhallaserver.processors.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Value;

import java.time.Duration;

@Value
@JsonDeserialize
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreDto {
    String levelName;
    Integer height;
    Integer coins;
    Duration flyTime;
}
