package com.maotterson.currentroutes.trips;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class TripResponse {
    protected LocalDateTime timestamp;
    protected HttpStatus status;
    @JsonProperty("status_code")
    protected int statusCode;
    protected String reason;
    protected String message;
    protected Collection<TripDto> data;
}
