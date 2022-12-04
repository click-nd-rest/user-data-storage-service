package com.github.click.nd.rest.uds.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResourceFieldDataType {
    STRING("string"),
    NUMBER("number");

    @JsonValue
    private final String stringValue;
}
