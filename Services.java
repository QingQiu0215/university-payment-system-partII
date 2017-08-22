//-----------------------------------
//Written by: Qing Qiu, 40022237
//For COMP 249 section U Winter-2017 
//Assignment #4
//Part: II
//-----------------------------------

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**create a class Services which inherit from Bill
 */
public class Services extends Bill
{

    private int hours;
    private double hourRate;
    private double total;
	private ArrayList<Long> serv_bill=new ArrayList<Long>();//create an ArrayList which store the bill number of Bill.
	private int size=0;//track the number of lines of the bill.txt.ie.number of bills. 
    public Services()
    {
        super();
	    hours=0;
	    hourRate=0;
	    total=0;
    }
    public Services(long newId,String newsupplierName,String newcompanyName,int newstartYear,long newbillNum,int newhours,double newhourRate,double newtotal)
    {
        super(newId,newsupplierName,newcompanyName,newstartYear,newbillNum);
	    hours=newhours;
	    hourRate=newhourRate;
	    total=newtotal;
    }
    public int getHours()
	{
		return hours;
	}
	public void setHours(int newhours)
	{
		hours=newhours;
	}
	public double getHourRate()
	{
		return hourRate;
	}
	public void setHourRate(double newhourRate)
	{
		hourRate=newhourRate;
	}
	public double getTotal()
	{
		return total;
	}
	public void setTotal(double newtotal)
	{
		total=newtotal;
	}
	public ArrayList<Long> getArray()//return the attribute serv_bill.
	{
		return serv_bill;
	}
	/**get the lines of bill.txt.
	 */
	public void getArraySize(Scanner inputFile)
	{	  
	    String line=null;	 	  
	 	while(inputFile.hasNextLine())
	 	{	      
	 	    line=inputFile.nextLine();
	 	    size++;
	 	}
	    inputFile.close();	  
	}
	/**extract the bill number of each line and add to ArrayList serv_bill.
	 */
	public void fillInArrayList(Scanner inputFile)
	{
		long servicesNum=0;
		for(int i=0;i<size;i++)
		{
			inputFile.nextLong();
			inputFile.next();
			inputFile.next();
			inputFile.nextInt();
			servicesNum=inputFile.nextLong();
			inputFile.nextLine();									
			serv_bill.add(servicesNum);
		}		   
	}
	/**add another bill from the users.
	 */
	public Services addBill()
	{
		System.out.println("Please add information of services.");
		Scanner keyboard=new Scanner(System.in);
		long id=0;
		String supplier=null;
		String company=null;
		int year=0;
		long bNum=0;
		int hrs=0;
		double hrsRate=0;
        double tAmount=0;
		int exitInt=0;		
		boolean add=true;//control the while loop.
		boolean done=false;
		boolean duplicate=false;
		/**prompt the user to enter ID.If it is not a long type, the user will be required to 
		 * enter another ID until the correct type will be entered.
		 */
		while(!done)
		{
		   try
		   {
		    	 System.out.println("Please enter ID:");
			     id=keyboard.nextLong();			        
		         done=true;
		   }
		   catch(InputMismatchException e)
		   {
		         keyboard.nextLine();
		    	 System.out.println("This is not a correct type.Please enter a long type ID:");
		   }
		}
		done=false;//set the done=false again, so that it can be used in the following codes.
		keyboard.nextLine();//clean the line.
		System.out.println("Please enter supplier name:");
		supplier=keyboard.nextLine();//prompt the user to enter supplier name.
		System.out.println("Please enter company name:");
		company=keyboard.nextLine();//prompt the user to enter company name.		      
		boolean yearBound=false;//control the validity of year
		/**prompt the user to enter start year.If it is not an int type, the user will be required to 
		 * enter another start year until the correct type will be entered.
		 */
		while(!done)
		{
		   try
		   {
		     System.out.println("Please enter start year:");
		     year=keyboard.nextInt();
		     /**if the years the user entered is not valid, the following while loop 
		      * will be executed until valid year will be entered.
		      */
			 if(year>2018||year<1900)
			    yearBound=true;
		     while(yearBound)
		     {
		        yearBound=false;
		        System.out.println("The start year you entered is unreasonable,please enter another one:");
		        year=keyboard.nextInt();
		        if(year>2018||year<1900)
				    yearBound=true;
		     }
		     done=true;
		   }
		   catch(InputMismatchException e)
		   {
		      keyboard.nextLine();
		      System.out.println("This is not a correct type.Please enter a int type start year:");
		   }
		}
		done=false;
		/**prompt the user to enter bill number.If it is not a long type, the user will be required to 
		 * enter another bill number until the correct type will be entered.
		 */
		while(!done)
		{
		   try
		   {
		     System.out.println("Please enter bill number:");
			 bNum=keyboard.nextLong();
			 if(serv_bill.contains(bNum)==true)//check if the bill number exist in the ArrayList by using contains method.
			    duplicate=true;
			 /**if the bill number exist in the bills, prompt the users to enter another one until different one is entered.
			  */
		     while(duplicate)
		     {
		       duplicate=false;
		       System.out.println("The bill number you entered exiested in the original file,please enter another one:");
		       bNum=keyboard.nextLong();
		       if(serv_bill.contains(bNum)==true)
				  duplicate=true;
		     }
		     done=true;
		   }
		   catch(InputMismatchException e)
		   {
		     keyboard.nextLine();
		     System.out.println("This is not a correct type.Please enter a long type ID:");
		   }
		}
		done=false;
		boolean hrsBound=false;
		/**prompt the user to enter hours.If it is not an int type, the user will be required to 
		 * enter another hours until the correct type will be entered.
		 */
		while(!done)
		{
		   try
		   {
		     System.out.println("Please enter hours:");
		     hrs=keyboard.nextInt();
		     /**if the hours the user entered is not valid, the following while loop 
		      * will be executed until valid hours will be entered.
		      */
			 if(hrs>1000||hrs<0)
			    hrsBound=true;
		     while(hrsBound)
		     {
		        hrsBound=false;
		        System.out.println("The hours you entered is unreasonable,please enter another one:");
		        hrs=keyboard.nextInt();
		        if(hrs>1000||hrs<0)
				hrsBound=true;
		     }
		     done=true;
		   }
		   catch(InputMismatchException e)
		   {
		     keyboard.nextLine();
		     System.out.println("This is not a correct type.Please enter a int type hours:");
		   }
		}		   		   
		done=false;		      		
		/**prompt the user to enter hourly rate.If it is not an double type, the user will be required to 
		 * enter another hourly rate until the correct type will be entered.
		 */
		boolean hrsRateBound=false;
		while(!done)
		{
		   try
		   {
		     System.out.println("Please enter hours rate:");
		     hrsRate=keyboard.nextDouble();
		     /**if the hourly rate the user entered is not valid, the following while loop 
		      * will be executed until valid hourly rate will be entered.
		      */
			 if(hrsRate>10000||hrsRate<0)
			    hrsRateBound=true;
		     while(hrsRateBound)
		     {
		        hrsRateBound=false;
		        System.out.println("The hours rate you entered is unreasonable,please enter another one:");
		        hrsRate=keyboard.nextDouble();
		        if(hrsRate>10000||hrsRate<0)
				    hrsRateBound=true;
		     }
		     done=true;
		   }
		   catch(InputMismatchException e)
		   {
		     keyboard.nextLine();
		     System.out.println("This is not a correct type.Please enter a double type hours rate:");
		   }
		}
		done=false;
		/**prompt the user to enter total amount of money.If it is not an double type, the user will be required to 
		 * enter another total amount of money until the correct type will be entered.
		 */
		boolean amountBound=false;
		while(!done)
		{
		   try
		   {
		     System.out.println("Please enter total amount of money:");
		     tAmount=keyboard.nextDouble();
		     /**if the total amount of money the user entered is not valid, the following while loop 
		      * will be executed until valid total amount of money will be entered.
		      */
			 if(tAmount>2000000||tAmount<0)
			    amountBound=true;
		     while(amountBound)
		     {
		        amountBound=false;
		        System.out.println("The total amount of money you entered is unreasonable,please enter another one:");
		        tAmount=keyboard.nextDouble();
		        if(tAmount>2000000||tAmount<0)
		           amountBound=true;
		     }
		     done=true;
		   }
		   catch(InputMismatchException e)
		   {
		     keyboard.nextLine();
		     System.out.println("This is not a correct type.Please enter a double type total amount of money:");
		   }
		}
		done=false;
		/**create a new object which includes all the attributes the users entered 
		 */
		Services addItems=new Services(id,supplier,company,year,bNum,hrs,hrsRate,tAmount);	
		/**add the new bill number the users entered to the ArrayList. 
		 */
		serv_bill.add(bNum);
		return addItems;//return the new object of Services.
		
	}
	/**updateBill method is to update any information(information of services) in the bill.
	 */
	public Services updateBill()
	{
		System.out.println("Please update information of services.");
		Scanner keyboard=new Scanner(System.in);		
		String YorN=null;//control if the users choose to update or not.
		boolean done=false;	//control the while loops in the followings.		
		/**prompt the users to choose to update ID or not. 
		 */
		System.out.println("Please enter \"y\" to update supplier ID,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))//if choose to update, prompt the users to enter update ID.
		{			
			while(!done)
			{
			   try
			   {
			      System.out.println("Please enter an ID what you want to update:");
			      long id=keyboard.nextLong();
			      setId(id);	
				  keyboard.nextLine();				     
			      done=true;
			   }
			   catch(InputMismatchException e)
			   {
			      keyboard.nextLine();
			      System.out.println("This is not a correct type.Please enter a long type ID:");
			   }
			}
		}
		else//if choose not to update,just output description.
		{
			System.out.println("You chose to keep supplier ID unchanged.");
		}		      
		done=false;  
		/**prompt the users to choose to update supplier name or not. 
		 */
		System.out.println("Please enter \"y\" to update supplier name,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))
		{				
			System.out.println("Please enter supplier name what you want to update:");
			String supname=keyboard.nextLine();
			setSupplierName(supname);					     			 			
		}
		else
		{
			System.out.println("You chose to keep supplier name unchanged.");
		}
		/**prompt the users to choose to update company name or not. 
		 */
		System.out.println("Please enter \"y\" to update company name,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))
		{				
			System.out.println("Please enter company name what you want to update:");
			String comname=keyboard.nextLine();
			setSupplierName(comname);					     			 			
		}
		else
		{
			System.out.println("You chose to keep company name unchanged.");
		}
		/**prompt the users to choose to update start year or not. 
		 */
		System.out.println("Please enter \"y\" to update start year,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))
		{			
			while(!done)
			{
			   try
			   {
			      System.out.println("Please enter start year what you want to update:");
			      int start=keyboard.nextInt();
			      setStartYear(start);	
				  keyboard.nextLine();				     
			      done=true;
			   }
			   catch(InputMismatchException e)
			   {
			      keyboard.nextLine();
			      System.out.println("This is not a correct type.Please enter a int type of start year:");
			   }
			}
		}
		else
		{
			System.out.println("You chose to keep start year unchanged.");
		}		      
		done=false;
		/**prompt the users to choose to update bill number or not. 
		 */
		System.out.println("Please enter \"y\" to update bill number,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))
		{			
			while(!done)
			{
			   try
			   {
			      System.out.println("Please enter bill number what you want to update:");
			      long bill=keyboard.nextLong();
			      setBillNum(bill);	
				  keyboard.nextLine();				     
			      done=true;
			   }
			   catch(InputMismatchException e)
			   {
			      keyboard.nextLine();
			      System.out.println("This is not a correct type.Please enter a long type bill number:");
			   }
			}
		}
		else
		{
			System.out.println("You chose to keep bill number unchanged.");
		}		      
		done=false;
		/**prompt the users to choose to update hours or not. 
		 */
		System.out.println("Please enter \"y\" to update hours,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))
		{			
			while(!done)
			{
			   try
			   {
			      System.out.println("Please enter hours what you want to update:");
			      int hrs=keyboard.nextInt();
			      hours=hrs;	
				  keyboard.nextLine();				     
			      done=true;
			   }
			   catch(InputMismatchException e)
			   {
			      keyboard.nextLine();
			      System.out.println("This is not a correct type.Please enter a int type of hours:");
			   }
			}
		}
		else
		{
			System.out.println("You chose to keep start year unchanged.");
		}		      
		done=false;
		/**prompt the users to choose to update hour rate or not. 
		 */
		System.out.println("Please enter \"y\" to update hour rate,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))
		{			
			while(!done)
			{
			   try
			   {
			      System.out.println("Please enter hour rate what you want to update:");
			      double r=keyboard.nextDouble();
			      hourRate=r;	
				  keyboard.nextLine();				     
			      done=true;
			   }
			   catch(InputMismatchException e)
			   {
			      keyboard.nextLine();
			      System.out.println("This is not a correct type.Please enter a double type hour rate:");
			   }
			}
		}
		else
		{
			System.out.println("You chose to keep hour rate unchanged.");
		}		      
		done=false;
		/**prompt the users to choose to total amount rate or not. 
		 */
		System.out.println("Please enter \"y\" to update total bill,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))
		{			
			while(!done)
			{
			   try
			   {
			      System.out.println("Please enter total bill what you want to update:");
			      double t=keyboard.nextDouble();
			      total=t;	
				  keyboard.nextLine();				     
			      done=true;
			   }
			   catch(InputMismatchException e)
			   {
			      keyboard.nextLine();
			      System.out.println("This is not a correct type.Please enter a double type total bill:");
			   }
			}
		}
		else
		{
			System.out.println("You chose to keep total bill unchanged.");
		}		      
		done=false;
		/**return a new Services object with all attributes the users entered.
		 */
		return new Services(getId(),getSupplierName(),getCompanyName(),getStartYear(),getBillNum(),hours,hourRate,total);
	}
	/**to remove a bill from the bill list.However, the method will not be used because the remove() method of ArrayList
	 * is used in the main method.
	 */
	public Services removeBill()
	{
		return new Services();
	}
	/**to return the total amount of bills.
	 */
	public double findSupplierTotal_Bills(String name)
	{
		return total;
	}
	/**to return the High or lowest hour rate of Service of bills.
	 */
	public double findHigh_and_Lowest_Service()
    {
    	return hourRate;
    }
	public String toString()
	{
		return super.toString()+"  "+hours+"  "+hourRate+"  "+total;	   			
	}
}
