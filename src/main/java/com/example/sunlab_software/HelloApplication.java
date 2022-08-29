package com.example.sunlab_software;

import oracle.jdbc.pool.OracleDataSource;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.event.*;






public class HelloApplication extends Application {

    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    Button signIn;
    @FXML
    Label connected;

    public static Connection conn;
    public static OracleDataSource ods;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {

        System.out.print("Connecting to the database...");
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//h3oracle.ad.psu.edu:1521/orclpdb.ad.psu.edu");
        launch();
    }

    @FXML
    public void signInAction() throws Exception {
        ods.setUser(username.getText());
        ods.setPassword(password.getText());
        conn = ods.getConnection();
        System.out.println("Connected ");
        connected.setText("Connected");
    }


}