package ru.rsc.tovalhallaserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Value;

@Value
@JsonDeserialize
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminTokenDto {
    String token;
}
