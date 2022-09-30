package modelo;

public class Configuracion {

    private String razonSocial;
    private String RUC;
    private String nombreComercial;
    private int espacios;
    private double tarifa;

    public Configuracion() {
    }

    public Configuracion(String razonSocial, String RUC, String nombreComercial, int espacios, double tarifa) {
        this.razonSocial = razonSocial;
        this.RUC = RUC;
        this.nombreComercial = nombreComercial;
        this.espacios = espacios;
        this.tarifa = tarifa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public int getEspacios() {
        return espacios;
    }

    public void setEspacios(int espacios) {
        this.espacios = espacios;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }



}
