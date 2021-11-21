package news.code.newproject.api;


import news.code.newproject.entities.Advertisement;

import news.code.newproject.properties.FileStorageProperties;
import news.code.newproject.services.abstracts.AdvertisementService;
import news.code.newproject.services.concretes.FileStorageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/advertisement")
public class AdversitementsController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private FileStorageManager fileStorageManager;

    @PostMapping("/addAdvert")
    public Advertisement addNew(Advertisement advertisement,MultipartFile file){
        return  advertisementService.addNew(advertisement,file);
    }


    @GetMapping("getAllAdverts")
    public List<Advertisement> getAllAdverts() {
        return advertisementService.getall();
    }

    @GetMapping("/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
        // Load file as Resource
        Resource resource = fileStorageManager.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            //
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Advertisement> update(Advertisement advertisement,@PathVariable("id") int id){
       advertisementService.update(advertisement,id);
       return new ResponseEntity<>(advertisementService.getAdversitemenById(id), HttpStatus.OK);

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Advertisement> delete(@PathVariable("id") int id){
        advertisementService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getByAdvert/{id}")
    public Advertisement getPhotoById(int id) {
        return this.advertisementService.getPhotoById(id);
    }
    @GetMapping("/getByPhoto/{id}")
    Advertisement getAdversitemenById(int id){
        return this.advertisementService.getAdversitemenById(id);
    }


}









