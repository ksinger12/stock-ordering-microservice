package com.trading.trader;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AlphaVantageConfig {
    @Autowired
    private Environment env;

    @Bean
    public AlphaVantage alphaVantage() {
        Config cfg = Config.builder()
                .key(env.getProperty("alphavantage.api.key"))
                .timeOut(10)
                .build();

        AlphaVantage.api().init(cfg);
        return AlphaVantage.api();
    }

}
