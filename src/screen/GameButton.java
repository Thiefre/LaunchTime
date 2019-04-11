package screen;

import java.awt.Color;
import java.io.File;

import javax.swing.JButton;
import javax.swing.filechooser.FileSystemView;

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
		setIcon(FileSystemView.getFileSystemView().getSystemIcon(new File(g.path)));
		setBackground(new Color(75, 80, 95));
		setForeground(Color.WHITE);
	}
}