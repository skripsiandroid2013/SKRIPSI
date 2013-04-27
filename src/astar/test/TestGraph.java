package astar.test;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import astar.graph.builder.GraphBuilder;
import astar.model.Graph;


public class TestGraph {
	
	@Test
	public  void testGraphBuilder() throws Exception {
		GraphBuilder builder = new GraphBuilder("data/surabaya.osm");
		Graph graph = builder.getGraph();
		assertNotNull("graph loaded !", graph);

	}
}
