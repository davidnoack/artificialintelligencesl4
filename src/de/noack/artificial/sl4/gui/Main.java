package de.noack.artificial.sl4.gui;

import de.noack.artificial.sl4.logic.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Oberfläche der Anwendung bestehend aus zwei Eingabefeldern mit je zwei Radio-Buttons
 * (true oder false), sowie Ergebnisanzeige der XOR-Operation
 */
public class Main extends Application {

	private Stage window;

	// Ergebnisanzeige
	private Label resultLabel = new Label("");
	GridPane gridPane = new GridPane();
	private int a = 0;
	private int b = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;
		window.setTitle("XOR");

		// Eingabeaufforderung
		gridPane.add(createLabel("Choose Input A:"), 0, 0);
		gridPane.add(createLabel("Choose Input B:"), 1, 0);

		// -----------------------------------------------------------------------------------
		// Erster Eingabeparameter der XOR Operation (true oder false für A)
		ToggleGroup groupA = new ToggleGroup();
		RadioButton inputAfalse = new RadioButton("false");
		inputAfalse.setUserData("false");
		inputAfalse.setToggleGroup(groupA);
		groupA.selectToggle(inputAfalse);
		RadioButton inputAtrue = new RadioButton("true");
		inputAtrue.setToggleGroup(groupA);
		inputAtrue.setUserData("true");
		groupA.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
			if (groupA.getSelectedToggle() != null) {
				if ("false".equals(groupA.getSelectedToggle().getUserData().toString())) a = 0;
				else a = 1;
				printResult();
			}});
		gridPane.add(inputAfalse, 0, 1);
		gridPane.add(inputAtrue, 0, 2);
		// -----------------------------------------------------------------------------------

		// -----------------------------------------------------------------------------------
		// Erster Eingabeparameter der XOR Operation (true oder false für A)
		ToggleGroup groupB = new ToggleGroup();
		RadioButton inputBfalse = new RadioButton("false");
		inputBfalse.setUserData("false");
		inputBfalse.setToggleGroup(groupB);
		groupB.selectToggle(inputBfalse);
		RadioButton inputBtrue = new RadioButton("true");
		inputBtrue.setToggleGroup(groupB);
		inputBtrue.setUserData("true");
		gridPane.add(inputBfalse, 1, 1);
		gridPane.add(inputBtrue, 1, 2);
		groupB.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
			if (groupB.getSelectedToggle() != null) {
				if ("false".equals(groupB.getSelectedToggle().getUserData().toString())) b = 0;
				else b = 1;
				printResult();
			}});

		gridPane.add(createLabel("Result: "), 0, 4);
		// -----------------------------------------------------------------------------------


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
	 * Schreibt das ermittelte Ergebnis auf die Oberfläche
	 */
	private void printResult() {
		gridPane.getChildren().remove(resultLabel);
		resultLabel = createLabel(String.valueOf(Controller.xor(a, b)));
		gridPane.add(resultLabel, 1, 4);
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
