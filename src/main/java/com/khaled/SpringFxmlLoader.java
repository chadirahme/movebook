package com.khaled;


import javafx.fxml.FXMLLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.ResourceBundle;

public class SpringFxmlLoader {

//    private static final ApplicationContext applicationContext =
//            new AnnotationConfigApplicationContext(SpringApplication.run(HomeApplication.class));

    public Object load(String url, String resources) {
        FXMLLoader loader = new FXMLLoader();
        //loader.setControllerFactory(clazz -> applicationContext.getBean(clazz));
        loader.setLocation(getClass().getResource(url));
       // loader.setResources(ResourceBundle.getBundle(resources));
        try {
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
