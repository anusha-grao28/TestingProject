package Template;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Store {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("lat")
    @Expose
    private Integer lat;
    @SerializedName("lng")
    @Expose
    private Integer lng;
    @SerializedName("hours")
    @Expose
    private String hours;
    @SerializedName("services")
    @Expose
    private Services services;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Store getBasicStore()
    {
        Store store = new Store();
        store.type = Generator.randomShortText();
        store.name = Generator.randomShortText();
        store.address = Generator.randomShortText();
        store.city = Generator.randomShortText();
        store.state = Generator.randomShortText();
        store.zip = Generator.randomShortText();
        return store;
    }
    public String getBasicStoreAsJson()
    {
        Store store = getBasicStore();
        Gson gson = new Gson();
        String jsonString = gson.toJson(store);
        System.out.println("jsonString = " + jsonString);
        return  jsonString;
    }

    public String getStoreWithNameAsJson(String name)
    {
        Store store= getBasicStore();
        store.setName(name);
        Gson gson = new Gson();
        String jsonString = gson.toJson(store);
        System.out.println("jsonString = " + jsonString);
        return  jsonString;
    }

}