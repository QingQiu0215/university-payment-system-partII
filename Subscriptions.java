//-----------------------------------
//Written by: Qing Qiu, 40022237
//For COMP 249 section U Winter-2017 
//Assignment #4
//Part: II
//-----------------------------------

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**the following comments are similar as that in class Services except special and different cases.
 */
public class Subscriptions extends Bill
{
	enum type {WEEKLY,BI_WEEKLY,BI_MONTHLY,MONTHLY,TRIMESTER,SEMESTER,YEARLY};//declare an enumerate type of payment type.
	private type t;
	private double amount;	
	private ArrayList<Long> s_bill=new ArrayList<Long>();
	private int size=0;
	public Subscriptions()
	{
		super();
		t=type.WEEKLY;
		amount=0;
	}
	public Subscriptions(long newId,String newsupplierName,String newcompanyName,int newstartYear,long newbillNum,String newt,double newamount)
	{
		super(newId,newsupplierName,newcompanyName,newstartYear,newbillNum);
		t=type.valueOf(newt.toUpperCase());//convert the passing parameter to upper case and to enumerate type and assign it to attribute t.
		amount=newamount;
	}
	public type getType()
	{
		return t;
	}
	public void setType(type newt)
	{
		t=newt;
	}
	public double getAmount()
	{
		return amount;
	}
	public ArrayList<Long> getArray()
	{
		return s_bill;
	}
	public void setAmount(double newamount)
	{
		amount=newamount;
	}
	public int getSize()
	{
		return size;
	}
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
	public void fillInArrayList(Scanner inputFile)
	{
		long sub=0;
		for(int i=0;i<size;i++)
		{
			inputFile.nextLong();
			inputFile.next();
			inputFile.next();
			inputFile.nextInt();
			sub=inputFile.nextLong();
			inputFile.nextLine();									
			s_bill.add(sub);
		}
		inputFile.close();
	}
	public Subscriptions addBill()
	{
		System.out.println("Please add information of subscription.");
		Scanner keyboard=new Scanner(System.in);
		long id=0;
		String supplier=null;
		String company=null;
		int year=0;
		long bNum=0;
		String subType=null;
		int exitInt=0;
		double tAmount=0;
		boolean add=true;
		boolean done=false;
		boolean duplicate=false;		
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
		   done=false;
		   keyboard.nextLine();
		   System.out.println("Please enter supplier name:");
		   supplier=keyboard.nextLine();
		   System.out.println("Please enter company name:");
		   company=keyboard.nextLine();		      
		   boolean yearBound=false;
		   while(!done)
		   {
		      try
		      {
		    	 System.out.println("Please enter start year:");
		    	 year=keyboard.nextInt();
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
		   while(!done)
		   {
		      try
		      {
		    	 System.out.println("Please enter bill number:");
			     bNum=keyboard.nextLong();
			     keyboard.nextLine();
			     if(s_bill.contains(bNum)==true)
			      	duplicate=true;
		         while(duplicate)
		         {
		        	duplicate=false;
		        	System.out.println("The bill number you entered exiested in the original file,please enter another one:");
		        	bNum=keyboard.nextLong();
		        	keyboard.nextLine();
		        	if(s_bill.contains(bNum)==true)
				       duplicate=true;
		          }
		          done=true;
		      }
		      catch(InputMismatchException e)
		      {
		         keyboard.nextLine();
		    	 System.out.println("This is not a correct type.Please enter a long type bill number:");
		      }
		   }		   
		   done=false;
		   while(!done)
		   {
		      System.out.println("Please enter valid payment type(WEEKLY,BI_WEEKLY,MONTHLY,TRIMESTER,SEMESTER,YEARLY):");
	    	  subType=keyboard.nextLine();
	    	  subType=subType.toUpperCase();
	    	  type[] paymentType=type.values();	        
		      for(int i=0;i<paymentType.length;i++)
		      {
		    	 if(paymentType[i].toString().equals(subType))
		    	 {
		    	    done=true;
		    	    break;
		    	 }
		      }		            		      
		   }
		   done=false;		      		      
		   boolean amountBound=false;
		   while(!done)
		   {
		      try
		      {
		    	 System.out.println("Please enter total amount of money:");
		    	 tAmount=keyboard.nextDouble();
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
		   Subscriptions addItems=new Subscriptions(id,supplier,company,year,bNum,subType,tAmount);		   
		   s_bill.add(bNum);
		   return addItems;		   				
	}
	public Subscriptions updateBill()
	{
		System.out.println("Please update information of subscription.");
		Scanner keyboard=new Scanner(System.in);		
		String YorN=null;
		boolean done=false;	
		
		System.out.println("Please enter \"y\" to update supplier ID,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))
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
		else
		{
			System.out.println("You chose to keep supplier ID unchanged.");
		}		      
		done=false;  
		
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
		
		System.out.println("Please enter \"y\" to update payment type,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))
		{
		   while(!done)
		   {
		      System.out.println("Please enter valid payment type(WEEKLY,BI_WEEKLY,MONTHLY,TRIMESTER,SEMESTER,YEARLY):");
	    	  String payment=keyboard.nextLine();
	    	  payment=payment.toUpperCase();
	    	  type[] paymentType=type.values();	        
		      for(int i=0;i<paymentType.length;i++)
		      {
		    	 if(paymentType[i].toString().equals(payment))
		    	 {
		    	    done=true;
		    	    t=type.valueOf(payment);
		    	    break;
		    	 }
		      }		            		      
		   }   
		}
		else
		{
			System.out.println("You chose to keep bill number unchanged.");
		}		      
		done=false;
		
		System.out.println("Please enter \"y\" to update subscription amount,otherwise will not update:");
		YorN=keyboard.nextLine();
		if(YorN.equalsIgnoreCase("y"))
		{			
			while(!done)
			{
			   try
			   {
			      System.out.println("Please enter subscription amount what you want to update:");
			      double a=keyboard.nextDouble();
			      amount=a;	
				  keyboard.nextLine();				     
			      done=true;
			   }
			   catch(InputMismatchException e)
			   {
			      keyboard.nextLine();
			      System.out.println("This is not a correct type.Please enter a double type subscription amount:");
			   }
			}
		}
		else
		{
			System.out.println("You chose to keep supplier subscription amount unchanged.");
		}		      
		done=false;
		return new Subscriptions(getId(),getSupplierName(),getCompanyName(),getStartYear(),getBillNum(),t.toString(),amount);
	}
	public Subscriptions removeBill()
	{
		return new Subscriptions();
	}
	public double findSupplierTotal_Bills(String name)
	{
		return amount;
	}
	public String toString()
	{
		return super.toString()+"  "+t.toString()+"  "+amount; 	   			
    }
} 
