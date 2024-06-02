package com.sopt.seminar.config.auth.redis.Service;

import com.sopt.seminar.config.auth.UserAuthentication;
import com.sopt.seminar.config.auth.redis.domain.Token;
import com.sopt.seminar.config.auth.redis.repository.TokenRepository;
import com.sopt.seminar.config.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenRepository tokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void saveRefreshToken(
            final Long userId,
            final String refreshToken
    ) {
        tokenRepository.save(
                Token.of(
                        userId,
                        refreshToken
                )
        );
    }

    public String reissueAccessTokenByRefreshToken(
            Long userId
    ){
        String newAccessToken = jwtTokenProvider.issueAccessToken(UserAuthentication.createUserAuthentication(userId));
        return newAccessToken;
    }
}
