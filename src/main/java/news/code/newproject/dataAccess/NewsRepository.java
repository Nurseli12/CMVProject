package news.code.newproject.dataAccess;

import news.code.newproject.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {
 News getNewsById(int id);


}
