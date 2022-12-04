package com.github.click.nd.rest.uds.contoller;

import com.github.click.nd.rest.uds.exception.UserDataServiceException;
import com.github.click.nd.rest.uds.service.UserDataStorageService;
import com.github.click.nd.rest.uds.to.request.CreateApiDefinitionRequestTO;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserDataStorageController {

    private final UserDataStorageService userDataStorageService;

    @GetMapping("/apis")
    public ResponseEntity<?> getUserApis() {
        return ResponseEntity.ok(userDataStorageService.getUserApis());
    }

    @PutMapping("/save")
    public ResponseEntity<?> saveApiDefinition(@RequestBody CreateApiDefinitionRequestTO request) throws UserDataServiceException {
        return ResponseEntity.ok(userDataStorageService.saveUserDefinition(request));
    }

}
