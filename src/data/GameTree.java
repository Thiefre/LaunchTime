package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;


public class GameTree 
{
	public Game root;
	public File f = new File("C:/LaunchTime/data.txt");
	//public File r = new File("C:/LaunchTime/recents.txt");
	
	
	public GameTree()
	{
		new File("C:/LaunchTime").mkdirs();
		try {
			f.createNewFile();
		//	r.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public GameTree(ArrayList<Game> gl)
	{
		root = gl.get(0);
		gl.remove(0);
		for(Game g : gl)
		{
			insert(g);
		}
	}
	
	public boolean insert(Game g)
	{
		if(root == null)
		{
			root = g;
		}
		else
		{
			return root.add(g);
		}
		return false;
	}
	
	public ArrayList<Game> toArrayList() throws IOException
	{
		ArrayList<Game> list = new ArrayList<Game>();
		Writer w = new FileWriter(this.f, false);
		BufferedWriter bw = new BufferedWriter(w);
		
		if(root.getChildren() != null)
		{
			list = root.getChildren();
		}
		list.add(root);
		
		for(Game game : list)
		{
			bw.write(game.name+"@"+game.path);
			bw.newLine();
		}
		bw.close();
		w.close();
		return list;
	}
	
	
	//If keyword is smaller than name, it will always search the left path and not the right path.
	//Solution: search through everything and check?
	//Solution2: find key node and search both paths
	
	public ArrayList<Game> search(String keyword)
	{
		ArrayList<Game> games = root.getChildren();
		games.add(root);
		
		ArrayList<Game> keyGames = new ArrayList<Game>();
		for(Game g : games)
		{
			if(g.name.toLowerCase().contains(keyword.toLowerCase()) || g.name.compareToIgnoreCase(keyword) == 0)
			{
				keyGames.add(g);
			}
		}
		return keyGames;
	}

}
