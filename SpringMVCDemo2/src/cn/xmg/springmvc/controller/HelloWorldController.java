package cn.xmg.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("HelloWorldController");
		String user = request.getParameter("user");
		//request.setAttribute("key", "今天天气转凉");
		//request.getRequestDispatcher("hello.jsp").forward(request, response);
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", "今天天气转凉");
		mv.setViewName("hello");
		System.out.println(user);
		return mv;
	}

}
