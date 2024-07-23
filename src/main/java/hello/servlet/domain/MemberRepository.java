package hello.servlet.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  MemberRepository 는 스프링 없이 스프링으로 구현
 *  회원정보 등록 (save()) 시 id 에 해당하는 sequence 가 1 증가한다.
 *  회원정보 전체 조회(findAll()) 의 경우 Map 에 저장된 values 들을 ArrayList 형태로 저장한다.
 *  회원정보 초기화(전체삭제)(clear) 의 경우 현재 등록된 회원정보들을 초기화한다.
 * */

public class MemberRepository {

    // 변수 선언 - store, sequence
    private static Map<Long, Member> store = new HashMap<>();

    private static Long sequence = 0L;

    // 1. singleton
    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository() {
    }

    public static MemberRepository getInstance() {
        return instance;
    }

    // 2. 회원정보 등록
    public Member save(Member member) { // Test시 savedMember 조회를 위해 return type Member
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    // 3-1. 전체 회원 정보 조회
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    // 3-2. id로 회원 정보 조회
    public Member findById(Long id) {
        return store.get(id);
    }

    // 4. 회원 정보 초기화
    public void clearStore() {
        store.clear();
    }
}
