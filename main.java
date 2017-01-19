
package Starbucks;

import javax.swing.JOptionPane;
/**
 *
 * @author Sam
 */
public class main
{
    public static void main(String[] args)
    {
        String[] drinks = {"Latte", "Cappucino"};
        String drink = (String) JOptionPane.showInputDialog(null, "Choose Drink",
                null, JOptionPane.QUESTION_MESSAGE, null, drinks, drinks[0]);
        switch(drink)
        {
            case "Latte":   Latte l = new Latte();
                            l.getSize();    l.getSyrup();
                            l.getMilk();    l.getShots(); l.getCaf();
                            l.output();     break;
            case "Cappucino":   Cappucino c = new Cappucino(); c.main();
        }
    }
}
