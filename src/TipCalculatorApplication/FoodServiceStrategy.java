
package TipCalculatorApplication;


public class FoodServiceStrategy implements TipStrategy{
    
    private static final double MIN_BILL = 0.00;
    private static final String BILL_ENTRY_ERR = "Error: bill must be greater than or equal to " + MIN_BILL;
            
    private static final double GOOD_RATE = 0.20;
    private static final double FAIR_RATE = 0.15;
    private static final double POOR_RATE = 0.10;

   
    
    private ServiceQuality serviceQuality;
    
    private double bill;
    
    //Constructor
    public FoodServiceStrategy(ServiceQuality q, double billAmt) {
        this.setServiceRating(q);
        this.setBill(billAmt);
    }

    public final double getTip() {
        double tip = 0.00; // always initialize local variables

        switch(serviceQuality) {
            case GOOD:
                tip = bill * GOOD_RATE;
                break;
            case FAIR:
                tip = bill * FAIR_RATE;
                break;
            case POOR:
                tip = bill * POOR_RATE;
                break;
        }

        return tip;
    }

    public final void setBill(double billAmt) {
        if(billAmt < MIN_BILL) {
            throw new IllegalArgumentException(BILL_ENTRY_ERR);
        }
        bill = billAmt;
    }

    public final double getBill() {
        return bill;
    }  
    
    public final void setServiceRating(ServiceQuality q) {
        // No need to validate because enums provide type safety!
        serviceQuality = q;
    }

    public final ServiceQuality getServiceQuality() {
        return serviceQuality;
    }
    
}