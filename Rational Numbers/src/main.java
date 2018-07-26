import java.util.Scanner;
import javax.swing.JOptionPane;
/*
 * 
Write a Java data type (Java class) Rational whose values (Java object) represent rational numbers. 
Your data type must store the numerator and denominator of the rational number and must provide the following operations (Java instance methods):
(1) constructor operation which takes two integers (a numerator and a denominator),
w and which constructs a rational number value with the given numerator and denominator.
(2) constructor operation which takes an integer (a numerator) and which constructs a rational number value representing the given integer.  
(3) add operation which takes a rational number value and which returns a rational  number value which is the sum of this rational number and the given rational  number.
(4) subtract operation which takes a rational number value and which returns a rational number value which is this rational number less the given rational number.
(5) multiply operation which takes a rational number value and which returns a  rational number value which is the product of this rational number and the given rational number.
(6) divide operation which takes a rational number value and which returns a rational number value which is the quotient of this rational number by the given rational number.
(7) equals operation which determines whether this rational number value is equal to a given rational number value, for example, 1/3 equals 2/6, however 2/3 does not  equal 5/10.
(8) isLessThan operation which determines whether this rational number value is less than a given rational number value, for example, 50/100 is less than 2/3, however 1/2 is not less than 3/9.
(9) simplify operation which returns a rational number value which is this rational number value reduced to its lowest terms and expressed with a positive denominator, for example, 6/8 simplifies to 3/4 and 50/-100 simplifies to -1/2 and -6/-9 simplifies to 2/3. [Hint: you will need to use and write a greatest common divisor (GCD) function.]
(10) toString operation which returns a String value representation of this rational number value.

Write a Java program (a test client) which will test your rational number data type, by allowing a user to enter fraction values which will be added, subtracted, multiplied, divided, compared (equals and less than) and simplified by your program. Your program should print the results of these computations to the standard output. 
 */
public class main {


	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog(" Enter a rational number ");
		Scanner scan = new Scanner(input);
		scan.useDelimiter("/");
		int numerator = scan.nextInt();
		int denominator = 1;
		if(scan.hasNextInt()){
			denominator = scan.nextInt();
		}
		int answer =-2;
		RationalNumber myNum = new RationalNumber(numerator, denominator);
		while(answer != -1){
			String[] options = {"Add", "Subtract", "Multiply", "Divide", "Equals", "LessThen", "Simplify"};
			answer = JOptionPane.showOptionDialog(null, "What would you like to do Mr grader ", "Records", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			switch(answer){
			case -1:
				break;
			case 0:
				input = JOptionPane.showInputDialog("Enter a number you would like to add");
				scan = new Scanner(input);
				scan.useDelimiter("/");
				int numerator2 = scan.nextInt();
				int denominator2 = 1;
				if(scan.hasNextInt()){
					denominator2 = scan.nextInt();
				}
				RationalNumber newNum = new RationalNumber(numerator2, denominator2);
				myNum = myNum.add(newNum);
				JOptionPane.showMessageDialog(null, "the answer is " + myNum);
				break;
			case 1:
				input = JOptionPane.showInputDialog("Enter a number you would like to subtract");
				scan = new Scanner(input);
				scan.useDelimiter("/");
				numerator2 = scan.nextInt();
				denominator2 = 1;
				if(scan.hasNextInt()){
					denominator2 = scan.nextInt();
				}
				newNum = new RationalNumber(numerator2, denominator2);
				System.out.print(myNum.subtract(newNum).toString());
				myNum = myNum.subtract(newNum);
				JOptionPane.showMessageDialog(null, "the answer is " + myNum);
				break;
			case 2:
				input = JOptionPane.showInputDialog("Enter a number you would like to multiply by");
				scan = new Scanner(input);
				scan.useDelimiter("/");
				numerator2 = scan.nextInt();
				denominator2 = 1;
				if(scan.hasNextInt()){
					denominator2 = scan.nextInt();
				}
				newNum = new RationalNumber(numerator2, denominator2);
				myNum = myNum.multiply(newNum);
				JOptionPane.showMessageDialog(null, "the answer is " + myNum);
				break;
			case 3:
				input = JOptionPane.showInputDialog("Enter a number you would like to divide by");
				scan = new Scanner(input);
				scan.useDelimiter("/");
				numerator2 = scan.nextInt();
				denominator2 = 1;
				if(scan.hasNextInt()){
					denominator2 = scan.nextInt();
				}
				newNum = new RationalNumber(numerator2, denominator2);
				myNum = myNum.divide(newNum);
				JOptionPane.showMessageDialog(null, "the answer is " + myNum);
				break;
			case 4:
				input = JOptionPane.showInputDialog(" what Rational number would you like to compare to " + myNum);
				scan = new Scanner(input);
				scan.useDelimiter("/");
				numerator2 = scan.nextInt();
				denominator2 = 1;
				if(scan.hasNextInt()){
					denominator2 = scan.nextInt();
				}
				newNum = new RationalNumber(numerator2, denominator2);
				if(myNum.equals(newNum)){
					JOptionPane.showMessageDialog(null, myNum + " and " + newNum + " are equal " );
				}
				else{
					JOptionPane.showMessageDialog(null,  myNum + " and " + newNum + " are not equal ");
				}
				break;
			case 5:
				input = JOptionPane.showInputDialog("Enter a number you would like to compare " + myNum + " with ");
				scan = new Scanner(input);
				scan.useDelimiter("/");
				numerator2 = scan.nextInt();
				denominator2 = 1;
				if(scan.hasNextInt()){
					denominator2 = scan.nextInt();
				}
				newNum = new RationalNumber(numerator2, denominator2);
				if(myNum.lessThen(newNum)){
					JOptionPane.showMessageDialog(null, myNum.toString() + " is less then " + newNum.toString());
				}
				else{
					JOptionPane.showMessageDialog(null,  newNum.toString() + " is less then " + myNum.toString());
				}
				break;
			case 6:
				newNum = myNum;
				myNum = myNum.simplify();
				JOptionPane.showMessageDialog(null, newNum +" simplified is " + myNum);
				break;
			}
			
		}
		
	}

}
