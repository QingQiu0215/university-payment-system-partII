//-----------------------------------
//Written by: Qing Qiu, 40022237
//For COMP 249 section U Winter-2017 
//Assignment #4
//Part: II
//-----------------------------------
/**create a class Bill which implements interface Bills.
 */
public class Bill implements Bills
{
	/**declares some Bill attributes.
	 */
	private long Id;
	private String supplierName;
	private String companyName;
	private int startYear;
	private long billNum;
	public Bill()
	{
		Id=0;
		supplierName=null;
		companyName=null;
		startYear=0;
		billNum=0;
	}
	public Bill(long newId,String newsupplierName,String newcompanyName,int newstartYear,long newbillNum)
	{
		Id=newId;
		supplierName=newsupplierName;
		companyName=newcompanyName;
		startYear=newstartYear;
		billNum=newbillNum;
	}
	public long getId()
	{
		return Id;
	}
	public void setId(long newId)
	{
		Id=newId;
	}
	public String getSupplierName()
	{
		return supplierName;
	}
	public void setSupplierName(String newsupplierName)
	{
		supplierName=newsupplierName;
	}
	public String getCompanyName()
	{
		return companyName;
	}
	public void setCompanyName(String newcompanyName)
	{
		companyName=newcompanyName;
	}
	public int getStartYear()
	{
		return startYear;
	}
	public void setStartYear(int newStartYear)
	{
		startYear=newStartYear;
	}
	public long getBillNum()
	{
		return billNum;
	}
	public void setBillNum(long newbillNum)
	{
		billNum=newbillNum;
	}
	/**complete the following methods in the interface Bills.
	 */
    public Bill addBill()
    {
    	return new Bill();
    }
    public Bill updateBill()
    {
    	return new Bill();
    }
    public Bill RemoveBill()
    {
    	return new Bill();
    }
    public double findSupplierTotal_Bills(String name)
    {
    	return 0;
    }
    public double findHigh_and_Lowest_Service()
    {
    	return 0;
    }
    public String toString()
    {
    	return Id+"  "+supplierName+"  "+companyName+"  "+startYear+"  "+billNum;
    }
}
