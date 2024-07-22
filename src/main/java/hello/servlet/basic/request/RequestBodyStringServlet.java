package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream(); // request body 내용을 byteStream으로 받아옴
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// byteStream을 특정 인코딩에 맞추어 String 으로 변환
        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("OK");
    }
}
/*
* messageBody = hello!
 * */