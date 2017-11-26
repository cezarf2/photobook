package photobook.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	public void saveImage(MultipartFile image, String path) throws Exception{
		if(!image.isEmpty()){
			Files.copy(image.getInputStream(), Paths.get(path));
		}
		else{
			throw new Exception("Image is empty");
		}
	}
	
	public void deleteImage(String path) throws IOException{
		Files.delete(Paths.get(path));
	}
}
