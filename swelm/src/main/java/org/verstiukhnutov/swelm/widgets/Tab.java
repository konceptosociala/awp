package org.verstiukhnutov.swelm.widgets;

public class Tab {

    private String label;
    private Panel panel;

    public Tab(String label, Panel panel) {
        this.label = label;
        this.panel = panel;
    }

    public String getLabel() {
        return label;
    }

    public Panel getPanel() {
        return panel;
    }
}
