import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CardScreen {
	
	public  static void show() {
		Stage window = new Stage();

		TextField CardNumber = new TextField();
		CardNumber.setPromptText("Credit Card Number");

		TextField expireDate = new TextField();
		expireDate.setPromptText("Expire Date [only dig]");
		
		TextField securityCode3dig = new TextField();
		securityCode3dig.setPromptText("3 dig Security code");
		
		TextField TopUp = new TextField();
		TopUp.setPromptText("TopUp Value");
		
		Button btnEnter = new Button("Enter");
		btnEnter.setOnAction(e -> DoneScreen.show());
		
		Label label10 = new Label("**Minimal - €10");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(10);

		grid.add(CardNumber, 0, 2);
		grid.add(expireDate, 0, 3);
		
		grid.add(securityCode3dig, 0, 4);
		
		grid.add(label10, 0, 6);

		grid.add(btnEnter, 0, 11);
		btnEnter.setStyle("-fx-base: red;");
		grid.getStylesheets().add("Style.css");

		 
		


		Scene scene = new Scene(grid, 300, 400);
		window.setTitle("PAYMENT");
		window.setScene(scene);
		window.show();

	
	// btnEnter.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
	btnEnter.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		
		// Implementation 
		public void handle(ActionEvent e) {

			if (!CardNumber.getText().matches("^4[0-9]{12}(?:[0-9]{3})?$")) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter a valid card number [VISA ONLY] ");
				return;
				}
//			if (PINCODE.getText().trim().isEmpty()) {
//				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
//				"Please enter your 4 dig PASSCODE");
//				return;
//				}
			if (!expireDate.getText().matches("^[0-9]{4}$")) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter your 4-dig expire date [1234] ");
				return;
				}
			if (!securityCode3dig.getText().matches("^[0-9]{3}$")) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter your security code [123] ");
				return;
				}
	else {
		 DoneScreen.show();
	}

		}
	});
		}


	

private static void showAlert(AlertType error, Window window, String string, String string2) {
	Alert alert = new Alert(error);
	alert.setTitle(string);
	alert.setHeaderText(null);
	alert.setContentText(string2);
	alert.initOwner(window);
	alert.show();
	
}



	}




