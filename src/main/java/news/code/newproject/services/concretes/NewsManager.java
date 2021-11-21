package news.code.newproject.services.concretes;

import antlr.Utils;
import news.code.newproject.dataAccess.NewsRepository;
import news.code.newproject.entities.News;

import news.code.newproject.services.abstracts.NewsService;
import org.hibernate.procedure.internal.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsManager implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public News add(News news) {
        return this.newsRepository.save(news);
    }

    @Override
    public void delete(int id) {
        Optional<News> savedNews = newsRepository.findById(id);
        if(savedNews.isPresent()){
            News deleteNews =savedNews.get();
            newsRepository.delete(deleteNews);
        }
    }


    @Override
    public void update(News news,int id) {
        News savedNews = newsRepository.findById(id).get();
        savedNews.setId(news.getId());
        savedNews.setNews_link(news.getNews_link());
        savedNews.setContent(news.getContent());
        savedNews.setSubject(news.getSubject());
        savedNews.setValidity_date(news.getValidity_date());
         this.newsRepository.save(savedNews);

    }

    @Override
    public News getNewsById(int id) {
        return newsRepository.findById(id).get();
    }

    @Override
    public List<News> getall() {
        return newsRepository.findAll();
    }



}
