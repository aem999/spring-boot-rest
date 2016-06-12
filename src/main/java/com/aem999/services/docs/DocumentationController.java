package com.aem999.services.docs;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Display API Documentation.
 */
@Api(tags = {"Documentation"}, description = "REST API")
@Controller
public class DocumentationController {

    @ApiOperation(value = "Display REST API documentation")
    @RequestMapping(value = {"/", "/api", "/api/", "/api/docs"}, method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String docs() {
        return "redirect:/api/docs/swagger-ui.html";
    }
}
