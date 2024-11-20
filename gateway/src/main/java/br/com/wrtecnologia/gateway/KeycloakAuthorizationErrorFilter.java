package br.com.wrtecnologia.gateway;

import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.ClientAuthorizationException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class KeycloakAuthorizationErrorFilter implements WebFilter {

    private static final String LOGIN_URL = "http://localhost:9001/api/hello"; // Página de login ou revalidação

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return chain.filter(exchange)
                .onErrorResume(ClientAuthorizationException.class, ex -> {
                    System.err.println("Erro de autorização detectado: " + ex.getMessage());

                    // Remover cookies configurando `Set-Cookie` com Max-Age=0
                    exchange.getRequest().getCookies().forEach((name, cookies) -> {
                        for (HttpCookie cookie : cookies) {
                            ResponseCookie expiredCookie = ResponseCookie.from(cookie.getName(), "")
                                    .maxAge(0) // Remove imediatamente
                                    .path("/") // Abrange toda a aplicação
                                    .build();
                            exchange.getResponse().addCookie(expiredCookie);
                        }
                    });

                    // Redireciona o usuário para a página de login ou tratamento
                    exchange.getResponse().setStatusCode(HttpStatus.FOUND);
                    exchange.getResponse().getHeaders().setLocation(URI.create(LOGIN_URL));
                    return exchange.getResponse().setComplete();
                });
    }
}

