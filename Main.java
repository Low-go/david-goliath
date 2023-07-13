import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.io.*;
import javax.sound.sampled.*;

public class Main extends JPanel implements KeyListener{

    //Fields
    Room[] rooms;
    David strippling;
    Goliath goliath;
    Stone[] stone;
    ArrayList<Drawable> drawable = new ArrayList<>();
    File file;
    AudioInputStream audioStream;

    //Constructor
    public Main() throws UnsupportedAudioFileException, IOException, LineUnavailableException{

        addKeyListener(this); 

        // Instantiates file, reads the file and plays the music
        file = new File("Metal Gear Rising - Revengeance OST It Has To Be This Way Extended.wav");
        audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();



     
        //Calls and instantiates the Room object from our 
        // room class.
        rooms = new Room[25];
        rooms[0] = new Room(0,0);
        rooms[1] = new Room(65,0);
        rooms[2] = new Room(125,0);
        rooms[3] = new Room(185,0);
        rooms[4] = new Room(245,0);
        rooms[5] = new Room(0,60);
        rooms[6] = new Room(65,60);
        rooms[7] = new Room(125,60);
        rooms[8] = new Room(185,60);
        rooms[9] = new Room(245,60);
        rooms[10] = new Room(0,120);
        rooms[11] = new Room(65,120);
        rooms[12] = new Room(125,120);
        rooms[13] = new Room(185,120);
        rooms[14] = new Room(245,120);
        rooms[15] = new Room(0,180);
        rooms[16] = new Room(65,180);
        rooms[17] = new Room(125,180);
        rooms[18] = new Room(185,180);
        rooms[19] = new Room(245,180);
        rooms[20] = new Room(0,240);
        rooms[21] = new Room(65,240);
        rooms[22] = new Room(125,240);
        rooms[23] = new Room(185,240);
        rooms[24] = new Room(245,240);

       
        //These next lines of codes create the
        // Rooms exits
        rooms[22].setNorthexit(rooms[17]);
        rooms[22].setWestexit(rooms[21]);
        rooms[22].setEastexit(rooms[23]);

        rooms[23].setNorthexit(rooms[18]);
        rooms[21].setWestexit(rooms[20]);
        rooms[21].setNorthexit(rooms[16]);

        rooms[20].setNorthexit(rooms[15]);
        rooms[15].setNorthexit(rooms[10]);

        rooms[16].setEastexit(rooms[17]);
        rooms[17].setEastexit(rooms[18]);
        rooms[17].setNorthexit(rooms[12]);

        rooms[12].setWestexit(rooms[11]);
        rooms[11].setWestexit(rooms[10]);

        rooms[10].setNorthexit(rooms[5]);
        rooms[5].setNorthexit(rooms[0]);

        rooms[0].setEastexit(rooms[1]);
        rooms[6].setEastexit(rooms[7]);
        rooms[7].setEastexit(rooms[8]);
        rooms[8].setEastexit(rooms[9]);
        rooms[7].setNorthexit(rooms[2]);

        rooms[2].setEastexit(rooms[3]);
        rooms[3].setEastexit(rooms[4]);

        rooms[4].setSouthexit(rooms[9]);
        rooms[6].setSouthexit(rooms[11]);

        rooms[18].setNorthexit(rooms[13]);
        rooms[13].setEastexit(rooms[14]);

        rooms[14].setSouthexit(rooms[19]);
        rooms[19].setSouthexit(rooms[24]);

        rooms[14].setNorthexit(rooms[9]);



         //adding these objects into the arraylist
         drawable.add(rooms[0]);
         drawable.add(rooms[1]);
         drawable.add(rooms[2]);
         drawable.add(rooms[3]);
         drawable.add(rooms[4]);
         drawable.add(rooms[5]);
         drawable.add(rooms[6]);
         drawable.add(rooms[7]);
         drawable.add(rooms[8]);
         drawable.add(rooms[9]);
         drawable.add(rooms[10]);
         drawable.add(rooms[11]);
         drawable.add(rooms[12]);
         drawable.add(rooms[13]);
         drawable.add(rooms[14]);
         drawable.add(rooms[15]);
         drawable.add(rooms[16]);
         drawable.add(rooms[17]);
         drawable.add(rooms[18]);
         drawable.add(rooms[19]);
         drawable.add(rooms[20]);
         drawable.add(rooms[21]);
         drawable.add(rooms[22]);
         drawable.add(rooms[23]);
         drawable.add(rooms[24]);
          

        // Sets the david object inside one of the rooms
        strippling = new David();
        strippling.setCurrentRoom(rooms[22]);

        drawable.add(strippling);

        // Instantiates the 5 stones needed in the game.
        // Also assigns them to rooms
        stone = new Stone[5];
        stone[0] = new Stone();
        stone[1] = new Stone();
        stone[2] = new Stone();
        stone[3] = new Stone();
        stone[4] = new Stone();

        stone[0].setCurrentRoom(rooms[1]);
        stone[1].setCurrentRoom(rooms[8]);
        stone[2].setCurrentRoom(rooms[10]);
        stone[3].setCurrentRoom(rooms[12]);
        stone[4].setCurrentRoom(rooms[24]);

        drawable.add(stone[0]);
        drawable.add(stone[1]);
        drawable.add(stone[2]);
        drawable.add(stone[3]);
        drawable.add(stone[4]);
        
        

        // Instantiates the Goliath object, assigns to a room
        goliath = new Goliath();
        goliath.setCurrentRoom(rooms[2]);

        drawable.add(goliath);


    }

