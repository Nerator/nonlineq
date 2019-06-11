package ru.nerator.nonlineq.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class GraphTabController {

    @FXML
    private LineChart<Double, Double> chart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public GraphTabController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        chart.setLegendVisible(false);

        xAxis.setLowerBound(-5.0);
        xAxis.setUpperBound(5.0);

        yAxis.setLowerBound(-10.0);
        yAxis.setUpperBound(10.0);
    }

    LineChart<Double, Double> getChart() {
        return chart;
    }

//    void setMainController(RootController rootController) {
//        rootController.setTabGraphController(this);
//    }
}