import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String fileName = "toys.txt";
    public static void main(String[] args) {
        try{
            ToyStore store = new ToyStore();
            File toyFile = new File(fileName);

            if(!toyFile.exists()){
                toyFile.createNewFile();
                store.addToy(new Toy(1,"Car", 5, 15));
                store.addToy(new Toy(2,"ActionFigure", 10, 20));
                store.addToy(new Toy(3,"Bunny", 3, 25));
                store.saveToFile(fileName);
            } else {
                store.loadFromFile(fileName);
            }
            store.setWeight(1,20);
            ArrayList<String> toyList = store.getToyList();
            for(String toy:toyList){
                System.out.println(toy);
            }
            ArrayList<Toy> winners = store.play(3);
            System.out.println("You get the following toys: ");
            for(Toy t:winners){
                System.out.println(t.getName());
            }
            store.saveToFile(fileName);
        } catch (IOException e){
            System.out.println("Error with the file: " + e.getMessage());
        }
    }
}
