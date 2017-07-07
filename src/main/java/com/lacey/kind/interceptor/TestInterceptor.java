package com.lacey.kind.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/25.
 */
public class TestInterceptor implements HandlerInterceptor {
    /**
     * 返回值：表示我们是否需要将当前的请求拦截下来
     * 如果返回false,请求将本终止
     * 如果返回TRUE，请求会被继续运行
     * Object object表示被拦截的请求的目标对象
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
      httpServletRequest.setCharacterEncoding("utf-8");
      if(httpServletRequest.getSession().getAttribute("user")==null)
      {
          httpServletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest,httpServletResponse);
          return false;
      }

       return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
