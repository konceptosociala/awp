package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.Border;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;

public class Button extends Widget {

    private JButton button;

    public Button(IWidgetCollection widgets, String widgetName){
        super(widgets, widgetName);
        button = new JButton();
    }

    public Button text(String text) {
        setText(text);
        return this;
    }

    public <Msg> Button clicked(ConstructWidget<Msg> app, Msg msg) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.event(msg);
            }
        });
        return this;
    }

    public void setText(String text) {
        button.setText(text);
    }

    @Override
    public void setSize(Size size) {
        button.setSize(size.width, size.height);
    }

    @Override
    public void setPosition(Pos pos) {
        button.setLocation(pos.x, pos.y);
    }

    @Override
    public void setBackground(Color color) {
        button.setBackground(color);
    }

    @Override
    public void setForeground(Color color) {
        button.setForeground(color);
    }

    @Override
    public void setBorder(Border border) {
        button.setBorder(border);
    }

    @Override
    public void setVisible(boolean visible) {
        button.setVisible(visible);
    }

    @Override
    public Button size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public Button position(Pos pos) {
        setPosition(pos);
        return this;
    }

    @Override
    public Button background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public Button foreground(Color color) {
        setForeground(color);
        return this;
    }

    @Override
    public Button border(Border border) {
        setBorder(border);
        return this;
    }

    @Override
    public Button visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    @Override
    public Component component() {
        return button;
    }

}
