package com.andres.curso.springboot.calendar.interceptor.springboothorario.interceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("calendarInter")
public class CalendatInterceptor implements HandlerInterceptor {

  @Value("${config.calendar.open}")
  private Integer open;

  @Value("${config.calendar.close}")
  private Integer close;

  @Override
  public boolean preHandle(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull Object handler) throws Exception {

    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    System.out.println(hour);

    if (hour >= open & hour < close) {
      StringBuilder message = new StringBuilder("Estas en el horario de atencion al clientes")
          .append(", atendemos desde las ")
          .append(open)
          .append("hrs.")
          .append(" hasta las ")
          .append(close)
          .append("hrs.")
          .append(", Gracias por su visita");

      request.setAttribute("message", message.toString());
      return true;

    }

    Map<String, Object> data = new HashMap<>();

    StringBuilder message = new StringBuilder("Cerrado, El servicio esta fuera del horario al cliente")
        .append(" por favor visitenos desde las ")
        .append(open)
        .append("hrs.")
        .append(" hasta las ")
        .append(close)
        .append("hrs. Gracias");

    data.put("message", message.toString());
    data.put("date", new Date().toString());

    ObjectMapper mapper = new ObjectMapper();
    String jsonString = mapper.writeValueAsString(data);

    response.setContentType("application/json");
    response.getWriter().write(jsonString);
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    return false;
  }

  @Override
  public void postHandle(
      @NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
      @NonNull Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {

  }

}
