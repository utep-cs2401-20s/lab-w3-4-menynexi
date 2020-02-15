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

    @Test
    public void GOLTesting8() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        assertEquals(4, case1.neighbor(2,2));
    }

    @Test
    public void GOLTesting9(){
        int[][] arr = {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,1,1,1,0},
                {0,1,1,1,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
        };
        int[][] expectedArr = {
                {0,0,0,0,0,0},
                {0,0,0,1,0,0},
                {0,1,0,0,1,0},
                {0,1,0,0,1,0},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0}
        };
        int[][] expectedArr2 = {
                {0,0,0,0,0,0},
                {0,0,0,1,0,0},
                {0,1,0,0,1,0},
                {0,1,0,0,1,0},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.oneStep();
        assertEquals( expectedArr, case1.getcurrBoard());
        assertEquals( expectedArr2, case1.getcurrBoard());//I wanted to see if this was possible
    }

    @Test//this test case passed but it froze my computer and took 156 ms which is odd compared to other actions
    public void GOLTesting10() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.oneStep();
        assertEquals(arr, case1.getPrevBoard());
    }

    @Test
    public void GOLTesting11() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.oneStep();
        assertEquals(arr, case1.getPrevBoard());
    }

    @Test//cant take in rectangles
    public void GOLTesting12() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.oneStep();
        assertEquals(arr, case1.getPrevBoard());
    }

    @Test//if you where to devide the rows and the colums based on different input the it would support different sized input
    public void GOLTesting13(){
        int[][] arr = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0}
        };

        int[][] expectedArr = {
                {0,0,0,0,0,0},
                {0,0,0,1,0,0},
                {0,1,0,0,1,0},
                {0,1,0,0,1,0},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,1,0,0},
                {0,1,0,0,1,0},
                {0,1,0,0,1,0},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.oneStep();
        assertEquals(expectedArr, case1.getcurrBoard());
    }

    @Test
    public void GOLTesting14() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.oneStep();
        assertEquals(arr, case1.getPrevBoard());
    }

    @Test
    public void GOLTesting15() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0}
        };
        GameOfLife case1 = new GameOfLife(arr);
        case1.evolution(-1);
        assertEquals(arr, case1.getPrevBoard());
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


    //checking evolving
    @Test
    public void GOLTesting21(){
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
    public void GOLTesting22() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0}
        };
        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.oneStep();
        assertEquals(arr, case1.getPrevBoard());
    }

    @Test//cheack a bigger board just to see if it can support a 10 x 10
    public void GOLTesting23() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.oneStep();
        assertEquals(arr, case1.getPrevBoard());
    }

    @Test //because science
    public void GOLTesting24() {
        int[][] arr = {
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };

        int[][] expectedArr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };

        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.oneStep();
        case1.printarr();
        assertEquals(expectedArr, case1.getcurrBoard());
    }

    @Test
    public void GOLTesting25() {
        int[][] arr = {
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };

        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.oneStep();
        case1.printarr();
        assertEquals(arr, case1.prevBoard);
    }

    @Test
    public void GOLTesting26() {
        int[][] arr = {
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };

        int[][] expectedArr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };

        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.evolution( -1);
        case1.printarr();
        assertEquals(expectedArr, case1.getcurrBoard());
    }

    @Test
    public void GOLTesting27() {
        int[][] arr = {
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };

        int[][] expectedArr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };

        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.evolution( 1);
        case1.printarr();
        assertEquals(expectedArr, case1.getcurrBoard());
    }

    @Test
    public void GOLTesting28() {
        int[][] arr = {
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };

        int[][] expectedArr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };

        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.printarr();
        case1.oneStep(); // you cant use case.oneStep(),oneStep();
        assertEquals(expectedArr, case1.getcurrBoard());
    }

    @Test
    public void GOLTesting29(){
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
        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.oneStep();
        case1.evolution(11);
        assertEquals( expectedArr, case1.getcurrBoard());
    }

    @Test
    public void GOLTesting30(){
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
        case1.evolution(109);
        assertEquals( expectedArr, case1.getcurrBoard());
    }

    @Test
    public void GOLTesting31() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.oneStep();
        assertEquals(arr, case1.getPrevBoard());
    }

    @Test
    public void GOLTesting32() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.oneStep();
        assertEquals(4, case1.neighbor(5,4));
    }

    @Test//cheack a bigger board just to see if it can support a 10 x 10
    public void GOLTesting33() {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int[][] expectedArr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };


        TorusGameOfLife case1 = new TorusGameOfLife(arr);
        case1.oneStep();
        case1.printarr();
        assertEquals(expectedArr, case1.getcurrBoard());
    }







}