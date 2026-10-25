import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;
public class Main {
    public static void main(String[] args) {
        //Obtaining the file that the user wants to read
        Scanner userInput = new Scanner(System.in);
        System.out.print("File to read: ");
        String filename = userInput.nextLine();
        Scanner scanner = getScanner(filename);
        //Adding all the recipes from the file into a list of recipes, and putting that list onto a new class
        ArrayList<Recipe> recipes = new ArrayList<>();
        while(scanner.hasNextLine()){
            String name = scanner.nextLine();
            int cookingTime = Integer.valueOf(scanner.nextLine());
            ArrayList<String> ingredients = new ArrayList<>();
            while(true) {
                if (!(scanner.hasNextLine())) {
                    recipes.add(new Recipe(name, cookingTime, ingredients));
                    break;
                }
                String ingredientName = scanner.nextLine();
                if(ingredientName.equals("")) {
                    recipes.add(new Recipe(name, cookingTime, ingredients));
                    break;
                } 
                ingredients.add(ingredientName);
            }
        }
        RecipeList recipeList = new RecipeList(recipes);
        //allowing the user to enter commands
        while(true) {
            System.out.print("Command: ");
            String command = userInput.nextLine();
            if(command.equals("stop")) {
                System.out.println("Did you like this service?");
                break;
            } else if (command.equals("list")) {
                System.out.println("\nRecipes: ");
                System.out.print(recipeList);
            } else if(command.equals("find name") || command.equals("search")) {
                System.out.print("Searched word: ");
                String word = userInput.nextLine();
                recipeList.search(word);
            } else if(command.equals("find cooking time") || command.equals("times") || command.equals("search times")) {
                System.out.print("Max cooking time: ");
                recipeList.searchTime(Integer.valueOf(userInput.nextLine()));
            } else if(command.equals("search ingredients")) {
                System.out.print("Ingredient to search for: ");
                recipeList.searchIngredient(userInput.nextLine());
            } else {
                System.out.println("That was an invalid command, try again.");
            }
        }
     } 
    //defining a method to create a scanner from a given filename
    public static Scanner getScanner(String fileName) {
        try {
            Scanner scanner =  new Scanner(Paths.get(fileName));
            return scanner;
        } catch(Exception e) {
            Scanner scanner = new Scanner(System.in);
            return scanner;
        }
    }
}
