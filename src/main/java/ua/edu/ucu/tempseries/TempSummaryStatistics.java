package ua.edu.ucu.tempseries;

import java.util.Objects;

public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;

    public TempSummaryStatistics() {
    }

    public TempSummaryStatistics(double avgTemp, double devTemp,
                                 double minTemp, double maxTemp) {
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avg) {
        this.avgTemp = avg;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public void setDevTemp(double dev) {
        this.devTemp = dev;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double min) {
        this.minTemp = min;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double max) {
        this.maxTemp = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TempSummaryStatistics that = (TempSummaryStatistics) o;
        return Double.compare(that.avgTemp, avgTemp) == 0
                && Double.compare(that.devTemp, devTemp) == 0
                && Double.compare(that.minTemp, minTemp) == 0
                && Double.compare(that.maxTemp, maxTemp) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(avgTemp, devTemp, minTemp, maxTemp);
    }
}
