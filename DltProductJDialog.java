import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;


public class DltProductJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox;
	private Product p;
	Brain b;
	JFrame MainWindow;
	
	Category getMyCategory(int a)
	{
		 switch (a) {
            case 0:  return new Food("Food");
                     
            case 1:  return new Beverage("Beverage");
                    
            case 2:  return new Clothing("Clothing");
                    
            case 3:  return new Entertainment("Entertainment");
                    
            case 4:	 return new Taxes("Taxes");
            		 
            default: return null;
                    
        }
	}
	public Product GetProduct() {
		return p;
	}
	
	public DltProductJDialog(Brain brain, JFrame m) {
		b = brain;
		MainWindow = m;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDeleteProductWindow = new JLabel("Delete Product Window");
		lblDeleteProductWindow.setBounds(136, 24, 182, 15);
		getContentPane().add(lblDeleteProductWindow);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(135, 104, 70, 15);
		getContentPane().add(lblCategory);
		
		String[] elements={"Food", "Beverage", "Clothing", "Entertainment", "Tax" };
		DefaultComboBoxModel model = new DefaultComboBoxModel(elements);
		JComboBox comboBox_1 = new JComboBox(elements);
		comboBox_1.setBounds(223, 99, 95, 24);
		getContentPane().add(comboBox_1);
		
		JButton btnShowList = new JButton("Show List");
		btnShowList.setBounds(303, 223, 117, 25);
		getContentPane().add(btnShowList);

		btnShowList.addActionListener(new DltFetcher2(MainWindow, b, comboBox_1.getSelectedIndex()));
		
		
		
		
		
	}
}