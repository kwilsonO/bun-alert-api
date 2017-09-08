package bun;

import bun.data.MemoryStore;
import bun.data.Store;
import bun.model.Bun;
import com.google.maps.GeoApiContext;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@PropertySource("classpath:apiKey.properties")
public class BunAlertApiApplication {

    @Value("{apiKey}")
    public String apiKey;

    public static void main(String[] args) {
        SpringApplication.run(BunAlertApiApplication.class, args);
    }

    @Bean(name = "geocodeApiContext")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConfigurationProperties(prefix = "config")
    public GeoApiContext getGeocodeApiContext() {
        GeoApiContext context = new GeoApiContext.Builder()
               .apiKey(apiKey)
               .build();

        return context;
    }

    @Bean(name = "memoryStore")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Store<Bun, LatLng> getMemoryStore() {
        return new MemoryStore();
    }
}
