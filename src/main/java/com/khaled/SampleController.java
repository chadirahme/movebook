package com.khaled;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotEmpty;
import java.sql.*;

@Controller
public class SampleController {

//    @Value("${database}")
//    private String myUrl;

    String connectionUrl;
    @Autowired
    GlobalProperties globalProperties;

    public String getName() {
        return myUrl;
    }

    @FXML
    private WebView myWebView;

    @FXML
    private TextField txtServer;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtDataBase;

    @Value("${my.url}")
    private String myUrl;

    @NotEmpty
    @Value("${app.server}")
    private String server;

    @FXML
    private void initialize() {
        // myWebView.getEngine().load(myUrl);
        txtServer.setText(globalProperties.getServer());
        txtUserName.setText(globalProperties.getUser());
        txtPassword.setText(globalProperties.getPassword());
        txtDataBase.setText(globalProperties.getDatabase());
    }

    @FXML
    private void testConn() {
        System.out.println(txtServer.getText());
        connectionUrl = String.format("jdbc:sqlserver://%s;database=%s;user=%s;password=%s",
                txtServer.getText(),txtDataBase.getText(),txtUserName.getText(),txtPassword.getText());
        ResultSet resultSet = null;
        String connectionUrl1 =
                "jdbc:sqlserver://12.13.14.15:1433;"
                        + "database=webdemo;"
                        + "user=sa;"
                        + "password=Password;"
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
        catch (Exception e) {
            e.printStackTrace();
            AlertBox.display("Loading Error !!", e.getMessage());
        }
    }

    private void buildSecondScreen()throws Exception {

        SpringFxmlLoader springFxmlLoader=new SpringFxmlLoader();

        //FXMLLoader fxmlLoader =(FXMLLoader)springFxmlLoader.load("/fxml/move.fxml","/fxml/move.fxml");
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/fxml/move.fxml"));
       // Parent root = (Parent) springFxmlLoader.load("/fxml/move.fxml","mycompany/imageviewer/bundle/bundle");
       // firstLoader.setController(new MoveController(connectionUrl));



        Parent firstUI = firstLoader.load();

        MoveController moveController= (MoveController)firstLoader.getController();
        moveController.connString=connectionUrl;

        Scene scene = new Scene(firstUI);
        // FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/move.fxml"));
        //Parent rootNode = fxmlLoader.load();
        Stage stage = (Stage)txtServer.getScene().getWindow();//or use any other component in your controller
        //Scene scene = new Scene(fxmlLoader.load());
        //Scene mainCallWindow = new Scene (fxmlLoader, 800, 600);

        stage.setScene(scene);

    }

}