import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class highScores {

	/**Write a program to maintain a list of the high scores obtained in a game.
	 *   The program should first ask the user how many scores they want to maintain and then 
	 *   repeatedly accept new scores from the user and should add the score to the list of high scores 
	 *   (in the appropriate position) if it is higher than any of the existing high scores.  
	 *   You must include the following functions:-initialiseHighScores () which sets all high scores to zero.
	 *   -printHighScores() which prints the high scores in the format: “The high scores are 345, 300, 234”, 
	 *   for all exisiting high scores in the list (remember that sometimes it won’t be full).
	 *   -higherThan() which takes the high scores and a new score and returns whether the passed
	 *   score is higher than any of those in the high score list.
	 *   -insertScore() which takes the current high score list  and a new score and updates it by inserting
	 *    the new score at the appropriate position in the list
	 */
	public static void main(String[] args) {
		System.out.println(pal("clinteastwood","oldwestaction"));
	}
	public static boolean pal(String x, String z){
		char[] p = x.toCharArray();
		char[] q = z.toCharArray();
		if(p.length == q.length){
			Arrays.sort(p);
			Arrays.sort(q);
			for(int i =0; i<p.length;i++){
				//System.out.print(p[i]);
				if(p[i]!=q[i]){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	// TODO Auto-generated method stub
	//		System.out.print(" how long do you want your array");
	//		Scanner keyScanner = new Scanner(System.in);
	//		int numOfScores = keyScanner.nextInt();
	//		int[] highScores = new int[numOfScores];
	//		int index = 0;
	//		boolean finished = false;
	//		initialiseHighScores(highScores);
	//		System.out.print(" enter scores ");
	//		while(!finished){
	//			int newScore;
	//			if (keyScanner.hasNextInt()){
	//				newScore = keyScanner.nextInt();
	//			}
	//			else {
	//				finished = true;
	//				newScore = -1;
	//			}
	//			insertScore( newScore, highScores);
	//		}
	//		printHighScores(highScores);
	//		keyScanner.close();
	//	}
	//	public static void initialiseHighScores(int[] highScores){
	//		int index = 0;
	//		for( index = 0; (index < highScores.length ); index++ ){
	//			highScores[index] = 0;
	//		}
	//	}
	//	public static int[] printHighScores( int[] highScores){
	//		for( int index = highScores.length-1;( index >= 0  ); index-- ){
	//			if (index > (highScores.length)-2){
	//				System.out.print("the high scores are " + highScores[index] + " ");
	//			}
	//			else{
	//				System.out.print( highScores[index] + ", ");
	//			}
	//		}return highScores;
	//	}
	//	public static boolean higherThan(int newScore, int[] highScores){
	//		int count;
	//		for(count = 0; (count < highScores.length); count++){
	//			if(newScore > highScores[count]){
	//				return true;
	//			}
	//		}
	//		return false;
	//	}
	//	public static int[] insertScore( int newScore, int[] highScores){
	//		Arrays.sort(highScores);
	//		System.out.println();
	//		if (higherThan(newScore, highScores)){
	//			highScores[0] = newScore;
	//		}
	//		Arrays.sort(highScores);
	//		return highScores;
	//	}
}
