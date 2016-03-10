/*
 * Author: Oliver Thompson
 * Date: March 7, 2016
 * Created and run on NetBeans IDE 8.1
 */

package investmentcalculator;

import java.text.DecimalFormat;
        
public class InvestmentCalculator {
    
    public static void main(String[] args) {
        DecimalFormat decfor = new DecimalFormat();
        decfor.setMaximumFractionDigits(2);
        
        Loan house = new Loan((float).05, 1000, 0, 's', 12, "House", "Bob", "Bank");
        
        System.out.println("Calculate interest for Simple Interest Loan");
        
        //One year of interest
        house.calculate_interest(1);
        System.out.println("One Year of interest: $" + decfor.format(house.get_interest()));
        
        //Two years of interest
        house.calculate_interest(1);
        System.out.println("Two Years of interest: $" + decfor.format(house.get_interest()));
        System.out.println("Total Accrued after two years: $" + decfor.format(house.get_accrued()));
        
        //How long it would take to pay back the loan after not having made any payments for two years
        Loan temp = new Loan(house);
        System.out.println("Repaying Total Accrued with a $10 payment");
        System.out.println("Repaying will take: " + decfor.format(house.repay_loan(10)) + " years");
        

        //How much a payment should be to repay the loan in the given number of payments
        house = new Loan(temp);
        System.out.println("Paying the loan in 18 months will result in");
        System.out.println("a payment of: $" + decfor.format(house.calc_payment(18)) + " per month");
        
        
        Loan car = new Loan((float).05, 1000, 0, 'c', 12, "Car", "Bob", "Bank");
        
        System.out.println("\nCalculate interest for Compound Interest Loan");
        
        //One year of interest
        car.calculate_interest(1);
        System.out.println("Principal after One Year of interest: $" + decfor.format(car.get_principal()));
        
        //Two years of interest
        car.calculate_interest(1);
        System.out.println("Two Years of interest: $" + decfor.format(car.get_principal()));
        System.out.println("Total Accrued after two years: $" + decfor.format(car.get_accrued()));
        
        //How long it would take to pay back the loan after not having made any payments for two years
        temp = new Loan(car);
        System.out.println("Repaying Total Accrued with a $10 payment");
        System.out.println("Repaying will take: " + decfor.format(car.repay_loan(10)) + " years");
        

        //How much a payment should be to repay the loan in the given number of payments
        car = new Loan(temp);
        System.out.println("Paying the loan in 18 months will result in");
        System.out.println("a payment of: $" + decfor.format(car.calc_payment(18)) + " per month");
        
        
        
        
        //Creates a house that was bought with a loan and has an expected sell value
        //Determines how long the house can be lived in before a loss occurs

        HomeSell haus = new HomeSell(150000, (float).06, 15, 185000);
        
        System.out.println("\nCalculate the apropriate time to sell a house");
        System.out.println("The house was bought for: $" + haus.get_borrowed());
        System.out.println("At an annual interest rate of: " + haus.get_rate());
        System.out.println("To be paid over: " + haus.get_years() + " years");
        System.out.println("The house is expected to sell for: $" + haus.get_sell());
        System.out.println("The house will have a monthly payment of: $" + haus.get_payment());
        System.out.println("The house will have a gain if sold on or before the "
                + haus.get_loss() + " payment");
        
        
        //Given a lump sum investment, gives the expected future value
        
        LumpInvestment invest = new LumpInvestment(1500, (float)0.08, 5);
        
        System.out.println("\nCalculating the value of a lump sum investment");
        System.out.println("The amount invested is: $" + invest.get_principal());
        System.out.println("It is invested for: " + invest.get_years() + " years");
        System.out.println("With an expected growth of: " + invest.get_rate());
        System.out.println("Resulting in a future value of: $" + invest.get_future());
        
        
        //If renting for a number of years, determines how much you should invest to reduce the cost of renting
        
        RentInvestment renting = new RentInvestment(1200, 5, (float)0.08);
        
        System.out.println("\nCalculating the amount needed to invest to pay rent");
        System.out.println("Renting at a rate of: $" + renting.get_rent());
        System.out.println("For: " + renting.get_years() + " years");
        System.out.println("With an expected investment growth rate of: " + renting.get_rate());
        System.out.println("The renter will pay a total of: $" + renting.get_total());
        System.out.println("There should be an investment made of: $" + renting.get_investment());
    }
    
}
