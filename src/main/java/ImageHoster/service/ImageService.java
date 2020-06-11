package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    //Call the getAllImages() method in the Repository and obtain a List of all the images in the database
    public List<Image> getAllImages() {
        return imageRepository.getAllImages();
    }


    //The method calls the createImage() method in the Repository and passes the image to be persisted in the database
    public void uploadImage(Image image) {
        imageRepository.uploadImage(image);
    }

    //The method calls the addComment() method in the Repository and passes the comment to be persisted in the database
    public void addComment(Comment comment) {
        imageRepository.addComment(comment);
    }

    //The method calls the getImageById() method in the Repository and passes the ID of the image to be fetched
    public Image getImageById(Integer imageId) {
        return imageRepository.getImageById(imageId);
    }

    // Duplicate method, disabled
    /*public Image getImage(Integer imageId) {
        return imageRepository.getImage(imageId);
    } */

    //The method calls the updateImage() method in the Repository and passes the Image to be updated in the database
    public void updateImage(Image updatedImage) {
        imageRepository.updateImage(updatedImage);
    }

    //The method calls the deleteImage() method in the Repository and passes the Image id of the image to be deleted in the database
    public void deleteImage(Integer imageId) {
        imageRepository.deleteImage(imageId);
    }

    // The method is used to authenticate user editting/delete image is owner
    public boolean compareImageSessionUser(User sessionUser, User imageUser){
        if(sessionUser.getId() == imageUser.getId()){
            return true;
        } else {
            return false;
        }
    }

}
