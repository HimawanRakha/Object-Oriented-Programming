import javax.swing.*; 
import java.awt.*;      
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel userLabel, passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

 
    public LoginFrame() {
       
        setTitle("Form Login"); 
        setSize(350, 200);    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));

        userLabel = new JLabel("Username:");
        userField = new JTextField();
    
        passLabel = new JLabel("Password:");
        passField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(this); 

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel()); 
        panel.add(loginButton);
   
        add(panel);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource() == loginButton) {
            String username = userField.getText();
            String password = new String(passField.getPassword()); 

         
            if (username.equals("rakha") && password.equals("bhadra")) {
       
                JOptionPane.showMessageDialog(this, "Login Berhasil! Selamat datang, " + username);
            } else {
              
                JOptionPane.showMessageDialog(this, "Login Gagal! Username atau Password salah.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

 
    public static void main(String[] args) {
  
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame();
            }
        });
    }
}