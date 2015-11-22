package sistemacontable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Agry
 */
import entidades.Catalogo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class claseconexion {

    private String url = "jdbc:mysql://localhost:3306/dbcontable";
    private String login = "root";
    private String password = "";
    protected Connection con = null;
    protected Statement St = null;
    protected ResultSet Rs = null;
    private String driver = "com.mysql.jdbc.Driver";
    protected ArrayList registros;
    protected ArrayList Cuentas;

    public Connection conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, login, password);
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    


   

}
