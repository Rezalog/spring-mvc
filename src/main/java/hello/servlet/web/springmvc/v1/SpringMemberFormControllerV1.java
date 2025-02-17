package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller :
 * 스프링이 자동으로 스프링 빈으로 등록한다. (내부에 @Component 애노테이션이 있어서 컴포넌트 스캔의
 * 대상이 됨)
 * 스프링 MVC에서 애노테이션 기반 컨트롤러로 인식한다.
 * @RequestMapping : 요청 정보를 매핑한다. 해당 URL이 호출되면 이 메서드가 호출된다. 애노테이션을 기반
 * 으로 동작하기 때문에, 메서드의 이름은 임의로 지으면 된다.
 * ModelAndView : 모델과 뷰 정보를 담아서 반환하면 된다
 *
 * RequestMappingHandlerMapping 은 스프링 빈 중에서
 * @RequestMapping 또는 @Controller 가 "클래스 레벨"에 붙어 있는 경우에 매핑 정보로 인식한다.
 * 따라서 다음 코드도 동일하게 동작한다.
 * ```java
 * @Component //컴포넌트 스캔을 통해 스프링 빈으로 등록
 * @RequestMapping
 * public class SpringMemberFormControllerV1 {
 *
 *      @RequestMapping("/springmvc/v1/members/new-form")
 *      public ModelAndView process() {
 *          return new ModelAndView("new-form");
 *      }
 * }
 * ```
 * 물론 컴포넌스 스캔 없이 다음과 같이 스프링 빈으로 직접 등록해도 동작한다.
 * ```java
 * @RequestMapping
 * public class SpringMemberFormControllerV1 {
 *
 *      @RequestMapping("/springmvc/v1/members/new-form")
 *      public ModelAndView process() {
 *          return new ModelAndView("new-form");
 *      }
 * }
 * ServletApplication
 * ```java
 * //스프링 빈 직접 등록
 * @Bean
 * SpringMemberFormControllerV1 springMemberFormControllerV1() {
 * return new SpringMemberFormControllerV1();
 * }
 *
 * ※ 스프링 부트 3.0(스프링 프레임워크 6.0)부터는 클래스 레벨에 @RequestMapping 이 있어도 스프링 컨트롤러로 인
 * 식하지 않는다.
 * 오직 @Controller 가 있어야 스프링 컨트롤러로 인식한다.
 * 참고로 @RestController 는 해당 애노테이션 내부에 @Controller 를 포함하고 있으므로 인식 된다.
 * 따라서 @Controller 가 없는 위의 두 코드는 스프링 컨트롤러로 인식되지 않는다.
 * ( RequestMappingHandlerMapping 에서 @RequestMapping 는 이제 인식하지 않고, Controller 만 인식한다.
 *
 * */
@Controller // spring 3.0 이상은 무조건 @Controller, @Component, @RequestMapping 은 인식 X
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        System.out.println("SpringMemberFormControllerV1.process");
        return new ModelAndView("new-form");
    }
}
