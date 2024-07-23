package hello.servlet.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * MemberRepositoryTest
 *
 * 회원정보 등록, 회원 정보 조회 Test(singleton with no spring)
 *
 * */

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance(); // singleton 이므로 멤버변수로 선언

    @AfterEach
    void afterEach() {
        memberRepository.clearStore(); // 각 테스트는 순서가 보장되지 않으므로 테스트 후 등록된 회원정보를 초기화
    }

    @Test
    void save() {

        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(savedMember).isEqualTo(findMember);
    }

    @Test
    void findAll() {

        //given

        Member memberA = memberRepository.save(new Member("memberA", 10));
        Member memberB = memberRepository.save(new Member("memberB", 20));
        Member memberC = memberRepository.save(new Member("memberC", 30));

        //when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(3);
        assertThat(members).contains(memberA, memberB, memberC);
    }
}