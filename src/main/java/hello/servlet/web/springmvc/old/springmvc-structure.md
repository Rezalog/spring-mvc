# 5. 스프링 MVC - 구조 이해

### 직접 만든 MVC FW
![img.png](img/img.png)

### Spring MVC FW
![img_1.png](img/img_1.png)


## 직접 만든 프레임워크 스프링 MVC 비교
- FrontController -> DispatcherServlet
- handlerMappingMap -> HandlerMapping
- MyHandlerAdapter -> HandlerAdapter
- ModelView -> ModelAndView
- viewResolver -> ViewResolver
- MyView -> View


---

## DispatcherServlet 구조 살펴보기
![img_2.png](img/img_2.png)![img_3.png](img/img_3.png)![img_4.png](img/img_4.png)

---

## Spring MVC 동작 순서

![img_5.png](img/img_5.png)

---

## 주요 인터페이스, 결론
![img_6.png](img/img_6.png)
