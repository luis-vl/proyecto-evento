package Vista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author OWNER
// */
public class Conexion {
    public String db = "teatro";
    public String url = "jdbc:mysql://localhost:3306/" + db+"?serverTimezone=UTC";
    public String user = "root";
    public String pass = "Sistema/123";

  
    public Conexion() {
    }

    public Connection conectar() {
        Connection link = null;
//org.gjt.mm.mysql.Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);

        }

        return link;
    }
}
    
    



