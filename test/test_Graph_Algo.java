package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.edgeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.nodeData;
import dataStructure.node_data;
import utils.Point3D;

public class test_Graph_Algo {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void test_Init_Graph() {
	//	fail("Not yet implemented")
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
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.connect(n1.getKey(), n2.getKey(), 2);
		g.connect(n2.getKey(), n3.getKey(), 3);
		Graph_Algo a=new Graph_Algo();
		a.init(g);
		a.save("graph");
		String s=a.toString();
		a.init("graph");
		String s1=a.toString();
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
	public void test_Shortest_Path_Dist() {
		//fail("Not yet implemented");
	}

	@Test
	public void test_Shortest_Path() {
		//fail("Not yet implemented");
	}

	@Test
	public void test_TSP() {
		//fail("Not yet implemented");
	}

	@Test
	public void test_Copy() {
		//fail("Not yet implemented");
	}

}
