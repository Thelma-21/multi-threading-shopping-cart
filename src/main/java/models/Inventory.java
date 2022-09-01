package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Inventory {
    public List<Product> productList = new ArrayList<>();
    public List<Product> addToProductList(){
        String input;
            try {
                BufferedReader br = new BufferedReader(new FileReader("/Users/dec/IdeaProjects/MyWeek4Task/src/main/resources/ProductList.csv"));
                while ((input = br.readLine()) != null){
                    String [] values = input.split(",");
                    String name = values[1].toLowerCase();
                    String category = values[0].toLowerCase();
                    long quantity = Long.parseLong(values[2]);
                    double price = Double.parseDouble(values[3]);
                    if(getMatchIndex(name) >= 0){
                        Product product = productList.get(getMatchIndex(name));
                        product.setQuantity(product.getQuantity() + quantity);
                    }else{
                        Product newProduct = new Product(category, name, quantity, price);
                        productList.add(newProduct);
                    }
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        return productList;
    }

    public int getMatchIndex(String item){
        for(Product product: productList){
            if(product.getName().equalsIgnoreCase(item)){
                return productList.indexOf(product);
            }
        }
        return -1;
    }

    public void printProds() {
        for (Product p : productList) {
            System.out.println(p);
        }

    }


}
