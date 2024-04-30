package sopt.cloneCoding.carrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.cloneCoding.carrot.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
