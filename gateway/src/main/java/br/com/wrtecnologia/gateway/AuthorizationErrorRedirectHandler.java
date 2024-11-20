package br.com.wrtecnologia.gateway;

import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.ClientAuthorizationException;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class AuthorizationErrorRedirectHandler {

    private static final String HOME_URL = "http://localhost:9001/api/hello";

    public Mono<Void> redirectToHome(WebFilterExchange exchange) {
        return Mono.defer(() -> {
            exchange.getExchange().getResponse().setStatusCode(HttpStatus.FOUND);
            exchange.getExchange().getResponse().getHeaders().setLocation(URI.create(HOME_URL));
            return exchange.getExchange().getResponse().setComplete();
        });
    }

    public Mono<Void> handleAuthorizationError(Throwable throwable, WebFilterExchange exchange) {
        if (throwable instanceof ClientAuthorizationException) {
            System.err.println("Erro de autorização detectado: " + throwable.getMessage());
            return redirectToHome(exchange);
        }
        return Mono.error(throwable);
    }
}
