/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_2048_swing.UI;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author pahuja
 */
public class DimensionConstants {
    
    static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    
   
    static final int FRAME_TOP_MARGIN = 50;
    static final int FRAME_DOWN_MARGIN = 100;
    static final int FRAME_LEFT_MARGIN = 50;
    static final int FRAME_RIGHT_MARGIN = 50;
    
    private static int tileSize = (SCREEN_SIZE.height - (FRAME_TOP_MARGIN + 30 +FRAME_DOWN_MARGIN))/MiscellaneousProperties.GRID_COUNT;
    
    static final Dimension TILE = new Dimension(tileSize,tileSize);
   
    static final Dimension TILE_PANEL = new Dimension(MiscellaneousProperties.GRID_COUNT * TILE.width 
                                        ,MiscellaneousProperties.GRID_COUNT * TILE.height);
    
    static final Dimension BASE_FRAME = new Dimension(TILE_PANEL.width + FRAME_LEFT_MARGIN + FRAME_RIGHT_MARGIN
                                        ,TILE_PANEL.height + FRAME_DOWN_MARGIN + FRAME_TOP_MARGIN );
    
    static final Dimension TITLE = new Dimension(BASE_FRAME.width , 30);
    static final Dimension CLOSE = new Dimension(50,30);
}
