package org.verstiukhnutov.swelm.utils;

import javax.swing.border.Border;

public interface AdjustableWidget {
    
    public void setSize(Size size); 

    public void setPosition(Pos pos);

    public void setBackground(Color color);

    public void setForeground(Color color);

    public void setBorder(Border border);

    public void setAlignmentX(float alignmentX);

    public void setAlignmentY(float alignmentY);

    public void setVisible(boolean visible);

    public AdjustableWidget size(Size size); 

    public AdjustableWidget position(Pos pos);

    public AdjustableWidget background(Color color);

    public AdjustableWidget foreground(Color color);

    public AdjustableWidget border(Border border);

    public AdjustableWidget alignmentX(float alignmentX);

    public AdjustableWidget alignmentY(float alignmentY);

    public AdjustableWidget visible(boolean visible);

}
