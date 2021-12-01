import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class PickABike  {
	public static Stage window;
	public static Scene scene1;
	
	
	public static void show(){
		
		Stage primaryStage = new Stage();
		window = primaryStage;
		window.setTitle("pick a bike");
   	
        Label label1 = new Label("Pick a bike");
        
        // setting actions 
        Button PickBtn = new Button("Pick a bike");
        PickBtn.setOnAction(e -> PickABikeTest.show());
        Button ReturnBtn = new Button("Return a bike");
        ReturnBtn.setOnAction(e -> ReturningBike.show());
        Button ReportBtn = new Button("Report a problem");
        ReportBtn.setOnAction(e -> ReportProblem.show());
        Button InfoBtn = new Button("Info");
        InfoBtn.setOnAction(e -> InfoPage.show());
        
        // Ordering My Items 
        VBox layout1 = new VBox(30);
        layout1.getChildren().addAll(label1, PickBtn, ReturnBtn, ReportBtn, InfoBtn);
        Scene scene1 = new Scene(layout1, 500, 500);
        
        scene1.getStylesheets().add("Style.css");
        
        layout1.setAlignment(Pos.CENTER);
        window.setScene(scene1);
        
        window.show();
    }

        
	}


        

	