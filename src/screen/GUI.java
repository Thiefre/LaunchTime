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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.Game;
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

	JPanel topPanel = new JPanel();
	JPanel iconPanel = new JPanel();
	JPanel mainPanel = new JPanel(new BorderLayout());	
	JPanel libPanel = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel searchPanel = new JPanel();

	JButton syncBut, libBut, upBut, searchBut;
	Desktop desktop = Desktop.getDesktop();

	//JLabel recent = new JLabel();
	
	JTextField searchBar;
		
	ArrayList<Game> list = new ArrayList<Game>();
	ArrayList<Game> recents = new ArrayList<Game>();
	
	Launcher launcher = new Launcher();
	File f = new File("C:/");

	public GUI() {
		super("LaunchTime");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1440, 980);
		
		topPanel.setBackground(grayMENU);
		mainPanel.setBackground(grayBG);
		iconPanel.setBackground(grayICONS);
		searchPanel.setBackground(grayMENU);

		syncBut = new JButton("Sync");
		syncBut.setBackground(grayBUT);
		syncBut.setForeground(Color.WHITE);

		libBut = new JButton("Library");
		libBut.setBackground(grayBUT);
		libBut.setForeground(Color.WHITE);	
		upBut = new JButton("Updates");
		upBut.setBackground(grayBUT);
		upBut.setForeground(Color.WHITE);
		searchBut = new JButton("Search");
		searchBut.setBackground(grayBUT);
		searchBut.setForeground(Color.WHITE);

		actionListener al = new actionListener();
		
		libPanel.setBackground(grayBG);
		libPanel.setLayout(new GridLayout(0,3));
		
		libBut.addActionListener(al);
		upBut.addActionListener(al);
		syncBut.addActionListener(al);
		searchBut.addActionListener(al);
		
		searchBar = new JTextField();
		searchBar.setBackground(grayMENU);
		searchBar.setForeground(Color.WHITE);

	//	recent.setText("Recents");
	//	recent.setForeground(blueTXT);
	//	iconPanel.setLayout(new BoxLayout(iconPanel, BoxLayout.Y_AXIS));
	//	iconPanel.add(recent);

		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		topPanel.add(syncBut);
		topPanel.add(libBut);
		topPanel.add(upBut);
		topPanel.add(searchBar);
		topPanel.add(searchBut);


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
		JTextArea changes = new JTextArea("This is LaunchTime v0.2 added: search bar, search button, search functionality, recent functionality, updated updates");
		changes.setBackground(grayBG);
		changes.setForeground(Color.WHITE);
		upPanel.add(changes, BorderLayout.CENTER);
		
		this.add(mainPanel);
		this.add(topPanel, BorderLayout.NORTH);
		this.add(iconPanel, BorderLayout.WEST);
		this.getContentPane().add(mainPanel);
		this.setVisible(true);
		this.setResizable(true);
		searchAndAdd();
	}
	
	public void searchAndAdd()
	{
		try {
			list = launcher.g.toArrayList();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		libPanel.removeAll();
		libPanel.revalidate();
		iconPanel.removeAll();
		iconPanel.revalidate();
		
		for(Game g : list)
		{
			GameButton gBut = new GameButton(g);
			gBut.setPreferredSize(new Dimension(150, 150));
			gBut.addActionListener(new ActionListener( ) {
				public void actionPerformed(ActionEvent e)
				{
					try {
						desktop.open(new File(g.path));
						
						if(!recents.contains(g))
						{
/*Code for recents tab		recents.add(g);
							if(recents.size() == 4)
							{
								recents.remove(recents.size()-1);
							}
							Writer w = new FileWriter(launcher.g.r, true);
							BufferedWriter bw = new BufferedWriter(w);
							bw.write(g.name+"@"+g.path);
							bw.newLine();
							
							bw.close();
							w.close();	*/
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			libPanel.add(gBut);
		}
		for(Game g : recents)
		{
			GameButton aBut = new GameButton(g);
			aBut.setText("");
			aBut.setPreferredSize(new Dimension(50, 75));
			aBut.addActionListener(new ActionListener( ) {
				public void actionPerformed(ActionEvent e)
				{
					try {
						desktop.open(new File(g.path));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			iconPanel.add(aBut);
		}
		libPanel.updateUI();
		iconPanel.updateUI();
	}
	
	public class actionListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			JButton src = (JButton) event.getSource();

			if(src.equals(syncBut))
			{	
				int reply = JOptionPane.showConfirmDialog(null, "Do you want to sync your system?");
				if(reply == JOptionPane.YES_OPTION)
				{
					launcher.searchGames(f);
					searchAndAdd();
				}
			}
				
			if(src.equals(libBut)) {
				cardLayout.show(mainPanel, "Library");
			}
			if(src.equals(upBut)) {
				cardLayout.show(mainPanel, "Updates");
			}
			if(src.equals(searchBut)) {
				String text = searchBar.getText();
				libPanel.removeAll();
				libPanel.revalidate();
				
				for(Game g : launcher.g.search(text))
				{
					GameButton gBut = new GameButton(g);
					gBut.setPreferredSize(new Dimension(150, 150));
					gBut.addActionListener(new ActionListener( ) {
						public void actionPerformed(ActionEvent e)
						{
							try {
								desktop.open(new File(g.path));
								
								if(!recents.contains(g))
								{
			/*Code for Recents tab				recents.add(g);
									if(recents.size() == 4)
									{
										recents.remove(recents.size()-1);
									}
									Writer w = new FileWriter(launcher.g.r, true);
									BufferedWriter bw = new BufferedWriter(w);
									bw.write(g.name+"@"+g.path);
									bw.newLine();
									
									bw.close();
									w.close();	*/
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					});
					libPanel.add(gBut);
				}
				libPanel.updateUI();
				launcher.g.search(text);
			}
		}
	}
	
	public static void main(String[] args)
	{
		GUI screen = new GUI();
	}
}
