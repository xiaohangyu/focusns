package org.focusns.social.api;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;

public class TencentApi extends DefaultApi20{

    private static final String ACCESS_TOKEN_END_POINT = "";
    private static final String AUTHORIZE_URL = "https://open.t.qq.com/cgi-bin/authorize?oauth_token=%s&oauth_callback=%s";


    @Override
    public String getAccessTokenEndpoint() {
        return null;
    }

    @Override
    public String getAuthorizationUrl(OAuthConfig config) {
        return null;
    }
}
