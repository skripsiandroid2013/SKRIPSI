package astar.test;

import geocoding.engine.Geocode;

import java.util.LinkedList;

import org.junit.Test;

import astar.engine.AStar;
import astar.engine.AStarHeuristic;
import astar.engine.EuclidianHeuristic;
import astar.graph.builder.GraphBuilder;
import astar.model.Graph;
import astar.model.Key;
import astar.model.Vertex;

public class TestAstar {

	@Test
	public void testAlgoritmaAstar() throws Exception {
	
		GraphBuilder builder = new GraphBuilder("data/surabaya.osm");
				
		Graph graph = builder.getGraph();
		
		AStarHeuristic heuristic = new EuclidianHeuristic();
		AStar aStar = new AStar(graph, heuristic);

		String [] location = Geocode.request();
		System.out.println(location[0]+", "+location[1]);
		
		Vertex start = graph.fromVertex(new Key("-7.3161762","112.7918078"));
		System.out.println(start.getNode().lat+","+start.getNode().lon);
		
		Vertex goal = graph.toVertex(new Key("-7.3164693","112.7903005"));
		System.out.println(goal.getNode().lat+","+goal.getNode().lon);
		
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
