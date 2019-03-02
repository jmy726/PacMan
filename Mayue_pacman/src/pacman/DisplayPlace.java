
/**
 * This is DisplayPlace class. It defines the method for initialization of PacMan game.
 * This class execute different commands and display the input and output for users.
 * 
 * @author Mayue Jiang
 * @version 03/03/2019
 */

package pacman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayPlace {

    public static final String moveError = "out of index,move fail";

    private PacMan pacMan;

    private List<String> commandList;

    /**
     * Constructor of DisplayPlace class.
     * 
     * @param commandList
     */
    public DisplayPlace(List<String> commandList) {
        super();
        if(commandList!=null&&commandList.size()>0&&commandList.get(0).startsWith(Command.PLACE.name())){
            String firstCommand = commandList.get(0);
            createPacMan(firstCommand);
            this.commandList = commandList.subList(1,commandList.size());
        }else{
            throw new RuntimeException("Please input Place command first");
        }
    }

    /**
     * Method to create and validate a new PacMan game
     * 
     * @param command
     */
    private void createPacMan(String command){
        String[] xy = command.substring(Command.PLACE.name().length()).trim().split(",");
        try {
        	int x = Integer.parseInt(xy[0]); 
        	int y = Integer.parseInt(xy[1]);
        	this.pacMan = new PacMan(x,y,xy[2]+"");
        }catch(Exception e) {
        	throw new RuntimeException("Please input valid data.");
        }
    }

    /**
     * Method to judge and execute different commands.
     * 
     */
    public void executeCommand(){

        for (String command : commandList) {
            System.out.println(command);
            if(command.startsWith(Command.PLACE.name())){
                createPacMan(command);
            }else if(command.equals(Command.LEFT.name())){
                pacMan.left();
            }else if(command.equals(Command.RIGHT.name())){
                pacMan.right();
            }else if(command.equals(Command.MOVE.name())){
                if(!pacMan.move()){
                    System.out.println(moveError);
                }
            }else if(command.equals(Command.REPORT.name())){
                System.out.println(pacMan.toString());
            }
        }
    }

    /**
     * This is main method of this project. It give the entrance of the project,read the input file
     * and display the result.
     */
    public static void main(String[] args) {
        ArrayList<String> commandList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
            		new InputStreamReader(new FileInputStream("src\\pacman\\xxx.txt"), "utf-8"));
            String command = bufferedReader.readLine();
            while (command!=null&&(!"".equals(command))) {
                commandList.add(command);
                command = bufferedReader.readLine();
            }
            DisplayPlace displayPlace = new DisplayPlace(commandList);
            displayPlace.executeCommand();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
