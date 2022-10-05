package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TxtConfiguracionDAO extends DAO<ConfiguracionDTO> {

    @Override
    public void create(ConfiguracionDTO configuracion) {
        
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
    public ConfiguracionDTO findBy(String nombrefichero) {

        ConfiguracionDTO configuracionDTO = new ConfiguracionDTO();

        try (BufferedReader br = new BufferedReader(new FileReader(nombrefichero))){
 
            configuracionDTO.setRazonSocial(br.readLine().substring(14));
            configuracionDTO.setRUC(br.readLine().substring(5));
            configuracionDTO.setNombreComercial(br.readLine().substring(18));
            configuracionDTO.setEspacios(Integer.parseInt(br.readLine().substring(10)));
            configuracionDTO.setTarifa(Double.parseDouble(br.readLine().substring(8)));

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(System.out);
        }
        return configuracionDTO;
    }

    @Override
    public void update(ConfiguracionDTO configuracion) {

    }

    @Override
    public List<ConfiguracionDTO> filter(String filtro) {
        return null;
    }

    @Override
    public List<ConfiguracionDTO> getList() {
        return null;
    }

}
