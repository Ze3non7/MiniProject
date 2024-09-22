package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class SignupController {

    public TextField txtName;
    public PasswordField txtPassword;
    public PasswordField txtConfirmPassword;
    public TextField txtEmail;
    public TextField txtPrn;
    public Label lbpassword1;


    //Changing Scene in Register Page (i.e. Redirecting User to Login Page)
    private Stage stage;
    private Scene scene;
    private Parent root;



    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/login.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    //To give error when password not same
    public void initialize() {
        lbpassword1.setVisible(false);
    }

    public void btnSignup(ActionEvent event) throws IOException {

        register();

        DBConnection object = DBConnection.getInstance();
        System.out.println(object);

        DBConnection object2 = DBConnection.getInstance();
        System.out.println(object2);


    }

    public void txtConfirmPasswordOnAction(ActionEvent event) {
        register();
    }
    //to confirm passwords are same
    public void register(){
        String newPassword = txtPassword.getText();
        String ConfirmPassword = txtConfirmPassword.getText();

        if(newPassword.equals(ConfirmPassword))
        {
            setBorderColor("green");
            txtPassword.requestFocus();
            lbpassword1.setVisible(false);
        }
        else {
            setBorderColor("red");
            txtPassword.requestFocus();
            lbpassword1.setVisible(true);
        }
    }

    public void setBorderColor(String color){
        txtPassword.setStyle("-fx-border-color: " + color);
        txtConfirmPassword.setStyle("-fx-border-color: " + color);
    }
}
