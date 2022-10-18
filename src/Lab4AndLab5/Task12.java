package Lab4AndLab5;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task12 extends Component {
    JButton button;
    JLabel titleLabel, nameLabel, numberLabel, cityLabel, informationLabel;
    JRadioButton kyivRadioButton, kharkivRadioButton, odesaRadioButton;
    JTextField nameInput, mobileInput;
    JTextArea textArea;
    JLabel iconLabel;

    private void run() {
        JFrame window = createWindow();
        window.setVisible(true);
    }

    private JFrame createWindow() {
        JFrame frame = new JFrame("Laba 4-5");
        frame.getContentPane().add(createPanel());
        frame.pack();
        frame.setSize(600, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        // panel.setLayout(null);

        //Phone icon add
        ImageIcon iconLogo = new ImageIcon("C:\\Repositories\\Java_Programming_v.4.0\\src\\Lab4AndLab5\\call.png");
        iconLabel = new JLabel("1");
        iconLabel.setIcon(iconLogo);
        iconLabel.setBounds(20, 20, 50, 50);
        panel.add(iconLabel);

        Color textColor = new Color(227, 108, 10, 255);
        //Замовити зв'язок
        titleLabel = new JLabel("Замовити зворотній зв'язок");
        titleLabel.setBounds(220, 20, 300, 40);
        titleLabel.setForeground(textColor);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(titleLabel);

        //Місто
        cityLabel = new JLabel("Місто:");
        cityLabel.setBounds(20, 130, 80, 60);
        cityLabel.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(cityLabel);

        //Radio btns
        kyivRadioButton = new JRadioButton("Київ");
        kharkivRadioButton = new JRadioButton("Харків");
        odesaRadioButton = new JRadioButton("Одеса");

        kyivRadioButton.setBounds(100, 120, 100, 25);
        kyivRadioButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        kharkivRadioButton.setBounds(100, 150, 100, 25);
        kharkivRadioButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        odesaRadioButton.setBounds(100, 180, 100, 25);
        odesaRadioButton.setFont(new Font("SansSerif", Font.PLAIN, 16));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(kyivRadioButton);
        buttonGroup.add(kharkivRadioButton);
        buttonGroup.add(odesaRadioButton);

        panel.add(kyivRadioButton);
        panel.add(kharkivRadioButton);
        panel.add(odesaRadioButton);

        //Name and mobile number labels
        nameLabel = new JLabel("Ваше ім'я:");
        nameLabel.setBounds(250, 110, 100, 30);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(nameLabel);

        numberLabel = new JLabel("Телефон:");
        numberLabel.setBounds(250, 170, 100, 30);
        numberLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(numberLabel);

        //Name and mobile number inputs
        nameInput = new JTextField("David");
        nameInput.setBounds(350, 110, 200, 40);
        panel.add(nameInput);

        mobileInput = new JTextField("+919367788755");
        mobileInput.setBounds(350, 170, 200, 40);
        panel.add(mobileInput);

        //Border label
        JLabel borderLabel = new JLabel("");
        borderLabel.setBounds(30, 250, 500, 40);
        borderLabel.setBorder(new MatteBorder(new Insets(0, 0, 4, 0), Color.green.darker()));
        panel.add(borderLabel);

        //Text area
        informationLabel = new JLabel("Додаткова інформація:");
        informationLabel.setBounds(30, 330, 200, 30);
        informationLabel.setFont(new Font("Serif", Font.ITALIC, 16));
        panel.add(informationLabel);

        textArea = new JTextArea();
        textArea.setBounds(30, 365, 500, 100);
        panel.add(textArea);

        //Кнопка
        button = new JButton("Надіслати");
        button.setBounds(180, 500, 180, 35);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(new Font("Serif", Font.BOLD, 18));
        button.addActionListener(this::actionPerformed);
        panel.add(button);

        panel.setLayout(null);
        panel.setVisible(true);
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        Pattern checkLetters = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher1 = checkLetters.matcher(nameInput.getText());

        Pattern checkNumbers = Pattern.compile("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$");
        Matcher matcher2 = checkNumbers.matcher(mobileInput.getText());

        if (!kyivRadioButton.isSelected() && !odesaRadioButton.isSelected() && !kharkivRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Оберіть місто!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (nameInput.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Введіть ім'я!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (mobileInput.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Введіть номер!", "Error", JOptionPane.ERROR_MESSAGE);
        }
//        else if ((nameInput.getText().trim().isEmpty() || mobileInput.getText().trim().isEmpty()) || (nameInput.getText().trim().isEmpty() && mobileInput.getText().trim().isEmpty())) {
//            errorLabel.setText("Заповніть поля!");
//        }
        else if (!matcher1.matches()) {
            JOptionPane.showMessageDialog(this, "Тільки літери A-Z a-z!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!matcher2.matches()) {
            JOptionPane.showMessageDialog(this, "Некорректний формат номеру!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ми зв’яжемось з вами найближчим \n" + "часом", "Message", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Task12().run());
    }
}
