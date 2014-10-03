import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class DltFetcher2 implements ActionListener {
	private JFrame window;
	private Brain brain;
	private int comboBoxIndex; 
	
	public DltFetcher2(JFrame m, Brain b, int a) {
		window = m;
		brain = b;
		comboBoxIndex= a;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		DeleteList dltlist = new DeleteList(brain, comboBoxIndex);
		  dltlist.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  dltlist.setModal(true);
		  dltlist.setVisible(true);
		  /*Product p  = dltp.GetProduct();
		  if(p != null) {
			  brain.delProduct(p);
			  System.out.println("Erased" + p);
		  }*/

	} 
}