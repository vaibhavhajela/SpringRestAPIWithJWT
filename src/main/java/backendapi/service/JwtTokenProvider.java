package backendapi.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.UUID;

public class JwtTokenProvider {

    private static final String TOKEN_ISSUER = "https://proman.io";

    private  Algorithm algorithm = null;

    public JwtTokenProvider(final String secret) {
        try {
            algorithm = Algorithm.HMAC512(secret);

        }
        catch (IllegalArgumentException e) {
        }
    }

    public String generateToken(final String username) {

        final Date issuedAt = new Date(System.currentTimeMillis());
        final Date expiresAt = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);

        return JWT.create().withIssuer(TOKEN_ISSUER) //
                .withKeyId(UUID.randomUUID().toString())
                .withAudience(username) //
                .withIssuedAt(issuedAt).withExpiresAt(expiresAt).sign(algorithm);
    }
}