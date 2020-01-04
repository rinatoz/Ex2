package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.nodeData;
import dataStructure.node_data;
import gui.Graph_GUI;
import utils.Point3D;

public class test_Graph_Algo {
	
	public static graph g=new DGraph();
	public static Graph_Algo ga=new Graph_Algo();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void test_save_and_init_file()
	{
		Point3D p1 = new Point3D(2, 2, 0);
		Point3D p2 = new Point3D(1, 1, 0);
		Point3D p3 = new Point3D(2, 2, 2);
		nodeData n1 = new nodeData(p1,5,"",0);
		nodeData n2 = new nodeData(p2,5,"", 0);
		nodeData n3 = new nodeData(p3,5,"", 0);
		graph g = new DGraph();
		Graph_Algo a=new Graph_Algo();
		a.init(g);
		a.save("graph");
		String s=a.toString();
		Graph_Algo a1=new Graph_Algo();
		a1.init("graph");
		String s1=a.toString();
		assertTrue(s.toString().equals(s1));
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.connect(n1.getKey(), n2.getKey(), 2);
		g.connect(n2.getKey(), n3.getKey(), 3);
	     a=new Graph_Algo();
		a.init(g);
		a.save("graph");
		s=a.toString();
		a1=new Graph_Algo();
		a1.init("graph");
		s1=a.toString();
		assertTrue(s.toString().equals(s1));

	}


	@Test
	public void test_Is_Connected() 
	{
		Point3D p1 = new Point3D(2, 2, 0);
		Point3D p2 = new Point3D(1, 1, 0);
		Point3D p3 = new Point3D(2, 2, 2);
		Point3D p4 = new Point3D(1, 2, 2);

		nodeData n1 = new nodeData(p1,5,"",0);
		nodeData n2 = new nodeData(p2,5,"", 0);
		nodeData n3 = new nodeData(p3,5,"", 0);
		nodeData n4 = new nodeData(p4,5,"", 0);

		graph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
	
		g.connect(n1.getKey(), n2.getKey(), 2);
		g.connect(n2.getKey(), n1.getKey(), 2);
		g.connect(n1.getKey(), n3.getKey(), 2);
		g.connect(n3.getKey(), n1.getKey(), 2);
		g.connect(n2.getKey(), n3.getKey(), 2);
		g.connect(n3.getKey(), n2.getKey(), 2);

		Graph_Algo a=new Graph_Algo();
		a.init(g);
		
		assertTrue(a.isConnected());
		a.g.addNode(n4);
		assertFalse(a.isConnected());
	}

	@Test
	public void test_Shortest_Path_Dist()
	{
		Point3D p1 = new Point3D(10, 20, 0);
		Point3D p2 = new Point3D(21, 41, 0);
		Point3D p3 = new Point3D(62, 78, 2);
		Point3D p4 = new Point3D(45, 34, 0);
		Point3D p5 = new Point3D(48, 75, 0);
		Point3D p6 = new Point3D(67, 81, 2);
		Point3D p7 = new Point3D(75, 81, 2);
		nodeData n1 = new nodeData(p1,0,"",0);
		nodeData n2 = new nodeData(p2,0,"", 0);
		nodeData n3 = new nodeData(p3,0,"", 0);
		nodeData n4 = new nodeData(p4,0,"",0);
		nodeData n5 = new nodeData(p5,0,"", 0);
		nodeData n6 = new nodeData(p6,0,"", 0);
		nodeData n7 = new nodeData(p7,0,"", 0);
		graph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
        g.connect(n1.getKey(), n2.getKey(), 10);
		g.connect(n1.getKey(), n5.getKey(), 4);
		g.connect(n1.getKey(), n4.getKey(), 3);
		g.connect(n2.getKey(), n4.getKey(), 3);
		g.connect(n4.getKey(), n3.getKey(), 3);
		g.connect(n4.getKey(), n7.getKey(), 2);
		g.connect(n5.getKey(), n6.getKey(), 4);
		g.connect(n3.getKey(), n6.getKey(), 1);
		g.connect(n3.getKey(), n7.getKey(), 6);
		g.connect(n6.getKey(), n7.getKey(), 1);		
        Graph_GUI test = new Graph_GUI();
        test.init(g);
       assertEquals(test.shortestPathDist(n2.getKey(),n7.getKey()),5,0.001);
	}

