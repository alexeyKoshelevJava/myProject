import org.apache.commons.io.FileUtils;
import org.locationtech.jts.geom.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class PolygonAndPoint {
    public static void main(String[] args) {
        //accept file name
        String fileNameWithPolygonCoordinates = args[0];
        float[][] polygonCoordinates = getArrayPolygonCoordinates(fileNameWithPolygonCoordinates);
        PolygonCreator polygonCreator = new PolygonCreator(polygonCoordinates);
        Polygon polygon = polygonCreator.CreatePolygon();
        LinearRing linearRing = polygonCreator.createLinearRing();
        String fileNameWithPointCoordinates = args[1];
        float[][] coordinatePoints = getArrayPointCoordinates(fileNameWithPointCoordinates);




        GeometryFactory factory = polygonCreator.getFactory();
boolean flag = false;
        for (int x = 0; x < coordinatePoints.length; x++) {

            Coordinate coordinate = new Coordinate(coordinatePoints[x][0], coordinatePoints[x][1]);
            Point point = factory.createPoint(coordinate);
            if (linearRing.contains(point)) {
                for (int z = 0; z < polygonCoordinates.length; z++) {
                    if (coordinatePoints[x][0] == polygonCoordinates[z][0] && coordinatePoints[x][1] == polygonCoordinates[z][1]) {
                        System.out.println(0);
                        flag = true;

                    }
                }
                if (flag == false){
                    System.out.println(1);
                }else flag = false;


            } else if (polygon.contains(point)) {
                System.out.println(2);

            } else {
                System.out.println(3);
            }

        }
    }


    public static float[][] getArrayPolygonCoordinates(String fileNameWithPolygonCoordinates) {
        String fileContentWithWithPolygonCoordinates = null;
        try {
            fileContentWithWithPolygonCoordinates = FileUtils.readFileToString(new File(fileNameWithPolygonCoordinates), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String el = fileContentWithWithPolygonCoordinates.replaceAll("(?m)^[ \t]*\r?\n", "");

        String[] elements = el.split("\\n+");


        String[][] rasparseElements = new String[elements.length][];

        for (int z = 0; z < rasparseElements.length; z++) {
            String[] value = elements[z].split(" ");
            rasparseElements[z] = value;
        }


        float[][] floatElements = new float[rasparseElements.length][rasparseElements[0].length];
        for (int i = 0; i < floatElements.length; i++) {
            for (int i1 = 0; i1 < rasparseElements[0].length; i1++) {
                floatElements[i][i1] = (Float.parseFloat(rasparseElements[i][i1]));


            }
        }

        return floatElements;

    }

    public static float[][] getArrayPointCoordinates(String fileNameWithPointCoordinates) {
        String fileContentWithPointCoordinates = null;
        try {
            fileContentWithPointCoordinates = FileUtils.readFileToString(new File(fileNameWithPointCoordinates), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String el = fileContentWithPointCoordinates.replaceAll("(?m)^[ \t]*\r?\n", "");
        String[] elements = el.split("\\n+");

        String[][] rasparseElements = new String[elements.length][];

        for (int z = 0; z < rasparseElements.length; z++) {
            String[] value = elements[z].split(" ");
            rasparseElements[z] = value;

        }

        float[][] floatElements = new float[rasparseElements.length][rasparseElements[0].length];
        for (int i = 0; i < floatElements.length; i++) {
            for (int i1 = 0; i1 < rasparseElements[0].length; i1++) {
                floatElements[i][i1] = (Float.parseFloat(rasparseElements[i][i1]));


            }
        }

        return floatElements;


    }

}

