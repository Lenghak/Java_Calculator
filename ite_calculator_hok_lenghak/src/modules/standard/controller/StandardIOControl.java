package modules.standard.controller;

import helper.controller.SyntaxCtrl;
import modules.standard.models.StandardIOData;
import modules.standard.view.StandardIOView;
import org.jetbrains.annotations.NotNull;
import resource.font.QuickSand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.HashMap;

public class StandardIOControl implements ComponentListener, ActionListener, MouseListener {

    private ComponentEvent event;

    private final StandardIOView ioView = new StandardIOView();     //ioView working with the view of the StandardIOData section
    private final StandardIOData ioData = new StandardIOData();     //ioData use for working in the calculation process

    private HashMap<String, JPanel> disableButton;

    private Color oldColor;             //old color of the button
    private float newOFS = 0;
    private float newIFS = 0;

    private String op;


    private boolean eqlClicked = false;   //state of eql button click
    private boolean opClicked = false;   //state of the click of operands
    private boolean numAfterOpClicked = false;   //state for the num input after an op is clicked

    protected boolean buttonDisable = false;

    public void createView() {
        ioView.createView();
    }


    protected String calculate(String first, String second, String op) {
        return StandardCalculation.calculate(first, second, op);
    }


    public JPanel getIOPanel() {
        return ioView.getIOPanel();
    }


    public void setComponentListener() {

        this.ioView.getOutputField().addComponentListener(this);
        this.ioView.getInputField().addComponentListener(this);

        this.ioView.getInputField().setName("input_label");
        this.ioView.getOutputField().setName("output_label");

    }


    public void setDisableButton(HashMap<String, JPanel> disableButton) {
        this.disableButton = disableButton;
    }


    private void setInput(@NotNull String string){

        try {


            if (string.lastIndexOf(".") != string.length() - 1) {

                if (string.contains(",")) string = string.replace(",", "");

                string = (string.contains("E")) ? new DecimalFormat("#.###############E0").format(Double.parseDouble(string))
                        : new DecimalFormat(",###.###############").format(Double.parseDouble(string));

            }
        } catch (Exception e){

            string = "Overflow";

            buttonDisable = true;
            disableButton.forEach((name, container) -> container.getComponent(0).setEnabled(false));

        }

        ioView.setInput(string);
        ioData.input = string;
        componentResized(event);

    }


    private String getInput(){
        return ioView.getInputField().getText();
    }


    private void setOutput(String string, boolean check){
        ioView.setOutput((check) ? SyntaxCtrl.negativeHandler(string) : string);
    }

    private void clearAll(){
        ioView.clearAll();
        ioData.clearAll();

        opClicked = false;
        numAfterOpClicked = false;
        eqlClicked = false;
        op = null;
    }


    private void changeFontSize(@NotNull JTextField label, float newSize){

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        int size;

        float ratio = Float.parseFloat(decimalFormat.format((float) (label.getWidth())
                / (label.getFontMetrics(label.getFont()).getStringBounds(label.getText(), label.getGraphics()).getWidth() + 20)));


        float oldSize = (label.getFont().getSize() - 1) * (ratio);

        size = (int) Math.floor( ((oldSize + newSize) / 2));

        label.setFont(QuickSand.getFont(Font.BOLD, size));
    }

    /**
     * button pressed configuration in color
     */
    @Override
    public void mousePressed(@NotNull MouseEvent e) {
        JButton button = (JButton) e.getSource();
        oldColor = button.getParent().getBackground();
        button.getParent().setBackground(button.getParent().getBackground().brighter());
    }


    /**
     * customize the button back to the original state after release
     */
    @Override
    public void mouseReleased(@NotNull MouseEvent e) {
        JButton button = (JButton) e.getSource();
        button.getParent().setBackground(oldColor);
        button.getParent().repaint();
        button.getParent().revalidate();
    }


    /**
     * Resizing the frame of the component included output and input string and the buttons string
     */
    @Override
    public void componentResized(@NotNull ComponentEvent e) {

        JTextField field = (JTextField) e.getComponent();

        if (field.getName().equals("output_label") || field.getText() == null) {

            changeFontSize(field, newOFS);

            if (field.getFont().getSize() >= 20)
                field.setFont(QuickSand.getFont(Font.BOLD, 20));

            else if (field.getFont().getSize() <= 9)
                field.setFont(QuickSand.getFont(Font.BOLD, 9));

            newOFS = field.getFont().getSize();

        } else if (field.getName().equals("input_label") && field.getText() != null) {

            changeFontSize(field, newIFS);

            if (field.getFont().getSize() >= 35)
                field.setFont(QuickSand.getFont(Font.BOLD, 35));

            else if (field.getFont().getSize() <= 15)
                field.setFont(QuickSand.getFont(Font.BOLD, 15));

            newIFS = field.getFont().getSize();
        }

        e.getComponent().repaint();
        e.getComponent().revalidate();

        event = e;
    }


