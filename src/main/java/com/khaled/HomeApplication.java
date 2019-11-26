package com.khaled;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ComponentScan("com.khaled")
//@EnableConfigurationProperties(GlobalProperties.class)
public class HomeApplication extends Application {

    private ConfigurableApplicationContext springContext;
    Stage window;
    Scene scene,scene1, scene2;
    private FXMLLoader fxmlLoader;
    private Parent rootNode;


    @Value("${my.url}")
    private String myUrl2;

    @Value("${database}")
    private String myUrl;

    //@Autowired
    SampleController sampleController;
  //  MoveController moveController;

    //@Autowired
    GlobalProperties globalProperties;

//    	public static void main(String[] args) {
//		SpringApplication.run(HomeApplication.class, args);
//	}

    public static void main(String[] args) {
        launch(args); // It calls start method defined bellow...
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(HomeApplication.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
        sampleController=  springContext.getBean(SampleController.class);
       // moveController=  springContext.getBean(MoveController.class);
        globalProperties=  springContext.getBean(GlobalProperties.class);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoader.setLocation(getClass().getResource("/fxml/main.fxml"));
        rootNode = fxmlLoader.load();

        primaryStage.setTitle("Publisher");
        Scene scene = new Scene(rootNode);// 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println("url>> "+sampleController.getName());
        System.out.println("url>> "+globalProperties.getDatabase());

//
//
//        window = primaryStage;
//        //Button 1
//       // GlobalProperties globalProperties=new GlobalProperties();
//        Label label1 = new Label("Welcome to the first scene! "); //+globalProperties.getDatabase());
//        Button button1 = new Button("Go to scene 2");
//        String test = "";//sampleController.getName();
//        button1.setOnAction(e -> AlertBox.display("Title of Window", "Wow this alert box is awesome!" + test));
//
//        //button1.setOnAction(e -> window.setScene(scene2));
//
//        //Layout 1 - children laid out in vertical column
//        VBox layout1 = new VBox(20);
//        layout1.getChildren().addAll(label1, button1);
//        scene1 = new Scene(layout1, 600, 300);
//
//
//        //Button 2
//        Button button2 = new Button("This sucks, go back to scene 1");
//        button2.setOnAction(e -> window.setScene(scene1));
//
//        //Layout 2
//        StackPane layout2 = new StackPane();
//        layout2.getChildren().add(button2);
//        scene2 = new Scene(layout2, 600, 300);
//
//        //Display scene 1 at first
//        window.setScene(scene1);
//        window.setTitle("Title Here");
//        window.show();
    }
}
