import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineApplication {
    public static void main(String args[]){
        DepthFirstSearch.jugCapacities = input();

        System.out.println(DepthFirstSearch.doDepthFirstSearch() + " Nodes Traversed");
    }

    public static ArrayList<Integer> input(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> setJugCapacities = new ArrayList<String>(3);
        ArrayList<Integer> jugCapacities = new ArrayList<Integer>(3);

        do{
            System.out.print("Please enter the capacity of the first jug: ");
            String jugA = sc.nextLine();
            setJugCapacities.add(0,jugA);
        } while (!InputValidation.validateInteger(setJugCapacities.get(0)));

        do{
            System.out.print("Please enter the capacity of the second jug: ");
            String jugB = sc.nextLine();
            setJugCapacities.add(1,jugB);
        } while(!InputValidation.validateInteger(setJugCapacities.get(1)));

        do{
            System.out.print("Please enter the capacity of the third jug: ");
            String jugC = sc.nextLine();
            setJugCapacities.add(2,jugC);
        } while(!InputValidation.validateInteger((setJugCapacities.get(2))));

        for (String capacity : setJugCapacities){
            jugCapacities.add(Integer.parseInt(capacity));
        }

        return jugCapacities;
    }


    public static void outputInvalidInput(){
        System.out.println("Invalid input. Please ensure you enter a positive number.\n");
    }


    public static void outputNode(Node node){
        System.out.println(node.toString());
    }
}
