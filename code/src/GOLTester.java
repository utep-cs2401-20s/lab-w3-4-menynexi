import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


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

    //check the edges for any possible out of bound cases
    @Test
    public void GOLTesting3(){
        int[][] arr = {
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {1,0,0,0,1}
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

    //testing the evolution method with a minimum of 11 steps
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

    //a combination of oneStep and evolution
    @Test
    public void GOLTesting5(){
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
        case1.evolution(11);
        assertEquals( expectedArr, case1.getcurrBoard());
    }

    //testing neighbors
    @Test
    public void GOLTesting6(){
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        assertEquals( 2, case1.neighbor(2,2));
    }

    //testing neighbors after step
    @Test
    public void GOLTesting7(){
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.oneStep();
        assertEquals( 2, case1.neighbor(2,2));
    }

    //testing neighbors using torus
    @Test
    public void GOLTesting16(){
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        GameOfLife case1 = new TorusGameOfLife(arr);
        assertEquals( 2, case1.neighbor(2,2));
    }

    //using neighbors  test cases 17 -- 20 using torus I used this statement to check if there are no duplicate statements that check the same index twice
    @Test
    public void GOLTesting17(){
        int[][] arr = {
                {1,0,0,1,1},
                {0,0,0,1,1},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {1,0,0,0,1}
        };
        GameOfLife case1 = new TorusGameOfLife(arr);
        assertEquals( 6, case1.neighbor(0,4));
    }

    @Test
    public void GOLTesting18(){
        int[][] arr = {
                {1,1,0,0,1},
                {1,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {1,0,0,0,1}
        };
        GameOfLife case1 = new TorusGameOfLife(arr);
        assertEquals( 6, case1.neighbor(0,0));
    }

    @Test
    public void GOLTesting19(){
        int[][] arr = {
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {1,1,0,0,0},
                {1,1,0,0,1}
        };
        GameOfLife case1 = new TorusGameOfLife(arr);
        assertEquals( 6, case1.neighbor(0,0));
    }

    @Test
    public void GOLTesting20(){
        int[][] arr = {
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,1,1},
                {1,0,0,1,1}
        };
        GameOfLife case1 = new TorusGameOfLife(arr);
        assertEquals( 6, case1.neighbor(0,0));
    }







}