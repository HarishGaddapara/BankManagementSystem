import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class user_log_in extends JFrame implements ActionListener {
  JLabel background;
  
  ImageIcon image1;
  
  JTextField user;
  
  JTextField passJTextField;
  
  JTextField loginpageJTextField;
  
  JTextField fn;
  
  JButton login;
  
  JButton backJButton;
  
  JPasswordField pw;
  
  final Font font = new Font("Arial Rounded MT Bold", 0, 20);
  
  final Font font1 = new Font("Arial Rounded MT Bold", 0, 30);
  
  user_log_in() {
    setTitle("CREATE NEW ACCOUNT IN SBI");
    setBounds(450, 150, 765, 450);
    setLayout((LayoutManager)null);
    setDefaultCloseOperation(3);
    setResizable(false);
    setLocationRelativeTo(this.rootPane);
    this.image1 = new ImageIcon(getClass().getResource("background.jpg"));
    this.background = new JLabel(this.image1);
    this.background.setBounds(0, 0, 765, 450);
    add(this.background);
    Color color = new Color(100, 149, 237);
    this.fn = new JTextField("");
    this.fn.setBackground(color);
    this.fn.setForeground(Color.WHITE);
    this.fn.setBounds(420, 120, 240, 60);
    this.fn.setFont(this.font1);
    this.background.add(this.fn);
    this.user = new JTextField("    USER ID");
    this.user.setEditable(false);
    this.user.setBackground(color);
    this.user.setForeground(Color.WHITE);
    this.user.setBounds(80, 120, 300, 60);
    this.user.setFont(this.font1);
    this.background.add(this.user);
    this.passJTextField = new JTextField("    PASSWORD");
    this.passJTextField.setEditable(false);
    this.passJTextField.setBackground(color);
    this.passJTextField.setForeground(Color.WHITE);
    this.passJTextField.setBounds(80, 200, 300, 60);
    this.passJTextField.setFont(this.font1);
    this.background.add(this.passJTextField);
    this.pw = new JPasswordField("");
    this.pw.setBackground(color);
    this.pw.setForeground(Color.WHITE);
    this.pw.setBounds(420, 200, 240, 60);
    this.pw.setFont(this.font);
    add(this.pw);
    this.login = new JButton("LOG IN");
    this.login.setBackground(color);
    this.login.setForeground(Color.WHITE);
    this.login.setBounds(325, 300, 150, 50);
    this.login.setFont(this.font1);
    this.login.addActionListener(this);
    this.background.add(this.login);
    this.loginpageJTextField = new JTextField(" LOG IN PAGE");
    this.loginpageJTextField.setEditable(false);
    this.loginpageJTextField.setBackground(color);
    this.loginpageJTextField.setForeground(Color.WHITE);
    this.loginpageJTextField.setBounds(300, 30, 220, 50);
    this.loginpageJTextField.setFont(this.font1);
    this.background.add(this.loginpageJTextField);
    this.backJButton = new JButton("<");
    this.backJButton.setBackground(color);
    this.backJButton.setForeground(Color.WHITE);
    this.backJButton.setBounds(0, 0, 60, 40);
    this.backJButton.setFont(this.font1);
    this.background.add(this.backJButton);
    this.backJButton.addActionListener(this);
    setVisible(true);
  }
  
  public static void main(String[] args) {
  new user_log_in();}
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.backJButton) {
        new Homepage();
        setVisible(false);
    	dispose(); }
      
    
    String useridString = "", passwordString = "";
    if (e.getSource() == this.login) {
      useridString = this.fn.getText();
      passwordString = String.valueOf(this.pw.getPassword());
      String username = JdbcConnector.databasecheck_userid_password(useridString, passwordString);
      if (!username.equals("yes")) {
        new transcationPage(useridString,username);
        setVisible(false);
        this.dispose();
    } 
  }}
}
