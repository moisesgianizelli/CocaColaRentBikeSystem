import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DoneScreen {
	public static Stage window;
	public static Scene scene1;
	
	public static void show(){
		
		Stage primaryStage = new Stage();
		window = primaryStage;
		window.setTitle("DONE");
   	
        Label label1 = new Label("Thanks for using COCA COLA BIKES");
        
        Button doneButton = new Button("DONE");
        
        
        //doneButton.setOnAction(e -> MainScreen.show());

        
        VBox layout1 = new VBox(30);
        layout1.getChildren().addAll(label1, doneButton);
        Scene scene1 = new Scene(layout1, 500, 500);
        
        
        doneButton.setId("newDoneBtn");
        scene1.getStylesheets().add("Style.css");
        
        layout1.setAlignment(Pos.CENTER);
        window.setScene(scene1);
        
        window.show();
    }

        

}
