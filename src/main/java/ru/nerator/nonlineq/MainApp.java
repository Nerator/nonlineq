package ru.nerator.nonlineq;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import ru.nerator.nonlineq.controller.RootController;

import java.io.IOException;

public class MainApp extends Application {
	
	private Stage primaryStage;

	@Override
	public void start(Stage stage) {
		this.primaryStage = stage;
		this.primaryStage.setTitle("Методы решения нелинейных уравнений");
		
        initRootLayout();
	}
	
	private void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			AnchorPane rootLayout = loader.load();
            
            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            // For Ubuntu until solve fonts/sizes issue
            primaryStage.setResizable(true);
            
            primaryStage.show();
            
            RootController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			launch(args);
		} else {
			MainAppConsole.main(args);
		}		
	}
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
