/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_2048_swing.UI;

import static game_2048_swing.UI.MiscellaneousProperties.GRID_COUNT;
import game_2048_swing.corelogic.Actions;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;


/**
 *
 * @author pahuja
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    
    Font TILE_FONT = new java.awt.Font("Dialog", 1, (25+(5*(8 - GRID_COUNT))));
    ArrayList<JLabel> tiles = new ArrayList<>();
    public JPanel tilePanel = new JPanel();
    int colorWeight = 255/(int)(Math.log(MiscellaneousProperties.WINNING_VALUE)/Math.log(2));
    
    Border matteBorder = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3);
    Border matteBorderHighlight = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 3);
    
    Actions game = new Actions(MiscellaneousProperties.GRID_COUNT,
            MiscellaneousProperties.WINNING_VALUE,
            ()->{
                JOptionPane.showMessageDialog(rootPane,"Kabhi Kabhi Lagta Hai Ki Apunich BHAGWAN Hai.","You Won I Guess ?",JOptionPane.INFORMATION_MESSAGE);
                new Configuration().setVisible(true);
                this.setVisible(false);
            },
            ()->{
                JOptionPane.showMessageDialog(rootPane,"Tum se Na ho Payga","You Lost for Sure !",JOptionPane.ERROR_MESSAGE);
                new Configuration().setVisible(true);
                this.setVisible(false);
            });
    
    public MainUI() {
        initComponents();
        overrideDefaultProperties();
        
        render(game.getGrid());
    }

    private void overrideDefaultProperties(){
        //Frame Properties
        this.setBackground(ColorConstants.BASE_FRAME);
        this.setSize(DimensionConstants.BASE_FRAME);
        this.setLocation(LocationConstants.BASE_FRAME);
        
        //tilePanel Properties
        
        tilePanel.setLayout(new java.awt.GridLayout(MiscellaneousProperties.GRID_COUNT,MiscellaneousProperties.GRID_COUNT));
        
        createLabelGrid();
        this.getContentPane().add(tilePanel);
        
        tilePanel.setBackground(ColorConstants.TILE_PANEL_BACKGROUND);
        tilePanel.setSize(DimensionConstants.TILE_PANEL);
        tilePanel.setLocation(LocationConstants.TILE_PANEL);
        
        //title Properties
        title.setBackground(ColorConstants.TITLE_BACKGROUND);
        title.setForeground(ColorConstants.TITLE_FOREGROUND);
        title.setSize(DimensionConstants.TITLE);
        title.setLocation(LocationConstants.TITLE);
        
        //close Properties
        close.setBackground(ColorConstants.CLOSE_BUTTON_LIGHT);
        close.setSize(DimensionConstants.CLOSE);
        close.setLocation(LocationConstants.CLOSE);
    }
    
    public void createLabelGrid(){
        
        for(int iter = 0;iter < MiscellaneousProperties.GRID_COUNT * MiscellaneousProperties.GRID_COUNT ; iter++)
        {   
            JLabel tileLabel = new JLabel();
            
            tilePanel.add(tileLabel);
            tileLabel.setSize(DimensionConstants.TILE_PANEL);
            tileLabel.setBackground(ColorConstants.TILE_BACKGROUND);
            tileLabel.setBorder(matteBorder);
            tileLabel.setFont(TILE_FONT);
            tileLabel.setForeground(ColorConstants.TILE_FOREGROUND);
            tileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            tileLabel.setOpaque(true);
            
            tiles.add(tileLabel);
        }
    }
    
    private Color getColorAsPerValue(int value){
        int colorValue =255 - (colorWeight*(int)(Math.log(value)/Math.log(2)));
        return new Color(colorValue, colorValue, colorValue);
    }
    
    private Color getNegativeColor(Color color)
    {
        if(color.getRed() < 120)
            return new Color(255,255,255);
        
        return new Color(0,0,0);
    }
    
    private void render(int[][] grid){
        for(int x = 0; x < MiscellaneousProperties.GRID_COUNT ; ++x)
        {
            for(int y = 0; y < MiscellaneousProperties.GRID_COUNT ; ++y)
            {
                int index = (x*MiscellaneousProperties.GRID_COUNT) + y;
                JLabel tile = tiles.get(index);
                if(grid[x][y] != 0)
                {
                    tile.setText(""+grid[x][y]);
                    tile.setBackground(new Color(100,100,100));
                    
                    int indexValue = game.getNewValueIndex();
                    int xCord = indexValue/MiscellaneousProperties.GRID_COUNT;
                    int yCord = indexValue%MiscellaneousProperties.GRID_COUNT;
                    
                    if(x == xCord && y == yCord)
                        tile.setBorder(matteBorderHighlight);
                    else
                        tile.setBorder(matteBorder);
                    
                    Color background = getColorAsPerValue(grid[x][y]);
                    
                    tile.setBackground(background);
                    tile.setForeground(getNegativeColor(background));
                }
                else
                {
                    tile.setText("");
                    tile.setBackground(ColorConstants.TILE_BACKGROUND);
                    tile.setBorder(matteBorder);
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        close = new javax.swing.JLabel();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        close.setBackground(new java.awt.Color(255, 102, 102));
        close.setOpaque(true);
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(450, 0, 50, 30);

        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("2048 Game - Java Swing");
        title.setOpaque(true);
        title.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleMouseDragged(evt);
            }
        });
        title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleMousePressed(evt);
            }
        });
        getContentPane().add(title);
        title.setBounds(0, 0, 500, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private int tx, ty;
    
    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        // TODO add your handling code here:
        close.setBackground(ColorConstants.CLOSE_BUTTON_DARK);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        // TODO add your handling code here:
        close.setBackground(ColorConstants.CLOSE_BUTTON_LIGHT);
    }//GEN-LAST:event_closeMouseExited

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void titleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMousePressed
        // TODO add your handling code here:
        tx = evt.getX();
        ty = evt.getY();
    }//GEN-LAST:event_titleMousePressed

    private void titleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseDragged
        // TODO add your handling code here:
        this.setLocation(evt.getXOnScreen() -tx, evt.getYOnScreen() -ty);
    }//GEN-LAST:event_titleMouseDragged

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int keyCode = evt.getKeyCode();
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                render(game.moveUp());
                break;
            case KeyEvent.VK_DOWN:
                render(game.moveDown());
                break;
            case KeyEvent.VK_LEFT:
                render(game.moveLeft());
                break;
            case KeyEvent.VK_RIGHT:
                render(game.moveRight());
                break;
        }
        
        int freeCount = game.getFreeIndexCount();
        int gridSize = MiscellaneousProperties.GRID_COUNT * MiscellaneousProperties.GRID_COUNT;
        if(freeCount >= 0 && freeCount < gridSize/3)
            this.setBackground(new Color(255,102,102,40));
        else if(freeCount >= gridSize/3 && freeCount < (2*gridSize)/3)
            this.setBackground(new Color(255,255,0,40));
        else
            this.setBackground(new Color(0,255,0,40));
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
