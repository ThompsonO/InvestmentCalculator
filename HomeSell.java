/*
 * Author: Oliver Thompson
 * Date: March 7, 2016
 * Created and run on NetBeans IDE 8.1
 */

package investmentcalculator;

public class HomeSell {
    
    //The amount borrowed for the loan
    private float borrowed;
    //The annual rate of interest on the loan
    private float rate;
    //The number of years to repay the loan
    private int years;
    //The desired amount to sell the loan for
    private float sell;
    //The monthly interest rate
    private float m_rate;
    //The monthly payment on the loan
    private float m_payment;
    //The difference between the sell price and the loan principal
    private float gain;
    //The point at which selling after would result in a loss
    //in number of monthly payments
    private int lossPoint;
    
    
    public HomeSell(float f_borrowed, float f_rate, int f_years, float f_sell)
    {
        borrowed = f_borrowed;
        rate = f_rate;
        years = f_years;
        sell = f_sell;
        monthly_rate();
        monthly_payment();
        find_gain();
        find_loss();
    }
    
    //Calculates the monthly interest rate
    private void monthly_rate()
    {
        m_rate = rate/12;
    }
    
    //Calculates the monthly loan payment
    //M = ((P*(1+r)^n)*r ) / (((1+r)^n)-1)
    private void monthly_payment()
    {
        m_payment = (float)(borrowed*(Math.pow((1+m_rate), (years*12)))*m_rate)
                /(float)((Math.pow((1+m_rate), (years*12))) - 1);
    }
    
    //The amount gained once the house is sold
    private void find_gain()
    {
        gain = sell-borrowed;
    }
    
    //The point at which selling after would result in a loss
    private void find_loss()
    {
        if(m_payment > 0)
        {
          lossPoint = (int)(gain/m_payment);
        }
    }
    
    //Returns the gain on the house
    public float get_gain()
    {
        return gain;
    }
    
    //Returns the monthly payment on the loan
    public float get_payment()
    {
        return m_payment;
    }
    
    //Returns the point at which there is a loss on the house
    public float get_loss()
    {
        return lossPoint;
    }
    
    //Returns the amount borrowed
    public float get_borrowed()
    {
        return borrowed;
    }
    
    //Returns the annual rate of interest on the loan
    public float get_rate()
    {
        return rate;
    }
    
    //Returns the number of years to pay off the loan
    public float get_years()
    {
        return years;
    }
    
    //Returns the sell value of the house
    public float get_sell()
    {
        return sell;
    }
    
}
