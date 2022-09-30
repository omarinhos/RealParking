package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class TxtConfiguracionDAO extends DAO<ConfiguracionDTO> {

    @Override
    public void create(ConfiguracionDTO configuracion) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("configuracion.txt");
            pw = new PrintWriter(fichero);

            pw.append("Razon Social: " + configuracion.getRazonSocial() + "\n");
            pw.append("RUC: " + configuracion.getRUC() + "\n");
            pw.append("Nombre Comercial: " + configuracion.getNombreComercial() + "\n");
            pw.append("Espacios: " + configuracion.getEspacios() + "\n");
            pw.append("Tarifa: " + configuracion.getTarifa());

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public ConfiguracionDTO findBy(String nombrefichero) {

        ConfiguracionDTO configuracionDTO = new ConfiguracionDTO();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(nombrefichero));
            configuracionDTO.setRazonSocial(br.readLine().substring(14));
            configuracionDTO.setRUC(br.readLine().substring(5));
            configuracionDTO.setNombreComercial(br.readLine().substring(18));
            configuracionDTO.setEspacios(Integer.parseInt(br.readLine().substring(10)));
            configuracionDTO.setTarifa(Double.parseDouble(br.readLine().substring(8)));

            br.close();

        } catch (Exception e) {
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
