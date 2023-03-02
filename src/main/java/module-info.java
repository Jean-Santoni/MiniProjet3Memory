module com.example.miniprojet3memory {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.miniprojet3memory to javafx.fxml;
    exports com.example.miniprojet3memory;
}