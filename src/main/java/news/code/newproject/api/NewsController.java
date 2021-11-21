package news.code.newproject.api;

import news.code.newproject.entities.News;
import news.code.newproject.services.abstracts.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/getAll")
    public List<News> getAll(){
        return newsService.getall();
    }

    @GetMapping("/getByNews/{id}")
    public News getNewsById(@PathVariable("id") int id){
       return newsService.getNewsById(id);

    }

    @PostMapping("/add")
    public ResponseEntity<News> add(@RequestBody News news){
        return ResponseEntity.ok(this.newsService.add(news));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<News> delete(@PathVariable("id") int id){
        newsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<News>  update(@RequestBody News news,@PathVariable("id")  int id){
        newsService.update(news,id);
        return new ResponseEntity<>(newsService.getNewsById(id), HttpStatus.OK);
    }
}

