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
public class LibroMayor extends sistemacontable.claseconexion implements operaciones<LibroMayor>{     
    private int IdMayor;
    private int IdCuenta;
    private float Saldo;
    
    public LibroMayor (){
    
    }

    public LibroMayor(int IdMayor, int IdCuenta, float Saldo) {
        this.IdMayor = IdMayor;
        this.IdCuenta = IdCuenta;
        this.Saldo = Saldo;
    }

    public int getIdMayor() {
        return IdMayor;
    }

    public void setIdMayor(int IdMayor) {
        this.IdMayor = IdMayor;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }

    @Override
    public void insertar() {
 try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("INSERT INTO 'tblmayor' ('IdCuenta','Saldo')"
                    + " VALUES ('" + IdCuenta + "','" + Saldo + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }      }

    @Override
    public void borrar() {
 try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("DELETE FROM tblmayor WHERE IdMayor='" + IdMayor + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }      }

    @Override
    public void actualizar() {
 try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("UPDATE 'tblmayor' SET 'IdCuenta'='" + IdCuenta + "',"
                    + " 'Saldo'='" + Saldo + "';");

        } catch (Exception e) {
            e.printStackTrace();
        }    }

    @Override
    public ArrayList<LibroMayor> consultar() {
try {
            conectar();
            St = con.createStatement();

            Rs = St.executeQuery("SELECT* FROM 'tblmayor");
            registros = new ArrayList<LibroMayor>();

            while (Rs.next()) {
                registros.add(new LibroMayor(Rs.getInt(1), Rs.getInt(2), Rs.getFloat(3)));

            }

        } catch (Exception e) {
            e.printStackTrace();
            }
        return registros;}

}
