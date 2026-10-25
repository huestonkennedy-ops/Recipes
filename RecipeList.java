import java.util.ArrayList;

public class RecipeList {
    private ArrayList<Recipe>  recipes =  new ArrayList<>();
    public RecipeList(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }
    public String toString() {
        String string = "";
        for(Recipe i: recipes) {
            string += (i + "\n");
        }
        return string;
    }
    public void search(String name) {
        boolean found = false;
        for(Recipe i: recipes) {
            if(i.name().contains(name)) {
                System.out.println(i);
                found = true;
            }
        }
        if(found == false) {
            System.out.println("Sorry, we couldn't find anything containing that.");
        }
    }
    public void searchTime(int time) {
        boolean found = false;
        for(Recipe i: recipes) {
            if(i.time()<=time) {
                System.out.println(i);
                found = true;
            }
        }
        if(found == false) {
            System.out.println("Sorry, we couldnt find anything shorter than that.");
        }
    }
    public void searchIngredient(String ingredient) {
        boolean found = false;
        for(Recipe i: recipes) {
            for(String u: i.ingredients) {
                if(u.equals(ingredient)) {
                    System.out.println(i);
                    found = true;
                }
            }
        }
        if (found==false) {
            System.out.println("Sorry, we couldn't find anything with that");
        }
    }
}