import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;


	public class ReportProblem {
		public static Stage window;
		public static Scene scene1;
		
		public static void show(){
			
			Stage primaryStage = new Stage();
			window = primaryStage;
			window.setTitle("Report Problem");
			ComboBox<String> bloc = new ComboBox<>();
	        Label label1 = new Label("Report problem");
	        
	        TextField ProblemField = new TextField();
	        ProblemField.setPromptText("What is your problem?");
	        TextField SerialNumber = new TextField();
	        
	        SerialNumber.setPromptText("Bike Serial Number");
	        Label label2 = new Label("Location");
	        
			bloc.getItems().addAll("Popes quay","College Of Commerce","UCC");
	        bloc.setValue("UCC");
	        
	        Button enterbike = new Button("Enter");
	        enterbike.setOnAction(e -> System.out.println("Problem " + SerialNumber + ProblemField));
	        
	        Button ButtonSubmit = new Button("Submit");

	        bloc.setOnAction(e -> System.out.println("Location is: " + bloc.getValue()));
	        ButtonSubmit.setOnAction(e -> DoneScreen.show());
	        
	        VBox layout1 = new VBox(30);
	        layout1.getChildren().addAll(label1, ProblemField, SerialNumber, enterbike, label2, bloc, ButtonSubmit);
	        Scene scene1 = new Scene(layout1, 500, 500);
	        
	        scene1.getStylesheets().add("Style.css");
	        
	        layout1.setAlignment(Pos.CENTER);
	        window.setScene(scene1);
	        
	        window.show();
	    }

	        
		}