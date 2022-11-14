package com.example.dynamotest.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.example.dynamotest.repository")
public class DynamoDBConfiguration {

    @Value("${cloud.aws.dynamodb.endpoint}")
    private String dynamodbEndpoint;

    @Value("${cloud.aws.region}")
    private String awsRegion;

    @Value("${cloud.aws.credentials.access-key}")
    private String dynamodbAccessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String dynamodbSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamodbEndpoint,awsRegion))
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(dynamodbAccessKey,dynamodbSecretKey)))
                .build();
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
                dynamodbAccessKey, dynamodbSecretKey);
    }
}
