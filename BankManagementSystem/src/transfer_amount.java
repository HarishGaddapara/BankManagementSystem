import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class transfer_amount implements ActionListener {
  final Font font = new Font("Arial Rounded MT Bold", 0, 25);
  
  JFrame obJFrame = null;
  
  String id;
  
  String username;
  
  Color color = new Color(100, 149, 237);
  
  JTextField enteramo;
  
  JTextField moneydepField;
  
  JTextField accno;
  
  JTextField amo;
  
  JButton depButton;
  
  JButton backJButton;
  
  JLabel bgJLabel;
  
  public transfer_amount(String id, String username) {
    this.obJFrame = new JFrame("Transfer Amount");
    this.id = id;
    this.username = username;
    this.obJFrame.setBounds(400, 100, 680, 600);
    this.obJFrame.setLayout((LayoutManager)null);
    this.obJFrame.setDefaultCloseOperation(3);
    this.obJFrame.setResizable(false);
    this.bgJLabel = new JLabel(new ImageIcon(getClass().getResource("background.jpg")));
    this.bgJLabel.setBounds(0, 0, 680, 600);
    this.obJFrame.add(this.bgJLabel);
    this.enteramo = new JTextField("  Account Number :");
    this.enteramo.setEditable(false);
    this.enteramo.setBackground(this.color);
    this.enteramo.setForeground(Color.WHITE);
    this.enteramo.setBounds(60, 70, 250, 50);
    this.enteramo.setFont(this.font);
    this.bgJLabel.add(this.enteramo);
    this.moneydepField = new JTextField("  Amount : ");
    this.enteramo.setEditable(false);
    this.moneydepField.setBackground(this.color);
    this.moneydepField.setForeground(Color.WHITE);
    this.moneydepField.setBounds(60, 160, 250, 50);
    this.moneydepField.setFont(this.font);
    this.bgJLabel.add(this.moneydepField);
    this.accno = new JTextField();
    this.accno.setBackground(this.color);
    this.accno.setForeground(Color.WHITE);
    this.accno.setBounds(340, 70, 250, 50);
    this.accno.setFont(this.font);
    this.bgJLabel.add(this.accno);
    this.amo = new JTextField();
    this.amo.setBackground(this.color);
    this.amo.setForeground(Color.WHITE);
    this.amo.setBounds(340, 160, 250, 50);
    this.amo.setFont(this.font);
    this.bgJLabel.add(this.amo);
    this.depButton = new JButton(" Transfer ");
    this.depButton.setBackground(this.color);
    this.depButton.setForeground(Color.WHITE);
    this.depButton.setBounds(120, 260, 400, 70);
    this.depButton.setFont(this.font);
    this.depButton.setVisible(true);
    this.depButton.addActionListener(this);
    this.bgJLabel.add(this.depButton);
    this.backJButton = new JButton("<");
    this.backJButton.setBackground(this.color);
    this.backJButton.setForeground(Color.WHITE);
    this.backJButton.setBounds(0, 0, 60, 40);
    this.backJButton.setFont(this.font);
    this.bgJLabel.add(this.backJButton);
    this.backJButton.addActionListener(this);
    this.obJFrame.setVisible(true);
  }
  
  public static void main(String[] args) {}
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.depButton) {
      String accnumberR = this.accno.getText();
      String amount = this.amo.getText();
      boolean ac = validate_Inputs.validate_accno(accnumberR);
      if (ac) {
        boolean ba = validate_Inputs.validate_amount(amount);
        if (ba && ac) {
          boolean boll1 = JdbcConnector.database_transfer_amount(this.id, accnumberR, amount);
          if (boll1==true) {
            JdbcConnector.database_enter_record(this.id, accnumberR, amount, "Transfer");
            String amountrem = JdbcConnector.getBalance(this.id);
            JOptionPane.showMessageDialog(null, "Transfered successfully! Your balance is " + amountrem + ".");
            obJFrame.setVisible(false);
            this.obJFrame.dispose();
            new transcationPage(id,username);
          } 
        } 
      } 
    } 
    if (e.getSource() == this.backJButton) {
    	new transcationPage(id,username);
    	obJFrame.setVisible(false);
        this.obJFrame.dispose(); 
      
  }
}}