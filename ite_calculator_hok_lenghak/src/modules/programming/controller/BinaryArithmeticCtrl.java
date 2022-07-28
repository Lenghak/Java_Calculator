package modules.programming.controller;

import modules.programming.view.BinaryArithmeticLayoutView;
import modules.programming.view.BinaryArithmeticIOView;

public class BinaryArithmeticCtrl {

    private String input;
    private String output;

    private BinaryArithmeticLayoutView binaryArithmeticLayoutView = new BinaryArithmeticLayoutView();
    private BinaryArithmeticIOView binaryArithmeticIOView = new BinaryArithmeticIOView();

    public void binaryArithmetic(){}

    public void bitwiseCal(){}

    public void setInput(String input) {
        this.input = input;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public void showResult(){}

    public void showInput(){}
}
