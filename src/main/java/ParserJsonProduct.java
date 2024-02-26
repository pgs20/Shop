import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
// Принцип замены Барбары Лисков
public class ParserJsonProduct implements Parser {
    @Override
    public List<Product> parse(String fileName) {
        List<Product> listProduct = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        Gson gson = new GsonBuilder().create();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(readString(fileName));
            for (int i = 0; i < jsonArray.size(); ++i) {
                listProduct.add(gson.fromJson(jsonArray.get(i).toString(), Product.class));
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return listProduct;
    }

    public String readString(String fileName) {
        String res = null;
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            while ((res = br.readLine()) != null) {
                stringBuilder.append(res);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
