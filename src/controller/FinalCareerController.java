package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FinalCareerController {

    @FXML
    private Label recommendationLabel;

    private static String highestSubjectCareer1 = "";
    private static String highestSubjectCareer2 = "";
    private static String highestSubjectCareer3 = "";
    private static String highestSubjectCareer4 = "";

    private static int highestMarksCareer1 = 0;
    private static int highestMarksCareer2 = 0;
    private static int highestMarksCareer3 = 0;
    private static int highestMarksCareer4 = 0;

    public static void setHighestCareer1(String subject, int marks) {
        highestSubjectCareer1 = subject;
        highestMarksCareer1 = marks;
    }

    public static void setHighestCareer2(String subject, int marks) {
        highestSubjectCareer2 = subject;
        highestMarksCareer2 = marks;
    }

    public static void setHighestCareer3(String subject, int marks) {
        highestSubjectCareer3 = subject;
        highestMarksCareer3 = marks;
    }

    public static void setHighestCareer4(String subject, int marks) {
        highestSubjectCareer4 = subject;
        highestMarksCareer4 = marks;
    }

    @FXML
    public void initialize() {
        // Determine the highest subject from all careers
        String finalHighestSubject = "";
        int finalHighestMarks = 0;

        if (highestMarksCareer1 >= finalHighestMarks) {
            finalHighestMarks = highestMarksCareer1;
            finalHighestSubject = highestSubjectCareer1;
        }

        if (highestMarksCareer2 >= finalHighestMarks) {
            finalHighestMarks = highestMarksCareer2;
            finalHighestSubject = highestSubjectCareer2;
        }

        if (highestMarksCareer3 >= finalHighestMarks) {
            finalHighestMarks = highestMarksCareer3;
            finalHighestSubject = highestSubjectCareer3;
        }

        if (highestMarksCareer4 >= finalHighestMarks) {
            finalHighestMarks = highestMarksCareer4;
            finalHighestSubject = highestSubjectCareer4;
        }

        if(finalHighestSubject == "BEE") {
            finalHighestSubject = "Electrical Engineering";
        } else if (finalHighestSubject == "Mechanics") {
            finalHighestSubject = "Mechanical Engineering";
        }  else if (finalHighestSubject == "Physics") {
            finalHighestSubject = "Physics Research";
        } else if (finalHighestSubject == "Chemistry") {
            finalHighestSubject = " Chemical Engineering";
        }else if (finalHighestSubject == "Maths") {
            finalHighestSubject = " Data Science";
        }else if (finalHighestSubject == "PCE") {
            finalHighestSubject = "Corporate Communications";
        }else if (finalHighestSubject == "Engineering Graphics") {
            finalHighestSubject = "Cryptography";
        }else if (finalHighestSubject == "C Programming") {
            finalHighestSubject = "Software Development";
        }else if (finalHighestSubject == "Physics 2") {
            finalHighestSubject = "Physics Research";
        }else if (finalHighestSubject == "Chemistry 2") {
            finalHighestSubject = "Electrical";
        }else if (finalHighestSubject == "Maths 2") {
            finalHighestSubject = "Data Science";
        }else if (finalHighestSubject == "DSGT") {
            finalHighestSubject = "Cryptography";
        }else if (finalHighestSubject == "DLCOA") {
            finalHighestSubject = "Embedded Systems Engineering";
        }else if (finalHighestSubject == "Computer Graphics") {
            finalHighestSubject = "Designing and Animation";
        }else if (finalHighestSubject == "Data Structures") {
            finalHighestSubject = "Software Engineering";
        }else if (finalHighestSubject == "Maths (Semester 3)") {
            finalHighestSubject = "Data Science";
        }else if (finalHighestSubject == "Analysis of Algorithms") {
            finalHighestSubject = "Algorithm Engineering";
        }else if (finalHighestSubject == "DBMS") {
            finalHighestSubject = "Database Administration";
        }else if (finalHighestSubject == "Operating System") {
            finalHighestSubject = "Systems Administration";
        }else if (finalHighestSubject == "Microprocessor") {
            finalHighestSubject = "Embedded Systems Engineering";
        }else if (finalHighestSubject == "Maths (Semester 4)") {
            finalHighestSubject = "Data Science";
        }else if (finalHighestSubject == "Data Science (PGM / IP / ADBMS)") {
            finalHighestSubject = "Data Analysis:";
        }else if (finalHighestSubject == "Systems Programming (SPCC)") {
            finalHighestSubject = "Systems Administration";
        }else if (finalHighestSubject == "Cybersecurity (CSS)") {
            finalHighestSubject = "Cybersecurity";
        }else if (finalHighestSubject == "Data Analytics (IOT / DSIP / QA)") {
            finalHighestSubject = "Data Analysis";
        }else if (finalHighestSubject == "Software Engineering") {
            finalHighestSubject = "Software Development";
        }else if (finalHighestSubject == "Computer Network") {
            finalHighestSubject = "Network Engineering";
        }else if (finalHighestSubject == "Data Warehousing & Mining") {
            finalHighestSubject = "Data Analysis";
        }else if (finalHighestSubject == "Mobile Computing") {
            finalHighestSubject = " Mobile Application Development";
        }else if (finalHighestSubject == "Artificial Intelligence") {
            finalHighestSubject = "AI Engineering";
        }else if (finalHighestSubject == "Machine Learning") {
            finalHighestSubject = "Data Science";
        }else if (finalHighestSubject == "Big Data Analysis") {
            finalHighestSubject = " Data Analysis";
        }else if (finalHighestSubject == "Artificial Intelligence (MV / QC / NLP)") {
            finalHighestSubject = "AI Engineering";
        }else if (finalHighestSubject == "Emerging Technologies (ARVR / Block Chain / IR)") {
            finalHighestSubject = "Technology Innovation Management";
        }else if (finalHighestSubject == "Systems Engineering (PLM / OR / DE)") {
            finalHighestSubject = "System Administration";
        }else if (finalHighestSubject == "Risk Management (RE / DOE / DMMM)") {
            finalHighestSubject = "Risk Management";
        }else if (finalHighestSubject == "Information Technology Management (MIS / CSL / EAM)") {
            finalHighestSubject = "IT Management";
        }else if (finalHighestSubject == "Human Machine Interaction") {
            finalHighestSubject = "UX/UI Design";
        }else if (finalHighestSubject == "Distributed Computing (HPC / AWN)") {
            finalHighestSubject = "Cloud Engineering";
        }else if (finalHighestSubject == "Digital Transformation (NLP / DBM)") {
            finalHighestSubject = "Digital Transformation Consulting";
        }else if (finalHighestSubject == "Business Administration (PM / FM / HRM)") {
            finalHighestSubject = "Business Analysis";
        }else if (finalHighestSubject == "Sustainable Business Practices (EDM / PECSR / EM)") {
            finalHighestSubject = "Sustainability Management";
        }else if (finalHighestSubject == "Innovation Management (RM / IPR & Patenting)") {
            finalHighestSubject = "Innovation Management";
        }else {
            finalHighestSubject = "Cloud Engineering";
        }

        // Update the label text with the highest subject
        recommendationLabel.setText("Based on your academic performance in each subject throughout the years, we recommend pursuing a career in " + finalHighestSubject);
    }

    public void switchToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/dashboard.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}
