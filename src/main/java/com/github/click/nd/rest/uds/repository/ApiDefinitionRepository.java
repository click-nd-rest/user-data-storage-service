package com.github.click.nd.rest.uds.repository;

import com.github.click.nd.rest.uds.domain.document.ApiDefinitionDataDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApiDefinitionRepository extends MongoRepository<ApiDefinitionDataDocument, String> {
    List<ApiDefinitionDataDocument> findAllByOwnerUsername(String username);
}