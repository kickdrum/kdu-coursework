var ShopRecipe = /** @class */ (function () {
    function ShopRecipe(apiUrl) {
        this.apiUrl = apiUrl;
    }
    ShopRecipe.prototype.fetchRecipesFromAPI = function () {
        var _this = this;
        return new Promise(function (resolve, reject) {
            fetch(_this.apiUrl)
                .then(function (response) { return response.json(); })
                .then(function (data) { return resolve(data.recipes); })
                .catch(function (error) { return reject(error); });
        });
    };
    ShopRecipe.prototype.searchRecipes = function (query) {
        var _this = this;
        return new Promise(function (resolve, reject) {
            fetch("".concat(_this.apiUrl, "/search?q=").concat(query))
                .then(function (response) { return response.json(); })
                .then(function (data) { return resolve(data.recipes); })
                .catch(function (error) { return reject(error); });
        });
    };
    ShopRecipe.prototype.printAllRecipes = function (recipes) {
        recipes.forEach(function (recipe) {
            console.log('Name:', recipe.name);
            console.log('Rating:', recipe.rating);
            console.log('Cuisine:', recipe.cuisine);
            console.log('Ingredients:', recipe.ingredients);
            console.log('Difficulty:', recipe.difficulty);
            console.log('Time taken:', recipe.preparationTime + recipe.cookingTime);
            console.log('Calorie count:', recipe.calorieCount);
            console.log('+++++++++++++++++++++++++++++++++++++++++++');
        });
    };
    return ShopRecipe;
}());
var app = new ShopRecipe('https://dummyjson.com/recipes');
app.fetchRecipesFromAPI()
    .then(function (recipes) {
    console.log('All Recipes:');
    app.printAllRecipes(recipes);
})
    .catch(function (error) {
    console.error('Error fetching recipes:', error);
});
var query = 'chicken';
app.searchRecipes(query)
    .then(function (recipes) {
    console.log("Recipes matching \"".concat(query, "\":"));
    app.printAllRecipes(recipes);
})
    .catch(function (error) {
    console.error('Error searching recipes:', error);
});
