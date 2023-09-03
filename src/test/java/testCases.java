import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class testCases {

    private static String sessionToken = "";
    @Test(priority = 1)
    public void loginReq(){

        foodicsSerialize serialize = new foodicsSerialize();
        serialize.setEmail("merchant@foodics.com");
        serialize.setPassword("123456");
        serialize.setToken("Lyz22cfYKMetFhKQybx5HAmVimF1i0xO");
        String bodyData = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            bodyData = objectMapper.writeValueAsString(serialize);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Response response =
        given()
                .contentType(ContentType.JSON)
                .body(bodyData)
                .when()
                .post("https://pay2.foodics.dev/cp_internal/login");
        response.prettyPrint();
        int responseStatus = response.statusCode();
       Assert.assertEquals(responseStatus,200,"Incorrect Response code :" + response.statusCode());
       sessionToken =  response.jsonPath().getString("token");

    }


    @Test(priority = 2)
    public void foodicsRequestTwo(){
        System.out.println(sessionToken);
        Response response =
        given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + sessionToken)
                .when()
                .get("https://pay2.foodics.dev/cp_internal/whoami/");
        response.prettyPrint();

       foodicsDeSerialize deSerialize = response.body().as(foodicsDeSerialize.class);
        int responseStatus = response.statusCode();

        Assert.assertEquals(responseStatus,200,"Incorrect Response code :" + response.statusCode());
        Assert.assertNull(deSerialize.getUser().getOnboard_request(),"OnBoard is not Null!!" + deSerialize.getUser().getOnboard_request());
        Assert.assertNotNull(deSerialize.getUser().getMerchant().getId(),"MerchantID is Null!!");
       //Assert.assertEquals(deSerialize.getUser().getMerchant().getReference(),"ME000001","MerchantReference incorrect :" +deSerialize.getUser().getMerchant().getReference());
        Assert.assertEquals(deSerialize.getUser().getMerchant().getBusiness_name(),"FOODICS","MerchantBuisnessName incorrect: " + deSerialize.getUser().getMerchant().getBusiness_name());
        Assert.assertEquals(deSerialize.getUser().getMerchant().getBeneficiary_name(),"ABDULLAH KHAWAJI","MerchantBeneficiaryName incorrect: " + deSerialize.getUser().getMerchant().getBeneficiary_name());
        Assert.assertNotNull(deSerialize.getUser().getMerchant().getCreated_at(),"MerchantCreatedDate is NULL!!");
        Assert.assertNotNull(deSerialize.getUser().getId(),"ResponseID is NULL!!");
        Assert.assertEquals(deSerialize.getUser().getName(),"Test Foodics","ResponseName incorrect: " + deSerialize.getUser().getName());
        Assert.assertEquals(deSerialize.getUser().getEmail(),"merchant@foodics.com","ResponseEmail incorrect: " + deSerialize.getUser().getEmail());
        Assert.assertTrue(deSerialize.getUser().getUpdated_at().contains("2023-09-03"),"UserUpdatedDate incorrect: " + deSerialize.getUser().getUpdated_at());
    }
}
