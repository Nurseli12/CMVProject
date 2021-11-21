package news.code.newproject.services.abstracts;


import news.code.newproject.entities.Advertisement;
import news.code.newproject.entities.News;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface AdvertisementService {

    void delete(int id);
    void update(Advertisement advertisement,int id);
    List<Advertisement> getall();
    Advertisement addNew(Advertisement advertisement,MultipartFile file);
    Advertisement getAdversitemenById(int id);
    Advertisement getPhotoById(int id);




}
