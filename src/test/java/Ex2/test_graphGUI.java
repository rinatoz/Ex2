package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.nodeData;
import gui.Graph_GUI;
import utils.Point3D;

public class test_graphGUI {

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
	public void testGraphwindows()
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
		g.connect(n1.getKey(), n4.getKey(), 1);
		g.connect(n3.getKey(), n5.getKey(), 1);
		g.connect(n5.getKey(), n4.getKey(), 3);
		g.connect(n4.getKey(), n3.getKey(), 3);
		g.connect(n4.getKey(), n7.getKey(), 2);
		g.connect(n5.getKey(), n6.getKey(), 4);
		g.connect(n3.getKey(), n6.getKey(), 1);
		g.connect(n3.getKey(), n7.getKey(), 6);
		g.connect(n6.getKey(), n7.getKey(), 1);			
        Graph_GUI test = new Graph_GUI(g);
        test.init(g);
        ArrayList<Integer> target= new ArrayList<Integer>();
        target.add(n1.getKey());
        target.add(n2.getKey());
        target.add(n3.getKey());
        target.add(n4.getKey());
        test.isconnected_gui();
        test.shortestPath_gui(n1.getKey(),n6.getKey());
	}

}
