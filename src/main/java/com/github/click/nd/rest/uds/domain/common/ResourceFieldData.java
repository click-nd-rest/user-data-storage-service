package com.github.click.nd.rest.uds.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.click.nd.rest.uds.enumeration.ResourceFieldDataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceFieldData {
    private String name;
    private ResourceFieldDataType type;

    @JsonIgnore
    public Boolean isValid() {
        return Objects.nonNull(name) && Objects.nonNull(type);
    }
}
