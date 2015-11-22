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
public class Partidas extends sistemacontable.claseconexion implements operaciones<Partidas> {
    private int IdPartida;
    private int IdPeriodo;
    private String Fpartida;
    private String Npartida;

    private Partidas(int aInt, int aInt0, float aFloat, float aFloat0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdPartida() {
        return IdPartida;
    }

    public void setIdPartida(int IdPartida) {
        this.IdPartida = IdPartida;
    }

    public int getIdPeriodo() {
        return IdPeriodo;
    }

    public void setIdPeriodo(int IdPeriodo) {
        this.IdPeriodo = IdPeriodo;
    }

    public String getFpartida() {
        return Fpartida;
    }

    public void setFpartida(String Fpartida) {
        this.Fpartida = Fpartida;
    }

    public String getNpartida() {
        return Npartida;
    }

    public void setNpartida(String Npartida) {
        this.Npartida = Npartida;
    }

    @Override
    public void insertar() {
 try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("INSERT INTO 'tblpartida' ('IdPeriodo','Fpartida','Npartida')"
                    + " VALUES ('" + IdPeriodo + "','" + Fpartida + "','" + Npartida + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }      }

    @Override
    public void borrar() {
   try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("DELETE FROM tblpartida WHERE IdPartida='" + IdPartida + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }    }

    @Override
    public void actualizar() {
try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("UPDATE 'tblpartida' SET 'IdPeriodo'='" + IdPeriodo + "',"
                    + " 'Fpartida'='" + Fpartida + "'," + " 'Npartida'='" + Npartida + ";");

        } catch (Exception e) {
            e.printStackTrace();
        }    }

    @Override
    public ArrayList<Partidas> consultar() {
       try {
            conectar();
            St = con.createStatement();

            Rs = St.executeQuery("SELECT* FROM 'tblpartida");
            registros = new ArrayList<Partidas>();

            while (Rs.next()) {
                registros.add(new Partidas(Rs.getInt(1), Rs.getInt(2), Rs.getFloat(3), Rs.getFloat(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
    }    
               return registros;}

    
    
}
