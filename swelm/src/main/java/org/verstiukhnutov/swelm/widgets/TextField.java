package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;
import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.swing.JPlaceholderTextField;

public class TextField extends Widget {

    private JPlaceholderTextField textField;

    public TextField(IWidgetCollection widgets, String widgetName){
        super(widgets, widgetName);
        textField = new JPlaceholderTextField();
    }

    public TextField text(String text) {
        setText(text);
        return this;
    }
    
    public TextField placeholder(String placeholder) {
        setPlaceholder(placeholder);
        return this;
    }

    public void setText(String text) {
        textField.setText(text);
    }

    public void setPlaceholder(String placeholder) {
        textField.setPlaceholder(placeholder);
    }

    @Override
    public Component component() {
        return textField;
    }

}
