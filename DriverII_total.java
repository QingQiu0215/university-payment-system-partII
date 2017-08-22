import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class DriverII_total 
{
	public static void main(String[] args) 
	{
		System.out.println("Attempting to calculate the total amount of special supplier from the file: Bills.txt.");
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
		/**prompt the users to choose a supplier name and calculate the total amount of them.
		 */
		Scanner keyboard=new Scanner(System.in);
		String name=null;
		boolean done=false;
		double total=0;
		Object[] a1=arr.toArray();
		while(!done)
		{	
			System.out.println("Please enter supplier name you want to calculate:");
			name=keyboard.nextLine();
			for(int i=0;i<sub.getSize();i++)
			{
				/**search each object in the ArrayList<Bill> arr,if it match the name the users entered,
				 * add the amount to the total.
				 */
				if(((Bill)a1[i]).getSupplierName().equalsIgnoreCase(name))
					total+=((Bill)a1[i]).findSupplierTotal_Bills(name);//evoke the correctfindSupplierTotal_Bills to return the amount. 
			}
			if(total!=0)//if the supplier name exist in the bill,the while loop end.
				done=true;	
			else//if the supplier name does not exist in the bill,the while loop execute.
			{
				System.out.println("The supplier name do not exist in the file.");
			}
		}
		done=false;
		System.out.println("Total amount of "+name+" is: "+total);
	}

}
