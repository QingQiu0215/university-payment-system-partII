import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class DriverII_remove 
{
	public static void main(String[] args) 
	{
		System.out.println("Attempting to remove a bill from the file: Bills.txt.");
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
		int billNum=0;
		int index=0;
		/**prompt the users to choose a bill number to remove.If the type of bill number is not an long type,enter another one,
		 * if the type is correct,check if it is exist in the bill list, if no, enter another one,if yes,just use remove() method
		 * of ArrayList to remove it.
		 */
		boolean done=false;
		Scanner keyboard=new Scanner(System.in);
		while(!done)
		{
		   try
		   {
		     System.out.println("Please enter bill number:");
		     billNum=keyboard.nextInt();
		     index=sub.getArray().indexOf(new Long(billNum));
		     if(index==-1)
		     {
		    	 System.out.println("The bill number does not exist in the file."); 
		     }
		     else
		     {
		    	 arr.remove(index);
		         done=true;
		     }
		   }
		   catch(InputMismatchException e)
		   {
		         keyboard.nextLine();
		    	 System.out.println("This is not a correct type.Please enter a int type bill number:");
		   }
		}
		/**write all the bills including added bills to the Bills.txt.
		 */
		try
		{
		    pw=new PrintWriter(new FileOutputStream("Bills.txt"));
		    Object[] a=arr.toArray();
		    for(int i=0;i<arr.size();i++)
			  pw.println((Bill)a[i]);
		    System.out.println("The bill was remove from the Bills.txt.");
		    pw.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}

	}

}
