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

public class deposit_button implements ActionListener {
  final Font font = new Font("Arial Rounded MT Bold", 0, 25);
  
  JFrame obJFrame = null;
  
  String id;
  
  String username;
  
  Color color = new Color(100, 149, 237);
  
  JTextField enteramo;
  
  JTextField moneydepField;
  
  JButton depButton;
  
  JButton backJButton;
  
  JLabel bgJLabel;
  
  public deposit_button(String id, String username) {
    this.obJFrame = new JFrame("Deposit");
    this.id = id;
    this.username = username;
    this.obJFrame.setBounds(485, 100, 410, 600);
    this.obJFrame.setLayout((LayoutManager)null);
    this.obJFrame.setDefaultCloseOperation(3);
    this.obJFrame.setResizable(false);
    this.bgJLabel = new JLabel(new ImageIcon(getClass().getResource("background.jpg")));
    this.bgJLabel.setBounds(0, 0, 410, 600);
    this.obJFrame.add(this.bgJLabel);
    this.enteramo = new JTextField("Enter the Amount :");
    this.enteramo.setEditable(false);
    this.enteramo.setBackground(this.color);
    this.enteramo.setForeground(Color.WHITE);
    this.enteramo.setBounds(60, 70, 250, 50);
    this.enteramo.setFont(this.font);
    this.bgJLabel.add(this.enteramo);
    this.moneydepField = new JTextField();
    this.moneydepField.setBackground(this.color);
    this.moneydepField.setForeground(Color.WHITE);
    this.moneydepField.setBounds(60, 160, 250, 50);
    this.moneydepField.setFont(this.font);
    this.bgJLabel.add(this.moneydepField);
    this.depButton = new JButton(" Deposit ");
    this.depButton.setBackground(this.color);
    this.depButton.setForeground(Color.WHITE);
    this.depButton.setBounds(80, 260, 200, 70);
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
      String dep = this.moneydepField.getText();
      boolean val = validate_Inputs.validate_amount(dep);
      boolean boll1 = JdbcConnector.database_update_balance(this.id, dep);
      if (val && (boll1 = true)) {
        JdbcConnector.database_enter_record(this.id, "0", dep, "Deposit");
        JOptionPane.showMessageDialog(null, "Amount deposited Succesfull");
        obJFrame.setVisible(false);
        this.obJFrame.dispose();
        new transcationPage(id,username);
      } 
    } 
    if(e.getSource() == this.backJButton) {
    	obJFrame.setVisible(false);
      this.obJFrame.dispose(); 
      new transcationPage(id,username);
  }}}