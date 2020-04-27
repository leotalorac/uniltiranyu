package nsgl.agents.examples.labyrinth.teseo.simple.solution;

import java.util.List;

public class MazeNode {
    //if the node have been visited
    private int visited;
    //the options since that node
    private List<Integer> options;
    //orientation on the node
    private int orientation;
    public MazeNode(int v,List o,int or){
        this.visited = v;
        this.options = o;
        this.orientation = or;
    }
}
