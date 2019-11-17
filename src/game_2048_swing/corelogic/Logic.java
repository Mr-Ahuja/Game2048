/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_2048_swing.corelogic;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author pahuja
 */
public class Logic {
    
    protected int gridSize ;
    protected int[][] grid ;
    private int newValueIndex ;
    
    //LinkedList has less time complexity for deletion and insertion
    protected List<Integer> freeIndex = new LinkedList<>();
    private Random random = new Random();
    
    protected Logic(int gridSize)
    {
        this.gridSize = gridSize;
        grid = new int[gridSize][gridSize];
        
        //Initially all indexes are free
        for(int iter = 0 ; iter < gridSize*gridSize ; ++iter)
        {
            freeIndex.add(iter);
        }
        
        //Adding Initial Value to Grid
        addValueInGrid(2);
        addValueInGrid(2);
    }   
    
    protected void addValueInGrid(){
        addValueInGrid(randomNumber2and4());
    }
    
    //For explicit value input
    private void addValueInGrid(int value){
        int freeIndexValue = getFreeIndexRandom();
        int xCord = freeIndexValue/gridSize;
        int yCord = freeIndexValue%gridSize;
        
        grid[xCord][yCord] = value;
    }
    
    //Chances of getting 4 is 1 in 10
    private int randomNumber2and4(){
        if(randomInRange(1, 10) == 1)
            return 4;
        return 2;
    }
    
    private int getFreeIndexRandom(){
        int randomIndex = randomInRange(0,freeIndex.size()-1);
        int freeIndexValue = freeIndex.get(randomIndex);

        newValueIndex = freeIndex.remove(randomIndex);
        return freeIndexValue;
    }
    //Inclusive
    private int randomInRange(int i,int j)
    {
        return random.nextInt((j-i) + 1) + i;
    }
    
    public int getFreeIndexCount(){
        return freeIndex.size();
    }
    
    //To expose Last Added Index
    public int getNewValueIndex(){
        return newValueIndex;
    }
}
