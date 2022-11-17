package ru.rsc.tovalhallaserver.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Embeddable;
import java.time.Duration;

@Value
@Embeddable
public class Score {
    String levelName;
    Integer height;
    Integer coins;
    Duration flyTime;
}
