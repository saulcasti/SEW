import java.util.ArrayList;
import java.util.List;

public class GestorArtistas {
	List<Artista> arts;
	
	public String getConc(String art) {
		String text="+ "+ art+":\n\n";
		for(Artista a:arts) {
			if(a.getNombre().equals(art))
				text+=a.toString();
	    }return text +"\n";
	}
	public void setArts(List<Artista> as) {arts=as;}
	
	public List<String> getArtistas(){
		List<String> ar= new ArrayList<String>();
		for(Artista a:arts) {
				ar.add(a.getNombre());
	    }return ar;
	}
}
