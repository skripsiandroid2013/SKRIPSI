package astar.test;

import static org.junit.Assert.assertNotNull;

import geocoding.engine.Geocode;

import java.util.LinkedList;

import org.junit.Test;

import parsing.model.OSMNode;
import astar.engine.AStar;
import astar.engine.AStarHeuristic;
import astar.engine.EuclidianHeuristic;
import astar.graph.builder.GraphBuilder;
import astar.model.Graph;
import astar.model.Vertex;

public class TestAstar {

	@Test
	public void testAlgoritmaAstar() throws Exception {
	
		GraphBuilder builder = new GraphBuilder("data/surabaya.osm");
				
		Graph graph = builder.getGraph();
		assertNotNull("graph not null", graph);
		
		AStarHeuristic heuristic = new EuclidianHeuristic();
		AStar aStar = new AStar(graph, heuristic);
		
		String[] latlan = Geocode.request();
		
		Vertex myLocation = null;	
		for(Vertex vertex : graph.getVertexs()){
			OSMNode n = vertex.getNode();
			System.out.println(n.lat+" , "+n.lon);
			if(n.lat.equals("-7.3436905") && n.lon.equals("112.695374") ){
				myLocation = vertex;
			}
		}
		
		Vertex start = graph.fromVertex(""+myLocation.toString());
		
		Vertex goal = graph.toVertex("1357523975");
		aStar.execute(start, goal);

		LinkedList<Vertex> path = aStar.getPath();
		System.out.print("[");
		for (Vertex vertex : path) {
			System.out.print(vertex+ ", ");
		}
		System.out.print("]");
		System.out.println();
	}

}
