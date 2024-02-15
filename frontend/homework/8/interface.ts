export interface IRecipe {
  id: number;
  name: string;
  image: string;
  ingredients: string[];
  rating: number;
  cuisine: string;
  difficulty: string;
  caloriesPerServing: number;
  cookTimeMinutes: number;
  prepTimeMinutes: number;
}

export interface apiResponse {
  recipes: IRecipe[];
  total: number;
}
