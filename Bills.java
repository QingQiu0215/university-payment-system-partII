//-----------------------------------
//Written by: Qing Qiu, 40022237
//For COMP 249 section U Winter-2017 
//Assignment #4
//Part: II
//-----------------------------------
/**create a interface Bills with several methods(empty).
 */
public interface Bills 
{
	public Bill addBill();
    public Bill updateBill();
    public Bill RemoveBill();
    public double findSupplierTotal_Bills(String name);
    public double findHigh_and_Lowest_Service();
}
