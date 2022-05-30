import java.util.Arrays;
import java.util.Scanner;

import classes.Store;
import classes.Turtle;
import species.Flatback;
import species.Green;
import species.Hawksbill;
import species.KempsRidley;
import species.Leatherback;
import species.Loggerhead;
import species.OliveRidley;


public class Main {

	public static void main(String[] args) {
		
		
		Scanner reader = new Scanner(System.in);
		
		Store s = new Store();
		

		boolean exit = false;
		// Main application loop
		do {
		   
			String menu = 
					"======================\n" +
					"|  Turtle Catalogue  |\n" + 
					"======================\n" +
					"| Menu               |\n" + 
					"|    1: Add Record   |\n" + 
					"|    2: View Record  |\n" +
					"|    3: Edit Record  |\n" + 
					"|    4: Delete Record|\n" + 
					"|--------------------|\n" +
					"|    s: Search Record|\n" + 
					"|    r: View Report  |\n" +
					"|--------------------|\n" +
					"|    e: Exit         |\n" +
					"======================\n" +
					"      "+s.getRecordsCount()+" Record\\s\n" +
					"======================\n" ;
			System.out.println(menu);
			System.out.println("Select Option: ");
			
			String option = reader.nextLine();

			switch (option) {
			case "1":
				addRecord(s);
				break;

			case "2":
				viewRecord(s);
				break;
				
			case "3":
				editRecord(s);
				break;
				
			case "4":
				deleteRecord(s);
				break;
				
				
			case "s":
			case "S":
				searchRecord(s);
				break;
				
			case "r":
			case "R":
				generateReport(s);
				break;
				
			case "e":
			case "E":
				exit=true;
				System.out.println("Bye!!");
				break;

			default:
				System.out.println("Invalid option selected");
				break;
			}

		} while (!exit);

		reader.close();

	}
	
	private static void generateReport(Store s) {

		s.getReport();
		
	}

	private static void searchRecord(Store s) {
		
		Scanner reader = new Scanner(System.in);		
		boolean done = false;
		
		String species = "";
		
		double weightLess = -1;
		double weightMore = -1;
		char weightOperator = '=';
		
		double lengthLess = -1;
		double lengthMore = -1;
		char lengthOperator = '=';
		
		int flippersLess = -1;
		int flippersMore = -1;
		char flippersOperator = '=';
		
		String location = "";
		
		// Enter Species
		System.out.println("Species: ");
		System.out.println("Enter full name or part of it, if you don't want to search using Species just hit enter");

		String speciesIn = reader.nextLine();
		species = speciesIn;
		
		
		System.out.println("Weight: ");
		// Enter Weight Operator
		weightOperator = getOperator();
		
		if(weightOperator != 'n') {

			// Enter Weight
			do {
				done=true;
					try {
						System.out.println("Weight: ");
	
						Double weightIn = reader.nextDouble();
						if(weightIn <= 0) {
							System.out.println("please enter a positive number");
							done=false;
						}else {
							weightLess  = weightMore = weightIn;
						}
					}catch(Exception e) {
						reader.next();
						System.out.println("please enter a number and make sure it's positive ");
						done=false;
					}
				
			} while (!done);
			
			if(weightOperator == 'b') {
				// Enter Second Weight
				do {
					done=true;
						try {
							System.out.println("Second Weight: ");
	
							Double weightIn = reader.nextDouble();
							if(weightIn <= 0) {
								System.out.println("please enter a positive number");
								done=false;
							}else {
								weightMore = weightIn;
							}
						}catch(Exception e) {
							reader.next();
							System.out.println("please enter a number and make sure it's positive ");
							done=false;
						}
					
				} while (!done);
			}
		}
		
		
		System.out.println("Length: ");
		// Enter Length Operator
		lengthOperator = getOperator();
		
		if(lengthOperator != 'n') {
		
			// Enter Length
			do {
				done=true;
				
				try {
					System.out.println("Length: ");

					Double lengthIn = reader.nextDouble();
					if(lengthIn <= 0) {
						System.out.println("please enter a positive number");
						done=false;
					}else {
						lengthLess  = lengthMore = lengthIn;
					}
				}catch(Exception e) {
					reader.next();
					System.out.println("please enter a number and make sure it's positive ");
					done=false;
				}
				
			} while (!done);
			
			if(lengthOperator == 'b') {
				// Enter Second Length
				do {
					done=true;
					try {
						System.out.println("Second Length: ");

						Double lengthIn = reader.nextDouble();
						if(lengthIn <= 0) {
							System.out.println("please enter a positive number");
							done=false;
						}else {
							lengthMore = lengthIn;
						}
					}catch(Exception e) {
						reader.next();
						System.out.println("please enter a number and make sure it's positive ");
						done=false;
					}
					
				} while (!done);
			}
		}
		
		
		System.out.println("Flippers: ");
		// Enter Flippers Operator
		flippersOperator = getOperator();
		
		if(flippersOperator != 'n') {
			// Enter Flippers
			do {
				done=true;
				try {
					System.out.println("Working flippers (0,1,2): ");
					int flippersIn = reader.nextInt();
					if( flippersIn != 0 && flippersIn != 1 && flippersIn != 2 ) {
						System.out.println("please insert one of those numbers (0,1,2)");
						done=false;
					}else {
						flippersLess = flippersMore = flippersIn;
					}
				}catch(Exception e) {
					reader.next();
					System.out.println("please insert one of those numbers (0,1,2)");
					done=false;
				}
				
			} while (!done);
			
			if(flippersOperator == 'b') {
				// Enter Second Flippers
				do {
					done=true;
					try {
						System.out.println("Second Working flippers (0,1,2): ");
						int flippersIn = reader.nextInt();
						if( flippersIn != 0 && flippersIn != 1 && flippersIn != 2 ) {
							System.out.println("please insert one of those numbers (0,1,2)");
							done=false;
						}else {
							flippersMore = flippersIn;
						}
					}catch(Exception e) {
						reader.next();
						System.out.println("please insert one of those numbers (0,1,2)");
						done=false;
					}
					
				} while (!done);
			}
		
		}
		
		// Enter Location
		System.out.println("Location: ");
		System.out.println("Enter full location or part of it, if you don't want to search using location enter -1");

		String locationIn = reader.next();
		location = locationIn;
		
		s.search(species, weightOperator, weightLess, weightMore,lengthOperator,lengthLess,lengthMore,flippersOperator,flippersLess,flippersMore,location);
	
		
	}
	