    @Override
    public void paintComponent(Graphics g){

        var dif_grey = new Color(158,158,158);
        g.setColor(dif_grey);
        g.fillRect(0, 0, 350, 350);

        // Can ignore these next comments, they used to be the old loops
        // that drew the objects,

       /*  for(int i = 0; i < rooms.length; i ++ ){
            rooms[i].draw(g);

        }
       
        strippling.draw(g);
        goliath.draw(g);

        for(var s: stone){
            s.draw(g);
        }*/

        // Loops through the Drawable arraylist and draws each of them.

        for( var i: drawable){
            i.draw(g);

        }

        requestFocusInWindow();

    }

    // Sets window size, opens the window, and allows it to be visible when running.
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		var window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(350,350);
		window.setContentPane(new Main());
		window.setVisible(true);
	}

    //Methods for KeyListener, only one will be used
    @Override
    public void keyTyped(KeyEvent e){}

    // Key pressed is used to see if eith of the direction keys are pressed
    // if so then we invoke the one of the direction methods on the david object

    @Override
    public void keyPressed(KeyEvent e){
        int keycode = e.getKeyCode();

        if(keycode == KeyEvent.VK_UP){
             strippling.moveNorth();
        }

        else if(keycode == KeyEvent.VK_DOWN){
            strippling.moveSouth();
        }

        else if(keycode == KeyEvent.VK_LEFT){
            strippling.moveWest();
        }

        else if(keycode == KeyEvent.VK_RIGHT){
            strippling.moveEast();
        }

        // If david object is in the same room, he uses the pickup stone method and 
        // the stone dissapears from the room

        for(var s: stone){
            Room sr = s.getCurrentRoom();
            if(strippling.currentRoom == sr){
                strippling.pickUpStone();
                s.setCurrentRoom(null);
            }
        
        }

        // Game end messages, david wins if he picks up all 5 stones.

        if(strippling.getCurrentRoom() == goliath.getCurrentRoom()){
            if(strippling.isArmed()){
                JOptionPane.showMessageDialog(null, "Congratulations, you Slaughtered your prey");
                reset();
            }
            else{
                JOptionPane.showMessageDialog(null,"You were not strong enough, you were killed.");
                reset();
            }

        }

        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e){}

    // Reset method, invoked after the game is over, resets objects to original state.

    private void reset(){

        strippling.reset();
        strippling.setCurrentRoom(rooms[22]);
        stone[0].setCurrentRoom(rooms[1]);
        stone[1].setCurrentRoom(rooms[8]);
        stone[2].setCurrentRoom(rooms[10]);
        stone[3].setCurrentRoom(rooms[12]);
        stone[4].setCurrentRoom(rooms[24]);
        
    }



}
