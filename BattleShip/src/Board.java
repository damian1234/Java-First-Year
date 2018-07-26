import java.util.ArrayList;
public class Board {
	final int DIM = 20;
	private int[] lastShot = new int[2];
	private ArrayList<Ship> shipList = new ArrayList<Ship>();
	private boolean[][] board = new boolean[DIM][DIM];
	public Board(){
		for(int i = 0;i <20; i++){
			for(int j = 0;j<20; j++){
				board[i][j] = false;
			}
		}
	}
	public boolean checkSpaces(Ship ship, int[] coordinates){
		if(!ship.horizontal){
			if((coordinates[0]+(ship.hits.length)) <= DIM){
				for(int i = 0; i <ship.hits.length;i++){
					if(this.board[coordinates[0]+i][coordinates[1]]){
						return false;
					}
				}
			}
			else{
				return false;
			}
		}
		else{
			if((coordinates[1]+(ship.hits.length)) <= DIM){
				for(int i = 0; i <ship.hits.length;i++){
					if(this.board[coordinates[0]][coordinates[1]+i]){
						return false;
					}
				}
			}
			else{
				return false;
			}
		}
		return true;
	}
	public void placeShip(Ship ship, int[] coordinates){
		shipList.add(ship);
		if(!ship.horizontal){
			if((coordinates[0]+(ship.hits.length)) <= DIM){		//ship doesn't exceed the board size
				for(int j = 0; j<ship.hits.length; j++){
					board[coordinates[0]+j][coordinates[1]] = true;
				}
			}
		}
		else{
			if((coordinates[1]+(ship.hits.length)) <= DIM){		//ship doesn't exceed the board size
				for(int j = 0; j<ship.hits.length; j++){
					board[coordinates[0]][coordinates[1]+j] = true;
				}

			}
		}
	}
	public void takeShot(int[] coordinates){
		lastShot[0] = coordinates[0];
		lastShot[1] = coordinates[1];
	}
	public void removeShip(Ship ship){
		if(shipList.contains(ship)){
			shipList.remove(ship);
		}
	}
	public boolean checkHit(Board attacker){
		for(int i = 0; i < shipList.size(); i++){
			Ship target = this.shipList.get(i);
			if(attacker.lastShot[0] == target.coordinates[0]){
				for(int j = 0; j < target.hits.length;j++){
					if(attacker.lastShot[1] == target.coordinates[1]+j){
						return true;
					}
				}
			}
			else if(attacker.lastShot[1] == target.coordinates[1]){
				for(int j = 0; j < target.hits.length;j++){
					if(attacker.lastShot[0] == target.coordinates[0]+j){
						return true;
					}
				}
			}
		}
		return false;
	}
	public void hit(Board attacker){
		for(int i = 0; i < shipList.size(); i++){
			Ship target = this.shipList.get(i);
			if(attacker.lastShot[0] == target.coordinates[0]){
				for(int j = 0; j < target.hits.length;j++){
					if(attacker.lastShot[1] == target.coordinates[1]+j){
						int index = attacker.lastShot[1]-target.coordinates[1];
						target.gotHit(index);
					}
				}
			}
			else if(attacker.lastShot[1] == target.coordinates[1]){
				for(int j = 0; j < target.hits.length;j++){
					if(attacker.lastShot[0] == target.coordinates[0]+j){
						int index = attacker.lastShot[0]-target.coordinates[0];
						target.gotHit(index);
					}
				}
			}
		}
	}
	public boolean sinkShip(){
		for(int i = 0; i < shipList.size(); i++){
			Ship ship = shipList.get(i);
			if(ship.shipSunk()){
				this.removeShip(ship);
				return true;
			}
		}
		return false;
	}
	public boolean endGame(){
		if(shipList.size()==0){
			return true;
		}
		return false;
	}
}
