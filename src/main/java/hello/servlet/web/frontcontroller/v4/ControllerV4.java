package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

/**
 * v3 에서 ModelView 객체가 model 및 viewName 까지 담았다면,
 * v4 는 FrontController 에서 paramMap 으로
 * 구현 Controller 가 처리해야하는 비즈니스 로직에 필요한 paramMap 을 get 하여 처리하고,
 * 비어있는 값의 Map 인 model 을 함께 전달하여 JSP 에 전달하고자하는 model 을 담아 set 한다.
 * 그리고 기존 MyView 객체 타입으로 반환하지 않고 viewName 의 논리이름을 String 으로 반환한다.
 * */

public interface ControllerV4 {

    String process(Map<String, String> paramMap, Map<String, Object> model);
}
