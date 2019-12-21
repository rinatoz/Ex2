package gui;

import algorithms.Graph_Algo;
import dataStructure.*;
import utils.Point3D;
import utils.StdDraw;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;


public class Graph_GUI extends Graph_Algo
{
	
    graph gA;


    public Graph_GUI()
    {
      gA=new DGraph();
    }
    public Graph_GUI(graph g)
    {    
        gA=g;
    }
    public void draw(int width,int height)
    {
        StdDraw.setCanvasSize(width,height);
        StdDraw.setXscale(0,100);
        StdDraw.setYscale(0,100);
        StdDraw.setPenRadius(0.01);
        Collection <node_data> nodes=this.gA.getV();
        Iterator<node_data> it=nodes.iterator();
        while (it.hasNext()){
        	node_data n=it.next();
        	try
        	{
            Collection<edge_data> myE =this.gA.getE(n.getKey());
            Iterator<edge_data> it2=myE.iterator();
            StdDraw.setPenColor(Color.blue);
            StdDraw.setPenRadius(0.02);
            StdDraw.point(n.getLocation().x(),n.getLocation().y());
            String s="";
            s=s+n.getKey();
            StdDraw.text(n.getLocation().x(),n.getLocation().y()-2,s);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius(0.004);
            while (it2.hasNext()) 
            {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.setPenRadius(0.004);
            	edge_data e=it2.next();
                double x0 = n.getLocation().x();
                double y0 = n.getLocation().y();
                double y1 = this.gA.getNode(e.getDest()).getLocation().y();
                double x1 = this.gA.getNode(e.getDest()).getLocation().x();
                double centerX= (x0+x1)/2;
                double centerY=(y0+y1)/2;
                String weight="";
                weight=weight+e.getWeight();
                StdDraw.text(centerX+0.5,centerY+0.5,weight);
                StdDraw.line(x0,y0,x1,y1);
                double dX = x1-x0;
                double dY = y1-y0;
                double m = dY/dX;
          
                StdDraw.setPenColor(StdDraw.YELLOW);
                StdDraw.setPenRadius(0.015);
                if (x1>x0)
                {
                StdDraw.point(x1-1,m+y1);
                }
                else
                {
                	StdDraw.point(x1+1,m+y1);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setPenRadius(0.004);
            }
            
        	}
        	catch (Exception e) 
        	{
                StdDraw.setPenColor(Color.blue);
                StdDraw.setPenRadius(0.02);
                StdDraw.point(n.getLocation().x(),n.getLocation().y());
                String s="";
                s=s+n.getKey();
                StdDraw.text(n.getLocation().x(),n.getLocation().y()-2,s);
        	}

        }
    }
    public boolean isConected()
    {
        return this.isConnected();
    }
    public void saveaspicture (int width,int height)
    {
    	this.draw(width, height);
    	StdDraw.save("Draw_functions.jpg"); //save the draw as a jpg file
    }
    public static void main(String[] args)
    {
		Point3D p1 = new Point3D(10, 20, 0);
		Point3D p2 = new Point3D(21, 41, 0);
		Point3D p3 = new Point3D(62, 78, 2);
		Point3D p4 = new Point3D(45, 34, 0);
		Point3D p5 = new Point3D(48, 75, 0);
		Point3D p6 = new Point3D(67, 81, 2);
		nodeData n1 = new nodeData(p1,5,"",0);
		nodeData n2 = new nodeData(p2,4,"", 0);
		nodeData n3 = new nodeData(p3,5,"", 0);
		nodeData n4 = new nodeData(p4,5,"",0);
		nodeData n5 = new nodeData(p5,5,"", 0);
		nodeData n6 = new nodeData(p6,5,"", 0);
		graph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.connect(n1.getKey(), n4.getKey(), 10);
		g.connect(n1.getKey(), n3.getKey(), 1);
		g.connect(n1.getKey(), n2.getKey(), 3);
		g.connect(n3.getKey(), n4.getKey(), 4);
	//	g.connect(n1.getKey(), n4.getKey(), 6);
	
		Graph_Algo a=new Graph_Algo();
		a.init(g);
        Graph_GUI test = new Graph_GUI(g);
           test.draw(800,600);
             System.out.println(test.shortestPath(n1.getKey(),n4.getKey()));

    }

}