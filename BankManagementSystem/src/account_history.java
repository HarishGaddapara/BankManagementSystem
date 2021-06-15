import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class account_history implements ActionListener {
  JLabel bg;
  
  JLabel hdfc;
  
  JLabel bankLogoJLabel;
  
  JLabel bgr;
  
  JButton withdrawJButton;
  
  JButton depositJButton;
  
  JButton transferJButton;
  
  JButton recentJButton;
  
  JButton backJButton;
  
  final Font font = new Font("Arial Rounded MT Bold", 0, 25);
  
  Color color = new Color(100, 149, 237);
  
  Color colorbg = new Color(220, 220, 220);
  
  String id;
  
  String username;
  
  JFrame obj;
  
  public account_history(String id, String username) {
    this.id = id;
    this.username = username;
    this.obj = new JFrame();
    this.obj.setTitle(String.valueOf(username) + " ACCOUNT DETAILS");
    this.obj.setBounds(485, 100, 410, 600);
    this.obj.setLayout((LayoutManager)null);
    this.obj.setDefaultCloseOperation(3);
    ImageIcon image1 = new ImageIcon(getClass().getResource("background.jpg"));
    this.bg = new JLabel(image1);
    this.bg.setBounds(0, 0, 410, 600);
    this.obj.add(this.bg);
    this.recentJButton = new JButton("Recent Transcations");
    this.recentJButton.setBounds(20, 80, 355, 60);
    this.recentJButton.setFont(this.font);
    this.recentJButton.setBackground(this.colorbg);
    this.recentJButton.addActionListener(this);
    this.bg.add(this.recentJButton);
    this.withdrawJButton = new JButton("Withdraw History");
    this.withdrawJButton.setBounds(20, 180, 355, 60);
    this.withdrawJButton.setFont(this.font);
    this.withdrawJButton.setBackground(this.colorbg);
    this.withdrawJButton.addActionListener(this);
    this.bg.add(this.withdrawJButton);
    this.depositJButton = new JButton("Deposits History");
    this.depositJButton.setBounds(20, 280, 355, 60);
    this.depositJButton.setFont(this.font);
    this.depositJButton.setBackground(this.colorbg);
    this.depositJButton.addActionListener(this);
    this.bg.add(this.depositJButton);
    this.transferJButton = new JButton("Transfer History");
    this.transferJButton.setBounds(20, 380, 355, 60);
    this.transferJButton.setFont(this.font);
    this.transferJButton.addActionListener(this);
    this.transferJButton.setBackground(this.colorbg);
    this.bg.add(this.transferJButton);
    this.backJButton = new JButton(" < ");
    this.backJButton.setBounds(5, 5, 70, 30);
    this.backJButton.setFont(this.font);
    this.backJButton.addActionListener(this);
    this.backJButton.setBackground(this.colorbg);
    this.bg.add(this.backJButton);
    this.obj.setVisible(true);
  }
  
  public static void main(String[] args) {}
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.withdrawJButton)
      tablesView.withdraw_sheet(this.id); 
    if (e.getSource() == this.depositJButton)
      tablesView.deposit_sheet(this.id); 
    if (e.getSource() == this.transferJButton)
      tablesView.transfer_sheet(this.id); 
    if (e.getSource() == this.recentJButton)
      tablesView.recent_sheet(this.id); 
    if (e.getSource() == this.backJButton) {
    	obj.setVisible(false);
    	obj.dispose();
    	new transcationPage(id,username);}
  }
}