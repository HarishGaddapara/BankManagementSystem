import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JdbcConnector {
  public static boolean databasecheck(String fn, String ln, String e, String p) {
    try {
      String url = "jdbc:mysql://localhost:3306/GIRAFFE";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
      PreparedStatement pst = conn.prepareStatement("SELECT * FROM GIRAFFE.KITSW WHERE EMAIL=?");
      pst.setString(1, e);
      ResultSet rs = pst.executeQuery();
      boolean bool = true;
      if (rs.next()) {
        bool = false;
        JOptionPane.showMessageDialog(null, "You have already an account, Try Login");
        return false;
      } 
      PreparedStatement pst1 = conn.prepareStatement("INSERT INTO GIRAFFE.KITSW(FIRST_NAME,LAST_NAME,EMAIL,PASSWORD) VALUES(?,?,?,?)");
      pst1.setString(1, fn);
      pst1.setString(2, ln);
      pst1.setString(3, e);
      pst1.setString(4, p);
      pst1.executeUpdate();
      JOptionPane.showMessageDialog(null, " Successfully signed up ");
      return true;
    } catch (ClassNotFoundException|java.sql.SQLException ex) {
      ex.printStackTrace();
      return true;
    } 
  }
  
  public static String databasecheck_userid_password(String id, String pass) {
    try {
      String url = "jdbc:mysql://localhost:3306/GIRAFFE";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
      PreparedStatement pst = conn.prepareStatement("SELECT * FROM GIRAFFE.CUSTOMERS WHERE USER_ID=? and PASSWORD=?");
      pst.setInt(1, Integer.parseInt(id));
      pst.setString(2, pass);
      ResultSet rs = pst.executeQuery();
      if (rs.next()) {
        JOptionPane.showMessageDialog(null, "Successfully sign in");
        return rs.getString(3);
      } 
      JOptionPane.showMessageDialog(null, "Incorrect details");
      return "yes";
    } catch (ClassNotFoundException|java.sql.SQLException ex) {
      ex.printStackTrace();
      System.out.print("exceptiom");
      return "yes";
    } 
  }
  
  public static String getBalance(String id) {
    try {
      String url = "jdbc:mysql://localhost:3306/GIRAFFE";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
      PreparedStatement pst = conn.prepareStatement("SELECT * FROM GIRAFFE.CUSTOMERS WHERE USER_ID=?");
      pst.setInt(1, Integer.parseInt(id));
      ResultSet rs = pst.executeQuery();
      if (rs.next())
        return String.valueOf(rs.getInt(4)); 
      JOptionPane.showMessageDialog(null, "database went offline");
      return "offline";
    } catch (ClassNotFoundException|java.sql.SQLException ex) {
      ex.printStackTrace();
      System.out.print("exceptiom");
      return "yes";
    } 
  }
  
  public static boolean database_update_balance(String id, String dep) {
    try {
      String url = "jdbc:mysql://localhost:3306/GIRAFFE";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
      PreparedStatement to_get_bal = conn.prepareStatement("SELECT * FROM GIRAFFE.CUSTOMERS WHERE USER_ID=?");
      to_get_bal.setInt(1, Integer.parseInt(id));
      ResultSet bal = to_get_bal.executeQuery();
      if (bal.next()) {
        int prevbalance = bal.getInt(4);
        prevbalance += Integer.parseInt(dep);
        PreparedStatement to_update_bal = conn.prepareStatement("UPDATE GIRAFFE.CUSTOMERS SET BALANCE = ? WHERE USER_ID=?");
        to_update_bal.setInt(1, prevbalance);
        to_update_bal.setInt(2, Integer.parseInt(id));
        to_update_bal.executeUpdate();
        return true;
      } 
    } catch (ClassNotFoundException|java.sql.SQLException ex) {
      ex.printStackTrace();
      System.out.print("exceptiom");
      return false;
    } 
    return true;
  }
  
  public static boolean database_deduct_balance(String id, String wd) {
    try {
      String url = "jdbc:mysql://localhost:3306/GIRAFFE";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
      PreparedStatement to_get_bal = conn.prepareStatement("SELECT * FROM GIRAFFE.CUSTOMERS WHERE USER_ID=?");
      to_get_bal.setInt(1, Integer.parseInt(id));
      ResultSet bal = to_get_bal.executeQuery();
      if (bal.next()) {
        int prevbalance = bal.getInt(4);
        if (prevbalance >= Integer.parseInt(wd)) {
          prevbalance -= Integer.parseInt(wd);
          PreparedStatement to_update_bal = conn.prepareStatement("UPDATE GIRAFFE.CUSTOMERS SET BALANCE = ? WHERE USER_ID=?");
          to_update_bal.setInt(1, prevbalance);
          to_update_bal.setInt(2, Integer.parseInt(id));
          to_update_bal.executeUpdate();
          return true;
        } 
        String string = getBalance(id);
        JOptionPane.showMessageDialog(null, "You have insufficient balance " + string + ".");
        return false;
      } 
    } catch (ClassNotFoundException|java.sql.SQLException ex) {
      ex.printStackTrace();
      System.out.print("exceptiom");
      return false;
    } 
    return true;
  }
  
  public static boolean database_transfer_amount(String acc_sender, String acc_receiver, String amount) {
    try {
      String url = "jdbc:mysql://localhost:3306/GIRAFFE";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
      PreparedStatement pst = conn.prepareStatement("SELECT * FROM GIRAFFE.CUSTOMERS WHERE USER_ID=?");
      pst.setInt(1, Integer.parseInt(acc_receiver));
      ResultSet rs = pst.executeQuery();
      if (rs.next()) {
        if (rs.getInt(1) != Integer.valueOf(acc_sender).intValue()) {
          JOptionPane.showConfirmDialog(null, "Confirm Account Holder Name : " + rs.getString(3) + ".");
          boolean deduct = database_deduct_balance(acc_sender, amount);
          if (deduct) {
            boolean credit = database_update_balance(acc_receiver, amount);
            if (credit)
              return true; 
            JOptionPane.showMessageDialog(null, "Unable to credit the amount into the receivers bank");
            return false;
          } 
          JOptionPane.showMessageDialog(null, "Unable to deduct money from your bank");
          return false;
        } 
        JOptionPane.showMessageDialog(null, "we cannot perform a transcation in same account");
        return false;
      } 
      JOptionPane.showMessageDialog(null, "Account does not exists");
      return false;
    } catch (ClassNotFoundException|java.sql.SQLException ex) {
      ex.printStackTrace();
      return false;
    } 
  }
  
  public static void main(String[] args) {}
  
  public static void database_enter_record(String sender, String accnumberR, String amount, String type) {
    try {
      String url = "jdbc:mysql://localhost:3306/GIRAFFE";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
      PreparedStatement enter_record = conn.prepareStatement("INSERT INTO GIRAFFE.TRANSCATIONS(accNoSender,typeTranscation,amount,accNoReceiver,tdate,ttime,tdt) VALUES(?,?,?,?,curdate(),curtime(),now())");
      enter_record.setInt(1, Integer.parseInt(sender));
      enter_record.setString(2, type);
      enter_record.setInt(3, Integer.parseInt(amount));
      enter_record.setInt(4, Integer.parseInt(accnumberR));
      enter_record.executeUpdate();
    } catch (ClassNotFoundException|java.sql.SQLException ex) {
      JOptionPane.showMessageDialog(null, "Unable to update record in database");
    } 
  }
  
  public static String[][] getData(String accno, String string) {
    ArrayList<ArrayList<Object>> strings = new ArrayList<>();
    try {
      String url = "jdbc:mysql://localhost:3306/GIRAFFE";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
      PreparedStatement to_get_rec = conn.prepareStatement("SELECT * FROM GIRAFFE.TRANSCATIONS WHERE accNoSender=? AND typeTranscation=? ORDER BY no DESC");
      to_get_rec.setInt(1, Integer.parseInt(accno));
      to_get_rec.setString(2, string);
      ResultSet bal = to_get_rec.executeQuery();
      int j = -1;
      while (bal.next()) {
        j++;
        strings.add(j, new ArrayList());
        int x = bal.getInt(4);
        strings.get(j).add("                                              " + String.valueOf(x) + "/-");
        if (x > 1) {
          strings.get(j).add("        " + String.valueOf(String.valueOf(num_to_word.findnum(x)) + "rupees only/-"));
        } else {
          strings.get(j).add(String.valueOf(num_to_word.findnum(x)));
        } 
          strings.get(j).add("                                           " + String.valueOf(bal.getDate(6)));
          strings.get(j).add("                                           " + String.valueOf(bal.getTime(7)));
      } 
    } catch (ClassNotFoundException|java.sql.SQLException ex) {
      ex.printStackTrace();
      System.out.print("exception at retreving data from the table transcations");
    } 
    String[][] data = new String[strings.size()][4];
    for (int i = 0; i < strings.size(); i++) {
      for (int j = 0; j < 4; j++)
        data[i][j] =(String) strings.get(i).get(j); 
    } 
    return data;
  }
  
  public static String[][] getData_transfer(String accno, String string) {
    ArrayList<ArrayList<Object>> strings = new ArrayList<>();
    try {
      String url = "jdbc:mysql://localhost:3306/GIRAFFE";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
      PreparedStatement to_get_rec = conn.prepareStatement("SELECT * FROM GIRAFFE.TRANSCATIONS WHERE accNoSender=? AND typeTranscation=? ORDER BY no DESC");
      to_get_rec.setInt(1, Integer.parseInt(accno));
      to_get_rec.setString(2, string);
      ResultSet bal = to_get_rec.executeQuery();
      int j = -1;
      while (bal.next()) {
        j++;
        strings.add(j, new ArrayList());
        strings.get(j).add("                                        " + String.valueOf(bal.getInt(5)));
        int x = bal.getInt(4);
        strings.get(j).add("                                               " + String.valueOf(x) + "/-");
        if (x > 1) {
          strings.get(j).add(" " + String.valueOf(String.valueOf(num_to_word.findnum(x)) + "rupees only/-"));
        } else {
          strings.get(j).add(String.valueOf(num_to_word.findnum(x)));
        } 
          strings.get(j).add("                              " + String.valueOf(bal.getTimestamp(8)));
      } 
    } catch (ClassNotFoundException|java.sql.SQLException ex) {
      ex.printStackTrace();
      System.out.print("exception at retreving data from the table transcations");
    } 
    String[][] data = new String[strings.size()][4];
    for (int i = 0; i < strings.size(); i++) {
      for (int j = 0; j < 4; j++)
        data[i][j] = (String) strings.get(i).get(j); 
    } 
    return data;
  }
  
  public static String[][] getData_recent(String accno) {
    ArrayList<ArrayList<Object>> strings = new ArrayList<>();
    try {
      String url = "jdbc:mysql://localhost:3306/GIRAFFE";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
      PreparedStatement to_get_rec = conn.prepareStatement("SELECT * FROM GIRAFFE.TRANSCATIONS WHERE accNoSender=? ORDER BY no DESC");
      to_get_rec.setInt(1, Integer.parseInt(accno));
      ResultSet bal = to_get_rec.executeQuery();
      int j = -1;
      while (bal.next()) {
        j++;
        strings.add(j, new ArrayList());
        strings.get(j).add("                                 " + String.valueOf(bal.getString(3)));
        int x = bal.getInt(4);
        int y = bal.getInt(5);
        if (y == 0) {
           strings.get(j).add("                                           -");
        } else {
          strings.get(j).add("                                     " + y);
        } 
        strings.get(j).add("                                     " + String.valueOf(x) + "/-");
        if (x > 1) {
          strings.get(j).add(" " + String.valueOf(String.valueOf(num_to_word.findnum(x)) + "rupees only/-"));
        } else {
          strings.get(j).add(String.valueOf(num_to_word.findnum(x)));
        } 
        strings.get(j).add("                    " + String.valueOf(bal.getTimestamp(8)));
      } 
    } catch (ClassNotFoundException|java.sql.SQLException ex) {
      ex.printStackTrace();
    } 
    String[][] data = new String[strings.size()][5];
    for (int i = 0; i < strings.size(); i++) {
      for (int j = 0; j < 5; j++)
        data[i][j] = (String) strings.get(i).get(j); 
    } 
    return data;
  }
}