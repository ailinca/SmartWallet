import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class ProductDataFetcher implements ActionListener {
	private JFrame window;
	private Brain brain;
	
	public ProductDataFetcher(JFrame m, Brain b) {
		window = m;
		brain = b;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		  AddProductJDialog apd = new AddProductJDialog();
		  apd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  apd.setModal(true);
		  apd.setVisible(true);
		  Product p  = apd.GetProduct();
		  if(p != null) {
			  brain.addProduct(p);
			  System.out.println("In button" + p);
		  }

	} 
}