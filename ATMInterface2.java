import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface2 extends JFrame {
    private BankAccount bankAccount;

    public ATMInterface2(BankAccount bankAccount) {
        this.bankAccount = bankAccount;

        setTitle("ATM Interface");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel header = new JPanel();
        JLabel label = new JLabel();
        label.setText("Welcome to Digital Era!");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.BOLD, 35));
        header.add(label);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setFocusable(false);
        JButton depositButton = new JButton("Deposit");
        depositButton.setFocusable(false);
        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setFocusable(false);
        JButton accountDetails = new JButton("Account Details");
        accountDetails.setFocusable(false);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
                double amount = Double.parseDouble(input);
                bankAccount.withdraw(amount);
                JOptionPane.showMessageDialog(null, "Withdrawal successful.");
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter deposit amount:");
                double amount = Double.parseDouble(input);
                bankAccount.deposit(amount);
                JOptionPane.showMessageDialog(null, "Deposit successful.");
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Current Balance: $" + bankAccount.getBalance());
            }
        });

        accountDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new JFrame();
                frame1.setTitle("Account Details");
                frame1.setSize(300, 200);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);
                JPanel bankHeader = new JPanel();
                JLabel label = new JLabel();
                label.setText("Your Account Details");
                label.setFont(new Font("MV Boli", Font.BOLD, 25));
                bankHeader.add(label);

                JPanel holderDetails = new JPanel();
                holderDetails.add(new JLabel("Account Number: " + bankAccount.getAccountNumber()));
                holderDetails.add(new JLabel("Account Holder Name :" + bankAccount.getAccountHolderName()));
                holderDetails.add(new JLabel("Current Balance : " + bankAccount.getBalance()));

                frame1.setLayout(new BorderLayout());
                frame1.add(bankHeader, BorderLayout.NORTH);
                frame1.add(holderDetails, BorderLayout.CENTER);
            }
        });

        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(checkBalanceButton);
        panel.add(accountDetails);

        setLayout(new BorderLayout());
        add(header, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.0);
        ATMInterface2 atmInterface = new ATMInterface2(account);
        atmInterface.setVisible(true);
    }
}




