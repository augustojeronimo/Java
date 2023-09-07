import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Screen extends JFrame {
    public Screen() {

        /* Título da janela */
        setTitle("Estudos Interface Gráfica");
        
        /* Configutando dimensões e visibilidade */
        setResizable(false);
        setSize(800, 500);
        setVisible(true);

        /* Posição e fechamento */
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        /* Criando botão */
        JButton botao = new JButton("Clique aqui");

        /* Configutando botão */
        botao.setBounds(100, 200, 300, 50);
        botao.setFont(new Font("Arial", Font.BOLD, 20));

        botao.setBackground(new Color(30, 30, 200));
        botao.setForeground(new Color(255, 255, 255));

        /* Ação do botão */
        

        /* Adicionando botão na janela */
        add(botao);
    }


}
