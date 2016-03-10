/*
 * Author: Oliver Thompson
 * Date: March 7, 2016
 * Created and run on NetBeans IDE 8.1
 */

package investmentcalculator;

public class LumpInvestment {
    
    //The amount invested
    private float principal;
    //The expected annual rate of growth
    private float rate;
    //The amount of years the principal will be invested
    private int years;
    //The expected future value of the investment
    private float futureValue;
    
    LumpInvestment(float f_principal, float f_rate, int f_years)
    {
        principal = f_principal;
        rate = f_rate;
        years = f_years;
        future_val();
    }
    
    //The future value after a provided number of years and given growth rate of a principal amount
    private void future_val()
    {
        futureValue = (float)(principal*(Math.pow((1+rate), (years))));
    }
    
    //Returns the principal amount
    public float get_principal()
    {
        return principal;
    }
    
    //Returns the expected growth rate
    public float get_rate()
    {
        return rate;
    }
    
    //Returns the years invested
    public float get_years()
    {
        return years;
    }
    
    //Returns the expected future value
    public float get_future()
    {
        return futureValue;
    }
}
