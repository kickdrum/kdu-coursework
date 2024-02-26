export interface ProductProps {
  id: number;
  title: string;
  price: number;
  description: string;
  category: "electronics" | "jewelery" | "men's clothing" | "women's clothing";
  image: string;
  rating: {
    rate: number;
    count: number;
  };
}