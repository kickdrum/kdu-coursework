interface Recipe {
  image: string;
  name: string;
  rating: number;
  cuisine: string;
  ingredients: string[];
  difficulty: string;
  preparationTime: number;
  cookingTime: number;
  calorieCount: number;
}

class RecipeSearchApp {
  private apiUrl: string;
  private recipes: Recipe[];

  constructor(apiUrl: string) {
    this.apiUrl = apiUrl;
    this.recipes = [];
  }

  async fetchRecipesFromAPI(): Promise<any> {
    return new Promise(async (resolve, reject) => {
      try {
        const response = await fetch(this.apiUrl);
        if (!response.ok) {
          reject("Failed to fetch recipes");
        }
        const data = await response.json();
        this.recipes = data.recipes as Recipe[];
        resolve("success");
      } catch (error) {
        console.error("Error fetching recipes:", error);
        reject("Error fetching recipes");
      }
    });
  }

  async searchRecipes(query: string): Promise<Recipe[]> {
    const searchUrl = `${this.apiUrl}/search?q=${query}`;
    try {
      const response = await fetch(searchUrl);
      if (!response.ok) {
        throw new Error("Failed to search recipes");
      }
      return await response.json();
    } catch (error) {
      console.error("Error searching recipes:", error);
      return [];
    }
  }

  printAllRecipes(): void {
    this.recipes.forEach((recipe: Recipe) => {
      console.log("Recipe Name:", recipe.name);
      console.log("Image:", recipe.image);
      console.log("Rating:", recipe.rating);
      console.log("Cuisine:", recipe.cuisine);
      console.log("Ingredients:", recipe.ingredients);
      console.log("Difficulty:", recipe.difficulty);
      console.log("Preparation Time:", recipe.preparationTime);
      console.log("Cooking Time:", recipe.cookingTime);
      console.log("Total Time:", recipe.preparationTime + recipe.cookingTime);
      console.log("Calorie Count:", recipe.calorieCount);
    });
  }
}

const recipeSearchApp = new RecipeSearchApp("https://dummyjson.com/recipes");
(async () => {
  await recipeSearchApp.fetchRecipesFromAPI();
  recipeSearchApp.printAllRecipes();

  try {
    const testRecipe = await recipeSearchApp.searchRecipes("Pizza");
    console.log(" recipes:", testRecipe);
  } catch (error) {
    console.error("Error searching for pasta recipes:", error);
  }
})();
