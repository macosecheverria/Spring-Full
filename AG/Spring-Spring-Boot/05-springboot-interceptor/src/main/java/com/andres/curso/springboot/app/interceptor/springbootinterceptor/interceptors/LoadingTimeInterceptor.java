package com.andres.curso.springboot.app.interceptor.springbootinterceptor.interceptors;

// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("loadingTime")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod controller = ((HandlerMethod) handler);

        logger.info("LoadingTimeInterceptor: preHandler() entrando....." + controller.getMethod().getName());

        Long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);

        // Map<String, Object> json = new HashMap<>();
        // json.put("Error", "You do not have access to this page");
        // json.put("date", new Date());
        // ObjectMapper mapper = new ObjectMapper();
        // String jsonString = mapper.writeValueAsString(json);
        // response.setContentType("application/json");
        // response.setStatus(HttpStatus.UNAUTHORIZED.value());
        // response.getWriter().write(jsonString);
        // return false;

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        Long end = System.currentTimeMillis();
        Long start = (Long) request.getAttribute("start");

        Long result = end - start;

        logger.info("Tiempo trascurrido " + result + " millisegundo");

        logger.info(
                "LoadingTimeInterceptor: postHandler() saliendo...." + ((HandlerMethod) handler).getMethod().getName());
    }

}
