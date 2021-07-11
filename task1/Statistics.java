import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

public class Statistics {
    private final DescriptiveStatistics stat = new DescriptiveStatistics();
    private int[] arr;


    public Statistics(int[] arr) {
        this.arr = arr;
        stat.setPercentileImpl(new Percentile().
                withEstimationType(Percentile.EstimationType.R_7));
        for (int num : arr) {
            stat.addValue(num);


        }
    }

    public double getMin() {
        return stat.getMin();
    }

    public double getMax() {
        return stat.getMax();
    }

    public double getPercentiles90() {
        return stat.getPercentile(90);
    }

    public double getMedian() {
        return stat.getPercentile(50);
    }

    public double getMean() {
        return stat.getMean();
    }

    public int[] getArr() {
        return arr;
    }

    public void printPercentileMedianMaxMinMean() {
        System.out.println(String.format("%.2f", getPercentiles90()));
        System.out.println(String.format("%.2f", getMedian()));
        System.out.println(String.format("%.2f", getMax()));
        System.out.println(String.format("%.2f", getMin()));
        System.out.println(String.format("%.2f", getMean()));

    }
}
