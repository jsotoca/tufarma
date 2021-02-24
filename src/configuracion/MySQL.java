package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class MySQL {
    
    private Connection conn = null;
    private static MySQL instance = null;
    

    private MySQL() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager
                        .getConnection("jdbc:mysql://"+Entorno.DB_HOST+"/"+Entorno.DB_NAME,
                                Entorno.DB_USER,
                                Entorno.DB_PASS);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    
    public static MySQL getInstance() throws Exception {
        try {
            if(instance == null) instance = new MySQL();
            return instance;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Connection getConnection() throws Exception {
        try {
            return getInstance().conn;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ResultSet executeQuery(String query, List<Object> values) throws Exception {
        Statement stm;
        ResultSet rs = null;
        try {
            stm = getInstance().conn.createStatement();
            rs = stm.executeQuery(query);
            
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }
    
    public static boolean executeUpdate(String query, List<Object> values) throws Exception {
        PreparedStatement stm;
        boolean result = false;
        try {
            
            stm = getInstance().conn.prepareStatement(query);
            int idx = 1;
            
            for (Object temp : values) {
                stm.setObject(idx, temp);
                idx++;
            }
            
            int row = stm.executeUpdate();
            result = (row == 1);
            
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
    
    
}
