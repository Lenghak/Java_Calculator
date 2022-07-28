package modules.standard.controller;

import modules.standard.models.StandardComponents;
import org.jetbrains.annotations.NotNull;
import modules.standard.view.StandardComponentView;
import resource.font.QuickSand;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.*;
import java.util.HashMap;

public class StandardComponentControl implements ComponentListener{

    private final StandardComponentView componentView = new StandardComponentView();
    private final StandardComponents components = new StandardComponents();

    /**
     * Create the op buttons before adding them to the layout
     * */
    public void createOpButtons(){

        //create the operator buttons along with its view and add them into a collect
        for(int index = 0; index < StandardComponents.OPERATOR.length; index++){
            JButton button = new JButton();
            JPanel extButton;

            if (StandardComponents.OPERATOR[index].equals("=")) {
                extButton = createView(button, Color.decode("#FB5724"), Color.white,
                        "=", "op");
            }
            else {
                extButton = createView(button, Color.decode("#1D1D1D"),
                        Color.decode("#FB5724"), StandardComponents.OPERATOR[index], "op");

            }

            collectOp("Btn_" + button.getText(), button);
            collectExtOp("Btn_" + button.getText(), extButton);
        }

    }

    /**
     * Create the op buttons before adding them to the layout
     * */
    public void createNumButton(){
        //create the number button along with its view and add them into a collection inside the model class
        for(int index = 0; index < 10; index++){
            JButton button = new JButton();

            JPanel extButton =  createView(button, Color.decode("#1D1D1D"),
                    Color.white, String.valueOf(index), "num");

            collectNum("Btn_" + button.getText(), button);
            collectExtNum("Btn_" + button.getText(), extButton);
        }
    }


    /**
     * Create the static buttons before adding them to the layout
     * */
    public void createStaticButton(){
        //create the static buttons along with its view and add them into the collection inside the model class
        for (int index = 0; index < StandardComponents.STATIC_OPERATOR.length; index++){
            JButton button = new JButton();

            JPanel extButton = createView(button, Color.decode("#1D1D1D"),
                    (StandardComponents.STATIC_OPERATOR[index].equals("AC") || StandardComponents.STATIC_OPERATOR[index].equals("C"))
                            ? Color.decode("#36DABC") : Color.white, StandardComponents.STATIC_OPERATOR[index], "static");

            collectStatic("Btn_" + button.getText(), button);
            collectExtStatic("Btn_" + button.getText(), extButton);
        }
    }

    public void collectNum(String key, JButton button){
        components.putNumButton(key, button);
    }

    public void collectStatic(String key, JButton button){
        components.putStaticButton(key, button);
    }

    public void collectOp(String key, JButton button){
        components.putOpButton(key, button);
    }

    public void collectExtNum(String key, JPanel buttonPanel){
        components.putExtNumButton(key, buttonPanel);
    }

    public void collectExtStatic(String key, JPanel buttonPanel){
        components.putExtStaticButton(key, buttonPanel);
    }

    public void collectExtOp(String key, JPanel buttonPanel){
        components.putExtOpButton(key, buttonPanel);
    }

    public JPanel createView(JButton button, Color bg, Color fg, String text, String className){
        return componentView.createView(button, bg, fg, text, className);
    }

    public JPanel createView(JButton button, Color fg, String text, String className){
        return componentView.createView(button, fg, text, className);
    }

    public void setMouseListener(@NotNull JButton button, MouseListener listener) {
        button.addMouseListener(listener);
    }

    public void setMouseListener(@NotNull HashMap<String, JButton> buttons, MouseListener listener) {
        buttons.forEach((name, button) -> button.addMouseListener(listener));
    }

    public void setActionListener(@NotNull JButton button, ActionListener listener){
        button.addActionListener(listener);
    }

    public void setActionListener(@NotNull HashMap<String, JButton> buttons, ActionListener listener){
        buttons.forEach((name, button) -> button.addActionListener(listener));
    }

    public void setResizeListener(@NotNull Component component, ComponentListener listener){
        component.addComponentListener(listener);
    }

    public void setResizeListener(@NotNull HashMap<String, Component> button, ComponentListener listener){
        button.forEach((name, component) -> component.addComponentListener(listener));
    }

    public StandardComponentView getComponentView() {
        return componentView;
    }

    public StandardComponents getComponents(){
        return components;
    }

    public void setKeyAction(@NotNull JComponent jComponent){

        KeyAction action = new KeyAction();

        components.getAllButtons().forEach((name, button) -> jComponent.getInputMap().put(KeyStroke.getKeyStroke(name.charAt(4)), "keyAction"));

        jComponent.getInputMap().put(KeyStroke.getKeyStroke('\n'), "keyAction");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke('\b'), "keyAction");
        jComponent.getActionMap().put("keyAction", action);
    }


    private class KeyAction extends AbstractAction{


        @Override
        public void actionPerformed(@NotNull ActionEvent e) {

            String character = (e.getActionCommand().equals("\n")) ? "="
                    : (e.getActionCommand().equals("\b") ? "C" : e.getActionCommand());

            if (components.getExtAllButtons().get("Btn_" + character) != null
                    && components.getExtAllButtons().get("Btn_" + character) != null) {

                JPanel panel = components.getExtAllButtons().get("Btn_" + character);

                Color oldColor = panel.getBackground();
                panel.setBackground(panel.getBackground().brighter());
                components.getAllButtons().get("Btn_" + character).doClick();

                panel.setBackground(oldColor);

            }
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        if ((getComponents().getOpButton("Btn_=").getHeight() + getComponents().getOpButton("Btn_=").getWidth()) > (240))
            getComponents().getAllButtons().forEach((name, button) -> button.setFont(QuickSand.getFont(Font.BOLD, 22)));
        else getComponents().getAllButtons().forEach((name, button) -> button.setFont(QuickSand.getFont(Font.BOLD, 18)));
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}
}
