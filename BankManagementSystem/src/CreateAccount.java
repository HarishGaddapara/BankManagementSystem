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

public class CreateAccount extends JFrame implements ActionListener {
  JLabel res;
  
  JLabel lsignup;
  
  JLabel temail;
  
  JLabel Lfname;
  
  JLabel Llname;
  
  JLabel tpass;
  
  JLabel Lemail;
  
  JLabel Lpassword;
  
  JLabel background;
  
  JLabel bg1;
  
  JLabel Tlname;
  
  JLabel tlast;
  
  ImageIcon image1;
  
  ImageIcon log;
  
  ImageIcon image2;
  
  JTextField fn;
  
  JTextField ln;
  
  JTextField email;
  
  JTextField password;
  
  JButton signin;
  
  JButton login;
  
  JPasswordField pw;
  
  final Font font = new Font("Arial Rounded MT Bold", 0, 20);
  
  CreateAccount() {
    setTitle("CREATE NEW ACCOUNT IN SBI");
    setBounds(450, 150, 450, 550);
    setLayout((LayoutManager)null);
    setDefaultCloseOperation(3);
    setResizable(false);
    this.image1 = new ImageIcon(getClass().getResource("/images/bg2.jpg"));
    this.background = new JLabel(this.image1);
    this.background.setBounds(0, 0, 450, 550);
    add(this.background);
    this.image2 = new ImageIcon(getClass().getResource("/images/button.jpg"));
    this.lsignup = new JLabel(this.image2);
    this.lsignup.setBounds(135, 30, 150, 50);
    this.background.add(this.lsignup);
    this.Tlname = new JLabel("First Name :");
    this.Tlname.setBounds(30, 110, 120, 50);
    this.Tlname.setFont(this.font);
    this.background.add(this.Tlname);
    this.fn = new JTextField("");
    this.fn.setBounds(165, 115, 200, 35);
    this.fn.setFont(this.font);
    add(this.fn);
    this.tlast = new JLabel("Last Name :");
    this.tlast.setBounds(30, 170, 120, 50);
    this.tlast.setFont(this.font);
    this.background.add(this.tlast);
    this.ln = new JTextField("");
    this.ln.setBounds(165, 175, 200, 35);
    this.ln.setFont(this.font);
    add(this.ln);
    this.temail = new JLabel("E-Mail          :");
    this.temail.setBounds(30, 230, 120, 50);
    this.temail.setFont(this.font);
    this.background.add(this.temail);
    this.email = new JTextField("");
    this.email.setBounds(165, 235, 200, 35);
    this.email.setFont(this.font);
    add(this.email);
    this.tpass = new JLabel("Password  :");
    this.tpass.setBounds(30, 290, 120, 50);
    this.tpass.setFont(this.font);
    this.background.add(this.tpass);
    this.pw = new JPasswordField("");
    this.pw.setBounds(165, 295, 200, 35);
    this.pw.setFont(this.font);
    add(this.pw);
    this.log = new ImageIcon(getClass().getResource("/images/re.png"));
    this.signin = new JButton(this.log);
    this.signin.setBounds(135, 400, 150, 40);
    this.signin.addActionListener(this);
    this.background.add(this.signin);
    this.res = new JLabel();
    this.res.setBounds(20, 350, 400, 50);
    this.res.setFont(this.font);
    this.background.add(this.res);
    setVisible(true);
  }
  
  public static void main(String[] args) {}
  
  public void result(boolean bool, String err) {
    String str = "";
    if (bool) {
      str = "Successfully signed up";
    } else {
      str = err;
    } 
    this.res.setText(str);
    this.fn.setText("");
    this.ln.setText("");
    this.email.setText("");
    this.pw.setText("");
  }
  
  public void actionPerformed(ActionEvent e) {
    String firstName = "", lastName = "", Email = "", pass = "";
    if (e.getSource() == this.signin) {
      firstName = this.fn.getText();
      lastName = this.ln.getText();
      Email = this.email.getText();
      pass = String.valueOf(this.pw.getPassword());
      String error = "";
      boolean bname = true;
      boolean blame = true;
      boolean bemail = true;
      boolean bpass = true;
      if (firstName != "" && lastName != "" && Email != "" && pass != "") {
        int i;
        for (i = 0; i < firstName.length(); i++) {
          if ((firstName.charAt(i) >= 'A' && firstName.charAt(i) <= 'Z') || (firstName.charAt(i) >= 'a' && firstName.charAt(i) <= 'z')) {
            bname = true;
          } else {
            bname = false;
            error = "First Name should contain alphabets only";
            result(bname, error);
            break;
          } 
        } 
        for (i = 0; i < lastName.length(); i++) {
          if ((lastName.charAt(i) >= 'A' && lastName.charAt(i) <= 'Z') || (lastName.charAt(i) >= 'a' && lastName.charAt(i) <= 'z')) {
            blame = true;
          } else {
            blame = false;
            error = "Last Name should contain alphabets only";
            result(blame, error);
            break;
          } 
        } 
        String[] arr = Email.split("@");
        if (arr.length == 2 && arr[1].equals("gmail.com")) {
          bemail = true;
        } else {
          bemail = false;
          error = "Enter the proper Email";
          result(bemail, error);
        } 
        if (blame && bemail && bname && blame) {
          boolean dbcheck = JdbcConnector.databasecheck(firstName, lastName, Email, pass);
          if (!dbcheck) {
            error = "Already registered";
            result(false, error);
          } else {
            result(true, error);
          } 
        } 
      } 
    } 
  }
}
