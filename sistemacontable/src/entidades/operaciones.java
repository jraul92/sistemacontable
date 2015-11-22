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
public interface operaciones<E> {
    public void insertar();
    public void borrar();
    public void actualizar();
    public ArrayList<E> consultar();
    
}
