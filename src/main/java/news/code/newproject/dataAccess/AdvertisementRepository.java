package news.code.newproject.dataAccess;

import news.code.newproject.entities.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement,Integer> {
/*Optional<ImageModel> findByName(String name);*/

    Advertisement getPhotoById(int id);
    Advertisement getAdvertisementById(int id);
}
