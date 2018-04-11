package com.ksilit.core;

import com.google.inject.Injector;
import com.ksilit.main.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static com.google.common.base.Preconditions.checkArgument;

public class StageManager {
    private final Stage primaryStage;
    private Injector injector;

    public StageManager(final Stage primaryStage) {
        checkArgument(primaryStage != null, "'primaryStage' must be defined");

        this.primaryStage = primaryStage;
    }

    public void setInjector(final Injector injector) {
        checkArgument(injector != null, "'injector' must be defined");

        this.injector = injector;
    }

    public void showMainStage() throws IOException {
        final MainController mainController = injector.getInstance(MainController.class);
        mainController.setStage(primaryStage);
        showStage(mainController);
    }

    private void showStage(final MainController mainController) throws IOException {
        final String fxmlPath = mainController.getFxmlPath();
        final URL url = getClass().getResource(fxmlPath);
        final FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setController(mainController);
        final Parent parent = fxmlLoader.load();
        final Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
