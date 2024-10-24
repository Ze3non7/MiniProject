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

public class Career4Controller {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Input fields for marks
    @FXML
    private TextField mlField; // Machine Learning
    @FXML
    private TextField bdaField; // Big Data Analysis
    @FXML
    private TextField aiField; // Artificial Intelligence (MV / QC / NLP)
    @FXML
    private TextField etField; // Emerging Technologies (ARVR / Block Chain / IR)
    @FXML
    private TextField seField; // Systems Engineering (PLM / OR / DE)
    @FXML
    private TextField rmField; // Risk Management (RE / DOE / DMMM)
    @FXML
    private TextField itmField; // Information Technology Management (MIS / CSL / EAM)
    @FXML
    private TextField hmiField; //Human Machine Interaction
    @FXML
    private TextField dcField; // Distributed Computing (HPC / AWN)
    @FXML
    private TextField dtField; // Digital Transformation (NLP / DBM)
    @FXML
    private TextField baField; // Business Administration (PM / FM / HRM)
    @FXML
    private TextField sbpField; // Sustainable Business Practices (EDM / PECSR / EM)
    @FXML
    private TextField imField; // Innovation Management (RM / IPR & Patenting)
    @FXML
    private TextField disField; //Distributive Computing original

    public void finish(ActionEvent event) throws IOException {
        // Retrieve marks from TextFields
        int mlMarks = getMarks(mlField);
        int bdaMarks = getMarks(bdaField);
        int aiMarks = getMarks(aiField);
        int etMarks = getMarks(etField);
        int seMarks = getMarks(seField);
        int rmMarks = getMarks(rmField);
        int itmMarks = getMarks(itmField);
        int hmiMarks = getMarks(hmiField);
        int dcMarks = getMarks(dcField);
        int dtMarks = getMarks(dtField);
        int baMarks = getMarks(baField);
        int sbpMarks = getMarks(sbpField);
        int imMarks = getMarks(imField);
        int disMarks = getMarks(disField);

        // Find the highest marks and corresponding subject name
        String highestSubject = "No subjects entered";
        int highestMarks = 0;

        // Compare each subject's marks to find the highest
        highestMarks = Math.max(highestMarks, mlMarks);
        highestMarks = Math.max(highestMarks, bdaMarks);
        highestMarks = Math.max(highestMarks, aiMarks);
        highestMarks = Math.max(highestMarks, etMarks);
        highestMarks = Math.max(highestMarks, seMarks);
        highestMarks = Math.max(highestMarks, rmMarks);
        highestMarks = Math.max(highestMarks, itmMarks);
        highestMarks = Math.max(highestMarks, hmiMarks);
        highestMarks = Math.max(highestMarks, dcMarks);
        highestMarks = Math.max(highestMarks, dtMarks);
        highestMarks = Math.max(highestMarks, baMarks);
        highestMarks = Math.max(highestMarks, sbpMarks);
        highestMarks = Math.max(highestMarks, imMarks);
        highestMarks = Math.max(highestMarks, disMarks);

        if (highestMarks == mlMarks) {
            highestSubject = "Machine Learning";
        } else if (highestMarks == bdaMarks) {
            highestSubject = "Big Data Analysis";
        } else if (highestMarks == aiMarks) {
            highestSubject = "Artificial Intelligence (MV / QC / NLP)";
        } else if (highestMarks == etMarks) {
            highestSubject = "Emerging Technologies (ARVR / Block Chain / IR)";
        } else if (highestMarks == seMarks) {
            highestSubject = "Systems Engineering (PLM / OR / DE)";
        } else if (highestMarks == rmMarks) {
            highestSubject = "Risk Management (RE / DOE / DMMM)";
        } else if (highestMarks == itmMarks) {
            highestSubject = "Information Technology Management (MIS / CSL / EAM)";
        } else if (highestMarks == hmiMarks) {
            highestSubject = "Human Machine Interaction";
        } else if (highestMarks == dcMarks) {
            highestSubject = "Distributed Computing (HPC / AWN)";
        } else if (highestMarks == dtMarks) {
            highestSubject = "Digital Transformation (NLP / DBM)";
        } else if (highestMarks == baMarks) {
            highestSubject = "Business Administration (PM / FM / HRM)";
        } else if (highestMarks == sbpMarks) {
            highestSubject = "Sustainable Business Practices (EDM / PECSR / EM)";
        } else if (highestMarks == imMarks) {
            highestSubject = "Innovation Management (RM / IPR & Patenting)";
        } else if (highestMarks == disMarks) {
            highestSubject = "Distributive Computing";
        }
        // Pass the highest subject and marks to FinalCareerController
        FinalCareerController.setHighestCareer4(highestSubject, highestMarks);
        // Output the highest subject and marks
        System.out.println("Highest Marks: " + highestMarks + " in " + highestSubject);

        // Load the final scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/finalCareer.fxml")));
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
