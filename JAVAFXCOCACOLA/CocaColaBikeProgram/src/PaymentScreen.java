import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class PaymentScreen  {
	public static Stage window;
	public static Scene scene1;
	
	public static void show(){
		
		Stage primaryStage = new Stage();
		window = primaryStage;
		window.setTitle("Payment");
		
		// setting actions 
        Button TopUpBtn = new Button("TopUp");
        TopUpBtn.setOnAction(e -> CardScreen.show());
        Button PayBtn = new Button("Pay");
        PayBtn.setOnAction(e -> CardScreen.show());
        Button CheckBalanceBtn = new Button("CheckBalance");
        CheckBalanceBtn.setOnAction(e -> ReportProblem.show());
        Button InfoBtn = new Button("Info");
        InfoBtn.setOnAction(e -> InfoPage.show());
        
        // Ordering My Items 
        VBox layout1 = new VBox(30);
        layout1.getChildren().addAll(TopUpBtn, PayBtn, CheckBalanceBtn, InfoBtn);
        Scene scene1 = new Scene(layout1, 500, 500);
        
        //CSS
        scene1.getStylesheets().add("Style.css");
        layout1.setAlignment(Pos.CENTER);
        window.setScene(scene1);    
        window.show();
    }
}


        