	private static void addRecord(Store s) {
		
		Scanner reader = new Scanner(System.in);		
		boolean done = false;
		Turtle t= null;
		
		// Select Species
		do {
			String enterASpecies = 
					"======================\n" +
					"|   Turtle Species   |\n" + 
					"======================\n" +
					"|    1: Flatback     |\n" + 
					"|    2: Green        |\n" +
					"|    3: Hawksbill    |\n" + 
					"|    4: Kemps Ridley |\n" + 
					"|    5: Leatherback  |\n" +
					"|    6: Loggerhead   |\n" +
					"|    7: Olive Ridley |\n" +
					"======================\n" +
					"|  Select a species  |\n" +
					"======================\n" ;
			System.out.println(enterASpecies);
			System.out.println("Species: ");
			String species = reader.nextLine();
			
			done = true;
			
			switch (species) {
			case "1":
				t = new Flatback();
				break;

			case "2":
				t = new Green();
				break;
				
			case "3":
				t = new Hawksbill();
				break;
				
			case "4":
				t = new KempsRidley();
				break;
				
			case "5":
				t = new Leatherback();
				break;
				
			case "6":
				t = new Loggerhead();
				break;
				
			case "7":
				t = new OliveRidley();
				break;

			default:
				System.out.println("What species is that !? please select one of the options");
				done = false;
				break;
			}
				
		} while (!done);
			
		// Enter Weight
		do {
			done=true;
			if(t.getWeight() == -1) {
				try {
					System.out.println("Weight: ");
					
					Double weight = reader.nextDouble();
					if(weight <= 0) {
						System.out.println("please enter a positive number ");
						done=false;
					}else {
						t.setWeight(weight);
					}
				}catch(Exception e) {
					reader.next();
					System.out.println("please enter a number and make sure it's positive ");
					done=false;
				}
			}
		} while (!done);
		
		// Enter Length
		do {
			done=true;
			if(t.getLength() == -1) {
				try {
					System.out.println("Length: ");
					Double length = reader.nextDouble();
					if(length <= 0) {
						System.out.println("please enter a positive number ");
						done=false;
					}else {
						t.setLength(length);
					}
				}catch(Exception e) {
					reader.next();
					System.out.println("please enter a number and make sure it's positive ");
					done=false;
				}
			}
		} while (!done);
		
		// Enter Flippers
		do {
			done=true;
			if(t.getFlippers() == -1) {
				try {
					System.out.println("Working flippers (0,1,2): ");
					int flippers = reader.nextInt();
					if( flippers != 0 && flippers != 1 && flippers != 2 ) {
						System.out.println("please insert one of those numbers (0,1,2)");
						done=false;
					}else {
						t.setFlippers(flippers);
					}
				}catch(Exception e) {
					reader.next();
					System.out.println("please insert one of those numbers (0,1,2)");
					done=false;
				}
			}
		} while (!done);
		
		// Enter Location
		do {
			done=true;
			if(t.getLocation() == "") {
				System.out.println("Location: ");
				String location = reader.next();
				if( location.trim() == "" ) {
					System.out.println("please enter a location");
					done=false;
				}else {
					t.setLocation(location);
				}
			}
		} while (!done);

//		reader.close();
		
		s.addRecord(t);
	}
	
