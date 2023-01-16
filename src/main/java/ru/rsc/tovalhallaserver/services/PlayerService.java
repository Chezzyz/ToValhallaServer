package ru.rsc.tovalhallaserver.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.rsc.tovalhallaserver.converters.PlayerConverter;
import ru.rsc.tovalhallaserver.domain.model.Player;
import ru.rsc.tovalhallaserver.domain.repository.PlayersRepository;
import ru.rsc.tovalhallaserver.dto.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayersRepository repository;

    private final PlayerConverter converter;

    public void saveSession(PlayerSessionDto dto){
        Optional<Player> player = repository.findByPlayerId(UUID.fromString(dto.getPlayerId()));
        if (player.isPresent()) {
            repository.save(converter.convertExisted(dto, player.get()));
            log.info("update player with username {}", player.get().getUsername());
        } else {
            log.info("save new player - {}", dto);
            repository.save(converter.convertNew(dto));
        }
    }

    public PlayerDto getPlayerById(UUID id){
        Optional<Player> player = repository.findByPlayerId(id);
        return converter.convert(player.orElse(null));
    }

    public BestScoresDto getBestScores(String levelName, Integer count){
        List<Player> players = repository.findAll();
        List<PlayerBestScoreDto> bestScores = players
                .stream()
                .map(player -> player.getBestScores()
                        .stream()
                        .filter(score -> score.getLevelName().equals(levelName))
                        .findFirst()
                        .map(score -> new PlayerBestScoreDto(player.getUsername(), score.getHeight())).orElse(null))
                .collect(Collectors.toList());
        bestScores = bestScores
                .stream()
                .sorted((score1,score2) -> Integer.compare(score2.getHeight(), score1.getHeight()))
                .limit(count)
                .collect(Collectors.toList());
        return new BestScoresDto(bestScores);
    }
}
