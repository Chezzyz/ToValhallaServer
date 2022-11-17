package ru.rsc.tovalhallaserver.domain.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KafkaTopics {
    public static final String PLAYER_SESSION = "player-sessions";
}
