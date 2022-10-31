package com.maotterson.currentroutes.locations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class LocationResponse {
    protected LocalDateTime timestamp;
    protected HttpStatus status;
    @JsonProperty("status_code")
    protected int statusCode;
    protected String reason;
    protected String message;
    protected Map<?,?> data;
}