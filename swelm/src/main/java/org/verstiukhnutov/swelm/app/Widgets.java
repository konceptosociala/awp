package org.verstiukhnutov.swelm.app;

import java.util.HashMap;

import javax.swing.JOptionPane;

import org.verstiukhnutov.swelm.widgets.Widget;

public class Widgets implements IWidgetCollection {

    private HashMap<String, Widget> widgets;

    public Widgets() {
        widgets = new HashMap<>();
    }

    @Override
    public void addWidget(String widgetName, Widget widget) {
        widgets.put(widgetName, widget);
    }

    @Override
    public Widget getWidget(String widgetName) {
        return widgets.get(widgetName);
    }

    public final void dumpWidgets(DumpMode mode) {
        String dump = "";

        for (String widgetName : widgets.keySet()) {
            Widget widget = widgets.get(widgetName);
            dump += widgetName + ": " + widget.getClass().getSimpleName() + "\n";
        }

        dump = dump.trim();

        switch (mode) {
            case Console:
                System.out.println(dump);
                break;
        
            case GUI:
                JOptionPane.showMessageDialog(null, dump, "Widgets dump", JOptionPane.INFORMATION_MESSAGE);
                break;

            default:
                break;
        }
    }
    
}
