package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;



public class RepoController {
    @FXML
    Label prnid;

    public void switchToDashboard(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/dashboard.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    private String loggedInPrn;

    // Method to set the logged-in prn
    public void setLoggedInPrn(String prn) {
        this.loggedInPrn = prn;

        prnid.setText("Logged-in user's PRN: " + prn);
    }

    // Method to upload a document
    public void uploadDocument(ActionEvent event, String documentColumn) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Document");
        File file = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

        if (file != null) {
            try (FileInputStream fis = new FileInputStream(file)) {
                Connection connection = DBConnection.getInstance().getConnection();
                String query = "UPDATE users SET " + documentColumn + " = ? WHERE prn = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setBinaryStream(1, fis, (int) file.length());
                preparedStatement.setString(2, loggedInPrn);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println(documentColumn + " uploaded successfully.");
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void chooseAadhar(ActionEvent event) {
        uploadDocument(event, "aadhar_card");
    }

    public void choosePAN(ActionEvent event) {
        uploadDocument(event, "pancard");
    }

    public void chooseBirthCertificate(ActionEvent event) {
        uploadDocument(event, "birth");
    }

    public void chooseMarksheet12(ActionEvent event) {
        uploadDocument(event, "marksheet12");
    }

    public void chooseMarksheet10(ActionEvent event) {
        uploadDocument(event, "marksheet10");
    }

    public void chooseBonafide(ActionEvent event) {
        uploadDocument(event, "bonafide");
    }





}
