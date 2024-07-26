package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) { // 비즈니스 로직 처리 후 해당 viewName(논리)을 반환
        return new ModelView("new-form"); // viewName 을 param 으로 객체 인스턴스 생성, 해당 인스턴스 바로 반환(model 조작 필요없으므로)
    }
}
