import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;


public class SignUp  {


public  static void show() {
	Stage window = new Stage();

	TextField Name1 = new TextField();
	Name1.setPromptText("name");
	TextField Name2 = new TextField();
	Name2.setPromptText("Surname");
	TextField Gender = new TextField();
	Gender.setPromptText("MALE OR FEMALE");
	TextField DOB = new TextField();
	DOB.setPromptText("12051996 example");
	TextField Address1 = new TextField();
	Address1.setPromptText("Address Line 1");
	TextField Address2 = new TextField();
	Address2.setPromptText("Address Line 2");
	TextField Country = new TextField();
	Country.setPromptText("Country");
	TextField County = new TextField();
	County.setPromptText("County");
	TextField PhoneNo = new TextField();
	PhoneNo.setPromptText("831234567");
	TextField Email = new TextField();
	Email.setPromptText("Enter email address");
	TextField Cred = new TextField();
	Cred.setPromptText("Enter a 4-dig PIN");
	TextField Pass2 = new TextField();
	Pass2.setPromptText("Confirm a 4-dig PIN");
	Button btnEnter = new Button("Enter");
	btnEnter.setOnAction(e -> PickABike.show());
	Label termsBox = new Label();
	CheckBox terms = new CheckBox("Terms and Conds");
	terms.setStyle("-fx-base: white");
	
	//Create and organise my grid
	
	GridPane grid = new GridPane();
	grid.setAlignment(Pos.TOP_CENTER);
	grid.setStyle("-fx-base: grey;");
	grid.setPadding(new Insets(5, 5, 5, 5));
	grid.setVgap(7);
	grid.setHgap(7);
	grid.add(Name1, 0, 2);
	grid.add(Name2, 1, 2);	
	grid.add(Gender, 0, 3);	
	grid.add(DOB, 0, 4);	
	grid.add(Address1, 0, 5);
	grid.add(Address2, 1, 5);	
	grid.add(County, 1, 6);
	grid.add(Country, 0, 6);	
	grid.add(PhoneNo, 0, 7);
	grid.add(Email, 0, 8);
	grid.add(Cred, 0, 9);
	grid.add(Pass2, 0, 10);
	grid.add(termsBox, 0, 11);
	grid.add(terms, 0, 11);
	grid.add(btnEnter, 0, 12);
	btnEnter.setStyle("-fx-base: red;");
	//CS
	grid.getStylesheets().add("Style.css");

	// Scene Size
	Scene scene = new Scene(grid, 500, 500);
	window.setTitle("Sign Up");
	window.setScene(scene);
	window.show();
	
	// Give command for the bottom 
	btnEnter.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		//Implementation 
		public void handle(ActionEvent e) {

			if (!Name1.getText().matches("[a-zA-Z\\s']+")) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter a valid name ");
				return;
				}
			if (!Name2.getText().matches("[a-zA-Z\\s']+")) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter a valid surname ");
				return;
				} 
			if (Gender.getText().trim().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter your gender (MALE OR FEMALE) ");
				return;
				}
			if (!DOB.getText().matches("[0-9]{8}$")) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter a valid Date of birth ddmmyyyy ");
				return;
				}
			if (Address1.getText().trim().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter your Address ");
				return;
				}
			if (Country.getText().trim().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter your Country ");
				return;
				}
			if (County.getText().trim().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter your County ");
				return;
				}
			if (!PhoneNo.getText().matches("[0-9]{9}$")) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter a valid Phone Number [ONLY NUMBERS 0-9] ");
			}
			if (!Email.getText().matches("^(.+)@(.+)$")) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter a valid Email example@gmail.com ");
				return;
			}
			if (!Cred.getText().matches("^[0-9]{4}$")) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter a valid Pin ");
				return;
				}
			if (!Pass2.getText().matches("^[0-9]{4}$")) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Please enter a valid Pin ");
				return;
				}
			
			if (!terms.isSelected()) {
				showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
				"Confirm our terms and services, please ");
				return;
				
				}
	else {
		 PickABike.show();
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


