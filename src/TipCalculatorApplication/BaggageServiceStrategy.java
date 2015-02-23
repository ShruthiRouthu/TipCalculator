
package TipCalculatorApplication;


public class BaggageServiceStrategy  implements TipStrategy{
     
    private static final double MIN_BILL = 0.00;
    private static final double MAX_BILL = 100.00;
    private static final String BILL_ENTRY_ERR = "Error: bill must be between " + MIN_BILL + " and "
                                                 + MAX_BILL; 
    
    private double baseTipPerBag;
    private int bagCount;
    
   
    private ServiceQuality serviceQuality;
    
    // Constructor
    public BaggageServiceStrategy(ServiceQuality q, int bags) {
        this.setServiceRating(q); // perform validation
        this.setBagCount(bags);

        baseTipPerBag = 1.00; // set default value
    }
    
    // Overloading Constructor for flexibility
    public BaggageServiceStrategy(ServiceQuality q, int bags, double baseTipPerBag) {
        // perform validation
        this.setServiceRating(q); 
        this.setBagCount(bags);
        this.setBaseTipPerBag(baseTipPerBag);
        
    }
    

    public final double getTip() {
        return  baseTipPerBag * bagCount * (1 + serviceQuality.getPercent());
    }

    public final void setServiceRating(ServiceQuality q) {
        // No need to validate because enums provide type safety!
        serviceQuality = q;
    }

    public  final ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

    public  final int getBagCount() {
        return bagCount;
    }

    public final void setBagCount(int bagCount) {
        if(bagCount < 0) {
            throw new IllegalArgumentException(
                    "bag count must be greater than or equal to zero");
        }
        this.bagCount = bagCount;
    }

    public final double getBaseTipPerBag() {
        return baseTipPerBag;
    }

    public final void setBaseTipPerBag(double baseTipPerBag) {
        if(baseTipPerBag < 0) {
            throw new IllegalArgumentException(
                    "error: base tip must be greater than or equal to zero");
        }
        this.baseTipPerBag = baseTipPerBag;
    }
}
