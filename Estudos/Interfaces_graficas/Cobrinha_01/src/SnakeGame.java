import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SnakeGame extends JPanel
{
    private JFrame ancestor;
    
    private ArrayList<JPanel> snake;
    private JPanel head;
    private JLabel eyes;
    
    private JPanel fruit;
    
    /*  */
    private int speed;
    private int spot_size;

    /* Direção de movimento */
    private char moving;
    private char move_to;

    /* Direções */
    private final char UP = '^';
    private final char DOWN = 'v';
    private final char LEFT = '<';
    private final char RIGHT = '>';

    SnakeGame (JFrame ancestor)
    {
        this.ancestor = ancestor;
        spot_size = ancestor.getWidth()/21;
        setLayout(null);
        setBackground(Color.BLACK);
        setSize(ancestor.getWidth(), ancestor.getHeight());

        moving = UP;
        move_to = UP;

        snake = new ArrayList<>();
        speed = 500;

        
        fruit = new JPanel();
        fruit.setBackground(Color.CYAN);
        fruit.setSize(spot_size, spot_size);
        add(fruit);

        keys_configure();

        head = new_snake_spot();
        head.setLocation(10*spot_size, 10*spot_size);

        eyes = new JLabel("x x");
        eyes.setForeground(Color.BLACK);
        eyes.setFont(new Font("Verdana", Font.BOLD, 12));
        eyes.setVisible(true);
        head.add(eyes);

        snake.add(head);
        add(head);

        fruit_spawn();
        
        setVisible(true);
    }

    public void game_start ()
    {
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Erro no intervalo de início...\nERRO: "+e.getMessage());
        }

        boolean loop = true;

        for (int i = 0; loop; i++) {
            try {
                Thread.sleep(speed);
                speed_update(i);
                loop = update_snake_position();
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Erro de loop no jogo da cobrinha...\nERRO: "+e.getMessage());
            }
        }
    }

    private void speed_update (int count)
    {
        if (speed > 200 && count%5 == 0) {
            speed -= 15;
        }
    }

    private void fruit_spawn ()
    {

        int x, y;

        do {
            x = 30 * (int) (Math.random()*20);
            y = 30 + 30 * (int) (Math.random()*19);
        } while (check_position(x, y));

        fruit.setLocation(x, y);
    }

    private boolean check_position (int x, int y)
    {
        for (JPanel s : snake) {
            if (s.getX() == x && s.getY() == y) {
                return true;
            }
        }

        return false;
    }

    private boolean check_colision (int x, int y)
    {
        for (JPanel s : snake) {
            if (s.getX() == x && s.getY() == y && !s.equals(head)) {
                return true;
            }
        }

        return false;
    }

    private boolean update_snake_position ()
    {
        direction_valid();
        if (!lose()) {
            
            for (int i = snake.size()-1; i > 0; i--) {
                snake.get(i).setLocation(snake.get(i-1).getLocation());
            }

            move();
            if (head.getX() == fruit.getX() && head.getY() == fruit.getY()) {
                fruit_spawn();
                increase_snake();
            }

            return true;
            
        } else {
            return false;
        }

    }

    private void direction_valid()
    {
        if (!((moving == UP && move_to != DOWN) || (moving == DOWN && move_to != UP) || (moving == LEFT && move_to != RIGHT) || (moving == RIGHT && move_to != LEFT))) {
            move_to = moving;
        }
    }

    private boolean lose()
    {
        return ((move_to == UP && head.getY() <= 0) || (move_to == DOWN && head.getY() >= this.getHeight()-2*spot_size) || (move_to == LEFT && head.getX() <= 0) || (move_to == RIGHT && head.getX() >= this.getWidth()-spot_size) || check_colision(head.getX(), head.getY()));
    }

    private void move ()
    {
        switch (move_to) {
            case UP:
                head.setLocation(head.getX(), head.getY()-spot_size);
                moving = UP;
                break;
            case DOWN:
                head.setLocation(head.getX(), head.getY()+spot_size);
                moving = DOWN;
                break;
            case LEFT:
                head.setLocation(head.getX()-spot_size, head.getY());
                moving = LEFT;
                break;
            case RIGHT:
                head.setLocation(head.getX()+spot_size, head.getY());
                moving = RIGHT;
                break;
            default:
                break;
        }
    }

    private JPanel new_snake_spot ()
    {
        JPanel new_spot = new JPanel();
        new_spot.setSize(spot_size, spot_size);
        new_spot.setBackground(Color.RED);

        new_spot.setLocation(getWidth(), getHeight());

        return new_spot;
    }

    private void increase_snake ()
    {
        JPanel tail = new_snake_spot();
        snake.add(tail);
        add(tail);
    }
    
    private void keys_configure ()
    {
        
        ancestor.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'w':
                        move_to = UP;
                        break;
                    case 's':
                        move_to = DOWN;
                        break;
                    case 'a':
                        move_to = LEFT;
                        break;
                    case 'd':
                        move_to = RIGHT;
                        break;
                
                    default:
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
            
        });
    }
}
