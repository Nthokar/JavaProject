import Course.Student;
import com.vk.api.sdk.client.Lang;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.base.Country;
import com.vk.api.sdk.objects.database.City;
import com.vk.api.sdk.objects.database.University;
import com.vk.api.sdk.objects.groups.responses.GetResponse;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.UserFull;
import com.vk.api.sdk.objects.users.responses.SearchResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VkManager {
    TransportClient transportClient = new HttpTransportClient();
    VkApiClient vk = new VkApiClient(transportClient);
    UserActor actor;

    private final int countryId;
    private final int cityId;
    private final int universityId;

    public static void main(String[] args) throws ClientException, ApiException {
//        try {
//            transportClient.get("https://oauth.vk.com/authorize?client_id=51463689&display=page&redirect_uri=http://yoursite.com&scope=friends&response_type=code&v=5.131", "");
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }

//        UserAuthResponse authResponse = vk.oAuth()
//                .userAuthorizationCodeFlow(51463689, "kr1vOrwoAMO4E74SL94J", "http://yoursite.com", "20e12b850a7b65daa0")
//                .execute();
        //actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
        //actor = new UserActor(51463689, "vk1.a.JkFji9XEnai9Ynp3z_jBfvUeVQnhi0H8g1J4ZEVhYlgGJIptDXpVId-wjV1GmoFR5vV9sEyL_o-N1mBLAZWQQh5bNYwc--6lW9YD_vwnvc29BwyeAxytBBCbfH1Xmxs0KfXMgrvITaXpxv0DQFa9CguKJilVSCkGtV6CnkLkhmipZKJJbRT3YUKfDDvQrsgl");
    }

    public VkManager(String countryCode, String cityName, String universityName) throws ClientException, ApiException {

//        try {
//            var response = transportClient.post("https://oauth.vk.com/authorize?client_id=51463689&display=page&redirect_uri=http://yoursite.com&scope=friends&response_type=code&v=5.131");
//            var b = 1+ 1;
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        var code = "202c069ce9fe4c472a";
//        UserAuthResponse authResponse = vk.oAuth()
//                .userAuthorizationCodeFlow(51463689, "kr1vOrwoAMO4E74SL94J", "http://yoursite.com", code)
//                .execute();
        //actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
        var accesToken = "vk1.a.orS3IMm4O2seodSk9bi97ONle2DX_JOdZOxqHNLlO38LmZ2nEGoasJvPckFvXSLPXD6-V_UtiglKnAdh7ywL8Pt1f6i0_5llkklBVreEhJYsXtIsYSlByE7XBH2VGpCvPAxTQiTwei1VfIvSn1wkPcJR44JZpBH40xCjJrUeJ1O6NHr5J7GWLP6v7-vIMqBi";
        actor = new UserActor(51463689, accesToken);

        countryId = tryGetCountryId(countryCode);
        cityId = tryGetCityId(cityName);
        universityId = tryGetUniversityId(universityName);
    }

    public SearchResponse SearchUser(String fullName) throws ClientException, ApiException {

        try {
            Thread.sleep(250);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return vk.users()
                .search(actor)
                .fields(Fields.SEX, Fields.BDATE, Fields.HOME_TOWN, Fields.CITY)
                .lang(Lang.RU)
                .q(fullName)
                .country(countryId)
                .city(cityId)
                .university(universityId)
                .execute();
    }
    public Student parseVkUserToStudent(Student student, UserFull userFull){
        student.setBirthDate(getBirthdate(userFull));
        student.setHomeTown(userFull.getHomeTown());
        student.setSex(userFull.getSex());
        return student;
    }
    private LocalDate getBirthdate(UserFull userFull) {
        var bDate = userFull.getBdate();
        if (bDate == null)
            return null;

        if (bDate.split("\\.").length == 2)
            bDate += ".0001";

        return LocalDate.parse(bDate, DateTimeFormatter.ofPattern("d.M.yyyy"));
    }

    public GetResponse tryGetUsersGroups(Integer user_id) throws ClientException, ApiException {
        return vk.groups()
                .get(actor)
                .userId(user_id)
                .execute();
    }
    private int tryGetCountryId(String countryCode) throws ClientException, ApiException {
        return vk.database()
                .getCountries(actor)
                .code(countryCode)
                .count(1)
                .execute()
                .getItems()
                .stream()
                .findFirst()
                .map(Country::getId)
                .orElseThrow(() -> new IllegalArgumentException("Country not found!"));
    }

    private int tryGetCityId(String cityName) throws ClientException, ApiException {
        return vk.database()
                .getCities(actor, countryId)
                .q(cityName)
                .count(1)
                .execute()
                .getItems()
                .stream()
                .findFirst()
                .map(City::getId)
                .orElseThrow(() -> new IllegalArgumentException("City not found!"));
    }

    private int tryGetUniversityId(String universityName) throws ClientException, ApiException {
        return vk.database()
                .getUniversities(actor)
                .q(universityName)
                .countryId(countryId)
                .cityId(cityId)
                .count(1)
                .execute()
                .getItems()
                .stream()
                .findFirst()
                .map(University::getId)
                .orElseThrow(() -> new IllegalArgumentException("University not found!"));
    }
}
