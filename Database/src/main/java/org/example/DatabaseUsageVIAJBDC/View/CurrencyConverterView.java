package org.example.DatabaseUsageVIAJBDC.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.DatabaseUsageVIAJBDC.Controller.CurrencyConverterController;
import org.example.DatabaseUsageVIAJBDC.DAO.CurrencyDao;
import org.example.DatabaseUsageVIAJBDC.Model.CurrencyConverter;


public class CurrencyConverterView extends Application {

    private CurrencyConverterController controller;

    @Override
    public void start(Stage primaryStage) {
        CurrencyDao currencyDao = new CurrencyDao();
        CurrencyConverter converter = new CurrencyConverter();
        controller = new CurrencyConverterController(currencyDao, converter, this);

        TextField amountTextField = new TextField();
        Button convertButton = new Button("Convert");
        TextField resultTextField = new TextField();
        ChoiceBox<String> fromCurrencyChoiceBox = new ChoiceBox<>();
        ChoiceBox<String> toCurrencyChoiceBox = new ChoiceBox<>();

        StackPane amountStackPane = new StackPane();
        StackPane resultStackPane = new StackPane();

        Label fromCurrencyLabel = new Label("From Currency");
        Label toCurrencyLabel = new Label("To Currency");
        Label amountLabel = new Label("Amount");
        Label resultLabel = new Label();

        amountStackPane.getChildren().addAll(amountTextField, amountLabel);
        resultStackPane.getChildren().addAll(resultTextField, resultLabel);

        fromCurrencyChoiceBox.getItems().addAll(controller.getAllCurrencies());
        toCurrencyChoiceBox.getItems().addAll(controller.getAllCurrencies());

        fromCurrencyChoiceBox.setValue("USD");
        toCurrencyChoiceBox.setValue("EUR");
        convertButton.setOnAction(e -> {
            String fromCurrency = fromCurrencyChoiceBox.getValue();
            String toCurrency = toCurrencyChoiceBox.getValue();
            String amountText = amountTextField.getText();
            if (!fromCurrency.isEmpty() && !toCurrency.isEmpty() && !amountText.isEmpty()) {
                try {
                    double amount = Double.parseDouble(amountText);
                    resultLabel.setText(controller.convertCurrency(fromCurrency, toCurrency, amount));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid amount entered.");
                }
            } else {
                resultLabel.setText("Please enter all fields.");
            }
        });

        amountTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            amountLabel.setVisible(newValue.isEmpty());
        });

        resultTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            resultLabel.setVisible(newValue.isEmpty());
        });

        VBox fromCurrencyVBox = new VBox(fromCurrencyLabel, fromCurrencyChoiceBox, amountStackPane);
        VBox toCurrencyVBox = new VBox(toCurrencyLabel, toCurrencyChoiceBox, resultStackPane);

        fromCurrencyVBox.setSpacing(10);
        toCurrencyVBox.setSpacing(10);

        fromCurrencyVBox.setAlignment(Pos.CENTER);
        toCurrencyVBox.setAlignment(Pos.CENTER);

        FlowPane root = new FlowPane(10, 10, fromCurrencyVBox, toCurrencyVBox, convertButton);
        Scene scene = new Scene(root, 600, 350);

        root.setAlignment(Pos.CENTER);

        scene.getStylesheets().add("style.css");

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void displayDatabaseConnectionError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Database Connection Error");
        alert.setHeaderText(null);
        alert.setContentText("Error connecting to the database. Please check your database connection.");
        alert.showAndWait();
        System.exit(0);
    }
}
