package Template;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Random;

public class Product {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("shipping")
    @Expose
    private Integer shipping;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image")
    @Expose
    private String image;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getShipping() {
        return shipping;
    }

    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product getBasicProduct()
    {
        Product product = new Product();
        product.type = Generator.randomShortText();
        product.shipping = Generator.randomInt(4);
        product.upc = Generator.randomShortText();
        product.name = Generator.randomShortText();
        product.description = Generator.randomShortText();
        product.url = Generator.randomShortText();
        product.model = Generator.randomShortText();
        return product;
    }
    public String getBasicProductAsJson()
    {
        Product product = getBasicProduct();
        Gson gson = new Gson();
        String jsonString = gson.toJson(product);
        System.out.println("jsonString = " + jsonString);
        return  jsonString;
    }

    public String getProductWithNameAsJson(String name)
    {
        Product product = getBasicProduct();
        product.setName(name);
        Gson gson = new Gson();
        String jsonString = gson.toJson(product);
        System.out.println("jsonString = " + jsonString);
        return  jsonString;
    }
}
