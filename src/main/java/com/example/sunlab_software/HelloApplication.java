package com.example.sunlab_software;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
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

    //Login Page
    @FXML TextField username;
    @FXML TextField password;
    @FXML Button signIn;
    @FXML Label connected;

    //Menu Page
    @FXML ChoiceBox<String> menuChoice;
    @FXML Button confirmChoice;

    //For Browsing Customers
    @FXML TableView<Logs> browseLogs;
    @FXML TableColumn<Logs, String> IdCol;
    @FXML TableColumn<Logs, String> NameCol;
    @FXML TableColumn<Logs, String> JobCol;
    @FXML TableColumn<Logs, String> DateCol;
    @FXML TableColumn<Logs, String> TImeCol;
    ObservableList<Logs> data = FXCollections.observableArrayList();


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
                Stage stage = new Stage();
                FXMLLoader searchID = new FXMLLoader(HelloApplication.class.getResource("searchById.fxml"));
                searchID.setController(this);
                Parent root = searchID.load();
                Scene scene = new Scene(root, 600, 400);
                stage.setTitle("Search by ID");
                stage.setScene(scene);
                stage.show();
                break;
            case "Search by Date":
                Stage stage1 = new Stage();
                FXMLLoader searchDate = new FXMLLoader(HelloApplication.class.getResource("searchByDate.fxml"));
                searchDate.setController(this);
                Parent root1 = searchDate.load();
                Scene scene1 = new Scene(root1, 600,400);
                stage1.setTitle("Search by Date");
                stage1.setScene(scene1);
                stage1.show();
                break;
            case "Search by Time Range":
                Stage stage2 = new Stage();
                FXMLLoader searchRange = new FXMLLoader(HelloApplication.class.getResource("searchByRange.fxml"));
                searchRange.setController(this);
                Parent root2 = searchRange.load();
                Scene scene2 = new Scene(root2, 600,400);
                stage2.setTitle("Search by Time Range");
                stage2.setScene(scene2);
                stage2.show();
                break;
            case "Update Student Status":
                Stage stage3 = new Stage();
                FXMLLoader updateStatus = new FXMLLoader(HelloApplication.class.getResource("updateStudent.fxml"));
                updateStatus.setController(this);
                Parent root3 = updateStatus.load();
                Scene scene3 = new Scene(root3, 600, 400);
                stage3.setTitle("Update Student Status");
                stage3.setScene(scene3);
                stage3.show();
                break;
            case "Browse all Logs":
                Stage stage4 = new Stage();
                FXMLLoader browseLogsScene = new FXMLLoader(HelloApplication.class.getResource("BrowseLogs.fxml"));
                browseLogsScene.setController(this);
                Parent root4 = browseLogsScene.load();
                Scene scene4 = new Scene(root4, 600,400);
                stage4.setTitle("Browse Logs");
                stage4.setScene(scene4);
                stage4.show();

                ResultSet browse = stmt.executeQuery("Select * from SunLabLogs");
                ResultSetMetaData browseData = browse.getMetaData();
                browseLogs.getColumns().clear();
                data.clear();
                while(browse.next()) {
                    Logs current = new Logs(browse.getString(1), browse.getString(2), browse.getString(3), browse.getString(4),
                            browse.getString(5));
                    data.add(current);
                }
                    IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
                    NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
                    JobCol.setCellValueFactory(new PropertyValueFactory<>("Job"));
                    DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
                    TImeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
                    browseLogs.setItems(data);
                    browseLogs.getColumns().addAll(IdCol, NameCol, JobCol, DateCol, TImeCol);

                break;
        }
    }

    public void menu() throws SQLException, IOException {
        String[] whatToDo = {"Search by ID", "Search by Date", "Search by Time Range", "Update Student Status", "Browse all Logs"};
        menuChoice.getItems().addAll(whatToDo);
    }


    @FXML Button search;
    @FXML TextField IdSearch;

    @FXML
    public void searchID() throws Exception{

    }



    @FXML
    public void suspendStudent(){

    }

    @FXML
    public void activateStudent(){

    }

}