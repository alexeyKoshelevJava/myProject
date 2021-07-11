import org.apache.commons.io.FileUtils;

import java.io.File;

import java.io.IOException;

import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        //accept file name
        String fileName = args[0];
        try {
            String fileContent = FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);

            //getting String array
            String[] elements = fileContent.split("\\s+");
            int[] intElements = new int[elements.length];
//initialisation int array
            for (int i = 0; i < elements.length; i++) {
                intElements[i] = Integer.parseInt(elements[i]);
            }
            Statistics stat = new Statistics(intElements);
            stat.printPercentileMedianMaxMinMean();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}