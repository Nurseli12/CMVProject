package news.code.newproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name= "subject")
    private String subject;

    @Column(name="content")
    private String content;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name="validity_date")
    private Date validity_date;

}
