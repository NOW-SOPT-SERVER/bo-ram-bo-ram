package com.sopt.seminar.settirngs.controller;

import com.sopt.seminar.service.dto.MemberCreateDto;
import com.sopt.seminar.respository.MemberRepository;
import com.sopt.seminar.service.MemberService;
import com.sopt.seminar.settirngs.settirngs.ApiTest;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static com.sopt.seminar.domain.Part.SERVER;


public class MemberControllerTest extends ApiTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Nested // 중첩 테스트를 진행할 수 있게하는 테스트
    @DisplayName("멤버 생성 테스트")
    public class CreateMember {

        @Test
        @DisplayName("요청 성공 케이스")
        public void createMemberSuccess() throws Exception {
            //given
            final var request = new MemberCreateDto(
                    "도소현",
                    SERVER,
                    24);
            //when
            final var response = RestAssured
                    .given()
                    .log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(request)
                    .when()
                    .post("/api/v1/member")
                    .then().log().all().extract();
            //then
            Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        }

    }

}
