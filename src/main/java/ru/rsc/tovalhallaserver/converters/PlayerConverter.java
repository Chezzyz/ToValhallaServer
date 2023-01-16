package ru.rsc.tovalhallaserver.converters;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import ru.rsc.tovalhallaserver.domain.model.Player;
import ru.rsc.tovalhallaserver.domain.model.Score;
import ru.rsc.tovalhallaserver.dto.PlayerDto;
import ru.rsc.tovalhallaserver.dto.PlayerSessionDto;
import ru.rsc.tovalhallaserver.dto.ScoreDto;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PlayerConverter {

    @NonNull
    public Player convertNew(@NotNull PlayerSessionDto dto) {
        return new Player(UUID.randomUUID(), UUID.fromString(dto.getPlayerId()), dto.getUsername(), Duration.ofSeconds(dto.getGameTime()),
                Duration.ofSeconds(dto.getFlyTime()), 1,
                dto.getCoinsCount(), dto.getHammersCount(), dto.getSkinsCount(), dto.getArtifactsCount(),
                dto.getBestScores()
                        .stream()
                        .map(scoreDto -> new Score(scoreDto.getLevelName(), scoreDto.getHeight()))
                        .collect(Collectors.toList()));
    }

    @NonNull
    public Player convertExisted(@NotNull PlayerSessionDto dto, @NotNull Player existed) {
        Player player = new Player(existed.getUuid(), UUID.fromString(dto.getPlayerId()), dto.getUsername(), Duration.ofSeconds(dto.getGameTime()),
                existed.getEntireFlyTime().plus(Duration.ofSeconds(dto.getFlyTime())), existed.getSessionsCount() + 1,
                dto.getCoinsCount(), dto.getHammersCount(), dto.getSkinsCount(), dto.getArtifactsCount(),
                dto.getBestScores()
                        .stream()
                        .map(scoreDto -> new Score(scoreDto.getLevelName(), scoreDto.getHeight()))
                        .collect(Collectors.toList()));
        player.setId(existed.getId());
        return player;
    }

    @Nullable
    public PlayerDto convert(@Nullable Player player) {
        if (player == null) return null;
        return new PlayerDto(player.getUsername(), 100, player.getSessionsCount(), TimeConverter.convertToString(player.getGameTime()),
                TimeConverter.convertToString(player.getEntireFlyTime()), player.getCoinsCount(), player.getHammersCount(), 8,
                player.getArtifactsCount(), 5, player.getSkinsCount(), 3,
                player.getBestScores()
                        .stream()
                        .map(score -> new ScoreDto(score.getLevelName(), score.getHeight()))
                        .collect(Collectors.toList()));
    }
}
