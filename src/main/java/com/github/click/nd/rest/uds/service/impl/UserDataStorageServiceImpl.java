package com.github.click.nd.rest.uds.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.click.nd.rest.uds.domain.common.ApiDefinition;
import com.github.click.nd.rest.uds.domain.document.ApiDefinitionDataDocument;
import com.github.click.nd.rest.uds.enumeration.SaveType;
import com.github.click.nd.rest.uds.exception.UserDataServiceException;
import com.github.click.nd.rest.uds.repository.ApiDefinitionRepository;
import com.github.click.nd.rest.uds.service.UserDataStorageService;
import com.github.click.nd.rest.uds.to.request.CreateApiDefinitionRequestTO;
import com.github.click.nd.rest.uds.to.response.CreateUserDefinitionResponseTO;
import com.github.click.nd.rest.uds.to.response.UserApisResponseTO;
import com.github.click.nd.rest.uds.util.SecurityUtil;
import com.github.click.nd.rest.uds.util.TextConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDataStorageServiceImpl implements UserDataStorageService {
    private final ApiDefinitionRepository apiDefinitionRepository;


    @Override
    public UserApisResponseTO getUserApis() {
        String currentUsername = SecurityUtil.getCurrentUsername();
        List<ApiDefinitionDataDocument> apiDefinitionDataDocuments = apiDefinitionRepository.findAllByOwnerUsername(currentUsername);
        return new UserApisResponseTO()
                .setDefinitions(apiDefinitionDataDocuments);
    }

    @Override
    public CreateUserDefinitionResponseTO saveUserDefinition(CreateApiDefinitionRequestTO request) throws UserDataServiceException {
        if (Objects.isNull(request.getRawValue())) {
            throw new UserDataServiceException(TextConstants.INCORRECT_API_DEFINITION_ERROR_MESSAGE);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        ApiDefinitionDataDocument apiDefinitionDataDocument = new ApiDefinitionDataDocument()
                .setRawContent(request.getRawValue())
                .setId(request.getId())
                .setOwnerUsername(SecurityUtil.getCurrentUsername())
                .setDefinition(null);

        try {
            ApiDefinition apiDefinition = objectMapper.readValue(request.getRawValue(), ApiDefinition.class);
            if (Objects.nonNull(apiDefinition) && apiDefinition.isValid()) {
                apiDefinitionDataDocument.setDefinition(apiDefinition);
                apiDefinitionDataDocument.setModificationDate(String.valueOf(System.currentTimeMillis()));
            }
        } catch (JsonProcessingException ignored) {
        }

        ApiDefinitionDataDocument savedItem = apiDefinitionRepository.save(apiDefinitionDataDocument);
        log.info("Saved api definition with id: {}, content: {}, isValid: {}",
                savedItem.getId(),
                savedItem.getRawContent(),
                Objects.nonNull(savedItem.getDefinition()));

        return new CreateUserDefinitionResponseTO(
                savedItem.getId(),
                Objects.isNull(savedItem.getModificationDate()) ? null : savedItem.getModificationDate(),
                Objects.isNull(savedItem.getDefinition()) ? SaveType.RAW : SaveType.VALID
        );
    }

}
