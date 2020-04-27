package nsgl.agents.examples.labyrinth.teseo.simple.solution;

import nsgl.agents.examples.labyrinth.teseo.simple.SimpleTeseoAgentProgram;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTeseo extends SimpleTeseoAgentProgram {
    //save the orientation of the agent on the map
    private int orientation=0;
    private final ArrayList<MazeNode> mapMazeNodes = new ArrayList<>();
    private int goBack =-1;
    @Override
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean FAIL) {
        //research the goal
        if (MT) return -1;
        int actionToPerform = -2;
        //map the options as an array
        boolean[] l = {PF,PD,PA,PI};
        //Get the action based on order
        int pos = (4-this.orientation)%4;
        for(int i=pos;i<l.length+pos;i++){
            if (!l[i%4]) {
                l[i%4] =!l[i%4];
                actionToPerform = i%4;
                break;
            }
        }
        l = reOrder(l);
        int actionToPerformReference = (actionToPerform+this.orientation)%4;
        System.out.println(this.mapOptions(l).toString());
        System.out.println("action " + actionToPerformReference + " goBack " + goBack);
        goBack = (actionToPerformReference+2)%4;
        mapMazeNodes.add(new MazeNode(1,this.mapOptions(l),this.orientation));
        this.affectOrientation(actionToPerform);
        return actionToPerform;
    }
    //affects the orientation variable in order to action change
    public void affectOrientation(int act){
        this.orientation = (this.orientation + act)%4;
    }
    public boolean[] reOrder(boolean[] b){
        boolean[] reordered = new boolean[4];
        int pos = (4-this.orientation)%4;
        for(int i=pos;i<b.length+pos;i++){
            reordered[i%4] =b[(i+pos)%4];
        }
        return reordered;
    }
    public List<Integer> mapOptions( boolean[] v){
        ArrayList<Integer> MapArray = new ArrayList<Integer>();
        for (int i = 0;i<v.length;i++){
            if(!v[i]){
                MapArray.add(i);
            }
        }
        return MapArray;
    }

}
