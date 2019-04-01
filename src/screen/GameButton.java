package screen;

import java.awt.Color;
import javax.swing.JButton;
import data.Game;

public class GameButton extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Game g;
	public GameButton(Game g)
	{
		this.g = g;
		setText(g.name);
		setBackground(new Color(75, 80, 95));
		setForeground(Color.WHITE);
	}
}