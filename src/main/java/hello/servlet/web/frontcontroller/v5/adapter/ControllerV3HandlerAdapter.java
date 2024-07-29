package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * boolean supports(Object handler)
 * handler는 컨트롤러를 말한다.
 * 어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드다.
 * ModelView handle(HttpServletRequest request, HttpServletResponse response,
 * Object handler)
 * 어댑터는 실제 컨트롤러를 호출하고, 그 결과로 ModelView를 반환해야 한다.
 *
 * 실제 컨트롤러가 ModelView를 반환하지 못하면, 어댑터가 ModelView를 직접 생성해서라도 반환해야
 * 한다.
 * 이전에는 프론트 컨트롤러가 실제 컨트롤러를 호출했지만 이제는 이 어댑터를 통해서 실제 컨트롤러가 호출
 * 된다
 * */

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean support(Object handler) {
        return handler instanceof ControllerV3;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, ServletException {
        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        ModelView mv = controller.process(paramMap);
        return mv;
    }
}
