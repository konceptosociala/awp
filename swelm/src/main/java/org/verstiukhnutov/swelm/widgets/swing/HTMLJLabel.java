package org.verstiukhnutov.swelm.widgets.swing;

import javax.swing.JLabel;
import java.awt.Font;

public class HTMLJLabel extends JLabel {
    boolean wrapText = false;

    public HTMLJLabel(String text) {
        super(text);
        updateTextWithHTML(text);
    }

    private void updateTextWithHTML(String text) {
        String htmlText = "<html><body style='" + getStyle() + "'>" + text + "</body></html>";
        super.setText(htmlText);
    }

    private String getStyle() {
        StringBuilder style = new StringBuilder();
        Font font = getFont();
        if (font != null) {
            String fontString = String.format("font-family:%s; font-size:%dpt; font-weight:%s;",
                    font.getFamily(), font.getSize(), font.isBold() ? "bold" : "normal");
            style.append(fontString);
        }
        style.append("width: ").append(getPreferredSize()).append(";");
        if (wrapText) {
//            style.append("white-space: normal;");
        } else {
            style.append("white-space: nowrap;");
        }

        return style.toString();
    }

    @Override
    public void setText(String text) {
        updateTextWithHTML(text);
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
        setText(getText());
    }

    public void setWrapText(boolean wrapText) {
        this.wrapText = wrapText;
    }
}
