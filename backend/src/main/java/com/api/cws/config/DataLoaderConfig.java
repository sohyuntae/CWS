package com.api.cws.config;

import com.api.cws.module.testApp.query.SystemDataLoader;
import io.leangen.graphql.spqr.spring.autoconfigure.DataLoaderRegistryFactory;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataLoaderConfig {
    private final SystemDataLoader systemDataLoader;

    @Bean
    public DataLoaderRegistryFactory dataLoaderRegistryFactory() {
        return () -> {
            DataLoaderRegistry dataLoaderRegistry =  new DataLoaderRegistry();
            dataLoaderRegistry.register(SystemDataLoader.NAME, new DataLoader<>(systemDataLoader));
            return dataLoaderRegistry;
        };
    }
}
