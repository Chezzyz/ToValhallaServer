package ru.rsc.tovalhallaserver.domain.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.rsc.tovalhallaserver.domain.model.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RepositoryRestResource(path = "players", itemResourceRel = "player")
public interface PlayersRepository extends JpaRepository<Player, Integer> {
    boolean existsByUuid(UUID uuid);

    Optional<Player> findByUuid(UUID uuid);

    Optional<Player> findByPlayerId(UUID playerId);

    @NotNull List<Player> findAll();
}
