import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class Screen extends JFrame {

    Screen() {
        /* Janela principal */

        setTitle("Interface criada manualmente");

        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        /* painel de fundo da janela principal */

        JPanel backgroundPanel = new JPanel();
        add(backgroundPanel);

        backgroundPanel.setBackground(new Color(200,200,255));

        backgroundPanel.setLayout(null);

        /* painel de formulário */

        JPanel formPanel = new JPanel();
        backgroundPanel.add(formPanel);

        formPanel.setLayout(null);

        formPanel.setBackground(new Color(255,255,255));
        formPanel.setBounds((getWidth()/2)-150,(getHeight()/2)-220, 300,400);
        formPanel.setBorder(new LineBorder(new Color(100,100,200),2));

        /* Campos de texto */

        int widthField = 250;
        int heightField = 50;
        int positionFieldX = (formPanel.getWidth()/2)-(widthField/2);
        int positionFieldY = (formPanel.getHeight()/5)-(heightField/3);

        int fontSize = 20;
        Font fieldFont = new Font(Font.DIALOG, Font.PLAIN, fontSize);
        Font buttonFont = new Font(Font.DIALOG, Font.BOLD, fontSize);

        Color inputColor = new Color(100,100,200);
        LineBorder borderInput = new LineBorder(inputColor);

        // Campo para nome
        JTextField nameField = new JTextField();
        formPanel.add(nameField);

        nameField.setBounds(positionFieldX, positionFieldY, widthField, heightField);
        nameField.setFont(fieldFont);
        nameField.setBorder(new TitledBorder(borderInput, "Nome"));

        //campo para cpf
        MaskFormatter cpf = null;
        try {
            cpf = new MaskFormatter("###.###.###-##");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Erro na máscara do campo CPF...","", JOptionPane.ERROR_MESSAGE);
        }
        JFormattedTextField cpfField = new JFormattedTextField(cpf);
        formPanel.add(cpfField);

        cpfField.setBounds(positionFieldX, positionFieldY*2, widthField, heightField);
        cpfField.setBorder(new TitledBorder(borderInput, "CPF"));
        cpfField.setFont(fieldFont);

        //campo para idade
        JTextField ageField = new JTextField();
        formPanel.add(ageField);

        ageField.setBounds(positionFieldX, positionFieldY*3, widthField, heightField);
        ageField.setBorder(new TitledBorder(borderInput, "Idade"));
        ageField.setFont(fieldFont);

        //campo telefone
        MaskFormatter tel = null;
        try {
            tel = new MaskFormatter("(##) #####-####");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Erro na máscara do campo Telefone...","", JOptionPane.ERROR_MESSAGE);
        }

        JFormattedTextField telField = new JFormattedTextField(tel);
        formPanel.add(telField);

        telField.setBounds(positionFieldX, positionFieldY*4, widthField, heightField);
        telField.setBorder(new TitledBorder(borderInput, "Telefone"));
        telField.setFont(fieldFont);

        /* botão de cadastro */

        JButton registerButton = new JButton("Cadastrar-se");
        formPanel.add(registerButton);

        registerButton.setBounds(positionFieldX, positionFieldY*5, widthField, heightField);
        registerButton.setBackground(inputColor);
        registerButton.setForeground(new Color(255,255,255));
        registerButton.setFont(buttonFont);
        registerButton.setBorder(borderInput);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        registerButton.addActionListener(e -> {
            String message = String.format("Nome: %s\nCPF: %s\nIdade: %s\nTelefone: %s", nameField.getText(), cpfField.getText(), ageField.getText(), telField.getText());
            JOptionPane.showMessageDialog(this, message, "Cadastrado com sucesso!", JOptionPane.PLAIN_MESSAGE);
        });

    }

    public static void main(String[] args) {
        new Screen();
    }
}
