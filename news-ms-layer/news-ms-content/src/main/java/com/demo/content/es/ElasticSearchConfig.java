package com.demo.content.es;

import org.elasticsearch.client.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * ElasticSearch Config
 * @author Larry_lee
 *
 */
@Configuration
public class ElasticSearchConfig {
 
    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client) {
        return new ElasticsearchTemplate(client);
    }
 
}