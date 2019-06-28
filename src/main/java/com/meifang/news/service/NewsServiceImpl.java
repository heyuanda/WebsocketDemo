package com.meifang.news.service;

import com.meifang.news.WebSocket;
import com.meifang.news.dao.domain.News;
import com.meifang.news.dao.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public boolean insert(News news) {
        int row=newsMapper.insert(news);
        if(row==1){
            String uid=news.getAcceptUser().toString();
            String sender=news.getSender();
            String msg="收到来自"+sender+"一条信息";
            WebSocket.sendToUser(uid,msg);
            return true;
        }
        return false;
    }

    @Override
    public List<News> getNews() {
        return newsMapper.selectAll();
    }


}
