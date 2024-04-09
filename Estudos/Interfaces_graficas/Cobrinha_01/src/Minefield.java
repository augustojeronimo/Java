import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Minefield extends JPanel
{
    private Spot[][] field;
    private int grid;
    private int size;
    private int bomb_spaw;

    Minefield (int grid)
    {
        bomb_spaw = 5;
        this.grid = grid;
        this.size = 630/grid;

        setLayout(new GridLayout(grid,grid));
        
        setBackground(Color.GRAY);

        configure_field();

        configure_clicks();

        for (int y = 0; y < this.grid; y++) {
            for (int x = 0; x < this.grid; x++) {
                
                System.out.print("["+(field[y][x].isBomb()? "0" : "_")+"]");

            }
            System.out.println();
        }
    }

    private void configure_clicks ()
    {
        for (int i = 0; i < this.grid; i++) {
            for (int j = 0; j < this.grid; j++) {

                final int y = i, x = j;
                
                field[y][x].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1 && !field[y][x].wasClicked() && !field[y][x].isMarked()) {
                            if (!field[y][x].wasClicked()) {

                                if (field[y][x].click()) {
                                    JOptionPane.showMessageDialog(null, "Perdeu");
                                } else if (field[y][x].getBombs_around() == 0) {
                                    click_round(x, y);
                                }
                                
                            } 
                        } else if (e.getButton() == MouseEvent.BUTTON1 && field[y][x].wasClicked() && count_marked_around(x, y) == field[y][x].getBombs_around()) {
                            click_round(x, y);
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            field[y][x].mark();
                        } 
                    }
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent e) {}
                    @Override
                    public void mouseExited(java.awt.event.MouseEvent e) {}
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e) {}
                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent e) {}
                });

            }
        }
    }

    private void click_round(int x, int y) {
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {

                if (i >= 0 && j >= 0 && i < this.grid && j < this.grid) {
                    
                    if (!field[i][j].wasClicked() && !field[i][j].isMarked()) {

                        if (field[i][j].getBombs_around() == 0 && !field[i][j].isMarked()) {
                            field[i][j].click();
                            click_round(j, i);
                        }
                        
                        field[i][j].click();
                        
                    }

                }

            }
        }
    }

    private int count_marked_around (int x, int y)
    {
        int count = 0;

        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {

                if (i >= 0 && j >= 0 && i < this.grid && j < this.grid) {
                    
                    if (field[i][j].isMarked()) {

                        count++;
                        
                    }

                }

            }
        }

        return count;
    }

    private void configure_field ()
    {
        field = new Spot[this.grid][this.grid];

        for (int y = 0; y < this.grid; y++) {
            for (int x = 0; x < this.grid; x++) {
                
                field[y][x] = new_spot();

            }
        }

        for (int y = 0; y < this.grid; y++) {
            for (int x = 0; x < this.grid; x++) {

                int count = 0;
                
                for (int i = y-1; i <= y+1; i++) {
                    for (int j = x-1; j <= x+1; j++) {
                        
                        if (i >=0 && j >= 0 && i < this.grid && j < this.grid) {
                            if (field[i][j].isBomb()) {
                                count++;
                            }
                        }
                        
                    }
                }

                field[y][x].setBombs_around(count);
            }
        }
    }

    private Spot new_spot ()
    {
        Spot s = new Spot();
        add(s);

        s.setBomb((int) (Math.random()*this.bomb_spaw) == 0);

        return s;
    }

    private class Spot extends JPanel
    {
        private JLabel bombs_around;
        private boolean bomb;
        private boolean clicked;
        private boolean marked;

        private final Color COLOR_DEFAULT = Color.GRAY;
        private final Color COLOR_CLEAN = Color.LIGHT_GRAY;
        private final Color COLOR_MARKED = Color.ORANGE;
        private final Color COLOR_BOMB = Color.RED;

        Spot ()
        {
            this.marked = false;
            this.clicked = false;

            bombs_around = new JLabel();
            bombs_around.setVisible(false);
            add(bombs_around);


            setBackground(COLOR_DEFAULT);
            setBorder(new LineBorder(Color.BLACK));
        }

        public void setBomb (boolean bomb)
        {
            this.bomb = bomb;
        }

        public boolean click ()
        {
            if (this.bomb) {
                setBackground(COLOR_BOMB);
            } else {
                setBackground(COLOR_CLEAN);

                this.bombs_around.setVisible(true);
            }
            this.clicked = true;
            return this.bomb;
        }

        public boolean isBomb ()
        {
            return this.bomb;
        }

        public int getBombs_around ()
        {
            return Integer.parseInt(!this.bombs_around.getText().equals("")? this.bombs_around.getText() : "0");
        }

        public void setBombs_around (int bombs_around)
        {
            if (bombs_around != 0) {
                this.bombs_around.setText(String.valueOf(bombs_around));
            }
        }

        public boolean isMarked ()
        {
            return this.marked;
        }

        public void mark () {
            if (!clicked) {
                if (this.marked) {
                    setBackground(COLOR_DEFAULT);
                    this.marked = false;
                } else {
                    setBackground(COLOR_MARKED);
                    this.marked = true;
                }
            }
        }

        public boolean wasClicked ()
        {
            return this.clicked;
        }
    }
}
