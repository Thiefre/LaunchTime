package data;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game 
{
	public String name;
	public String path;
	public ImageIcon image;
	
	Game parent;
	Game left;
	Game right;
	
	public Game(String name, String path, ImageIcon image)
	{
		this.name = name;
		this.path = path;
		this.image = image;
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
			}
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
