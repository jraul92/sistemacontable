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
public class PeriodoContable extends sistemacontable.claseconexion implements operaciones<PeriodoContable> {
     
    private int IdPeriodo;
    private String FInicio;
    private String FFin;

    public int getIdPeriodo() {
        return IdPeriodo;
    }

    public void setIdPeriodo(int IdPeriodo) {
        this.IdPeriodo = IdPeriodo;
    }

    public String getFInicio() {
        return FInicio;
    }

    public void setFInicio(String FInicio) {
        this.FInicio = FInicio;
    }

    public String getFFin() {
        return FFin;
    }

    public void setFFin(String FFin) {
        this.FFin = FFin;
    }
    
    
    public  PeriodoContable(){
    
    }
    public PeriodoContable(int IdPeriodo, String FInicio, String FFin) {
        this.IdPeriodo = IdPeriodo;
        this.FInicio = FInicio;
        this.FFin = FFin;
     
    }

    @Override
    public void insertar() {
 try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("INSERT INTO 'tblperiodo' ('FInicio','FFin')"
                    + " VALUES ('" + FInicio + "','" + FFin + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }    }

    @Override
    public void borrar() {
    try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("DELETE FROM tblperiodo WHERE IdPeriodo='" + IdPeriodo + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }    }

    @Override
    public void actualizar() {
     try {
            conectar();
            St = con.createStatement();
            St.executeUpdate("UPDATE 'tblperiodo' SET 'FInicio'='" + FInicio + "',"
                    + " 'FFin'='" + FFin + "';");

        } catch (Exception e) {
            e.printStackTrace();
        }    }

    @Override
    public ArrayList<PeriodoContable> consultar() {
  try {
            conectar();
            St = con.createStatement();

            Rs = St.executeQuery("SELECT* FROM 'tblperiodo");
            registros = new ArrayList<PeriodoContable>();

            while (Rs.next()) {
                registros.add(new PeriodoContable(Rs.getInt(1), Rs.getString(2), Rs.getString(3)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }   
    return registros;}
    
}
