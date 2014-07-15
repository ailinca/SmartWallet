import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
// fa un backup dupa brain, si pune l undeva unde nu l stergi adica ce sa ii fac? sa ilpun pe git?
//poti.
public class Brain {

	public LinkedList<GenericPair<Category, HashMap<Date,  LinkedList<Product>>>> fullmap;
	//cheia e data, valoarea e product.
	int totalcash;
	int totalspend;

	public Brain()
	{
		this.totalcash = 0;
		this.totalspend = 0;
		this.fullmap = new LinkedList<GenericPair<Category, HashMap<Date,  LinkedList<Product>>>>();
	}

	public Brain(int c)
	{
		this.totalcash = c;
		this.totalspend = 0;
		this.fullmap = new LinkedList<GenericPair<Category, HashMap<Date,  LinkedList<Product>>>>(); 
	}

	public int getCash()
	{
		return this.totalcash;
	}

	public int getSpend()
	{
		return this.totalspend;
	}

	public int getRemaining()
	{
		return (this.totalcash - this.totalspend);
	}

	public void addProduct(Product p)
	{
		for(GenericPair<Category, HashMap<Date,  LinkedList<Product>>> itr : fullmap) {
			if(itr.getFirst().getName().equals(p.getCategory().getName()))  {
				if(itr.getSecond().containsKey(p.getDate())) {
					itr.getSecond().get(p.getDate()).add(p);
				} else {
					LinkedList<Product> list = new LinkedList<Product>() ;
					list.add(p);
					itr.getSecond().put(p.getDate(), list);
				}
			}
		}
	}

	public void delProduct(Product p)
	{
		for(GenericPair<Category, HashMap<Date,  LinkedList<Product>>> itr : fullmap) {
			if(itr.getFirst().getName().equals(p.getCategory().getName()))  {
				if(itr.getSecond().containsKey(p.getDate())) {
					itr.getSecond().get(p.getDate()).remove(p); // stai asa, stergi, ce?
				}else System.out.println("You did not purchase anything at that date");//eu nu stiu engleza, sigur.
			}else System.out.println("Esti prost, la tine nu vine Mos Craciun!"); // ......
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

