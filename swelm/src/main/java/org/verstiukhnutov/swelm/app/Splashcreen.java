package org.verstiukhnutov.swelm.app;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import org.verstiukhnutov.swelm.utils.ResourceImage;

public class Splashcreen {

    private JWindow window;
    private int duration;

    public Splashcreen(int width, int height, ImageIcon imageIcon, int duration) {
        window = new JWindow();
        window.getContentPane().add(
            new JLabel(imageIcon, SwingConstants.CENTER)
        );
        window.setSize(width, height);
        window.setLocationRelativeTo(null);
        this.duration = duration;
    }

    public Splashcreen(int width, int height, ResourceImage resourceImage, int duration) {
        this(width, height, resourceImage.toIcon(), duration);
    }

    public Splashcreen(int width, int height, String imagePath, int duration) {
        this(width, height, new ImageIcon(imagePath), duration);
    }

    public void show() {
        window.setVisible(true);
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
        window.dispose();
    }
}
