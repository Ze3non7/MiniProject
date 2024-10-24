package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {
    @FXML
    TextField tf_email;
    @FXML
    PasswordField tf_password;
    @FXML
    AnchorPane pane;

    //Changing Scene in Login Page (i.e. Redirecting User to Register Page)
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSignup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/signup.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Register");
        stage.show();


    }

    public void button_login(ActionEvent event) throws IOException
    {
        try{
            String email = tf_email.getText();
            String password = tf_password.getText();

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email_id=? and password=?");

            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){

                String prn = resultSet.getString("prn");

                // Load the dashboard.fxml and pass the prn to the DashboardController
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
                Parent root = loader.load();

                // Get the controller for the dashboard
                DashboardController dashboardController = loader.getController();
                dashboardController.setLoggedInPrn(prn);

                Scene scene = new Scene(root);

                Stage primaryStage = (Stage) pane.getScene().getWindow();
                primaryStage.setTitle("Dashboard");
                primaryStage.setScene(scene);
                primaryStage.show();
                primaryStage.centerOnScreen();
            }

            else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Username or Password does not match");
                alert.showAndWait();

                tf_email.clear();
                tf_password.clear();
                tf_email.requestFocus();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
