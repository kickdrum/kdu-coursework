package shrishti.example.ExchangeArray;
import shrishti.example.Logger.logger;

public class ArrayExchange {
    public static <T> void exchangeELements(T[] arr,int pos1, int pos2){
        if(arr==null || pos1<0 || pos1>=arr.length || pos2<0 || pos2>=arr.length){
            logger.printLogger("Wrong input");
            return;
        }
        T temp = arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=temp;
    }

    public static void main(String[] args){
        Integer[] arr = {4,5,6,3};
        logger.printLogger("Before exchanging pos:");
        exchangeELements(arr,2,4);

    }
}
