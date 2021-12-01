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

public class ReturningBike {
	
	Stage window = new Stage();
	static int count = 0;
	static int bikeRemain;
	static String[][] myLocNum = new String[5][5];
	public static void show () {
		 ChooseBikes ();
		 UserChoice ();
		
	}
	
	

	public static void  ChooseBikes () {
		
	
		
		

	 String [] myLoc = {"Popes quay","College Of Commerce","UCC", "Cork School of Music", "Kent East"};
		//String[] myLoc = new String[3];
		String record = " ";
		try {
			System.out.println("Loading bike locations from a file");
			FileReader textFile = new FileReader("Locations.txt");
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
			System.out.println("Loading bike locations from a file");
			FileReader textFile = new FileReader("Locations.txt");
			BufferedReader textF = new BufferedReader(textFile);

			// while (record != null) {

			while (count < 5) {
				record = textF.readLine();
				myLocNum[count][0] = record;
				myLocNum[count][1] = "10";
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

		window.setTitle("Return a Bike");
		TextField Num1 = new TextField();
		Num1.setPromptText("How many bikes?");


		ToggleGroup group = new ToggleGroup();

		RadioButton pq = new RadioButton(myLocNum[0][0] + " bikes remaining " + myLocNum[0][1]);

		pq.setUserData(myLocNum[0][0]);
		pq.setSelected(true); // Initialised selected
		pq.setStyle("-fx-text-fill: white;");
		pq.setToggleGroup(group);

		RadioButton ccom = new RadioButton(myLocNum[1][0]+ " bikes remaining " + myLocNum[1][1]);
		ccom.setUserData(myLocNum[1][0]);
		ccom.setStyle("-fx-text-fill: white;");
		ccom.setToggleGroup(group);

		RadioButton ucc = new RadioButton(myLocNum[2][0] + " bikes remaining " + myLocNum[2][1]);
		ucc.setUserData(myLocNum[2][0]);
		ucc.setToggleGroup(group);
		ucc.setStyle("-fx-text-fill: white;");
		
		RadioButton csm = new RadioButton(myLocNum[3][0] + " bikes remaining " + myLocNum[3][1]);
		csm.setUserData(myLocNum[3][0]);
		csm.setToggleGroup(group);
		csm.setStyle("-fx-text-fill: white;");
		
		RadioButton ke = new RadioButton(myLocNum[4][0] + " bikes remaining " + myLocNum[4][1]);
		ke.setUserData(myLocNum[4][0]);
		ke.setToggleGroup(group);
		ke.setStyle("-fx-text-fill: white;");

		group.selectedToggleProperty().addListener((obserableValue, old_toggle, new_toggle) -> {
			if (group.getSelectedToggle() != null) {
				System.out.println("Index #" + group.getToggles().indexOf(new_toggle) + " selected!");
				int num1 = Integer.parseInt(Num1.getText()); //# of bikes to rent
				int x = group.getToggles().indexOf(new_toggle);  //index number of array
				int bikes = Integer.parseInt(myLocNum[x][1]); //# of bikes remaining

				bikeRemain = bikes + num1;
				myLocNum[x][1] = String.valueOf(bikeRemain);

				System.out.println(num1 + " " + bikes + " " + myLocNum[x][1]);
				System.out.println("remaining bikes at " + group.getSelectedToggle().getUserData().toString() + " are "
						+ bikeRemain);
				System.out.println(
						"You have selected bike location:- " + group.getSelectedToggle().getUserData().toString());
			}
		});

		ComboBox<String> bloc = new ComboBox<>();
		Button PayBtn = new Button("PAY");
		PayBtn.setOnAction(e -> PaymentScreen.show());

		bloc.getItems().addAll("Popes quay","College Of Commerce","UCC", "Cork School of Music", "Kent East");

		bloc.setValue("UCC");
		
		System.out.println(bloc.getValue());

		
		//b1.setOnAction(e -> System.out.println("This was printed from a button click " + bloc.getValue()));
		//PayBtn.setOnAction(e -> PaymentScreen.show());
		bloc.setOnAction(e -> System.out.println("User took the bike at: " + bloc.getValue()));

		ArrayList<String> locate = new ArrayList<String>();
		String record = " ";

		try {
			System.out.println("Loading locations from a file to a Combobox");
			FileReader textFile = new FileReader("Locations.txt");
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
		
		Label WhereLabel = new Label("Where did you take the bike: ");
		
		
		ComboBox<String> loc = new ComboBox<String>(FXCollections.observableArrayList(locate));
		VBox vbox = new VBox(10);
		
		Label ReturnLabel = new Label("How many bikes do you want to return?");

        Button CalculationBtn = new Button("Calculate");
        CalculationBtn.setOnAction(e -> Calculation.show());
		
		
		vbox.setPadding(new Insets(30, 30, 30, 30));
		vbox.getChildren().addAll(ReturnLabel, Num1, ccom, pq, ucc, csm, ke,  WhereLabel, bloc, CalculationBtn);
		vbox.getStylesheets().add("Style.css");

		Scene scene = new Scene(vbox, 600, 500);
		window.setScene(scene);
		window.show();

	}
}
