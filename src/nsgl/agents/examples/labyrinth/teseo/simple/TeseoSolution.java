package nsgl.agents.examples.labyrinth.teseo.simple;

import javax.crypto.interfaces.PBEKey;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TeseoSolution extends SimpleTeseoAgentProgram{
    private int[][] map;
    private int dim = 12;
    private int posx = dim/2;
    private int posy = dim/2;
    private int posd = 3;
    public TeseoSolution() {
        this.map = new int[dim][dim];
        this.map[posx][posy] = 1;
    }

    @Override
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean FAIL) {
        //System.out.println("My teseo PF " + PF + " PD " + PD + " PA " + PA + " PI " + PI + " MT " + MT + " FAIL" + FAIL);
        int returnvar = -3;
        int[] dir = this.calculatedirection();
        if (MT) {
            return -1;
        }
        else if (!PI){
            this.posd = (this.posd +3)%4;
            returnvar= 3;
        }
        else if (!PF){
            returnvar = 0;
        }
        else if (!PD ){
            this.posd = (this.posd +1)%4;
            returnvar = 1;
        }else if(returnvar == -3){
            returnvar = 2;
            this.posd = (this.posd + 2)%4;
        }
        System.out.println(this.posd);

        posx = posx+dir[0];
        posy = posy+dir[1];
        this.map[posx][posy]+=1;
        printmatrix();
        return returnvar;
    }
    private void printmatrix(){
        for(int i =0;i<dim;i++){
            System.out.println(Arrays.toString(this.map[i]));
        }
    }
    private int[] calculatedirection(){
        int[] dir = {0,0};
        switch (this.posd){
            case 0:
                dir[1]+=1;
                break;
            case 1:
                dir[0]+=1;
                break;
            case 2:
                dir[1]-=1;
                break;
            case 3:
                dir[0]-=1;
                break;
        }
        return dir;
    }
}
