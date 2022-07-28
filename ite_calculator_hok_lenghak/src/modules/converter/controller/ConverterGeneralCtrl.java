package modules.converter.controller;

import modules.converter.view.ConverterLayoutView;
import modules.converter.view.ConverterIOView;

public abstract class ConverterGeneralCtrl {

    protected String input;
    protected String output;

    protected ConverterIOView ioView = new ConverterIOView();
    protected ConverterLayoutView converterBtnView = new ConverterLayoutView();

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public abstract void showResult();

    public abstract void showInput();


}
