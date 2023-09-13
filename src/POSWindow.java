import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class POSWindow {

	private JFrame frame;
	private JTable table;
	private JTextField jtxtBarCode;
	private JTextField jtxtTax;
	private JTextField jtxtSubtotal;
	private JTextField jtxtTotal;
	private JTextField jtxtDisplay;
	private JTextField jtxtChange;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POSWindow window = new POSWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public POSWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	//// ===================================================== Methods ================================================\\\\\\\\\\\\
	
	public void itemCost() {
		
		double sum = 0;
		double tax = 3.9;
		for(int i = 0; i < table.getRowCount(); i++) {
			sum += Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		
		jtxtSubtotal.setText(Double.toString(sum));
		double cTotal = Double.parseDouble(jtxtSubtotal.getText());
		
		double cTax = (cTotal * tax)/100;
		
		String iTaxTotal = String.format("$ % .2f", cTax);
		jtxtTax.setText(iTaxTotal);
		
		String iSubTotal = String.format("$ % .2f", cTotal);
		jtxtSubtotal.setText(iSubTotal);
		
		String iTotal = String.format("$ % .2f", cTotal + cTax);
		jtxtTotal.setText(iTotal);
		
		String barCode = String.format("The Total is % .2f", cTotal + cTax);
		jtxtBarCode.setText(barCode);
	}
	
	
	public void change() {
		
		double sum = 0;
		double tax = 3.9;
		
		double cash = Double.parseDouble(jtxtDisplay.getText());
		
		for(int i = 0; i < table.getRowCount(); i++) {
			sum += Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		
		double cTax = (sum * tax)/100;
		double cChange = (cash - (sum + cTax));
		
		String changeGiven = String.format("$ %.2f", cChange);
		jtxtChange.setText(changeGiven);
	}
	
	
   ////===================================================== Methods ================================================\\\\\\\\\\\\
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(0x333905));;
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(14, 11, 303, 404);
		panel.setBackground(new Color(0x636833));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton jbtn7 = new JButton("7");
		jbtn7.setForeground(new Color(102, 0, 0));
		jbtn7.setBackground(new Color(0x00C9B0));
		jbtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String enterNumber = jtxtDisplay.getText();
				
				if(enterNumber == "") {
					jtxtDisplay.setText(jbtn7.getText());
				}
				else {
					enterNumber = jtxtDisplay.getText() + jbtn7.getText();
					jtxtDisplay.setText(enterNumber);
				}
				
				
			}
		});
		jbtn7.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtn7.setBounds(10, 11, 89, 89);
		panel.add(jbtn7);
		
		JButton jbtn8 = new JButton("8");
		jbtn8.setForeground(new Color(102, 0, 0));
		jbtn8.setBackground(new Color(0x00C9B0));
		jbtn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jtxtDisplay.getText();
				
				if(enterNumber == "") {
					jtxtDisplay.setText(jbtn8.getText());
				}
				else {
					enterNumber = jtxtDisplay.getText() + jbtn8.getText();
					jtxtDisplay.setText(enterNumber);
				}
			}
		});
		jbtn8.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtn8.setBounds(109, 11, 89, 89);
		panel.add(jbtn8);
		
		JButton jbtn9 = new JButton("9");
		jbtn9.setForeground(new Color(102, 0, 0));
		jbtn9.setBackground(new Color(0x00C9B0));
		jbtn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String enterNumber = jtxtDisplay.getText();
				
				if(enterNumber == "") {
					jtxtDisplay.setText(jbtn9.getText());
				}
				else {
					enterNumber = jtxtDisplay.getText() + jbtn9.getText();
					jtxtDisplay.setText(enterNumber);
				}
			}
		});
		jbtn9.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtn9.setBounds(204, 11, 89, 89);
		panel.add(jbtn9);
		
		JButton jbtn4 = new JButton("4");
		jbtn4.setForeground(new Color(102, 0, 0));
		jbtn4.setBackground(new Color(0x00C9B0));
		jbtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jtxtDisplay.getText();
				
				if(enterNumber == "") {
					jtxtDisplay.setText(jbtn4.getText());
				}
				else {
					enterNumber = jtxtDisplay.getText() + jbtn4.getText();
					jtxtDisplay.setText(enterNumber);
				}
			}
		});
		jbtn4.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtn4.setBounds(10, 111, 89, 89);
		panel.add(jbtn4);
		
		JButton jbtn5 = new JButton("5");
		jbtn5.setForeground(new Color(102, 0, 0));
		jbtn5.setBackground(new Color(0x00C9B0));
		jbtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jtxtDisplay.getText();
				
				if(enterNumber == "") {
					jtxtDisplay.setText(jbtn5.getText());
				}
				else {
					enterNumber = jtxtDisplay.getText() + jbtn5.getText();
					jtxtDisplay.setText(enterNumber);
				}
			}
		});
		jbtn5.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtn5.setBounds(109, 111, 89, 89);
		panel.add(jbtn5);
		
		JButton jbtn6 = new JButton("6");
		jbtn6.setForeground(new Color(102, 0, 0));
		jbtn6.setBackground(new Color(0x00C9B0));
		jbtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jtxtDisplay.getText();
				
				if(enterNumber == "") {
					jtxtDisplay.setText(jbtn6.getText());
				}
				else {
					enterNumber = jtxtDisplay.getText() + jbtn6.getText();
					jtxtDisplay.setText(enterNumber);
				}
			}
		});
		jbtn6.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtn6.setBounds(204, 111, 89, 89);
		panel.add(jbtn6);
		
		JButton jbtn1 = new JButton("1");
		jbtn1.setForeground(new Color(102, 0, 0));
		jbtn1.setBackground(new Color(0x00C9B0));
		jbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jtxtDisplay.getText();
				
				if(enterNumber == "") {
					jtxtDisplay.setText(jbtn1.getText());
				}
				else {
					enterNumber = jtxtDisplay.getText() + jbtn1.getText();
					jtxtDisplay.setText(enterNumber);
				}
			}
		});
		jbtn1.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtn1.setBounds(10, 211, 89, 89);
		panel.add(jbtn1);
		
		JButton jbtn2 = new JButton("2");
		jbtn2.setForeground(new Color(102, 0, 0));
		jbtn2.setBackground(new Color(0x00C9B0));
		jbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jtxtDisplay.getText();
				
				if(enterNumber == "") {
					jtxtDisplay.setText(jbtn2.getText());
				}
				else {
					enterNumber = jtxtDisplay.getText() + jbtn2.getText();
					jtxtDisplay.setText(enterNumber);
				}
			}
		});
		jbtn2.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtn2.setBounds(109, 211, 89, 89);
		panel.add(jbtn2);
		
		JButton jbtn3 = new JButton("3");
		jbtn3.setForeground(new Color(102, 0, 0));
		jbtn3.setBackground(new Color(0x00C9B0));
		jbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jtxtDisplay.getText();
				
				if(enterNumber == "") {
					jtxtDisplay.setText(jbtn3.getText());
				}
				else {
					enterNumber = jtxtDisplay.getText() + jbtn3.getText();
					jtxtDisplay.setText(enterNumber);
				}
			}
		});
		jbtn3.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtn3.setBounds(204, 211, 89, 89);
		panel.add(jbtn3);
		
		JButton jbtn0 = new JButton("0");
		jbtn0.setForeground(new Color(102, 0, 0));
		jbtn0.setBackground(new Color(0x00C9B0));
		jbtn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jtxtDisplay.getText();
				
				if(enterNumber == "") {
					jtxtDisplay.setText(jbtn0.getText());
				}
				else {
					enterNumber = jtxtDisplay.getText() + jbtn0.getText();
					jtxtDisplay.setText(enterNumber);
				}
			}
		});
		jbtn0.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtn0.setBounds(10, 304, 89, 89);
		panel.add(jbtn0);
		
		JButton jbtnPeriod = new JButton(".");
		jbtnPeriod.setForeground(new Color(102, 0, 0));
		jbtnPeriod.setBackground(new Color(0x00C9B0));
		jbtnPeriod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!jtxtDisplay.getText().contains(".")) {
					jtxtDisplay.setText(jtxtDisplay.getText() + jbtnPeriod.getText());
				}
			}
		});
		jbtnPeriod.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtnPeriod.setBounds(109, 304, 89, 89);
		panel.add(jbtnPeriod);
		
		JButton jbtnClear = new JButton("C");
		jbtnClear.setForeground(new Color(102, 0, 0));
		jbtnClear.setBackground(new Color(0x00C9B0));
		jbtnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtDisplay.setText(null);
				jtxtChange.setText(null);
			}
		});
		jbtnClear.setFont(new Font("Tahoma", Font.BOLD, 48));
		jbtnClear.setBounds(204, 304, 89, 89);
		panel.add(jbtnClear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(607, 11, 753, 415);
		panel_1.setBackground(new Color(0x636833));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton jbtnCappucino = new JButton("");
		jbtnCappucino.setForeground(new Color(102, 0, 0));
		jbtnCappucino.setBackground(new Color(0x00C9B0));
		jbtnCappucino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 2.57;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Cappuccino", "1", itemPrice});
				itemCost();
				
			}
		});
		jbtnCappucino.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnCappucino.setBounds(10, 11, 140, 125);
		panel_1.add(jbtnCappucino);
		
		JButton jbtnRedCake = new JButton("Red Cake");
		jbtnRedCake.setForeground(new Color(102, 0, 0));
		jbtnRedCake.setBackground(new Color(0x00C9B0));
		jbtnRedCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 2.45;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Red Cake", "1", itemPrice});
				itemCost();
			}
		});
		jbtnRedCake.setFont(new Font("Tahoma", Font.PLAIN, 48));
		jbtnRedCake.setBounds(10, 147, 140, 125);
		panel_1.add(jbtnRedCake);
		
		JButton btnNewButton_6_2 = new JButton("");
		btnNewButton_6_2.setForeground(new Color(102, 0, 0));
		btnNewButton_6_2.setBackground(new Color(0x00C9B0));
		btnNewButton_6_2.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton_6_2.setBounds(10, 279, 140, 125);
		panel_1.add(btnNewButton_6_2);
		
		JButton jbtnCanDrinks = new JButton("Can Drinks");
		jbtnCanDrinks.setForeground(new Color(102, 0, 0));
		jbtnCanDrinks.setBackground(new Color(0x00C9B0));
		jbtnCanDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 0.57;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Can Drinks", "1", itemPrice});
				itemCost();
			}
		});
		jbtnCanDrinks.setFont(new Font("Tahoma", Font.PLAIN, 48));
		jbtnCanDrinks.setBounds(160, 11, 140, 125);
		panel_1.add(jbtnCanDrinks);
		
		JButton btnNewButton_6_1_1 = new JButton("");
		btnNewButton_6_1_1.setForeground(new Color(102, 0, 0));
		btnNewButton_6_1_1.setBackground(new Color(0x00C9B0));
		btnNewButton_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton_6_1_1.setBounds(160, 147, 140, 125);
		panel_1.add(btnNewButton_6_1_1);
		
		JButton btnNewButton_6_2_1 = new JButton("");
		btnNewButton_6_2_1.setForeground(new Color(102, 0, 0));
		btnNewButton_6_2_1.setBackground(new Color(0x00C9B0));
		btnNewButton_6_2_1.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton_6_2_1.setBounds(160, 279, 140, 125);
		panel_1.add(btnNewButton_6_2_1);
		
		JButton jbtnCake = new JButton("Cake");
		jbtnCake.setForeground(new Color(102, 0, 0));
		jbtnCake.setBackground(new Color(0x00C9B0));
		jbtnCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 2.75;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Cappuccino", "1", itemPrice});
				itemCost();
			}
		});
		jbtnCake.setFont(new Font("Tahoma", Font.PLAIN, 48));
		jbtnCake.setBounds(310, 11, 140, 125);
		panel_1.add(jbtnCake);
		
		JButton btnNewButton_6_1_2 = new JButton("");
		btnNewButton_6_1_2.setForeground(new Color(102, 0, 0));
		btnNewButton_6_1_2.setBackground(new Color(0x00C9B0));
		btnNewButton_6_1_2.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton_6_1_2.setBounds(310, 147, 140, 125);
		panel_1.add(btnNewButton_6_1_2);
		
		JButton btnNewButton_6_2_2 = new JButton("");
		btnNewButton_6_2_2.setForeground(new Color(102, 0, 0));
		btnNewButton_6_2_2.setBackground(new Color(0x00C9B0));
		btnNewButton_6_2_2.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton_6_2_2.setBounds(310, 279, 140, 125);
		panel_1.add(btnNewButton_6_2_2);
		
		JButton jbtnCoffee = new JButton("Coffee");
		jbtnCoffee.setForeground(new Color(102, 0, 0));
		jbtnCoffee.setBackground(new Color(0x00C9B0));
		jbtnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 1.90;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Coffee", "1", itemPrice});
				itemCost();
			}
		});
		jbtnCoffee.setFont(new Font("Tahoma", Font.PLAIN, 48));
		jbtnCoffee.setBounds(460, 11, 140, 125);
		panel_1.add(jbtnCoffee);
		
		JButton btnNewButton_6_1_3 = new JButton("");
		btnNewButton_6_1_3.setForeground(new Color(102, 0, 0));
		btnNewButton_6_1_3.setBackground(new Color(0x00C9B0));
		btnNewButton_6_1_3.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton_6_1_3.setBounds(460, 147, 140, 125);
		panel_1.add(btnNewButton_6_1_3);
		
		JButton btnNewButton_6_2_3 = new JButton("");
		btnNewButton_6_2_3.setForeground(new Color(102, 0, 0));
		btnNewButton_6_2_3.setBackground(new Color(0x00C9B0));
		btnNewButton_6_2_3.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton_6_2_3.setBounds(460, 279, 140, 125);
		panel_1.add(btnNewButton_6_2_3);
		
		JButton jbtnAngleCake = new JButton("Angle Cake");
		jbtnAngleCake.setForeground(new Color(102, 0, 0));
		jbtnAngleCake.setBackground(new Color(0x00C9B0));
		jbtnAngleCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 2.90;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Angle Cake", "1", itemPrice});
				itemCost();
			}
		});
		jbtnAngleCake.setFont(new Font("Tahoma", Font.PLAIN, 48));
		jbtnAngleCake.setBounds(608, 11, 140, 125);
		panel_1.add(jbtnAngleCake);
		
		JButton btnNewButton_6_1_4 = new JButton("");
		btnNewButton_6_1_4.setForeground(new Color(102, 0, 0));
		btnNewButton_6_1_4.setBackground(new Color(0x00C9B0));
		btnNewButton_6_1_4.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton_6_1_4.setBounds(608, 147, 140, 125);
		panel_1.add(btnNewButton_6_1_4);
		
		JButton btnNewButton_6_2_4 = new JButton("");
		btnNewButton_6_2_4.setForeground(new Color(102, 0, 0));
		btnNewButton_6_2_4.setBackground(new Color(0x00C9B0));
		btnNewButton_6_2_4.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton_6_2_4.setBounds(608, 279, 140, 125);
		panel_1.add(btnNewButton_6_2_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 470, 1325, 211);
		panel_2.setBackground(new Color(0x636833));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 23, 425, 161);
		panel_3.setBackground(new Color(255, 255, 204));
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax");
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 16, 98, 34);
		panel_3.add(lblNewLabel);
		
		jtxtTax = new JTextField();
		jtxtTax.setBounds(146, 11, 171, 39);
		panel_3.add(jtxtTax);
		jtxtTax.setColumns(10);
		
		jtxtSubtotal = new JTextField();
		jtxtSubtotal.setColumns(10);
		jtxtSubtotal.setBounds(146, 56, 171, 39);
		panel_3.add(jtxtSubtotal);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setForeground(new Color(102, 0, 0));
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSubtotal.setBounds(10, 61, 98, 34);
		panel_3.add(lblSubtotal);
		
		jtxtTotal = new JTextField();
		jtxtTotal.setColumns(10);
		jtxtTotal.setBounds(146, 106, 171, 39);
		panel_3.add(jtxtTotal);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setForeground(new Color(102, 0, 0));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTotal.setBounds(10, 111, 98, 34);
		panel_3.add(lblTotal);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(255, 255, 204));
		panel_3_1.setBounds(445, 23, 410, 161);
		panel_2.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		jtxtDisplay = new JTextField();
		jtxtDisplay.setBounds(262, 52, 138, 30);
		jtxtDisplay.setColumns(10);
		panel_3_1.add(jtxtDisplay);
		
		jtxtChange = new JTextField();
		jtxtChange.setBounds(262, 93, 138, 29);
		jtxtChange.setColumns(10);
		panel_3_1.add(jtxtChange);
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setForeground(new Color(102, 0, 0));
		lblChange.setBounds(42, 92, 86, 29);
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3_1.add(lblChange);
		
		JLabel lblDisplayCash = new JLabel("Display Cash");
		lblDisplayCash.setForeground(new Color(102, 0, 0));
		lblDisplayCash.setBounds(42, 52, 153, 29);
		lblDisplayCash.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3_1.add(lblDisplayCash);
		
		JLabel lblPayment = new JLabel("Payment Method");
		lblPayment.setForeground(new Color(102, 0, 0));
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPayment.setBounds(42, 11, 179, 29);
		panel_3_1.add(lblPayment);
		
		JComboBox jcboPayment = new JComboBox();
		jcboPayment.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Visa Card", "Master Card"}));
		jcboPayment.setBounds(262, 20, 138, 22);
		panel_3_1.add(jcboPayment);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(255, 255, 204));
		panel_3_2.setBounds(865, 23, 433, 161);
		panel_2.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JButton jbtnPay = new JButton("Pay");
		jbtnPay.setForeground(new Color(102, 0, 0));
		jbtnPay.setBackground(new Color(0x00C9B0));
		jbtnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcboPayment.getSelectedItem().equals("Cash")) {
					change();
				}
				else {
					jtxtChange.setText("");
					jtxtDisplay.setText("");
				}
			}
		});
		jbtnPay.setFont(new Font("Tahoma", Font.BOLD, 24));
		jbtnPay.setBounds(10, 25, 111, 46);
		panel_3_2.add(jbtnPay);
		
		JButton jbtnPrint = new JButton("Print");
		jbtnPrint.setForeground(new Color(102, 0, 0));
		jbtnPrint.setBackground(new Color(0x00C9B0));
		jbtnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Printing in progress");
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				
				try {
					table.print(JTable.PrintMode.NORMAL, header, footer);
				} catch (PrinterException e1) {
					System.err.format("No printer found", e1.getMessage());
				}
			}
		});
		jbtnPrint.setFont(new Font("Tahoma", Font.BOLD, 24));
		jbtnPrint.setBounds(147, 25, 111, 46);
		panel_3_2.add(jbtnPrint);
		
		JButton jbtnReset = new JButton("Reset");
		jbtnReset.setForeground(new Color(102, 0, 0));
		jbtnReset.setBackground(new Color(0x00C9B0));
		jbtnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtDisplay.setText(null);
				jtxtChange.setText(null);
				jtxtSubtotal.setText(null);
				jtxtTax.setText(null);
				jtxtTotal.setText(null);
				jtxtBarCode.setText(null);
				
				
				DefaultTableModel recordTable = (DefaultTableModel) table.getModel();
				recordTable.setRowCount(0);
			}
		});
		jbtnReset.setFont(new Font("Tahoma", Font.BOLD, 24));
		jbtnReset.setBounds(292, 25, 111, 46);
		panel_3_2.add(jbtnReset);
		
		JButton jbtnRemove = new JButton("Remove Item");
		jbtnRemove.setForeground(new Color(102, 0, 0));
		jbtnRemove.setBackground(new Color(0x00C9B0));
		jbtnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int removeItem = table.getSelectedRow();
				
				if(removeItem >= 0) {
					model.removeRow(removeItem);
				}
				
				itemCost();
				
				if(jcboPayment.getSelectedItem().equals("Cash")) {
					change();
				}
				else {
					jtxtChange.setText("");
					jtxtDisplay.setText("");
				}
			}
		});
		jbtnRemove.setFont(new Font("Tahoma", Font.BOLD, 24));
		jbtnRemove.setBounds(10, 91, 204, 59);
		panel_3_2.add(jbtnRemove);
		
		JButton btnNewButton_7_3_1 = new JButton("Exit");
		btnNewButton_7_3_1.setForeground(new Color(102, 0, 0));
		btnNewButton_7_3_1.setBackground(new Color(0x00C9B0));
		btnNewButton_7_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Point Of Sale",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_7_3_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_7_3_1.setBounds(224, 91, 164, 59);
		panel_3_2.add(btnNewButton_7_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 11, 259, 369);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 204));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Item", "Qty", "Amount"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		scrollPane.setViewportView(table);
		
		jtxtBarCode = new JTextField();
		jtxtBarCode.setBackground(new Color(255, 255, 204));
		jtxtBarCode.setFont(new Font("Tahoma", Font.PLAIN, 36));
		jtxtBarCode.setBounds(339, 384, 258, 33);
		frame.getContentPane().add(jtxtBarCode);
		jtxtBarCode.setColumns(10);
	}
}
