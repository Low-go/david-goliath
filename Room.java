import java.awt.*;


public class Room implements Drawable {
   
    //Fields
    private Point pos = new Point();
    private Room exitEast;
    private Room exitWest;
    private Room exitNorth;
    private Room exitSouth;
    public static final int size = 50;

    //Constructor 1
    public Room(int x, int y){

        pos.x = x;
        pos.y = y;
        exitEast = null;
        exitWest = null;
        exitNorth = null;
        exitSouth = null;

    }

    //Method--> draws the Room object-- or basically a square
    // and a blank or hole in wall if there exists an exit there
    public void draw(Graphics g){

        g.setColor(Color.BLUE);
        g.drawRect(pos.x, pos.y, size, size);
        var dif_grey = new Color(158,158,158);
        if(exitNorth != null){
            g.setColor(dif_grey);
            g.drawLine(pos.x+20, pos.y, pos.x+30, pos.y);
        }

        if(exitSouth != null){
            g.setColor(dif_grey);
            g.drawLine(pos.x+20, pos.y+50, pos.x+30, pos.y+50);
        }

        if(exitWest != null){
            g.setColor(dif_grey);
            g.drawLine(pos.x, pos.y+20, pos.x, pos.y+30);
        }

        if(exitEast != null){
            g.setColor(dif_grey);
            g.drawLine(pos.x+50, pos.y+20, pos.x+50, pos.y+30);
        }
           

    }

    // Next couple of methods will set the exits for each of the variables in the field
    public void setEastexit(Room r){

        exitEast = r;
        r.exitWest = this;

    }

    public void setWestexit(Room r){

        exitWest = r;
        r.exitEast = this;
        
    }

    public void setNorthexit(Room r){

            exitNorth = r;
            r.exitSouth = this;
        
    }

    public void setSouthexit(Room r){

        exitSouth = r;
        r.exitNorth = this;
        
    }

    public Point getPosition(){
        
        return pos;

    }


    // The next 4 methods will check for true or false on the given statements.
    public boolean hasNorthExit(){

        if(exitNorth == null) return false;
        else return true;


        
    }

    public boolean hasSouthExit(){

        if(exitSouth == null) return false;
        else return true;


        
    }

    public boolean hasWestExit(){

        if(exitWest == null) return false;
        else return true;


        
    }

    public boolean hasEastExit(){

        if(exitEast == null) return false;
        else return true;


        
    }

    //The next 4 will simply return the exits
    public Room getNorthExit(){

        return exitNorth;
    }

    public Room getSouthExit(){

        return exitSouth;
    }

    public Room getWestExit(){

        return exitWest;
    }

    public Room getEastExit(){

        return exitEast;
    }

}

