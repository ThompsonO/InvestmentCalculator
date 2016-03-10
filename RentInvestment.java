/*
 * Author: Oliver Thompson
 * Date: March 7, 2016
 * Created and run on NetBeans IDE 8.1
 */

package investmentcalculator;

public class RentInvestment {
    
    //Amount paid in rent each month
    private float rent;
    //Number of years renting
    private int years;
    //Expected growth on investment
    private float rate;
    //Total spent on rent
    private float totalRent;
    //Amount to invest to end with total rent value
    private float investment;
    
    RentInvestment(float f_rent, int f_years, float f_rate)
    {
        rent = f_rent;
        years = f_years;
        rate = f_rate;
        find_rent();
        find_investment();
    }
    
    //Finds the total amount of rent
    private void find_rent()
    {
        totalRent = rent*years*12;
    }
    
    //Finds the amount required to invest
    private void find_investment()
    {
        investment = (float)(totalRent/Math.pow((1+rate), years));
    }
    
    //Returns the monthly rent price
    public float get_rent()
    {
        return rent;
    }
    
    //Returns the expected growth rate
    public float get_rate()
    {
        return rate;
    }
    
    //Returns the years renting
    public float get_years()
    {
        return years;
    }
    
    //Returns the total rent
    public float get_total()
    {
        return totalRent;
    }
    
    //Returns the investment amount
    public float get_investment()
    {
        return investment;
    }
}
