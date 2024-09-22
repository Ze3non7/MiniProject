package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class SignupController {

    public TextField txtName;
    public PasswordField txtPassword;
    public PasswordField txtConfirmPassword;
    public TextField txtEmail;
    public TextField txtPrn;
    public Label lbpassword1;
    public Label lblAutoID;


    //Changing Scene in Register Page (i.e. Redirecting User to Login Page)
    private Stage stage;
    private Scene scene;
    private Parent root;



    public void switchToLogin(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/login.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    //To give error when password not same
    public void initialize() throws SQLException
    {
        lbpassword1.setVisible(false);
        AutoID();
    }

    public void AutoID() throws SQLException
    {

        Connection connection = DBConnection.getInstance().getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select user_id from users order by user_id desc limit 1");
        boolean a = resultSet.next();

        if (a)
        {
            String uid = resultSet.getString(1);
            uid = uid.substring(1,4);
            int intID = Integer.parseInt(uid);

            intID++;

            if (intID< 10)
            {
                lblAutoID.setText("S00"+intID);
            }

            else if (intID< 100)
            {
                lblAutoID.setText("S0"+intID);
            }
            else
            {
                lblAutoID.setText("S"+intID);
            }
        }

        else
        {
            lblAutoID.setText("S001");
        }
    }

    public void btnSignup(ActionEvent event) throws IOException, SQLException {

        register();

        DBConnection object = DBConnection.getInstance();
        System.out.println(object);

        DBConnection object2 = DBConnection.getInstance();
        System.out.println(object2);


    }

    public void txtConfirmPasswordOnAction(ActionEvent event) throws SQLException {
        register();
    }
    //to confirm passwords are same
    public void register() throws SQLException {
        String newPassword = txtPassword.getText();
        String ConfirmPassword = txtConfirmPassword.getText();

        if(newPassword.equals(ConfirmPassword))
        {
            setBorderColor("green");
            txtPassword.requestFocus();
            lbpassword1.setVisible(false);

            try {
                Connection connection = DBConnection.getInstance().getConnection();

                String id = lblAutoID.getText();
                String name = txtName.getText();
                String email = txtEmail.getText();
                String prn = txtPrn.getText();
                String cpass = txtConfirmPassword.getText();

                PreparedStatement preparedStatement = connection.prepareStatement("insert into users(user_id, name, prn, email_id, password) values(?,?,?,?,?)");

                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, prn);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, cpass);

                int i = preparedStatement.executeUpdate();

                if (i != 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Success");
                    alert.setTitle("Success");
                    alert.showAndWait();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            setBorderColor("red");
            txtPassword.requestFocus();
            lbpassword1.setVisible(true);
        }







    }

    public void setBorderColor(String color)
    {
        txtPassword.setStyle("-fx-border-color: " + color);
        txtConfirmPassword.setStyle("-fx-border-color: " + color);
    }
}
