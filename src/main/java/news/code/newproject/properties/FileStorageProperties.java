package news.code.newproject.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;
    private String portal;

    public String getUploadDir() {
        return uploadDir;
    }
    public String getPort(){return portal;}

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
