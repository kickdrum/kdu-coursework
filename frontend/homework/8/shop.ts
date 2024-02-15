// Promise polyfill for ES5/ES3 environments
declare let Promise: any;

interface IRecipe {
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

class ShopRecipe {
    private apiUrl: string;

    constructor(apiUrl: string) {
        this.apiUrl = apiUrl;
    }

    public fetchRecipesFromAPI(): Promise<IRecipe[]> {
        return new Promise((resolve, reject) => {
            fetch(this.apiUrl)
                .then(response => response.json())
                .then(data => resolve(data.recipes))
                .catch(error => reject(error));
        });
    }

    public searchRecipes(query: string): Promise<IRecipe[]> {
        return new Promise((resolve, reject) => {
            fetch(`${this.apiUrl}/search?q=${query}`)
                .then(response => response.json())
                .then(data => resolve(data.recipes))
                .catch(error => reject(error));
        });
    }

    public printAllRecipes(recipes: IRecipe[]): void {
        recipes.forEach(recipe => {
            console.log('Name:', recipe.name);
            console.log('Rating:', recipe.rating);
            console.log('Cuisine:', recipe.cuisine);
            console.log('Ingredients:', recipe.ingredients);
            console.log('Difficulty:', recipe.difficulty);
            console.log('Time taken:', recipe.preparationTime + recipe.cookingTime);
            console.log('Calorie count:', recipe.calorieCount);
            console.log('+++++++++++++++++++++++++++++++++++++++++++');
        });
    }
}

const app = new ShopRecipe('https://dummyjson.com/recipes');

app.fetchRecipesFromAPI()
    .then(recipes => {
        console.log('All Recipes:');
        app.printAllRecipes(recipes);
    })
    .catch(error => {
        console.error('Error fetching recipes:', error);
    });

const query = 'chicken';
app.searchRecipes(query)
    .then(recipes => {
        console.log(`Recipes matching "${query}":`);
        app.printAllRecipes(recipes);
    })
    .catch(error => {
        console.error('Error searching recipes:', error);
    });
