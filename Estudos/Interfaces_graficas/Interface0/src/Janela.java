import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Janela extends JFrame {

    /*  */
    private JPanel painel;
    private JButton b1;
    private JButton b2;
    private JButton b3;

    /* Construtor da Classe */
    public Janela() {
        setLayout(new FlowLayout()); // Definido o Layout, posicionamento automático dos itens
        painel = new JPanel(); // instanciação do painel

        /* Botão 1 */
        b1 = new JButton("Botão 1"); // Instanciação do primeiro botão
        /* Ação do botão com Função Lambda */
        b1.addActionListener(
            e -> {
                JOptionPane.showMessageDialog(this, "Botão 1 clicado!");
            }
        );
        b1.setBounds(10, 10, 200, 50); // Tamanho do botão

        /* Botão 2 */
        b2 = new JButton("Botão 2"); // Instanciação do segundo botão
        /* Ação do botão com classe herdando de ActionListener */
        b2.addActionListener(new CliqueBtn());
        b2.setBounds(10, 10, 200, 50); // Tamanho do botão
        
        /* Botão 3 */
        b3 = new JButton("Botão 3"); // Instanciando o terceiro botão
        /* Usando Função Lambda para chamar a função de acão */
        b3.addActionListener(e -> actionButton3());
        b3.setBounds(10, 10, 200, 50); // Tamanho do botão

        setSize(800, 500); // Tamanho da janela
        setResizable(false); // Tirando a possibilidade de alterar o tamanho da janela
        setLocationRelativeTo(null); // Centalizando a janela ao iniciar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Botão de fechar janela encerra a execução
        setVisible(true); // Janela se torna visível

        /* Adiciona os componentes */
        add(b1);
        add(b2);
        add(b3);
        add(painel);
    }

    /* Função principal */
    public static void main(String[] args) {
        new Janela();
    }

    /* Classe que herda de ActionListener para ação do botão 2 */
    private class CliqueBtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(Janela.this, "Botão 2 clicado...");
        }
        
    }

    /* Função de ação do botão 3 */
    private void actionButton3() {
        JOptionPane.showMessageDialog(this, "Botão 3 clicado?");
    }
    
}

