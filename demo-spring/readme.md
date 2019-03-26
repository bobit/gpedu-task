# Spring的核心原理

### SpringIOC
IOC即控制反转，是一种设计思想，将对象创建、维护、销毁的控制权交给spring容器。
### DI
DI即依赖注入，是IOC的一种重要实现，在系统运行过程中，动态的向某个对象注入它所依赖的对象。
### MVC
SpringMVC框架是以请求为驱动，围绕Servlet设计，将请求发给控制器，然后通过模型对象，分派器来展示请求结果视图。其中核心类是DispatcherServlet，它是一个Servlet，顶层是实现的Servlet接口。
#### SpringMVC运行原理

1. 客户端（浏览器）发送请求，直接请求到DispatcherServlet。
2.  DispatcherServlet根据请求信息调用HandlerMapping，解析请求对应的Handler。
3.  解析到对应的Handler后，开始由HandlerAdapter适配器处理。
4.  HandlerAdapter会根据Handler来调用真正的处理器开处理请求，并处理相应的业务逻辑。
5.  处理器处理完业务后，会返回一个ModelAndView对象，Model是返回的数据对象，View是个逻辑上的View。
6.  ViewResolver会根据逻辑View查找实际的View。
7.  DispaterServlet把返回的Model传给View。
8.  通过View返回给请求者（浏览器）。

### MiniSpringMVC
- [ ] [MiniSpringMVC](https://github.com/bobit/gpedu-task/tree/master/demo-spring/src/main/java/com/demo/spring/minispringmvc)

