package org.verstiukhnutov.swelm.widgets.swing;

import javax.swing.*;
import javax.swing.text.*;

public class TruncatingTextPane extends JTextPane {
    private int maxLines = 1;

    public TruncatingTextPane() {
        this.setEditable(false);
        this.setOpaque(false);
        this.setFocusable(false);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        truncateText();
    }

    public void setMaxLines(int maxLines) {
        this.maxLines = maxLines;
    }

    private void truncateText() {
        try {
            Document doc = getDocument();
            int lineCount = doc.getDefaultRootElement().getElementCount();
            if (lineCount <= maxLines) {
                return;
            }

            Element root = doc.getDefaultRootElement();
            Element line = root.getElement(maxLines - 1); // Get the last allowed line
            int endOffset = line.getEndOffset(); // End of the last allowed line

            // Remove excess text and append ellipsis if needed
            if (doc.getLength() > endOffset) {
                doc.remove(endOffset - 1, doc.getLength() - endOffset + 1);
                doc.insertString(endOffset - 1, "...", null);
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
