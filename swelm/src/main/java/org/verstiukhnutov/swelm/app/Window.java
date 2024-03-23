package org.verstiukhnutov.swelm.app;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.verstiukhnutov.swelm.widgets.Widget;

public class Window {
    
    private JFrame frame;

    public Window() {
        frame = new JFrame();
        frame.setTitle("My app");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setTitle(String title) {
        frame.setTitle(title);
    }

    public void setSize(int width, int height) {
        frame.setSize(width, height);
    }

    public void setPosition(int x, int y) {
        frame.setLocation(x, y);
    }

    public void add(Widget widget) {
        frame.add(widget.component());
    }

    public void run() {
        frame.setVisible(true);
    }
}
