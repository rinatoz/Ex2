package dataStructure;

import java.util.HashMap;

import utils.Point3D;

public class nodeData implements node_data
{
	private static int keyI = 1; //index of key 
	private Point3D location;  
	private int key;  //key to the hashmap
	private double weight; 
	private String info;
	private int tag;
	
	//////// ****as a pointers to another nodes which consider edge with this node.***//////////////////
	
	HashMap<Integer, node_data>  tN  = new HashMap<Integer, node_data>(); //to neighbor
	HashMap<Integer, node_data> fN = new HashMap<Integer, node_data>(); //from neighbor to this node
	HashMap<Integer, edge_data>  tE  = new HashMap<Integer, edge_data>(); //to edge 
	HashMap<Integer, edge_data> fE = new HashMap<Integer, edge_data>(); //from edge to this node

	public nodeData() 
	{
		this.key=keyI;
		this.location=null;
		this.weight=0;
		this.info=null;
		this.tag=0;
		keyI++;
	}
	public nodeData(Point3D p,double w,String i,int t) 
	{
		this.key=keyI;
		this.location=p;
		this.weight=w;
		this.info=i;
		this.tag=t;
		keyI++;
	}

	@Override
	public int getKey() 
	{
		return this.key;
	}

	@Override
	public Point3D getLocation() 
	{
		if(location!=null)
			return this.location;
		else
			return null;
	}

	@Override
	public void setLocation(Point3D p) 
	{
		Point3D temp=new Point3D(p);
		this.location=temp;
	}
	@Override
	public double getWeight() 
	{
		return this.weight;
	}
	@Override
	public void setWeight(double w) 
	{
		this.weight=w;	
	}

	@Override
	public String getInfo() 
	{
		return this.info;
	}

	@Override
	public void setInfo(String s) 
	{
		this.info=s;
	}

	@Override
	public int getTag() 
	{
		return this.tag;
	}

	@Override
	public void setTag(int t) 
	{
			this.tag=t;
	}
	/////////////////////////////////////////////////////////////////
	public String toString()
	{
		String s="";
		if(this.info.isEmpty())
		{
			s=s+"(location:" + this.location.toString()+",weight:"+this.weight+",info:no information yet"+",tag:"+this.tag+")";
		}
		else
		{
		s=s+"(location:" + this.location.toString()+",weight:"+this.weight+",info:"+ this.info.toString()+ ",tag:"+this.tag+")";
		}
		return s;
	}



}