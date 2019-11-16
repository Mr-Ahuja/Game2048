/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_2048_swing.corelogic;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author pahuja
 */
//Consumer Producer Logic Combine With Functional Interface

public class Actions extends Logic{
    
    LossingConsumer lossConsumer;
    
    WinningConsumer winConsumer;
    
    private int winningValue;
    
    private boolean check = true;
    
    public Actions(int gridSize,int winningValue,WinningConsumer winConsumer,LossingConsumer lossConsumer) {
        super(gridSize);
        this.winningValue = winningValue;
        this.winConsumer = winConsumer;
        this.lossConsumer = lossConsumer;
    }
    
    public int[][] moveLeft(){
        gravity(false,false);
        return grid;
    }
    
    public int[][] moveRight(){
        gravity(true,false);
        return grid;
    }
    
     public int[][] moveUp(){
        gravity(false,true);
        return grid;
    }
     
    public int[][] moveDown(){
        gravity(true,true);
        return grid;
    }
   
    // Single Method to reduce Redundancy
    private void gravity(boolean antiGravity,boolean metaGravity)
    {
        //Flushing free Spaces
        freeIndex = new LinkedList<>();
        for(int x = 0; x < gridSize ; ++x)
        {
            List<Integer> values = new LinkedList<>();
            for(int y  = 0; y < gridSize ; ++y)
            {
                int X=x,Y=y;
                
                if(metaGravity)
                {
                    int temp = x;
                    X = y;
                    Y = temp;
                }
                
                if(grid[X][Y] != 0)
                    values.add(grid[X][Y]);
            }

            if(antiGravity)
                Collections.reverse(values);

            values = mergeSequence(values);
            
            //To add rest spaces as 0
            for(int y = gridSize - values.size() ; y > 0 ; --y)
                values.add(0);
            
            if(antiGravity)
                Collections.reverse(values);

            for(int y = 0; y < gridSize ; ++y)
            {
                int X=x,Y=y;
                
                if(metaGravity)
                {
                    int temp = x;
                    X = y;
                    Y = temp;
                }
                
                grid[X][Y] = values.get(y);
                //To keep track of Empty Indexes
                if(grid[X][Y] == 0)
                    freeIndex.add( (X * gridSize) + Y );
            }
        }
        if(getFreeIndexCount() > 0)
            addValueInGrid();
        
        if(check)
            checkForLost();
    }
    
    private void checkForLost(){
        if(getFreeIndexCount() != 0)
            return;
        
        check = false;
        int[][] gridCopy = Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
        
        moveDown();
        moveUp();
        moveLeft();
        moveRight();
        
        check = true;
        
        boolean validation = true;
        
        for(int x = 0;x< gridSize;x++)
        {
            for(int y = 0;y<gridSize;y++){
                if(grid[x][y] == gridCopy[x][y])
                {
                    validation = validation && true;
                }
                else{
                    validation = validation && false;
                }
            }
        }
        
        if(validation)
           lossConsumer.toDo();
        else
            grid = gridCopy;
        
    }
    
    private List<Integer> mergeSequence(List<Integer> values){
        for(int iter = 0; iter < values.size();++iter)
        {
            if((iter +1 < values.size()) && (Objects.equals(values.get(iter), values.get(iter+1))))
            {
                values.set(iter,values.get(iter) * 2);
                values.remove(iter+1);
                
                if(values.get(iter) == winningValue)
                    winConsumer.toDo();
            }
        }
        return values;
    }
    
    public int[][] getGrid(){
        return grid;
    }
}
