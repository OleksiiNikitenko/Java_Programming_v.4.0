package Lab6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class lab6 extends Canvas {
    static JFrame frame;
    private static Color rectColor = Color.orange;
    static boolean drawPaint = true;
    static boolean removePaint = false;
    static boolean addDiagonalPaint = false;
    private static Color bgColor = Color.white;

    public void paint(Graphics g) {
        super.paint(g);
        if (drawPaint) {
            g.setColor(bgColor);
            g.fillRect(0, 0, 600, 600);
            g.drawRect(10, 10, 200, 100);
            g.setColor(rectColor);
            g.fillRect(10, 10, 200, 100);
        }

        if (removePaint) {
            g.clearRect(0, 0, 500, 500);
        }

        if (addDiagonalPaint) {
            g.setColor(Color.BLACK);
            g.drawLine(10, 10, 210, 110);
        }
    }

    public static void main(String[] args) {
        lab6 rect = new lab6();
        frame = new JFrame();
        frame.setTitle("Lab 6");
        frame.getContentPane().setBackground(Color.white);

        //Введення сторони
        JLabel sideLabel = new JLabel("Введіть сторони: ");
        sideLabel.setBounds(10, 150, 250, 50);
        frame.add(sideLabel);

        JTextField sideTextfield1 = new JTextField("2");
        sideTextfield1.setBounds(130, 160, 50, 30);
        frame.add(sideTextfield1);

        JTextField sideTextField2 = new JTextField("4");
        sideTextField2.setBounds(190, 160, 50, 30);
        frame.add(sideTextField2);

        //Кнопка розрахунку площі, периметра та довжини діагоналі
        JButton secondFormButton = new JButton("Отримати результат");
        secondFormButton.setBounds(250, 160, 150, 30);
        secondFormButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rectSide1 = Integer.parseInt(sideTextfield1.getText());
                int rectSide2 = Integer.parseInt(sideTextField2.getText());
                int rectArea = rectSide1 * rectSide2;
                int rectPerimetr = 2 * (rectSide1 + rectSide2);
                double diagonalLength = Math.sqrt(Math.pow(rectSide1, 2) + Math.pow(rectSide2, 2));
                JOptionPane.showMessageDialog(frame, "Rectangle area = " + rectArea + "\nRectangle perimetr = " + rectPerimetr + "\n Diagonal length = " + diagonalLength);
                System.exit(0);
            }
        });
        frame.add(secondFormButton);

        //Головне меню
        JMenuBar mainMenu = new JMenuBar();
        JMenu programMenu = new JMenu("Програма");
        JMenu fileMenu = new JMenu("Правка");

        //Програма меню
        JMenuItem changeBG = new JMenuItem("Змінити фон");
        JMenuItem countRect = new JMenuItem("Обчислити");
        JMenuItem exitProgram = new JMenuItem("Вийти");

        programMenu.add(changeBG);
        programMenu.add(countRect);
        programMenu.addSeparator();
        programMenu.add(exitProgram);

        //Функционал
        changeBG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color randColor = new java.awt.Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
                frame.getContentPane().setBackground(randColor);
                bgColor = randColor;
            }
        });

        countRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rectSide1 = Integer.parseInt(sideTextfield1.getText());
                int rectSide2 = Integer.parseInt(sideTextField2.getText());
                int rectArea = rectSide1 * rectSide2;
                int rectPerimetr = 2 * (rectSide1 + rectSide2);
                double diagonalLength = Math.sqrt(Math.pow(rectSide1, 2) + Math.pow(rectSide2, 2));
                JOptionPane.showMessageDialog(frame, "Rectangle area = " + rectArea + "\nRectangle perimetr = " + rectPerimetr + "\n Diagonal length = " + diagonalLength);
                //System.exit(0);
            }
        });

        exitProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Правка меню
        JMenuItem copyMenu = new JMenuItem("Копіювати");
        JMenuItem pasteMenu = new JMenuItem("Вставити");

        fileMenu.add(copyMenu);
        fileMenu.add(pasteMenu);

        mainMenu.add(programMenu);
        mainMenu.add(fileMenu);

        frame.add(mainMenu);
        frame.setJMenuBar(mainMenu);

        //Контекстне меню
        JPopupMenu contextMenu = new JPopupMenu();

        JMenuItem repaintAll = new JMenuItem("Перефарбувати");
        JMenuItem deleteAll = new JMenuItem("Видалити");
        JMenuItem diagonalAdd = new JMenuItem("Діагональ");

        contextMenu.add(repaintAll);
        contextMenu.add(deleteAll);
        contextMenu.add(diagonalAdd);

        frame.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent me) {
                if (me.isPopupTrigger()) contextMenu.show(me.getComponent(), me.getX(), me.getY());
            }
        });

        repaintAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rectColor = Color.YELLOW;
                frame.repaint();
            }
        });

        deleteAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPaint = false;
                removePaint = true;
                addDiagonalPaint = false;
                frame.repaint();
            }
        });

        diagonalAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPaint = true;
                removePaint = false;
                addDiagonalPaint = true;
                frame.repaint();
            }
        });

        frame.add(rect);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
