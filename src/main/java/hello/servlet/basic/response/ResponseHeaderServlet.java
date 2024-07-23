package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK); // 200

        // [response-headers]
//        response.setHeader("Content-Type", "text/plan;charset=utf-8");
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 무효화
//        response.setHeader("Pragma", "no-cache");
//        response.setHeader("my-header", "hello"); // custom

        // [Header 편의 메서드] - content, cookie, redirect
        content(response);
        cookie(response);
//        response.getWriter().write("OK"); -- Content-Length: 2
        PrintWriter writer = response.getWriter();
        writer.println("OK"); // "OK\n" 으로 Content-Length: 4

        redirect(response);
    }



    private static void content(HttpServletResponse response) {

        /*
        * Content-Type: text/plan;charset=utf-8
        * Content-Length: 2
        * */
        response.setContentType("text/plan");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(2); // 생략시 길이에 맞게 자동 생성, 지정시 해당 값 반환
    }

    private static void cookie(HttpServletResponse response) {
        // Set-Cookie: myCookie=good; Max-Age=600
        // response setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private static void redirect(HttpServletResponse response) throws IOException {
        // Status Code : 302
        // Location: /basic/hello-form.html

//        response.setStatus(HttpServletResponse.SC_FOUND); // 302
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html"); // throws IOException 필요
    }
}
