
public class Board {
	public Space[][] board;
	public int xBound;
	public int yBound;
	public int[] gold;
	public boolean found = false;


	public class Space{
		public int displacement[] = new int[2];
		public int type;
		//0 = space, 1 = trap, 2 = gold
		public Space(){
		}
		public Space(int x, int y, int t){
			displacement[0] = x;
			displacement[1] = y;
			type = t;
		}
	}
	public Board(int x, int y){
		board = new Space[x][y];
		xBound = x;
		yBound = y;
		gold = new int[2];
	}
	public void initRow(String input, int index){
		String[] line = input.split(" ");
		int k = 0;
		for(int i = 0; i < yBound; i++,k++){
			switch(line[k]){
			case "D":
				int x = Integer.parseInt(line[k+1]);
				int y = Integer.parseInt(line[k+2]);
				k+=2;
				board[index][i] = new Space(x,y, 0);
				break;
			case "G":
				board[index][i] = new Space(0,0,2);
				gold[0] = index;
				gold[1] = i;
				break;
			case "T":
				board[index][i] = new Space(0,0,1);
			}
		}
	}
	public boolean move(Player p){
		if(p.position[0] == gold[0]&&p.position[1] == gold[1]){
			found = true;
			return true;
		}
		Space s = board[p.position[0]][p.position[1]];
		int x = p.position[0] + s.displacement[0];
		int y = p.position[1] + s.displacement[1];
		x = x%xBound;
		y = y%yBound;
		if(x < 0){
			x = xBound + x;
		}
		if(y < 0){
			y = yBound + y;
		}
		p.position[0] = x;
		p.position[1] = y;
		if(p.position[0] == gold[0]&&p.position[1] == gold[1]){
			found = true;
			return true;
		}
		if(board[p.position[0]][p.position[1]].type == 1){
			p.alive = false;
			return false;
		}
		return true;
	}

}
