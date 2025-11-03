module com.example.stargame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stargame to javafx.fxml;
    exports com.example.stargame;
}