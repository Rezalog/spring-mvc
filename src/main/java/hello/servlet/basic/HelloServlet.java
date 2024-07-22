package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        /*
        * HelloServlet.service
        request = org.apache.catalina.connector.RequestFacade@67477683
        response = org.apache.catalina.connector.ResponseFacade@193e925f
        *
        * => HttpServletRequest 및 response 인터페이스를
        * Tomcat, Jetty, Undertow 등의 WAS가 Servlet 표준 스펙을 구현체로 구현함.
        * (실제 콘솔에 찍힌 catalina는 tomcat의 라이브러리이다.)
        * */


        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello: " + username); // response.getWriter() 사용 시 responseBody 에 실어서보냄
        /*
        * 2024-07-22T14:09:50.241+09:00 DEBUG 27092 --- [servlet] [nio-8080-exec-1] o.a.coyote.http11.Http11InputBuffer      : Received [GET /hello?username=%22%EC%9D%B8%EC%83%9D%22 HTTP/1.1
         * */
    }

}
