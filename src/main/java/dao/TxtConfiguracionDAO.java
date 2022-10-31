package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import modelo.Configuracion;

public class TxtConfiguracionDAO extends DAO<Configuracion> {

    @Override
    public void create(Configuracion configuracion) {
        
        try (FileWriter fichero = new FileWriter("configuracion.txt");
            PrintWriter pw = new PrintWriter(fichero)){
          
            pw.append("Razon Social: " + configuracion.getRazonSocial() + "\n");
            pw.append("RUC: " + configuracion.getRUC() + "\n");
            pw.append("Nombre Comercial: " + configuracion.getNombreComercial() + "\n");
            pw.append("Espacios: " + configuracion.getEspacios() + "\n");
            pw.append("Tarifa: " + configuracion.getTarifa());

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public Configuracion findBy(String nombrefichero) {

        Configuracion configuracion = new Configuracion();

        try (BufferedReader br = new BufferedReader(new FileReader(nombrefichero))){
 
            configuracion.setRazonSocial(br.readLine().substring(14));
            configuracion.setRUC(br.readLine().substring(5));
            configuracion.setNombreComercial(br.readLine().substring(18));
            configuracion.setEspacios(Integer.parseInt(br.readLine().substring(10)));
            configuracion.setTarifa(Double.parseDouble(br.readLine().substring(8)));

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(System.out);
        }
        return configuracion;
    }

    @Override
    public void update(Configuracion configuracion) {

    }

    @Override
    public List<Configuracion> filter(String filtro) {
        return null;
    }

    @Override
    public List<Configuracion> getList() {
        return null;
    }

    @Override
    public void delete(int id) {
    }

}
