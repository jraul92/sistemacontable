/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Agry
 */
public class calculos {

    public void calcular(JTable tabla) {
        double i = 0,d =0;
        String tipo = "";
        double debe, haber;
        for (int j = 0; j < tabla.getRowCount(); j++) {
            tipo = (String) tabla.getValueAt(j, 3);
            System.out.println(tipo);
            debe = Double.parseDouble((String) tabla.getValueAt(j, 1));
            haber = Double.parseDouble((String) tabla.getValueAt(j, 2));
            switch (tipo) {
                case "ACTIVO":
                    i += debe-haber;
                    break;
                case "PASIVO":
                    d += haber-debe;
                    break;
                case "INGRESOS":
                     d += haber-debe;
                    
                    break;
                case "GASTOS":
                   i += debe-haber;
                    break;
                case "CAPITAL":
                    d += haber-debe;
                    break;
            }

        }
        System.out.println("Debe: "+i+" haber "+d);

    }
}
