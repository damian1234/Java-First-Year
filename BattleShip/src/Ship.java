import java.util.Random;
public class Ship {
	boolean[] hits;
	boolean horizontal;
	int[] coordinates = new int[2];
	public Ship(boolean Horizontal){
		horizontal = Horizontal;
		hits = new boolean[2];
		hits[0] = false;
		hits[1] = false;
	}
	public Ship(int size, boolean Horizontal){
		horizontal = Horizontal;
		hits  = new boolean[size];
		for(int i = 0; i <size; i++){
			hits[i] = false;
		}
	}
	public boolean gotHit(int index){
		if(hits[index]){
			return false;
		}
		hits[index] = true;
		return true;
	}
	public boolean shipSunk(){
		for(int i = 0; i <this.hits.length; i++){
			if(!hits[i]){
				return false;
			}
		}
		return true;
	}
}
