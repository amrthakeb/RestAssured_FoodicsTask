import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"reference","business_type","business_reference","solo_id","business_name_localized","commercial_registration"
,"commercial_registration_expiration","unified_national_number","mcc","settlement_enabled","settlement_disabled_reason","total_terminals"
,"active_terminals","is_active","is_approved","updated_at"})


public class foodicsMerchant {

    @JsonProperty("id")
    private String id;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("business_name")
    private String business_name;
    @JsonProperty("beneficiary_name")
    private String beneficiary_name;
    @JsonProperty("created_at")
    private String created_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBeneficiary_name() {
        return beneficiary_name;
    }

    public void setBeneficiary_name(String beneficiary_name) {
        this.beneficiary_name = beneficiary_name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
