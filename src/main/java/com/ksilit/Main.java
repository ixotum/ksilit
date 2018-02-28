package com.ksilit;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ksilit.core.InjectorModule;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("ksilit starting...");

        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final InjectorModule injectorModule = new InjectorModule();
        final Injector injector = Guice.createInjector(injectorModule);
    }
}
