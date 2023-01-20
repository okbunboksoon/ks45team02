package ks45team02.ire.interceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final UserMapper userMapper;

    public LoginInterceptor(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        HttpSession session=request.getSession();
        LoginInfo loginInfo= (LoginInfo) session.getAttribute("S_USER_INFO");
        Cookie cookie= WebUtils.getCookie(request,"loginKeepId");
        if(cookie !=null && loginInfo==null){
            String loginKeepId=cookie.getValue();
            User user = userMapper.getUserInfoById(loginKeepId);
            if(user != null){
                loginInfo=new LoginInfo(loginKeepId,
                        user.getUserName());
                session.setAttribute("S_USER_INFO",loginInfo);
            }
        }
        if(loginInfo==null){
            response.sendRedirect("/");
            return false;
        }else {
            String requestURI=request.getRequestURI();
            String admin=loginInfo.getLoginName();
            if (!admin.equals("관리자")){
                if(     requestURI.indexOf("/admin")>-1       ){
                    msgRedirect(response);
                    return false;
                }
            }
        }
        return true;
    }
    public static void msgRedirect(HttpServletResponse response){
        try {
            response.setContentType("text/html;charset=utf-8;");
            PrintWriter writer= response.getWriter();
            writer.write("<script>alert('비정상적인 접근');" +
                    "location.href='/';</script>");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
