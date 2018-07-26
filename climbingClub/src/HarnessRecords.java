import java.util.ArrayList;
/*
 * Design a HarnessRecords data type (Java class) whose values (Java objects) represent the collection of harnesses owned by climbing club, that is,
 *  the current characteristics of each harness owned by a climbing club.
 *  Your data type must store a list of Harness values (using either an array or an ArrayList) and must provide at least the following operations (Java instance methods):
(1) a constructor which constructs an empty HarnessRecords value, that is, a HarnessRecords value which does not contain any Harness values.
(2) a constructor which takes an input stream containing the number of harness contained in the stream follow by characteristics values for each harness.
 The constructor creates a HarnessRecords value containing a Harness value for each one in the input stream.
(3) isEmpty which determiners whether this collection of harness records is empty,  that is, does not contain any Harness values.
(4) addHarness which takes a Harness value to add to the list of currently recorded climbing club harnesses.
(5) findHarness which takes a harness make and model number, and which finds and returns the harness with given make and model number,
 assuming that such a harness exists in list of currently recorded climbing club harnesses, otherwise the operation returns the null value.
(6) checkHarness which takes an instructor name, a harness make and model number, and which updates the characteristics of this particular
 harness to reflect the fact that the given instructor has safety checked the harness, assuming the harness exists and is currently not on loan.
  If a harness is updated it is returned by the operation, otherwise the operation has no effect and      returns the null value.
(7) loanHarness which takes the name of a climbing club member and which tries to find an available harness for them to use.
 If a usable harness is found its characteristics are updated and the harness is returned, otherwise the operation has no effect and returns the null value.
(8) returnHarness which takes the make and model number of a harness, which should be currently on loan to a club member,
 and which finds and updates the  characteristics of that particular harness, assuming that such a harness exists. 
 If a harness is found and updated it is returned by the operation,  otherwise the operation has no effect and returns the null value.
(9) removeHarness which takes the make and model number of a harness, and which finds and removes the harness from the list
 of currently recorded climbing club harnesses, assuming that such a harness exists. If a harness is found and removed it is returned by the operation,
  otherwise the operation has no effect and returns the null value.
 */

public class HarnessRecords {
	private static ArrayList<Harness> Harnesses;
	public HarnessRecords(){
		Harnesses = new ArrayList<Harness>();
	}
	public HarnessRecords(In file){
		Harnesses = new ArrayList<Harness>();
		int numberOfHarnesses = Integer.parseInt(file.readLine());
		for(int i = 0;(i < numberOfHarnesses); i++){
			int modelNum = Integer.parseInt(file.readLine());
			String make = file.readLine();
			int timesUsed = Integer.parseInt(file.readLine());
			String instructor = file.readString();
			boolean loan = Boolean.parseBoolean(file.readLine());
			String member = null;
			Harness newHarness = new Harness(make, modelNum, timesUsed, instructor, loan, member);
			Harnesses.add(newHarness);
		}
	}
	public static boolean isEmpty(){
		if(Harnesses.size() == 0){
			return true;
		}
		return false;
	}
	public static boolean addHarness(Harness newHarness){
		boolean unique = true;
		for(int i = 0;(i< Harnesses.size()); i++){
			Harness thisOne = Harnesses.get(i);
			if(thisOne.Model == newHarness.Model){
				unique = false;
			}
			if(unique){
				Harnesses.add(newHarness);
				return true;
			}
		}
		return false;

	}
	public static Harness findHarness(String make, int modelNumber){
		boolean found = false;
		int i = 0;
		while(!found){
			Harness thisHarness = (Harness) Harnesses.get(i);
			if((thisHarness.Model == modelNumber)&&(thisHarness.Make.contains(make))){
				found = true;
				return thisHarness;
			}
			i++;
		}
		return null;
	}
	public static void loanHarness(Harness thisOne, String member) {
		thisOne.loanHarness(member);
	}
	public static Harness checkHarness(String instructor, int model, String make){
		Harness thisOne = findHarness(make, model);
		thisOne.checkHarness(instructor);
		return null;
	}
	public static void returnHarness(int model, String make){
		boolean found = false;
		int i = 0;
		while(!found){
			Harness thisHarness = (Harness) Harnesses.get(i);
			if((thisHarness.Model == model)&&(thisHarness.Make == make)){
				thisHarness.returnHarness();
			}
		}
	}
	public static void removeHarness(int model, String make){
		int i = 0;
		boolean found = false;
		while((i < Harnesses.size())&&(!found)){
			Harness thisOne = (Harness) Harnesses.get(i);
			if((thisOne.Model == model)&&(thisOne.Make==make)){
				Harnesses.remove(i);
				found = true;
			}
		}
	}
}
