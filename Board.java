import javax.swing.*;
import java.awt.*;

class Board extends JFrame{
    private InfoBoardView infoBoard;

    public Board()
    {
        super("Key Collector");
        this.setLayout(new GridLayout(1,2));
        infoBoard = new InfoBoardView(this);

        this.pack();
        this.setVisible(true);
    }



}