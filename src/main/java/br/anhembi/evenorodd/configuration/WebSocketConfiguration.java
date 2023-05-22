package br.anhembi.evenorodd.configuration;

import br.anhembi.evenorodd.handler.ParOuImparHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    private final static String GAME_ENDOPOINT = "/play";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getParOuImparHandler(),GAME_ENDOPOINT)
                .setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler getParOuImparHandler(){
        return new ParOuImparHandler();
    }
}
