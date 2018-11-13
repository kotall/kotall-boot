package com.kotall.rms.web.auth;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 *
 * @author aracwong
 * @date 2017年9月3日 上午2:56:44
 */
public class AuthToken implements AuthenticationToken {
	
	private static final long serialVersionUID = 1L;
	
	private String token;

    public AuthToken(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
