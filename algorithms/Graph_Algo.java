package algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import dataStructure.DGraph;
import dataStructure.edgeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.nodeData;
import dataStructure.node_data;
import utils.Point3D;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{

	public graph g;
	
	public Graph_Algo()
	{
		this.g=new DGraph();
	}
	
	@Override
	public void init(graph g)
	{
		this.g=g;		
	}
	
	@Override
	public void init(String file_name)
	{
	       String line = "";
	       int i=0;
	        try 
	        {
	        	BufferedReader br = new BufferedReader(new FileReader(file_name));
	        	line=br.readLine();
	            String[] afterread = line.split("]"); //graph
	            
	            while (i<afterread.length)
	            {
	             afterread[i]= afterread[i].substring(8); 
	             String[] two =afterread[i].split(Pattern.quote("edges:("));
	             String[] nodes =two[0].split(Pattern.quote("("));
	             DGraph e=new DGraph();
	             for (int k=0;k<nodes.length;k++)
	             {
	            	 e.addNode(readS(nodes[k]));
	             }
                try
                 {
	             String[] edges =two[1].split(Pattern.quote("("));
	             for (int k1=0;k1<edges.length;k1++)
	             {
	            	 edgeData ed=readSt(edges[k1]);
	                 e.connect(ed.getSrc(), ed.getDest(), ed.getWeight());	            	 
	             }
	             }
	            catch(Exception E) {}
	             this.g=e;
	             
                i++;
	            }	             
	          
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	            throw new RuntimeException ("couldnt read a file");
	        }
	}

	@Override
	public void save(String file_name) 
	{
		try {
			File f=new File(file_name);
			PrintWriter pw = new PrintWriter(f);
			String intoFile="";
	        intoFile=intoFile+this.g.toString();
			pw.write(intoFile.toString());
			pw.close();
		}
		catch (Exception e) 
		{
			throw new RuntimeException("couldn't save the collection");
		}	
		
	}

	@Override
	public boolean isConnected()
	{
		int key,key2;
       boolean ans=true;
       Collection<node_data> col= this.g.getV();
       Iterator<node_data> it=col.iterator();
       Iterator<node_data> it1=col.iterator();
	   while (it.hasNext())
	    {
			key=it.next().getKey();
			while (it1.hasNext())
			  {		     
				key2=it1.next().getKey();
					if (key!=key2)
					{
						try
						{
							if (this.g.getEdge(key,key2)==null)ans=false;
							if (this.g.getEdge(key2,key)==null)ans=false;
						}
						catch (Exception e)
						{
							ans=false;
						}
					}
		 	}
			it1=col.iterator();	
		}

       return ans;
	}

	@Override
	public double shortestPathDist(int src, int dest)
	{

		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) 
	{

	  return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() 
	{
		Collection<node_data> nodes=this.g.getV();
		Collection<edge_data> edges=new ArrayList<>();
		Iterator<node_data> itr=nodes.iterator();
		while(itr.hasNext()) {
			edges.addAll(this.g.getE(itr.next().getKey()));
		}
		graph g=new DGraph(nodes, edges);
		return g;
	}
	
	///////////////////////////////////////////////////////
	public nodeData readS(String s)
	{
		Point3D p;
	//	s=s.substring(1);
		s=s.replaceAll("key:","");
		s=s.replaceAll("location:","");
		s=s.replaceAll("info:","");
		s=s.replaceAll("weight:","");
		s=s.replaceAll("tag:","");
		String[] s1=s.split(",");
		int key=Integer.parseInt(s1[0]);
		nodeData d=new nodeData(key);
		double x= Double.parseDouble(s1[1]);
		double y= Double.parseDouble(s1[2]);
		double z= Double.parseDouble(s1[3]);
		p=new Point3D(x,y,z);
		d.setLocation(p);
		double weight=Double.parseDouble(s1[4]);
		d.setWeight(weight);
		d.setInfo(s1[5]);
		s1[6]=s1[6].replace(")", "");
		int tag=Integer.parseInt(s1[6]);
        d.setTag(tag);
		return d;
		
	}
	//
	public edgeData readSt(String s)
	{
		edgeData d;
		Point3D p;
         try
        {
		s=s.replaceAll("src:","");
		s=s.replaceAll("dest:","");
		s=s.replaceAll("weight:","");
		s=s.replaceAll("info:","");
		s=s.replaceAll("tag:","");
		String[] s1=s.split(",");
	    int src=Integer.parseInt(s1[0]);
	    int dest=Integer.parseInt(s1[1]);
	    double weight=Double.parseDouble(s1[2]);
	    d=new edgeData(src,dest,weight);
		d.setInfo(s1[3]);
		s1[4]=s1[4].replaceAll("\\)","");
		int tag=Integer.parseInt(s1[4]);
        d.setTag(tag);
		return d;
		}
      catch (Exception e) 
      {
    	  throw new RuntimeException ("cant read edge's list");
      }
	}
	public String toString()
	{
		String s="";
        
		s=s+this.g.toString();
		return s;
	}

}
