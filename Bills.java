public interface Bills 
{
	public Bill addBill();
    public Bill updateBill();
    public Bill RemoveBill();
    public double findSupplierTotal_Bills(String name);
    public double findHigh_and_Lowest_Service();
}
