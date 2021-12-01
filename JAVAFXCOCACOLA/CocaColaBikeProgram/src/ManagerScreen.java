import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class ManagerScreen  {
	public static Stage window;
	public static Scene scene1;
	
	public static void show(){
		
		Stage primaryStage = new Stage();
		window = primaryStage;
		window.setTitle("Admin Check");
        
        Button problemBtn = new Button("Problems Report");
        problemBtn.setOnAction(e -> DoneScreen.show());
        Button RevenueBtn = new Button("Revenue");
        RevenueBtn.setOnAction(e -> DoneScreen.show());
        Button CheckStation = new Button("Check Station");
        CheckStation.setOnAction(e -> DoneScreen.show());
        Button InfoBtn = new Button("Info");
        InfoBtn.setOnAction(e -> InfoPage.show());
        
        VBox layout1 = new VBox(30);
        layout1.getChildren().addAll(problemBtn, RevenueBtn, CheckStation, InfoBtn);
        Scene scene1 = new Scene(layout1, 500, 500);
        
        scene1.getStylesheets().add("Style.css");
        
        layout1.setAlignment(Pos.CENTER);
        window.setScene(scene1);
        
        window.show();
    }

        
	}