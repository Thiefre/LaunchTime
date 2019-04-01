package data;

import java.util.ArrayList;


public class GameTree 
{
	public Game root;
	
	
	public GameTree()
	{
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
			root.add(g);
		}
		return false;
	}
	
	public ArrayList<Game> toArrayList()
	{
		ArrayList<Game> list = new ArrayList<Game>();
		
		if(root.getChildren() != null)
		{
			list = root.getChildren();
		}
		list.add(root);
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
