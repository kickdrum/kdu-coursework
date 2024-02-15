import { apiResponse, IRecipe } from "./interface";

async function fetchRecipesFromAPI() {
  const response = await fetch("https://dummyjson.com/recipes");
  return (await response.json()) as apiResponse;
}

async function searchRecipies(query: string) {
  const response = await fetch(
    `https://dummyjson.com/recipes/search?q=${query}`
  );
  return (await response.json()) as apiResponse;
}
function printRecipeDetails(recipe: IRecipe): void {
  console.log(` - Image: ${recipe.image}`);
  console.log(` - Name: ${recipe.name}`);
  console.log(` - Rating: ${recipe.rating}`);
  console.log(` - Cuisine: ${recipe.cuisine}`);
  console.log(` - Ingredients:`);
  recipe.ingredients.forEach((ingredient) => console.log(`   - ${ingredient}`));
  console.log(` - Difficulty: ${recipe.difficulty}`);
  console.log(
    ` -Cook Time: ${recipe.prepTimeMinutes + recipe.cookTimeMinutes} minutes`
  );
  console.log(` - Calories: ${recipe.caloriesPerServing}`);
}

async function main(): Promise<void> {
  // Fetch all recipes
  const allRecipes = await fetchRecipesFromAPI();

  //   Print all recipes
  console.log("All Recipes:");
  allRecipes.recipes.forEach(printRecipeDetails);

  console.log("Requested Recipes:");
  const requestedRecipes = await searchRecipies("pizza");
  requestedRecipes.recipes.forEach(printRecipeDetails);
}
main();
