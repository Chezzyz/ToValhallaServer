package ru.rsc.tovalhallaserver.domain.model;

import lombok.*;
import ru.rsc.tovalhallaserver.converters.DurationConverter;
import ru.rsc.tovalhallaserver.converters.ScoreListConverter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "player_id", nullable = false)
    private UUID playerId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "game_time", nullable = false)
    @Convert(converter = DurationConverter.class)
    private Duration gameTime;

    @Column(name = "entire_fly_time", nullable = false)
    @Convert(converter = DurationConverter.class)
    private Duration entireFlyTime;

    @Column(name = "sessions_count", nullable = false)
    private Integer sessionsCount;

    @Column(name = "coins_count", nullable = false)
    private Integer coinsCount;

    @Column(name = "hammers_count", nullable = false)
    private Integer hammersCount;

    @Column(name = "skins_count", nullable = false)
    private Integer skinsCount;

    @Column(name = "artifacts_count", nullable = false)
    private Integer artifactsCount;

    @Convert(converter = ScoreListConverter.class)
    @Column(name = "best_scores", nullable = false)
    private List<Score> bestScores = new ArrayList<>();

    @Column(name = "create_timestamp", nullable = false)
    private LocalDateTime createTimestamp;

    @Column(name = "update_timestamp", nullable = false)
    private LocalDateTime updateTimestamp;


    @PrePersist
    public void prePersist(){
        createTimestamp = LocalDateTime.now();
        updateTimestamp = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updateTimestamp = LocalDateTime.now();
    }


    public Player(UUID uuid, UUID playerId, String username, Duration gameTime, Duration entireFlyTime, Integer sessionsCount,
                  Integer coinsCount, Integer hammersCount, Integer skinsCount, Integer artifactsCount, List<Score> bestScores){
        this.uuid = uuid;
        this.playerId = playerId;
        this.username = username;
        this.gameTime = gameTime;
        this.entireFlyTime = entireFlyTime;
        this.sessionsCount = sessionsCount;
        this.coinsCount = coinsCount;
        this.hammersCount = hammersCount;
        this.skinsCount = skinsCount;
        this.artifactsCount = artifactsCount;
        this.bestScores = bestScores;
    }
}
