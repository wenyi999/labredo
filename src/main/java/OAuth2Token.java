/**
 * Created by Boyi on 2018/4/21.
 */
public class OAuth2Token implements AuthenticationToken {
    private String authCode;
    private String principal;
    public OAuth2Token(String authCode) {
        this.authCode = authCode;
    }
}
