
public class Trabajo {
	private String area;
	private double metrosCuadrados;
	private double costePintura_metroCuadrado;
	private double horasTrabajadas;
	private double precioHoraTrabajo;
	private double totalTrabajo;
	private double totalpintura;
	
	public Trabajo(String area, double metrosCuadrados, double costePintura_metroCuadrado, double horasTrabajadas,
			double precioHoraTrabajo) {
		super();
		this.area = area;
		this.metrosCuadrados = metrosCuadrados;
		this.costePintura_metroCuadrado = costePintura_metroCuadrado;
		this.horasTrabajadas = horasTrabajadas;
		this.precioHoraTrabajo = precioHoraTrabajo;
		this.totalTrabajo = 0;
		this.totalpintura=0;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public double getCostePintura_metroCuadrado() {
		return costePintura_metroCuadrado;
	}

	public void setCostePintura_metroCuadrado(double costePintura_metroCuadrado) {
		this.costePintura_metroCuadrado = costePintura_metroCuadrado;
	}

	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public double getPrecioHoraTrabajo() {
		return precioHoraTrabajo;
	}

	public void setPrecioHoraTrabajo(double precioHoraTrabajo) {
		this.precioHoraTrabajo = precioHoraTrabajo;
	}

	public double getTotalTrabajo() {
		double coste= getHorasTrabajadas()*getPrecioHoraTrabajo();
		setTotalTrabajo(coste);
		return totalTrabajo;
	}

	public void setTotalTrabajo(double totalTrabajo) {
		this.totalTrabajo = totalTrabajo;
	}

	public double getTotalpintura() {
		double coste=getMetrosCuadrados()*getCostePintura_metroCuadrado();
		setTotalpintura(coste);
		return totalpintura;
	}

	public void setTotalpintura(double totalpintura) {
		this.totalpintura = totalpintura;
	}
	
	
}
