package modules.standard.view;


import resource.font.QuickSand;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;

public class StandardIOView {

    protected final JTextField inputField = new JTextField();
    protected final JTextField outputField = new JTextField();

    protected final JPanel resultPanel = new JPanel();
    protected final JPanel inputPanel = new JPanel();
    protected final JPanel ioPanel = new JPanel();

    public void clearInput() {
        inputField.setText("0");
    }

    public void clearAll() {
        inputField.setText("0");
        outputField.setText(" ");
    }


    public void createView() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        inputPanel.setLayout(new BorderLayout());
        inputPanel.setOpaque(false);

        resultPanel.setLayout(new BorderLayout());
        resultPanel.setOpaque(false);


        outputField.setFocusable(false);
        outputField.setText(" ");
        outputField.setHorizontalAlignment(SwingConstants.RIGHT);
        outputField.setFont(QuickSand.getFont(Font.BOLD, 15));
        outputField.setForeground(Color.LIGHT_GRAY);
        outputField.setEditable(false);
        outputField.setOpaque(false);
        outputField.setBorder(BorderFactory.createEmptyBorder());


        inputField.setFocusable(false);
        inputField.setText("0");
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setFont(QuickSand.getFont(Font.BOLD, 35));
        inputField.setForeground(Color.white);
        inputField.setOpaque(false);
        inputField.setEditable(false);
        inputField.setBorder(BorderFactory.createEmptyBorder());

        inputPanel.add(inputField);
        resultPanel.add(outputField);

        ioPanel.setLayout(layout);
        ioPanel.setOpaque(false);
        ioPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridy = 0;
        ioPanel.add(resultPanel, gbc);

        gbc.gridy = 1;
        ioPanel.add(inputPanel, gbc);
        ioPanel.validate();

    }

    public void setInput(String text) {
        inputField.setText(text);
    }

    public void setOutput(String result) {
        outputField.setText(result);
    }

    public JPanel getIOPanel() {
        return ioPanel;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JTextField getOutputField() {
        return outputField;
    }
}
