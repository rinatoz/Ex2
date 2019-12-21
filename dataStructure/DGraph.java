package dataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class DGraph implements graph{

	  HashMap<Integer,node_data> v; 
      HashMap<Integer,HashMap<Integer,edge_data>> e;
      private static int MC = 0;
	   
    public DGraph() 
    {
	 v=new HashMap<Integer,node_data>();
	 e=new HashMap<Integer, HashMap<Integer,edge_data>>();
    }
    public DGraph (	Collection<node_data> nodes,Collection<edge_data> edges)
    {
    	this.v = new HashMap<Integer, node_data>();
		this.e = new HashMap<Integer, HashMap<Integer, edge_data>>();
		for(node_data n : nodes)
			addNode(n);
		for(edge_data e : edges)
			connect(e.getSrc(), e.getDest(), e.getWeight());
    }
    
	@Override
	public node_data getNode(int key) 
	{
		if(v.containsKey(key)) 
		{
			return v.get(key);
		}
		else
		{
			throw new RuntimeException ("this key not exist") ;  
		}
	}  

	@Override
	public edge_data getEdge(int src, int dest)
	{
		
     try
     {
    	return this.e.get(src).get(dest);    	
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
		MC++;
	}

	@Override
	public void connect(int src, int dest, double w) //check cases that src and dest not at the nodes list
	{
		if(src!=dest&&w>=0)//check if the edge is between different vertices and the weight is positive 
		{
			if(this.v.containsKey(src)&&this.v.containsKey(dest))//check if there is vertices src dest
			{
				if(!this.e.containsKey(src)) //check if there is a hashmap for key src
				{
					HashMap<Integer, edge_data> edgesVer=new HashMap<Integer,edge_data> ();
					this.e.put(src, edgesVer);
				}
				if(!this.e.get(src).containsKey(dest))//check if the edge is already exist
				{
					edge_data edge=new edgeData(src,dest,w,"",0);
					this.e.get(src).put(dest,edge);
				}
				MC++;	
			}
			else
			{
				throw new RuntimeException ("one of the nodes not exist");
			}
			
		}
		else
			throw new RuntimeException ("the nodess must be diffrent");
	}

	@Override
	public Collection<node_data> getV() 
	{
		return this.v.values();
		
	}


	@Override
	public Collection<edge_data> getE(int node_id)
	{
		try
		{
		return e.get(node_id).values();
		}
		catch (Exception e)
		{
			throw new RuntimeException ("no edges");
		}
	}

	@Override
	public node_data removeNode(int key) 
	{
		int keyTemp;
		for (Entry<Integer, node_data> entry : this.v.entrySet())
		{
			keyTemp=entry.getKey();
			if(keyTemp!=key&&this.e.containsKey(keyTemp) &&this.e.get(keyTemp).containsKey(key))
			{
				if (this.e.get(keyTemp).size()==1)
				{
					this.e.remove(keyTemp);
				}
				else
				{
				this.e.get(keyTemp).remove(key);
				}
			}
			if(keyTemp==key&&e.containsKey(key))
			{
				this.e.remove(key);
			}
		}
		MC++;
        
		return this.v.remove(key);
	}

	@Override
	public edge_data removeEdge(int src, int dest) 
	{
		if(this.v.containsKey(src)&&this.v.containsKey(dest))
		{
			MC++;
			if(this.v.containsKey(src)&&this.e.get(src).containsKey(dest))
			{
				if (e.get(src).size()==1)
				{
					edge_data edge=this.e.get(src).get(dest);
					 this.e.remove(src);
					 return edge;
				}
				else
				{
				return this.e.get(src).remove(dest);
				}
				
			}
			else 
				throw new RuntimeException ("this edge is not exist");
		}
		else
			throw new RuntimeException ("one of the nodes not exist");
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
		
		return MC;
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
	public String tostringEdge()
	{
		String s="edges:";
		int keyTemp;
		for (Entry<Integer, node_data> entry : this.v.entrySet())
		{
			keyTemp=entry.getKey();
			if (this.e.containsKey(keyTemp))
			{
			Iterator<Entry<Integer, edge_data>> it=this.e.get(keyTemp).entrySet().iterator();
			while (it.hasNext())
			{
				if(this.e.get(keyTemp).isEmpty()==false)
				{
				  edgeData ed= (edgeData) it.next().getValue();

				  s=s+ed.toString();
				}
			}
			}
			        
		}
		if (s.equals("edges:"))
		{
			s=s+"(not edges yet)";
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
