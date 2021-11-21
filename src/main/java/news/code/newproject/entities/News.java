package news.code.newproject.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="news")
public class News extends Activity{

    @Column(name="news_link")
    private String news_link;
}


