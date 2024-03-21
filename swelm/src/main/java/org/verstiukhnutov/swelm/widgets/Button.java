package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.verstiukhnutov.swelm.app.IWidgetCollection;

public class Button extends Widget {

    JButton button;

    public <Msg> Button(IWidgetCollection widgets, String widgetName){
        super(widgets, widgetName);
        button = new JButton();
    }

    public Button text(String text) {
        button.setText(text);
        return this;
    }

    public Button bounds(int x, int y, int width, int height) {
        button.setBounds(x, y, width, height);
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

    @Override
    public Component component() {
        return button;
    }

}
