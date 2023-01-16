package ru.rsc.tovalhallaserver.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    String levelName;
    Integer height;
}
