package news.code.newproject.services.abstracts;

import news.code.newproject.entities.News;

import java.util.List;

public interface NewsService {
     News add(News news);
     void delete(int id);
     void update(News news,int id);
     News getNewsById(int id);
     List<News> getall();
}
