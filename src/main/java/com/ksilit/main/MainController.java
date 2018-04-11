package com.ksilit.main;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.google.common.base.Preconditions.checkArgument;

public class MainController implements Initializable {
    private static final String FXML_PATH = "/main/main.fxml";
    private Stage stage;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        final String title = getTitle();

        stage.setTitle(title);
    }

    public String getFxmlPath() {
        return FXML_PATH;
    }

    public void setStage(final Stage stage) {
        checkArgument(stage != null, "'stage' must be defined");

        this.stage = stage;
    }

    private String getTitle() {
        return "ksilit";
    }
}
