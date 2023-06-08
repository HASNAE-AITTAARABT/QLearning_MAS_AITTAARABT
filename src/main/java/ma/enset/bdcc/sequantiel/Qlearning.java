package ma.enset.bdcc.sequantiel;

import java.util.Random;

public class Qlearning {
    private  final double ALPHA=0.1; // Learning rate ou taux d'apprentissage
    private  final double GAMMA=0.9;
    private  final double EPS=0.4;
    private  final int MAX_EPOCH=10000;
    private final int GRID_SIZE=6;
    private final int ACTION_SIZE=4;
    private int [][]grid;
    private double [][]QTable= new double[GRID_SIZE * GRID_SIZE][ACTION_SIZE];
    private int [][]actions;
    private int StatI;
    private int Statj;
    public Qlearning() {
        actions= new int[][]  {
                {0,-1},//Left
                {0,1},//Right
                {1,0},//Down
                {-1,0}//Up
        };
        grid= new int[][]  {
                {0,0,0,0,0,0},
                {0,0,0,0,-1,0},
                {0,0,0,0,0,0},
                {0,0,-1,0,0,0},
                {0,0,0,0,0,0},
                {-1,0,0,0,0,1}
        };
    }
    private void resetState(){
        StatI=0;
        Statj=0;
    }
    private int choseAction(double eps){
        Random rm=new Random();
        double bestQ=0;
        int act=0;
        if(rm.nextDouble()<eps){
            //Exploration
            act=rm.nextInt(ACTION_SIZE);
        }else {
            //Exploitation
            int st = StatI*GRID_SIZE+Statj;
            for (int i=0;i<ACTION_SIZE;i++){
                if (QTable[st][i]>bestQ){
                    bestQ=QTable[st][i];
                    act=i;
                }

            }
        }
        return act;
    }
    private int executeAction(int act ){
        StatI=Math.max(0,Math.min(actions[act][0]+StatI,GRID_SIZE-1));
        Statj=Math.max(0,Math.min(actions[act][1]+Statj,GRID_SIZE-1));
        return StatI*GRID_SIZE+Statj;
    }
    //vérifier si l'agent a atteint l'état final
    private boolean finished(){
        return grid[StatI][Statj]==1;
    }
    // imprime les valeurs actuelles de la table Q.
    private void showResult(){
        System.out.println("########## Q TABLE ############");
        for (double[] line:QTable){
            System.out.printf("[");
            for (double Qvalue:line){
                System.out.printf(Qvalue+",");
            }
            System.out.println("]");
        }
// réinitialise l'état de l'agent à l'état de départ
        resetState();
        while (!finished()){
            int act = choseAction(0);
            System.out.println("State :"+(StatI*GRID_SIZE+Statj)+" action: " +act);
            executeAction(act);
        }
        System.out.println("Final State :"+(StatI*GRID_SIZE+Statj));
    }
    public void runQlearning(){
        int it=0;
        int currentState;
        int nextState;
        int act,act1;
        while (it<MAX_EPOCH){
            resetState();
            while (!finished()){
                currentState=StatI*GRID_SIZE+Statj;
                act =choseAction(0.4);
                nextState=executeAction(act);
                act1 =choseAction(0);
                //Equation De BellMan
                QTable[currentState][act] =QTable[currentState][act]+ALPHA*(grid[StatI][Statj]+GAMMA*QTable[nextState][act1]-QTable[currentState][act]);
            }
            it++;
        }
        showResult();
    }
}
