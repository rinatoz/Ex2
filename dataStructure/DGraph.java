package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DGraph implements graph{

	  HashMap<Integer,node_data> v; 
	  HashMap<Integer,HashMap<Integer,edge_data>> e;
	   
    public DGraph() 
    {
	 v=new HashMap<Integer,node_data>();
	 e=new HashMap<Integer, HashMap<Integer,edge_data>>();
    }
    
	@Override
	public node_data getNode(int key) 
	{
		if(v.containsKey(key)) //check if this hashmap contains this key
		{
			return v.get(key);
		}
		else
			return null;   
	}  

	@Override
	public edge_data getEdge(int src, int dest)
	{
		
     try
     {
    	 edge_data e= this.e.get(src).get(dest);
    	 return e;
     }
     catch (Exception e)
     {
    	 throw new RuntimeException ("src or dest nodes not exist");
     }
     
	}

	@Override
	public void addNode(node_data n)
	{ 
		if(!this.v.containsKey(n.getKey()))
		{
		this.v.put(n.getKey(),n); 
		}
	}

	@Override
	public void connect(int src, int dest, double w) //check cases that src and dest not at the nodes list
	{
		try
		{
			this.v.get(src);
			this.v.get(dest);
			edgeData e = new edgeData(src, dest, w);
			HashMap<Integer,edge_data> inside=new HashMap<Integer,edge_data>();
			edge_data edg=new edgeData(src,dest,w);
			inside.put(dest,edg);
			this.e.put(src,inside);
		}
		catch (Exception e)
		{
			throw new RuntimeException ("src or dest not found at the nodes list");
		}


	}

	@Override
	public Collection<node_data> getV() 
	{
		Collection<node_data> v1=(Collection<node_data>) this.v;     
		return (Collection<node_data>)v1;
		
	}


	@Override
	public Collection<edge_data> getE(int node_id)
	{
		try
		{
		node_data n = this.v.get(node_id);
		try
		{
		Collection<edge_data> e1=(Collection<edge_data>) this.e.get(node_id);     
		return (Collection<edge_data>)e1;
		}
		catch (Exception e)
		{
			throw new RuntimeException("node_id havn't edges");
		}
		}
		catch (Exception e)
		{
			throw new RuntimeException("node_id not exitst");
		}
	}

	@Override
	public node_data removeNode(int key) 
	{
		if (this.v.get(key)==null) 
		{ 
			return null;  //this key isnt exist
		}

		nodeData n = (nodeData)(this.v.get(key));
		Collection<edge_data> delete = this.getE(key);
		Iterator<edge_data> iterator = delete.iterator();
		while (iterator.hasNext())
		{
			edgeData edg = (edgeData) iterator.next();
			int s=key;
			int d=edg.getDest();
			removeEdge(s,d); 
		}
		
		this.v.remove(key);
		return n;
	}

	@Override
	public edge_data removeEdge(int src, int dest) 
	{
		try
		{
        edge_data edge=this.getEdge(src, dest);
        this.e.get(src).remove(dest);
		return edge;
		}
		catch (Exception e)
		{
			throw new RuntimeException("src or dest not exist");
		}
	}

	@Override
	public int nodeSize()
	{
		return this.v.size();
	}

	@Override
	public int edgeSize() 
	{
		int i=this.e.size() ;
		return i;
	}

	@Override
	public int getMC() 
	{
		
		return 0;
	}
	
	//**********************************
	
	private String tostringNodes()
	{
		String s="nodes:";
		Iterator<Entry<Integer, node_data>> it=this.v.entrySet().iterator();
		while (it.hasNext())
		{
			  nodeData d= (nodeData) it.next().getValue();
			  s=s+d.toString();
		}
	    
		return s;
	}
	private String tostringEdge()
	{
		String s="edges:";
        for (int i=0;i<this.edgeSize();i++)
        {
        	s=s+this.e.get(i).toString();
        }
	    
		return s;
	}
	public String toString()
	{
		String s="";
		String nodes=tostringNodes();
		String edges=tostringEdge();
		s=s+"["+nodes.toString()+edges.toString()+"]";
		return s;
	}


}
