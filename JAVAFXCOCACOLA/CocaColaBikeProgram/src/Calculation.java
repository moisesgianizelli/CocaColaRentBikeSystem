import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Calculation {
	
	Stage window = new Stage();
	static int count = 0;
	static int bikeRemain;
	static String[][] myLocNum = new String[5][5];
	public static void show () {
		 Cost ();
		 UserChoice ();
		
	}
	
	

	public static void  Cost () {
		
	
		
		

	 String [] myLoc = {"First hour FREE","Up to hour 50c", "Up to 2 hours €1.50", "Up to 3 hours 6.50", "Up to 4 hours 4 per hour"};
		//String[] myLoc = new String[3];
		String record = " ";
		try {
			System.out.println("Loading bike locations from a file");
			FileReader textFile = new FileReader("Costs.txt");
			BufferedReader textF = new BufferedReader(textFile);

			// while (record != null) {
			while (count < 5) {
				record = textF.readLine();
				myLoc[count] = record;
				count += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}

		int count = 0;

		try {
			System.out.println("Loading costs locations from a file");
			FileReader textFile = new FileReader("Costs.txt");
			BufferedReader textF = new BufferedReader(textFile);

			// while (record != null) {

			while (count < 5) {
				record = textF.readLine();
				myLocNum[count][0] = record;
				myLocNum[count][1] = "";
				myLocNum[count][2] = "9";
				myLocNum[count][3] = "5";
				myLocNum[count][4] = "7";
				
				System.out.println("Location at index " + count + " " + myLocNum[count][0]);
				System.out.println("Number of bikes at " + myLocNum[count][1]);

				count += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}

	};

		public static void UserChoice () {
		
			Stage window = new Stage ();

		window.setTitle("Cost");

		ToggleGroup group = new ToggleGroup();

		RadioButton free = new RadioButton(myLocNum[0][0] + myLocNum[0][1]);

		free.setUserData(myLocNum[0][0]);
		free.setSelected(true); // Initialised selected
		free.setStyle("-fx-text-fill: white;");
		free.setToggleGroup(group);

		RadioButton hour = new RadioButton(myLocNum[1][0] + myLocNum[1][1]);
		hour.setUserData(myLocNum[1][0]);
		hour.setStyle("-fx-text-fill: white;");
		hour.setToggleGroup(group);

		RadioButton twohours = new RadioButton(myLocNum[2][0] + myLocNum[2][1]);
		twohours.setUserData(myLocNum[2][0]);
		twohours.setToggleGroup(group);
		twohours.setStyle("-fx-text-fill: white;");
		
		RadioButton threehours = new RadioButton(myLocNum[3][0]  + myLocNum[3][1]);
		threehours.setUserData(myLocNum[3][0]);
		threehours.setToggleGroup(group);
		threehours.setStyle("-fx-text-fill: white;");
		
		RadioButton fourhours = new RadioButton(myLocNum[4][0] + myLocNum[4][1]);
		fourhours.setUserData(myLocNum[4][0]);
		fourhours.setToggleGroup(group);
		fourhours.setStyle("-fx-text-fill: white;");

		group.selectedToggleProperty().addListener((obserableValue, old_toggle, new_toggle) -> {
			if (group.getSelectedToggle() != null) {
				System.out.println("Index #" + group.getToggles().indexOf(new_toggle) + " selected!");
				int x = group.getToggles().indexOf(new_toggle);  //index number of array
				int bikes = Integer.parseInt(myLocNum[x][1]); //# of bikes remaining

				myLocNum[x][1] = String.valueOf(bikeRemain);

				System.out.println(bikes + " " + myLocNum[x][1]);
				System.out.println("remaining bikes at " + group.getSelectedToggle().getUserData().toString() + " are "
						+ bikeRemain);
				System.out.println(
						"You have selected bike location:- " + group.getSelectedToggle().getUserData().toString());
			}
		});

		ComboBox<String> bloc = new ComboBox<>();
		Button PayBtn = new Button("PAY");
		PayBtn.setOnAction(e -> PaymentScreen.show());

		bloc.getItems().addAll("Annual Plan", "3 days Pass");

		bloc.setValue("Choose Plan ");
		
		System.out.println(bloc.getValue());

		
		//b1.setOnAction(e -> System.out.println("This was printed from a button click " + bloc.getValue()));
		//PayBtn.setOnAction(e -> PaymentScreen.show());
		bloc.setOnAction(e -> System.out.println("" + bloc.getValue()));

		ArrayList<String> locate = new ArrayList<String>();
		String record = " ";

		try {
			System.out.println("Loading costs from a file to a Combobox");
			FileReader textFile = new FileReader("Costs.txt");
			BufferedReader textF = new BufferedReader(textFile);

			while (record != null) {
				record = textF.readLine();
				locate.add(record);
				count += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
			
		}
		
		
		
		ComboBox<String> loc = new ComboBox<String>(FXCollections.observableArrayList(locate));
		VBox vbox = new VBox(10);

        Button CalculationBtn = new Button("PAY");
        CalculationBtn.setOnAction(e -> PaymentScreen.show());
		
		
		vbox.setPadding(new Insets(30, 30, 30, 30));
		vbox.getChildren().addAll(free, hour, twohours, threehours, fourhours, bloc, CalculationBtn);
		vbox.getStylesheets().add("Style.css");

		Scene scene = new Scene(vbox, 400, 300);
		window.setScene(scene);
		window.show();

	}
}

