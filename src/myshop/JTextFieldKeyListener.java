package myshop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
/**
 *
 * @author odipojames12
 */
public class JTextFieldKeyListener extends KeyAdapter {
    
    private final JTextField textField;
    
    public JTextFieldKeyListener(JTextField textField) {
        this.textField = textField;
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
      super.keyTyped(e);
      char c = e.getKeyChar();
      //only numbers
      if(!Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)){
         e.consume();
    } 
        
 
      
    }


  
    
}



