/*
* @author Moises Gianizelli 
* Date started: 05/11/21
* Last Update: 01/12/21
*
* 1st Skills Demo
*
*This assignment is intended to replicate the Coca Cola Bike rental system in Cork, IE.
*
*/

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
// Setting up my starting point


public class MainScreen extends Application {

	public static Stage window;
	public static Scene scene1, scene2;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
    	//Declaring my items that I want to show on my scene
    	   	
        Label label1 = new Label("Welcome to Coca Cola Rent Bike System Cork");
        
        Button SignInBtn = new Button("Sign In");
        SignInBtn.setOnAction(e -> SignIn.show());
        Button SignUpBtn = new Button("Sign Up");
        SignUpBtn.setOnAction(e -> SignUp.show());
        Button ThreeDaysPassBtn = new Button("3-days pass");
        ThreeDaysPassBtn.setOnAction(e -> SignUp.show());
        Button InfoBtn = new Button("Info");
        InfoBtn.setOnAction(e -> InfoPage.show());
        VBox layout1 = new VBox(30);
        
        // Ordering My Items 
        layout1.getChildren().addAll(label1, SignInBtn, SignUpBtn, ThreeDaysPassBtn, InfoBtn);
        
        // make my scene
        scene1 = new Scene(layout1, 500, 500);
        
        //Calling my CSS file
        scene1.getStylesheets().add("Style.css");
        
        // Alignment 
        layout1.setAlignment(Pos.CENTER);
        
        //Display scene 1 at first
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Main Screen");
        primaryStage.show();
    }    
}