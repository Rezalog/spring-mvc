package hello.servlet.web.servlet;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberRepository memberRepository = MemberRepository.getInstance();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        String username = request.getParameter("username"); // x-www-form-urlencoded 의 request body, querystring 의 param 모두 조회 가능
        int age = Integer.parseInt(request.getParameter("age"));
        Member savedMember = memberRepository.save(new Member(username, age));

        PrintWriter w = response.getWriter();
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                " <li>id="+savedMember.getId()+"</li>\n" +
                " <li>username="+savedMember.getUsername()+"</li>\n" +
                " <li>age="+savedMember.getAge()+"</li>\n" +
                "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" +
                "</body>\n" +
                "</html>");

    }
}
