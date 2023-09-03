import com.fasterxml.jackson.annotation.JsonProperty;


public class foodicsDeSerialize //it's used for deserializing JSON data into Java objects.
{

    @JsonProperty("user")
    private foodicsUser user;  //when Jackson encounters JSON data with "user" property,
                              // it automatically assigns its value to the corresponding field in the Java object

    public foodicsUser getUser() {
        return user;
    }

    public void setUser(foodicsUser user) {
       this.user = user;
    }
}
