package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request) {
        Member member = new Member(request.getParameter("username"), Integer.parseInt(request.getParameter("age")));
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);

        return mv;
    }

    @RequestMapping
    public ModelAndView members() {

        ModelAndView mv = new ModelAndView("members");
        List<Member> members = memberRepository.findAll();
        mv.addObject("members", members);

        return mv;
    }
}
