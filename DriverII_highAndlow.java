import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class DriverII_highAndlow 
{
	public static void main(String[] args) 
	{
		System.out.println("Attempting to find the highest and lowest hourly rate of services from the file: Bills.txt.");
		System.out.println("============================================================");	  
		Scanner inputF=null;
		PrintWriter pw=null;
		ArrayList<Bill> arr=new ArrayList<Bill>();//create an ArrayList to store all the bills information.
		Subscriptions sub=new Subscriptions();//create a Subscriptions object to evoke attributes and methods in the class.
		Services ser=new Services();//create a Services object to evoke attributes and methods in the class. 			
		/**get size of arrayList.*/
		try
		{
			inputF=new Scanner(new FileInputStream("Bills.txt"));
			sub.getArraySize(inputF);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		/**store all the bill numbers in the ArrayList<Long> s_bill.*/
		try
		{
			inputF=new Scanner(new FileInputStream("Bills.txt"));
			sub.fillInArrayList(inputF);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		/**read each bill and store it to the ArrayList<Bill> arr.
		 */
		try
		{
			inputF=new Scanner(new FileInputStream("Bills.txt"));
			Bill b1=new Subscriptions(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.next(),inputF.nextDouble());
			Bill b2=new Services(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.nextInt(),inputF.nextDouble(),inputF.nextDouble());
			Bill b3=new Subscriptions(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.next(),inputF.nextDouble());
			Bill b4=new Subscriptions(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.next(),inputF.nextDouble());
			Bill b5=new Subscriptions(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.next(),inputF.nextDouble());
			Bill b6=new Services(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.nextInt(),inputF.nextDouble(),inputF.nextDouble());
			Bill b7=new Services(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.nextInt(),inputF.nextDouble(),inputF.nextDouble());
			Bill b8=new Services(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.nextInt(),inputF.nextDouble(),inputF.nextDouble());
			Bill b9=new Subscriptions(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.next(),inputF.nextDouble());
			Bill b10=new Services(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.nextInt(),inputF.nextDouble(),inputF.nextDouble());
			Bill b11=new Subscriptions(inputF.nextLong(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextLong(),inputF.next(),inputF.nextDouble());					
			arr.add(b1);
			arr.add(b2);
			arr.add(b3);
			arr.add(b4);
			arr.add(b5);
			arr.add(b6);
			arr.add(b7);
			arr.add(b8);
			arr.add(b9);
			arr.add(b10);
			arr.add(b11);
			inputF.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		Object[] a1=arr.toArray();
		double max=((Services)a1[1]).findHigh_and_Lowest_Service();
		double min=((Services)a1[1]).findHigh_and_Lowest_Service();
        for(int i=0;i<sub.getSize();i++)
        {
        	/**check which bill is service and check if its hourly rate is bigger than max.
        	 */
        	if(a1[i].getClass()==(new Services()).getClass()&&((Services)a1[i]).findHigh_and_Lowest_Service()>max)
        	{
        		max=((Services)a1[i]).findHigh_and_Lowest_Service();
        	}
        }
        for(int i=0;i<sub.getSize();i++)
        {
        	/**check which bill is service and check if its hourly rate is smaller than min.
        	 */
        	if(a1[i].getClass()==(new Services()).getClass()&&((Services)a1[i]).findHigh_and_Lowest_Service()<min)
        	{
        		min=((Services)a1[i]).findHigh_and_Lowest_Service();
        	}
        }
        /**output all the highest and lowest hourly rate of service in the bill.
    	 */
		for(int i=0;i<sub.getSize();i++)
		{
			if(a1[i].getClass()==(new Services()).getClass()&&((Services)a1[i]).findHigh_and_Lowest_Service()==max)
				System.out.println("The highest hourly rate of service are:"+a1[i]);	
		}
		for(int i=0;i<sub.getSize();i++)
		{
			if(a1[i].getClass()==(new Services()).getClass()&&((Services)a1[i]).findHigh_and_Lowest_Service()==min)
				System.out.println("The lowest hourly rate of service are:"+a1[i]);	
		}
	}
}
