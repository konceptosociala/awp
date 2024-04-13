package org.verstiukhnutov.swelm.widgets.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextField;

public class JPlaceholderTextField extends JTextField {

	private String placeholder;

	public JPlaceholderTextField(String placeholder) {
		this.placeholder = placeholder;
	}
	
	public JPlaceholderTextField() {
		this.placeholder = null;
	}

	/**
	 * Gets text, returns placeholder if nothing specified
	 */
	@Override
	public String getText() {
		String text = super.getText();

		if (text.trim().isEmpty() && placeholder != null) {
			text = placeholder;
		}

		return text;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (!super.getText().isEmpty() || placeholder == null) {
			return;
		}
		
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(super.getDisabledTextColor());
		g2.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent()/4 + getInsets().top/2 + getHeight()/2);
	}
}
