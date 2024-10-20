package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardController {

    private String loggedInPrn;

    // Method to receive prn from LoginController
    public void setLoggedInPrn(String prn) {
        this.loggedInPrn = prn;
    }

    public void switchToRepo(ActionEvent event) throws IOException
    {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/repo.fxml"));
        Parent root = loader.load();

        // Pass the prn to the RepoController
        RepoController repoController = loader.getController();
        repoController.setLoggedInPrn(loggedInPrn);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Repository");
        stage.setScene(scene);
        stage.show();
    }
    public void careerConnect(ActionEvent event) throws IOException {
        @FXML
        private Stage stage;
        private Scene scene;
        private Parent root;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/career1.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
