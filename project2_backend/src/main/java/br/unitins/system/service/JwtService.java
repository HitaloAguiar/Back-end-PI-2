package br.unitins.system.service;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.system.model.User;
import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

@Singleton
public class JwtService {
    public String generateJwt(User user) {
        // 1 hora = 3600000
        long duration = System.currentTimeMillis() + 3600000;

        System.out.println(user.getRole().getLabel());

        // upn - User Principal Name
        return Jwt.issuer("unitins-jwt")
                .claim("id", user.getIdUser())
                .claim("name", user.getName())
                .claim("email", user.getEmail())
                .upn(user.getEmail())
                .groups(user.getRole().getLabel())
                .expiresAt(duration)
                .sign();
    }

    public Long getUserId(JsonWebToken token) {
        return Long.parseLong(token.<Object>getClaim("id").toString());
    }
}
