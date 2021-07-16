import org.locationtech.jts.geom.*;

public class PolygonCreator {
    private final float[][] coordinates;
    private final GeometryFactory factory = new GeometryFactory();

    public PolygonCreator(float[][] coordinates) {
        this.coordinates = coordinates;

    }

    public GeometryFactory getFactory() {
        return factory;
    }

    public LinearRing createLinearRing() {

        Coordinate[] coords =
                new Coordinate[]{new Coordinate(coordinates[0][0], coordinates[0][1]), new Coordinate(coordinates[1][0], coordinates[1][1]),
                        new Coordinate(coordinates[2][0], coordinates[2][1]), new Coordinate(coordinates[3][0], coordinates[3][1]), new Coordinate(coordinates[0][0], coordinates[0][1])};
        LinearRing linearRing = factory.createLinearRing(coords);

        return linearRing;
    }

    public Polygon CreatePolygon() {
        Polygon polygon = factory.createPolygon(createLinearRing(), null);
        return polygon;
    }

}
