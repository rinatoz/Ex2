package dataStructure;

import java.util.Iterator;

public class edgeData implements edge_data
{
	private int src;
	private int dest;
	private double weight;
	private String info;
	private int tag;

	public edgeData(int s,int d,double w) 
	{
		this.src=s;
		this.dest=d;
		this.weight=w;
		this.info="";
		this.tag=0;
	}
	public edgeData(int s,int d,double w,String i,int t) 
	{
		this.src=s;
		this.dest=d;
		this.weight=w;
		this.info=i;
		this.tag=t;
	}
	
	public boolean equals (edge_data a)
	{
		if (this.src!=a.getSrc())
			return false;
		if (this.dest!=a.getDest())
			return false;
		if (this.weight!=a.getWeight())
			return false;
		if (!this.info.equals(a.getInfo()))
			return false;
		if (this.tag!=a.getTag())
			return false;
		
		return true;
	}

	@Override
	public int getSrc() 
	{
		return src;
	}

	@Override
	public int getDest() 
	{
		return dest;
	}

	@Override
	public double getWeight() 
	{
		return weight;
	}

	@Override
	public String getInfo() 
	{
		return info;
	}

	@Override
	public void setInfo(String s) 
	{
		info=s;
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
	///////////////////////////////////////////////
	public String toString()
	{
		String s="";
		if(this.info.isEmpty())
		{
			s=s+"(src:"+ this.src+",dest:"+this.dest+",weight:"+this.weight+",info:no information yet"+",tag:"+this.tag+")";
		}
		else
		{
	    s=s+"(src:"+ this.src+",dest:"+this.dest+",weight:"+this.weight+",info:"+this.info.toString()+",tag:"+this.tag+")";
		}
		return s;
	}
	

}