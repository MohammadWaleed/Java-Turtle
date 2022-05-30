package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Turtle {
	
	private String species;
	private double weight = -1;
	private double length = -1;
	private int flippers = -1;
	private String location = "";
	private Date date;
	
	public Turtle(String species) {
		this.species = species;
		this.date = new Date();
	}
	
	public Turtle(String species, double weight, double length, int flippers, String location) {
		this.species = species;
		this.weight = weight;
		this.length = length;
		this.flippers = flippers;
		this.location = location;
		this.date = new Date();
	}
	
	public String getSpecies() {
		return species;
	}
		
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public int getFlippers() {
		return flippers;
	}
	
	public void setFlippers(int flippers) {
		this.flippers = flippers;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getTime() {
		SimpleDateFormat format  = new SimpleDateFormat("hh:mm:ss");
		return format.format(date);
	}
	
	public String getDate() {
		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	
	public String getString() {
		return 	"|----------------\n"+
				"| Species: "+this.getSpecies()+"\n"+
				"| Weight: "+this.getWeight()+"\n"+
				"| Length: "+this.getLength()+"\n"+
				"| Flippers: "+this.getFlippers()+"\n"+
				"| Location: "+this.getLocation()+"\n"+
				"| Date: "+this.getDate()+" || Time: "+this.getTime()+"\n"+
				"|----------------\n";
	}
	
}
