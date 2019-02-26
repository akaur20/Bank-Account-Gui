import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BankAccountGUI extends JFrame
{

	public BankAccountGUI()
	{
		setTitle("Bank Account");
		setBounds(100, 100, 600, 400);
		setLayout(null);
		
		JLabel lbl1 = new JLabel("Name:");
		lbl1.setBounds(20, 5, 100, 30);
		add(lbl1);
		
		JTextField txtName = new JTextField();
		txtName.setSize(new Dimension(100,30));
		txtName.setLocation(new Point(20,30));
		add(txtName);
		
		JLabel lbl2 = new JLabel("Account Type:");
		lbl2.setBounds(20, 75, 100, 30);
		add(lbl2);
		
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		String[] options = {"", "Checking", "Savings"};
		JComboBox dropDown = new JComboBox(options);
		dropDown.setBounds(20, 100, 100, 30);
		add(dropDown);
		
		JLabel lbl3 = new JLabel("Initial Balance:");
		lbl3.setBounds(210, 5, 100, 30);
		add(lbl3);
		
		JTextField initialBalance = new JTextField();
		initialBalance.setSize(new Dimension(100,30));
		initialBalance.setLocation(new Point(210,30));
		add(initialBalance);
		
		JButton create = new JButton("Create Account");
		create.setSize(new Dimension(175,30));
		create.setLocation(new Point(20,200));
		create.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(dropDown.getSelectedItem().equals("Checking"))
						{
							accounts.add(new CheckingAccount(txtName.getText(), Double.parseDouble(initialBalance.getText()), 10, 10, 15));
						}
						if(dropDown.getSelectedItem().equals("Savings"))
						{
							accounts.add(new SavingsAccount(txtName.getText(), Double.parseDouble(initialBalance.getText()), 10, 10, 15));
						}
						txtName.setText(null);
						initialBalance.setText(null);
						dropDown.setSelectedIndex(0);
					}
				});
		add(create);
		
		JButton display = new JButton("Display Accounts");
		display.setSize(new Dimension(175,30));
		display.setLocation(new Point(200,200));
		display.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						for(int i = 0; i < accounts.size(); i++)
						{
							System.out.println(accounts.get(i).toString());
						}
						
					}
				});
		add(display);
		
		setVisible(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		
		new BankAccountGUI();
		
	}

}