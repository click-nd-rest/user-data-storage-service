package com.github.click.nd.rest.uds.domain.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.click.nd.rest.uds.domain.common.ApiDefinition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(collection = "built_api_definitions")
public class ApiDefinitionDataDocument {
    @Id
    private String id;

    @Field
    @JsonIgnore
    private String ownerUsername;

    @Field
    private String rawContent;

    @Field
    private String modificationDate;

    @Field
    private ApiDefinition definition;

}
