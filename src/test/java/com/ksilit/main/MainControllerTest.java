package com.ksilit.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ksilit.core.InjectorModule;
import com.ksilit.core.StageManager;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainControllerTest extends ApplicationTest {
    private Stage stage;

    @Override
    public void start(final Stage stage) throws IOException {
        this.stage = stage;

        final StageManager stageManager = new StageManager(stage);
        final Injector injector = Guice.createInjector(new InjectorModule());
        stageManager.setInjector(injector);
        stageManager.showMainStage();
    }

    @Test
    void shouldHasValidInitialState() {
        // Given
        final String titleExpected = "ksilit";

        // Then
        final String titleActual = stage.getTitle();
        assertEquals(titleExpected, titleActual);
    }
}
