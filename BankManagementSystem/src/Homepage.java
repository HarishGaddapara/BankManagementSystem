import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Homepage extends JFrame implements ActionListener {
  JLabel bg;
  
  JLabel hdfc;
  
  JLabel bankLogoJLabel;
  
  JButton adminButton;
  
  JButton userButton;
  
  public Homepage() {
    setTitle("HDFC BANK HOMEPAGE");
    setBounds(80, 100, 1200, 600);
    setLayout((LayoutManager)null);
    setResizable(false);
    bg = new JLabel(new ImageIcon(getClass().getResource("background.jpg")));
    bg.setBounds(0, 0, 1200, 600);
    add(bg);
    hdfc = new JLabel(new ImageIcon(getClass().getResource("hdfcc.png")));
    hdfc.setBounds(0, 0, 1200, 200);
    bg.add(hdfc);
    bankLogoJLabel = new JLabel(new ImageIcon(getClass().getResource("indiasNo1bank.png")));
    bankLogoJLabel.setBounds(0, 300, 321, 150);
    bg.add(bankLogoJLabel);
    userButton = new JButton(new ImageIcon(getClass().getResource("1userlogin.jpg")));
    userButton.setBounds(400, 300, 400, 150);
    bg.add(userButton);
    userButton.addActionListener(this);
    setVisible(true);
  }
  
  public static void main(String[] args) {
	  new Homepage();
  }
  
  public void actionPerformed(ActionEvent e) {
    new user_log_in();
    setVisible(false);
    dispose();
  }
}