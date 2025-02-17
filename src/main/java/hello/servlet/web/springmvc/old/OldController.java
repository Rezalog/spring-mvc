package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @Component : 이 컨트롤러는 /springmvc/old-controller 라는 이름의 스프링 빈으로 등록되었다.
 * 빈의 이름으로 URL을 매핑할 것이다.
 *
 * 스프링 부트가 자동 등록하는 핸들러 매핑과 핸들러 어댑터
 * (실제로는 더 많지만, 중요한 부분 위주로 설명하기 위해 일부 생략)
 *
 * - HandlerMapping(핸들러 매핑)
 * 핸들러 매핑에서 이 컨트롤러를 찾을 수 있어야 한다.
 * 예) 스프링 빈의 이름으로 핸들러를 찾을 수 있는 핸들러 매핑이 필요하다.
 *
 * 0 = RequestMappingHandlerMapping : 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용
 * 1 = BeanNameUrlHandlerMapping : 스프링 빈의 이름으로 핸들러를 찾는다 (O)
 *
 * - HandlerAdapter(핸들러 어댑터)
 * 핸들러 매핑을 통해서 찾은 핸들러를 실행할 수 있는 핸들러 어댑터가 필요하다.
 * 예) Controller 인터페이스를 실행할 수 있는 핸들러 어댑터를 찾고 실행해야 한다.
 *
 * 0 = RequestMappingHandlerAdapter : 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용
 * 1 = HttpRequestHandlerAdapter : HttpRequestHandler 처리
 * 2 = SimpleControllerHandlerAdapter : Controller 인터페이스(애노테이션X, 과거에 사용) 처리 (O)
 *
 * 스프링 부트가 자동 등록하는 뷰 리졸버
 * (실제로는 더 많지만, 중요한 부분 위주로 설명하기 위해 일부 생략) ```
 *
 * - ViewResolver(뷰 리졸버)
 * 1 = BeanNameViewResolver : 빈 이름으로 뷰를 찾아서 반환한다. (예: 엑셀 파일 생성 기능
 * 에 사용)
 * 2 = InternalResourceViewResolver : JSP를 처리할 수 있는 뷰를 반환한다.
 * Thymeleaf 뷰 템플릿을 사용하면 ThymeleafViewResolver 를 등록해야 한다. 최근에는 라이브러리만 추
 * 가하면 스프링 부트가 이런 작업도 모두 자동화해준다
 *
 * ===========================
 * 1. 핸들러 매핑으로 핸들러 조회
 * - HandlerMapping 을 순서대로 실행해서, 핸들러를 찾는다.
 * - 이 경우 빈 이름으로 핸들러를 찾아야 하기 때문에 이름 그대로 빈 이름으로 핸들러를 찾아주는
 *    BeanNameUrlHandlerMapping 가 실행에 성공하고 핸들러인 OldController 를 반환한다.
 * 2. 핸들러 어댑터 조회
 * - HandlerAdapter 의 supports() 를 순서대로 호출한다.
 * - SimpleControllerHandlerAdapter 가 Controller 인터페이스를 지원하므로 대상이 된다.
 * 3. 핸들러 어댑터 실행
 * - 디스패처 서블릿이 조회한 SimpleControllerHandlerAdapter 를 실행하면서 핸들러 정보도 함께 넘겨준다.
 * - SimpleControllerHandlerAdapter 는 핸들러인 OldController 를 내부에서 실행하고, 그 결과를 반환한다.
 *
 * [정리] - OldController 핸들러매핑, 어댑터
 * OldController 를 실행하면서 사용된 객체는 다음과 같다.
 * HandlerMapping = BeanNameUrlHandlerMapping
 * HandlerAdapter = SimpleControllerHandlerAdapter
 *
 * */

@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
/*
* 스프링 부트는 InternalResourceViewResolver 라는 뷰 리졸버를 자동으로 등록하는데, 이때
application.properties 에 등록한 spring.mvc.view.prefix , spring.mvc.view.suffix 설정 정
보를 사용해서 등록한다.
* */