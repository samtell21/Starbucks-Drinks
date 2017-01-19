
package Starbucks;

/**
 *
 * @author Sam Tell
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Latte
{
    /**
     * Size of drink.
     */
    private char size = 'g';
    /**
     * Syrup in drink.
     */
    private String syrup = ""; 
    /**
     * Syrup with default number of pumps.
     */
    private String syrup1 = "";
    /**
     * Milk in drink.
     */
    private String milk = "2%";
    /**
     * Shots in drink.
     */
    private int shots = 2;
    /**
     * Caffeination of the drink.
     */
    private double caf = 1;
    /**
     * Syrup options.
     */
    private final String[] syrups = {"mocha", "caramel", "vanilla", "special"};
    /**
     * Milk options.
     */
    private final String[] milks  = {"Non-fat milk", "2%", "Whole milk", "Breve"};
    /**
     * Size options.
     */
    private final String[] sizes  = {"Short","Tall","Grande","Venti"};
    /**
     * Default option booleans and one error boolean.
     */
    private boolean dy1 = false, dy2 = false, dy3 = false, dt = false, dm = false,
            dc = false, er = false;
    private final String ER = "\nError with caffeination: entered value is greater than 1 or less than 0";
    private int steam = 5;
    private char l = 'l';
    
    /**
     * Constructor.
     * @param s size
     * @param sy syrup
     * @param m milk
     * @param sh shots
     */
    public void Late(char s, String sy, String m, int sh)
    {
        size = s;
        syrup = sy;
        milk = m;
        shots = sh;
    }
    
    /**
     * Gets Syrup for drink.
     */
    @SuppressWarnings("empty-statement")
    public void getSyrup()
    {
        String[] pumps = {"default","1","2","3","4","5","6","7","other"};
        String sy = "";
        SHABADOO:
        {
            int p = 0;
            String sy1 = (String) JOptionPane.showInputDialog(null,"Syrup?"+ 
                                        " Cancel for none",null,
                                         JOptionPane.QUESTION_MESSAGE, null,
                                         syrups, syrups[0]);
            if(sy1 == null) {dy1 = true; dy2 = true; break SHABADOO;}
            syrup1 = sy1;
            String pp = (String) JOptionPane.showInputDialog(null,"Pumps?", null,
                                         JOptionPane.QUESTION_MESSAGE, null,
                                         pumps, pumps[0]);
            if(pp.equals("default"))
            {
                switch(size)
                {
                    case 's': p = 2;    break;
                    case 't': p = 3;    break;
                    case 'g': p = 4;    break;
                    case 'v': p = 5;    break;
                }
                dy2 = true;
            }
            else if(pp.equals("other")) p = Integer.parseInt(
                    JOptionPane.showInputDialog("Pumps?"));
            else p = Integer.parseInt(pp);
            sy += p + " pump " + sy1 + " ";
            int cont = JOptionPane.showConfirmDialog(null, "Another syrup",
                                    null, JOptionPane.YES_NO_OPTION);
            if(cont == JOptionPane.YES_OPTION) dy3 = true;
            while(cont == JOptionPane.YES_OPTION)
            {
                String[] lumps = {"1","2","3","4","5","6","7","other"};
                sy1 = (String) JOptionPane.showInputDialog(null,"Syrup?"+ 
                                        " Cancel for none",null,
                                         JOptionPane.QUESTION_MESSAGE, null,
                                         syrups, syrups[0]);
                if(sy1 == null) {break SHABADOO;}
                pp = (String) JOptionPane.showInputDialog(null,"Pumps?", null,
                                         JOptionPane.QUESTION_MESSAGE, null,
                                         lumps, lumps[0]);
                if(pp.equals("other")) p = Integer.parseInt(
                        JOptionPane.showInputDialog("Pumps?"));
                else p = Integer.parseInt(pp);
                sy += p + " pump " + sy1 + " ";
                cont = JOptionPane.showConfirmDialog(null, "Another syrup",
                                    null, JOptionPane.YES_NO_OPTION);
            }   
        }
        syrup = sy;
    }
    
    /**
     * Gets milk for drink.
     */
    public void getMilk()
    {
        String ml = (String) JOptionPane.showInputDialog(null, "Milk?", null,
                                            JOptionPane.QUESTION_MESSAGE, null,
                                            milks, milks[1]);
        if(ml.equals("2%")) dm = true;
        milk = ml;
    }
    
    /**
     * Gets number of shots in drink.
     */
    public void getShots()
    {
        int st = 0;
        String[] sh = {"default", "1", "2", "3", "4", "5", "other"};
        String s =  (String) JOptionPane.showInputDialog(null, "Shots?", null,
                                            JOptionPane.QUESTION_MESSAGE, null,
                                            sh, sh[0]);
        if(s.equals("default"))
        {
            switch(size)
            {
                case 's':   
                case 't':   st = 1;    break;
                case 'g':   
                case 'v':   st = 2;
            }
            dt = true;
        }
        else if(s.equals("other"))
            st = Integer.parseInt(JOptionPane.showInputDialog("Shots?"));
        else st = Integer.parseInt(s);
        shots = st;
    }
    
    /**
     * Gets size of drink.
     */
    public void getSize()
    {
        String sz = (String) JOptionPane.showInputDialog(null, "Size?", null, 
                JOptionPane.QUESTION_MESSAGE, null, sizes, sizes[0]);
        sz = sz.toLowerCase();
        size = sz.charAt(0);
    }
    
    /**
     * Gets caffeination of drink.
     */
    public void getCaf()
    {
        double c;
        String[] cafs = {"Whole caf", "1/2 caf", "1/3 caf", "2/3 caf", "1/4 caf", "3/4 caf", "Decaf", "other"};
        String cc = (String) JOptionPane.showInputDialog(null, "Caffeination?",
                                            null, JOptionPane.QUESTION_MESSAGE,
                                            null, cafs, cafs[0]);
        switch(cc)
        {
            case "Whole caf":   c = 1;dc = true;    break;
            case "1/2 caf"  :   c = .5;             break;
            case "Decaf"    :   c = 0;              break;
            case "1/3 caf"  :   c = .33333333333;   break;
            case "2/3 caf"  :   c = .66666666666;   break;
            case "1/4 caf"  :   c = .25;            break;
            case "3/4 caf"  :   c = .75;            break;
            default:    c = Double.parseDouble(JOptionPane.showInputDialog("Enter a decimal (not a fraction)"));
        }
        if(c <= 1.001 && c >= -.001)caf = c;
        else{er = true; dc = true; caf = 1;}
    }
    
    /**
     * Prints name and diagram of drink in console.
     */
    public void output()
    {
        String l = (syrup.equals(""))?"    \\          /\n":
                        "    \\~~~~~~~~~~/----------"+syrup+"\n";
        double asd = Math.ceil((double)shots*caf);
        String m = (dc == true)?"   \\~~~~~~~~~~~~/---------"+shots+" shots\n":
                "   \\~~~~~~~~~~~~/---------"+Integer.toString((int)asd)
                +" caf shots, "+Integer.toString((int)((double)shots-asd))+" dec shots"+"\n";
        System.out.println(
                name() + "\n\n" +
                "\\~~~~~~~~~~~~~~~~~~/------\n"+
                "\\                  /     |\n"+
                " \\                /      |\n" +
                " \\                /      |\n" +
                "  \\              /\t  "+milk+"\n"  +
                "  \\              /       |\n"  +
                "   \\            /---------\n"   +
                m   +
                l+
                "    \\----------/\n\nAirate milk for "+steam+" seconds");      
    }
    
    /**
     * Determines name of drink.
     * @return Name of drink
     */
    public String name()
    {
        Scanner s = new Scanner(syrup);
        String z = "Grande", t = "", y = "", m = "", c = "", e = "",
        d = "Latte", w = "";
        switch(size)
        {
            case 's':   z = "Short";    break;
            case 't':   z = "Tall";     break;
            case 'g':   z = "Grande";   break;
            case 'v':   z = "Venti";
        }
        if(dt == false)
            switch(shots)
            {
                case 1: t = "Single";   break;
                case 2: t = "Double";   break;
                case 3: t = "Triple";   break;
                case 4: t = "Quadruple";break;
                case 5: t = "Quintuple";break;
                case 6: t = "Sextuple"; break;
                case 7: t = "Septuple"; break;
                case 8: t = "Octuple";  break;
                default: t = Integer.toString(shots) + " shot";
            }
        if(dy2 == false) y = Integer.toString(s.nextInt())+" pump ";
        if(dy1 == false) y += syrup1;
        if(dy3 == true)  y = syrup;
        if(dm == false)  m = (milk.equals("Non-fat milk"))?"Non-fat":milk;
        if(dc == false)
        {
            if     (caf == .5)              c = "half caf";
            else if(caf == 0)               c = "decaf";
            else if(caf < .34 && caf > .32) c = "1/3 caf";
            else if(caf < .67 && caf > .65) c = "2/3 caf";
            else if(caf == .25)             c = "1/4 caf";
            else if(caf == .75)             c = "3/4 caf";
            else                c = Double.toString(caf)+" caf";
        }
        if(er == true)   e = ER;
        switch(l)
        {
            case 'l':   d = "Latte";    break;
            case 'c':   d = "Cappucino";
                switch(steam)
                {
                    case 10:    w = "wet";  
                    case 15:                break;
                    case 20:    w = "dry";  
                }
        }
        return t+" "+z+" "+c+" "+m+" "+y+" "+w+" "+d+e;
    }
    
    public void setSteam(int n) {steam = n;}
    public void setDrink(char b) {l = b;}
}