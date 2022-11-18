import com.vk.api.sdk.client.Lang;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.users.responses.SearchResponse;

public class VkManager {
    static TransportClient transportClient = new HttpTransportClient();
    static VkApiClient vk = new VkApiClient(transportClient);
    static UserActor actor;

    public static void main(String[] args) throws ClientException, ApiException {
//        UserAuthResponse authResponse = vk.oAuth()
//                .userAuthorizationCodeFlow(51463689, "vk1.a.7qMCfCcvw-Lp5HyzwxpeneD_ZcWdcY7manz9UwT_lK2r6XcqoBL5ENx8jrtI75tRZHBGc48FjqIJJHAbiHlNYWUHvkQm-mXnVbLUy539SCTaeKXKw4AgY2oihgxvSX0gTQSNhtvtBI9c85gBm8CsOOR6AaT_eOKTmjPH4CbIpjlF2Xp4OO_SggmVwgR8HNPp")
//                .execute();

        actor = new UserActor(51463689, "vk1.a.JkFji9XEnai9Ynp3z_jBfvUeVQnhi0H8g1J4ZEVhYlgGJIptDXpVId-wjV1GmoFR5vV9sEyL_o-N1mBLAZWQQh5bNYwc--6lW9YD_vwnvc29BwyeAxytBBCbfH1Xmxs0KfXMgrvITaXpxv0DQFa9CguKJilVSCkGtV6CnkLkhmipZKJJbRT3YUKfDDvQrsgl");

        var response = SearchUser("Артем Садыков");

        if (response.getCount() > 1)
        System.out.print(response.getCount());
    }


    private static SearchResponse SearchUser(String fullName) throws ClientException, ApiException {
        return vk.users()
                .search(actor)
                .lang(Lang.RU)
                .q(fullName)
                .execute();
    }
}
