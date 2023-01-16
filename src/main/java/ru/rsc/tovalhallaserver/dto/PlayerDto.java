package ru.rsc.tovalhallaserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Value;

import java.util.List;

@Value
@JsonDeserialize
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDto {
    String username;
    Integer completeGamePercent;
    Integer sessionsCount;
    String gameTime;
    String flyTime;
    Integer coinsCount;
    Integer boughtHammersCount;
    Integer hammersCount;
    Integer boughtArtifactsCount;
    Integer artifactsCount;
    Integer boughtSkinsCount;
    Integer skinsCount;
    List<ScoreDto> bestScores;
}
