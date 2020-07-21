package com.web.oauth;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;


public class ClientResources {

    @NestedConfigurationProperty //해당 필드가 단일값이 아닌 중복으로 바인딩 된다고 표시
    private AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails(); //프로퍼티값중 client 를 기준으로 하위 키/값을 매핑해주는 대상 객체

    @NestedConfigurationProperty
    private ResourceServerProperties resource = new ResourceServerProperties();

    public AuthorizationCodeResourceDetails getClient() {
        return client;
    }

    public ResourceServerProperties getResource() {
        return resource;
    }
}
