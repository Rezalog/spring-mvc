package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * HttpServletRequest, HttpServletResponse
 * request 객체가 servlet 역할이 불필요한 상황, 없어도 model 역할을 수행하는 객체로 대체할 수 있음
 * HttpServletRequest, HttpServletResponse 불필요, view 이름(WEB-INF...) 중복
 * */

public class MemberListControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
