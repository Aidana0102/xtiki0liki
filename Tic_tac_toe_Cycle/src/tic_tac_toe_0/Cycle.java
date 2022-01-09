package tic_tac_toe_0;

import javax.swing.JOptionPane;

public class Cycle{
    private static Logic logic = new Logic();
    private static Frame frame = new Frame(logic.getSide());
    
    private static void action(String text){
        JOptionPane.showMessageDialog(null,text);    
    }
    
    private static boolean result(String result){
        if(result=="0")        { action("YOU LOSE"); return true; }
        if(result=="X")        { action("YOU WON");  return true;}
        if(result=="deadlock") { action("DRAW");     return true;}
        return false;
    }
    
    public static void main(String[] args) {
        while(true){
            frame.pushReset();
            frame.update(logic.resetPosition());
            while(true){
                frame.update(logic.process(frame.pushButton()));
                if(result(logic.result())){ break; }
            }
        } 
    }
    
}
