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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Career2Controller {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField dsgtField;        // Data Structure Graphics and Theory
    @FXML
    private TextField dlcoaField;       // Data Structures and Algorithms
    @FXML
    private TextField compGraphicsField; // Computer Graphics
    @FXML
    private TextField dataStructuresField; // Data Structures
    @FXML
    private TextField mathsField1;      // Maths Semester 3
    @FXML
    private TextField algoField;        // Analysis of Algorithms
    @FXML
    private TextField dbmsField;        // Database Management System
    @FXML
    private TextField osField;          // Operating Systems
    @FXML
    private TextField microprocessorField; // Microprocessor
    @FXML
    private TextField mathsField2;      // Maths Semester 4

    public void next2(ActionEvent event) throws IOException {
        // Find the highest marks and corresponding subject
        Map<TextField, String> subjects = new HashMap<>();
        subjects.put(dsgtField, "DSGT");
        subjects.put(dlcoaField, "DLCOA");
        subjects.put(compGraphicsField, "Computer Graphics");
        subjects.put(dataStructuresField, "Data Structures");
        subjects.put(mathsField1, "Maths (Semester 3)");
        subjects.put(algoField, "Analysis of Algorithms");
        subjects.put(dbmsField, "DBMS");
        subjects.put(osField, "Operating System");
        subjects.put(microprocessorField, "Microprocessor");
        subjects.put(mathsField2, "Maths (Semester 4)");

        Optional<Map.Entry<TextField, String>> highestEntry = subjects.entrySet().stream()
                .max((entry1, entry2) -> {
                    // Parse marks, considering empty fields as 0
                    int marks1 = entry1.getKey().getText().isEmpty() ? 0 : Integer.parseInt(entry1.getKey().getText());
                    int marks2 = entry2.getKey().getText().isEmpty() ? 0 : Integer.parseInt(entry2.getKey().getText());
                    return Integer.compare(marks1, marks2);
                });

        // Pass the highest subject and marks to FinalCareerController
        if (highestEntry.isPresent()) {
            Map.Entry<TextField, String> entry = highestEntry.get();
            int highestMarks = entry.getKey().getText().isEmpty() ? 0 : Integer.parseInt(entry.getKey().getText());
            String highestSubject = entry.getValue();

            // Pass the values to FinalCareerController
            FinalCareerController.setHighestCareer2(highestSubject, highestMarks);

            System.out.println("Highest Marks: " + highestMarks + " in " + highestSubject);
        } else {
            System.out.println("No marks entered.");
        }

        // Load the next scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/career3.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
