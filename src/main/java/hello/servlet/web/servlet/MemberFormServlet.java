package hello.servlet.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *  httpServletResponse 객체에 직접 html 을 자바코드로 반환한다.(hello-form.html 과 동일)
 *  동적으로 데이터를 매핑하는 등의 처리가 가능하지만,
 *  매우 비효율적이고 부정확해서 이를 계기로 "템플릿 엔진"이 등장하게 된다.
 *
 *  템플릿 엔진은 자바코드로 html을 만들어 넣는 것이 아닌,
 *  html(템플릿)에다가 자바코드를 중간중간에 넣는 방식이다.(ex: JSP, Thymeleaf, Freemarker, Velocity)
* */

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();

        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                " <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/servlet/members/save\" method=\"post\">\n" +
                " username: <input type=\"text\" name=\"username\" />\n" +
                " age: <input type=\"text\" name=\"age\" />\n" +
                " <button type=\"submit\">전송</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n");

    }
}
