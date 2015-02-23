
package TipCalculatorApplication;


public class FoodServiceStrategy implements TipStrategy{
    
    private static final double MIN_BILL = 0.00;
    private static final String BILL_ENTRY_ERR = "Error: bill must be greater than or equal to " + MIN_BILL;
           
    private ServiceQuality serviceQuality;
    private double bill;
    
    //Constructor
    public FoodServiceStrategy(ServiceQuality q, double billAmt) {
        this.setServiceRating(q);
        this.setBill(billAmt);
    }

    public final double getTip() {          
          return  bill * serviceQuality.getPercent();         
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
