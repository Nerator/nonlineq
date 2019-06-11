package ru.nerator.nonlineq.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import ru.nerator.nonlineq.MainApp;
import ru.nerator.nonlineq.model.MethodResult;
import ru.nerator.nonlineq.model.NumericMethods;
import ru.nerator.nonlineq.util.Formatter;

public class FindRootTabController {

    private RootController rootController;

    public FindRootTabController() {
    }

    @FXML
    private void initialize() {
    }

    private MainApp main;

    @FXML
    private void btnPressed(ActionEvent ae) {
        if (isInputValid()) {
            double a = Double.parseDouble(rootController.getA());
            double b = Double.parseDouble(rootController.getB());
            int n = Integer.parseInt(rootController.getN());
            double e = Double.parseDouble(rootController.getE());

            MethodResult root = null;
            switch (((Node) ae.getSource()).getId()) {
                case "btnBisec":
                    root = NumericMethods.rootBisec(a, b, n, e);
                    break;
                case "btnSec":
                    root = NumericMethods.rootSecant(a, b, n, e);
                    break;
                case "btnNew":
                    root = NumericMethods.rootNewton(a, b, n, e);
                    break;
                case "btnIter":
                    root = NumericMethods.rootIter(a, b, n, e);
                    break;
            }
            String result = root == null ? "Something went horribly wrong" : Formatter.formatTuple(root);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Корень");
            alert.setHeaderText(null);
            alert.setContentText(result);

            // Workaround for ubuntu
            alert.setResizable(true);

            alert.showAndWait();
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (rootController.getA() == null || rootController.getA().length() == 0) {
            errorMessage += "Не заполнена левая граница корня.\n";
        } else {
            try {
                Double.parseDouble(rootController.getA());
            } catch (NumberFormatException e) {
                errorMessage += "Левая граница корня не является числом.\n";
            }
        }
        if (rootController.getB() == null || rootController.getB().length() == 0) {
            errorMessage += "Не заполнена правая граница корня.\n";
        } else {
            try {
                Double.parseDouble(rootController.getB());
            } catch (NumberFormatException e) {
                errorMessage += "Правая граница корня не является числом.\n";
            }
        }
        if (rootController.getE() == null || rootController.getE().length() == 0) {
            errorMessage += "Не заполнена точность.\n";
        } else {
            try {
                Double.parseDouble(rootController.getE());
            } catch (NumberFormatException e) {
                errorMessage += "Точность не является числом.\n";
            }
        }
        if (rootController.getN() == null || rootController.getN().length() == 0) {
            errorMessage += "Не заполнено значение N.\n";
        } else {
            try {
                Integer.parseInt(rootController.getN());
            } catch (NumberFormatException e) {
                errorMessage += "Значение N не является целым числом.\n";
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Ошибка");
            alert.setHeaderText("Исправьте ошибки в полях");
            alert.setContentText(errorMessage);

            // Workaround for ubuntu
            alert.setResizable(true);

            alert.showAndWait();

            return false;
        }
    }

    void setMainApp(MainApp main) {
        this.main = main;
    }

    void setMainController(RootController rootController) {
        this.rootController = rootController;
        //this.rootController.setTabRootController(this);
    }

}
