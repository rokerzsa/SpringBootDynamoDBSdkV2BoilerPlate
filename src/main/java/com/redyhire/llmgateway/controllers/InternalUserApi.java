package com.redyhire.llmgateway.controllers;

import com.redyhire.llmgateway.constants.RequestMappings;
import com.redyhire.llmgateway.models.InternalUserLoginRequest;
import com.redyhire.llmgateway.models.InternalUserLoginSuccessResponse;
import com.redyhire.llmgateway.services.InternalUserLoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestMappings.BASE_PATH)
@Tag(name = "Internal User Management API", description = "Operations related to management of internal users of redyhire")
public class InternalUserApi {
    @Autowired
    InternalUserLoginService internalUserLoginService;
    @Operation(summary = "Internal User Login", description = "API used to login internal user and generate a login token")
    @ApiResponse(responseCode = "200", description = "Login Successful")
    @ApiResponse(responseCode = "401", description = "User not authorized")
    @PostMapping(RequestMappings.LOGIN)
    public InternalUserLoginSuccessResponse login(@RequestBody InternalUserLoginRequest internalUserLoginRequest, HttpServletResponse response){
            InternalUserLoginSuccessResponse internalUserLoginSuccessResponse = internalUserLoginService.userLogin(internalUserLoginRequest);
            response.addCookie(internalUserLoginService.getLoginCookie(internalUserLoginRequest));
            return  internalUserLoginSuccessResponse;
    }
}
