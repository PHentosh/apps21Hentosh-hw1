package ua.edu.ucu.tempseries;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    int length;

    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[]{};
        length=temperatureSeries.length;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double temperature:temperatureSeries) {
            if (temperature<-273) {
                throw new IllegalArgumentException(Double.toString(temperature));
            }
        }
        this.temperatureSeries=temperatureSeries;
        this.length=temperatureSeries.length;
    }

    public double[] getTemperatureSeries() {
        return temperatureSeries;
    }

    public double average() {
        if (length==0){
            throw new IllegalArgumentException(temperatureSeries.toString());
        }
        double sum=0;
        for (int i=0;i<length;i++) {
            sum+=temperatureSeries[i];
        }
        return sum/length;
    }

    public double deviation() {
        if (length==0){
            throw new IllegalArgumentException(temperatureSeries.toString());
        }
        double sd = 0;
        double sum = average();
        for (int i=0; i<length;i++) {
            sd+=Math.pow(temperatureSeries[i]-sum, 2);
        }
        return Math.sqrt(sd);
    }

    public double min() {
        if (length == 0){
            throw new IllegalArgumentException(temperatureSeries.toString());
        }
        double min=Integer.MAX_VALUE;
        for (int i=0; i<length; i++) {
            if (temperatureSeries[i] < min){
                min=temperatureSeries[i];
            }
        }
        return min;
    }

    public double max() {
        if (length == 0){
            throw new IllegalArgumentException(temperatureSeries.toString());
        }
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (temperatureSeries[i] > max){
                max = temperatureSeries[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0.0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (length == 0){
            throw new IllegalArgumentException(temperatureSeries.toString());
        }

        double min_dist = Integer.MAX_VALUE;
        int el = 0;
        for (int i = 0; i < length; i++) {
            if (Math.abs(temperatureSeries[i]-tempValue) < min_dist) {
                min_dist = Math.abs(temperatureSeries[i] - tempValue);
                el = i;
            } else if(Math.abs(temperatureSeries[i]-tempValue) == min_dist){
                if (temperatureSeries[i]>0){
                    el = i;
                }
            }
        }
        return temperatureSeries[el];
    }

    public double[] findTempsLessThen(double tempValue) {
        if (length == 0){
            return new double[]{};
        }

        int num = 0;
        for (int i = 0; i < length; i++) {
            if (temperatureSeries[i] < tempValue) {
                num ++;
            }
        }
        double[] lestemp = new double[num];
        if (num == 0){
            return lestemp;
        }
        num = 0;
        for (int i =0; i<length; i++){
            if (temperatureSeries[i] < tempValue) {
                lestemp[num] = temperatureSeries[i];
                num ++;
            }
        }
        return lestemp;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (length == 0){
            return new double[]{};
        }

        int num = 0;
        for (int i = 0; i < length; i++) {
            if (temperatureSeries[i] >= tempValue) {
                num ++;
            }
        }
        double[] lestemp = new double[num];
        if (num == 0){
            return lestemp;
        }
        num = 0;
        for (int i =0; i<length; i++){
            if (temperatureSeries[i] >= tempValue) {
                lestemp[num] = temperatureSeries[i];
                num ++;
            }
        }
        return lestemp;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (length == 0){
            throw new IllegalArgumentException(temperatureSeries.toString());
        }
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < -273) {
                throw new IllegalArgumentException(Double.toString(temp));
            }
        }

        if (length + temps.length > temperatureSeries.length){
            int len;
            if (length == 0){
                len = 1;
            } else {
                len = length;
            }
            double[] nwelist = new double[len*2];
            for (int i=0; i<length; i++){
                nwelist[i] = temperatureSeries[i];
            }
            temperatureSeries = nwelist;
        }
        for (int i=0; i<temps.length; i++){
            temperatureSeries[length+i] = temps[i];
            length ++;
        }
        return 0;
    }
}
