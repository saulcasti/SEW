import java.util.List;

public class Factura {
	private List<Trabajo> trabajos;
	private String fecha;
	private String direccion;

	public Factura(List<Trabajo> trabajos, String fecha, String direccion) {
		this.trabajos = trabajos;
		this.fecha=fecha;
		this.direccion=direccion;
	}

	public void addTrabajo(Trabajo tr) {
		trabajos.add(tr);
	}
	public List<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(List<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}
	
	public double getTotal() {
		double coste=0;
		for(Trabajo t:trabajos) {
			coste+=t.getTotalpintura()+ t.getTotalTrabajo();
		}return coste;
	}
	
	public double getIva() {
		return getTotal()*0.21;
	}

	public double getTotalConIva() {
		return getTotal()+getIva();
	}
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String toString() {
		String text="";
		for(Trabajo t:trabajos) {
			text+="Pintado de "+ t.getArea() +"\n      Coste total pintura: "+t.getTotalpintura() +"\n      Coste total mano de obra: "+t.getTotalTrabajo();
			text+="\n";
		}
		return text;
	}

}