	@Test
	public void test_Shortest_Path() 
	{
		Point3D p1 = new Point3D(10, 20, 0);
		Point3D p2 = new Point3D(21, 41, 0);
		Point3D p3 = new Point3D(62, 78, 2);
		Point3D p4 = new Point3D(45, 34, 0);
		Point3D p5 = new Point3D(48, 75, 0);
		Point3D p6 = new Point3D(67, 81, 2);
		Point3D p7 = new Point3D(75, 81, 2);
		nodeData n1 = new nodeData(p1,0,"",0);
		nodeData n2 = new nodeData(p2,0,"", 0);
		nodeData n3 = new nodeData(p3,0,"", 0);
		nodeData n4 = new nodeData(p4,0,"",0);
		nodeData n5 = new nodeData(p5,0,"", 0);
		nodeData n6 = new nodeData(p6,0,"", 0);
		nodeData n7 = new nodeData(p7,0,"", 0);

		graph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		g.connect(n1.getKey(), n2.getKey(), 10);
		g.connect(n1.getKey(), n5.getKey(), 4);
		g.connect(n1.getKey(), n4.getKey(), 3);
		g.connect(n2.getKey(), n4.getKey(), 3);
		g.connect(n4.getKey(), n3.getKey(), 3);
		g.connect(n4.getKey(), n7.getKey(), 2);
		g.connect(n5.getKey(), n6.getKey(), 4);
		g.connect(n3.getKey(), n6.getKey(), 1);
		g.connect(n3.getKey(), n7.getKey(), 6);
		g.connect(n6.getKey(), n7.getKey(), 1);			
        Graph_GUI test = new Graph_GUI(g);
        test.init(g);
        ArrayList<node_data> a=(ArrayList<node_data>) test.shortestPath(n2.getKey(),n7.getKey());
       assertEquals(a.get(0).getKey(),n2.getKey());    //n2--->n4--->n7
       assertEquals(a.get(1).getKey(),n4.getKey());
       assertEquals(a.get(2).getKey(),n7.getKey());
	}

	@Test
	public void test_TSP() 
	{
		ga.init(g);
		for(int i=0;i<5;i++)
		{
		Point3D p=new Point3D(i,i,i);
		node_data a=new nodeData(i);
		g.addNode(a);
		}
		g.connect(0,1,2);
		g.connect(3,0,12);
		g.connect(0,3,12);
		g.connect(1,2,7);
		g.connect(1,4,5); 
		g.connect(2,4,1);
		g.connect(4,3,3);
		g.connect(2,3,3);
		List<Integer> send=new ArrayList <Integer>();
		send.add(0);send.add(1);send.add(4);send.add(3);
		List<node_data> actualnode=new ArrayList  <node_data>();
		System.out.println(ga.isConnected());
		actualnode=ga.TSP(send);
		List<Integer> actual=new ArrayList <Integer>();
		for(int i=0;i<actualnode.size();i++)
		{
			actual.add(actualnode.get(i).getKey());
			System.out.println(actualnode.get(i).getKey());
		}
		
	}

	@Test
	public void test_Copy() 
	{
		Point3D p1 = new Point3D(10, 20, 0);
		Point3D p2 = new Point3D(21, 41, 0);
		Point3D p3 = new Point3D(62, 78, 2);
		Point3D p4 = new Point3D(45, 34, 0);
		nodeData n1 = new nodeData(p1,0,"",0);
		nodeData n2 = new nodeData(p2,0,"", 0);
		nodeData n3 = new nodeData(p3,0,"", 0);
		nodeData n4 = new nodeData(p4,0,"",0);
		graph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.connect(n1.getKey(), n2.getKey(), 10);
		g.connect(n1.getKey(), n3.getKey(), 4);
		g.connect(n1.getKey(), n4.getKey(), 3);
		Graph_Algo gr=new Graph_Algo();
		gr.init(g);
		graph copy=gr.copy();
		assertEquals(copy.getV().toString(),g.getV().toString());
		Collection <node_data> nodes=g.getV();
		Iterator<node_data> it=nodes.iterator();
		while(it.hasNext())
		{
			int key=it.next().getKey();
			try //cases that there are edges in the graph
			{
				assertEquals(copy.getE(key).toString(),g.getE(key).toString());
			}
			catch (Exception e) {} 
		}
		

	}

}
