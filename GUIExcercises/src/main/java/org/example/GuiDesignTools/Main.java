package org.example.GuiDesignTools;

import org.example.GuiDesignTools.Controller.NoteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.GuiDesignTools.Model.Notebook;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/notebook.fxml"));
        Parent root = fxmlLoader.load();

        NoteController controller = fxmlLoader.getController();
        Notebook notebook = new Notebook();
        controller.setNotebook(notebook);

        stage.setScene(new Scene(root));
        stage.show();
    }
}

