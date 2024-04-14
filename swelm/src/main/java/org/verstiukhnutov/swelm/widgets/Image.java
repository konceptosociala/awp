package org.verstiukhnutov.swelm.widgets;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.ResourceImage;
import org.verstiukhnutov.swelm.utils.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Image extends Widget {
    private ImageIcon image;
    private JLabel iconContainer;

    public Image(IWidgetCollection widgets, String widgetName, ResourceImage resourceImage) {
        super(widgets, widgetName);
        this.image = resourceImage.toIcon();
        this.iconContainer = new JLabel(image);
    }

    public <Msg> Image clicked(ConstructWidget<Msg> app, Msg msg) {
        iconContainer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                app.event(msg);
            }
        });
        return this;
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
        if (size == null) {
            return this;
        }
        setSize(size);
        return this;
    }

    @Override
    public Image alignmentX(float alignmentX) {
        iconContainer.setAlignmentX(alignmentX);
        return this;
    }

    @Override
    public Component component() {
        return iconContainer;
    }
}
