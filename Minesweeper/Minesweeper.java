import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Minesweeper extends JFrame{
    private MinesweeperTile[][] board = new MinesweeperTile[9][9];
    private JButton tile00,tile01,tile02,tile03,tile04,tile05,tile06,tile07,tile08;
    private JButton tile10,tile11,tile12,tile13,tile14,tile15,tile16,tile17,tile18;
    private JButton tile20,tile21,tile22,tile23,tile24,tile25,tile26,tile27,tile28;
    private JButton tile30,tile31,tile32,tile33,tile34,tile35,tile36,tile37,tile38;
    private JButton tile40,tile41,tile42,tile43,tile44,tile45,tile46,tile47,tile48;
    private JButton tile50,tile51,tile52,tile53,tile54,tile55,tile56,tile57,tile58;
    private JButton tile60,tile61,tile62,tile63,tile64,tile65,tile66,tile67,tile68;
    private JButton tile70,tile71,tile72,tile73,tile74,tile75,tile76,tile77,tile78;
    private JButton tile80,tile81,tile82,tile83,tile84,tile85,tile86,tile87,tile88;
    private JLabel time;
    private String s;
    private long start = System.currentTimeMillis();
    private TimeGUI subGUI;
    private boolean firstClick = false;
    private boolean flagClick = false;
    private JButton flagButton;

    public Minesweeper(){
        super("Minesweeper");
        setLayout(new GridLayout(9,9));
        //create a board of tiles
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                board[r][c] = new MinesweeperTile();
            }
        }
        //set 10 tiles to mines
        for(int a = 0; a < 15; a++){
            int r = (int)(Math.random()*9);
            int c = (int)(Math.random()*9);
            if(board[r][c].getMine() != true){
                board[r][c].setToMine();
            }else{
                a--;
            }
        }
        //change all the adjacent values for all tiles
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                updateAdjacent(r,c);
            }
        }
        
        ButtonHandler handler = new ButtonHandler();
        
        tile00 = new JButton(); tile00.addActionListener(handler); tile00.setFont(new Font(tile00.getName(), Font.BOLD, 15));
        tile01 = new JButton(); tile01.addActionListener(handler); tile01.setFont(new Font(tile01.getName(), Font.BOLD, 15));
        tile02 = new JButton(); tile02.addActionListener(handler); tile02.setFont(new Font(tile02.getName(), Font.BOLD, 15));
        tile03 = new JButton(); tile03.addActionListener(handler); tile03.setFont(new Font(tile03.getName(), Font.BOLD, 15));
        tile04 = new JButton(); tile04.addActionListener(handler); tile04.setFont(new Font(tile04.getName(), Font.BOLD, 15));
        tile05 = new JButton(); tile05.addActionListener(handler); tile05.setFont(new Font(tile05.getName(), Font.BOLD, 15));
        tile06 = new JButton(); tile06.addActionListener(handler); tile06.setFont(new Font(tile06.getName(), Font.BOLD, 15));
        tile07 = new JButton(); tile07.addActionListener(handler); tile07.setFont(new Font(tile07.getName(), Font.BOLD, 15));
        tile08 = new JButton(); tile08.addActionListener(handler); tile08.setFont(new Font(tile08.getName(), Font.BOLD, 15));
        tile10 = new JButton(); tile10.addActionListener(handler); tile10.setFont(new Font(tile10.getName(), Font.BOLD, 15));
        tile11 = new JButton(); tile11.addActionListener(handler); tile11.setFont(new Font(tile11.getName(), Font.BOLD, 15));
        tile12 = new JButton(); tile12.addActionListener(handler); tile12.setFont(new Font(tile12.getName(), Font.BOLD, 15));
        tile13 = new JButton(); tile13.addActionListener(handler); tile13.setFont(new Font(tile13.getName(), Font.BOLD, 15));
        tile14 = new JButton(); tile14.addActionListener(handler); tile14.setFont(new Font(tile14.getName(), Font.BOLD, 15));
        tile15 = new JButton(); tile15.addActionListener(handler); tile15.setFont(new Font(tile15.getName(), Font.BOLD, 15));
        tile16 = new JButton(); tile16.addActionListener(handler); tile16.setFont(new Font(tile16.getName(), Font.BOLD, 15));
        tile17 = new JButton(); tile17.addActionListener(handler); tile17.setFont(new Font(tile17.getName(), Font.BOLD, 15));
        tile18 = new JButton(); tile18.addActionListener(handler); tile18.setFont(new Font(tile18.getName(), Font.BOLD, 15));
        tile20 = new JButton(); tile20.addActionListener(handler); tile20.setFont(new Font(tile20.getName(), Font.BOLD, 15));
        tile21 = new JButton(); tile21.addActionListener(handler); tile21.setFont(new Font(tile21.getName(), Font.BOLD, 15));
        tile22 = new JButton(); tile22.addActionListener(handler); tile22.setFont(new Font(tile22.getName(), Font.BOLD, 15));
        tile23 = new JButton(); tile23.addActionListener(handler); tile23.setFont(new Font(tile23.getName(), Font.BOLD, 15));
        tile24 = new JButton(); tile24.addActionListener(handler); tile24.setFont(new Font(tile24.getName(), Font.BOLD, 15));
        tile25 = new JButton(); tile25.addActionListener(handler); tile25.setFont(new Font(tile25.getName(), Font.BOLD, 15));
        tile26 = new JButton(); tile26.addActionListener(handler); tile26.setFont(new Font(tile26.getName(), Font.BOLD, 15));
        tile27 = new JButton(); tile27.addActionListener(handler); tile27.setFont(new Font(tile27.getName(), Font.BOLD, 15));
        tile28 = new JButton(); tile28.addActionListener(handler); tile28.setFont(new Font(tile28.getName(), Font.BOLD, 15));
        tile30 = new JButton(); tile30.addActionListener(handler); tile30.setFont(new Font(tile30.getName(), Font.BOLD, 15));
        tile31 = new JButton(); tile31.addActionListener(handler); tile31.setFont(new Font(tile31.getName(), Font.BOLD, 15));
        tile32 = new JButton(); tile32.addActionListener(handler); tile32.setFont(new Font(tile32.getName(), Font.BOLD, 15));
        tile33 = new JButton(); tile33.addActionListener(handler); tile33.setFont(new Font(tile33.getName(), Font.BOLD, 15));
        tile34 = new JButton(); tile34.addActionListener(handler); tile34.setFont(new Font(tile34.getName(), Font.BOLD, 15));
        tile35 = new JButton(); tile35.addActionListener(handler); tile35.setFont(new Font(tile35.getName(), Font.BOLD, 15));
        tile36 = new JButton(); tile36.addActionListener(handler); tile36.setFont(new Font(tile36.getName(), Font.BOLD, 15));
        tile37 = new JButton(); tile37.addActionListener(handler); tile37.setFont(new Font(tile37.getName(), Font.BOLD, 15));
        tile38 = new JButton(); tile38.addActionListener(handler); tile38.setFont(new Font(tile38.getName(), Font.BOLD, 15));
        tile40 = new JButton(); tile40.addActionListener(handler); tile40.setFont(new Font(tile40.getName(), Font.BOLD, 15));
        tile41 = new JButton(); tile41.addActionListener(handler); tile41.setFont(new Font(tile41.getName(), Font.BOLD, 15));
        tile42 = new JButton(); tile42.addActionListener(handler); tile42.setFont(new Font(tile42.getName(), Font.BOLD, 15));
        tile43 = new JButton(); tile43.addActionListener(handler); tile43.setFont(new Font(tile43.getName(), Font.BOLD, 15));
        tile44 = new JButton(); tile44.addActionListener(handler); tile44.setFont(new Font(tile44.getName(), Font.BOLD, 15));
        tile45 = new JButton(); tile45.addActionListener(handler); tile45.setFont(new Font(tile45.getName(), Font.BOLD, 15));
        tile46 = new JButton(); tile46.addActionListener(handler); tile46.setFont(new Font(tile46.getName(), Font.BOLD, 15));
        tile47 = new JButton(); tile47.addActionListener(handler); tile47.setFont(new Font(tile47.getName(), Font.BOLD, 15));
        tile48 = new JButton(); tile48.addActionListener(handler); tile48.setFont(new Font(tile48.getName(), Font.BOLD, 15));
        tile50 = new JButton(); tile50.addActionListener(handler); tile50.setFont(new Font(tile50.getName(), Font.BOLD, 15));
        tile51 = new JButton(); tile51.addActionListener(handler); tile51.setFont(new Font(tile51.getName(), Font.BOLD, 15));
        tile52 = new JButton(); tile52.addActionListener(handler); tile52.setFont(new Font(tile52.getName(), Font.BOLD, 15));
        tile53 = new JButton(); tile53.addActionListener(handler); tile53.setFont(new Font(tile53.getName(), Font.BOLD, 15));
        tile54 = new JButton(); tile54.addActionListener(handler); tile54.setFont(new Font(tile54.getName(), Font.BOLD, 15));
        tile55 = new JButton(); tile55.addActionListener(handler); tile55.setFont(new Font(tile55.getName(), Font.BOLD, 15));
        tile56 = new JButton(); tile56.addActionListener(handler); tile56.setFont(new Font(tile56.getName(), Font.BOLD, 15));
        tile57 = new JButton(); tile57.addActionListener(handler); tile57.setFont(new Font(tile57.getName(), Font.BOLD, 15));
        tile58 = new JButton(); tile58.addActionListener(handler); tile58.setFont(new Font(tile58.getName(), Font.BOLD, 15));
        tile60 = new JButton(); tile60.addActionListener(handler); tile60.setFont(new Font(tile60.getName(), Font.BOLD, 15));
        tile61 = new JButton(); tile61.addActionListener(handler); tile61.setFont(new Font(tile61.getName(), Font.BOLD, 15));
        tile62 = new JButton(); tile62.addActionListener(handler); tile62.setFont(new Font(tile62.getName(), Font.BOLD, 15));
        tile63 = new JButton(); tile63.addActionListener(handler); tile63.setFont(new Font(tile63.getName(), Font.BOLD, 15));
        tile64 = new JButton(); tile64.addActionListener(handler); tile64.setFont(new Font(tile64.getName(), Font.BOLD, 15));
        tile65 = new JButton(); tile65.addActionListener(handler); tile65.setFont(new Font(tile65.getName(), Font.BOLD, 15));
        tile66 = new JButton(); tile66.addActionListener(handler); tile66.setFont(new Font(tile66.getName(), Font.BOLD, 15));
        tile67 = new JButton(); tile67.addActionListener(handler); tile67.setFont(new Font(tile67.getName(), Font.BOLD, 15));
        tile68 = new JButton(); tile68.addActionListener(handler); tile68.setFont(new Font(tile68.getName(), Font.BOLD, 15));
        tile70 = new JButton(); tile70.addActionListener(handler); tile70.setFont(new Font(tile70.getName(), Font.BOLD, 15));
        tile71 = new JButton(); tile71.addActionListener(handler); tile71.setFont(new Font(tile71.getName(), Font.BOLD, 15));
        tile72 = new JButton(); tile72.addActionListener(handler); tile72.setFont(new Font(tile72.getName(), Font.BOLD, 15));
        tile73 = new JButton(); tile73.addActionListener(handler); tile73.setFont(new Font(tile73.getName(), Font.BOLD, 15));
        tile74 = new JButton(); tile74.addActionListener(handler); tile74.setFont(new Font(tile74.getName(), Font.BOLD, 15));
        tile75 = new JButton(); tile75.addActionListener(handler); tile75.setFont(new Font(tile75.getName(), Font.BOLD, 15));
        tile76 = new JButton(); tile76.addActionListener(handler); tile76.setFont(new Font(tile76.getName(), Font.BOLD, 15));
        tile77 = new JButton(); tile77.addActionListener(handler); tile77.setFont(new Font(tile77.getName(), Font.BOLD, 15));
        tile78 = new JButton(); tile78.addActionListener(handler); tile78.setFont(new Font(tile78.getName(), Font.BOLD, 15));
        tile80 = new JButton(); tile80.addActionListener(handler); tile80.setFont(new Font(tile80.getName(), Font.BOLD, 15));
        tile81 = new JButton(); tile81.addActionListener(handler); tile81.setFont(new Font(tile81.getName(), Font.BOLD, 15));
        tile82 = new JButton(); tile82.addActionListener(handler); tile82.setFont(new Font(tile82.getName(), Font.BOLD, 15));
        tile83 = new JButton(); tile83.addActionListener(handler); tile83.setFont(new Font(tile83.getName(), Font.BOLD, 15));
        tile84 = new JButton(); tile84.addActionListener(handler); tile84.setFont(new Font(tile84.getName(), Font.BOLD, 15));
        tile85 = new JButton(); tile85.addActionListener(handler); tile85.setFont(new Font(tile85.getName(), Font.BOLD, 15));
        tile86 = new JButton(); tile86.addActionListener(handler); tile86.setFont(new Font(tile86.getName(), Font.BOLD, 15));
        tile87 = new JButton(); tile87.addActionListener(handler); tile87.setFont(new Font(tile87.getName(), Font.BOLD, 15));
        tile88 = new JButton(); tile88.addActionListener(handler); tile88.setFont(new Font(tile88.getName(), Font.BOLD, 15));
        
        flagButton = new JButton(); flagButton.addActionListener(handler); flagButton.setFont(new Font(flagButton.getName(), Font.BOLD, 20));
        flagButton.setText("FLAG");
        flagButton.setBackground(Color.WHITE);
        
        add(tile00);
        add(tile01);
        add(tile02);
        add(tile03);
        add(tile04);
        add(tile05);
        add(tile06);
        add(tile07);
        add(tile08);
        add(tile10);
        add(tile11);
        add(tile12);
        add(tile13);
        add(tile14);
        add(tile15);
        add(tile16);
        add(tile17);
        add(tile18);
        add(tile20);
        add(tile21);
        add(tile22);
        add(tile23);
        add(tile24);
        add(tile25);
        add(tile26);
        add(tile27);
        add(tile28);
        add(tile30);
        add(tile31);
        add(tile32);
        add(tile33);
        add(tile34);
        add(tile35);
        add(tile36);
        add(tile37);
        add(tile38);
        add(tile40);
        add(tile41);
        add(tile42);
        add(tile43);
        add(tile44);
        add(tile45);
        add(tile46);
        add(tile47);
        add(tile48);
        add(tile50);
        add(tile51);
        add(tile52);
        add(tile53);
        add(tile54);
        add(tile55);
        add(tile56);
        add(tile57);
        add(tile58);
        add(tile60);
        add(tile61);
        add(tile62);
        add(tile63);
        add(tile64);
        add(tile65);
        add(tile66);
        add(tile67);
        add(tile68);
        add(tile70);
        add(tile71);
        add(tile72);
        add(tile73);
        add(tile74);
        add(tile75);
        add(tile76);
        add(tile77);
        add(tile78);
        add(tile80);
        add(tile81);
        add(tile82);
        add(tile83);
        add(tile84);
        add(tile85);
        add(tile86);
        add(tile87);
        add(tile88);
                
        time = new JLabel();
        time.setHorizontalAlignment(SwingConstants.CENTER);
        subGUI = new TimeGUI();
        subGUI.setDefaultCloseOperation(HIDE_ON_CLOSE);
        subGUI.setSize(100,115);
        subGUI.setLocation(400,0);
        subGUI.setVisible(true);
        
        updateBoard();
        updateBackgrounds();
        updateAdjacentColors();
    }
    
    private class MinesweeperTile{
        private boolean isMine;
        private boolean flag;
        private boolean clicked;
        private int adjacentMine;
        
        public MinesweeperTile(){
            isMine = false;
            adjacentMine = 0;
            clicked = false;
        }
        
        public MinesweeperTile(boolean m){
            isMine = m;
            adjacentMine = 0;
            clicked = false;
        }
        
        public MinesweeperTile(boolean m, int a){
            isMine = m;
            adjacentMine = a;
            clicked = false;
        }
      
        public void setToMine(){
            isMine = true;
        }
        
        public boolean getMine(){
            return isMine;
        }
        
        public void alternateFlag(){
            flag = !flag;
        }
        
        public boolean getFlag(){
            return flag;
        }
        
        public boolean getClicked(){
            return clicked;
        }
        
        public void setClicked(){
            clicked = true;
        }
        
        public int getAdjacent(){
            return adjacentMine;
        }
        
        public void addAdjacent(){
            adjacentMine++;
        }
        
        public String toString(){
            if(getMine()){
                return "*";
            }else{
                return Integer.toString(getAdjacent());
            }
        }
    }
    
    private class TimeGUI extends JFrame{
        private Thread updater;
        private boolean running = true;
        public TimeGUI(){
            super("Time");
            setLayout(new GridLayout(2,1));
            updater = new Thread(new timer());
            updater.start();
            add(flagButton);
            add(time);
        }
        
        private class timer implements Runnable{
            public void run(){
                if(firstClick){
                    double elapsed = (double)(System.currentTimeMillis()-start)/1000;
                    elapsed = Math.round(elapsed*100.0)/100.0;
                    s = Double.toString(elapsed);
                    int index = s.indexOf(".");
                    s = s.substring(0,index) + ":" + s.substring(index+1, s.length());
                    time.setText(s);  
                }
                try{
                        Thread.sleep(100);
                }catch(InterruptedException e){
                        
                }
                if(running)
                    run();
            }
        }
    }
    
    private class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(!firstClick){
                firstClick = true;
                start = System.currentTimeMillis();
            }
            if(e.getSource() == flagButton){
                flagClick = !flagClick;
            }
            if(flagClick){
                flagButton.setBackground(Color.RED);
                if(e.getSource() == tile00){
                    board[0][0].alternateFlag();
                }else if(e.getSource() == tile01){
                    board[0][1].alternateFlag();
                }else if(e.getSource() == tile02){
                    board[0][2].alternateFlag();
                }else if(e.getSource() == tile03){
                    board[0][3].alternateFlag();
                }else if(e.getSource() == tile04){
                    board[0][4].alternateFlag();
                }else if(e.getSource() == tile05){
                    board[0][5].alternateFlag();
                }else if(e.getSource() == tile06){
                    board[0][6].alternateFlag();
                }else if(e.getSource() == tile07){
                    board[0][7].alternateFlag();
                }else if(e.getSource() == tile08){
                    board[0][8].alternateFlag();
                }else if(e.getSource() == tile10){
                    board[1][0].alternateFlag();
                }else if(e.getSource() == tile11){
                    board[1][1].alternateFlag();
                }else if(e.getSource() == tile12){
                    board[1][2].alternateFlag();
                }else if(e.getSource() == tile13){
                    board[1][3].alternateFlag();
                }else if(e.getSource() == tile14){
                    board[1][4].alternateFlag();
                }else if(e.getSource() == tile15){
                    board[1][5].alternateFlag();
                }else if(e.getSource() == tile16){
                    board[1][6].alternateFlag();
                }else if(e.getSource() == tile17){
                    board[1][7].alternateFlag();
                }else if(e.getSource() == tile18){
                    board[1][8].alternateFlag();
                }else if(e.getSource() == tile20){
                    board[2][0].alternateFlag();
                }else if(e.getSource() == tile21){
                    board[2][1].alternateFlag();
                }else if(e.getSource() == tile22){
                    board[2][2].alternateFlag();
                }else if(e.getSource() == tile23){
                    board[2][3].alternateFlag();
                }else if(e.getSource() == tile24){
                    board[2][4].alternateFlag();
                }else if(e.getSource() == tile25){
                    board[2][5].alternateFlag();
                }else if(e.getSource() == tile26){
                    board[2][6].alternateFlag();
                }else if(e.getSource() == tile27){
                    board[2][7].alternateFlag();
                }else if(e.getSource() == tile28){
                    board[2][8].alternateFlag();
                }else if(e.getSource() == tile30){
                    board[3][0].alternateFlag();
                }else if(e.getSource() == tile31){
                    board[3][1].alternateFlag();
                }else if(e.getSource() == tile32){
                    board[3][2].alternateFlag();
                }else if(e.getSource() == tile33){
                    board[3][3].alternateFlag();
                }else if(e.getSource() == tile34){
                    board[3][4].alternateFlag();
                }else if(e.getSource() == tile35){
                    board[3][5].alternateFlag();
                }else if(e.getSource() == tile36){
                    board[3][6].alternateFlag();
                }else if(e.getSource() == tile37){
                    board[3][7].alternateFlag();
                }else if(e.getSource() == tile38){
                    board[3][8].alternateFlag();
                }else if(e.getSource() == tile40){
                    board[4][0].alternateFlag();
                }else if(e.getSource() == tile41){
                    board[4][1].alternateFlag();
                }else if(e.getSource() == tile42){
                    board[4][2].alternateFlag();
                }else if(e.getSource() == tile43){
                    board[4][3].alternateFlag();
                }else if(e.getSource() == tile44){
                    board[4][4].alternateFlag();
                }else if(e.getSource() == tile45){
                    board[4][5].alternateFlag();
                }else if(e.getSource() == tile46){
                    board[4][6].alternateFlag();
                }else if(e.getSource() == tile47){
                    board[4][7].alternateFlag();
                }else if(e.getSource() == tile48){
                    board[4][8].alternateFlag();
                }else if(e.getSource() == tile50){
                    board[5][0].alternateFlag();
                }else if(e.getSource() == tile51){
                    board[5][1].alternateFlag();
                }else if(e.getSource() == tile52){
                    board[5][2].alternateFlag();
                }else if(e.getSource() == tile53){
                    board[5][3].alternateFlag();
                }else if(e.getSource() == tile54){
                    board[5][4].alternateFlag();
                }else if(e.getSource() == tile55){
                    board[5][5].alternateFlag();
                }else if(e.getSource() == tile56){
                    board[5][6].alternateFlag();
                }else if(e.getSource() == tile57){
                    board[5][7].alternateFlag();
                }else if(e.getSource() == tile58){
                    board[5][8].alternateFlag();
                }else if(e.getSource() == tile60){
                    board[6][0].alternateFlag();
                }else if(e.getSource() == tile61){
                    board[6][1].alternateFlag();
                }else if(e.getSource() == tile62){
                    board[6][2].alternateFlag();
                }else if(e.getSource() == tile63){
                    board[6][3].alternateFlag();
                }else if(e.getSource() == tile64){
                    board[6][4].alternateFlag();
                }else if(e.getSource() == tile65){
                    board[6][5].alternateFlag();
                }else if(e.getSource() == tile66){
                    board[6][6].alternateFlag();
                }else if(e.getSource() == tile67){
                    board[6][7].alternateFlag();
                }else if(e.getSource() == tile68){
                    board[6][8].alternateFlag();
                }else if(e.getSource() == tile70){
                    board[7][0].alternateFlag();
                }else if(e.getSource() == tile71){
                    board[7][1].alternateFlag();
                }else if(e.getSource() == tile72){
                    board[7][2].alternateFlag();
                }else if(e.getSource() == tile73){
                    board[7][3].alternateFlag();
                }else if(e.getSource() == tile74){
                    board[7][4].alternateFlag();
                }else if(e.getSource() == tile75){
                    board[7][5].alternateFlag();
                }else if(e.getSource() == tile76){
                    board[7][6].alternateFlag();
                }else if(e.getSource() == tile77){
                    board[7][7].alternateFlag();
                }else if(e.getSource() == tile78){
                    board[7][8].alternateFlag();
                }else if(e.getSource() == tile80){
                    board[8][0].alternateFlag();
                }else if(e.getSource() == tile81){
                    board[8][1].alternateFlag();
                }else if(e.getSource() == tile82){
                    board[8][2].alternateFlag();
                }else if(e.getSource() == tile83){
                    board[8][3].alternateFlag();
                }else if(e.getSource() == tile84){
                    board[8][4].alternateFlag();
                }else if(e.getSource() == tile85){
                    board[8][5].alternateFlag();
                }else if(e.getSource() == tile86){
                    board[8][6].alternateFlag();
                }else if(e.getSource() == tile87){
                    board[8][7].alternateFlag();
                }else if(e.getSource() == tile88){
                    board[8][8].alternateFlag();
                }
            }else{
                flagButton.setBackground(Color.WHITE);
                if(e.getSource() == tile00){
                    if(!board[0][0].getFlag())board[0][0].setClicked();
                }else if(e.getSource() == tile01){
                    if(!board[0][1].getFlag())board[0][1].setClicked();
                }else if(e.getSource() == tile02){
                    if(!board[0][2].getFlag())board[0][2].setClicked();
                }else if(e.getSource() == tile03){
                    if(!board[0][3].getFlag())board[0][3].setClicked();
                }else if(e.getSource() == tile04){
                    if(!board[0][4].getFlag())board[0][4].setClicked();
                }else if(e.getSource() == tile05){
                    if(!board[0][5].getFlag())board[0][5].setClicked();
                }else if(e.getSource() == tile06){
                    if(!board[0][6].getFlag())board[0][6].setClicked();
                }else if(e.getSource() == tile07){
                    if(!board[0][7].getFlag())board[0][7].setClicked();
                }else if(e.getSource() == tile08){
                    if(!board[0][8].getFlag())board[0][8].setClicked();
                }else if(e.getSource() == tile10){
                    if(!board[1][0].getFlag())board[1][0].setClicked();
                }else if(e.getSource() == tile11){
                    if(!board[1][1].getFlag())board[1][1].setClicked();
                }else if(e.getSource() == tile12){
                    if(!board[1][2].getFlag())board[1][2].setClicked();
                }else if(e.getSource() == tile13){
                    if(!board[1][3].getFlag())board[1][3].setClicked();
                }else if(e.getSource() == tile14){
                    if(!board[1][4].getFlag())board[1][4].setClicked();
                }else if(e.getSource() == tile15){
                    if(!board[1][5].getFlag())board[1][5].setClicked();
                }else if(e.getSource() == tile16){
                    if(!board[1][6].getFlag())board[1][6].setClicked();
                }else if(e.getSource() == tile17){
                    if(!board[1][7].getFlag())board[1][7].setClicked();
                }else if(e.getSource() == tile18){
                    if(!board[1][8].getFlag())board[1][8].setClicked();
                }else if(e.getSource() == tile20){
                    if(!board[2][0].getFlag())board[2][0].setClicked();
                }else if(e.getSource() == tile21){
                    if(!board[2][1].getFlag())board[2][1].setClicked();
                }else if(e.getSource() == tile22){
                    if(!board[2][2].getFlag())board[2][2].setClicked();
                }else if(e.getSource() == tile23){
                    if(!board[2][3].getFlag())board[2][3].setClicked();
                }else if(e.getSource() == tile24){
                    if(!board[2][4].getFlag())board[2][4].setClicked();
                }else if(e.getSource() == tile25){
                    if(!board[2][5].getFlag())board[2][5].setClicked();
                }else if(e.getSource() == tile26){
                    if(!board[2][6].getFlag())board[2][6].setClicked();
                }else if(e.getSource() == tile27){
                    if(!board[2][7].getFlag())board[2][7].setClicked();
                }else if(e.getSource() == tile28){
                    if(!board[2][8].getFlag())board[2][8].setClicked();
                }else if(e.getSource() == tile30){
                    if(!board[3][0].getFlag())board[3][0].setClicked();
                }else if(e.getSource() == tile31){
                    if(!board[3][1].getFlag())board[3][1].setClicked();
                }else if(e.getSource() == tile32){
                    if(!board[3][2].getFlag())board[3][2].setClicked();
                }else if(e.getSource() == tile33){
                    if(!board[3][3].getFlag())board[3][3].setClicked();
                }else if(e.getSource() == tile34){
                    if(!board[3][4].getFlag())board[3][4].setClicked();
                }else if(e.getSource() == tile35){
                    if(!board[3][5].getFlag())board[3][5].setClicked();
                }else if(e.getSource() == tile36){
                    if(!board[3][6].getFlag())board[3][6].setClicked();
                }else if(e.getSource() == tile37){
                    if(!board[3][7].getFlag())board[3][7].setClicked();
                }else if(e.getSource() == tile38){
                    if(!board[3][8].getFlag())board[3][8].setClicked();
                }else if(e.getSource() == tile40){
                    if(!board[4][0].getFlag())board[4][0].setClicked();
                }else if(e.getSource() == tile41){
                    if(!board[4][1].getFlag())board[4][1].setClicked();
                }else if(e.getSource() == tile42){
                    if(!board[4][2].getFlag())board[4][2].setClicked();
                }else if(e.getSource() == tile43){
                    if(!board[4][3].getFlag())board[4][3].setClicked();
                }else if(e.getSource() == tile44){
                    if(!board[4][4].getFlag())board[4][4].setClicked();
                }else if(e.getSource() == tile45){
                    if(!board[4][5].getFlag())board[4][5].setClicked();
                }else if(e.getSource() == tile46){
                    if(!board[4][6].getFlag())board[4][6].setClicked();
                }else if(e.getSource() == tile47){
                    if(!board[4][7].getFlag())board[4][7].setClicked();
                }else if(e.getSource() == tile48){
                    if(!board[4][8].getFlag())board[4][8].setClicked();
                }else if(e.getSource() == tile50){
                    if(!board[5][0].getFlag())board[5][0].setClicked();
                }else if(e.getSource() == tile51){
                    if(!board[5][1].getFlag())board[5][1].setClicked();
                }else if(e.getSource() == tile52){
                    if(!board[5][2].getFlag())board[5][2].setClicked();
                }else if(e.getSource() == tile53){
                    if(!board[5][3].getFlag())board[5][3].setClicked();
                }else if(e.getSource() == tile54){
                    if(!board[5][4].getFlag())board[5][4].setClicked();
                }else if(e.getSource() == tile55){
                    if(!board[5][5].getFlag())board[5][5].setClicked();
                }else if(e.getSource() == tile56){
                    if(!board[5][6].getFlag())board[5][6].setClicked();
                }else if(e.getSource() == tile57){
                    if(!board[5][7].getFlag())board[5][7].setClicked();
                }else if(e.getSource() == tile58){
                    if(!board[5][8].getFlag())board[5][8].setClicked();
                }else if(e.getSource() == tile60){
                    if(!board[6][0].getFlag())board[6][0].setClicked();
                }else if(e.getSource() == tile61){
                    if(!board[6][1].getFlag())board[6][1].setClicked();
                }else if(e.getSource() == tile62){
                    if(!board[6][2].getFlag())board[6][2].setClicked();
                }else if(e.getSource() == tile63){
                    if(!board[6][3].getFlag())board[6][3].setClicked();
                }else if(e.getSource() == tile64){
                    if(!board[6][4].getFlag())board[6][4].setClicked();
                }else if(e.getSource() == tile65){
                    if(!board[6][5].getFlag())board[6][5].setClicked();
                }else if(e.getSource() == tile66){
                    if(!board[6][6].getFlag())board[6][6].setClicked();
                }else if(e.getSource() == tile67){
                    if(!board[6][7].getFlag())board[6][7].setClicked();
                }else if(e.getSource() == tile68){
                    if(!board[6][8].getFlag())board[6][8].setClicked();
                }else if(e.getSource() == tile70){
                    if(!board[7][0].getFlag())board[7][0].setClicked();
                }else if(e.getSource() == tile71){
                    if(!board[7][1].getFlag())board[7][1].setClicked();
                }else if(e.getSource() == tile72){
                    if(!board[7][2].getFlag())board[7][2].setClicked();
                }else if(e.getSource() == tile73){
                    if(!board[7][3].getFlag())board[7][3].setClicked();
                }else if(e.getSource() == tile74){
                    if(!board[7][4].getFlag())board[7][4].setClicked();
                }else if(e.getSource() == tile75){
                    if(!board[7][5].getFlag())board[7][5].setClicked();
                }else if(e.getSource() == tile76){
                    if(!board[7][6].getFlag())board[7][6].setClicked();
                }else if(e.getSource() == tile77){
                    if(!board[7][7].getFlag())board[7][7].setClicked();
                }else if(e.getSource() == tile78){
                    if(!board[7][8].getFlag())board[7][8].setClicked();
                }else if(e.getSource() == tile80){
                    if(!board[8][0].getFlag())board[8][0].setClicked();
                }else if(e.getSource() == tile81){
                    if(!board[8][1].getFlag())board[8][1].setClicked();
                }else if(e.getSource() == tile82){
                    if(!board[8][2].getFlag())board[8][2].setClicked();
                }else if(e.getSource() == tile83){
                    if(!board[8][3].getFlag())board[8][3].setClicked();
                }else if(e.getSource() == tile84){
                    if(!board[8][4].getFlag())board[8][4].setClicked();
                }else if(e.getSource() == tile85){
                    if(!board[8][5].getFlag())board[8][5].setClicked();
                }else if(e.getSource() == tile86){
                    if(!board[8][6].getFlag())board[8][6].setClicked();
                }else if(e.getSource() == tile87){
                    if(!board[8][7].getFlag())board[8][7].setClicked();
                }else if(e.getSource() == tile88){
                    if(!board[8][8].getFlag())board[8][8].setClicked();
                }
            }
            updateBoard();
            if(boardComplete()){
                gameWin();
            }
        }
    }
    
    public void updateAdjacent(int r, int c){
        if(r == 0){
            if(c == 0){
                //check top left tile
                if(board[r][c+1].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c+1].getMine()) board[r][c].addAdjacent();
            }else if(c == 8){
                //check top right tile
                if(board[r][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c-1].getMine()) board[r][c].addAdjacent();
            }else{
                //check top middle tiles
                if(board[r][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r][c+1].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c+1].getMine()) board[r][c].addAdjacent();
            }
        }else if(r == 8){
            if(c == 0){
                //check bottom left tile
                if(board[r][c+1].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c+1].getMine()) board[r][c].addAdjacent();
            }else if(c == 8){
                //check bottom right tile
                if(board[r][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c-1].getMine()) board[r][c].addAdjacent();
            }else{
                //check bottom middle tiles
                if(board[r][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r][c+1].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c+1].getMine()) board[r][c].addAdjacent();
            }
        }else{
            if(c == 0){
                //check center left tiles
                if(board[r-1][c].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c+1].getMine()) board[r][c].addAdjacent();
                if(board[r][c+1].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c+1].getMine()) board[r][c].addAdjacent();
            }else if(c == 8){
                //check center right tiles
                if(board[r-1][c].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c-1].getMine()) board[r][c].addAdjacent();
            }else{
                //check all center middle tiles
                if(board[r-1][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c].getMine()) board[r][c].addAdjacent();
                if(board[r-1][c+1].getMine()) board[r][c].addAdjacent();
                if(board[r][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r][c+1].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c-1].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c].getMine()) board[r][c].addAdjacent();
                if(board[r+1][c+1].getMine()) board[r][c].addAdjacent();
            }
        }
    }
    
    public void updateAdjacentColors(){
        for(int r = 0; r < board.length; r++){
            for( int c = 0; c < board[r].length; c++){
                if(board[r][c].getMine()){
                    
                }else if(board[r][c].getAdjacent() == 1){
                    if(r == 0 && c == 0){
                        tile00.setForeground(Color.BLUE);
                    }else if(r == 0 && c == 1){
                        tile01.setForeground(Color.BLUE);
                    }else if(r == 0 && c == 2){
                        tile02.setForeground(Color.BLUE);
                    }else if(r == 0 && c == 3){
                        tile03.setForeground(Color.BLUE);
                    }else if(r == 0 && c == 4){
                        tile04.setForeground(Color.BLUE);
                    }else if(r == 0 && c == 5){
                        tile05.setForeground(Color.BLUE);
                    }else if(r == 0 && c == 6){
                        tile06.setForeground(Color.BLUE);
                    }else if(r == 0 && c == 7){
                        tile07.setForeground(Color.BLUE);
                    }else if(r == 0 && c == 8){
                        tile08.setForeground(Color.BLUE);
                    }else if(r == 1 && c == 0){
                        tile10.setForeground(Color.BLUE);
                    }else if(r == 1 && c == 1){
                        tile11.setForeground(Color.BLUE);
                    }else if(r == 1 && c == 2){
                        tile12.setForeground(Color.BLUE);
                    }else if(r == 1 && c == 3){
                        tile13.setForeground(Color.BLUE);
                    }else if(r == 1 && c == 4){
                        tile14.setForeground(Color.BLUE);
                    }else if(r == 1 && c == 5){
                        tile15.setForeground(Color.BLUE);
                    }else if(r == 1 && c == 6){
                        tile16.setForeground(Color.BLUE);
                    }else if(r == 1 && c == 7){
                        tile17.setForeground(Color.BLUE);
                    }else if(r == 1 && c == 8){
                        tile18.setForeground(Color.BLUE);
                    }else if(r == 2 && c == 0){
                        tile20.setForeground(Color.BLUE);
                    }else if(r == 2 && c == 1){
                        tile21.setForeground(Color.BLUE);
                    }else if(r == 2 && c == 2){
                        tile22.setForeground(Color.BLUE);
                    }else if(r == 2 && c == 3){
                        tile23.setForeground(Color.BLUE);
                    }else if(r == 2 && c == 4){
                        tile24.setForeground(Color.BLUE);
                    }else if(r == 2 && c == 5){
                        tile25.setForeground(Color.BLUE);
                    }else if(r == 2 && c == 6){
                        tile26.setForeground(Color.BLUE);
                    }else if(r == 2 && c == 7){
                        tile27.setForeground(Color.BLUE);
                    }else if(r == 2 && c == 8){
                        tile28.setForeground(Color.BLUE);
                    }else if(r == 3 && c == 0){
                        tile30.setForeground(Color.BLUE);
                    }else if(r == 3 && c == 1){
                        tile31.setForeground(Color.BLUE);
                    }else if(r == 3 && c == 2){
                        tile32.setForeground(Color.BLUE);
                    }else if(r == 3 && c == 3){
                        tile33.setForeground(Color.BLUE);
                    }else if(r == 3 && c == 4){
                        tile34.setForeground(Color.BLUE);
                    }else if(r == 3 && c == 5){
                        tile35.setForeground(Color.BLUE);
                    }else if(r == 3 && c == 6){
                        tile36.setForeground(Color.BLUE);
                    }else if(r == 3 && c == 7){
                        tile37.setForeground(Color.BLUE);
                    }else if(r == 3 && c == 8){
                        tile38.setForeground(Color.BLUE);
                    }else if(r == 4 && c == 0){
                        tile40.setForeground(Color.BLUE);
                    }else if(r == 4 && c == 1){
                        tile41.setForeground(Color.BLUE);
                    }else if(r == 4 && c == 2){
                        tile42.setForeground(Color.BLUE);
                    }else if(r == 4 && c == 3){
                        tile43.setForeground(Color.BLUE);
                    }else if(r == 4 && c == 4){
                        tile44.setForeground(Color.BLUE);
                    }else if(r == 4 && c == 5){
                        tile45.setForeground(Color.BLUE);
                    }else if(r == 4 && c == 6){
                        tile46.setForeground(Color.BLUE);
                    }else if(r == 4 && c == 7){
                        tile47.setForeground(Color.BLUE);
                    }else if(r == 4 && c == 8){
                        tile48.setForeground(Color.BLUE);
                    }else if(r == 5 && c == 0){
                        tile50.setForeground(Color.BLUE);
                    }else if(r == 5 && c == 1){
                        tile51.setForeground(Color.BLUE);
                    }else if(r == 5 && c == 2){
                        tile52.setForeground(Color.BLUE);
                    }else if(r == 5 && c == 3){
                        tile53.setForeground(Color.BLUE);
                    }else if(r == 5 && c == 4){
                        tile54.setForeground(Color.BLUE);
                    }else if(r == 5 && c == 5){
                        tile55.setForeground(Color.BLUE);
                    }else if(r == 5 && c == 6){
                        tile56.setForeground(Color.BLUE);
                    }else if(r == 5 && c == 7){
                        tile57.setForeground(Color.BLUE);
                    }else if(r == 5 && c == 8){
                        tile58.setForeground(Color.BLUE);
                    }else if(r == 6 && c == 0){
                        tile60.setForeground(Color.BLUE);
                    }else if(r == 6 && c == 1){
                        tile61.setForeground(Color.BLUE);
                    }else if(r == 6 && c == 2){
                        tile62.setForeground(Color.BLUE);
                    }else if(r == 6 && c == 3){
                        tile63.setForeground(Color.BLUE);
                    }else if(r == 6 && c == 4){
                        tile64.setForeground(Color.BLUE);
                    }else if(r == 6 && c == 5){
                        tile65.setForeground(Color.BLUE);
                    }else if(r== 6 && c == 6){
                        tile66.setForeground(Color.BLUE);
                    }else if(r == 6 && c == 7){
                        tile67.setForeground(Color.BLUE);
                    }else if(r == 6 && c == 8){
                        tile68.setForeground(Color.BLUE);
                    }else if(r == 7 && c == 0){
                        tile70.setForeground(Color.BLUE);
                    }else if(r == 7 && c == 1){
                        tile71.setForeground(Color.BLUE);
                    }else if(r == 7 && c == 2){
                        tile72.setForeground(Color.BLUE);
                    }else if(r == 7 && c == 3){
                        tile73.setForeground(Color.BLUE);
                    }else if(r == 7 && c == 4){
                        tile74.setForeground(Color.BLUE);
                    }else if(r == 7 && c == 5){
                        tile75.setForeground(Color.BLUE);
                    }else if(r == 7 && c == 6){
                        tile76.setForeground(Color.BLUE);
                    }else if(r == 7 && c == 7){
                        tile77.setForeground(Color.BLUE);
                    }else if(r == 7 && c == 8){
                        tile78.setForeground(Color.BLUE);
                    }else if(r == 8 && c == 0){
                        tile80.setForeground(Color.BLUE);
                    }else if(r == 8 && c == 1){
                        tile81.setForeground(Color.BLUE);
                    }else if(r == 8 && c == 2){
                        tile82.setForeground(Color.BLUE);
                    }else if(r == 8 && c == 3){
                        tile83.setForeground(Color.BLUE);
                    }else if(r == 8 && c == 4){
                        tile84.setForeground(Color.BLUE);
                    }else if(r == 8 && c == 5){
                        tile85.setForeground(Color.BLUE);
                    }else if(r == 8 && c == 6){
                        tile86.setForeground(Color.BLUE);
                    }else if(r == 8 && c == 7){
                        tile87.setForeground(Color.BLUE);
                    }else if(r == 8 && c == 8){
                        tile88.setForeground(Color.BLUE);
                    }
                }else if(board[r][c].getAdjacent() == 2){
                    if(r == 0 && c == 0){
                        tile00.setForeground(Color.GREEN);
                    }else if(r == 0 && c == 1){
                        tile01.setForeground(Color.GREEN);
                    }else if(r == 0 && c == 2){
                        tile02.setForeground(Color.GREEN);
                    }else if(r == 0 && c == 3){
                        tile03.setForeground(Color.GREEN);
                    }else if(r == 0 && c == 4){
                        tile04.setForeground(Color.GREEN);
                    }else if(r == 0 && c == 5){
                        tile05.setForeground(Color.GREEN);
                    }else if(r == 0 && c == 6){
                        tile06.setForeground(Color.GREEN);
                    }else if(r == 0 && c == 7){
                        tile07.setForeground(Color.GREEN);
                    }else if(r == 0 && c == 8){
                        tile08.setForeground(Color.GREEN);
                    }else if(r == 1 && c == 0){
                        tile10.setForeground(Color.GREEN);
                    }else if(r == 1 && c == 1){
                        tile11.setForeground(Color.GREEN);
                    }else if(r == 1 && c == 2){
                        tile12.setForeground(Color.GREEN);
                    }else if(r == 1 && c == 3){
                        tile13.setForeground(Color.GREEN);
                    }else if(r == 1 && c == 4){
                        tile14.setForeground(Color.GREEN);
                    }else if(r == 1 && c == 5){
                        tile15.setForeground(Color.GREEN);
                    }else if(r == 1 && c == 6){
                        tile16.setForeground(Color.GREEN);
                    }else if(r == 1 && c == 7){
                        tile17.setForeground(Color.GREEN);
                    }else if(r == 1 && c == 8){
                        tile18.setForeground(Color.GREEN);
                    }else if(r == 2 && c == 0){
                        tile20.setForeground(Color.GREEN);
                    }else if(r == 2 && c == 1){
                        tile21.setForeground(Color.GREEN);
                    }else if(r == 2 && c == 2){
                        tile22.setForeground(Color.GREEN);
                    }else if(r == 2 && c == 3){
                        tile23.setForeground(Color.GREEN);
                    }else if(r == 2 && c == 4){
                        tile24.setForeground(Color.GREEN);
                    }else if(r == 2 && c == 5){
                        tile25.setForeground(Color.GREEN);
                    }else if(r == 2 && c == 6){
                        tile26.setForeground(Color.GREEN);
                    }else if(r == 2 && c == 7){
                        tile27.setForeground(Color.GREEN);
                    }else if(r == 2 && c == 8){
                        tile28.setForeground(Color.GREEN);
                    }else if(r == 3 && c == 0){
                        tile30.setForeground(Color.GREEN);
                    }else if(r == 3 && c == 1){
                        tile31.setForeground(Color.GREEN);
                    }else if(r == 3 && c == 2){
                        tile32.setForeground(Color.GREEN);
                    }else if(r == 3 && c == 3){
                        tile33.setForeground(Color.GREEN);
                    }else if(r == 3 && c == 4){
                        tile34.setForeground(Color.GREEN);
                    }else if(r == 3 && c == 5){
                        tile35.setForeground(Color.GREEN);
                    }else if(r == 3 && c == 6){
                        tile36.setForeground(Color.GREEN);
                    }else if(r == 3 && c == 7){
                        tile37.setForeground(Color.GREEN);
                    }else if(r == 3 && c == 8){
                        tile38.setForeground(Color.GREEN);
                    }else if(r == 4 && c == 0){
                        tile40.setForeground(Color.GREEN);
                    }else if(r == 4 && c == 1){
                        tile41.setForeground(Color.GREEN);
                    }else if(r == 4 && c == 2){
                        tile42.setForeground(Color.GREEN);
                    }else if(r == 4 && c == 3){
                        tile43.setForeground(Color.GREEN);
                    }else if(r == 4 && c == 4){
                        tile44.setForeground(Color.GREEN);
                    }else if(r == 4 && c == 5){
                        tile45.setForeground(Color.GREEN);
                    }else if(r == 4 && c == 6){
                        tile46.setForeground(Color.GREEN);
                    }else if(r == 4 && c == 7){
                        tile47.setForeground(Color.GREEN);
                    }else if(r == 4 && c == 8){
                        tile48.setForeground(Color.GREEN);
                    }else if(r == 5 && c == 0){
                        tile50.setForeground(Color.GREEN);
                    }else if(r == 5 && c == 1){
                        tile51.setForeground(Color.GREEN);
                    }else if(r == 5 && c == 2){
                        tile52.setForeground(Color.GREEN);
                    }else if(r == 5 && c == 3){
                        tile53.setForeground(Color.GREEN);
                    }else if(r == 5 && c == 4){
                        tile54.setForeground(Color.GREEN);
                    }else if(r == 5 && c == 5){
                        tile55.setForeground(Color.GREEN);
                    }else if(r == 5 && c == 6){
                        tile56.setForeground(Color.GREEN);
                    }else if(r == 5 && c == 7){
                        tile57.setForeground(Color.GREEN);
                    }else if(r == 5 && c == 8){
                        tile58.setForeground(Color.GREEN);
                    }else if(r == 6 && c == 0){
                        tile60.setForeground(Color.GREEN);
                    }else if(r == 6 && c == 1){
                        tile61.setForeground(Color.GREEN);
                    }else if(r == 6 && c == 2){
                        tile62.setForeground(Color.GREEN);
                    }else if(r == 6 && c == 3){
                        tile63.setForeground(Color.GREEN);
                    }else if(r == 6 && c == 4){
                        tile64.setForeground(Color.GREEN);
                    }else if(r == 6 && c == 5){
                        tile65.setForeground(Color.GREEN);
                    }else if(r== 6 && c == 6){
                        tile66.setForeground(Color.GREEN);
                    }else if(r == 6 && c == 7){
                        tile67.setForeground(Color.GREEN);
                    }else if(r == 6 && c == 8){
                        tile68.setForeground(Color.GREEN);
                    }else if(r == 7 && c == 0){
                        tile70.setForeground(Color.GREEN);
                    }else if(r == 7 && c == 1){
                        tile71.setForeground(Color.GREEN);
                    }else if(r == 7 && c == 2){
                        tile72.setForeground(Color.GREEN);
                    }else if(r == 7 && c == 3){
                        tile73.setForeground(Color.GREEN);
                    }else if(r == 7 && c == 4){
                        tile74.setForeground(Color.GREEN);
                    }else if(r == 7 && c == 5){
                        tile75.setForeground(Color.GREEN);
                    }else if(r == 7 && c == 6){
                        tile76.setForeground(Color.GREEN);
                    }else if(r == 7 && c == 7){
                        tile77.setForeground(Color.GREEN);
                    }else if(r == 7 && c == 8){
                        tile78.setForeground(Color.GREEN);
                    }else if(r == 8 && c == 0){
                        tile80.setForeground(Color.GREEN);
                    }else if(r == 8 && c == 1){
                        tile81.setForeground(Color.GREEN);
                    }else if(r == 8 && c == 2){
                        tile82.setForeground(Color.GREEN);
                    }else if(r == 8 && c == 3){
                        tile83.setForeground(Color.GREEN);
                    }else if(r == 8 && c == 4){
                        tile84.setForeground(Color.GREEN);
                    }else if(r == 8 && c == 5){
                        tile85.setForeground(Color.GREEN);
                    }else if(r == 8 && c == 6){
                        tile86.setForeground(Color.GREEN);
                    }else if(r == 8 && c == 7){
                        tile87.setForeground(Color.GREEN);
                    }else if(r == 8 && c == 8){
                        tile88.setForeground(Color.GREEN);
                    }
                }else if(board[r][c].getAdjacent() == 3){
                    if(r == 0 && c == 0){
                        tile00.setForeground(Color.RED);
                    }else if(r == 0 && c == 1){
                        tile01.setForeground(Color.RED);
                    }else if(r == 0 && c == 2){
                        tile02.setForeground(Color.RED);
                    }else if(r == 0 && c == 3){
                        tile03.setForeground(Color.RED);
                    }else if(r == 0 && c == 4){
                        tile04.setForeground(Color.RED);
                    }else if(r == 0 && c == 5){
                        tile05.setForeground(Color.RED);
                    }else if(r == 0 && c == 6){
                        tile06.setForeground(Color.RED);
                    }else if(r == 0 && c == 7){
                        tile07.setForeground(Color.RED);
                    }else if(r == 0 && c == 8){
                        tile08.setForeground(Color.RED);
                    }else if(r == 1 && c == 0){
                        tile10.setForeground(Color.RED);
                    }else if(r == 1 && c == 1){
                        tile11.setForeground(Color.RED);
                    }else if(r == 1 && c == 2){
                        tile12.setForeground(Color.RED);
                    }else if(r == 1 && c == 3){
                        tile13.setForeground(Color.RED);
                    }else if(r == 1 && c == 4){
                        tile14.setForeground(Color.RED);
                    }else if(r == 1 && c == 5){
                        tile15.setForeground(Color.RED);
                    }else if(r == 1 && c == 6){
                        tile16.setForeground(Color.RED);
                    }else if(r == 1 && c == 7){
                        tile17.setForeground(Color.RED);
                    }else if(r == 1 && c == 8){
                        tile18.setForeground(Color.RED);
                    }else if(r == 2 && c == 0){
                        tile20.setForeground(Color.RED);
                    }else if(r == 2 && c == 1){
                        tile21.setForeground(Color.RED);
                    }else if(r == 2 && c == 2){
                        tile22.setForeground(Color.RED);
                    }else if(r == 2 && c == 3){
                        tile23.setForeground(Color.RED);
                    }else if(r == 2 && c == 4){
                        tile24.setForeground(Color.RED);
                    }else if(r == 2 && c == 5){
                        tile25.setForeground(Color.RED);
                    }else if(r == 2 && c == 6){
                        tile26.setForeground(Color.RED);
                    }else if(r == 2 && c == 7){
                        tile27.setForeground(Color.RED);
                    }else if(r == 2 && c == 8){
                        tile28.setForeground(Color.RED);
                    }else if(r == 3 && c == 0){
                        tile30.setForeground(Color.RED);
                    }else if(r == 3 && c == 1){
                        tile31.setForeground(Color.RED);
                    }else if(r == 3 && c == 2){
                        tile32.setForeground(Color.RED);
                    }else if(r == 3 && c == 3){
                        tile33.setForeground(Color.RED);
                    }else if(r == 3 && c == 4){
                        tile34.setForeground(Color.RED);
                    }else if(r == 3 && c == 5){
                        tile35.setForeground(Color.RED);
                    }else if(r == 3 && c == 6){
                        tile36.setForeground(Color.RED);
                    }else if(r == 3 && c == 7){
                        tile37.setForeground(Color.RED);
                    }else if(r == 3 && c == 8){
                        tile38.setForeground(Color.RED);
                    }else if(r == 4 && c == 0){
                        tile40.setForeground(Color.RED);
                    }else if(r == 4 && c == 1){
                        tile41.setForeground(Color.RED);
                    }else if(r == 4 && c == 2){
                        tile42.setForeground(Color.RED);
                    }else if(r == 4 && c == 3){
                        tile43.setForeground(Color.RED);
                    }else if(r == 4 && c == 4){
                        tile44.setForeground(Color.RED);
                    }else if(r == 4 && c == 5){
                        tile45.setForeground(Color.RED);
                    }else if(r == 4 && c == 6){
                        tile46.setForeground(Color.RED);
                    }else if(r == 4 && c == 7){
                        tile47.setForeground(Color.RED);
                    }else if(r == 4 && c == 8){
                        tile48.setForeground(Color.RED);
                    }else if(r == 5 && c == 0){
                        tile50.setForeground(Color.RED);
                    }else if(r == 5 && c == 1){
                        tile51.setForeground(Color.RED);
                    }else if(r == 5 && c == 2){
                        tile52.setForeground(Color.RED);
                    }else if(r == 5 && c == 3){
                        tile53.setForeground(Color.RED);
                    }else if(r == 5 && c == 4){
                        tile54.setForeground(Color.RED);
                    }else if(r == 5 && c == 5){
                        tile55.setForeground(Color.RED);
                    }else if(r == 5 && c == 6){
                        tile56.setForeground(Color.RED);
                    }else if(r == 5 && c == 7){
                        tile57.setForeground(Color.RED);
                    }else if(r == 5 && c == 8){
                        tile58.setForeground(Color.RED);
                    }else if(r == 6 && c == 0){
                        tile60.setForeground(Color.RED);
                    }else if(r == 6 && c == 1){
                        tile61.setForeground(Color.RED);
                    }else if(r == 6 && c == 2){
                        tile62.setForeground(Color.RED);
                    }else if(r == 6 && c == 3){
                        tile63.setForeground(Color.RED);
                    }else if(r == 6 && c == 4){
                        tile64.setForeground(Color.RED);
                    }else if(r == 6 && c == 5){
                        tile65.setForeground(Color.RED);
                    }else if(r== 6 && c == 6){
                        tile66.setForeground(Color.RED);
                    }else if(r == 6 && c == 7){
                        tile67.setForeground(Color.RED);
                    }else if(r == 6 && c == 8){
                        tile68.setForeground(Color.RED);
                    }else if(r == 7 && c == 0){
                        tile70.setForeground(Color.RED);
                    }else if(r == 7 && c == 1){
                        tile71.setForeground(Color.RED);
                    }else if(r == 7 && c == 2){
                        tile72.setForeground(Color.RED);
                    }else if(r == 7 && c == 3){
                        tile73.setForeground(Color.RED);
                    }else if(r == 7 && c == 4){
                        tile74.setForeground(Color.RED);
                    }else if(r == 7 && c == 5){
                        tile75.setForeground(Color.RED);
                    }else if(r == 7 && c == 6){
                        tile76.setForeground(Color.RED);
                    }else if(r == 7 && c == 7){
                        tile77.setForeground(Color.RED);
                    }else if(r == 7 && c == 8){
                        tile78.setForeground(Color.RED);
                    }else if(r == 8 && c == 0){
                        tile80.setForeground(Color.RED);
                    }else if(r == 8 && c == 1){
                        tile81.setForeground(Color.RED);
                    }else if(r == 8 && c == 2){
                        tile82.setForeground(Color.RED);
                    }else if(r == 8 && c == 3){
                        tile83.setForeground(Color.RED);
                    }else if(r == 8 && c == 4){
                        tile84.setForeground(Color.RED);
                    }else if(r == 8 && c == 5){
                        tile85.setForeground(Color.RED);
                    }else if(r == 8 && c == 6){
                        tile86.setForeground(Color.RED);
                    }else if(r == 8 && c == 7){
                        tile87.setForeground(Color.RED);
                    }else if(r == 8 && c == 8){
                        tile88.setForeground(Color.RED);
                    }
                }else if(board[r][c].getAdjacent() == 4){
                    if(r == 0 && c == 0){
                        tile00.setForeground(Color.ORANGE);
                    }else if(r == 0 && c == 1){
                        tile01.setForeground(Color.ORANGE);
                    }else if(r == 0 && c == 2){
                        tile02.setForeground(Color.ORANGE);
                    }else if(r == 0 && c == 3){
                        tile03.setForeground(Color.ORANGE);
                    }else if(r == 0 && c == 4){
                        tile04.setForeground(Color.ORANGE);
                    }else if(r == 0 && c == 5){
                        tile05.setForeground(Color.ORANGE);
                    }else if(r == 0 && c == 6){
                        tile06.setForeground(Color.ORANGE);
                    }else if(r == 0 && c == 7){
                        tile07.setForeground(Color.ORANGE);
                    }else if(r == 0 && c == 8){
                        tile08.setForeground(Color.ORANGE);
                    }else if(r == 1 && c == 0){
                        tile10.setForeground(Color.ORANGE);
                    }else if(r == 1 && c == 1){
                        tile11.setForeground(Color.ORANGE);
                    }else if(r == 1 && c == 2){
                        tile12.setForeground(Color.ORANGE);
                    }else if(r == 1 && c == 3){
                        tile13.setForeground(Color.ORANGE);
                    }else if(r == 1 && c == 4){
                        tile14.setForeground(Color.ORANGE);
                    }else if(r == 1 && c == 5){
                        tile15.setForeground(Color.ORANGE);
                    }else if(r == 1 && c == 6){
                        tile16.setForeground(Color.ORANGE);
                    }else if(r == 1 && c == 7){
                        tile17.setForeground(Color.ORANGE);
                    }else if(r == 1 && c == 8){
                        tile18.setForeground(Color.ORANGE);
                    }else if(r == 2 && c == 0){
                        tile20.setForeground(Color.ORANGE);
                    }else if(r == 2 && c == 1){
                        tile21.setForeground(Color.ORANGE);
                    }else if(r == 2 && c == 2){
                        tile22.setForeground(Color.ORANGE);
                    }else if(r == 2 && c == 3){
                        tile23.setForeground(Color.ORANGE);
                    }else if(r == 2 && c == 4){
                        tile24.setForeground(Color.ORANGE);
                    }else if(r == 2 && c == 5){
                        tile25.setForeground(Color.ORANGE);
                    }else if(r == 2 && c == 6){
                        tile26.setForeground(Color.ORANGE);
                    }else if(r == 2 && c == 7){
                        tile27.setForeground(Color.ORANGE);
                    }else if(r == 2 && c == 8){
                        tile28.setForeground(Color.ORANGE);
                    }else if(r == 3 && c == 0){
                        tile30.setForeground(Color.ORANGE);
                    }else if(r == 3 && c == 1){
                        tile31.setForeground(Color.ORANGE);
                    }else if(r == 3 && c == 2){
                        tile32.setForeground(Color.ORANGE);
                    }else if(r == 3 && c == 3){
                        tile33.setForeground(Color.ORANGE);
                    }else if(r == 3 && c == 4){
                        tile34.setForeground(Color.ORANGE);
                    }else if(r == 3 && c == 5){
                        tile35.setForeground(Color.ORANGE);
                    }else if(r == 3 && c == 6){
                        tile36.setForeground(Color.ORANGE);
                    }else if(r == 3 && c == 7){
                        tile37.setForeground(Color.ORANGE);
                    }else if(r == 3 && c == 8){
                        tile38.setForeground(Color.ORANGE);
                    }else if(r == 4 && c == 0){
                        tile40.setForeground(Color.ORANGE);
                    }else if(r == 4 && c == 1){
                        tile41.setForeground(Color.ORANGE);
                    }else if(r == 4 && c == 2){
                        tile42.setForeground(Color.ORANGE);
                    }else if(r == 4 && c == 3){
                        tile43.setForeground(Color.ORANGE);
                    }else if(r == 4 && c == 4){
                        tile44.setForeground(Color.ORANGE);
                    }else if(r == 4 && c == 5){
                        tile45.setForeground(Color.ORANGE);
                    }else if(r == 4 && c == 6){
                        tile46.setForeground(Color.ORANGE);
                    }else if(r == 4 && c == 7){
                        tile47.setForeground(Color.ORANGE);
                    }else if(r == 4 && c == 8){
                        tile48.setForeground(Color.ORANGE);
                    }else if(r == 5 && c == 0){
                        tile50.setForeground(Color.ORANGE);
                    }else if(r == 5 && c == 1){
                        tile51.setForeground(Color.ORANGE);
                    }else if(r == 5 && c == 2){
                        tile52.setForeground(Color.ORANGE);
                    }else if(r == 5 && c == 3){
                        tile53.setForeground(Color.ORANGE);
                    }else if(r == 5 && c == 4){
                        tile54.setForeground(Color.ORANGE);
                    }else if(r == 5 && c == 5){
                        tile55.setForeground(Color.ORANGE);
                    }else if(r == 5 && c == 6){
                        tile56.setForeground(Color.ORANGE);
                    }else if(r == 5 && c == 7){
                        tile57.setForeground(Color.ORANGE);
                    }else if(r == 5 && c == 8){
                        tile58.setForeground(Color.ORANGE);
                    }else if(r == 6 && c == 0){
                        tile60.setForeground(Color.ORANGE);
                    }else if(r == 6 && c == 1){
                        tile61.setForeground(Color.ORANGE);
                    }else if(r == 6 && c == 2){
                        tile62.setForeground(Color.ORANGE);
                    }else if(r == 6 && c == 3){
                        tile63.setForeground(Color.ORANGE);
                    }else if(r == 6 && c == 4){
                        tile64.setForeground(Color.ORANGE);
                    }else if(r == 6 && c == 5){
                        tile65.setForeground(Color.ORANGE);
                    }else if(r== 6 && c == 6){
                        tile66.setForeground(Color.ORANGE);
                    }else if(r == 6 && c == 7){
                        tile67.setForeground(Color.ORANGE);
                    }else if(r == 6 && c == 8){
                        tile68.setForeground(Color.ORANGE);
                    }else if(r == 7 && c == 0){
                        tile70.setForeground(Color.ORANGE);
                    }else if(r == 7 && c == 1){
                        tile71.setForeground(Color.ORANGE);
                    }else if(r == 7 && c == 2){
                        tile72.setForeground(Color.ORANGE);
                    }else if(r == 7 && c == 3){
                        tile73.setForeground(Color.ORANGE);
                    }else if(r == 7 && c == 4){
                        tile74.setForeground(Color.ORANGE);
                    }else if(r == 7 && c == 5){
                        tile75.setForeground(Color.ORANGE);
                    }else if(r == 7 && c == 6){
                        tile76.setForeground(Color.ORANGE);
                    }else if(r == 7 && c == 7){
                        tile77.setForeground(Color.ORANGE);
                    }else if(r == 7 && c == 8){
                        tile78.setForeground(Color.ORANGE);
                    }else if(r == 8 && c == 0){
                        tile80.setForeground(Color.ORANGE);
                    }else if(r == 8 && c == 1){
                        tile81.setForeground(Color.ORANGE);
                    }else if(r == 8 && c == 2){
                        tile82.setForeground(Color.ORANGE);
                    }else if(r == 8 && c == 3){
                        tile83.setForeground(Color.ORANGE);
                    }else if(r == 8 && c == 4){
                        tile84.setForeground(Color.ORANGE);
                    }else if(r == 8 && c == 5){
                        tile85.setForeground(Color.ORANGE);
                    }else if(r == 8 && c == 6){
                        tile86.setForeground(Color.ORANGE);
                    }else if(r == 8 && c == 7){
                        tile87.setForeground(Color.ORANGE);
                    }else if(r == 8 && c == 8){
                        tile88.setForeground(Color.ORANGE);
                    }
                }else if(board[r][c].getAdjacent() == 5){
                    if(r == 0 && c == 0){
                        tile00.setForeground(Color.GRAY);
                    }else if(r == 0 && c == 1){
                        tile01.setForeground(Color.GRAY);
                    }else if(r == 0 && c == 2){
                        tile02.setForeground(Color.GRAY);
                    }else if(r == 0 && c == 3){
                        tile03.setForeground(Color.GRAY);
                    }else if(r == 0 && c == 4){
                        tile04.setForeground(Color.GRAY);
                    }else if(r == 0 && c == 5){
                        tile05.setForeground(Color.GRAY);
                    }else if(r == 0 && c == 6){
                        tile06.setForeground(Color.GRAY);
                    }else if(r == 0 && c == 7){
                        tile07.setForeground(Color.GRAY);
                    }else if(r == 0 && c == 8){
                        tile08.setForeground(Color.GRAY);
                    }else if(r == 1 && c == 0){
                        tile10.setForeground(Color.GRAY);
                    }else if(r == 1 && c == 1){
                        tile11.setForeground(Color.GRAY);
                    }else if(r == 1 && c == 2){
                        tile12.setForeground(Color.GRAY);
                    }else if(r == 1 && c == 3){
                        tile13.setForeground(Color.GRAY);
                    }else if(r == 1 && c == 4){
                        tile14.setForeground(Color.GRAY);
                    }else if(r == 1 && c == 5){
                        tile15.setForeground(Color.GRAY);
                    }else if(r == 1 && c == 6){
                        tile16.setForeground(Color.GRAY);
                    }else if(r == 1 && c == 7){
                        tile17.setForeground(Color.GRAY);
                    }else if(r == 1 && c == 8){
                        tile18.setForeground(Color.GRAY);
                    }else if(r == 2 && c == 0){
                        tile20.setForeground(Color.GRAY);
                    }else if(r == 2 && c == 1){
                        tile21.setForeground(Color.GRAY);
                    }else if(r == 2 && c == 2){
                        tile22.setForeground(Color.GRAY);
                    }else if(r == 2 && c == 3){
                        tile23.setForeground(Color.GRAY);
                    }else if(r == 2 && c == 4){
                        tile24.setForeground(Color.GRAY);
                    }else if(r == 2 && c == 5){
                        tile25.setForeground(Color.GRAY);
                    }else if(r == 2 && c == 6){
                        tile26.setForeground(Color.GRAY);
                    }else if(r == 2 && c == 7){
                        tile27.setForeground(Color.GRAY);
                    }else if(r == 2 && c == 8){
                        tile28.setForeground(Color.GRAY);
                    }else if(r == 3 && c == 0){
                        tile30.setForeground(Color.GRAY);
                    }else if(r == 3 && c == 1){
                        tile31.setForeground(Color.GRAY);
                    }else if(r == 3 && c == 2){
                        tile32.setForeground(Color.GRAY);
                    }else if(r == 3 && c == 3){
                        tile33.setForeground(Color.GRAY);
                    }else if(r == 3 && c == 4){
                        tile34.setForeground(Color.GRAY);
                    }else if(r == 3 && c == 5){
                        tile35.setForeground(Color.GRAY);
                    }else if(r == 3 && c == 6){
                        tile36.setForeground(Color.GRAY);
                    }else if(r == 3 && c == 7){
                        tile37.setForeground(Color.GRAY);
                    }else if(r == 3 && c == 8){
                        tile38.setForeground(Color.GRAY);
                    }else if(r == 4 && c == 0){
                        tile40.setForeground(Color.GRAY);
                    }else if(r == 4 && c == 1){
                        tile41.setForeground(Color.GRAY);
                    }else if(r == 4 && c == 2){
                        tile42.setForeground(Color.GRAY);
                    }else if(r == 4 && c == 3){
                        tile43.setForeground(Color.GRAY);
                    }else if(r == 4 && c == 4){
                        tile44.setForeground(Color.GRAY);
                    }else if(r == 4 && c == 5){
                        tile45.setForeground(Color.GRAY);
                    }else if(r == 4 && c == 6){
                        tile46.setForeground(Color.GRAY);
                    }else if(r == 4 && c == 7){
                        tile47.setForeground(Color.GRAY);
                    }else if(r == 4 && c == 8){
                        tile48.setForeground(Color.GRAY);
                    }else if(r == 5 && c == 0){
                        tile50.setForeground(Color.GRAY);
                    }else if(r == 5 && c == 1){
                        tile51.setForeground(Color.GRAY);
                    }else if(r == 5 && c == 2){
                        tile52.setForeground(Color.GRAY);
                    }else if(r == 5 && c == 3){
                        tile53.setForeground(Color.GRAY);
                    }else if(r == 5 && c == 4){
                        tile54.setForeground(Color.GRAY);
                    }else if(r == 5 && c == 5){
                        tile55.setForeground(Color.GRAY);
                    }else if(r == 5 && c == 6){
                        tile56.setForeground(Color.GRAY);
                    }else if(r == 5 && c == 7){
                        tile57.setForeground(Color.GRAY);
                    }else if(r == 5 && c == 8){
                        tile58.setForeground(Color.GRAY);
                    }else if(r == 6 && c == 0){
                        tile60.setForeground(Color.GRAY);
                    }else if(r == 6 && c == 1){
                        tile61.setForeground(Color.GRAY);
                    }else if(r == 6 && c == 2){
                        tile62.setForeground(Color.GRAY);
                    }else if(r == 6 && c == 3){
                        tile63.setForeground(Color.GRAY);
                    }else if(r == 6 && c == 4){
                        tile64.setForeground(Color.GRAY);
                    }else if(r == 6 && c == 5){
                        tile65.setForeground(Color.GRAY);
                    }else if(r== 6 && c == 6){
                        tile66.setForeground(Color.GRAY);
                    }else if(r == 6 && c == 7){
                        tile67.setForeground(Color.GRAY);
                    }else if(r == 6 && c == 8){
                        tile68.setForeground(Color.GRAY);
                    }else if(r == 7 && c == 0){
                        tile70.setForeground(Color.GRAY);
                    }else if(r == 7 && c == 1){
                        tile71.setForeground(Color.GRAY);
                    }else if(r == 7 && c == 2){
                        tile72.setForeground(Color.GRAY);
                    }else if(r == 7 && c == 3){
                        tile73.setForeground(Color.GRAY);
                    }else if(r == 7 && c == 4){
                        tile74.setForeground(Color.GRAY);
                    }else if(r == 7 && c == 5){
                        tile75.setForeground(Color.GRAY);
                    }else if(r == 7 && c == 6){
                        tile76.setForeground(Color.GRAY);
                    }else if(r == 7 && c == 7){
                        tile77.setForeground(Color.GRAY);
                    }else if(r == 7 && c == 8){
                        tile78.setForeground(Color.GRAY);
                    }else if(r == 8 && c == 0){
                        tile80.setForeground(Color.GRAY);
                    }else if(r == 8 && c == 1){
                        tile81.setForeground(Color.GRAY);
                    }else if(r == 8 && c == 2){
                        tile82.setForeground(Color.GRAY);
                    }else if(r == 8 && c == 3){
                        tile83.setForeground(Color.GRAY);
                    }else if(r == 8 && c == 4){
                        tile84.setForeground(Color.GRAY);
                    }else if(r == 8 && c == 5){
                        tile85.setForeground(Color.GRAY);
                    }else if(r == 8 && c == 6){
                        tile86.setForeground(Color.GRAY);
                    }else if(r == 8 && c == 7){
                        tile87.setForeground(Color.GRAY);
                    }else if(r == 8 && c == 8){
                        tile88.setForeground(Color.GRAY);
                    }
                }else if(board[r][c].getAdjacent() == 6){
                    if(r == 0 && c == 0){
                        tile00.setForeground(Color.CYAN);
                    }else if(r == 0 && c == 1){
                        tile01.setForeground(Color.CYAN);
                    }else if(r == 0 && c == 2){
                        tile02.setForeground(Color.CYAN);
                    }else if(r == 0 && c == 3){
                        tile03.setForeground(Color.CYAN);
                    }else if(r == 0 && c == 4){
                        tile04.setForeground(Color.CYAN);
                    }else if(r == 0 && c == 5){
                        tile05.setForeground(Color.CYAN);
                    }else if(r == 0 && c == 6){
                        tile06.setForeground(Color.CYAN);
                    }else if(r == 0 && c == 7){
                        tile07.setForeground(Color.CYAN);
                    }else if(r == 0 && c == 8){
                        tile08.setForeground(Color.CYAN);
                    }else if(r == 1 && c == 0){
                        tile10.setForeground(Color.CYAN);
                    }else if(r == 1 && c == 1){
                        tile11.setForeground(Color.CYAN);
                    }else if(r == 1 && c == 2){
                        tile12.setForeground(Color.CYAN);
                    }else if(r == 1 && c == 3){
                        tile13.setForeground(Color.CYAN);
                    }else if(r == 1 && c == 4){
                        tile14.setForeground(Color.CYAN);
                    }else if(r == 1 && c == 5){
                        tile15.setForeground(Color.CYAN);
                    }else if(r == 1 && c == 6){
                        tile16.setForeground(Color.CYAN);
                    }else if(r == 1 && c == 7){
                        tile17.setForeground(Color.CYAN);
                    }else if(r == 1 && c == 8){
                        tile18.setForeground(Color.CYAN);
                    }else if(r == 2 && c == 0){
                        tile20.setForeground(Color.CYAN);
                    }else if(r == 2 && c == 1){
                        tile21.setForeground(Color.CYAN);
                    }else if(r == 2 && c == 2){
                        tile22.setForeground(Color.CYAN);
                    }else if(r == 2 && c == 3){
                        tile23.setForeground(Color.CYAN);
                    }else if(r == 2 && c == 4){
                        tile24.setForeground(Color.CYAN);
                    }else if(r == 2 && c == 5){
                        tile25.setForeground(Color.CYAN);
                    }else if(r == 2 && c == 6){
                        tile26.setForeground(Color.CYAN);
                    }else if(r == 2 && c == 7){
                        tile27.setForeground(Color.CYAN);
                    }else if(r == 2 && c == 8){
                        tile28.setForeground(Color.CYAN);
                    }else if(r == 3 && c == 0){
                        tile30.setForeground(Color.CYAN);
                    }else if(r == 3 && c == 1){
                        tile31.setForeground(Color.CYAN);
                    }else if(r == 3 && c == 2){
                        tile32.setForeground(Color.CYAN);
                    }else if(r == 3 && c == 3){
                        tile33.setForeground(Color.CYAN);
                    }else if(r == 3 && c == 4){
                        tile34.setForeground(Color.CYAN);
                    }else if(r == 3 && c == 5){
                        tile35.setForeground(Color.CYAN);
                    }else if(r == 3 && c == 6){
                        tile36.setForeground(Color.CYAN);
                    }else if(r == 3 && c == 7){
                        tile37.setForeground(Color.CYAN);
                    }else if(r == 3 && c == 8){
                        tile38.setForeground(Color.CYAN);
                    }else if(r == 4 && c == 0){
                        tile40.setForeground(Color.CYAN);
                    }else if(r == 4 && c == 1){
                        tile41.setForeground(Color.CYAN);
                    }else if(r == 4 && c == 2){
                        tile42.setForeground(Color.CYAN);
                    }else if(r == 4 && c == 3){
                        tile43.setForeground(Color.CYAN);
                    }else if(r == 4 && c == 4){
                        tile44.setForeground(Color.CYAN);
                    }else if(r == 4 && c == 5){
                        tile45.setForeground(Color.CYAN);
                    }else if(r == 4 && c == 6){
                        tile46.setForeground(Color.CYAN);
                    }else if(r == 4 && c == 7){
                        tile47.setForeground(Color.CYAN);
                    }else if(r == 4 && c == 8){
                        tile48.setForeground(Color.CYAN);
                    }else if(r == 5 && c == 0){
                        tile50.setForeground(Color.CYAN);
                    }else if(r == 5 && c == 1){
                        tile51.setForeground(Color.CYAN);
                    }else if(r == 5 && c == 2){
                        tile52.setForeground(Color.CYAN);
                    }else if(r == 5 && c == 3){
                        tile53.setForeground(Color.CYAN);
                    }else if(r == 5 && c == 4){
                        tile54.setForeground(Color.CYAN);
                    }else if(r == 5 && c == 5){
                        tile55.setForeground(Color.CYAN);
                    }else if(r == 5 && c == 6){
                        tile56.setForeground(Color.CYAN);
                    }else if(r == 5 && c == 7){
                        tile57.setForeground(Color.CYAN);
                    }else if(r == 5 && c == 8){
                        tile58.setForeground(Color.CYAN);
                    }else if(r == 6 && c == 0){
                        tile60.setForeground(Color.CYAN);
                    }else if(r == 6 && c == 1){
                        tile61.setForeground(Color.CYAN);
                    }else if(r == 6 && c == 2){
                        tile62.setForeground(Color.CYAN);
                    }else if(r == 6 && c == 3){
                        tile63.setForeground(Color.CYAN);
                    }else if(r == 6 && c == 4){
                        tile64.setForeground(Color.CYAN);
                    }else if(r == 6 && c == 5){
                        tile65.setForeground(Color.CYAN);
                    }else if(r== 6 && c == 6){
                        tile66.setForeground(Color.CYAN);
                    }else if(r == 6 && c == 7){
                        tile67.setForeground(Color.CYAN);
                    }else if(r == 6 && c == 8){
                        tile68.setForeground(Color.CYAN);
                    }else if(r == 7 && c == 0){
                        tile70.setForeground(Color.CYAN);
                    }else if(r == 7 && c == 1){
                        tile71.setForeground(Color.CYAN);
                    }else if(r == 7 && c == 2){
                        tile72.setForeground(Color.CYAN);
                    }else if(r == 7 && c == 3){
                        tile73.setForeground(Color.CYAN);
                    }else if(r == 7 && c == 4){
                        tile74.setForeground(Color.CYAN);
                    }else if(r == 7 && c == 5){
                        tile75.setForeground(Color.CYAN);
                    }else if(r == 7 && c == 6){
                        tile76.setForeground(Color.CYAN);
                    }else if(r == 7 && c == 7){
                        tile77.setForeground(Color.CYAN);
                    }else if(r == 7 && c == 8){
                        tile78.setForeground(Color.CYAN);
                    }else if(r == 8 && c == 0){
                        tile80.setForeground(Color.CYAN);
                    }else if(r == 8 && c == 1){
                        tile81.setForeground(Color.CYAN);
                    }else if(r == 8 && c == 2){
                        tile82.setForeground(Color.CYAN);
                    }else if(r == 8 && c == 3){
                        tile83.setForeground(Color.CYAN);
                    }else if(r == 8 && c == 4){
                        tile84.setForeground(Color.CYAN);
                    }else if(r == 8 && c == 5){
                        tile85.setForeground(Color.CYAN);
                    }else if(r == 8 && c == 6){
                        tile86.setForeground(Color.CYAN);
                    }else if(r == 8 && c == 7){
                        tile87.setForeground(Color.CYAN);
                    }else if(r == 8 && c == 8){
                        tile88.setForeground(Color.CYAN);
                    }
                }else if(board[r][c].getAdjacent() == 7){
                    if(r == 0 && c == 0){
                        tile00.setForeground(Color.YELLOW);
                    }else if(r == 0 && c == 1){
                        tile01.setForeground(Color.YELLOW);
                    }else if(r == 0 && c == 2){
                        tile02.setForeground(Color.YELLOW);
                    }else if(r == 0 && c == 3){
                        tile03.setForeground(Color.YELLOW);
                    }else if(r == 0 && c == 4){
                        tile04.setForeground(Color.YELLOW);
                    }else if(r == 0 && c == 5){
                        tile05.setForeground(Color.YELLOW);
                    }else if(r == 0 && c == 6){
                        tile06.setForeground(Color.YELLOW);
                    }else if(r == 0 && c == 7){
                        tile07.setForeground(Color.YELLOW);
                    }else if(r == 0 && c == 8){
                        tile08.setForeground(Color.YELLOW);
                    }else if(r == 1 && c == 0){
                        tile10.setForeground(Color.YELLOW);
                    }else if(r == 1 && c == 1){
                        tile11.setForeground(Color.YELLOW);
                    }else if(r == 1 && c == 2){
                        tile12.setForeground(Color.YELLOW);
                    }else if(r == 1 && c == 3){
                        tile13.setForeground(Color.YELLOW);
                    }else if(r == 1 && c == 4){
                        tile14.setForeground(Color.YELLOW);
                    }else if(r == 1 && c == 5){
                        tile15.setForeground(Color.YELLOW);
                    }else if(r == 1 && c == 6){
                        tile16.setForeground(Color.YELLOW);
                    }else if(r == 1 && c == 7){
                        tile17.setForeground(Color.YELLOW);
                    }else if(r == 1 && c == 8){
                        tile18.setForeground(Color.YELLOW);
                    }else if(r == 2 && c == 0){
                        tile20.setForeground(Color.YELLOW);
                    }else if(r == 2 && c == 1){
                        tile21.setForeground(Color.YELLOW);
                    }else if(r == 2 && c == 2){
                        tile22.setForeground(Color.YELLOW);
                    }else if(r == 2 && c == 3){
                        tile23.setForeground(Color.YELLOW);
                    }else if(r == 2 && c == 4){
                        tile24.setForeground(Color.YELLOW);
                    }else if(r == 2 && c == 5){
                        tile25.setForeground(Color.YELLOW);
                    }else if(r == 2 && c == 6){
                        tile26.setForeground(Color.YELLOW);
                    }else if(r == 2 && c == 7){
                        tile27.setForeground(Color.YELLOW);
                    }else if(r == 2 && c == 8){
                        tile28.setForeground(Color.YELLOW);
                    }else if(r == 3 && c == 0){
                        tile30.setForeground(Color.YELLOW);
                    }else if(r == 3 && c == 1){
                        tile31.setForeground(Color.YELLOW);
                    }else if(r == 3 && c == 2){
                        tile32.setForeground(Color.YELLOW);
                    }else if(r == 3 && c == 3){
                        tile33.setForeground(Color.YELLOW);
                    }else if(r == 3 && c == 4){
                        tile34.setForeground(Color.YELLOW);
                    }else if(r == 3 && c == 5){
                        tile35.setForeground(Color.YELLOW);
                    }else if(r == 3 && c == 6){
                        tile36.setForeground(Color.YELLOW);
                    }else if(r == 3 && c == 7){
                        tile37.setForeground(Color.YELLOW);
                    }else if(r == 3 && c == 8){
                        tile38.setForeground(Color.YELLOW);
                    }else if(r == 4 && c == 0){
                        tile40.setForeground(Color.YELLOW);
                    }else if(r == 4 && c == 1){
                        tile41.setForeground(Color.YELLOW);
                    }else if(r == 4 && c == 2){
                        tile42.setForeground(Color.YELLOW);
                    }else if(r == 4 && c == 3){
                        tile43.setForeground(Color.YELLOW);
                    }else if(r == 4 && c == 4){
                        tile44.setForeground(Color.YELLOW);
                    }else if(r == 4 && c == 5){
                        tile45.setForeground(Color.YELLOW);
                    }else if(r == 4 && c == 6){
                        tile46.setForeground(Color.YELLOW);
                    }else if(r == 4 && c == 7){
                        tile47.setForeground(Color.YELLOW);
                    }else if(r == 4 && c == 8){
                        tile48.setForeground(Color.YELLOW);
                    }else if(r == 5 && c == 0){
                        tile50.setForeground(Color.YELLOW);
                    }else if(r == 5 && c == 1){
                        tile51.setForeground(Color.YELLOW);
                    }else if(r == 5 && c == 2){
                        tile52.setForeground(Color.YELLOW);
                    }else if(r == 5 && c == 3){
                        tile53.setForeground(Color.YELLOW);
                    }else if(r == 5 && c == 4){
                        tile54.setForeground(Color.YELLOW);
                    }else if(r == 5 && c == 5){
                        tile55.setForeground(Color.YELLOW);
                    }else if(r == 5 && c == 6){
                        tile56.setForeground(Color.YELLOW);
                    }else if(r == 5 && c == 7){
                        tile57.setForeground(Color.YELLOW);
                    }else if(r == 5 && c == 8){
                        tile58.setForeground(Color.YELLOW);
                    }else if(r == 6 && c == 0){
                        tile60.setForeground(Color.YELLOW);
                    }else if(r == 6 && c == 1){
                        tile61.setForeground(Color.YELLOW);
                    }else if(r == 6 && c == 2){
                        tile62.setForeground(Color.YELLOW);
                    }else if(r == 6 && c == 3){
                        tile63.setForeground(Color.YELLOW);
                    }else if(r == 6 && c == 4){
                        tile64.setForeground(Color.YELLOW);
                    }else if(r == 6 && c == 5){
                        tile65.setForeground(Color.YELLOW);
                    }else if(r== 6 && c == 6){
                        tile66.setForeground(Color.YELLOW);
                    }else if(r == 6 && c == 7){
                        tile67.setForeground(Color.YELLOW);
                    }else if(r == 6 && c == 8){
                        tile68.setForeground(Color.YELLOW);
                    }else if(r == 7 && c == 0){
                        tile70.setForeground(Color.YELLOW);
                    }else if(r == 7 && c == 1){
                        tile71.setForeground(Color.YELLOW);
                    }else if(r == 7 && c == 2){
                        tile72.setForeground(Color.YELLOW);
                    }else if(r == 7 && c == 3){
                        tile73.setForeground(Color.YELLOW);
                    }else if(r == 7 && c == 4){
                        tile74.setForeground(Color.YELLOW);
                    }else if(r == 7 && c == 5){
                        tile75.setForeground(Color.YELLOW);
                    }else if(r == 7 && c == 6){
                        tile76.setForeground(Color.YELLOW);
                    }else if(r == 7 && c == 7){
                        tile77.setForeground(Color.YELLOW);
                    }else if(r == 7 && c == 8){
                        tile78.setForeground(Color.YELLOW);
                    }else if(r == 8 && c == 0){
                        tile80.setForeground(Color.YELLOW);
                    }else if(r == 8 && c == 1){
                        tile81.setForeground(Color.YELLOW);
                    }else if(r == 8 && c == 2){
                        tile82.setForeground(Color.YELLOW);
                    }else if(r == 8 && c == 3){
                        tile83.setForeground(Color.YELLOW);
                    }else if(r == 8 && c == 4){
                        tile84.setForeground(Color.YELLOW);
                    }else if(r == 8 && c == 5){
                        tile85.setForeground(Color.YELLOW);
                    }else if(r == 8 && c == 6){
                        tile86.setForeground(Color.YELLOW);
                    }else if(r == 8 && c == 7){
                        tile87.setForeground(Color.YELLOW);
                    }else if(r == 8 && c == 8){
                        tile88.setForeground(Color.YELLOW);
                    }
                }else if(board[r][c].getAdjacent() == 8){
                    if(r == 0 && c == 0){
                        tile00.setForeground(Color.BLACK);
                    }else if(r == 0 && c == 1){
                        tile01.setForeground(Color.BLACK);
                    }else if(r == 0 && c == 2){
                        tile02.setForeground(Color.BLACK);
                    }else if(r == 0 && c == 3){
                        tile03.setForeground(Color.BLACK);
                    }else if(r == 0 && c == 4){
                        tile04.setForeground(Color.BLACK);
                    }else if(r == 0 && c == 5){
                        tile05.setForeground(Color.BLACK);
                    }else if(r == 0 && c == 6){
                        tile06.setForeground(Color.BLACK);
                    }else if(r == 0 && c == 7){
                        tile07.setForeground(Color.BLACK);
                    }else if(r == 0 && c == 8){
                        tile08.setForeground(Color.BLACK);
                    }else if(r == 1 && c == 0){
                        tile10.setForeground(Color.BLACK);
                    }else if(r == 1 && c == 1){
                        tile11.setForeground(Color.BLACK);
                    }else if(r == 1 && c == 2){
                        tile12.setForeground(Color.BLACK);
                    }else if(r == 1 && c == 3){
                        tile13.setForeground(Color.BLACK);
                    }else if(r == 1 && c == 4){
                        tile14.setForeground(Color.BLACK);
                    }else if(r == 1 && c == 5){
                        tile15.setForeground(Color.BLACK);
                    }else if(r == 1 && c == 6){
                        tile16.setForeground(Color.BLACK);
                    }else if(r == 1 && c == 7){
                        tile17.setForeground(Color.BLACK);
                    }else if(r == 1 && c == 8){
                        tile18.setForeground(Color.BLACK);
                    }else if(r == 2 && c == 0){
                        tile20.setForeground(Color.BLACK);
                    }else if(r == 2 && c == 1){
                        tile21.setForeground(Color.BLACK);
                    }else if(r == 2 && c == 2){
                        tile22.setForeground(Color.BLACK);
                    }else if(r == 2 && c == 3){
                        tile23.setForeground(Color.BLACK);
                    }else if(r == 2 && c == 4){
                        tile24.setForeground(Color.BLACK);
                    }else if(r == 2 && c == 5){
                        tile25.setForeground(Color.BLACK);
                    }else if(r == 2 && c == 6){
                        tile26.setForeground(Color.BLACK);
                    }else if(r == 2 && c == 7){
                        tile27.setForeground(Color.BLACK);
                    }else if(r == 2 && c == 8){
                        tile28.setForeground(Color.BLACK);
                    }else if(r == 3 && c == 0){
                        tile30.setForeground(Color.BLACK);
                    }else if(r == 3 && c == 1){
                        tile31.setForeground(Color.BLACK);
                    }else if(r == 3 && c == 2){
                        tile32.setForeground(Color.BLACK);
                    }else if(r == 3 && c == 3){
                        tile33.setForeground(Color.BLACK);
                    }else if(r == 3 && c == 4){
                        tile34.setForeground(Color.BLACK);
                    }else if(r == 3 && c == 5){
                        tile35.setForeground(Color.BLACK);
                    }else if(r == 3 && c == 6){
                        tile36.setForeground(Color.BLACK);
                    }else if(r == 3 && c == 7){
                        tile37.setForeground(Color.BLACK);
                    }else if(r == 3 && c == 8){
                        tile38.setForeground(Color.BLACK);
                    }else if(r == 4 && c == 0){
                        tile40.setForeground(Color.BLACK);
                    }else if(r == 4 && c == 1){
                        tile41.setForeground(Color.BLACK);
                    }else if(r == 4 && c == 2){
                        tile42.setForeground(Color.BLACK);
                    }else if(r == 4 && c == 3){
                        tile43.setForeground(Color.BLACK);
                    }else if(r == 4 && c == 4){
                        tile44.setForeground(Color.BLACK);
                    }else if(r == 4 && c == 5){
                        tile45.setForeground(Color.BLACK);
                    }else if(r == 4 && c == 6){
                        tile46.setForeground(Color.BLACK);
                    }else if(r == 4 && c == 7){
                        tile47.setForeground(Color.BLACK);
                    }else if(r == 4 && c == 8){
                        tile48.setForeground(Color.BLACK);
                    }else if(r == 5 && c == 0){
                        tile50.setForeground(Color.BLACK);
                    }else if(r == 5 && c == 1){
                        tile51.setForeground(Color.BLACK);
                    }else if(r == 5 && c == 2){
                        tile52.setForeground(Color.BLACK);
                    }else if(r == 5 && c == 3){
                        tile53.setForeground(Color.BLACK);
                    }else if(r == 5 && c == 4){
                        tile54.setForeground(Color.BLACK);
                    }else if(r == 5 && c == 5){
                        tile55.setForeground(Color.BLACK);
                    }else if(r == 5 && c == 6){
                        tile56.setForeground(Color.BLACK);
                    }else if(r == 5 && c == 7){
                        tile57.setForeground(Color.BLACK);
                    }else if(r == 5 && c == 8){
                        tile58.setForeground(Color.BLACK);
                    }else if(r == 6 && c == 0){
                        tile60.setForeground(Color.BLACK);
                    }else if(r == 6 && c == 1){
                        tile61.setForeground(Color.BLACK);
                    }else if(r == 6 && c == 2){
                        tile62.setForeground(Color.BLACK);
                    }else if(r == 6 && c == 3){
                        tile63.setForeground(Color.BLACK);
                    }else if(r == 6 && c == 4){
                        tile64.setForeground(Color.BLACK);
                    }else if(r == 6 && c == 5){
                        tile65.setForeground(Color.BLACK);
                    }else if(r== 6 && c == 6){
                        tile66.setForeground(Color.BLACK);
                    }else if(r == 6 && c == 7){
                        tile67.setForeground(Color.BLACK);
                    }else if(r == 6 && c == 8){
                        tile68.setForeground(Color.BLACK);
                    }else if(r == 7 && c == 0){
                        tile70.setForeground(Color.BLACK);
                    }else if(r == 7 && c == 1){
                        tile71.setForeground(Color.BLACK);
                    }else if(r == 7 && c == 2){
                        tile72.setForeground(Color.BLACK);
                    }else if(r == 7 && c == 3){
                        tile73.setForeground(Color.BLACK);
                    }else if(r == 7 && c == 4){
                        tile74.setForeground(Color.BLACK);
                    }else if(r == 7 && c == 5){
                        tile75.setForeground(Color.BLACK);
                    }else if(r == 7 && c == 6){
                        tile76.setForeground(Color.BLACK);
                    }else if(r == 7 && c == 7){
                        tile77.setForeground(Color.BLACK);
                    }else if(r == 7 && c == 8){
                        tile78.setForeground(Color.BLACK);
                    }else if(r == 8 && c == 0){
                        tile80.setForeground(Color.BLACK);
                    }else if(r == 8 && c == 1){
                        tile81.setForeground(Color.BLACK);
                    }else if(r == 8 && c == 2){
                        tile82.setForeground(Color.BLACK);
                    }else if(r == 8 && c == 3){
                        tile83.setForeground(Color.BLACK);
                    }else if(r == 8 && c == 4){
                        tile84.setForeground(Color.BLACK);
                    }else if(r == 8 && c == 5){
                        tile85.setForeground(Color.BLACK);
                    }else if(r == 8 && c == 6){
                        tile86.setForeground(Color.BLACK);
                    }else if(r == 8 && c == 7){
                        tile87.setForeground(Color.BLACK);
                    }else if(r == 8 && c == 8){
                        tile88.setForeground(Color.BLACK);
                    }
                }
            }
        }
    }
    
    public boolean updateZeros(int r, int c){
       boolean changes = false;
       if(!board[r][c].getClicked() && !board[r][c].getMine()){
            if(r == 0){
                if(c == 0){
                    //check top left tile
                    if(board[r][c+1].getAdjacent() <= 1 && board[r][c+1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r+1][c].getAdjacent() <= 1 && board[r+1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                }else if(c == 8){
                    //check top right tile
                    if(board[r][c-1].getAdjacent() <= 1 && board[r][c-1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r+1][c].getAdjacent() <= 1 && board[r+1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                }else{
                    //check top middle tiles
                    if(board[r][c-1].getAdjacent() <= 1 && board[r][c-1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r][c+1].getAdjacent() <= 1 && board[r][c+1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r+1][c].getAdjacent() <= 1 && board[r+1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                }
            }else if(r == 8){
                if(c == 0){
                    //check bottom left tile
                    if(board[r][c+1].getAdjacent() <= 1 && board[r][c+1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r-1][c].getAdjacent() <= 1 && board[r-1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                }else if(c == 8){
                    //check bottom right tile
                    if(board[r][c-1].getAdjacent() <= 1 && board[r][c-1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r-1][c].getAdjacent() <= 1 && board[r-1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                }else{
                    //check bottom middle tiles
                    if(board[r][c-1].getAdjacent() <= 1 && board[r][c-1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r][c+1].getAdjacent() <= 1 && board[r][c+1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r-1][c].getAdjacent() <= 1 && board[r-1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                }
            }else{
                if(c == 0){
                    //check center left tiles
                    if(board[r-1][c].getAdjacent() <= 1 && board[r-1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r][c+1].getAdjacent() <= 1 && board[r][c+1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r+1][c].getAdjacent() <= 1 && board[r+1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                }else if(c == 8){
                    //check center right tiles
                    if(board[r-1][c].getAdjacent() <= 1 && board[r-1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r][c-1].getAdjacent() <= 1 && board[r][c-1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r+1][c].getAdjacent() <= 1 && board[r+1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                }else{
                    //check all center middle tiles
                    if(board[r-1][c].getAdjacent() <= 1 && board[r-1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r][c-1].getAdjacent() <= 1 && board[r][c-1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r][c+1].getAdjacent() <= 1 && board[r][c+1].getClicked()) {board[r][c].setClicked(); changes = true;}
                    if(board[r+1][c].getAdjacent() <= 1 && board[r+1][c].getClicked()) {board[r][c].setClicked(); changes = true;}
                }
           }
        }
       return changes;
    }
    
    public void updateBackgrounds(){
        tile00.setBackground(Color.LIGHT_GRAY);
        tile01.setBackground(Color.LIGHT_GRAY);
        tile02.setBackground(Color.LIGHT_GRAY);
        tile03.setBackground(Color.LIGHT_GRAY);
        tile04.setBackground(Color.LIGHT_GRAY);
        tile05.setBackground(Color.LIGHT_GRAY);
        tile06.setBackground(Color.LIGHT_GRAY);
        tile07.setBackground(Color.LIGHT_GRAY);
        tile08.setBackground(Color.LIGHT_GRAY);
        tile10.setBackground(Color.LIGHT_GRAY);
        tile11.setBackground(Color.LIGHT_GRAY);
        tile12.setBackground(Color.LIGHT_GRAY);
        tile13.setBackground(Color.LIGHT_GRAY);
        tile14.setBackground(Color.LIGHT_GRAY);
        tile15.setBackground(Color.LIGHT_GRAY);
        tile16.setBackground(Color.LIGHT_GRAY);
        tile17.setBackground(Color.LIGHT_GRAY);
        tile18.setBackground(Color.LIGHT_GRAY);
        tile20.setBackground(Color.LIGHT_GRAY);
        tile21.setBackground(Color.LIGHT_GRAY);
        tile22.setBackground(Color.LIGHT_GRAY);
        tile23.setBackground(Color.LIGHT_GRAY);
        tile24.setBackground(Color.LIGHT_GRAY);
        tile25.setBackground(Color.LIGHT_GRAY);
        tile26.setBackground(Color.LIGHT_GRAY);
        tile27.setBackground(Color.LIGHT_GRAY);
        tile28.setBackground(Color.LIGHT_GRAY);
        tile30.setBackground(Color.LIGHT_GRAY);
        tile31.setBackground(Color.LIGHT_GRAY);
        tile32.setBackground(Color.LIGHT_GRAY);
        tile33.setBackground(Color.LIGHT_GRAY);
        tile34.setBackground(Color.LIGHT_GRAY);
        tile35.setBackground(Color.LIGHT_GRAY);
        tile36.setBackground(Color.LIGHT_GRAY);
        tile37.setBackground(Color.LIGHT_GRAY);
        tile38.setBackground(Color.LIGHT_GRAY);
        tile40.setBackground(Color.LIGHT_GRAY);
        tile41.setBackground(Color.LIGHT_GRAY);
        tile42.setBackground(Color.LIGHT_GRAY);
        tile43.setBackground(Color.LIGHT_GRAY);
        tile44.setBackground(Color.LIGHT_GRAY);
        tile45.setBackground(Color.LIGHT_GRAY);
        tile46.setBackground(Color.LIGHT_GRAY);
        tile47.setBackground(Color.LIGHT_GRAY);
        tile48.setBackground(Color.LIGHT_GRAY);
        tile50.setBackground(Color.LIGHT_GRAY);
        tile51.setBackground(Color.LIGHT_GRAY);
        tile52.setBackground(Color.LIGHT_GRAY);
        tile53.setBackground(Color.LIGHT_GRAY);
        tile54.setBackground(Color.LIGHT_GRAY);
        tile55.setBackground(Color.LIGHT_GRAY);
        tile56.setBackground(Color.LIGHT_GRAY);
        tile57.setBackground(Color.LIGHT_GRAY);
        tile58.setBackground(Color.LIGHT_GRAY);
        tile60.setBackground(Color.LIGHT_GRAY);
        tile61.setBackground(Color.LIGHT_GRAY);
        tile62.setBackground(Color.LIGHT_GRAY);
        tile63.setBackground(Color.LIGHT_GRAY);
        tile64.setBackground(Color.LIGHT_GRAY);
        tile65.setBackground(Color.LIGHT_GRAY);
        tile66.setBackground(Color.LIGHT_GRAY);
        tile67.setBackground(Color.LIGHT_GRAY);
        tile68.setBackground(Color.LIGHT_GRAY);
        tile70.setBackground(Color.LIGHT_GRAY);
        tile71.setBackground(Color.LIGHT_GRAY);
        tile72.setBackground(Color.LIGHT_GRAY);
        tile73.setBackground(Color.LIGHT_GRAY);
        tile74.setBackground(Color.LIGHT_GRAY);
        tile75.setBackground(Color.LIGHT_GRAY);
        tile76.setBackground(Color.LIGHT_GRAY);
        tile77.setBackground(Color.LIGHT_GRAY);
        tile78.setBackground(Color.LIGHT_GRAY);
        tile80.setBackground(Color.LIGHT_GRAY);
        tile81.setBackground(Color.LIGHT_GRAY);
        tile82.setBackground(Color.LIGHT_GRAY);
        tile83.setBackground(Color.LIGHT_GRAY);
        tile84.setBackground(Color.LIGHT_GRAY);
        tile85.setBackground(Color.LIGHT_GRAY);
        tile86.setBackground(Color.LIGHT_GRAY);
        tile87.setBackground(Color.LIGHT_GRAY);
        tile88.setBackground(Color.LIGHT_GRAY);
    }
    
    public void updateBoard(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c].getClicked()){
                    if(board[r][c].getMine()){
                        gameLose();
                    }else{
                        if(r == 0 && c == 0){
                            tile00.setBackground(Color.WHITE);
                            tile00.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 0 && c == 1){
                            tile01.setBackground(Color.WHITE);
                            tile01.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 0 && c == 2){
                            tile02.setBackground(Color.WHITE);
                            tile02.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 0 && c == 3){
                            tile03.setBackground(Color.WHITE);
                            tile03.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 0 && c == 4){
                            tile04.setBackground(Color.WHITE);
                            tile04.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 0 && c == 5){
                            tile05.setBackground(Color.WHITE);
                            tile05.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 0 && c == 6){
                            tile06.setBackground(Color.WHITE);
                            tile06.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 0 && c == 7){
                            tile07.setBackground(Color.WHITE);
                            tile07.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 0 && c == 8){
                            tile08.setBackground(Color.WHITE);
                            tile08.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 1 && c == 0){
                            tile10.setBackground(Color.WHITE);
                            tile10.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 1 && c == 1){
                            tile11.setBackground(Color.WHITE);
                            tile11.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 1 && c == 2){
                            tile12.setBackground(Color.WHITE);
                            tile12.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 1 && c == 3){
                            tile13.setBackground(Color.WHITE);
                            tile13.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 1 && c == 4){
                            tile14.setBackground(Color.WHITE);
                            tile14.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 1 && c == 5){
                            tile15.setBackground(Color.WHITE);
                            tile15.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 1 && c == 6){
                            tile16.setBackground(Color.WHITE);
                            tile16.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 1 && c == 7){
                            tile17.setBackground(Color.WHITE);
                            tile17.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 1 && c == 8){
                            tile18.setBackground(Color.WHITE);
                            tile18.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 2 && c == 0){
                            tile20.setBackground(Color.WHITE);
                            tile20.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 2 && c == 1){
                            tile21.setBackground(Color.WHITE);
                            tile21.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 2 && c == 2){
                            tile22.setBackground(Color.WHITE);
                            tile22.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 2 && c == 3){
                            tile23.setBackground(Color.WHITE);
                            tile23.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 2 && c == 4){
                            tile24.setBackground(Color.WHITE);
                            tile24.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 2 && c == 5){
                            tile25.setBackground(Color.WHITE);
                            tile25.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 2 && c == 6){
                            tile26.setBackground(Color.WHITE);
                            tile26.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 2 && c == 7){
                            tile27.setBackground(Color.WHITE);
                            tile27.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 2 && c == 8){
                            tile28.setBackground(Color.WHITE);
                            tile28.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 3 && c == 0){
                            tile30.setBackground(Color.WHITE);
                            tile30.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 3 && c == 1){
                            tile31.setBackground(Color.WHITE);
                            tile31.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 3 && c == 2){
                            tile32.setBackground(Color.WHITE);
                            tile32.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 3 && c == 3){
                            tile33.setBackground(Color.WHITE);
                            tile33.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 3 && c == 4){
                            tile34.setBackground(Color.WHITE);
                            tile34.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 3 && c == 5){
                            tile35.setBackground(Color.WHITE);
                            tile35.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 3 && c == 6){
                            tile36.setBackground(Color.WHITE);
                            tile36.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 3 && c == 7){
                            tile37.setBackground(Color.WHITE);
                            tile37.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 3 && c == 8){
                            tile38.setBackground(Color.WHITE);
                            tile38.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 4 && c == 0){
                            tile40.setBackground(Color.WHITE);
                            tile40.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 4 && c == 1){
                            tile41.setBackground(Color.WHITE);
                            tile41.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 4 && c == 2){
                            tile42.setBackground(Color.WHITE);
                            tile42.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 4 && c == 3){
                            tile43.setBackground(Color.WHITE);
                            tile43.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 4 && c == 4){
                            tile44.setBackground(Color.WHITE);
                            tile44.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 4 && c == 5){
                            tile45.setBackground(Color.WHITE);
                            tile45.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 4 && c == 6){
                            tile46.setBackground(Color.WHITE);
                            tile46.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 4 && c == 7){
                            tile47.setBackground(Color.WHITE);
                            tile47.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 4 && c == 8){
                            tile48.setBackground(Color.WHITE);
                            tile48.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 5 && c == 0){
                            tile50.setBackground(Color.WHITE);
                            tile50.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 5 && c == 1){
                            tile51.setBackground(Color.WHITE);
                            tile51.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 5 && c == 2){
                            tile52.setBackground(Color.WHITE);
                            tile52.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 5 && c == 3){
                            tile53.setBackground(Color.WHITE);
                            tile53.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 5 && c == 4){
                            tile54.setBackground(Color.WHITE);
                            tile54.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 5 && c == 5){
                            tile55.setBackground(Color.WHITE);
                            tile55.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 5 && c == 6){
                            tile56.setBackground(Color.WHITE);
                            tile56.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 5 && c == 7){
                            tile57.setBackground(Color.WHITE);
                            tile57.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 5 && c == 8){
                            tile58.setBackground(Color.WHITE);
                            tile58.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 6 && c == 0){
                            tile60.setBackground(Color.WHITE);
                            tile60.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 6 && c == 1){
                            tile61.setBackground(Color.WHITE);
                            tile61.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 6 && c == 2){
                            tile62.setBackground(Color.WHITE);
                            tile62.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 6 && c == 3){
                            tile63.setBackground(Color.WHITE);
                            tile63.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 6 && c == 4){
                            tile64.setBackground(Color.WHITE);
                            tile64.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 6 && c == 5){
                            tile65.setBackground(Color.WHITE);
                            tile65.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r== 6 && c == 6){
                            tile66.setBackground(Color.WHITE);
                            tile66.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 6 && c == 7){
                            tile67.setBackground(Color.WHITE);
                            tile67.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 6 && c == 8){
                            tile68.setBackground(Color.WHITE);
                            tile68.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 7 && c == 0){
                            tile70.setBackground(Color.WHITE);
                            tile70.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 7 && c == 1){
                            tile71.setBackground(Color.WHITE);
                            tile71.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 7 && c == 2){
                            tile72.setBackground(Color.WHITE);
                            tile72.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 7 && c == 3){
                            tile73.setBackground(Color.WHITE);
                            tile73.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 7 && c == 4){
                            tile74.setBackground(Color.WHITE);
                            tile74.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 7 && c == 5){
                            tile75.setBackground(Color.WHITE);
                            tile75.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 7 && c == 6){
                            tile76.setBackground(Color.WHITE);
                            tile76.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 7 && c == 7){
                            tile77.setBackground(Color.WHITE);
                            tile77.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 7 && c == 8){
                            tile78.setBackground(Color.WHITE);
                            tile78.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 8 && c == 0){
                            tile80.setBackground(Color.WHITE);
                            tile80.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 8 && c == 1){
                            tile81.setBackground(Color.WHITE);
                            tile81.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 8 && c == 2){
                            tile82.setBackground(Color.WHITE);
                            tile82.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 8 && c == 3){
                            tile83.setBackground(Color.WHITE);
                            tile83.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 8 && c == 4){
                            tile84.setBackground(Color.WHITE);
                            tile84.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 8 && c == 5){
                            tile85.setBackground(Color.WHITE);
                            tile85.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 8 && c == 6){
                            tile86.setBackground(Color.WHITE);
                            tile86.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 8 && c == 7){
                            tile87.setBackground(Color.WHITE);
                            tile87.setText(Integer.toString(board[r][c].getAdjacent()));
                        }else if(r == 8 && c == 8){
                            tile88.setBackground(Color.WHITE);
                            tile88.setText(Integer.toString(board[r][c].getAdjacent()));
                        }
                    }
                }else if(board[r][c].getFlag()){
                    if(r == 0 && c == 0){
                        tile00.setBackground(Color.DARK_GRAY);
                    }else if(r == 0 && c == 1){
                        tile01.setBackground(Color.DARK_GRAY);
                    }else if(r == 0 && c == 2){
                        tile02.setBackground(Color.DARK_GRAY);
                    }else if(r == 0 && c == 3){
                        tile03.setBackground(Color.DARK_GRAY);
                    }else if(r == 0 && c == 4){
                        tile04.setBackground(Color.DARK_GRAY);
                    }else if(r == 0 && c == 5){
                        tile05.setBackground(Color.DARK_GRAY);
                    }else if(r == 0 && c == 6){
                        tile06.setBackground(Color.DARK_GRAY);
                    }else if(r == 0 && c == 7){
                        tile07.setBackground(Color.DARK_GRAY);
                    }else if(r == 0 && c == 8){
                        tile08.setBackground(Color.DARK_GRAY);
                    }else if(r == 1 && c == 0){
                        tile10.setBackground(Color.DARK_GRAY);
                    }else if(r == 1 && c == 1){
                        tile11.setBackground(Color.DARK_GRAY);
                    }else if(r == 1 && c == 2){
                        tile12.setBackground(Color.DARK_GRAY);
                    }else if(r == 1 && c == 3){
                        tile13.setBackground(Color.DARK_GRAY);
                    }else if(r == 1 && c == 4){
                        tile14.setBackground(Color.DARK_GRAY);
                    }else if(r == 1 && c == 5){
                        tile15.setBackground(Color.DARK_GRAY);
                    }else if(r == 1 && c == 6){
                        tile16.setBackground(Color.DARK_GRAY);
                    }else if(r == 1 && c == 7){
                        tile17.setBackground(Color.DARK_GRAY);
                    }else if(r == 1 && c == 8){
                        tile18.setBackground(Color.DARK_GRAY);
                    }else if(r == 2 && c == 0){
                        tile20.setBackground(Color.DARK_GRAY);
                    }else if(r == 2 && c == 1){
                        tile21.setBackground(Color.DARK_GRAY);
                    }else if(r == 2 && c == 2){
                        tile22.setBackground(Color.DARK_GRAY);
                    }else if(r == 2 && c == 3){
                        tile23.setBackground(Color.DARK_GRAY);
                    }else if(r == 2 && c == 4){
                        tile24.setBackground(Color.DARK_GRAY);
                    }else if(r == 2 && c == 5){
                        tile25.setBackground(Color.DARK_GRAY);
                    }else if(r == 2 && c == 6){
                        tile26.setBackground(Color.DARK_GRAY);
                    }else if(r == 2 && c == 7){
                        tile27.setBackground(Color.DARK_GRAY);
                    }else if(r == 2 && c == 8){
                        tile28.setBackground(Color.DARK_GRAY);
                    }else if(r == 3 && c == 0){
                        tile30.setBackground(Color.DARK_GRAY);
                    }else if(r == 3 && c == 1){
                        tile31.setBackground(Color.DARK_GRAY);
                    }else if(r == 3 && c == 2){
                        tile32.setBackground(Color.DARK_GRAY);
                    }else if(r == 3 && c == 3){
                        tile33.setBackground(Color.DARK_GRAY);
                    }else if(r == 3 && c == 4){
                        tile34.setBackground(Color.DARK_GRAY);
                    }else if(r == 3 && c == 5){
                        tile35.setBackground(Color.DARK_GRAY);
                    }else if(r == 3 && c == 6){
                        tile36.setBackground(Color.DARK_GRAY);
                    }else if(r == 3 && c == 7){
                        tile37.setBackground(Color.DARK_GRAY);
                    }else if(r == 3 && c == 8){
                        tile38.setBackground(Color.DARK_GRAY);
                    }else if(r == 4 && c == 0){
                        tile40.setBackground(Color.DARK_GRAY);
                    }else if(r == 4 && c == 1){
                        tile41.setBackground(Color.DARK_GRAY);
                    }else if(r == 4 && c == 2){
                        tile42.setBackground(Color.DARK_GRAY);
                    }else if(r == 4 && c == 3){
                        tile43.setBackground(Color.DARK_GRAY);
                    }else if(r == 4 && c == 4){
                        tile44.setBackground(Color.DARK_GRAY);
                    }else if(r == 4 && c == 5){
                        tile45.setBackground(Color.DARK_GRAY);
                    }else if(r == 4 && c == 6){
                        tile46.setBackground(Color.DARK_GRAY);
                    }else if(r == 4 && c == 7){
                        tile47.setBackground(Color.DARK_GRAY);
                    }else if(r == 4 && c == 8){
                        tile48.setBackground(Color.DARK_GRAY);
                    }else if(r == 5 && c == 0){
                        tile50.setBackground(Color.DARK_GRAY);
                    }else if(r == 5 && c == 1){
                        tile51.setBackground(Color.DARK_GRAY);
                    }else if(r == 5 && c == 2){
                        tile52.setBackground(Color.DARK_GRAY);
                    }else if(r == 5 && c == 3){
                        tile53.setBackground(Color.DARK_GRAY);
                    }else if(r == 5 && c == 4){
                        tile54.setBackground(Color.DARK_GRAY);
                    }else if(r == 5 && c == 5){
                        tile55.setBackground(Color.DARK_GRAY);
                    }else if(r == 5 && c == 6){
                        tile56.setBackground(Color.DARK_GRAY);
                    }else if(r == 5 && c == 7){
                        tile57.setBackground(Color.DARK_GRAY);
                    }else if(r == 5 && c == 8){
                        tile58.setBackground(Color.DARK_GRAY);
                    }else if(r == 6 && c == 0){
                        tile60.setBackground(Color.DARK_GRAY);
                    }else if(r == 6 && c == 1){
                        tile61.setBackground(Color.DARK_GRAY);
                    }else if(r == 6 && c == 2){
                        tile62.setBackground(Color.DARK_GRAY);
                    }else if(r == 6 && c == 3){
                        tile63.setBackground(Color.DARK_GRAY);
                    }else if(r == 6 && c == 4){
                        tile64.setBackground(Color.DARK_GRAY);
                    }else if(r == 6 && c == 5){
                        tile65.setBackground(Color.DARK_GRAY);
                    }else if(r== 6 && c == 6){
                        tile66.setBackground(Color.DARK_GRAY);
                    }else if(r == 6 && c == 7){
                        tile67.setBackground(Color.DARK_GRAY);
                    }else if(r == 6 && c == 8){
                        tile68.setBackground(Color.DARK_GRAY);
                    }else if(r == 7 && c == 0){
                        tile70.setBackground(Color.DARK_GRAY);
                    }else if(r == 7 && c == 1){
                        tile71.setBackground(Color.DARK_GRAY);
                    }else if(r == 7 && c == 2){
                        tile72.setBackground(Color.DARK_GRAY);
                    }else if(r == 7 && c == 3){
                        tile73.setBackground(Color.DARK_GRAY);
                    }else if(r == 7 && c == 4){
                        tile74.setBackground(Color.DARK_GRAY);
                    }else if(r == 7 && c == 5){
                        tile75.setBackground(Color.DARK_GRAY);
                    }else if(r == 7 && c == 6){
                        tile76.setBackground(Color.DARK_GRAY);
                    }else if(r == 7 && c == 7){
                        tile77.setBackground(Color.DARK_GRAY);
                    }else if(r == 7 && c == 8){
                        tile78.setBackground(Color.DARK_GRAY);
                    }else if(r == 8 && c == 0){
                        tile80.setBackground(Color.DARK_GRAY);
                    }else if(r == 8 && c == 1){
                        tile81.setBackground(Color.DARK_GRAY);
                    }else if(r == 8 && c == 2){
                        tile82.setBackground(Color.DARK_GRAY);
                    }else if(r == 8 && c == 3){
                        tile83.setBackground(Color.DARK_GRAY);
                    }else if(r == 8 && c == 4){
                        tile84.setBackground(Color.DARK_GRAY);
                    }else if(r == 8 && c == 5){
                        tile85.setBackground(Color.DARK_GRAY);
                    }else if(r == 8 && c == 6){
                        tile86.setBackground(Color.DARK_GRAY);
                    }else if(r == 8 && c == 7){
                        tile87.setBackground(Color.DARK_GRAY);
                    }else if(r == 8 && c == 8){
                        tile88.setBackground(Color.DARK_GRAY);
                    }
                }else{
                    if(r == 0 && c == 0){
                        tile00.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 0 && c == 1){
                        tile01.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 0 && c == 2){
                        tile02.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 0 && c == 3){
                        tile03.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 0 && c == 4){
                        tile04.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 0 && c == 5){
                        tile05.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 0 && c == 6){
                        tile06.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 0 && c == 7){
                        tile07.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 0 && c == 8){
                        tile08.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 1 && c == 0){
                        tile10.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 1 && c == 1){
                        tile11.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 1 && c == 2){
                        tile12.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 1 && c == 3){
                        tile13.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 1 && c == 4){
                        tile14.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 1 && c == 5){
                        tile15.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 1 && c == 6){
                        tile16.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 1 && c == 7){
                        tile17.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 1 && c == 8){
                        tile18.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 2 && c == 0){
                        tile20.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 2 && c == 1){
                        tile21.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 2 && c == 2){
                        tile22.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 2 && c == 3){
                        tile23.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 2 && c == 4){
                        tile24.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 2 && c == 5){
                        tile25.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 2 && c == 6){
                        tile26.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 2 && c == 7){
                        tile27.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 2 && c == 8){
                        tile28.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 3 && c == 0){
                        tile30.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 3 && c == 1){
                        tile31.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 3 && c == 2){
                        tile32.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 3 && c == 3){
                        tile33.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 3 && c == 4){
                        tile34.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 3 && c == 5){
                        tile35.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 3 && c == 6){
                        tile36.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 3 && c == 7){
                        tile37.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 3 && c == 8){
                        tile38.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 4 && c == 0){
                        tile40.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 4 && c == 1){
                        tile41.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 4 && c == 2){
                        tile42.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 4 && c == 3){
                        tile43.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 4 && c == 4){
                        tile44.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 4 && c == 5){
                        tile45.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 4 && c == 6){
                        tile46.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 4 && c == 7){
                        tile47.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 4 && c == 8){
                        tile48.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 5 && c == 0){
                        tile50.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 5 && c == 1){
                        tile51.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 5 && c == 2){
                        tile52.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 5 && c == 3){
                        tile53.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 5 && c == 4){
                        tile54.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 5 && c == 5){
                        tile55.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 5 && c == 6){
                        tile56.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 5 && c == 7){
                        tile57.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 5 && c == 8){
                        tile58.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 6 && c == 0){
                        tile60.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 6 && c == 1){
                        tile61.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 6 && c == 2){
                        tile62.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 6 && c == 3){
                        tile63.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 6 && c == 4){
                        tile64.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 6 && c == 5){
                        tile65.setBackground(Color.LIGHT_GRAY);
                    }else if(r== 6 && c == 6){
                        tile66.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 6 && c == 7){
                        tile67.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 6 && c == 8){
                        tile68.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 7 && c == 0){
                        tile70.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 7 && c == 1){
                        tile71.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 7 && c == 2){
                        tile72.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 7 && c == 3){
                        tile73.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 7 && c == 4){
                        tile74.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 7 && c == 5){
                        tile75.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 7 && c == 6){
                        tile76.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 7 && c == 7){
                        tile77.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 7 && c == 8){
                        tile78.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 8 && c == 0){
                        tile80.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 8 && c == 1){
                        tile81.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 8 && c == 2){
                        tile82.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 8 && c == 3){
                        tile83.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 8 && c == 4){
                        tile84.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 8 && c == 5){
                        tile85.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 8 && c == 6){
                        tile86.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 8 && c == 7){
                        tile87.setBackground(Color.LIGHT_GRAY);
                    }else if(r == 8 && c == 8){
                        tile88.setBackground(Color.LIGHT_GRAY);
                    }
                }
                if(board[r][c].getAdjacent() == 0){
                    if(r == 0 && c == 0){
                        tile00.setText("");
                    }else if(r == 0 && c == 1){
                        tile01.setText("");
                    }else if(r == 0 && c == 2){
                        tile02.setText("");
                    }else if(r == 0 && c == 3){
                        tile03.setText("");
                    }else if(r == 0 && c == 4){
                        tile04.setText("");
                    }else if(r == 0 && c == 5){
                        tile05.setText("");
                    }else if(r == 0 && c == 6){
                        tile06.setText("");
                    }else if(r == 0 && c == 7){
                        tile07.setText("");
                    }else if(r == 0 && c == 8){
                        tile08.setText("");
                    }else if(r == 1 && c == 0){
                        tile10.setText("");
                    }else if(r == 1 && c == 1){
                        tile11.setText("");
                    }else if(r == 1 && c == 2){
                        tile12.setText("");
                    }else if(r == 1 && c == 3){
                        tile13.setText("");
                    }else if(r == 1 && c == 4){
                        tile14.setText("");
                    }else if(r == 1 && c == 5){
                        tile15.setText("");
                    }else if(r == 1 && c == 6){
                        tile16.setText("");
                    }else if(r == 1 && c == 7){
                        tile17.setText("");
                    }else if(r == 1 && c == 8){
                        tile18.setText("");
                    }else if(r == 2 && c == 0){
                        tile20.setText("");
                    }else if(r == 2 && c == 1){
                        tile21.setText("");
                    }else if(r == 2 && c == 2){
                        tile22.setText("");
                    }else if(r == 2 && c == 3){
                        tile23.setText("");
                    }else if(r == 2 && c == 4){
                        tile24.setText("");
                    }else if(r == 2 && c == 5){
                        tile25.setText("");
                    }else if(r == 2 && c == 6){
                        tile26.setText("");
                    }else if(r == 2 && c == 7){
                        tile27.setText("");
                    }else if(r == 2 && c == 8){
                        tile28.setText("");
                    }else if(r == 3 && c == 0){
                        tile30.setText("");
                    }else if(r == 3 && c == 1){
                        tile31.setText("");
                    }else if(r == 3 && c == 2){
                        tile32.setText("");
                    }else if(r == 3 && c == 3){
                        tile33.setText("");
                    }else if(r == 3 && c == 4){
                        tile34.setText("");
                    }else if(r == 3 && c == 5){
                        tile35.setText("");
                    }else if(r == 3 && c == 6){
                        tile36.setText("");
                    }else if(r == 3 && c == 7){
                        tile37.setText("");
                    }else if(r == 3 && c == 8){
                        tile38.setText("");
                    }else if(r == 4 && c == 0){
                        tile40.setText("");
                    }else if(r == 4 && c == 1){
                        tile41.setText("");
                    }else if(r == 4 && c == 2){
                        tile42.setText("");
                    }else if(r == 4 && c == 3){
                        tile43.setText("");
                    }else if(r == 4 && c == 4){
                        tile44.setText("");
                    }else if(r == 4 && c == 5){
                        tile45.setText("");
                    }else if(r == 4 && c == 6){
                        tile46.setText("");
                    }else if(r == 4 && c == 7){
                        tile47.setText("");
                    }else if(r == 4 && c == 8){
                        tile48.setText("");
                    }else if(r == 5 && c == 0){
                        tile50.setText("");
                    }else if(r == 5 && c == 1){
                        tile51.setText("");
                    }else if(r == 5 && c == 2){
                        tile52.setText("");
                    }else if(r == 5 && c == 3){
                        tile53.setText("");
                    }else if(r == 5 && c == 4){
                        tile54.setText("");
                    }else if(r == 5 && c == 5){
                        tile55.setText("");
                    }else if(r == 5 && c == 6){
                        tile56.setText("");
                    }else if(r == 5 && c == 7){
                        tile57.setText("");
                    }else if(r == 5 && c == 8){
                        tile58.setText("");
                    }else if(r == 6 && c == 0){
                        tile60.setText("");
                    }else if(r == 6 && c == 1){
                        tile61.setText("");
                    }else if(r == 6 && c == 2){
                        tile62.setText("");
                    }else if(r == 6 && c == 3){
                        tile63.setText("");
                    }else if(r == 6 && c == 4){
                        tile64.setText("");
                    }else if(r == 6 && c == 5){
                        tile65.setText("");
                    }else if(r== 6 && c == 6){
                        tile66.setText("");
                    }else if(r == 6 && c == 7){
                        tile67.setText("");
                    }else if(r == 6 && c == 8){
                        tile68.setText("");
                    }else if(r == 7 && c == 0){
                        tile70.setText("");
                    }else if(r == 7 && c == 1){
                        tile71.setText("");
                    }else if(r == 7 && c == 2){
                        tile72.setText("");
                    }else if(r == 7 && c == 3){
                        tile73.setText("");
                    }else if(r == 7 && c == 4){
                        tile74.setText("");
                    }else if(r == 7 && c == 5){
                        tile75.setText("");
                    }else if(r == 7 && c == 6){
                        tile76.setText("");
                    }else if(r == 7 && c == 7){
                        tile77.setText("");
                    }else if(r == 7 && c == 8){
                        tile78.setText("");
                    }else if(r == 8 && c == 0){
                        tile80.setText("");
                    }else if(r == 8 && c == 1){
                        tile81.setText("");
                    }else if(r == 8 && c == 2){
                        tile82.setText("");
                    }else if(r == 8 && c == 3){
                        tile83.setText("");
                    }else if(r == 8 && c == 4){
                        tile84.setText("");
                    }else if(r == 8 && c == 5){
                        tile85.setText("");
                    }else if(r == 8 && c == 6){
                        tile86.setText("");
                    }else if(r == 8 && c == 7){
                        tile87.setText("");
                    }else if(r == 8 && c == 8){
                        tile88.setText("");
                    }
                }
                if(updateZeros(r,c)){
                    r = 0;
                    c = -1;
                }
            }
        }
    }
    
    public void gameLose(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c].getMine()){
                    if(r == 0 && c == 0){
                        tile00.setText("#");
                    }else if(r == 0 && c == 1){
                        tile01.setText("#");
                    }else if(r == 0 && c == 2){
                        tile02.setText("#");
                    }else if(r == 0 && c == 3){
                        tile03.setText("#");
                    }else if(r == 0 && c == 4){
                        tile04.setText("#");
                    }else if(r == 0 && c == 5){
                        tile05.setText("#");
                    }else if(r == 0 && c == 6){
                        tile06.setText("#");
                    }else if(r == 0 && c == 7){
                        tile07.setText("#");
                    }else if(r == 0 && c == 8){
                        tile08.setText("#");
                    }else if(r == 1 && c == 0){
                        tile10.setText("#");
                    }else if(r == 1 && c == 1){
                        tile11.setText("#");
                    }else if(r == 1 && c == 2){
                        tile12.setText("#");
                    }else if(r == 1 && c == 3){
                        tile13.setText("#");
                    }else if(r == 1 && c == 4){
                        tile14.setText("#");
                    }else if(r == 1 && c == 5){
                        tile15.setText("#");
                    }else if(r == 1 && c == 6){
                        tile16.setText("#");
                    }else if(r == 1 && c == 7){
                        tile17.setText("#");
                    }else if(r == 1 && c == 8){
                        tile18.setText("#");
                    }else if(r == 2 && c == 0){
                        tile20.setText("#");
                    }else if(r == 2 && c == 1){
                        tile21.setText("#");
                    }else if(r == 2 && c == 2){
                        tile22.setText("#");
                    }else if(r == 2 && c == 3){
                        tile23.setText("#");
                    }else if(r == 2 && c == 4){
                        tile24.setText("#");
                    }else if(r == 2 && c == 5){
                        tile25.setText("#");
                    }else if(r == 2 && c == 6){
                        tile26.setText("#");
                    }else if(r == 2 && c == 7){
                        tile27.setText("#");
                    }else if(r == 2 && c == 8){
                        tile28.setText("#");
                    }else if(r == 3 && c == 0){
                        tile30.setText("#");
                    }else if(r == 3 && c == 1){
                        tile31.setText("#");
                    }else if(r == 3 && c == 2){
                        tile32.setText("#");
                    }else if(r == 3 && c == 3){
                        tile33.setText("#");
                    }else if(r == 3 && c == 4){
                        tile34.setText("#");
                    }else if(r == 3 && c == 5){
                        tile35.setText("#");
                    }else if(r == 3 && c == 6){
                        tile36.setText("#");
                    }else if(r == 3 && c == 7){
                        tile37.setText("#");
                    }else if(r == 3 && c == 8){
                        tile38.setText("#");
                    }else if(r == 4 && c == 0){
                        tile40.setText("#");
                    }else if(r == 4 && c == 1){
                        tile41.setText("#");
                    }else if(r == 4 && c == 2){
                        tile42.setText("#");
                    }else if(r == 4 && c == 3){
                        tile43.setText("#");
                    }else if(r == 4 && c == 4){
                        tile44.setText("#");
                    }else if(r == 4 && c == 5){
                        tile45.setText("#");
                    }else if(r == 4 && c == 6){
                        tile46.setText("#");
                    }else if(r == 4 && c == 7){
                        tile47.setText("#");
                    }else if(r == 4 && c == 8){
                        tile48.setText("#");
                    }else if(r == 5 && c == 0){
                        tile50.setText("#");
                    }else if(r == 5 && c == 1){
                        tile51.setText("#");
                    }else if(r == 5 && c == 2){
                        tile52.setText("#");
                    }else if(r == 5 && c == 3){
                        tile53.setText("#");
                    }else if(r == 5 && c == 4){
                        tile54.setText("#");
                    }else if(r == 5 && c == 5){
                        tile55.setText("#");
                    }else if(r == 5 && c == 6){
                        tile56.setText("#");
                    }else if(r == 5 && c == 7){
                        tile57.setText("#");
                    }else if(r == 5 && c == 8){
                        tile58.setText("#");
                    }else if(r == 6 && c == 0){
                        tile60.setText("#");
                    }else if(r == 6 && c == 1){
                        tile61.setText("#");
                    }else if(r == 6 && c == 2){
                        tile62.setText("#");
                    }else if(r == 6 && c == 3){
                        tile63.setText("#");
                    }else if(r == 6 && c == 4){
                        tile64.setText("#");
                    }else if(r == 6 && c == 5){
                        tile65.setText("#");
                    }else if(r== 6 && c == 6){
                        tile66.setText("#");
                    }else if(r == 6 && c == 7){
                        tile67.setText("#");
                    }else if(r == 6 && c == 8){
                        tile68.setText("#");
                    }else if(r == 7 && c == 0){
                        tile70.setText("#");
                    }else if(r == 7 && c == 1){
                        tile71.setText("#");
                    }else if(r == 7 && c == 2){
                        tile72.setText("#");
                    }else if(r == 7 && c == 3){
                        tile73.setText("#");
                    }else if(r == 7 && c == 4){
                        tile74.setText("#");
                    }else if(r == 7 && c == 5){
                        tile75.setText("#");
                    }else if(r == 7 && c == 6){
                        tile76.setText("#");
                    }else if(r == 7 && c == 7){
                        tile77.setText("#");
                    }else if(r == 7 && c == 8){
                        tile78.setText("#");
                    }else if(r == 8 && c == 0){
                        tile80.setText("#");
                    }else if(r == 8 && c == 1){
                        tile81.setText("#");
                    }else if(r == 8 && c == 2){
                        tile82.setText("#");
                    }else if(r == 8 && c == 3){
                        tile83.setText("#");
                    }else if(r == 8 && c == 4){
                        tile84.setText("#");
                    }else if(r == 8 && c == 5){
                        tile85.setText("#");
                    }else if(r == 8 && c == 6){
                        tile86.setText("#");
                    }else if(r == 8 && c == 7){
                        tile87.setText("#");
                    }else if(r == 8 && c == 8){
                        tile88.setText("#");
                    }
                }
            }
        }
        subGUI.running = false;
        JOptionPane.showMessageDialog(new JFrame(),"You clicked a mine!");
        System.exit(0);
    }
    
    public boolean boardComplete(){
        int nonTiles = 66;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c].getClicked()){
                    nonTiles--;
                }
            }
        }
        return nonTiles <= 0;
    }
    
    public void gameWin(){
        subGUI.running = false;
        JOptionPane.showMessageDialog(new JFrame(),"You win! Your time is " + s + " seconds!");
        System.exit(0);
    }
    
    public static void main(String args[]){
        Minesweeper game = new Minesweeper();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(400,400);
        game.setVisible(true);
    }
}