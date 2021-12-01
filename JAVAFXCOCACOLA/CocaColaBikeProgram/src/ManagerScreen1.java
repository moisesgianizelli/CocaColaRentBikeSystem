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

// Give access a different screens for Admin
public class ManagerScreen1  {

	
	public  static void show() {
		Stage window = new Stage();

		TextField Name1 = new TextField();
		Name1.setPromptText("name");		
		TextField PINCODE = new TextField();
		PINCODE.setPromptText("PINCODE");		
		Button btnEnter = new Button("Enter");	
		
		// Create my grid
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(50);
		grid.add(Name1, 0, 2);
		grid.add(PINCODE, 0, 3);
		grid.add(btnEnter, 0, 11);
		Scene scene = new Scene(grid, 300, 400);
		grid.getStylesheets().add("Style.css");
		window.setTitle("Sign In");
		window.setScene(scene);
		window.show();
		
		//Implementation
		btnEnter.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				if (!Name1.getText().matches("[a-zA-Z\\s']+")) {
					showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
					"Please enter a valid name and valid Pin ");
					return;
					}
				if (!PINCODE.getText().matches("^[0-9]{4}$")) {
					showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
					"Please enter a valid name and valid Pin ");
					return;
					}
		else {
			 ManagerScreen.show();
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

