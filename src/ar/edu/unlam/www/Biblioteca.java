package ar.edu.unlam.www;

import java.util.*;
import java.util.Map.Entry;

public class Biblioteca {
	
	private HashMap<Section, TreeSet<Libro>> myHashMap = new HashMap<Section, TreeSet<Libro>>(); 
	
	public void createSection(String nombre){
		Section key = new Section(nombre);
		myHashMap.put(key, new TreeSet<Libro>());
	}
			
	public Boolean existKey(String nombre){
		return myHashMap.containsKey(new Section(nombre));
	}
	
	public void addLibro(String nombreSeccion, String isbn, String nombre){ 
		Section key = new Section(nombreSeccion);
		
		TreeSet<Libro>  myTreeSet = myHashMap.get(key);
		
		myTreeSet.add(new Libro(isbn, nombre));
		
		myHashMap.put(key, myTreeSet);
	}
	
	public Boolean existLibro(String nombreSeccion, String isbn, String nombre){
		TreeSet<Libro> myTreeSet = new TreeSet<Libro>(); 
		Section key = new Section(nombreSeccion);
		
		myTreeSet = (TreeSet<Libro>)myHashMap.get(key);
		
		return (myTreeSet.contains(new Libro(isbn, nombre)));
	}
	
	public Libro getLibro(String isbn) throws Exception{
		for (Entry<Section, TreeSet<Libro>> e: myHashMap.entrySet()) {
	        TreeSet<Libro> myTreeSet = e.getValue();
	        
	        Iterator<Libro> myIterator = myTreeSet.iterator();
	        while (myIterator.hasNext()){
	        	Libro libro = myIterator.next();
	        	
	        	if((libro.getIsbn().compareTo(isbn)) == 0){
	        		return libro;
	        	}
	        }
		}
		throw new Exception("no existe el libro");
	}
}
