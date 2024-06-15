package unitconverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter {
    private JFrame frame;
    private JLabel inputLabel, outputLabel;
    private JTextField input;
    private JTextField output;

    private JComboBox<String> fromUnit;
    private JComboBox<String> toUnit;

    private JButton convertButton;

    protected void initComponent(){
        frame = new JFrame("Unit Converter");
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        inputLabel = new JLabel("Input: ");
        input = new JTextField(10);
        outputLabel = new JLabel("Output: ");
        output = new JTextField(10);
        output.setEditable(false);

        fromUnit = new JComboBox<String>(new String[] {"m", "ft", "in", "cm"});
        toUnit = new JComboBox<String>(new String[] {"m", "ft", "in", "cm"});

        convertButton = new JButton("Convert");

        inputLabel.setBounds(20,20, 100, 20);
        input.setBounds(150, 20, 100, 20);
        fromUnit.setBounds(270, 20, 50,20);
        outputLabel.setBounds(20, 50, 100, 20);
        output.setBounds(150, 50, 100, 20);
        toUnit.setBounds(270, 50, 50, 20);
        convertButton.setBounds(150, 80, 100, 20);

        convertButton.addActionListener(new ConvertButtonListener());

        frame.add(inputLabel);
        frame.add(input);
        frame.add(fromUnit);
        frame.add(outputLabel);
        frame.add(output);
        frame.add(toUnit);
        frame.add(convertButton);

        frame.setVisible(true);
    }

    //constructor
    public UnitConverter() {
        initComponent();
    }

    public static void main(String[] args){
        new UnitConverter();
    }

    private class ConvertButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String fromUnitType = fromUnit.getSelectedItem().toString();
            String toUnitType = toUnit.getSelectedItem().toString();
            double inputValue = Double.parseDouble(input.getText());
            double outputValue = 0.0;

            switch (fromUnitType) {
                case "m" -> {
                    switch (toUnitType) {
                        case "m" -> outputValue = UnitConverter.metersToMeters(inputValue);
                        case "cm" -> outputValue = UnitConverter.metersToCentimeters(inputValue);
                        case "ft" -> outputValue = UnitConverter.metersToFeet(inputValue);
                        case "in" -> outputValue = UnitConverter.metersToInches(inputValue);
                    }
                }
                case "cm" -> {
                    switch (toUnitType) {
                        case "m" -> outputValue = UnitConverter.centimetersToMeters(inputValue);
                        case "cm" -> outputValue = UnitConverter.centimetersToCentimeters(inputValue);
                        case "ft" -> outputValue = UnitConverter.centimetersToFeet(inputValue);
                        case "in" -> outputValue = UnitConverter.centimetersToInches(inputValue);
                    }
                }
                case "ft" -> {
                    switch (toUnitType) {
                        case "m" -> outputValue = UnitConverter.feetToMeters(inputValue);
                        case "cm" -> outputValue = UnitConverter.feetToCentimeters(inputValue);
                        case "ft" -> outputValue = UnitConverter.feetToFeet(inputValue);
                        case "in" -> outputValue = UnitConverter.feetToInches(inputValue);
                    }
                }
                case "in" -> {
                    switch (toUnitType) {
                        case "m" -> outputValue = UnitConverter.inchesToMeters(inputValue);
                        case "cm" -> outputValue = UnitConverter.inchesToCentimeters(inputValue);
                        case "ft" -> outputValue = UnitConverter.inchesToFeet(inputValue);
                        case "in" -> outputValue = UnitConverter.inchesToInches(inputValue);
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + fromUnitType);
            }
            output.setText(""+outputValue);
        }
    }

    public static double metersToMeters(double inputValue){
        double outputValue;
        outputValue = inputValue;
        return outputValue;
    }

    public static double metersToCentimeters(double inputValue) {
        double outputValue;
        outputValue = inputValue*100;
        return outputValue;
    }

    public static double metersToFeet(double inputValue) {
        double outputValue;
        outputValue = inputValue*3.28084;
        return outputValue;
    }

    public static double metersToInches(double inputValue) {
        double outputValue;
        outputValue = inputValue*3.28084*12;
        return outputValue;
    }

    public static double centimetersToMeters(double inputValue){
        double outputValue;
        outputValue = inputValue/100;
        return outputValue;
    }

    public static double centimetersToCentimeters(double inputValue) {
        double outputValue;
        outputValue = inputValue;
        return outputValue;
    }

    public static double centimetersToFeet(double inputValue) {
        double outputValue;
        outputValue = inputValue/100*3.28084;
        return outputValue;
    }

    public static double centimetersToInches(double inputValue) {
        double outputValue;
        outputValue = inputValue/100*3.28084*12;
        return outputValue;
    }

    public static double feetToMeters(double inputValue){
        double outputValue;
        outputValue = inputValue/3.28084;
        return outputValue;
    }

    public static double feetToCentimeters(double inputValue) {
        double outputValue;
        outputValue = inputValue/3.28084*100;
        return outputValue;
    }

    public static double feetToFeet(double inputValue) {
        double outputValue;
        outputValue = inputValue;
        return outputValue;
    }

    public static double feetToInches(double inputValue) {
        double outputValue;
        outputValue = inputValue*12;
        return outputValue;
    }

    public static double inchesToMeters(double inputValue){
        double outputValue;
        outputValue = inputValue/12/3.28084;
        return outputValue;
    }

    public static double inchesToCentimeters(double inputValue) {
        double outputValue;
        outputValue = inputValue/12/3.28084*100;
        return outputValue;
    }

    public static double inchesToFeet(double inputValue) {
        double outputValue;
        outputValue = inputValue/12;
        return outputValue;
    }

    public static double inchesToInches(double inputValue) {
        double outputValue;
        outputValue = inputValue;
        return outputValue;
    }
}
