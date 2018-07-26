import java.util.*;
import javax.swing.JOptionPane;
public class Game {
	public final static int SHIPS = 1;
	public static void main(String[] args) {
		SetUpBoard();
		Board myBoard = new Board();
		Board enemyBoard = new Board();
		fillBoard(myBoard);
		fillBoard(enemyBoard);
		int i = 1;
		while((!myBoard.endGame())&&(!enemyBoard.endGame())){
			if(i%2 ==1){
				takeShot(myBoard, enemyBoard);
			}
			else{
				takeShot(enemyBoard, myBoard);
			}
		}
		if(enemyBoard.endGame()){
			JOptionPane.showMessageDialog(null, "you won!");
		}
		else{
			JOptionPane.showMessageDialog(null, "you lost!");
		}
	}
	public static void fillBoard(Board board){
		for(int i = 0;i<SHIPS; i++){
			int answer = JOptionPane.showConfirmDialog(null, "Will the be place horizontally?");
			boolean horizon = true;
			if(answer == 1){
				horizon = false;
			}
			String input = JOptionPane.showInputDialog("please enter your y, x coordinates\n and size seperated by a comma");
			Scanner scan = new Scanner(input);
			scan.useDelimiter(",");
			int[] coordinates = new int[2];
			coordinates[0] = scan.nextInt()-1;
			coordinates[1] = scan.nextInt()-1;
			int size = scan.nextInt();
			if(size > 5){
				size = 5;
			}
			Ship ship = new Ship(size, horizon);
			if(board.checkSpaces(ship, coordinates)){
				board.placeShip(ship, coordinates);
			}
			else{
				JOptionPane.showMessageDialog(null, "that space has been\n filled by another ship");
				i-=1;
			}
		}
	}
	public static void takeShot(Board attacker, Board target){
		String input = JOptionPane.showInputDialog("please enter your y, x coordinates of where you\n want to shoot seperated by a comma");
		Scanner scan = new Scanner(input);
		scan.useDelimiter(",");
		int[] coordinates = new int[2];
		coordinates[0] = scan.nextInt()-1;
		coordinates[1] = scan.nextInt()-1;
		attacker.takeShot(coordinates);
		if(target.checkHit(attacker)){
			target.hit(attacker);
			JOptionPane.showMessageDialog(null, "hit ship");
			if(target.sinkShip()){
				JOptionPane.showMessageDialog(null, "ship sunk");
			}
		}
	}
	public static void SetUpBoard(){
		StdDraw.setCanvasSize(500, 500);
		StdDraw.setScale(0, 500);
		StdDraw.picture(100, 100, "/home/damian/Pictures/boat.GIF");
	}
}
