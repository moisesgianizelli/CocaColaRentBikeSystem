import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InfoPage {
	public static Stage window;
	public static Scene scene1;
	
	public static void show(){
		
		Stage primaryStage = new Stage();
		window = primaryStage;
		window.setTitle("INFORMATION");
   	
        Label label1 = new Label("Information");
        
        
        Button TextSpace = new Button("•The first half hour is free.\r\n"
        		+ "•Up to an hour is 50c.\r\n"
        		+ "•Up to 2 hours is €1.50.\r\n"
        		+ "•Up to 3 hours is €6.50.\r\n"
        		+ "•After that is an additional €2.00 per half hour.\r\n"
        		+ "•Contact us cocacola@bikes.ie or 0833560020\r\n");

        Button backToMainpageBtn = new Button("Back");
        backToMainpageBtn.setOnAction( e -> primaryStage.close() );
 
        
        VBox layout1 = new VBox(50);
        layout1.getChildren().addAll(label1, TextSpace, backToMainpageBtn);
        Scene scene1 = new Scene(layout1, 600, 600);

        
        
        TextSpace.setId("newtxt");
        scene1.getStylesheets().add("Style.css");
        
        layout1.setAlignment(Pos.CENTER);
        window.setScene(scene1);
        
        window.show();
    }

        

}