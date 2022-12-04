package com.github.click.nd.rest.uds.to.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApiDefinitionRequestTO {
    private String id;
    private String rawValue;
}
