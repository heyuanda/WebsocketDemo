package com.meifang.article;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsInformApplicationTests {

    @Test
    public void contextLoads(HttpServletRequest request) {
        System.out.println(request.getServletContext().getContextPath());
    }

}
