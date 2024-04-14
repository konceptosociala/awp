package org.verstiukhnutov.swelm.widgets;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Size;

import javax.swing.*;
import java.awt.*;

public class ComboBox extends Widget {
    private JComboBox<Object> comboBox;
    public ComboBox(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        comboBox = new JComboBox<>();
    }

    public void addItem(Object item) {
        comboBox.addItem(item);
    }

    public void setItems(Object[] items) {
        for (Object item : items) {
            addItem(item);
        }
    }

    public void setSelectedIndex(int index) {
        comboBox.setSelectedIndex(index);
    }

    public void setSelectedItem(Object item) {
        if (item == null) {
            return;
        }
        comboBox.setSelectedItem(item);
    }

    public ComboBox selectedItem(Object item) {
        setSelectedItem(item);
        return this;
    }

    public ComboBox item(Object item) {
        addItem(item);
        return this;
    }

    public ComboBox items(Object[] items) {
        setItems(items);
        return this;
    }

    public ComboBox selectedIndex(int index) {
        setSelectedIndex(index);
        return this;
    }

    public Object getSelectedItem() {
        return comboBox.getSelectedItem();
    }

    @Override
    public ComboBox size(Size size) {
        comboBox.setPreferredSize(new Dimension(size.width, size.height));
        comboBox.setMaximumSize(new Dimension(size.width, size.height));
        return this;
    }

    @Override
    public ComboBox alignmentX(float alignmentX) {
        comboBox.setAlignmentX(alignmentX);
        return this;
    }

    @Override
    public Component component() {
        return comboBox;
    }
}
