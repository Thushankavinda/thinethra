
package thinethra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



 class thinethra_DBClass {

   private static Connection c;
   public static void setUpConnection() throws Exception{
   Class.forName("com.mysql.jdbc.Driver");
   c=DriverManager.getConnection("jdbc:mysql://localhost:3306/thinethra","root","123");  
   //c=DriverManager.getConnection("jdbc:mysql://system.premierhealthcare.lk:3306/systemph_machine_management","systemph_root","machinemanagementroot");
//   c=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12357708","sql12357708","fXCW3p1f7h");
  //c=DriverManager.getConnection("jdbc:mysql://mysql-11810-0.cloudclusters.net:11810/machine_management","admin","123");
   
   //c=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12360148","sql12360148","vUnD8sA1zu");
   }
   public static void iud(String sql) throws Exception{
       if (c==null) {
           setUpConnection();
       }
       c.createStatement().executeUpdate(sql);
   }
  public static ResultSet search(String sql)throws Exception{
      if (c==null) {
          setUpConnection();
      }
      
      return c.createStatement().executeQuery(sql);
  }
  public static Connection getcon() throws Exception{
      if (c==null) {
          setUpConnection();
      }
      
  return c;
  }
   
  public static int IUDwithKey(String query) throws Exception {
        int ret = 0;
        if (c == null) {
            setUpConnection();
        }
        Statement stmt = c.createStatement();
        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            ret = rs.getInt(1);
        }

        return ret;
    }
    
}
