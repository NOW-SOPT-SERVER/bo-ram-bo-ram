package com.sopt.seminar.config.auth.redis.repository;

import com.sopt.seminar.config.auth.redis.domain.Token;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, String> {
    Optional<Token> findByRefreshToken(final String refreshToken);
    Optional<Token> findById(final Long id);
}
