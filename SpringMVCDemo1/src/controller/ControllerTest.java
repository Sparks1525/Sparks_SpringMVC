package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kerwin on 2017/9/12.
 */
@Controller
public class ControllerTest {

    @RequestMapping("/test1")
    public ModelAndView method1(){
        System.out.println("Test1");
        ModelAndView mv = new ModelAndView("index.jsp");
        mv.addObject("test1","Test1");
        return mv;
    }

    @RequestMapping("/test2")
    public ModelAndView method2(HttpServletRequest request){
        System.out.println("Test2");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = new User(userName,password);
        System.out.println("User:"+user.toString());
        ModelAndView mv = new ModelAndView("input.jsp");
        return mv;
    }

    @RequestMapping("/test3")
    public ModelAndView method3(String userName, String password){
        System.out.println("Test3");
        User user = new User(userName,password);
        System.out.println("User:"+user.toString());
        ModelAndView mv = new ModelAndView("input.jsp");
        return mv;
    }

    @RequestMapping("/test4.jsp")
    @ModelAttribute("test4")
    public User method4(){
        return new User("key","value");
    }

    @RequestMapping("/test5")
    public String method5(Model model){
        model.addAttribute("test5","test5");
        return "test5.jsp";
    }

    @RequestMapping("/test6")
    public String method6(Model model){
        model.addAttribute("test6","test6");
        return "forward:test6.jsp";
    }

    @RequestMapping("/test7")
    public String method7(Model model){
        model.addAttribute("test7","test7");
        return "redirect:test7.jsp";
    }








}
