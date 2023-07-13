import javax.swing.ImageIcon;
import java.awt.*;

public abstract class Sprite implements Drawable {
    
    //Fields

    protected Room currentRoom;
    protected ImageIcon image;

    //constructor
    public Sprite(){

        currentRoom = null;
        image = null;

    }

    //setter method, sets the room in which the sprite will appear
    public void setCurrentRoom(Room r){

        currentRoom = r;

    }

    // getter method

    public Room getCurrentRoom(){
        
        return currentRoom;
        
    }

    public void draw(Graphics g){
        if(currentRoom!= null){
            Point here = currentRoom.getPosition();
            image.paintIcon(null,g,here.x+8,here.y+9);

        
        }



    }

    //Methods that check if there is an exit, if true it moves the sprite to that new location
    public void moveSouth(){
        if(currentRoom.hasSouthExit()){
            currentRoom = currentRoom.getSouthExit();
        }

    }

    public void moveNorth(){
        if(currentRoom.hasNorthExit()){
            currentRoom = currentRoom.getNorthExit();
        }

    }

    public void moveWest(){
        if(currentRoom.hasWestExit()){
            currentRoom = currentRoom.getWestExit();
        }

    }

    public void moveEast(){
        if(currentRoom.hasEastExit()){
            currentRoom = currentRoom.getEastExit();
        }

    }



}


