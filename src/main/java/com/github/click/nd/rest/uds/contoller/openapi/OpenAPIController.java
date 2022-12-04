package com.github.click.nd.rest.uds.contoller.openapi;


import com.github.click.nd.rest.uds.util.TextConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *  Redirection to OpenAPI api documentation
 */
@OpenAPIDefinition(
        info = @Info(title = "UserDataStorageService",
                description = "Сервис для сохранения пользовательских данных и конфигураций",
                version = "0.0.1"),
        servers = {
            @Server(url = "${server.servlet.context-path:}", description = "API single instance"),
        })
@Controller
public class OpenAPIController {

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @RequestMapping("/")
    public String index() {
        return "redirect:/swagger-ui/index.html?configUrl="
                .concat((StringUtils.hasLength(contextPath) ? contextPath : TextConstants.EMPTY_STRING))
                .concat("/v3/api-docs/swagger-config");
    }
}