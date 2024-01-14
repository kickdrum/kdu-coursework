package jav.assignment.readFiles;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJSON {
    public static JSONArray JSONFileReader(String path, JSONArray transaction) {
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);
            transaction = (JSONArray) obj;
//                System.out.println(transaction);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    public static Object parseTypeForJSONObject(JSONObject transaction) {
        return transaction.get("type");
    }

    public static Object parseDataForJSONObject(JSONObject transaction) {
        return transaction.get("data");
    }
}

