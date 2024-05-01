package com.sopt.seminar.settirngs.settirngs;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @LocalServerPort
    private int port;

    @BeforeEach
        //각 테스트 진행 전 실행
    void setUp() {
        RestAssured.port = port;
    }
}
