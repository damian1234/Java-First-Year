import java.util.ArrayList;
import java.util.Scanner;


public class Simulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter the dimensions");
		int x = input.nextInt();
		int y = input.nextInt();
		input = new Scanner(System.in);
		Board board = new Board(x ,y);
		for(int i = 0; i < x; i++){
			System.out.println("enter the next line");
			String line = input.nextLine();
			board.initRow(line, i);
		}
		System.out.println("enter number of players");
		input = new Scanner(System.in);
		int num = input.nextInt();
		System.out.println(num);
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i = 0; i < num; i++){
			System.out.println("enter the next player");
			int id = input.nextInt();
			int xp = input.nextInt();
			int yp = input.nextInt();
			Player p  = new Player(id, xp, yp);
			players.add(p);
		}
		while(!board.found&&players.size() >0){
			for(int i = 0; (i < players.size())&&(!board.found); i++){
				Player p = players.get(i);
				if(!board.move(p)){
					players.remove(i);
					i-=1;
				}
			}
		}
		if(board.found){
			for(int i = 0; i < players.size(); i++){
				Player p = players.get(i);
				if(p.position[0] == board.gold[0] &&p.position[1] == board.gold[1]){
					System.out.print("the id is: " + p.id);
				}
			}
		}
	}
	
}
