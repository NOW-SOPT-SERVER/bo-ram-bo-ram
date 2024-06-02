package com.sopt.seminar.config.auth.redis.controller;

import com.sopt.seminar.common.dto.ApiResponse;
import com.sopt.seminar.common.dto.SuccessMessage;
import com.sopt.seminar.config.auth.PrincipalHandler;
import com.sopt.seminar.config.auth.redis.Service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;
    private final PrincipalHandler principalHandler;

    @PostMapping("api/v1/refresh-token")
    public ApiResponse reissueAccessToken(){
        return ApiResponse.success(
                        SuccessMessage.ACCESS_TOKEN_REFRESH_SUCCESS,
                        tokenService.reissueAccessTokenByRefreshToken(principalHandler.getUserIdFromPrincipal()));
    }
}
