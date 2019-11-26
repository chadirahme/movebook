package com.khaled;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import javafx.scene.control.Button;
//import java.awt.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.sql.*;

//@SpringBootApplication
public class DemoApplication extends Application{ //implements EventHandler<ActionEvent> {

	private ConfigurableApplicationContext springContext;
	private Parent rootNode;
	private FXMLLoader fxmlLoader;
	Stage window;
	Button button;
	Scene scene,scene1, scene2;
	String connectionUrl;
	TextField txtBookId,txtBookName;

//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}

	public static void main(String[] args) {
		launch(args); // It calls start method defined bellow...
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				System.out.println("Hello World");
//			}
//		};
//	}


	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(DemoApplication.class);
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(springContext::getBean);
	}

	//@Override
	public void start1(Stage primaryStage) throws Exception {

		window = primaryStage;
		//Button 1
		Label label1 = new Label("Welcome to the first scene!");
		Button button1 = new Button("Go to scene 2");
		button1.setOnAction(e -> AlertBox.display("Title of Window", "Wow this alert box is awesome!"));

		//button1.setOnAction(e -> window.setScene(scene2));

		//Layout 1 - children laid out in vertical column
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1, 600, 300);


		//Button 2
		Button button2 = new Button("This sucks, go back to scene 1");
		button2.setOnAction(e -> window.setScene(scene1));

		//Layout 2
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(button2);
		scene2 = new Scene(layout2, 600, 300);

