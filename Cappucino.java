
package Starbucks;

import javax.swing.JOptionPane;
/**
 *
 * @author Sam
 */
public class Cappucino
{
    public void main()
    {
        
        Latte l = new Latte();
        l.getSize();    l.getSyrup();
        l.getMilk();    l.getShots(); l.getCaf();
        l.setSteam(get()); l.setDrink('c');
        l.output();
    }
    
    public int get()
    {
        String[] s = {"Regular", "Wet", "Dry"}; int n = 15;
        String wd = (String) JOptionPane.showInputDialog(null, "Wet or Dry?",
                                            null, JOptionPane.QUESTION_MESSAGE,
                                            null, s, s[0]);
        switch(wd)
        {
            case "Regular"  :   n = 15;  break;
            case "Wet"      :   n = 10;  break;
            case "Dry"      :   n = 20;
        }
        return n;
    }
}
