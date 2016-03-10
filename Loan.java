/*
 * Author: Oliver Thompson
 * Date: Feb. 28, 2016
 * Created and run on NetBeans IDE 8.1
 */

package investmentcalculator;

public class Loan
{
  //The percentage rate of interest
  private float rate;
  //The principal amount of the loan
  private float principal;
  //The ammount of interest accrued
  private float interest;
  //The total amount accrued
  private float accrued;
  //The type of interest: "s" for simple, "c" for compound
  private char interestType;
  //How often the interest is compounded per year
  private int compounded;
  //The name of the loan
  private String name;
  //The borrower of the loan who owes the lender
  private String borrower;
  //The lender who is owed the value of the loan
  private String lender;
  
  //Defaults all values to 0 or N/A if no data is given
  public Loan()
  {
      rate = 0;
      principal = 0;
      interest = 0;
      accrued = 0;
      interestType = 0;
      compounded = 0;
      name = "N/A";
      borrower = "N/A";
      lender = "N/A";
  }
  
  public Loan(Loan x)
  {
      rate = x.get_rate();
      principal = x.get_principal();
      interest = x.get_interest();
      accrued = x.get_accrued();
      interestType = x.get_interest_type();
      compounded = x.get_compounded();
      name = x.get_name();
      borrower = x.get_borrower();
      lender = x.get_lender();
  }      
  
  //Sets all member variables to the function's values in the full Constructor
  public Loan(float f_rate, float f_principal, float f_interest, char f_interestType, 
          int f_compounded, String f_name, String f_borrower, String f_lender)
  {
      rate = f_rate;
      principal = f_principal;
      interest = f_interest;
      accrued = principal + interest;
      interestType = f_interestType;
      compounded = f_compounded;
      name = f_name;
      borrower = f_borrower;
      lender = f_lender;
  }  
  
  //Sets the interest rate
  public void set_rate(float new_rate)
  {
      rate = new_rate;
  }
  
  //Returns the interest rate
  public float get_rate()
  {
      return rate;
  }
  
  //Sets the loan's principal
  public void set_principal(float new_principal)
  {
      principal = new_principal;
  }
  
  //Returns the loan's principal
  public float get_principal()
  {
      return principal;
  }
  
  //Sets the loan's interest
  public void set_interest(float new_interest)
  {
      interest = new_interest;
  }
  
  //Returns the loan's interest
  public float get_interest()
  {
      return interest;
  }
  
  //Sets the amount accrued on the loan
  public void set_accrued()
  {   
      accrued = principal + interest;
  }
  
  //Returns the total amount accrued
  public float get_accrued()
  {
      return accrued;
  }
  
  //Sets the interest type
  public void set_interest_type(char new_interest_type)
  {
      interestType = new_interest_type;
  }
  
  //Returns the interest type
  public char get_interest_type()
  {
      return interestType;
  }
  
  //Sets how often the loan is compounded
  public void set_compounded(int new_compounded)
  {
      compounded = new_compounded;
  }
  
  //Returns how often the loan is compounded
  public int get_compounded()
  {
      return compounded;
  }
  
  //Sets the name of the loan
  public void set_name(String new_name)
  {
      name = new_name;
  }
  
  //Returns the name of the loan
  public String get_name()
  {
      return name;
  }

  //Sets the name of the loan borrower
  public void set_borrower(String new_borrower)
  {
      borrower = new_borrower;
  }
  
  //Returns the name of the loan borrower
  public String get_borrower()
  {
      return borrower;
  }
  
  //Sets the name of the loan lender
  public void set_lender(String new_lender)
  {
      lender = new_lender;
  }
  
  //Returns the name of the loan lender
  public String get_lender()
  {
      return lender;
  }
  
  //Calculates the interest on a loan after a given number of years
  public void calculate_interest(float years)
  {
      //Simple interest
      if(interestType == 's')
      {
          //Adds new interest to previous interest
          interest += principal*rate*years;
          accrued = principal + interest;
      }
      
      //Compounded interest
      else if(interestType == 'c')
      {
          //Interest is not set as it is compounded
          principal = (float)(principal*(Math.pow((1+(rate/compounded)), (compounded*years))));
          accrued = principal;
          interest = 0;
      }
      
  }
  
  //Calculates how many years it will take to repay a loan
  //given a monthly payment of "payment"
  public float repay_loan(float payment)
  {
      float repayYears = 0;
      int payments = 0;
      
      //Simple interest
      if(interestType == 's')
      {
          //Makes sure that the payment is greater than the interest
          if(payment*12 > principal*rate*1)
          {
            //While there is still money owed on the loan
            while((accrued) >= 0)
            {
              //Makes a payment
              interest = interest - payment;
              payments++;
              set_accrued();
              
              //Recalculates interest every year
              if(payments%12 == 0)
              {
                  //Subtracts the repaid amount from the principal
                  principal = interest + principal;
                  interest = 0;
                  
                  //Calculates the interest for the year
                  calculate_interest(1);
              }
            }
          }
          
          //Returns -1 as an error since the loan will never be repaid
          else
          {
              repayYears = -1;
          }
      }
      
      //Compound interest
      else if(interestType == 'c')
      {
          //Makes sure that the payment is greater than the interest
          if(payment*12 > principal*Math.pow((rate/compounded), (compounded*1)))
          {
              //Creates a checkpoint to test if interest needs to be compounded
              float checkpoint = 360/compounded/30;
              
              //While the loan has not been paid off
              while(accrued >= 0)
              {
                  //Checks if interest needs to be calculated
                  if(payments != 0 && payments%checkpoint == 0)
                  {
                    //Calculates for the fraction of the year that has passed
                    calculate_interest(1/compounded);
                  }
                  
                  //Makes a payment
                  principal = principal - payment;
                  payments++;
                  set_accrued();
                  
              }
          }
          
          //Returns -1 as an error since the loan will never be repaid
          else
          {
              repayYears = -1;
          }
          
      }
      
      //Calculates the number of years it would take to repay the loan
      repayYears = repayYears + (float)payments/12;
      
      return repayYears;
  }
  
  
  //Calculates how many much a payment should be given a number of monthly payments
  public float calc_payment(int payments)
  {
      float years;
      float payment = 0;
      float tempAccrued;
      
      
      
      //Simple interest
      if(interestType == 's')
      {
          //Calculates the number of years and months of payments
          //Integer division is performed here as the remainder months will not
          //be charged interest
          years = payments/12;
          
          //Calculates the number amount accrued
          calculate_interest(years);
          
          //Divides the accrued amount by the desired number of payments
          payment = accrued/payments;
      }
      
      //Compound interest
      else if(interestType == 'c')
      {
          Loan temp;
          
          //Calculates the number of years the payments convert to
          years = (float)payments/12;
          
          temp = new Loan (this);
        
          //Calculates the total accrued after the calculated years
          temp.calculate_interest(years);
          
          tempAccrued = temp.get_accrued();
          
          //Divides up total accrued by the number of payments
          //This is an approximation that will be over actual payment amount
          payment = tempAccrued/payments;
                    
          //Finds the actual payment amount
          do
          {
            temp = new Loan(this);
            
            //Uses approximate payment value to calculate how long
            //it would take to pay the loan off
            years = temp.repay_loan(payment);
          
            //If the amount of years does not match the desired number of payments
            if(Math.ceil(years*12) != payments)
            {
              //Decremetns the approximate payment by 1 cent
              payment = payment - (float).01;
            }
            //Will repeat until the payment causes the loan to be repaid in the
            //Desired amount of time
          } while(Math.ceil(years*12) != payments);
          
      }
          
      return payment;
  }
  
  
}
