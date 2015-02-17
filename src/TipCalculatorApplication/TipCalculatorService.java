
package TipCalculatorApplication;

public class TipCalculatorService {
    
    public final double getTip(TipStrategy tc)
    {
        if(tc == null)
        {
            System.exit(1);
        }
        return tc.getTip();
    }
    
}
