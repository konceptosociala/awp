package org.verstiukhnutov.swelm.widgets.ui;

import org.verstiukhnutov.swelm.utils.Color;

import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;


public class SwelmTabbedPaneUI extends BasicTabbedPaneUI {
    @Override
    protected void installDefaults() {
        super.installDefaults();
        tabAreaInsets = new Insets(0, 0, 0, 0);
        tabInsets = new Insets(5, 50, 5, 50);
        selectedTabPadInsets = new Insets(0, 0, 0, 0);
        contentBorderInsets = new Insets(0, 0, 0, 0);
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        if (isSelected) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x, y, w, h);
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(x, y, w, h);
        }
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
        super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {

    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
    }

    @Override
    protected void paintContentBorder(Graphics graphics, int tabPlacement, int selectedIndex) {
        int width = tabPane.getWidth();
        Insets insets = tabPane.getInsets();

        int x = insets.left;
        int y = insets.top;
        int w = width - insets.right - insets.left;
        int tabAreaHeight = calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);

        graphics.setColor(Color.LIGHT_GRAY);
        Graphics2D g2d = (Graphics2D) graphics;
        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(3));

        g2d.drawLine(x, y + tabAreaHeight, x + w, y + tabAreaHeight);

        g2d.setStroke(oldStroke);
    }
}
