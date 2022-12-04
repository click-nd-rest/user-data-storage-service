package com.github.click.nd.rest.uds.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiDefinition {
    private String id;
    private List<ApiResourceData> resources;

    @JsonIgnore
    public Boolean isValid() {
        return Objects.nonNull(resources)
                && resources.stream().allMatch(ApiResourceData::isValid);
    }

}
