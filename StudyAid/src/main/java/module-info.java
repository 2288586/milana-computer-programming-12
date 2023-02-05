module com.studyaid.studyaid {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.studyaid.studyaid to javafx.fxml;
    exports com.studyaid.studyaid;
}