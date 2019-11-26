package com.khaled;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotEmpty;


@Component
//@Configuration
@ConfigurationProperties(prefix = "app")
public class GlobalProperties {

    @NotEmpty
    private String database;
    private String server;
    private String user;
    private String password;


    public String getDatabase(){
        return database;
    }
    public void setDatabase(String value)
    {
        database=value;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
