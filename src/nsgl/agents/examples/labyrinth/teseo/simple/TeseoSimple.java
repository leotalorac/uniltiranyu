/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nsgl.agents.examples.labyrinth.teseo.simple;

/**
 *
 * @author Jonatan
 */
public class TeseoSimple extends SimpleTeseoAgentProgram {

    public TeseoSimple() {}
    
    @Override
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean FAIL) {
        System.out.println("PF" + PF + " PD" + PD + " PA" + PA + " PI" + PI + " MT" + MT + " FAIL" + FAIL);
        if (MT) return -1;
        if (!PI) return 3;
        if (!PF) return 0;
        if (!PD) return 1;
        return 2;
    }
    
}
