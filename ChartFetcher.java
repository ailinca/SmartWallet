
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import org.jfree.ui.RefineryUtilities;

	public class ChartFetcher implements ActionListener {
		private JFrame window;
		private Brain brain;
		
		public ChartFetcher(JFrame m, Brain b) {
			window = m;
			brain = b;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
				//stai sa caut cum e default size
			  
			  PieChart pc = new PieChart(brain, window, "TestDiag");
			  pc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			  pc.setVisible(true);
			  pc.setSize(500, 500);
			  RefineryUtilities.centerFrameOnScreen(pc);//blana:)))
			  
			 
		} 
	}

