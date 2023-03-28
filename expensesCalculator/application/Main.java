package application;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpandedBudget.fxml"));
			loader.setController(this);
			Parent root = loader.load();
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML Button btnVisualize;
	@FXML Button btnPlan;
	@FXML Button btnTotal;
	@FXML TextField txtIncome;
	@FXML TextField txtEducation;
	@FXML TextField txtHousing;
	@FXML TextField txtFood;
	@FXML TextField txtTransportation;
	@FXML Label lblResult;
	
    
public void initialize(){
		// Add functionality to the "Calculate Total Expenses" button
		btnTotal.setOnAction((event) -> {
			// Get user input from expense boxes
			String inputE = txtEducation.getText();
			String inputH = txtHousing.getText();
			String inputF = txtFood.getText();	
			String inputT = txtTransportation.getText();

			// Then parse user input into doubles
			double numInputH = Double.parseDouble(inputH);
			double numInputE = Double.parseDouble(inputE);
			double numInputF = Double.parseDouble(inputF);
			double numInputT = Double.parseDouble(inputT);



			// Add up all the expenses
			String Total = Double.toString(numInputE + numInputH + numInputF + numInputT);

			// Add string to Total statement for more clarity
			String output0 = ("Expenses: \n$" + Total);

			// Shows the text and total onto the label
			lblResult.setText(output0);
		});



		// Add functionality to the "Plan My Budget" button
		btnPlan.setOnAction((event) -> {
			// Get user input from income text box
			String inputI = txtIncome.getText();
			// Then parse user input into doubles
			double numInputI = Double.parseDouble(inputI);		

			// Calculate 50/20/30 expense rule for needs, wants, savings
			double Needs = (numInputI*0.5);
			double Wants = (numInputI * 0.3);
			double Savings = (numInputI * 0.2);

			// Add string to Plan statement for more clarity
			String output = ("Needs: $" + Double.toString(Needs) + 
			"\n" + "Wants: $" + Double.toString(Wants) + "\n" + 
			"Savings: $" + Double.toString(Savings));

			// Shows the text and division of income onto the label
			lblResult.setText(output);
		});


		// Add functionality to the "Visualize Your Budget" button
		btnVisualize.setOnAction((event) -> {

		// Get user input from expense boxes                                                                                    
		String inputE = txtEducation.getText();
		String inputH = txtHousing.getText();
		String inputF = txtFood.getText();
		String inputT = txtTransportation.getText();


		// Then parse user input into doubles
		double numInputE = Double.parseDouble(inputE);
		double numInputH = Double.parseDouble(inputH);
		double numInputF = Double.parseDouble(inputF);
		double numInputT = Double.parseDouble(inputT);

		// Add up all the expenses
		double Total1 = numInputE + numInputH + numInputF + numInputT;

		// Find the percentage weight of each expense
		double eC = (numInputE/Total1)*100;
		double hC = (numInputH/Total1)*100;
		double fC = (numInputF/Total1)*100;
		double tC = (numInputT/Total1)*100;

		// Convert percentages into string and to 2 decimal places
		String Education = String.format("%.2f", eC);
		String Housing = String.format("%.2f", hC);
		String Food = String.format("%.2f", fC);
		String Transport = String.format("%.2f", tC);
		
		// Add string to Visualize statement for more clarity
		String output = ("Education:" + Education + "%\n" 
		+ "Housing:" + Housing + "%\n" + "Food:" + Food + "%\n" 
		+ "Transport:" + Transport + "%");

		// Shows the text and division of expenses onto the label
		lblResult.setText(output);
		});}
	
	public static void main(String[] args) {
		launch(args);
	}
}

