package de.saxsys.heizwertberechner;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This is a hello world javafx example to verify that javafx 2 is working.
 *
 * TODO delete this class.
 * @author manuel.mauky
 *
 */
public class HelloWorldJFX extends Application{

	public static void main(String...args){
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Hello World");


		VBox root = new VBox();
		root.getChildren().add(new Label("Hello World"));

		stage.setScene(new Scene(root, 400, 300));

		stage.show();
	}

}
