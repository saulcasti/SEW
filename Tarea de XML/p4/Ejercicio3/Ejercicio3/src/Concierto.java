
public class Concierto {
	private String sala;
	private String fecha;
	private String ciudad;
	private String gira;
	
	
	public Concierto(String sala, String fecha, String ciudad, String gira) {
		this.sala = sala;
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.gira = gira;
	}
	
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getGira() {
		return gira;
	}

	public void setGira(String gira) {
		this.gira = gira;
	}
	
}
