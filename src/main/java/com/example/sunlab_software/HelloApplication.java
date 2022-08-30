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

    @FXML TextField username;
    @FXML TextField password;
    @FXML Button signIn;
    @FXML Label connected;

    @FXML ChoiceBox<String> menuChoice;
    @FXML Button confirmChoice;

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

        Stage stage = new Stage();
        FXMLLoader loginPage = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        loginPage.setController(this);
        Parent root = loginPage.load();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
        menu();
    }

    @FXML
    public void confirmAction() throws Exception{
        String userChoice = menuChoice.getValue();
        Statement stmt = conn.createStatement();
        Scanner scan = new Scanner(System.in);

        switch (userChoice){
            case "Search by ID":
                break;
            case "Search by Date":
                break;
            case "Search by Time Range":
                break;
            case "Update Student Status":
                break;
            case "Browse all Logs":
                break;
        }
    }

    public void menu() throws SQLException, IOException {
        String[] whatToDo = {"Search by ID", "Search by Date", "Search by Time Range", "Update Student Status", "Browse all Logs"};
        menuChoice.getItems().addAll(whatToDo);
    }

}