package javaMysqlConnection.modelo;


public class Coche {
    private String matricula;
    private String modelo;
    private TipoVehiculo tipoVehiculo;
    private double precio;
    private String color;
    private int kilometros;
    private Integer garantiaMeses;
    private String antiguoPropietario;

    public enum TipoVehiculo {
        KM0, SEGUNDA_MANO, NUEVO
    }

    public Coche(String matricula, String modelo, TipoVehiculo tipoVehiculo, double precio, String color, int kilometros, Integer garantiaMeses, String antiguoPropietario) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.precio = precio;
        this.color = color;
        this.kilometros = kilometros;
        this.garantiaMeses = garantiaMeses;
        this.antiguoPropietario = antiguoPropietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public Integer getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(Integer garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public String getAntiguoPropietario() {
        return antiguoPropietario;
    }

    public void setAntiguoPropietario(String antiguoPropietario) {
        this.antiguoPropietario = antiguoPropietario;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipoVehiculo=" + tipoVehiculo +
                ", precio=" + precio +
                ", color='" + color + '\'' +
                ", kilometros=" + kilometros +
                ", garantiaMeses=" + garantiaMeses +
                ", antiguoPropietario='" + antiguoPropietario + '\'' +
                '}';
    }

	public Enum<TipoVehiculo> getTipoVehiculo1() {
		return null;
	}
}