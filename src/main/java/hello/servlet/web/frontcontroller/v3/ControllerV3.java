package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;
/**
 * FrontControllerV3 에서 해당 인터페이스를 이용해 다형성을 이용한 구현 controller 를 호출함
 * 이때, FrontControllerV3 에서 request 객체로 받은 model 을 paramMap 으로 해당 구현 Controller 에게 넘겨줌.
 * 따라서 각 Controller 구현체들은 HttpServlet에 종속적이지 않음.
 *
 * 이 컨트롤러는 서블릿 기술을 전혀 사용하지 않는다. 따라서 구현이 매우 단순해지고, 테스트 코드 작성시 테스트 하기
 * 쉽다.
 * HttpServletRequest가 제공하는 파라미터는 프론트 컨트롤러가 paramMap에 담아서 호출해주면 된다.
 * 응답 결과로 뷰 이름과 뷰에 전달할 Model 데이터를 포함하는 ModelView 객체를 반환하면 된다.
 *
 * paramMap : {"username":"kim", "age":"10", ...}
 *
 * */
public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
