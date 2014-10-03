import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JToolBar;


public class WindowManager {
	static Brain b; 
	
	public static void main(String args[]) {
		

		b = new Brain();
		final JFrame MainWindow = new JFrame("SmartWallet main Window");
		MainWindow.setVisible(true);
		MainWindow.setTitle("SmartWallet");
		MainWindow.setSize(500, 500);
		MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainWindow.getContentPane().setLayout(null);
		
		JLabel lblSmartwalletAplicationFor = new JLabel("SmartWallet Aplication for Desktop");
		lblSmartwalletAplicationFor.setBounds(94, 7, 261, 23);
		MainWindow.getContentPane().add(lblSmartwalletAplicationFor);
		
		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.setBounds(152, 73, 139, 25);
		btnAddProduct.addActionListener(new ProductDataFetcher(MainWindow, b));
		MainWindow.getContentPane().add(btnAddProduct);
		
		JButton btnDeleteProduct = new JButton("Delete product");
		btnDeleteProduct.setBounds(142, 132, 168, 25);
		MainWindow.getContentPane().add(btnDeleteProduct);
		btnDeleteProduct.addActionListener(new DltDataFetcher(MainWindow, b));
		
		JButton btnSeeResults = new JButton("See Results");
		btnSeeResults.setBounds(152, 187, 139, 25);
		MainWindow.getContentPane().add(btnSeeResults);
		btnSeeResults.addActionListener(new ChartFetcher(MainWindow, b));
		
		
		
		}
	}