public class DZ05_task3 {

    public static int NUM = 8;
	public static int[][] chessBoard = new int[NUM][NUM];

    public static void main(String[] args) {
		setQueen(0);
		printBoard();
		
	}
 
	public static boolean checkPosition(int x, int y) {

        for (int i = 0; i <x; i ++) {
			if (chessBoard[i][y] == 1) {
				return false;
			}
			if(x-1-i >= 0 && y-1-i >=0 && chessBoard[x-1-i][y-1-i] == 1){
				return false;
			}
			if(x-1-i >=0 && y+1+i < NUM  && chessBoard[x-1-i][y+1+i] == 1){
				return false;
			}
		}
		return true;
	}
	
	public static boolean setQueen(int y){
		 if (y == NUM) {  
			return true;           
		}
		 for (int i = 0; i < NUM; i ++) {
			if(checkPosition(y, i)){
				chessBoard[y][i] = 1;
				if(setQueen(y+1)){
					return true;
				}else{
					chessBoard[y][i] = 0;
				}
			}
		}
		return false;
	}

    public static void printBoard(){
		for (int i = 0; i < NUM; i++) {
			for (int j = 0; j < NUM; j++) {
				System.out.print(chessBoard[i][j]+ "  ");
			}
			System.out.println();
		}
	}
}