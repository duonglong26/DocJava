import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoConnectDb {
    public static void main(String[] args) {
        String dbUrl = "jdbc:sqlserver://LAPTOP-6E8C1ESV\\SQLEXPRESS;database=javaLop;" +
                "user=sa;password=123456;";
        String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String query = "Select * from UserTb";
        try {
            Class.forName(dbClass);
            Connection con = DriverManager.getConnection(dbUrl);
            System.out.println("Connected.");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return;
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error." + e);

        }
    }
}
