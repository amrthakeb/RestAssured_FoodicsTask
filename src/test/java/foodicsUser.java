import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"national_id","mobile_dial_code","mobile_number","last_login_attempt","last_login","birth_date","gender","preferred_language"
        ,"eKYC","birth_country","residence_country","source_of_income","profession","is_owner","is_contact_user","is_active"
        ,"created_at"})
public class foodicsUser {
    @JsonProperty("onboard_request")
    private String onboard_request;
    @JsonProperty("merchant")
    private foodicsMerchant merchant;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("updated_at")
    private String updated_at;
    public String getOnboard_request() {
        return onboard_request;
    }

    public void setOnboard_request(String onboard_request) {
        this.onboard_request = onboard_request;
    }

    public foodicsMerchant getMerchant() {
        return merchant;
    }

    public void setMerchant(foodicsMerchant merchant) {
        this.merchant = merchant;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
