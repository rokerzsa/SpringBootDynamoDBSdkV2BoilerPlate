package com.redyhire.llmgateway.services;

import com.redyhire.llmgateway.dao.repositories.InternalUserRepository;
import com.redyhire.llmgateway.exceptions.LoginFailureException;
import com.redyhire.llmgateway.models.InternalUserLoginRequest;
import com.redyhire.llmgateway.models.InternalUserLoginSuccessResponse;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternalUserLoginService {
    private final static String LOGIN_COOKIE_NAME = "login-cookie";
    @Autowired
    InternalUserRepository internalUserRepository;
    public InternalUserLoginSuccessResponse userLogin(InternalUserLoginRequest internalUserLoginRequest) throws LoginFailureException {
        if(internalUserLoginRequest.getUnitId().equalsIgnoreCase("123") & internalUserLoginRequest.getOneTimePassword().equalsIgnoreCase("123")){
            return InternalUserLoginSuccessResponse.builder().userId(internalUserLoginRequest.getUserId()).build();
        }
        throw new LoginFailureException("Unable to login");
    }
    public Cookie getLoginCookie(InternalUserLoginRequest internalUserLoginRequest){
        return new Cookie(LOGIN_COOKIE_NAME, "token");
    }
}
