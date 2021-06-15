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

public class transcationPage extends JFrame implements ActionListener {
  JLabel bgJLabel;
  
  String userid = "";
  
  String username = "";
  
  JTextField usernameJTextField;
  
  JButton checkBalButton;
  
  JButton depositButton;
  
  JButton withdrawJButton;
  
  JButton transfer;
  
  JButton historyJButton;
  
  JButton logoutJButton;
  
  final Font font = new Font("Arial Rounded MT Bold", 0, 25);
  
  final Font font1 = new Font("Arial Rounded MT Bold", 0, 20);
  
  Color color = new Color(100, 149, 237);
  
  public transcationPage(String userid, String username) {
    this.userid = userid;
    this.username = username;
    setTitle("TRANSCATION PAGE");
    setBounds(485, 100, 410, 600);
    setLayout((LayoutManager)null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    this.bgJLabel = new JLabel(new ImageIcon(getClass().getResource("background.jpg")));
    this.bgJLabel.setBounds(0, 0, 410, 600);
    add(this.bgJLabel);
    this.usernameJTextField = new JTextField("   Welcome back!  " + username);
    this.usernameJTextField.setEditable(false);
    this.usernameJTextField.setBackground(this.color);
    this.usernameJTextField.setForeground(Color.WHITE);
    this.usernameJTextField.setBounds(15, 15, 360, 45);
    this.usernameJTextField.setFont(this.font1);
    this.bgJLabel.add(this.usernameJTextField);
    this.checkBalButton = new JButton("  Check Balance ");
    this.checkBalButton.setFont(this.font);
    this.checkBalButton.setBounds(60, 100, 250, 50);
    this.checkBalButton.addActionListener(this);
    this.bgJLabel.add(this.checkBalButton);
    this.depositButton = new JButton("  Deposit ");
    this.depositButton.setFont(this.font);
    this.depositButton.setBounds(60, 180, 250, 50);
    this.depositButton.addActionListener(this);
    this.bgJLabel.add(this.depositButton);
    this.withdrawJButton = new JButton("  Withdraw ");
    this.withdrawJButton.setFont(this.font);
    this.withdrawJButton.setBounds(60, 260, 250, 50);
    this.withdrawJButton.addActionListener(this);
    this.bgJLabel.add(this.withdrawJButton);
    this.transfer = new JButton("Transfer Amount");
    this.transfer.setFont(this.font);
    this.transfer.setBounds(60, 340, 250, 50);
    this.transfer.addActionListener(this);
    this.bgJLabel.add(this.transfer);
    this.historyJButton = new JButton("Account History");
    this.historyJButton.setFont(this.font);
    this.historyJButton.setBounds(60, 420, 250, 50);
    this.historyJButton.addActionListener(this);
    this.bgJLabel.add(this.historyJButton);
    this.logoutJButton = new JButton("Log out");
    this.logoutJButton.setFont(this.font);
    this.logoutJButton.setBounds(110, 500, 150, 50);
    this.logoutJButton.addActionListener(this);
    this.bgJLabel.add(this.logoutJButton);
    setVisible(true);
  }
  
  public static void main(String[] args) {}
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.checkBalButton) {
      String balance = JdbcConnector.getBalance(this.userid);
      if (!balance.equals("offline"))
        JOptionPane.showMessageDialog(null, "Your balance is : " + balance); 
    } 
    if (e.getSource() == this.depositButton) {
      new deposit_button(userid,username);
      setVisible(false);
      this.dispose();
      }
    
    if (e.getSource() == this.withdrawJButton) {
      new withdraw_button(userid,username);
      setVisible(false);
      this.dispose(); }
    
    if (e.getSource() == this.transfer) {
    new transfer_amount(userid,username);
    setVisible(false);
    this.dispose(); }
    
    if (e.getSource() == this.historyJButton) {
     new account_history(userid,username);
     setVisible(false);
     this.dispose(); }
  
    if (e.getSource() == this.logoutJButton) {
    new Homepage();
    setVisible(false);
    this.dispose(); 
  }
}}