package com.github.click.nd.rest.uds.service;

import com.github.click.nd.rest.uds.exception.UserDataServiceException;
import com.github.click.nd.rest.uds.to.request.CreateApiDefinitionRequestTO;
import com.github.click.nd.rest.uds.to.response.CreateUserDefinitionResponseTO;
import com.github.click.nd.rest.uds.to.response.UserApisResponseTO;
import com.github.click.nd.rest.uds.to.response.common.EmptyResponseTO;

public interface UserDataStorageService {
    UserApisResponseTO getUserApis();

    CreateUserDefinitionResponseTO saveUserDefinition(CreateApiDefinitionRequestTO request) throws UserDataServiceException;
}
