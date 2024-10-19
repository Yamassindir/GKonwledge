package fr.graphs.GKnowledge.model;

import org.springframework.data.mongodb.core.mapping.Field;

public record KeyValuePair(
    @Field("key") String key,
    @Field("value") String value
) {}