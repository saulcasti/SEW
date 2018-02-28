import java.util.ArrayList;
import java.util.List;

public class Artista {
	private String nombre;
	private int numeroMiembros;
	private List<Concierto> conciertos;
	
	public Artista(String nombre, int numeroMiembros, List<Concierto> conciertos) {
		this.nombre = nombre;
		this.numeroMiembros = numeroMiembros;
		this.conciertos = conciertos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroMiembros() {
		return numeroMiembros;
	}

	public void setNumeroMiembros(int numeroMiembros) {
		this.numeroMiembros = numeroMiembros;
	}

	public List<Concierto> getConciertos() {
		return conciertos;
	}

	public void setConciertos(List<Concierto> conciertos) {
		this.conciertos = conciertos;
	}
	
	public String toString() {
		String text="";
		List<String> giras= new ArrayList<String>();
		for(Concierto c:conciertos) {
			String nuevagira=c.getGira();
			
			if(giras.size()==0) giras.add(nuevagira);
			else {
			if(!giras.contains(nuevagira))giras.add(nuevagira);
			}
		}
		
		for(String g:giras) {
			text+="\tGira " + g +"\n";
			for(Concierto c:conciertos) {
				if(g.equals(c.getGira())) {
					text+="\t\tLugar: "+ c.getSala() + ", "+ c.getCiudad() + " // "+c.getFecha()+"\n";
				}
			}text+="\n";
		}
		return text;
	}
}
