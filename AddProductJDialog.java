import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

 
public class AddProductJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox;
	private Product p;
	private boolean prod_set = false;
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
	
	public boolean isReady() {
		return prod_set;
	}

	public AddProductJDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(29, 55, 53, 15);
		contentPanel.add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(31, 82, 51, 21);
		contentPanel.add(lblPrice);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(29, 117, 70, 15);
		contentPanel.add(lblCategory);
		
		final JTextField name = new JTextField();
		name.setBounds(89, 49, 106, 21);
		contentPanel.add(name);
		
		
		final JTextField price = new JTextField();
		price.setBounds(89, 82, 106, 21);
		contentPanel.add(price);
		
		String[] comboBoxItems={"Food", "Beverage", "Clothing", "Entertainment", "Tax" };
		DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
		comboBox = new JComboBox(comboBoxItems);
		comboBox.setBounds(117, 112, 118, 24);
		contentPanel.add(comboBox);
		
		final JRadioButton rdbtnShouldNotBuy = new JRadioButton("Should not buy");
		rdbtnShouldNotBuy.setBounds(29, 150, 149, 23);
		contentPanel.add(rdbtnShouldNotBuy);
		
		final JRadioButton rdbtnTracked = new JRadioButton("Tracked");
		rdbtnTracked.setBounds(31, 182, 149, 23);
		contentPanel.add(rdbtnTracked);
		
		JLabel lblAddProductWindow = new JLabel("Add Product Window");
		lblAddProductWindow.setBounds(131, 12, 157, 15);
		contentPanel.add(lblAddProductWindow);
		
		JButton btnImDoneBitch = new JButton("Im done, bitch!"); 
		btnImDoneBitch.setBounds(293, 236, 139, 25);
		contentPanel.add(btnImDoneBitch);
		
		JButton btnCancelThatShit = new JButton("Cancel that shit!");
		btnCancelThatShit.setBounds(117, 236, 157, 25);
		contentPanel.add(btnCancelThatShit);
			
		btnImDoneBitch.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  if (Pattern.matches("[a-zA-Z]+", name.getText()) && name.getText().length() > 2){ 
				  if (price.getText().matches("[0-9]+") && price.getText().length() > 0) {
			  
					  	p = new Product(name.getText(), 
					  				Float.parseFloat(price.getText()),
					  				getMyCategory(comboBox.getSelectedIndex()), rdbtnShouldNotBuy.isSelected(), 
					  				rdbtnTracked.isSelected() );
					  	dispose();
					  	}
				  else JOptionPane.showMessageDialog(null, "Price must contain only digits !", "Price Error Box", JOptionPane.ERROR_MESSAGE);
			  
			  }
			  else JOptionPane.showMessageDialog(null, "Name must have two letters or more", "Name Error Box", JOptionPane.ERROR_MESSAGE);
			  
			  //	public Product(String n, float p, Category c, boolean s, boolean t
			 // p = new Product(new String("hamburger"), s , new Food("Food") , false, true);
		  }
		});
	}
}