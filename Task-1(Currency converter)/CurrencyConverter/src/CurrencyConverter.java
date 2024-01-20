import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JTextField amountField;
    private JComboBox<String> fromCurrencyBox;
    private JComboBox<String> toCurrencyBox;
    private JLabel resultLabel;

    public CurrencyConverter() {
        
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        amountField = new JTextField(10);
        fromCurrencyBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR"});
        toCurrencyBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR"});
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        
        add(new JLabel("Amount: "));
        add(amountField);
        add(new JLabel("From Currency: "));
        add(fromCurrencyBox);
        add(new JLabel("To Currency: "));
        add(toCurrencyBox);
        add(convertButton);
        add(resultLabel);

       
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
      
        double amount = Double.parseDouble(amountField.getText());
        String fromCurrency = (String) fromCurrencyBox.getSelectedItem();
        String toCurrency = (String) toCurrencyBox.getSelectedItem();

   
        double result = amount * getConversionRate(fromCurrency, toCurrency);

       
        resultLabel.setText("Result: " + result);
    }

 
    private double getConversionRate(String fromCurrency, String toCurrency) {
    
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return 0.92;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            return 0.79;
        }else if(fromCurrency.equals("USD") && toCurrency.equals("INR")) {
            return 83.12;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return 1.09;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("GBP")) {
            return 0.86;
        }else if (fromCurrency.equals("EUR") && toCurrency.equals("INR")) {
            return 90.73;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
            return 1.27;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("EUR")) {
            return 1.16;
        }else if (fromCurrency.equals("GBP") && toCurrency.equals("INR")) {
            return 105.60;
        }else if (fromCurrency.equals("INR") && toCurrency.equals("USD")) {
            return 0.012;
        }else if (fromCurrency.equals("INR") && toCurrency.equals("EUR")) {
            return 0.011;
        }else if (fromCurrency.equals("INR") && toCurrency.equals("GBP")) {
            return 0.0095;
        }else
        {
            return 1.0;
        }
    }
}
