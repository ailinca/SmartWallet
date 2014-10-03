import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class DltDataFetcher implements ActionListener {
	private JFrame window;
	private Brain brain;
	
	public DltDataFetcher(JFrame m, Brain b) {
		window = m;
		brain = b;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		  DltProductJDialog dltp = new DltProductJDialog(brain, window);
		  dltp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  dltp.setModal(true);
		  dltp.setVisible(true);
		 
	} 
}