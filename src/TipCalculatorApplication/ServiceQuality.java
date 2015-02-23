
package TipCalculatorApplication;

public enum ServiceQuality {
    GOOD(0.20), FAIR(0.15), POOR(0.10);
     
    private double percent;
    
    
    ServiceQuality(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
