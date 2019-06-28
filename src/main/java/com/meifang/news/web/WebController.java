package com.meifang.news.web;

import com.meifang.news.dao.domain.News;
import com.meifang.news.dao.domain.User;
import com.meifang.news.service.NewsService;
import com.meifang.news.service.UserService;
import com.meifang.news.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;

    @RequestMapping("/getUser")
    @ResponseBody
    public ResponseResult<User> getUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ResponseResult<>(0);
        }
        return new ResponseResult<User>(1, user);
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/user_login")
    public String userLogin(User user, HttpSession session, HttpServletRequest request) {
        User u=userService.login(user);
        if (u!=null) {
            session.setAttribute("user", u);
        }
        return "index";
    }

    @PostMapping("/user_reg")
    public String userReg(User user, HttpSession session) {
        Integer id=userService.reg(user);
        user.setId(id);
        session.setAttribute("user", user);
        return "index";
    }

    @GetMapping("/show_user")
    @ResponseBody
    public List<User> showNews() {
        return userService.getUsers();
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("news")
    public String news() {
        return "news";
    }
    @RequestMapping("news_list")
    @ResponseBody
    public List<News> newsList() {
        return newsService.getNews();
    }

    @RequestMapping("admin")
    public String admin() {
        return "admin";
    }
    @PostMapping("/add_new")
    @ResponseBody
    public ResponseResult<Void> addNew(News news){
        news.setCreateTime(new Date());
        if(newsService.insert(news)){
            return new ResponseResult<Void>(1);
        }else {
            return new ResponseResult<Void>(0);
        }
    }
}