	private static void viewRecord(Store s) {
		Scanner reader = new Scanner(System.in);
		try {
			System.out.println("Record ID: ");
			int id = reader.nextInt();
			s.viewRecord(id);
		}catch(Exception e) {
			reader.next();
			System.out.println("Invalid ID");
		}
	}
	
	private static void deleteRecord(Store s) {
		Scanner reader = new Scanner(System.in);
		try {
			System.out.println("Record ID: ");
			int id = reader.nextInt();
			s.removeRecord(id);
		}catch(Exception e) {
			reader.next();
			System.out.println("Invalid ID");
		}
	}
	
private static void editRecord(Store s) {
		
		Scanner reader = new Scanner(System.in);		
		boolean done = false;
		
		// species is doesn't matter here
		Turtle t= new Flatback();
		
		int id = -1;
		
		try {
			System.out.println("Record ID: ");
			id = reader.nextInt();

			if(!s.checkRecordExists(id)) {
				return;
			}
		}catch(Exception e) {
			reader.next();
			System.out.println("Invalid ID");
			return;
		}
	
			
		// Enter Weight
		do {
			done=true;
			
				try {
					System.out.println("Weight: ");
					System.out.println("if you don't want to update the old value enter -1");

					Double weight = reader.nextDouble();
					if(weight <= 0 && weight != -1) {
						System.out.println("please enter a positive number or -1 ");
						done=false;
					}else {
						t.setWeight(weight);
					}
				}catch(Exception e) {
					reader.next();
					System.out.println("please enter a number and make sure it's positive ");
					done=false;
				}
			
		} while (!done);
		
		// Enter Length
		do {
			done=true;
				try {
					System.out.println("Length: ");
					System.out.println("if you don't want to update the old value enter -1");

					Double length = reader.nextDouble();
					if(length <= 0 && length != -1) {
						System.out.println("please enter a positive number or -1 ");
						done=false;
					}else {
						t.setLength(length);
					}
				}catch(Exception e) {
					reader.next();
					System.out.println("please enter a number and make sure it's positive ");
					done=false;
				}
			
		} while (!done);
		
		// Enter Flippers
		do {
			done=true;
				try {
					System.out.println("Working flippers (0,1,2): ");
					System.out.println("if you don't want to update the old value enter -1");

					int flippers = reader.nextInt();
					if( flippers != 0 && flippers != 1 && flippers != 2 && flippers !=-1 ) {
						System.out.println("please insert one of those numbers (0,1,2) or -1");
						done=false;
					}else {
						t.setFlippers(flippers);
					}
				}catch(Exception e) {
					reader.next();
					System.out.println("please insert one of those numbers (0,1,2)");
					done=false;
				}
			
		} while (!done);
		
		// Enter Location
		System.out.println("Location: ");
		System.out.println("if you don't want to update the old value enter -1");

		String location = reader.next();
		t.setLocation(location);
		
		
		s.editRecord(id, t);
	}

private static char getOperator() {
	
	String[] operators = {"=","!",">","<","b","n"};
	Scanner reader = new Scanner(System.in);
	char operator = 0;
	boolean done=true;
	
	do {
		done=true;	
		System.out.println("available search operators: ");
		System.out.println("= : value equals the entered");
		System.out.println("! : value not equals the entered");
		System.out.println("> : value larger or equals the entered");
		System.out.println("< : value less or equals the entered");
		System.out.println("b : value between two values entered");	
		System.out.println("n : don't use in search");

		System.out.println("Operator: ");

		String operatorIn = reader.next();
		if(!Arrays.asList(operators).contains(operatorIn)) {
			System.out.println("please enter one of the operators");
			done=false;
		}else {
			operator = operatorIn.charAt(0);
		}	
		
	} while (!done);
	
	return operator;
}


}
