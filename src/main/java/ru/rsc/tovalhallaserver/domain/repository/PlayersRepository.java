package ru.rsc.tovalhallaserver.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import ru.rsc.tovalhallaserver.domain.model.Player;
import ru.rsc.tovalhallaserver.domain.model.Score;

import java.time.Duration;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Repository
@RepositoryRestResource(path = "players", itemResourceRel = "player")
public interface PlayersRepository extends JpaRepository<Player, Integer> {
    boolean existsByUuid(UUID uuid);
    Optional<Player> findByUuid(UUID uuid);

    @RestResource(path = "random", rel = "rel")
    default Player createRandom(){
        return save(new Player(UUID.randomUUID(), "username", Duration.ofHours(2), Duration.ofMinutes(20), 1, 2, 3, 4, 5,  Collections.singletonList(new Score("levelname", 10, 10, Duration.ofMinutes(2)))));
    }
}
