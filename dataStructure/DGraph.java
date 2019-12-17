package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class DGraph implements graph{

	   HashMap<Integer,node_data> v; 
	   ArrayList<edgeData> e;
	   
    public DGraph() 
    {
	 v=new HashMap<Integer,node_data>();
	 e=new ArrayList<edgeData>();
    }
    
	@Override
	public node_data getNode(int key) 
	{
		if(v.containsKey(key))
		{
			return v.get(key);
		}
		else
			return null;
	}  

	@Override
	public edge_data getEdge(int src, int dest)
	{
		nodeData p = (nodeData)this.v.get(src);
		if (p.tE.get(dest) != null)
		{ 
			return p.tE.get(dest); 
		}
		return null;
	}

	@Override
	public void addNode(node_data n)
	{
		this.v.put(n.getKey(),n); //if already exist????????
	}

	@Override
	public void connect(int src, int dest, double w) 
	{
		nodeData s = (nodeData)this.v.get(src);
		nodeData d = (nodeData)this.v.get(dest);
		edgeData e = new edgeData(src, dest, w);
		this.e.add(e);
		s.tN.put(dest, d);	
		d.tN.put(src,s);
		s.tE.put(dest,e);
		d.fE.put(src, e);
	}

	@Override
	public Collection<node_data> getV() 
	{
		return this.v.values();
	}


	@Override
	public Collection<edge_data> getE(int node_id)
	{
		node_data n = this.v.get(node_id);
		return (Collection<edge_data>)((nodeData)n).tE;
	}

	@Override
	public node_data removeNode(int key) 
	{
		if (this.v.get(key)==null) 
		{ 
			return null;  //this key isnt exist
		}

		nodeData n = (nodeData)(this.v.get(key));
		Collection<edge_data> delete = getE(key);
		Iterator<edge_data> iterator = delete.iterator();
		while (iterator.hasNext())
		{
			edgeData edg = (edgeData) iterator.next();
			int s=edg.getSrc();
			int d=edg.getDest();
			removeEdge(s,d); //calling the next function
		}
		Collection<edge_data> s= (Collection<edge_data>) n.fE;
		Iterator<edge_data> iterator1 = s.iterator();
		while (iterator1.hasNext())
		{
			edgeData edg = (edgeData) iterator1.next();
			int sr=edg.getSrc();
			int d=edg.getDest();
			removeEdge(sr,d); //calling the next function
		}
		this.v.remove(key);
		return n;
	}

	@Override
	public edge_data removeEdge(int src, int dest) 
	{
		nodeData s = (nodeData)this.v.get(src);
		nodeData d = (nodeData)this.v.get(dest);
		if (s.tE.get(dest) == null)
		{
			return null; 
		}
		if(s.tN.get(dest)!=null)
		{
			s.tN.remove(dest);
			d.fN.remove(src);
		}
		edge_data edge = (edgeData)s.tN.get(dest); 
		s.tE.remove(dest);
		d.tE.remove(src);
		for (int i=0; i<this.e.size(); i++) {
			if (this.e.get(i)==edge) { 
				this.e.remove(i);
			}
		}
		return edge;
	}

	@Override
	public int nodeSize()
	{
		return this.v.size();
	}

	@Override
	public int edgeSize() 
	{
		int i=this.e.size();
		return i;
	}

	@Override
	public int getMC() 
	{
		
		return 0;
	}
	
	//**********************************
	


}
