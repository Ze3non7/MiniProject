package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class Career3Controller {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Input fields for marks
    @FXML
    private TextField tcsField;
    @FXML
    private TextField seField;
    @FXML
    private TextField cnField;
    @FXML
    private TextField dwmField;
    @FXML
    private TextField pgmField;
    @FXML
    private TextField spccField;
    @FXML
    private TextField cssField;
    @FXML
    private TextField mcField;
    @FXML
    private TextField aiField;
    @FXML
    private TextField iotField;

    public void next3(ActionEvent event) throws IOException {
        // Retrieve marks from TextFields
        int tcsMarks = getMarks(tcsField);
        int seMarks = getMarks(seField);
        int cnMarks = getMarks(cnField);
        int dwmMarks = getMarks(dwmField);
        int pgmMarks = getMarks(pgmField);
        int spccMarks = getMarks(spccField);
        int cssMarks = getMarks(cssField);
        int mcMarks = getMarks(mcField);
        int aiMarks = getMarks(aiField);
        int iotMarks = getMarks(iotField);

        // Find the highest marks and corresponding subject name
        String highestSubject = "No subjects entered";
        // Initialize highestMarks to 0
        int highestMarks = 0;

// Compare each subject's marks to find the highest
        highestMarks = Math.max(highestMarks, pgmMarks);
        highestMarks = Math.max(highestMarks, tcsMarks);
        highestMarks = Math.max(highestMarks, seMarks);
        highestMarks = Math.max(highestMarks, cnMarks);
        highestMarks = Math.max(highestMarks, dwmMarks);
        highestMarks = Math.max(highestMarks, spccMarks);
        highestMarks = Math.max(highestMarks, cssMarks);
        highestMarks = Math.max(highestMarks, mcMarks);
        highestMarks = Math.max(highestMarks, aiMarks);
        highestMarks = Math.max(highestMarks, iotMarks);
        if (highestMarks == pgmMarks) {
            highestSubject = "Data Science (PGM / IP / ADBMS)";
        } else if (highestMarks == spccMarks) {
            highestSubject = "Systems Programming (SPCC)";
        } else if (highestMarks == cssMarks) {
            highestSubject = "Cybersecurity (CSS)";
        } else if (highestMarks == iotMarks) {
            highestSubject = "Data Analytics (IOT / DSIP / QA)";
        } else if (highestMarks == tcsMarks) {
            highestSubject = "TCS";
        } else if (highestMarks == seMarks) {
            highestSubject = "Software Engineering";
        } else if (highestMarks == cnMarks) {
            highestSubject = "Computer Network";
        } else if (highestMarks == dwmMarks) {
            highestSubject = "Data Warehousing & Mining";
        } else if (highestMarks == mcMarks) {
            highestSubject = "Mobile Computing";
        } else if (highestMarks == aiMarks) {
            highestSubject = "Artificial Intelligence";
        }
        // Pass the highest subject and marks to FinalCareerController
        FinalCareerController.setHighestCareer3(highestSubject, highestMarks);

        // Output the highest subject and marks
        System.out.println("Highest Marks: " + highestMarks + " in " + highestSubject);

        // Load the next scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/career4.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private int getMarks(TextField textField) {
        String text = textField.getText();
        return text.isEmpty() ? 0 : Integer.parseInt(text);
    }
}
