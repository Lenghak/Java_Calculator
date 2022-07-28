package modules.scientific.models;

import modules.standard.models.StandardComponents;

import javax.swing.*;
import java.util.HashMap;

public class ScientificComponents extends StandardComponents {

    public static final String[] SCI_OPERATOR = {
                            "tan", "sin", "cos", "cot",
                            "1/X", "√", "^√", "mod",
                            "X!", "|X|", "X^", "X^2",
                            "logX", "lnX", "10^x", "e^x",
                            "(", ")", "π", "e",
                            "atan", "asin", "acos", "cot",
                            "sinh", "cosh", "tanh", "coth",
                            "asinh", "acosh", "atanh", "acoth"};

    protected final HashMap<String, JButton> sciButtons = new HashMap<>();

    protected final HashMap<String, JPanel> extSciButtons = new HashMap<>();

    public void putSciButton(String key, JButton button) {
        sciButtons.put(key, button);
        allButtons.put(key, button);
    }

    public void putExtSciButton(String key, JPanel container){
        extSciButtons.put(key, container);
        extAllButtons.put(key, container);
    }

    public HashMap<String, JButton> getSciButtons() {
        return sciButtons;
    }

    public HashMap<String, JPanel> getExtSciButtons() {
        return extSciButtons;
    }
}
