package ar.edu.unlam.www;

public class Libro implements Comparable<Libro>{
	private String isbn = "";
	private String nombre = "";
	
	public Libro(String isbn, String nombre) {
		this.isbn = isbn;
		this.nombre = nombre;
	}
	
	public String getIsbn(){
		return isbn;
	}
	
	@Override
	public int compareTo(Libro o) {
		// TODO Auto-generated method stub
		if(this.isbn == null){
			return 1;
		}
		else {
			if(o.isbn == null){
				return -1;
			}	
			else {
				return o.isbn.compareTo(this.isbn);
			}
		}
	}
	
}
