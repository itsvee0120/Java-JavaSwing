import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginGUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField password;
    private static JButton button;
    private static JLabel success;

    public static void main(String[] args) {

        // Frame & panel set up
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 200);  // Increased size to fit all components
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        // Panel setting
        panel.setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(100, 50, 165, 25);
        panel.add(password);

        button = new JButton("Login");
        button.setBounds(200, 80, 80, 25);
        button.addActionListener(new LoginGUI());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(90, 110, 300, 25);
        panel.add(success);

        // Set frame visibility
        frame.setVisible(true);
    }

    // Code that runs every time button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        char[] passwordGet = password.getPassword();

        // Printing credentials to the console for debugging (optional)
        System.out.println(user + ", " + Arrays.toString(passwordGet));

        // Correct password check using Arrays.equals()
        if (user.equals("n") && Arrays.equals(passwordGet, "123".toCharArray())) {
            success.setText("Login successful!");
        } else if (user.isBlank() || passwordGet.length == 0) {
            success.setText("Enter your credentials to login");
        } else {
            success.setText("Wrong Credentials");
        }
    }
}
