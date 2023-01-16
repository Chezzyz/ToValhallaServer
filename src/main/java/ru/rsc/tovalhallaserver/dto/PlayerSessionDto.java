package ru.rsc.tovalhallaserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@JsonDeserialize
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerSessionDto {
    String playerId;
    String username;
    LocalDateTime timestamp;
    Long gameTime;
    Long flyTime;
    Integer flyHeight;
    String levelName;
    Integer sessionCoinsCount;
    Integer coinsCount;
    Integer hammersCount;
    Integer skinsCount;
    Integer artifactsCount;
    List<ScoreDto> bestScores;
}
