module com.example.yugioh {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires com.fasterxml.jackson.databind;
    requires java.sql;

    opens com.example.yugioh to javafx.fxml;
    exports com.example.yugioh.application;
    exports com.example.yugioh.controllers;
    opens com.example.yugioh.application to javafx.fxml;
    opens com.example.yugioh.controllers to javafx.fxml;
}