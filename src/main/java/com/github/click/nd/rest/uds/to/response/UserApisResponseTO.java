package com.github.click.nd.rest.uds.to.response;

import com.github.click.nd.rest.uds.domain.document.ApiDefinitionDataDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserApisResponseTO {
    private List<ApiDefinitionDataDocument> definitions;
}
