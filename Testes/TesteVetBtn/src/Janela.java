import javax.swing.*;


public class Janela extends JFrame {
    private JButton[] botoes;
    private JButton b0;
    

    public Janela() {

        setTitle("Janela");
        setResizable(false);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        b0 = new JButton("Add buttons");
        b0.addActionListener(e -> adicionarBtn());
        add(b0);



    }

    public void adicionarBtn() {

        botoes = new JButton[9];

        for (int i = 0; i < botoes.length; i++) {
            botoes[i].setBounds(i*100, i*50, 30, 30);
            botoes[i].setText("botão "+i);
        }

        for (int i = 0; i < botoes.length; i++) {
            this.add(botoes[i]);
        }
    }

    public static void main(String[] args) {
        new Janela();
    }
}
