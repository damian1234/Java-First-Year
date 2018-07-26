
public class Player {
	public int id;
	public int[] position = new int[2];
	public boolean alive;
	public Player(int ident, int xPos, int yPos){
		id = ident;
		position[0] = xPos;
		position[1] = yPos;
		alive = true;
	}
}
