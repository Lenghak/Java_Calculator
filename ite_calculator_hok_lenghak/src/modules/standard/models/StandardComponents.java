package modules.standard.models;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.HashMap;

public class StandardComponents {

    //STRING PROPERTY for naming button
    public static final String[] STATIC_OPERATOR = {"AC", "C", ".", "+/_", "%"};
    public static final String[] OPERATOR = {"+", "-", "/", "=", "*"};

    public static final String[] SET_OPERATOR = {"U", "~U", "_", ","};
    public static final String[] BIN_OPERATOR = {"<<", ">>", "AND", "OR", "XOR", "A", "B", "C", "D", "E", "F"};
    public static final String[] UPPER_OPERATOR = {"2nd", "Hyp", "DEG"};

    protected final HashMap<String, JButton> numButtons = new HashMap<>();
    protected final HashMap<String, JButton> opButtons = new HashMap<>();
    protected final HashMap<String, JButton> staticButtons = new HashMap<>();
    protected final HashMap<String, JButton> allButtons = new HashMap<>();

    protected final HashMap<String, JPanel> extNumButtons = new HashMap<>();
    protected final HashMap<String, JPanel> extOpButtons = new HashMap<>();
    protected final HashMap<String, JPanel> extStaticButtons = new HashMap<>();
    protected final HashMap<String, JPanel> extAllButtons = new HashMap<>();

    public void putNumButton(String key, JButton button) {
        numButtons.put(key, button);
        allButtons.put(key, button);
    }

    public void putOpButton(String key, JButton button) {
        opButtons.put(key, button);
        allButtons.put(key, button);
    }

    public void putStaticButton(String key, JButton button) {
        staticButtons.put(key, button);
        allButtons.put(key, button);
    }

    public void putExtNumButton(String key, JPanel container) {
        extNumButtons.put(key, container);
        extAllButtons.put(key, container);
    }

    public void putExtOpButton(String key, JPanel container) {
        extOpButtons.put(key, container);
        extAllButtons.put(key, container);
    }

    public void putExtStaticButton(String key, JPanel container) {
        extStaticButtons.put(key, container);
        extAllButtons.put(key, container);
    }

    public JButton getNumButton(String key) {
        return numButtons.get(key);
    }

    public JButton getOpButton(String key) {
        return opButtons.get(key);
    }

    public JButton getStaticButton(String key) {
        return staticButtons.get(key);
    }

    public HashMap<String, JPanel> getExtStaticButtons() {
        return extStaticButtons;
    }

    public HashMap<String, JPanel> getExtNumButtons() {
        return extNumButtons;
    }

    public HashMap<String, JPanel> getExtOpButtons() {
        return extOpButtons;
    }

    public HashMap<String, JPanel> getExtAllButtons() {
        return extAllButtons;
    }

    public HashMap<String, JButton> getAllButtons() {
        return allButtons;
    }

}
