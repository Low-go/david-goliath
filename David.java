import javax.swing.ImageIcon;

public class David extends Sprite{
    
    private int numbStones;

    //constructor
    public David(){
 
        super();
        image = new ImageIcon("david.png");
        numbStones = 0;

    }

    public void pickUpStone(){

        numbStones += 1;
    }

    
    public boolean isArmed(){
       
        if(numbStones == 5){
            return true;

        }
        else{
            return false;
        }

    }

    public void reset(){

        numbStones = 0;
    }

}


