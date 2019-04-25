package data;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game 
{
	public String name;
	public String path;
	
	Game parent;
	Game left;
	Game right;
	
	public Game(String name, String path)
	{
		this.name = name;
		this.path = path;
	}
	
	public boolean add(Game g)
	{
		
		if(name.compareTo(g.name) > 0)
		{
			if(left == null)
			{
				left = g;
				left.parent = this;
				return true;
			}
			else
			{
				left.add(g);
				return true;
			}
		}
		else if(name.compareTo(g.name) < 0)
		{
			if(right == null)
			{
				right = g;
				right.parent = this;
				return true;
			}
			else
			{
				right.add(g);
				return true;
			}
		}
		return false;
	}
	public boolean equals(Object o)
	{
		Game g = (Game) o;
		if(this.name.equalsIgnoreCase(g.name))
		{
			return true;
		}
		return false;
	}
	
	public ArrayList<Game> getChildren()
	{
		ArrayList<Game> children = new ArrayList<Game>();
		if(left != null)
		{
			children.add(left);
			children.addAll(left.getChildren());
		}
		if(right != null)
		{
			children.add(right);
			children.addAll(right.getChildren());
		}
		return children;
	}
	
	public int compareTo(Game g)
	{
		return name.compareToIgnoreCase(g.name);
	}
}
