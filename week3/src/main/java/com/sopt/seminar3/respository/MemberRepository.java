package com.sopt.seminar3.respository;
import com.sopt.seminar3.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
