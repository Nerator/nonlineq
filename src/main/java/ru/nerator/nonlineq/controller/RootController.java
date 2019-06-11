package ru.nerator.nonlineq.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import ru.nerator.nonlineq.MainApp;
import ru.nerator.nonlineq.model.NumericMethods;

public class RootController {

    @FXML
    private Label lblEps;
    @FXML
    private TextField textN;
    @FXML
    private TextField textA;
    @FXML
    private TextField textB;
    @FXML
    private TextField textE;
    @FXML
    private TextField textXLower;
    @FXML
    private TextField textXHigher;
    @FXML
    private TabPane tabpane;
    @FXML
    private GraphTabController tabGraphController;
    @FXML
    private FindRootTabController tabRootController;

    // Ссылка на главное приложение.
    private MainApp main;

    /**
     * Конструктор. Конструктор вызывается раньше метода initialize().
     */
    public RootController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        lblEps.setText("Точность (\u03B5)");
        textN.setText("7");
        textXLower.setText("-5");
        textXHigher.setText("5");

        //tabGraphController.setMainController(this);
        tabRootController.setMainController(this);
    }

    @FXML
    private void btnGraphPressed() {
        if (inputOK()) {
            if (!tabpane.getSelectionModel().isSelected(0)) {
                tabpane.getSelectionModel().select(0);
            }
            LineChart<Double, Double> linechart = tabGraphController.getChart();

            ObservableList<XYChart.Series<Double, Double>> lineChartData = FXCollections.observableArrayList();

            LineChart.Series<Double, Double> mySeries = new LineChart.Series<>();
            double x = Double.parseDouble(textXLower.getText());
            while (x < Double.parseDouble(textXHigher.getText())) {
                double y = NumericMethods.func(x, Integer.parseInt(getN()));
                mySeries.getData().add(new XYChart.Data<>(x, y));
                x += 0.01;
            }

            lineChartData.add(mySeries);

            linechart.setData(lineChartData);
            linechart.setCreateSymbols(false);
            //linechart.createSymbolsProperty().;

            showWhereRoot();
        }
    }

    private boolean inputOK() {
        String errorMessage = "";
        if (textXLower.getText() == null || textXLower.getText().length() == 0) {
            errorMessage += "Не заполнена левая граница X.\n";
        } else {
            try {
                Double.parseDouble(textXLower.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Левая граница X не является вещественным числом.\n";
            }
        }
        if (textXHigher.getText() == null || textXHigher.getText().length() == 0) {
            errorMessage += "Не заполнена правая граница X.\n";
        } else {
            try {
                Double.parseDouble(textXHigher.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Правая граница X не является вещественным числом.\n";
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Ошибка");
            alert.setHeaderText("Исправьте ошибки в границах X");
            alert.setContentText(errorMessage);

            // Workaround for ubuntu
            alert.setResizable(true);

            alert.showAndWait();

            return false;
        }
    }

    private void showWhereRoot() {
        Integer leftRoot = null, rightRoot = null;
        for (int i = -5; i < 5; i++) {
            //System.out.println("f(i)   = " + Model.func(i,   Integer.parseInt(textN.getText())));
            //System.out.println("f(i+1) = " + Model.func(i+1, Integer.parseInt(textN.getText())));
            if (NumericMethods.func(i, Integer.parseInt(getN())) *
                    NumericMethods.func(i + 1, Integer.parseInt(getN())) <= 0) {
                leftRoot = i;
                rightRoot = i + 1;
                break;
            }
        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.initOwner(main.getPrimaryStage());
        alert.setTitle("Приближение корня");
        alert.setHeaderText(null);
        alert.setContentText("Корень не найден.");
        if (leftRoot == null) {
            alert.setContentText("Корень не найден.");
        } else {
            alert.setContentText("Корень находится между " + leftRoot +
                    " и " + rightRoot + ".");
        }

        // Workaround for ubuntu
        alert.setResizable(true);

        alert.showAndWait();
    }

    String getA() {
        return textA.getText();
    }

    String getB() {
        return textB.getText();
    }

    String getN() {
        return textN.getText();
    }

    String getE() {
        return textE.getText();
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param main главное приложение
     */
    public void setMainApp(MainApp main) {
        this.main = main;
        //tabGraphController.setMainApp(main);
        tabRootController.setMainApp(main);
    }

//    void setTabRootController(FindRootTabController findRootTabController) {
//        tabRootController = findRootTabController;
//    }
//
//    void setTabGraphController(GraphTabController graphTabController) {
//        tabGraphController = graphTabController;
//    }
}