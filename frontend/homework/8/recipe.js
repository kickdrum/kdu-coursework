var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
var _this = this;
var RecipeSearchApp = /** @class */ (function () {
    function RecipeSearchApp(apiUrl) {
        this.apiUrl = apiUrl;
        this.recipes = [];
    }
    RecipeSearchApp.prototype.fetchRecipesFromAPI = function () {
        return __awaiter(this, void 0, void 0, function () {
            var _this = this;
            return __generator(this, function (_a) {
                return [2 /*return*/, new Promise(function (resolve, reject) { return __awaiter(_this, void 0, void 0, function () {
                        var response, data, error_1;
                        return __generator(this, function (_a) {
                            switch (_a.label) {
                                case 0:
                                    _a.trys.push([0, 3, , 4]);
                                    return [4 /*yield*/, fetch(this.apiUrl)];
                                case 1:
                                    response = _a.sent();
                                    if (!response.ok) {
                                        reject("Failed to fetch recipes");
                                    }
                                    return [4 /*yield*/, response.json()];
                                case 2:
                                    data = _a.sent();
                                    this.recipes = data.recipes;
                                    resolve("success");
                                    return [3 /*break*/, 4];
                                case 3:
                                    error_1 = _a.sent();
                                    console.error("Error fetching recipes:", error_1);
                                    reject("Error fetching recipes");
                                    return [3 /*break*/, 4];
                                case 4: return [2 /*return*/];
                            }
                        });
                    }); })];
            });
        });
    };
    RecipeSearchApp.prototype.searchRecipes = function (query) {
        return __awaiter(this, void 0, void 0, function () {
            var searchUrl, response, error_2;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        searchUrl = "".concat(this.apiUrl, "/search?q=").concat(query);
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 4, , 5]);
                        return [4 /*yield*/, fetch(searchUrl)];
                    case 2:
                        response = _a.sent();
                        if (!response.ok) {
                            throw new Error("Failed to search recipes");
                        }
                        return [4 /*yield*/, response.json()];
                    case 3: return [2 /*return*/, _a.sent()];
                    case 4:
                        error_2 = _a.sent();
                        console.error("Error searching recipes:", error_2);
                        return [2 /*return*/, []];
                    case 5: return [2 /*return*/];
                }
            });
        });
    };
    RecipeSearchApp.prototype.printAllRecipes = function () {
        this.recipes.forEach(function (recipe) {
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
    };
    return RecipeSearchApp;
}());
var recipeSearchApp = new RecipeSearchApp("https://dummyjson.com/recipes");
(function () { return __awaiter(_this, void 0, void 0, function () {
    var testRecipe, error_3;
    return __generator(this, function (_a) {
        switch (_a.label) {
            case 0: return [4 /*yield*/, recipeSearchApp.fetchRecipesFromAPI()];
            case 1:
                _a.sent();
                _a.label = 2;
            case 2:
                _a.trys.push([2, 4, , 5]);
                return [4 /*yield*/, recipeSearchApp.searchRecipes("Pizza")];
            case 3:
                testRecipe = _a.sent();
                console.log(" recipes:", testRecipe);
                return [3 /*break*/, 5];
            case 4:
                error_3 = _a.sent();
                console.error("Error searching for pasta recipes:", error_3);
                return [3 /*break*/, 5];
            case 5: return [2 /*return*/];
        }
    });
}); })();
