package screen;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import data.Game;
import data.GameTree;
import launcher.Launcher;

public class GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CardLayout cardLayout = new CardLayout();

	Color blueTXT = new Color(60, 100, 140);
	Color grayBG = new Color(30, 30, 33);
	Color grayICONS = new Color(43, 43, 52);
	Color grayMENU = new Color(55, 60, 68);
	Color grayBUT = new Color(75, 80, 95);

	public JPanel topPanel = new JPanel();
	public JPanel iconPanel = new JPanel();
	public JPanel mainPanel = new JPanel(new BorderLayout());	
	public JPanel libPanel = new JPanel();
	public JPanel upPanel = new JPanel();

	public JButton syncBut, libBut, upBut;
	public Desktop desktop = Desktop.getDesktop();

	JLabel recent;

	File f = new File("C:/");

	public GUI(String s) {
		super(s);
	}
	
	public void init()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1440, 980);
		
		topPanel.setBackground(grayMENU);
		mainPanel.setBackground(grayBG);
		iconPanel.setBackground(grayICONS);

		syncBut = new JButton("Sync");
		syncBut.setBackground(grayBUT);
		syncBut.setForeground(Color.WHITE);

		libBut = new JButton("Library");
		libBut.setBackground(grayBUT);
		libBut.setForeground(Color.WHITE);	
		upBut = new JButton("Updates");
		upBut.setBackground(grayBUT);
		upBut.setForeground(Color.WHITE);

		actionListener al = new actionListener();
		
		libPanel.setBackground(grayBG);
		libPanel.setLayout(new GridLayout(0,3));
		
		libBut.addActionListener(al);
		upBut.addActionListener(al);
		syncBut.addActionListener(al);

		recent = new JLabel("Recent");
		recent.setForeground(blueTXT);

		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 7));
		topPanel.add(syncBut);
		topPanel.add(libBut);
		topPanel.add(upBut);

		iconPanel.add(recent);

		mainPanel.setLayout(cardLayout);
		
		
		JScrollPane sp = new JScrollPane(libPanel);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setViewportView(libPanel);
		
		mainPanel.add(sp, "Library");
		mainPanel.add(upPanel, "Updates");
		
		cardLayout.show(mainPanel,  "Library");
		

		upPanel.setBackground(grayBG);
		upPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 7));
		JLabel changes = new JLabel("This is LaunchTime version 0.1.");
		changes.setForeground(Color.WHITE);
		upPanel.add(changes);
		
		this.add(mainPanel);
		this.add(topPanel, BorderLayout.NORTH);
		this.add(iconPanel, BorderLayout.WEST);
		this.getContentPane().add(mainPanel);
		this.setVisible(true);
		this.setResizable(true);
	}
	public class actionListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			JButton src = (JButton) event.getSource();

			if(src.equals(syncBut))
			{	
				int reply = JOptionPane.showConfirmDialog(null, "Do you want to sync your system?");
				if(reply == JOptionPane.YES_OPTION)
				{
					launcher.searchAndAdd();
				}
			}
				
			if(src.equals(libBut)) {
				cardLayout.show(mainPanel, "Library");
			}
			if(src.equals(upBut)) {
				cardLayout.show(mainPanel, "Updates");
			}
		}
	}
}

