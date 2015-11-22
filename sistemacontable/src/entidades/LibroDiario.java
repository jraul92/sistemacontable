/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author Agry
 */
public class LibroDiario extends sistemacontable.claseconexion implements operaciones<LibroDiario> {

    private int IdDiario;
    private int IdPartida;
    private int IdCuenta;
    private Float Debe;
    private Float Haber;

    public LibroDiario(int aInt, int aInt1, float aFloat, float aFloat1) {

    }

    private LibroDiario(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdDiario() {
        return IdDiario;
    }

    public void setIdDiario(int IdDiario) {
        this.IdDiario = IdDiario;
    }

    public int getIdPartida() {
        return IdPartida;
    }

    public void setIdPartida(int IdPartida) {
        this.IdPartida = IdPartida;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public Float getDebe() {
        return Debe;
    }

    public void setDebe(Float Debe) {
        this.Debe = Debe;
    }

    public Float getHaber() {
        return Haber;
    }

    public void setHaber(Float Haber) {
        this.Haber = Haber;
    }

    @Override
    public void insertar() {
        try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("INSERT INTO 'tbldiario' ('IdPartida','IdCuenta','Debe','Haber')"
                    + " VALUES ('" + IdPartida + "','" + IdCuenta + "','" + Debe + "','" + Haber + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar() {
        try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("DELETE FROM tbldiario WHERE IdDiario='" + IdDiario + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


@Override
        public void actualizar() {
   try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("UPDATE 'tbldiario' SET 'IdPartida'='" + IdPartida + "',"
                    + " 'IdCuenta'='" + IdCuenta + "'," + " 'Debe'='" + Debe + "'," + " 'Haber'='" + Haber + "';");

        } catch (Exception e) {
            e.printStackTrace();
        }   
}

    @Override
        public ArrayList<LibroDiario> consultar() {
             try {
            conectar();
            St = con.createStatement();

            Rs = St.executeQuery("SELECT* FROM 'tbldiario");
            registros = new ArrayList<LibroDiario>();

            while (Rs.next()) {
                registros.add(new LibroDiario(Rs.getInt(1), Rs.getInt(2), Rs.getFloat(3), Rs.getFloat(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
    }
    
    
        return registros;}

}
