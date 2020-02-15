/*
* Births: Each dead cell adjacent to exactly three live neighbors will become live in the next generation.
* Death by isolation: Each live cell with one or fewer live neighbors will die in the next generation.
* Death by overcrowding: Each live cell with four or more live neighbors will die in the next generation.
* Survival: Each live cell with either two or three live neighbors will remain alive for the next generation.
*
*/

public class GameOfLife {
    int size;
    int[][] currBoard;
    int[][] prevBoard;

    //default constructor
    public GameOfLife(){
        //this.size = 5;
        //this.currBoard = new int[size][size];
        //
        this.prevBoard = new int[size][size];
    }

    //takes an integer //constructor
    public GameOfLife(int i) {
        this.size = i;
        this.currBoard = new int[size][size];
        this.prevBoard = new int[size][size];
    }

    //takes in an array of integers //constructor
    public GameOfLife(int[][] arr) {
        this.size = arr.length;
        this.currBoard = new int[size][size];
        this.prevBoard = new int[size][size];

        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                prevBoard[i][j] = arr[i][j];
                currBoard[i][j] = arr[i][j];
            }
        }
    }

    //gets the prevboard
    public int[][] getPrevBoard() {
        return this.prevBoard;
    }

    public int[][] getcurrBoard(){
        return this.currBoard;
    }

    //one step creates a new instance of the board
    public void oneStep(){
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                this.prevBoard[i][j] = this.currBoard[i][j];
            }
        }

        int[][] temp = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(prevBoard[i][j] == 1){
                    switch(neighbor(i,j)){
                        case 0:
                            temp[i][j] = 0;
                        break;
                        case 1:
                            temp[i][j] = 0;
                        break;
                        case 2:
                            temp[i][j] = 1;
                        break;
                        case 3:
                            temp[i][j] = 1;
                        break;                        
                        case 4:
                            temp[i][j] = 0;
                        break;
                        case 5:
                            temp[i][j] = 0;
                        break;
                        case 6:
                            temp[i][j] = 0;
                        break;
                        case 7:
                            temp[i][j] = 0;
                        break;
                        case 8:
                            temp[i][j] = 0;
                        break;
                    }
                }
                else if(prevBoard[i][j] == 0){
                    switch(neighbor(i,j)){
                        case 0:
                            temp[i][j] = 0;
                        break;
                        case 1:
                            temp[i][j] = 0;
                        break;
                        case 2:
                            temp[i][j] = 0;
                        break;
                        case 3:
                            temp[i][j] = 1;
                        break;                        
                        case 4:
                            temp[i][j] = 0;
                        break;
                        case 5:
                            temp[i][j] = 0;
                        break;
                        case 6:
                            temp[i][j] = 0;
                        break;
                        case 7:
                            temp[i][j] = 0;
                        break;
                        case 8:
                            temp[i][j] = 0;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                this.currBoard[i][j] = temp[i][j];
            }
        }
    }


    //the program has to cheack the inputs up, down, left, right, diagnal_up_left, diagnal_up_right, diagnal_down_left, diagnal_down_right
    public int  neighbor(int row, int colums){
      int countOfneighbor = 0;

      //check up
      if((row > 0) && (prevBoard[row - 1][colums] == 1)){
          countOfneighbor++;
      }

      //cheack down
      if((row < prevBoard.length - 1) && (prevBoard[row + 1][colums] == 1)){
          countOfneighbor++;
      }

      //check left
      if((colums > 0) && (prevBoard[row][colums - 1] == 1)){
          countOfneighbor++;
        }

      //checks right
      if((colums < prevBoard.length - 1) && (prevBoard[row][colums + 1]) == 1){
          countOfneighbor++;
      }

      //diagnal_up_left
      if(((row < prevBoard.length - 1) && (colums < prevBoard[row].length -1) && (row > 0) && (colums > 0)) && (prevBoard[row + 1][colums - 1]) == 1){
          countOfneighbor++;
      }

      //diagnal_up_right
      if(((row < prevBoard.length - 1) && (colums < prevBoard[row].length -1) && (row > 0) && (colums > 0)) && (prevBoard[row + 1][ colums + 1]) == 1){
          countOfneighbor++;
      }

      //diagnal_down_left
      if(((row < prevBoard.length - 1) && (colums < prevBoard[row].length -1) && (row > 0) && (colums > 0)) && (prevBoard[row - 1][colums - 1]) == 1){
          countOfneighbor++;
      }

      //diagnal_down_right
      if(((row < prevBoard.length - 1) && (colums < prevBoard[row].length -1) && (row > 0) && (colums > 0)) && (prevBoard[row - 1][colums + 1]) == 1){
          countOfneighbor++;
      }

      return countOfneighbor;
    }

    //does what step does but multiple times
    public void evolution(int n){
        if(0 > n){
            n = n * -1;
        }
        int countOfevolutions = 0;
        while(countOfevolutions < n){
            oneStep();
            countOfevolutions++;
        }
    }
    
    public void printarr(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(this.currBoard[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //public static void main(String[] args){

    //}
}