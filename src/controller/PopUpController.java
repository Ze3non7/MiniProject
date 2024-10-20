package controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PopUpController {

    @FXML
    private ImageView imageView;

    // Method to set the image in the ImageView
    public void setImage(Image image) {
        imageView.setImage(image);
    }
}