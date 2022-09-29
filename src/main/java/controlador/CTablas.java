package controlador;

import javax.swing.table.DefaultTableModel;

public class CTablas {
    
    private void eliminarTodasLasFilas(DefaultTableModel modelo) {
        int nRow = modelo.getRowCount();
        for (int i = nRow - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    
    
}