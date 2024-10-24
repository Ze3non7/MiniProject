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

public class Career1Controller {
    @FXML
    private TextField beeField;
    @FXML
    private TextField mechanicsField;
    @FXML
    private TextField physicsField;
    @FXML
    private TextField chemistryField;
    @FXML
    private TextField mathsField;
    @FXML
    private TextField pceField;
    @FXML
    private TextField engGraphicsField;
    @FXML
    private TextField cProgrammingField;
    @FXML
    private TextField physics2Field;
    @FXML
    private TextField chemistry2Field;
    @FXML
    private TextField maths2Field;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void next1(ActionEvent event) throws IOException {
        // Create a map to associate TextFields with their corresponding subjects
        Map<TextField, String> subjects = new HashMap<>();
        subjects.put(beeField, "BEE");
        subjects.put(mechanicsField, "Mechanics");
        subjects.put(physicsField, "Physics");
        subjects.put(chemistryField, "Chemistry");
        subjects.put(mathsField, "Maths");
        subjects.put(pceField, "PCE");
        subjects.put(engGraphicsField, "Engineering Graphics");
        subjects.put(cProgrammingField, "C Programming");
        subjects.put(physics2Field, "Physics 2");
        subjects.put(chemistry2Field, "Chemistry 2");
        subjects.put(maths2Field, "Maths 2");

        // Find the highest marks and corresponding subject
        Optional<Map.Entry<TextField, String>> highestEntry = subjects.entrySet().stream()
                .max((entry1, entry2) -> {
                    // Parse the marks or consider empty fields as 0
                    int marks1 = entry1.getKey().getText().isEmpty() ? 0 : Integer.parseInt(entry1.getKey().getText());
                    int marks2 = entry2.getKey().getText().isEmpty() ? 0 : Integer.parseInt(entry2.getKey().getText());
                    return Integer.compare(marks1, marks2);
                });

        // Send the highest marks and subject to final controller
        if (highestEntry.isPresent()) {
            Map.Entry<TextField, String> entry = highestEntry.get();
            int highestMarks = entry.getKey().getText().isEmpty() ? 0 : Integer.parseInt(entry.getKey().getText());
            String highestSubject = entry.getValue();

            // Pass the highest marks and subject to FinalCareerController
            FinalCareerController.setHighestCareer1(highestSubject, highestMarks);
        } else {
            System.out.println("No marks entered.");
        }

        // Load the next scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/career2.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
