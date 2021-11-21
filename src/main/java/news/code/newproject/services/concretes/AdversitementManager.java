package news.code.newproject.services.concretes;

import news.code.newproject.dataAccess.AdvertisementRepository;
import news.code.newproject.entities.Advertisement;
import news.code.newproject.entities.News;

import news.code.newproject.services.abstracts.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class AdversitementManager implements AdvertisementService {

    private AdvertisementRepository advertisementRepository;
    private FileStorageManager fileStorageManager;
    @Autowired
    public AdversitementManager(AdvertisementRepository advertisementRepository,FileStorageManager fileStorageManager) {
        this.advertisementRepository = advertisementRepository;
        this.fileStorageManager = fileStorageManager;
    }


    @Override
    public void delete(int id) {
        Optional<Advertisement>  savedAdvertisement= advertisementRepository.findById(id);
        if (savedAdvertisement.isPresent()){
            Advertisement deleted = savedAdvertisement.get();
            advertisementRepository.delete(deleted);
        }
    }

    @Override
    public void update(Advertisement advertisement, int id) {
        Advertisement savedadvertisement = advertisementRepository.findById(id).get();
        savedadvertisement.setId(advertisement.getId());
        savedadvertisement.setSubject(advertisement.getSubject());
        savedadvertisement.setContent(advertisement.getContent());
        savedadvertisement.setValidity_date(advertisement.getValidity_date());
        this.advertisementRepository.save(savedadvertisement);

    }

    @Override
    public List<Advertisement> getall() {
        return advertisementRepository.findAll();
    }

    @Override
    public Advertisement addNew(Advertisement advertisement, MultipartFile file) {
        String fileName = fileStorageManager.storeFile(file);
        advertisement.setPhoto(fileName);
        advertisement.setContent(advertisement.getContent());
        advertisement.setSubject(advertisement.getSubject());
        advertisement.setValidity_date(advertisement.getValidity_date());
        return this.advertisementRepository.save(advertisement);
    }

    @Override
    public Advertisement getAdversitemenById(int id) {
        return advertisementRepository.findById(id).get();
    }

    @Override
    public Advertisement getPhotoById(int id) {
        return advertisementRepository.findById(id).get();
    }
}
