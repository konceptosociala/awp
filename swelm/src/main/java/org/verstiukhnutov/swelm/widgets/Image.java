package org.verstiukhnutov.swelm.widgets;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.ResourceImage;
import org.verstiukhnutov.swelm.utils.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Image extends Widget {
    private ImageIcon image;

    public Image(IWidgetCollection widgets, String widgetName, ResourceImage resourceImage) {
        super(widgets, widgetName);
        this.image = resourceImage.toIcon();
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Image image(ImageIcon image) {
        this.image = image;
        return this;
    }

    @Override
    public void setSize(Size size) {
        super.setSize(size);
        if (image != null) {
            image.setImage(image.getImage().getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH));
        }
    }

    @Override
    public Image size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public Component component() {
        return new JLabel(image);
    }
}
