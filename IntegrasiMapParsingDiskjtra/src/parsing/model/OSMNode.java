/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsing.model;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.WKBWriter;
import java.util.Map;

/**
 *
 * @author Willy Tiengo
 */
public class OSMNode extends AbstractNode {

    public String lat;
    public String lon;
    public String id;
    public OSMNode(String id, String visible, String timestamp, String version, String changeset, String user, String uid, String lat, String lon, Map<String, String> tags) {
        super(id, visible, timestamp, version, changeset, user, uid, tags);
        this.lat = lat;
        this.lon = lon;
        this.tags = tags;
        this.id=id;
    }

    public String getLocation() {
        Point p = new GeometryFactory().createPoint(
                new Coordinate(Double.valueOf(lat), Double.valueOf(lon)));

        return WKBWriter.bytesToHex(new WKBWriter().write(p));
    }
    
    public Point getPoint() {
        Point p = new GeometryFactory().createPoint(
                new Coordinate(Double.valueOf(lat), Double.valueOf(lon)));

        return p;
    }
    public String getId() {
		return id;
	}
}
