package classes;

import java.util.ArrayList;
import java.util.Arrays;

import species.Flatback;
import species.Green;
import species.Hawksbill;
import species.KempsRidley;
import species.Leatherback;
import species.Loggerhead;
import species.OliveRidley;

public class Store {
	
	private ArrayList<Turtle> records = new ArrayList<Turtle>();
	
	public boolean addRecord(Turtle newRecord) {
		return records.add(newRecord);
	}
	
	public void viewRecord(int id) {
		if(checkRecordExists(id)) {
			System.out.println(records.get(id-1).getString());
		}
	}
	
	public void removeRecord(int id) {
		if(checkRecordExists(id)) {
			records.remove(id-1);
		}
	}
	
	public void editRecord(int id,Turtle newTurtle) {
		
		if(!checkRecordExists(id)) {
			return;
		}
		
		Turtle oldTurtle = records.get(id-1);
		
		
		if(newTurtle.getFlippers() != -1) {
			oldTurtle.setFlippers(newTurtle.getFlippers());
		}
		
		if(newTurtle.getWeight() != -1) {
			oldTurtle.setWeight(newTurtle.getWeight());
		}
		
		if(newTurtle.getLength() != -1) {
			oldTurtle.setLength(newTurtle.getLength());
		}
		
		if(newTurtle.getLocation().trim() != "-1") {
			oldTurtle.setLocation(newTurtle.getLocation());
		}
		
		 this.records.set(id-1, oldTurtle);
	}
	

	public int getRecordsCount() {
		return records.size();
	}

	public boolean checkRecordExists(int id) {
		if(id >0 && id <= records.size()) {
			return true;
		}
		System.out.println("Invalid record ID");
		return false;
	}

	public void search(String species, char weightOperator, double weightLess, double weightMore, char lengthOperator,
			double lengthLess, double lengthMore, char flippersOperator, int flippersLess, int flippersMore,
			String location) {

		Object[] result = null;
		
		if(species.length() > 0) {
			// search using species
			// use to lower case to become case insensitive
			result = records.stream().filter(x -> x.getSpecies().toLowerCase().contains(species.toLowerCase())).toArray();				
		}
		
		if(weightOperator != 'n') {
			// search using Weight
			if(result != null) {
				result =  Arrays.asList(result).stream().filter(x -> compare(weightOperator,((Turtle) x).getWeight(),weightLess,weightMore)).toArray();				
			}else {
				result =  records.stream().filter(x -> compare(weightOperator,x.getWeight(),weightLess,weightMore)).toArray();				
			}
		}
		
		if(lengthOperator != 'n') {
			// search using Length
			if(result != null) {
				result =  Arrays.asList(result).stream().filter(x -> compare(lengthOperator,((Turtle) x).getLength(),lengthLess,lengthMore)).toArray();				
			}else {
				result =  records.stream().filter(x -> compare(lengthOperator,x.getLength(),lengthLess,lengthMore)).toArray();	
			}
		}
		
		if(flippersOperator != 'n') {
			// search using Weight
			if(result != null) {
			result = Arrays.asList(result).stream().filter(x -> compare(flippersOperator,((Turtle) x).getFlippers(),flippersLess,flippersMore)).toArray();
			}else {
				result =  records.stream().filter(x -> compare(flippersOperator,x.getFlippers(),flippersLess,flippersMore)).toArray();
			}
		}
		
		if(location.trim() != "-1") {
			// search using location
			if(result != null) {
				result =  Arrays.asList(result).stream().filter(x -> ((Turtle) x).getLocation().toLowerCase().contains(species.toLowerCase())).toArray();								
			}else {
				result =  records.stream().filter(x -> x.getLocation().toLowerCase().contains(species.toLowerCase())).toArray();								
			}
		}
		
		if(result.length > 0) {
			System.out.println("Found " + result.length +" records");
			for(int i=0; i<result.length;i++) {
				System.out.println(((Turtle) result[i]).getString());
			}
		}else {
			System.out.println("No records found");
		}
		
		
	}
	
	public void getReport() {
		
		//Flatback
		int fb=0;
		//Green
		int g=0;
		//Hawksbill
		int hb=0;
		//KempsRidley
		int kr=0;
		//Leatherback
		int lb=0;
		//Loggerhead
		int lh=0;
		//OliveRidley
		int or=0;
		
		int w1=0;
		int w2=0;
		int w3=0;
		
		int l1=0;
		int l2=0;
		int l3=0;
		
		int f0=0;
		int f1=0;
		int f2=0;

		for(int i=0;i<records.size();i++) {
			Turtle t = records.get(i);
			
			if(t instanceof Flatback){
				fb++;
			}else if(t instanceof Green) {
				g++;
			}else if(t instanceof Hawksbill) {
				hb++;
			}else if(t instanceof KempsRidley) {
				kr++;
			}else if(t instanceof Leatherback) {
				lb++;
			}else if(t instanceof Loggerhead) {
				lh++;
			}else if(t instanceof OliveRidley) {
				or++;
			}
		
			
			switch (t.getFlippers()) {
				case 0:
					f0++;
					break;
				case 1:
					f1++;
					break;
				case 2:
					f2++;
					break;
			}
			
			if(t.getWeight() > 0 && t.getWeight() <= 5  ) {
				w1++;
			}else if(t.getWeight() > 5 && t.getWeight() <= 10  ) {
				w2++;
			}else if(t.getWeight() > 10  ) {
				w3++;
			}
			
			if(t.getLength() > 0 && t.getLength() <= 5  ) {
				l1++;
			}else if(t.getLength() > 5 && t.getLength() <= 10  ) {
				l2++;
			}else if(t.getLength() > 10  ) {
				l3++;
			}
			
			
		}
		System.out.println("Report: ");
		System.out.println("Species---------------------------------");
		System.out.println("Flatback: "+ fb);
		System.out.println("Green: "+ g);
		System.out.println("Hawksbill: "+ hb);
		System.out.println("KempsRidley: "+ kr);
		System.out.println("Leatherback: "+ lb);
		System.out.println("Loggerhead: "+ lh);
		System.out.println("OliveRidley: "+ or);
		System.out.println("----------------------------------------");
		
		System.out.println("Weights---------------------------------");
		System.out.println("Bewtween 0 and 5: "+ w1);
		System.out.println("Bewtween 5 and 10: "+ w2);
		System.out.println("More than 10: "+ w3);
		System.out.println("----------------------------------------");
		
		System.out.println("Length---------------------------------");
		System.out.println("Bewtween 0 and 5: "+ l1);
		System.out.println("Bewtween 5 and 10: "+ l2);
		System.out.println("More than 10: "+ l3);
		System.out.println("----------------------------------------");
		
		System.out.println("Flippers--------------------------------");
		System.out.println("No working flippers: "+ f0);
		System.out.println("1 working fliper: "+ f1);
		System.out.println("2 working flippers: "+ f2);
		System.out.println("----------------------------------------");
		
		System.out.println("Total records count: "+ getRecordsCount());
	}
	
	// Takes three values and operator and compares them 
	// operator
	// value
	// comparer one
	// comparer two
	private boolean compare(char operator, double value, double c1,double c2) {
		
		switch(operator) {
		case '=':
			return value == c1;
			
		case '!':
			return value != c1;
			
		case '>':
			return value >= c1;

		case '<':
			return value <= c1;
			
		case 'b':
			return value >= c1 && value <= c2 ;

		}
		
		return true;
		
	}

}
