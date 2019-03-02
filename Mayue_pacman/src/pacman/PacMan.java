
/**
 * This is PacMan class. With this class, players can set and get, X, Y and direction.
 * It also define several methods for commands: left, right and move.
 * 
 * @author Mayue Jiang
 * @version 03/03/2019
 */

package pacman;

public class PacMan {

    public static final int MAXX = 5;

    public static final int MAXY = 5;

    public static final int MINX = 0;

    public static final int MINY = 0;


    @Override
    public String toString() {
        return "Output:"+x+","+y+","+direction.name();
    }

    private int x;

    private int y;

    private Direction direction;

    /**
     * Method for getting Abscissa value
     * 
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Method for setting Abscissa value
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Method for getting Ordinate value
     * 
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Method for setting Ordinate value
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Method for getting direction
     * 
     * @return direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Method for setting direction of PacMan
     * 
     * @param direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Method for validating input x, y, direction
     * 
     */
    public PacMan(int x, int y, String direction) {
        if(x<MINX||x>MAXX||y>MAXY||y<MINY){
            throw new RuntimeException("Please input valid data.");
        }
        this.x = x;
        this.y = y;
        if(Direction.NORTH.name().equals(direction)){
            this.direction = Direction.NORTH;
        }else if(Direction.WEST.name().equals(direction)){
            this.direction = Direction.WEST;
        }else if(Direction.EAST.name().equals(direction)){
            this.direction = Direction.EAST;
        }else if(Direction.SOUTH.name().equals(direction)){
            this.direction = Direction.SOUTH;
        }else{
            throw new RuntimeException("Please input valid data.");
        }

    }

    /**
     * Method for defining left command
     * 
     */
    public void left(){
        if(Direction.NORTH.equals(this.direction)){
            this.direction = Direction.WEST;
        }else if(Direction.WEST.equals(this.direction)){
            this.direction = Direction.SOUTH;
        }else if(Direction.SOUTH.equals(this.direction)){
            this.direction = Direction.EAST;
        }else{
            this.direction = Direction.NORTH;
        }
    }

    /**
     * Method for defining right command
     * 
     */
    public void right(){
        if(Direction.NORTH.equals(this.direction)){
            this.direction = Direction.EAST;
        }else if(Direction.WEST.equals(this.direction)){
            this.direction = Direction.NORTH;
        }else if(Direction.SOUTH.equals(this.direction)){
            this.direction = Direction.WEST;
        }else{
            this.direction = Direction.SOUTH;
        }
    }

    /**
     * Method for defining move command
     * 
     */
    public boolean move(){
        if(Direction.NORTH.equals(this.direction)){
            if(this.y == MAXY){
                return false;
            }
            this.y++;
            return true;
        }else if(Direction.WEST.equals(this.direction)){
            if(this.x == MINX){
                return false;
            }
            this.x--;
            return true;
        }else if(Direction.SOUTH.equals(this.direction)){
            if(this.y == MINY){
                return false;
            }
            this.y--;
            return true;
        }else{
            if(this.x == MAXX){
                return false;
            }
            this.x++;
            return true;
        }
    }
}
