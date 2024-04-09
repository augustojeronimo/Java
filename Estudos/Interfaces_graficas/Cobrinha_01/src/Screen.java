import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Screen extends JFrame
{
    /* Componentes */
    private JPanel panel_navbar;
    private JPanel button_close;
    private JPanel panel_body;

    Screen ()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setSize(630, 630+30);
        setResizable(false);
        
        setLocationRelativeTo(null);

        setUndecorated(true);
        panel_navbar();

        panel_body();

        setVisible(true);

        int game = 2;
        
        switch (game) {
            case 1:
                SnakeGame game_snake = new SnakeGame(this);
                panel_body.add(game_snake);
                game_snake.game_start();
                break;
            case 2:
                Minefield game_minefield = new Minefield(21);
                panel_body.add(game_minefield);
                break;
            default:
                break;
        }

        setVisible(true);

    }

    private void panel_navbar ()
    {
        panel_navbar = new JPanel();
        panel_navbar.setLayout(new GridLayout());

        panel_navbar.setBounds(0, 0, 630, 30);
        panel_navbar.setBackground(new Color(100,100,100));

        configure_navbar();

        add(panel_navbar);
    }

    private void configure_navbar ()
    {
        button_close = new JPanel();
        button_close.setBackground(new Color(255, 80, 80));

        JLabel x = new JLabel("X");
        x.setFont(new Font("Verdana", Font.PLAIN, 15));
        x.setForeground(new Color(255,255,255));

        button_close.add(x);

        for (int i = 1; i <= 13; i++) {
            JPanel p = new JPanel();
            p.setBackground(Color.DARK_GRAY);
            panel_navbar.add(p);
        }

        action_close();
        panel_navbar.add(button_close);
    }

    private void action_close ()
    {
        button_close.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                button_close.setBackground(new Color(255,50,50));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                button_close.setBackground(new Color(255, 80, 80));
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
        });
    }

    private void panel_body ()
    {
        panel_body = new JPanel();

        panel_body.setLayout(new CardLayout());

        panel_body.setBounds(0, 30, 630, 630);
        panel_body.setBackground(new Color(255,255,255));

        add(panel_body);
        panel_body.setVisible(true);
    }


    public static void main(String[] args)
    {
        new Screen();
    }
}