    @Override
    public void actionPerformed(@NotNull ActionEvent e) {

        JButton button = (JButton) e.getSource();     //get the source of the event source

        //state of multiple op (op + num + op)
        boolean multipleState = opClicked && numAfterOpClicked;    //set the multipleState which is generated for multiple cal

        switch (button.getParent().getName()) {

            case "num" -> {

                //if there was an exception, enable back the buttons
                if (buttonDisable){
                    disableButton.forEach((name, container) -> container.getComponent(0).setEnabled(true));
                    buttonDisable = false;
                }

                //check if there is already an output before allowing another input
                if (eqlClicked) {  //if we click "=" and then an op before clicking a number, clear all
                    clearAll();
                }

                //check if there is an op has been clicked. If true, before printing more input, clear the input first
                if (opClicked && !multipleState){   //but if the multiple state are true clearing is not necessary
                    ioView.clearInput();
                    numAfterOpClicked = true;
                }


                //before set the input, check if the first number is 0 or " ". If true, clear it out
                if ((getInput().charAt(0) == '0' || getInput().charAt(0) == ' ') && !getInput().contains("."))
                    setInput(getInput().substring(1) + button.getText());

                    //set the view with the clicked number limited in 15 character
                else if (getInput().length() < 19) setInput(getInput() + button.getText());
            }

            case "op" -> {


                if (button.getText().equals("=")){

                    //when the "=" is clicked, paste what's in the input field to the second number for calculation
                    if (eqlClicked) {
                        ioData.firstNumber = ioData.result; //give the remaining result to the first number and remain second the same
                    } else ioData.secondNumber = getInput();    //else give the second number as the input
                    // since we already have the first number from when we click on an op

                    ioData.result = calculate(ioData.firstNumber, ioData.secondNumber, op); //calculate the result

                    //after the calculation, print the result inside the input field and the calculated operands to the output field
                    setOutput((op != null) ? ioData.firstNumber + " " + op + " " + ioData.secondNumber + " ="
                            : getInput() + " =", op != null);
                    setInput(ioData.result);    //set the result to the input

                    //reset all the states for a new calculation
                    eqlClicked = true;
                    opClicked = false;
                    numAfterOpClicked = false;

                } else {

                    //set the op
                    opClicked = true;


                    //if an "=" is not clicked, and also not a multi-state
                    //if the multi-state happen, we already have an op and a first number
                    if (multipleState && !eqlClicked){
                        ioData.secondNumber = getInput();   //give the input to the second for calculating
                        ioData.result = calculate(ioData.firstNumber, ioData.secondNumber, op); //calculate the result
                        ioData.firstNumber = ioData.result; //give the result to the first number

                        op = button.getText();  //get the op
                        setOutput(ioData.result + " " + op, false); //print out operands
                        setInput(ioData.result);               //print the result

                        numAfterOpClicked = false;      //set the numClick to false since we have clicked a new op

                    } else {    // if the multiple state is not on

                        op = button.getText();  //get the op from the button
                        ioView.setOutput(getInput() + " " + op);    //print out the output pattern
                        ioData.firstNumber = getInput();        //give the input to the first number
                    }    //** this is where we don't have to worry about the first number when we are in the multi-state**//

                    eqlClicked = false; //set the equal state to false since we already click another op

                }

            }

            case "static" -> {

                switch (button.getText()){

                    case "AC" -> clearAll();

                    case "C" -> {
                        if (eqlClicked)
                            clearAll();
                        else ioView.clearInput();
                    }

                    case "%" -> {
                        String result = calculate(getInput(), null, "%");
                        setOutput(getInput() + "% =", false);
                        setInput(result);
                    }

                    case "." -> {

                        if (eqlClicked){
                            setInput("0.");
                        }

                        if (!getInput().contains(".")){
                            setInput(getInput() + ".");
                        }
                    }

                    case "+/_" -> setInput((getInput().charAt(0) != '-')
                            ? "-".concat(getInput())
                            : getInput().substring(1));
                }
            }
        }
    }


    //------------ UNUSED METHODS --------------------------------------------------------------------------------------
    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseClicked(@NotNull MouseEvent e) {

    }

    //------------------------------------------------------------------------------------------------------------------
}

