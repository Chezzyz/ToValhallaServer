package ru.rsc.tovalhallaserver.processors.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Value;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Value
@JsonDeserialize
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerSessionDto {
    UUID uuid;
    String username;
    LocalDateTime timestamp;
    Duration gameTime;
    Duration flyTime;
    Integer flyHeight;
    String levelName;
    Integer sessionCoinsCount;
    Integer coinsCount;
    Integer hammersCount;
    Integer skinsCount;
    Integer artifactsCount;
    List<ScoreDto> bestScores;
}
