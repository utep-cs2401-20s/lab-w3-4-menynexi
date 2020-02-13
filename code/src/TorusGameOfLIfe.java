
class TorusGameOfLife extends GameOfLife{

    public TorusGameOfLife(){
    }

    //takes an integer //constructor
    public TorusGameOfLife(int i) {
        super(i);
    }

    //takes in an array of integers //constructor
    public TorusGameOfLife(int[][] arr) {
       super(arr);
    }

    @Override
    public int neighbor(int row, int colums){
        int count = 0;
        if(super.prevBoard[((row) + size)% size][((colums - 1) + size)% size] == 1){
            count++;
        }
        if(super.prevBoard[((row) + size)% size][((colums + 1) + size)% size] == 1){
            count++;
        }
        if(super.prevBoard[((row + 1) + size)% size][((colums) + size)% size] == 1){
            count++;
        }
        if(super.prevBoard[((row + 1) + size)% size][((colums) + size)% size] == 1){
            count++;
        }
        if(super.prevBoard[((row + 1) + size)% size][((colums + 1) + size)% size] == 1){
            count++;
        }
        if(super.prevBoard[((row - 1) + size)% size][((colums - 1) + size)% size] == 1){
            count++;
        }
        if(super.prevBoard[((row + 1) + size)% size][((colums - 1) + size)% size] == 1){
            count++;
        }
        if(super.prevBoard[((row - 1) + size)% size][((colums + 1) + size)% size] == 1){
            count++;
        }
        if(super.prevBoard[((row - 1) + size)% size][((colums + 1) + size)% size] == 1){
            count++;
        }
        return count;
    }
}