package com.stwijn;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RenteApp extends Application {

    public static void main(String[] args) {
        launch(RenteApp.class);
    }

    public void start(Stage scherm) {

        //1 chart
        NumberAxis x_As = new NumberAxis(0, 30, 1);
        NumberAxis y_As = new NumberAxis();
        x_As.setLabel("Jaren");
        y_As.setLabel("Totaal opgespaard vermogen in euro");
        LineChart<Number, Number> chart = new LineChart<>(x_As, y_As);
        chart.setTitle("Spaarrekening over 30 jaar");

        //1.1 legenda
        XYChart.Series dataSpaar = new XYChart.Series();
        dataSpaar.setName("Vermogen zonder rente");
        XYChart.Series dataRente = new XYChart.Series();
        dataRente.setName("Vermogen incl. opgebouwde rente");

        //2.0 Spaar/vermogen slider
        Slider spaarSlider = new Slider(25, 250, 25);
        Label spaarLabel = new Label("Hoeveel € per maand sparen");
        Label spaarValue = new Label(Double.toString(spaarSlider.getValue()));
        spaarSlider.setShowTickLabels(true);
        spaarSlider.setShowTickMarks(true);

        //2.0.1 listener om slider en chart interactief te maken
        spaarSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                spaarValue.setText(String.format("%.2f", newValue));

                dataSpaar.getData().clear();

                for (double i = 0; i <= 30; i++) {

                    Double som = (Double) newValue * 12 * i;
                    dataSpaar.getData().add(new XYChart.Data(i, som));
                }
            }
        });

        //2.0.2 toevoegen data aan de linechart
        chart.getData().add(dataSpaar);

        //3.0 Rente slider
        Slider renteSlider = new Slider();
        Label renteLabel = new Label("Rentepercentage");
        Label renteValue = new Label(Double.toString(renteSlider.getValue()));
        renteSlider.setMin(0);
        renteSlider.setMax(10);
        renteSlider.setShowTickLabels(true);

        //3.0.1 listener op de slider
        renteSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                renteValue.setText(String.format("%.2f", newValue));

                Double rentePerJaar = ((((Double) newValue) / 100 + 1));
                Double jaarEerder = 0.0;

                dataRente.getData().clear();

                for (double i = 0; i <= 30; i++) {
                    jaarEerder += spaarSlider.getValue() * 12;
                    jaarEerder *= rentePerJaar;

                    if (i == 0) {
                        jaarEerder = i;
                    }

                    dataRente.getData().add(new XYChart.Data(i, jaarEerder));
                }
            }
        });

        //3.0.2 toevoegen data aan de linechart
        chart.getData().add(dataRente);

        //4 main layout
        BorderPane mainLayout = new BorderPane();

        //4.1 VBox met indeling/opmaak (2 borderpanes)
        VBox box = new VBox();

        BorderPane spaarPane = new BorderPane();
        spaarPane.setLeft(spaarLabel);
        spaarPane.setCenter(spaarSlider);
        spaarPane.setRight(spaarValue);

        spaarPane.setPadding(new Insets(30, 20, 20, 20));

        BorderPane rentePane = new BorderPane();
        rentePane.setLeft(renteLabel);
        rentePane.setCenter(renteSlider);
        rentePane.setRight(renteValue);
        rentePane.setPadding(new Insets(0, 20, 20, 20));

        box.getChildren().addAll(spaarPane, rentePane);
        mainLayout.setCenter(chart);
        mainLayout.setTop(box);

        Scene scene = new Scene(mainLayout, 600, 500);
        scherm.setScene(scene);
        scherm.show();
    }
}