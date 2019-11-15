/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_2048_swing.UI;

import java.awt.Point;

/**
 *
 * @author pahuja
 */
public class LocationConstants {
    static final Point TITLE = new Point(0,0);
    //To Align Frame at Center of Screen
    static final Point BASE_FRAME = new Point((DimensionConstants.SCREEN_SIZE.width - DimensionConstants.BASE_FRAME.width)/2,
                                              (DimensionConstants.SCREEN_SIZE.height - DimensionConstants.BASE_FRAME.height)/2);
    
    static final Point CLOSE = new Point(DimensionConstants.BASE_FRAME.width - DimensionConstants.CLOSE.width , 0);
    static final Point TILE_PANEL = new Point(DimensionConstants.FRAME_LEFT_MARGIN,DimensionConstants.FRAME_DOWN_MARGIN);
}
