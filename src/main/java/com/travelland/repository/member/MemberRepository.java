package com.travelland.repository.member;

import com.travelland.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
    Optional<Member> findBySocialId(Long socialId);
    Optional<Member> findByNickname(String nickname);

}
