package prediction;

import java.util.List;

public class PredictionResult {
    private String drug;

    private Double decadeBasedRisk;
    private Double yearBasedRisk;
    private Double monthBasedRisk;
    private Double weekBasedRisk;

    PredictionResult(String drug, List<Double> rawProbability) {
        this.drug = drug;

        // Im not sure that its right way to calculate probability for different classification problems
        decadeBasedRisk  = rawProbability.get(2) + rawProbability.get(3) + rawProbability.get(4) + rawProbability.get(5)
                + rawProbability.get(6);
        yearBasedRisk = rawProbability.get(3) + rawProbability.get(4) + rawProbability.get(5) + rawProbability.get(6);
        monthBasedRisk = rawProbability.get(4) + rawProbability.get(5) + rawProbability.get(6);
        weekBasedRisk = rawProbability.get(5) + rawProbability.get(6);
    }


    public String getDrug() {
        return drug;
    }

    public Double getDecadeBasedRisk() {
        return decadeBasedRisk;
    }

    public Double getYearBasedRisk() {
        return yearBasedRisk;
    }

    public Double getMonthBasedRisk() {
        return monthBasedRisk;
    }

    public Double getWeekBasedRisk() {
        return weekBasedRisk;
    }

    @Override
    public String toString() {
        return "PredictionResult{" +
                "drug='" + drug + '\'' +
                ", decadeBasedRisk=" + decadeBasedRisk +
                ", yearBasedRisk=" + yearBasedRisk +
                ", monthBasedRisk=" + monthBasedRisk +
                ", weekBasedRisk=" + weekBasedRisk +
                '}';
    }
}
