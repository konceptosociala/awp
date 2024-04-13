package org.verstiukhnutov.swelm.widgets.menu;

import java.awt.Component;
import java.awt.event.*;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;

public class SingleItem extends MenuItem {

    private JMenuItem item;

    public SingleItem(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        item = new JMenuItem();
    }

    public SingleItem text(String text) {
        setText(text);
        return this;
    }

    public <Msg> SingleItem clicked(ConstructWidget<Msg> app, Msg msg) {
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.event(msg);
            }
        });
        return this;
    }

    public void setText(String text) {
        item.setText(text);
    }

    @Override
    public void setSize(Size size) {
        item.setSize(size.width, size.height);
    }

    @Override
    public void setPosition(Pos pos) {
        item.setLocation(pos.x, pos.y);
    }

    @Override
    public void setBackground(Color color) {
        item.setBackground(color);
    }

    @Override
    public void setForeground(Color color) {
        item.setForeground(color);
    }

    @Override
    public void setBorder(Border border) {
        item.setBorder(border);
    }

    @Override
    public void setVisible(boolean visible) {
        item.setVisible(visible);
    }

    @Override
    public SingleItem size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public SingleItem position(Pos pos) {
        setPosition(pos);
        return this;
    }

    @Override
    public SingleItem background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public SingleItem foreground(Color color) {
        setForeground(color);
        return this;
    }

    @Override
    public SingleItem border(Border border) {
        setBorder(border);
        return this;
    }

    @Override
    public SingleItem visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    @Override
    public Component component() {
        return item;
    }
    
}
