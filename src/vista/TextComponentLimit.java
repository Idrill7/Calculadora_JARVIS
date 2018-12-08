package vista;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class TextComponentLimit extends PlainDocument {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3534704465898969990L;
	private int charactersLimit;
	/**
	 * Esta es la clase TextComponentLimit, extiende de PlainDocument y usaremos el metodo
	 * addTO() para aniadir un limite de caracteres a un componente, en nuestro caso a las JTextField
	 * 
	 *
	 */
	private TextComponentLimit(int charactersLimit) {
		this.charactersLimit = charactersLimit;
	}

	@Override
	public void insertString(int offset, String input, AttributeSet attributeSet) throws BadLocationException {
		if (isAllowed(input)) {
			super.insertString(offset, input, attributeSet);
		} else {
			Toolkit.getDefaultToolkit().beep();
		}
	}

	private boolean isAllowed(String string) {
		return (getLength() + string.length()) <= charactersLimit;
	}

	public static void addTo(JTextComponent textComponent, int charactersLimit) {
		TextComponentLimit textFieldLimit = new TextComponentLimit(charactersLimit);
		textComponent.setDocument(textFieldLimit);
	}
}