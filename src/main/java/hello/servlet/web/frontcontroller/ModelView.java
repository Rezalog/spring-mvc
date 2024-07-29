package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {

    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    // 생성자(view 만)
    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    // getter, setter
    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() { // mv.getModel.set~ 형태로 사용
        return model;
    }

    public void setModel(Map<String, Object> model) { // 안쓰임, Map 자체는 setXX 하면 기존 저장내역이 초기화됨
        this.model = model;
    }
}
