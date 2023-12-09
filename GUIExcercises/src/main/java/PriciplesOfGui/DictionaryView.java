package PriciplesOfGui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private DictionaryController controller;
    private TextField wordInput;
    private TextArea meaningDisplay;

    @Override
    public void start(Stage primaryStage) {
        Dictionary dictionary = new Dictionary();
        controller = new DictionaryController(dictionary);

        FlowPane root = new FlowPane();
        wordInput = new TextField();
        Button searchButton = new Button("Search");
        meaningDisplay = new TextArea();
        meaningDisplay.setEditable(false);

        searchButton.setOnAction(e -> searchWord());
        root.getChildren().addAll(new Label("Word"), wordInput, searchButton, meaningDisplay);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Virtual Dictionary");
        primaryStage.show();

    }
    private void searchWord() {
        String word = wordInput.getText().trim();
        if (!word.isEmpty()) {
            String meaning = controller.searchWord(word);
            meaningDisplay.setText(meaning);
        } else {
            meaningDisplay.setText("Please enter a word.");
        }
    }
}

