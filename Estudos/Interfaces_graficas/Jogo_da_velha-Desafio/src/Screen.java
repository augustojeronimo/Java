import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Screen extends JFrame {
    Screen(){
        /* Tela */
        setTitle("Jogo da velha");
        setSize(800,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Painel de fundo */
        JPanel backgroundPanel = new JPanel();
        add(backgroundPanel);

        backgroundPanel.setLayout(null);

        backgroundPanel.setBackground(new Color(100,100,200));

        /* campo */
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        backgroundPanel.add(fieldPanel);

        int fieldSize = getHeight()-40;

        fieldPanel.setBounds(0,0,fieldSize,fieldSize);
        fieldPanel.setBackground(new Color(20,20,20));

        /* botões */
        JButton[][] button = new JButton[3][3];

        int size = fieldPanel.getHeight()/3;

        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {

                int positionX = l*size;
                int positionY = c*size;

                button[l][c] = new JButton(" ");
                int finalC = c;
                int finalL = l;
                button[l][c].addActionListener(e -> {click(button[finalL][finalC]);});

                button[l][c].setBounds(positionX,positionY,size,size);
                button[l][c].setBackground(new Color(0,0,0));
                button[l][c].setForeground(new Color(255,255,255));
                button[l][c].setFont(new Font(Font.MONOSPACED, Font.BOLD, 100));

                fieldPanel.add(button[l][c]);

            }
        }
    }

    private int count = 0;

    public void click(JButton btn){
        if (count % 2 == 0) {
            btn.setText("X");
        } else {
            btn.setText("O");
        }

        count++;
    }

    public static void main(String[] args) {
        Screen game = new Screen();
    }
}
