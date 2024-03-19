package aplicacion1;

import java.util.Scanner; //Package that allows us to obtain data entry

public class Main{  //create the class
    public static void main (String []arg) {

        Scanner sn = new Scanner(System.in); //create the scanner instance to capture user data

        //Define integer type variables
        int tileSize;
        int perimeter1;
        int perimeter2;
        int numberOfTiles;

        //tile size request to user
        System.out.println("Insert tile size:");
        //save value entered in variable
        tileSize = sn.nextInt();
        //request for the first perimeter
        System.out.println("Insert first perimeter:");
        //save value entered in variable
        perimeter1 = sn.nextInt();
        //second perimeter request
        System.out.println("Insert second perimeter:");
        //save value entered in variable
        perimeter2 = sn.nextInt();
        //calculation to define how many tiles are needed
        numberOfTiles = ((perimeter1/tileSize)+(perimeter1%tileSize))*((perimeter2/tileSize)+(perimeter2%tileSize));
        //Result
        System.out.println("The number of tiles they need are: "+ numberOfTiles);


    }

}