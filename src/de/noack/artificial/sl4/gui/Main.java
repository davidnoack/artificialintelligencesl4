package de.noack.artificial.sl4.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Neuronal Network");

		GridPane gridPane = new GridPane();
		gridPane.add(createLabel("Choose Input A:"), 0, 0);
		gridPane.add(createLabel("Choose Input B:"), 1, 0);
		Slider sliderA = new Slider(0, 1, 0.5D);
		sliderA.setMajorTickUnit(0.1);
		sliderA.setShowTickLabels(true);
		Slider sliderB = new Slider(0, 1, 0.5D);
		sliderB.setMajorTickUnit(0.1);
		sliderB.setShowTickLabels(true);
		gridPane.add(sliderA, 0, 1);
		gridPane.add(sliderB, 1, 1);
		gridPane.add(createLabel("Result A:"), 0, 2);
		gridPane.add(createLabel("Result B:"), 1, 2);
		window.setScene(new Scene(gridPane));

		window.setOnCloseRequest(t -> {
			Platform.exit();
			System.exit(0);
		});
		window.setResizable(false);
		window.setFullScreen(false);
		window.show();
	}

	/**
	 * Erstellt ein Label mit Arial Bold 14
	 *
	 * @param labelText
	 * @return befülltes und formatiertes Label
	 */
	private Label createLabel(String labelText) {
		Label label = new Label(labelText);
		label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		return label;
	}
}
