import java.util.Random;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class Main {

	/*
Write a Java program which will allow a user (the climbing club manager) to keep track of 
and update the current characteristics of each climbing club harness through a user interface (text based or otherwise). 
The user interface must at least allow the climbing club manager to:
(1) add a record for a newly purchased harness,
(2) remove a climbing harness from the club,
(3) record the fact that a club instructor has checked the safety of a harness,
(4) loan a harness to a club member if there is an availabe harness,  
5) return a harness which is no longer in use by a club member.

	 */
	public static void main(String[] args) {
		HarnessRecords recordsOfHarness = new HarnessRecords();
		Random gen = new Random();
		JOptionPane.showMessageDialog(null, "Welcome to the Climbing Club");
		boolean managing = true;
		while(managing){
			String[] Options  = {"Remove Harness", "Add Harness", "Loan Harness", "Return Harness", "Check Harness"};
			int input = JOptionPane.showOptionDialog(null, "What would you like to do Mr Owner ", "Records", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, Options, Options[0]);
			String answer = null;
			switch(input){
			case 0:
				answer = JOptionPane.showInputDialog(null, " To Remove a Harness enter the make and model number seperated by a comma");
				Scanner scan = new Scanner(answer);
				scan.useDelimiter(",");
				String make = scan.next();
				int modelNumber = scan.nextInt();
				Harness thisOne = recordsOfHarness.findHarness(make, modelNumber);
				if(thisOne != null){
					HarnessRecords.removeHarness(modelNumber, make);
					JOptionPane.showMessageDialog(null, "The Harness was removed");
				}
				break;
			case 1:
				answer = JOptionPane.showInputDialog(null, "  To Add a Harness enter the make , model number and name seperated by a comma");
				Scanner scan2 = new Scanner(answer);
				scan2.useDelimiter(",");
				make = scan2.next();
				modelNumber = scan2.nextInt();
				String name = scan2.next();
				thisOne = new Harness(make, modelNumber, name);
						if(thisOne != null){
							if(HarnessRecords.addHarness(thisOne)){
								JOptionPane.showMessageDialog(null, "");
							}
							else{
								JOptionPane.showMessageDialog(null, "");
							}
						}
				break;
			case 2:
				answer = JOptionPane.showInputDialog(null, " please enter");
				Scanner scan3 = new Scanner(answer);
				scan3.useDelimiter(",");
				make = scan3.next();
				modelNumber = scan3.nextInt();
				String member = scan3.next();
				thisOne = HarnessRecords.findHarness(make, modelNumber);
				if(thisOne == null){
					JOptionPane.showMessageDialog(null, "");
				}
				else{
					HarnessRecords.loanHarness(thisOne, member);
				}
				break;
			case 3:
				answer = JOptionPane.showInputDialog(null, " please enter");
				Scanner scan4 = new Scanner(answer);
				scan4.useDelimiter(",");
				make = scan4.next();
				modelNumber = scan4.nextInt();
				thisOne = HarnessRecords.findHarness(make, modelNumber);
				if(thisOne == null){
					JOptionPane.showMessageDialog(null, "");
				}
				else{
					HarnessRecords.returnHarness(modelNumber, make);
				}
				break;
			case 4:
				answer = JOptionPane.showInputDialog(null, " please enter");
				Scanner scan5 = new Scanner(answer);
				scan5.useDelimiter(",");
				make = scan5.next();
				modelNumber = scan5.nextInt();
				thisOne = HarnessRecords.findHarness(make, modelNumber);
				if(thisOne == null){
					JOptionPane.showMessageDialog(null, "");
				}
				else{
					HarnessRecords.returnHarness(modelNumber, make);
				}
				break;

			}
		}
	}
}
