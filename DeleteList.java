import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteList extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList list;
	public static String[] listElements;
	public static Product[] delProducts;
	Brain b;
	JFrame MainWindow;
	int comboBoxIndex;

	
	public DeleteList(Brain brain, int cbb) {
		
		b = brain;
		comboBoxIndex = cbb;
		setBounds(100, 100, 450, 300);
		//getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		
		final String today = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

		if (b == null) {
			System.err.println("brain null popup");
		} else 
		if (b.fullmap.get(comboBoxIndex) == null) {
			System.err.println("no categ popup");
		}
		if(!b.fullmap.get(comboBoxIndex).getSecond().containsKey(today)) {
			System.err.println("No products today");
		}
		
		String names[] = new String[b.fullmap.get(comboBoxIndex).getSecond().get(today).size()];
		int counter = 0;
		for(Product itr : b.fullmap.get(comboBoxIndex).getSecond().get(today)) {
			names[counter++] = itr.getName();
		};
		DefaultListModel model = new DefaultListModel();
		
		//list = new JList(names)
		for(String name : names) {
			model.addElement(name);
		}
		list = new JList(model);
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setLocation(0, 0);
		scrollPane.setSize(229, 147);
		getContentPane().add(scrollPane);
		
		JButton btnDeleteIt = new JButton("Delete it");
		btnDeleteIt.setBounds(225, 219, 117, 25);
		getContentPane().add(btnDeleteIt);
		
		
		 btnDeleteIt.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  for(Product itr : b.fullmap.get(comboBoxIndex).getSecond().get(today)) {	  
				  if(list.getSelectedValue().equals(itr.getName())) {
					  b.delProduct(itr);
					  break; 
					}
				}	
		  }
		});
		
	}

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

}