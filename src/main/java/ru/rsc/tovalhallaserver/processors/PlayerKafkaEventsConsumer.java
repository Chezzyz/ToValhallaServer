package ru.rsc.tovalhallaserver.processors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.rsc.tovalhallaserver.domain.constants.KafkaTopics;
import ru.rsc.tovalhallaserver.domain.model.Player;
import ru.rsc.tovalhallaserver.domain.model.Score;
import ru.rsc.tovalhallaserver.domain.repository.PlayersRepository;
import ru.rsc.tovalhallaserver.processors.dto.PlayerSessionDto;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlayerKafkaEventsConsumer {

    private final PlayersRepository repository;

    @KafkaListener(topics = KafkaTopics.PLAYER_SESSION, containerFactory = "kafkaListenerContainerFactory", autoStartup = "false")
    public void handle(@NotNull PlayerSessionDto dto) {
        Optional<Player> player = repository.findByUuid(dto.getUuid());
        if (player.isPresent()) {
            repository.save(convertExisted(dto, player.get()));
            log.info("update player with username {}", player.get().getUsername());
        } else {
            log.info("save new player - {}", dto);
            repository.save(convertNew(dto));
        }
    }

    private Player convertExisted(@NotNull PlayerSessionDto dto, @NotNull Player existed) {
        Player player = new Player( dto.getUuid(), dto.getUsername(), dto.getGameTime(),
                existed.getEntireFlyTime().plus(dto.getFlyTime()), existed.getSessionsCount() + 1,
                dto.getCoinsCount(), dto.getHammersCount(), dto.getSkinsCount(), dto.getArtifactsCount(),
                dto.getBestScores()
                        .stream()
                        .map(scoreDto -> new Score(scoreDto.getLevelName(), scoreDto.getHeight(), scoreDto.getCoins(), scoreDto.getFlyTime()))
                        .collect(Collectors.toList()));
        player.setId(existed.getId());
        return player;
    }

    private Player convertNew(@NotNull PlayerSessionDto dto){
        return new Player(dto.getUuid(), dto.getUsername(), dto.getGameTime(),
                dto.getFlyTime(), 1,
                dto.getCoinsCount(), dto.getHammersCount(), dto.getSkinsCount(), dto.getArtifactsCount(),
                dto.getBestScores()
                        .stream()
                        .map(scoreDto -> new Score(scoreDto.getLevelName(), scoreDto.getHeight(), scoreDto.getCoins(), scoreDto.getFlyTime()))
                        .collect(Collectors.toList()));
    }
}
