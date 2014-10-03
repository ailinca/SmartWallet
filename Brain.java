import java.awt.Color;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument.Iterator;
public class Brain {

	public LinkedList<GenericPair<Category, HashMap<String,  LinkedList<Product>>>> fullmap;
	int totalcash;
	int totalspend;

	public Brain()
	{
		this.totalcash = 0;
		this.totalspend = 0;
		this.fullmap = new LinkedList<GenericPair<Category, HashMap<String,  LinkedList<Product>>>>();
	}

	public Brain(int c)
	{
		this.totalcash = c;
		this.totalspend = 0;
		this.fullmap = new LinkedList<GenericPair<Category, HashMap<String,  LinkedList<Product>>>>(); 
	}

	public int getCash()
	{
		return this.totalcash;
	}

	public int getSpend()
	{
		Food a = new Food("Food");
		Beverage b = new Beverage("Beverage");
		Clothing c = new Clothing("Clothing");
		Entertainment d = new Entertainment("Entertainment");
		Taxes e = new Taxes("Taxes");
		return CategorySpendings(a) + CategorySpendings( b) + CategorySpendings(c) + CategorySpendings( d) + CategorySpendings(e);
	}

	public int getRemaining()
	{
		return (this.totalcash - this.totalspend);
	}
	
	public int CategorySpendings(Category c)
	
	{	
		int s=0;
		for (GenericPair<Category, HashMap<String,  LinkedList<Product>>> itr : fullmap) {
			if(itr.getFirst().getName().equals(c.getName())) {
				for (LinkedList<Product> pListItr: itr.getSecond().values()) {
					for(Product pItr : pListItr) {
						s += pItr.price;
					}
				}

			}
		}
		return s;
	}
	
	
	public void addProduct(Product p)
	{
		boolean categExists = false;
		for(GenericPair<Category, HashMap<String,  LinkedList<Product>>> itr : fullmap) {
			if(itr.getFirst().getName().equals(p.getCategory().getName()))
				categExists = true;		
		}
		if(!categExists) {
			HashMap<String,  LinkedList<Product>> h = new HashMap<String,  LinkedList<Product>>();
			GenericPair<Category, HashMap<String,  LinkedList<Product>>> newPair = 
					new GenericPair<Category, HashMap<String,  LinkedList<Product>>>(p.getCategory(), h);
			fullmap.add(newPair);
		}
		
		
		String today = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

		for(GenericPair<Category, HashMap<String,  LinkedList<Product>>> itr : fullmap) {
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
		for(GenericPair<Category, HashMap<String,  LinkedList<Product>>> itr : fullmap) {
			if(itr.getFirst().getName().equals(p.getCategory().getName()))  {
				if(itr.getSecond().containsKey(p.getDate())) {
					itr.getSecond().get(p.getDate()).remove(p); 
				}else System.out.println("You did not purchase anything at that date");
			}else System.out.println("There is no category with that name"); 
		}
	}
	
}
	