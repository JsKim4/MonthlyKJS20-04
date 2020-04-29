package kr.kjs.admin.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kjs.admin.vo.ProjectVO;
import lombok.extern.java.Log;

@Log
public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("Pre HANDLER ===============================================");
		String contextPath = request.getContextPath();
		String URL = request.getRequestURI();
		HttpSession session = request.getSession();
		if (session.getAttribute(ProjectVO.PROJECT_ID + ProjectVO.ADMIN_LOGIN) != null) {
			if(URL.contains("admin/login")){
				response.sendRedirect(contextPath+"/admin/");
				return false;
			}
			return true;
		} else {
			if(URL.contains("admin/login")){
				return true;
			}
			response.sendRedirect(contextPath+"/admin/login");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		log.info("Post HANDLER ===============================================");
		super.postHandle(request, response, handler, modelAndView);
	}

}
