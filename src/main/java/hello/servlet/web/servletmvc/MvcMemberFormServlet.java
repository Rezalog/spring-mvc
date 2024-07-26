package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * MVC 패턴 - 적용
 * 서블릿을 컨트롤러로 사용하고, JSP를 뷰로 사용해서 MVC 패턴을 적용해보자.
 * Model은 HttpServletRequest 객체를 사용한다. request는 내부에 데이터 저장소를 가지고 있는데,
 * request.setAttribute() , request.getAttribute() 를 사용하면 데이터를 보관하고, 조회할 수 있다
 *
 * - /WEB-INF
 * 이 경로안에 JSP가 있으면 외부에서 직접 JSP를 호출할 수 없다.
 * 우리가 기대하는 것은 "항상 컨트롤러를 통해서 JSP(view)를 호출"하는 것이다.
 *
 * - redirect vs forward
 * redirect 는 실제 클라이언트(웹 브라우저)에 응답이 나갔다가, 클라이언트가 redirect 경로로 다시 요청한다.(2번 요청)
 * 따라서 클라이언트가 인지할 수 있고, URL 경로도 실제로 변경된다.
 * forward 는 서버 내부에서 일어나는 호출이기 때문에 클라이언트가 전혀 인지하지 못한다.(1번 요청)
 * */

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp"; // WEB-INF의 view 페이지들은 외부에서 호출이 불가능하도록하고, controller 로 접근
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath); // requestDispatcher 가 Controller
        requestDispatcher.forward(request, response); //s
    }
}
