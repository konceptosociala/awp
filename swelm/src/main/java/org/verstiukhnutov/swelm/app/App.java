package org.verstiukhnutov.swelm.app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import io.materialtheme.darkstackoverflow.DarkStackOverflowTheme;
import mdlaf.MaterialLookAndFeel;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;

public class App<Msg> {

    static {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new DarkStackOverflowTheme()));
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    Window window;

    public App(ConstructWidget<Msg> appWidget) {
        window = new Window();
        window.add(appWidget);
    }

    public App<Msg> title(String title) {
        window.setTitle(title);
        return this;
    }

    public App<Msg> size(int width, int height) {
        window.setSize(width, height);
        return this;
    }

    public App<Msg> position(int x, int y) {
        window.setPosition(x, y);
        return this;
    }

    public void run() {
        window.run();
    }

}
