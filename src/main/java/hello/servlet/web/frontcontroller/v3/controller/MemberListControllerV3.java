package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        ModelView mv = new ModelView("members"); // viewName set

        List<Member> members = memberRepository.findAll();
        mv.getModel().put("members", members);

        return mv;
    }
}
