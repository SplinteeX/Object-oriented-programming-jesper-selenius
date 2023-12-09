package GuiDesignTools;

import GuiDesignTools.Controller.NoteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/notebook.fxml"));
        Parent root = fxmlLoader.load();

        NoteController controller = fxmlLoader.getController(); // Get the controller
        Notebook notebook = new Notebook(); // Create a Notebook instance
        controller.setNotebook(notebook); // Set the notebook in the controller

        stage.setScene(new Scene(root));
        stage.show();
    }
}

