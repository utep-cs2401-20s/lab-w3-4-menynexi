import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


class GOLTesting{

    //this is a basic test case that test oneStep
    @Test
    public void GOLTesting1(){
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };

        int[][] expectedArr = {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,0,0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.oneStep();
        assertEquals( expectedArr, case1.getcurrBoard());
    }

    //this test case checks for two consecutive oneStep
    @Test
    public void GOLTesting2(){
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.oneStep();
        case1.oneStep();
        assertEquals( arr, case1.getcurrBoard());
    }

    @Test
    public void GOLTesting3(){
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        int[][] expectedArr = {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,0,0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.oneStep();
        assertEquals( expectedArr, case1.getcurrBoard());
    }

    //testing the evolution
    @Test
      public void GOLTesting4(){
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        int[][] expectedArr = {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,0,0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.evolution(11);
        assertEquals( expectedArr, case1.getcurrBoard());
    }



}