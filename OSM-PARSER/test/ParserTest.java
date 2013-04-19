import br.zuq.osm.parser.OSMParser;
import br.zuq.osm.parser.model.OSM;
import br.zuq.osm.parser.model.OSMNode;
import br.zuq.osm.parser.model.Way;

public class ParserTest {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// String left = "16.35428";
		// String bottom = "48.20161";
		// String right = "16.36806";
		// String top = "48.20747";
		// String url = " http://api.openstreetmap.org/api/0.6/map?bbox=" + left
		// + "," + bottom + "," + right
		// + "," + top;
		// System.out.println(url);
		// OSM osm = OSMParser.parse(url);

		OSM osm = OSMParser.parse("test/surabaya.osm");
	
		 for (Way way : osm.getWays()) {
			 System.out.println(way.getLineString());
		 }
		System.out.println(osm.getWays().size());
		
//		String asal = "1379499958";
//		for (OSMNode node : osm.getNodes()) {
//			System.out.println(node.getPoint());
//		//	System.out.println(node.lat+" "+node.lon);
//		}
	}
}