		//Display scene 1 at first
		window.setScene(scene1);
		window.setTitle("Title Here");
		window.show();
//
//		//fxmlLoader.setLocation(getClass().getResource("/fxml/main.fxml"));
//		//rootNode = fxmlLoader.load();
//		window.setTitle("Hello Khaled");
//		//Scene scene = new Scene(rootNode, 800, 600);
//		//primaryStage.setScene(scene);
//		//primaryStage.show();
//		// Creating a simple UI button
//		button = new Button("Click me");
//		//This class will handle the button events
//		//button.setOnAction(this);
//		button.setOnAction(e -> {
//			System.out.println("dsa dsa dsa !");
//			System.out.println("Lambda expressions are awesome!");
//		});
//
//		// StackPane is a type of layout which we will look at later..
//		StackPane layout = new StackPane();
//
//		//Adding the button to the layout
//		layout.getChildren().add(button);
//
//		// Create scene with resolution of 300x250 and add layout to it...
//		Scene scene = new Scene(layout, 800, 600);
//
//		// Add scene to the stage i.e to the window
//		window.setScene(scene);
//		window.show();
	}

	@Override
	public void start(Stage primaryStage) {
//		window = primaryStage;
//		window.setTitle("JavaFX - Tutorials Face");
//		button = new Button("Click Me");
//
//		button.setOnAction(e -> {
//			boolean result = ConfirmBox.display("Title of Window", "Are you sure you want to send that pic?");
//			System.out.println(result);
//		});
//
//		StackPane layout = new StackPane();
//		layout.getChildren().add(button);
//		Scene scene = new Scene(layout, 300, 250);
//		window.setScene(scene);
//		window.show();

//		window = primaryStage;
//		window.setTitle("TutorialsFace");
//
//		//Form
//		TextField ageInput = new TextField();
//
//		button = new Button("Click me");
//		button.setOnAction( e -> isInt(ageInput, ageInput.getText()) );
//
//		//Layout
//		VBox layout = new VBox(10);
//		layout.setPadding(new Insets(20, 20, 20, 20));
//		layout.getChildren().addAll(ageInput, button);
//
//		scene = new Scene(layout, 300, 250);
//		window.setScene(scene);
//		window.show();

		window = primaryStage;
		window.setTitle("Publisher");

		//GridPane with 10px padding around edge
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		//Name Label - constrains use (child, column, row)
		Label lblServer = new Label("Server URL:");
		GridPane.setConstraints(lblServer, 0, 0);

		//Name Input
		TextField txtServer = new TextField("");
		txtServer.setPromptText("Server URL");
		GridPane.setConstraints(txtServer, 1, 0);


		//Name Label - constrains use (child, column, row)
		Label lblUserName = new Label("Username:");
		GridPane.setConstraints(lblUserName, 0, 1);

		//Name Input
		TextField txtUserName = new TextField("sa");
		txtUserName.setPromptText("User Name");
		GridPane.setConstraints(txtUserName, 1, 1);


		//Password Label
		Label lblPassword = new Label("Password:");
		GridPane.setConstraints(lblPassword, 0, 2);

		//Password Input
		TextField txtPassword = new TextField("");
		txtPassword.setPromptText("password");
		GridPane.setConstraints(txtPassword, 1, 2);

		Label lblDBName = new Label("DataBase:");
		GridPane.setConstraints(lblDBName, 0, 3);

		TextField txtDBName = new TextField("AllPublisher");
		txtDBName.setPromptText("DataBase Name");
		GridPane.setConstraints(txtDBName, 1, 3);

		//Login
		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 4);

		loginButton.setOnAction(e->testConn(txtServer.getText(),txtUserName.getText(),txtPassword.getText(),txtDBName.getText()));

		//Add everything to grid
		grid.getChildren().addAll(lblServer, txtServer, lblUserName, txtUserName,lblPassword,txtPassword, loginButton,lblDBName,txtDBName);

		Scene scene = new Scene(grid, 300, 300);
		window.setScene(scene);
		window.show();
	}

	//Validate age
	private boolean isInt(TextField input, String message){
		try{
			int age = Integer.parseInt(input.getText());
			System.out.println("User is: " + age);
			return true;
		}catch(NumberFormatException e){
			System.out.println("Error: " + message + " is not a number");
			return false;
		}
	}

	private void testConn(String url,String user,String password,String dbName)
	{
		connectionUrl = String.format("jdbc:sqlserver://%s;database=%s;user=%s;password=%s", url,dbName,user,password);
		ResultSet resultSet = null;
		String connectionUrl1 =
				"jdbc:sqlserver://11.22.33.44:1433;"
						+ "database=webdemo;"
						+ "user=sa;"
						+ "password="
						//+ "encrypt=true;"
						//+ "trustServerCertificate=false;"
						+ "loginTimeout=30;";

		try (Connection connection = DriverManager.getConnection(connectionUrl);)
		{
			Statement statement = connection.createStatement();
			// Code here.
			//System.out.println("done");
			// Create and execute a SELECT SQL statement.
//			String selectSql = "select top 10 bo_id,bo_code,bo_title_ar,bo_title_fg from p_books where bo_com_id=1";
//			resultSet = statement.executeQuery(selectSql);
//
//			// Print results from select statement
//			while (resultSet.next()) {
//				System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
//			}

			buildSecondScreen();
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
			AlertBox.display("Connection Error !!", e.getMessage());
		}
	}

	private void buildSecondScreen()
	{
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		Label lblCode = new Label("Book Code:");
		GridPane.setConstraints(lblCode, 0, 0);

		//Name Input
		TextField txtCode = new TextField("");
		txtCode.setPromptText("Book Code");
		GridPane.setConstraints(txtCode, 1, 0);

		Button btnSearch = new Button("Search");
		GridPane.setConstraints(btnSearch, 2, 0);

		btnSearch.setOnAction(e->searchBook(txtCode.getText()));

		Label lblBookId = new Label("Book ID:");
		GridPane.setConstraints(lblBookId, 0, 1);

		//Name Input
		txtBookId = new TextField("");
		txtCode.setPromptText("Book ID");
		GridPane.setConstraints(txtBookId, 1, 1);

		Label lblBookName = new Label("Book Name:");
		GridPane.setConstraints(lblBookName, 0, 2);

		//Name Input
		txtBookName = new TextField("");
		txtBookName.setPromptText("Book Name");
		GridPane.setConstraints(txtBookName, 1, 2);

		Button btnAddBook = new Button("Move Book");
		GridPane.setConstraints(btnAddBook, 1, 3);

		btnAddBook.setOnAction(e->addNewBook());


		grid.getChildren().addAll(lblCode, txtCode,btnSearch,lblBookId,txtBookId,lblBookName,txtBookName,btnAddBook);

		//Layout 2
		//StackPane layout2 = new StackPane();
		//layout2.getChildren().add(button2);
		scene2 = new Scene(grid, 600, 300);
		window.setScene(scene2);
	}

	private void searchBook(String bookCode)
	{
		boolean bookFound=false;
		ResultSet resultSet = null;
txtBookName.setText("");
txtBookId.setText("");
		try (Connection connection = DriverManager.getConnection(connectionUrl);)
		{
			Statement statement = connection.createStatement();
			String selectSql = "select bo_id,bo_code,bo_title_ar,bo_title_fg from p_books where bo_com_id=1 and bo_code='"+bookCode+"'";
			resultSet = statement.executeQuery(selectSql);

			// Print results from select statement
			while (resultSet.next()) {
				bookFound=true;
				System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
				txtBookId.setText(resultSet.getString(1));
				txtBookName.setText(resultSet.getString(4));
			}

			if(!bookFound){
				AlertBox.display("Book Code not found", "Book code not found!");
			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
			AlertBox.display("Connection Error !!", e.getMessage());
		}
	}

	private void addNewBook()
	{
		try (Connection connection = DriverManager.getConnection(connectionUrl);)
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = null;
			String sql="select * into #Temp from p_books where bo_id=" + txtBookId.getText();
			statement.executeUpdate(sql);

			sql="update #TEMP set bo_subtitle2_fg='test',bo_com_id=2";
			statement.executeUpdate(sql);

			sql="select bo_com_id,bo_subtitle2_fg, * from #Temp";
			resultSet = statement.executeQuery(sql);


			// Print results from select statement
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
			}

//			String insertSql = "INSERT INTO p_books (Name, ProductNumber, Color, StandardCost, ListPrice, SellStartDate) VALUES "
//					+ "('NewBike', 'BikeNew', 'Blue', 50, 120, '2016-01-01');";
//


			PreparedStatement prepsInsertProduct = connection.prepareStatement(insertBook(), Statement.RETURN_GENERATED_KEYS);

			prepsInsertProduct.execute();
			// Retrieve the generated key from the insert.
			resultSet = prepsInsertProduct.getGeneratedKeys();
			int newBookID=0;
			// Print the ID of the inserted row.
			while (resultSet.next()) {
				newBookID=resultSet.getInt(1);
				System.out.println("Generated: " + resultSet.getString(1));
			}

			if(newBookID>0){
				sql="INSERT INTO p_adjustment ([adj_type]\n" +
						"           ,[adj_date]\n" +
						"           ,[adj_book_id]\n" +
						"           ,[adj_book_desc]\n" +
						"           ,[adj_qty_ori]\n" +
						"           ,[adj_qty_plus]\n" +
						"           ,[adj_qty_min]\n" +
						"           ,[adj_qty]\n" +
						"           ,[adj_desc])" +
						" VALUES ('ADJ' , getdate(), %d , %s , 0 , 0 ,0,0,'Close Arkam' " +
						" ) ";
				statement.executeUpdate(String.format(sql,newBookID,"'"+txtBookName.getText()+"'"));
			}


		}
		catch (SQLException e) {
			e.printStackTrace();
			AlertBox.display("Connection Error !!", e.getMessage());
		}

	}

	private String insertBook()
	{
		String sql="INSERT INTO p_books " +
				" (\n" +
				"           [bo_code]\n" +
				"           ,[bo_title_ar]\n" +
				"           ,[bo_title_fg]\n" +
				"           ,[bo_subtitle1_ar]\n" +
				"           ,[bo_subtitle1_fg]\n" +
				"           ,[bo_subtitle2_ar]\n" +
				"           ,[bo_subtitle2_fg]\n" +
				"           ,[bo_desc]\n" +
				"           ,[bo_isbn]\n" +
				"           ,[bo_barcode]\n" +
				"           ,[bo_nb_pages]\n" +
				"           ,[bo_nb_mal]\n" +
				"           ,[bo_nb_vol]\n" +
				"           ,[bo_price_sal]\n" +
				"           ,[bo_price_pur]\n" +
				"           ,[bo_cost]\n" +
				"           ,[bo_discount]\n" +
				"           ,[bo_allowed]\n" +
				"           ,[bo_paint_title]\n" +
				"           ,[bo_remarks]\n" +
				"           ,[bo_char_id]\n" +
				"           ,[bo_char_desc]\n" +
				"           ,[bo_nb_cart]\n" +
				"           ,[bo_col_id]\n" +
				"           ,[bo_col_desc]\n" +
				"           ,[bo_size_id]\n" +
				"           ,[bo_size_desc]\n" +
				"           ,[bo_weight]\n" +
				"           ,[bo_lg_id]\n" +
				"           ,[bo_lg_desc]\n" +
				"           ,[bo_sub_id]\n" +
				"           ,[bo_sub_desc]\n" +
				"           ,[bo_rel_id]\n" +
				"           ,[bo_rel_desc]\n" +
				"           ,[bo_pap_id]\n" +
				"           ,[bo_pap_desc]\n" +
				"           ,[bo_cov_id]\n" +
				"           ,[bo_cov_desc]\n" +
				"           ,[bo_stk_qty]\n" +
				"           ,[bo_dt_stk_entry]\n" +
				"           ,[bo_img]\n" +
				"           ,[bo_editor_id]\n" +
				"           ,[bo_editor_desc]\n" +
				"           ,[bo_mmm_id]\n" +
				"           ,[bo_mmm_desc]\n" +
				"           ,[bo_min_stock]\n" +
				"           ,[bo_price_sal_2]\n" +
				"           ,[bo_is_print]\n" +
				"           ,[bo_print_year]\n" +
				"           ,[bo_com_id]\n" +
				"           ,[bo_old_id]\n" +
				"           ,[bo_location1]\n" +
				"           ,[bo_location2])\n" +
				"     select \n" +
				"     [bo_code]\n" +
				"           ,[bo_title_ar]\n" +
				"           ,[bo_title_fg]\n" +
				"           ,[bo_subtitle1_ar]\n" +
				"           ,[bo_subtitle1_fg]\n" +
				"           ,[bo_subtitle2_ar]\n" +
				"           ,[bo_subtitle2_fg]\n" +
				"           ,[bo_desc]\n" +
				"           ,[bo_isbn]\n" +
				"           ,[bo_barcode]\n" +
				"           ,[bo_nb_pages]\n" +
				"           ,[bo_nb_mal]\n" +
				"           ,[bo_nb_vol]\n" +
				"           ,[bo_price_sal]\n" +
				"           ,[bo_price_pur]\n" +
				"           ,[bo_cost]\n" +
				"           ,[bo_discount]\n" +
				"           ,[bo_allowed]\n" +
				"           ,[bo_paint_title]\n" +
				"           ,[bo_remarks]\n" +
				"           ,[bo_char_id]\n" +
				"           ,[bo_char_desc]\n" +
				"           ,[bo_nb_cart]\n" +
				"           ,[bo_col_id]\n" +
				"           ,[bo_col_desc]\n" +
				"           ,[bo_size_id]\n" +
				"           ,[bo_size_desc]\n" +
				"           ,[bo_weight]\n" +
				"           ,[bo_lg_id]\n" +
				"           ,[bo_lg_desc]\n" +
				"           ,[bo_sub_id]\n" +
				"           ,[bo_sub_desc]\n" +
				"           ,[bo_rel_id]\n" +
				"           ,[bo_rel_desc]\n" +
				"           ,[bo_pap_id]\n" +
				"           ,[bo_pap_desc]\n" +
				"           ,[bo_cov_id]\n" +
				"           ,[bo_cov_desc]\n" +
				"           ,[bo_stk_qty]\n" +
				"           ,[bo_dt_stk_entry]\n" +
				"           ,[bo_img]\n" +
				"           ,[bo_editor_id]\n" +
				"           ,[bo_editor_desc]\n" +
				"           ,[bo_mmm_id]\n" +
				"           ,[bo_mmm_desc]\n" +
				"           ,[bo_min_stock]\n" +
				"           ,[bo_price_sal_2]\n" +
				"           ,[bo_is_print]\n" +
				"           ,[bo_print_year]\n" +
				"           ,[bo_com_id]\n" +
				"           ,[bo_old_id]\n" +
				"           ,[bo_location1]\n" +
				"           ,[bo_location2]\n" +
				"      from #temp";

		return sql;
	}
	@Override
	public void stop() {
		springContext.stop();
	}

	//When button is clicked, handle() gets called
	//Button click is an ActionEvent (also MouseEvents, TouchEvents, etc...)
//	@Override
//	public void handle(ActionEvent event) {
//		if (event.getSource() == button)
//			System.out.println("Hey Charlie!");
//	}
}
