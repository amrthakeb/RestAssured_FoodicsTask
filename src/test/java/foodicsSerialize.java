import com.fasterxml.jackson.annotation.JsonProperty;

public class foodicsSerialize //it's used for serializing Java objects  into Json data.
{

    public void setEmail(String email) //to pass these values u have to convert them to Json
    {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("token")
    private String token;


}
