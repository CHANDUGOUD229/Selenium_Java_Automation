package utility;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBUtility extends PropertyFilesLoader {
    static Connection con = null;
    static Statement statement = null;
    static ResultSet rs = null;
    static ResultSetMetaData rsmd = null;
    static PreparedStatement preparedstatement = null;
    static SimpleDateFormat smpldateformat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS");
    GenericMethods gm = new GenericMethods();

    public Connection connectDb() {
        System.out.println("Connecting to database" + "\n" + smpldateformat.format(new Date()) + "\n............");
        try {
            con = DriverManager.getConnection(getProperty("connectionString"), getProperty("dbUserName"), getProperty("dbPassWord"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public Statement getStatement() {
        try {
            statement = connectDb().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public String showDatabase(String SQl_Query) throws SQLException {
        try {
            gm.writeLoginfo("Showing records");
            rs = getStatement().executeQuery(SQl_Query);
            rsmd = rs.getMetaData();
            int columnNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnNumber; i++) {
                    System.out.println(rs.getString(i) + "\t");
                }
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return rs.getString(1);
    }

}