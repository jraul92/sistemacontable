/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import sistemacontable.claseconexion;

/**
 *
 * @author Agry
 */
public class Catalogo extends sistemacontable.claseconexion implements operaciones<Catalogo> {

    private int CuentaPadre;
    private int IdCuenta;
    private String NCuenta;
    private String Cuenta;
    private String Tipo;

    public Catalogo() {

    }

    public Catalogo(String NCuenta, String Cuenta, String Tipo) {

        this.NCuenta = NCuenta;
        this.Cuenta = Cuenta;
        this.Tipo = Tipo;
    }

    public Catalogo(String NCuenta, String Tipo) {

        this.NCuenta = NCuenta;
        this.Tipo = Tipo;
    }

    public Catalogo(int IdCuenta, String NCuenta, String Cuenta, int CuentaPadre, String Tipo) {
        this.CuentaPadre = CuentaPadre;
        this.IdCuenta = IdCuenta;
        this.NCuenta = NCuenta;
        this.Cuenta = Cuenta;
        this.Tipo = Tipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getCuentaPadre() {
        return CuentaPadre;
    }

    public void setCuentaPadre(int CuentaPadre) {
        this.CuentaPadre = CuentaPadre;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public String getNCuenta() {
        return NCuenta;
    }

    public void setNCuenta(String NCuenta) {
        this.NCuenta = NCuenta;
    }

    public String getCuenta() {
        return Cuenta;
    }

    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;

    }

    @Override
    public String toString() {

        return Cuenta;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar() {
        try {
            conectar();
            St = con.createStatement();

            St.executeUpdate("INSERT INTO tblcatalogo(NCuenta,Cuenta,TipoCuenta)"
                    + " VALUES('" + NCuenta + "','" + Cuenta + "','" + Tipo + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar() {
        try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("DELETE FROM tblcatalogo WHERE IdCuenta='" + IdCuenta + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar() {
        try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("UPDATE 'tblcatalogo' SET 'NCuenta'='" + NCuenta + "',"
                    + " 'Cuenta'='" + Cuenta + "', 'CuentaPadre'`='" + CuentaPadre + "', 'TipoCuenta'`='" + Tipo + "'WHERE  'IdCuenta'='" + IdCuenta + "';");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Catalogo> consultar() {
        try {
            conectar();
            St = con.createStatement();

            Rs = St.executeQuery("SELECT * FROM tblcatalogo ORDER BY CuentaPadre");
            registros = new ArrayList<Catalogo>();

            while (Rs.next()) {
                registros.add(new Catalogo(Rs.getInt(1), Rs.getString(2), Rs.getString(3), Rs.getInt(4), Rs.getString(5)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return registros;

    }

    public String[] consultarN(String numero) {
        String N[] = new String[2];
        try {
            conectar();
            St = con.createStatement();
            Rs = St.executeQuery("SELECT Ncuenta,TipoCuenta FROM tblcatalogo WHERE `CuentaPadre` = '" + numero + "'");
            registros = new ArrayList<Catalogo>();
            while (Rs.next()) {
                registros.add(new Catalogo(Rs.getString(1), Rs.getString(2)));
            }
            Catalogo cuentamayor = (Catalogo) registros.get(registros.size() - 1);
            N[0] = numero + "." + registros.size();
            N[1] = cuentamayor.getTipo();
             System.out.println(cuentamayor.getCuentaPadre());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return N;

    }
    
    


}
