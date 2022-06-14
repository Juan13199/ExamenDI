module com.mycompany.examendi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.examendi to javafx.fxml;
    exports com.mycompany.examendi;
}
