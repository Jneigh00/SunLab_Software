module com.example.sunlab_software {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.oracle.database.jdbc;
    requires java.naming;

    opens com.example.sunlab_software to javafx.fxml;
    exports com.example.sunlab_software;
}