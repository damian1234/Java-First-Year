import java.util.Random;

/*Design a Harness data type (Java class) whose values (Java objects) represent climbing club harnesses. 
 * Your data type must store the above harness characteristics and must provide at least the following operations (Java instance methods):
(1) a constructor which takes the make, the model number, the number of times the harness was used,
 the name of the climbing instructor who last checked the safety of the harness, whether the harness is on loan, and if the harness is on loan the name of club member who has
  it borrowed. The constructor creates a Harness value with the given characteristics.
(2) a constructor which takes the make, the model number, and the name of the climbing instructor who 
checked the safety of the harness, and which creates a Harness value with the given characteristics and the other characteristics to sensible initial values.  
(3) checkHarness which takes the name of a climbing instructor and which resets the number of times used value 
of this harness and records the name of the safety checking instructor, assuming that this harness is not currently on out on loan, otherwise this operation has no effect.
(4) isHarnessOnLoan which determines whether this harness is currently loaned out to a climbing club member.
(5) canHarnessBeLoaned which determines whether this harness can be loaned out to a climbing club member.
(6) loanHarness which takes the name of a climbing club member and which loans this harness to the club member,
 assuming that this harness can be loaned, otherwise the operation has no effect.  
(7) returnHarness which updates this harness characteristics to record the fact that the harness has been returned by a climbing club member, 
assuming that the harness was on loan. If the harness was not on loan the operation has no effect.
(8) toString which return a String value description of this harness.
 */

public class Harness {

	int Used;
	int Model;
	String Make;
	String InstructorChk;
	String Member;
	boolean loaned;


	public Harness(String make, int modelNum, int timesUsed, String instructor, boolean loan, String member ){
		this.Used = timesUsed;
		this.Make = make;
		this.Model = modelNum;
		this.InstructorChk = instructor;
		this.loaned = loan;
		if(this.loaned){
			this.Member = member;
		}
	}

	public Harness(String make, int modelNum, String name){
		this.Make = make;
		this.Model = modelNum;
		this.InstructorChk = name;
		this.Used = 0;
		this.loaned = false;
	}

	public void checkHarness(String instructor){
		if(!this.loaned){
			this.Used = 0;
			this.InstructorChk = instructor;
		}		
	}

	public boolean isHarnessOnLoan(){
		boolean loan = false;
		if(this.loaned){
			loan = true;
		}
		return loan;
	}

	public boolean canHarnessBeLoaned(){
		boolean loan = false;
		if(!this.loaned){
			loan = true;
		}
		return loan;
	}

	public void loanHarness(String member){
		if(!this.loaned){
			this.loaned = true;
			this.Member = member;
		}
	}

	public void returnHarness(){
		if(this.loaned){
			this.Used++;
			this.loaned = false;
		}
	}
	public String toString(){
		String make, instructor, member, description;
		int  timesUsed, model;
		boolean loan;
		loan = this.loaned;
	 	make = this.Make;
		instructor = this.InstructorChk;
		timesUsed = this.Used;
		model = this.Model;
		member = this.Member;
		if(loan){
			description = "The harness is on loan, the member who has it is " + member + ", it has been used " + timesUsed + " times. The instructor who did the last safety check was " + instructor + ". \n" +
					"The make is " + make + " and the model number is" + model;
		}
		else{
			description = "The harness is not on loan, it has been used " + timesUsed + " times. The instructor who did the last safety check was " + instructor + ". \n" +
					"The make is " + make + " and the model number is" + model; 
		}
		return description;
	}	
}
