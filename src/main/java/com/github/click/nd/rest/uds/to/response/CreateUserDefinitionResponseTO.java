package com.github.click.nd.rest.uds.to.response;

import com.github.click.nd.rest.uds.enumeration.SaveType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDefinitionResponseTO {
    private String id;
    private String lastEditTimestamp;
    private SaveType saveType;
}
