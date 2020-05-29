package br.com.treinaweb.filters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.annotation.Priority;
import javax.crypto.SecretKey;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Provider
@Authorize
@Priority(Priorities.AUTHENTICATION)
public class AuthorizeFilter implements ContainerRequestFilter {
    private final SecretKey CHAVE = 
            Keys.hmacShaKeyFor("7f-j&amp;CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&amp;RNbDHUX6"
                                .getBytes(StandardCharsets.UTF_8));

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        try {
            String token = authorizationHeader.substring("Bearer".length()).trim();
            
            Jwts.parserBuilder().setSigningKey(CHAVE).build().parseClaimsJws(token);
        } catch (Exception e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }

    }
    
}