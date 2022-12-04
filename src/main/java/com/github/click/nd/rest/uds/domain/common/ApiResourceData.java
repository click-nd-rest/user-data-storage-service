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
public class ApiResourceData {
    private String name;
    private List<ResourceFieldData> resourceFields;

    @JsonIgnore
    public Boolean isValid() {
        return Objects.nonNull(name) && Objects.nonNull(resourceFields)
                && resourceFields.stream().allMatch(ResourceFieldData::isValid);
    }
}
