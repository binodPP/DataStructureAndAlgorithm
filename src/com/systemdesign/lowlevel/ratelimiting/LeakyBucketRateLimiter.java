package com.systemdesign.lowlevel.ratelimiting;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

//Custom implementation of rate limiting using leaky bucket
public class LeakyBucketRateLimiter {
    private static final Logger LOGGER= Logger.getLogger(LeakyBucketRateLimiter.class.getName());
    private final Map<String,RateLimitConfig> configMap;
    private long expirationTimeInMillis;

    public LeakyBucketRateLimiter(long expirationTimeInMillis) {
        this.expirationTimeInMillis = expirationTimeInMillis;
        this.configMap = new HashMap<>();
    }
    // Add client with initial configuration
    public void addClient(String clientId, long maxRequestsPerSecond, long refillTimeInMillis){
        if(configMap.containsKey(clientId)){
            throw new IllegalArgumentException("Client Id Already Available: " + clientId);
        }
        configMap.put(clientId, new RateLimitConfig(maxRequestsPerSecond,refillTimeInMillis));
    }

    // Update client configuration dynamically
    public void updateClientConfig(String clientId, long maxRequestsPerSecond, long refillTimeInMillis){
        if (configMap.containsKey(clientId)){
            configMap.get(clientId).update(maxRequestsPerSecond,refillTimeInMillis);
        }else {
            throw new IllegalArgumentException("Client not found: " + clientId);
        }
    }

    public boolean allowRequest(String clientId) throws Exception {
        cleanExpiredEntries();
        RateLimitConfig rateLimitConfig = configMap.getOrDefault(clientId, getDefaultRateLimit());
        long lastRequestTime = getLastRequestTime(clientId);
        if(lastRequestTime == 0 || System.currentTimeMillis() -
                        lastRequestTime >= rateLimitConfig.getRefillTimeInMillis()){
            updateLastRequestTime(clientId);
            return true;
        }else {
            long remainingTime = configMap.get(clientId).getRefillTimeInMillis()-System.currentTimeMillis()-lastRequestTime;
            if(isSuspiciousClient(clientId)){
                remainingTime = adjustRemainingTime(clientId,remainingTime);
                throw new Exception("Rate limit exceeded for client " + clientId + ". Try again in " + remainingTime + " milliseconds.");
            }
        }
        return false;
    }

    private void cleanExpiredEntries(){
        long currentTime = System.currentTimeMillis();
        configMap.entrySet().removeIf(entry -> {
            long lastRequestTime = entry.getValue().getLastRequestTime();
            return lastRequestTime != 0 && currentTime - lastRequestTime >= expirationTimeInMillis;
        });
    }

    private Long getLastRequestTime(String clientId){
        return configMap.getOrDefault(clientId, getDefaultRateLimit()).getLastRequestTime();
    }

    private RateLimitConfig getDefaultRateLimit(){
        //Default to 1 request per second with 1-second refill
        return new RateLimitConfig(1,1000);
    }

    private void updateLastRequestTime(String clientId){
        configMap.get(clientId).setLastRequestTime(System.currentTimeMillis());
    }

    // Implement logic for dynamic rate adjustments based on client behavior or risk assessment (e.g., increase/decrease limits, temporary bans)
    private long adjustRemainingTime(String clientId, long remainingTime) {
        // Example: Reduce remaining time for suspicious clients by 50%
        if (isSuspiciousClient(clientId)) {
            remainingTime /= 2;
            LOGGER.warning("Reduced 50 % rate limit for suspicious client " + clientId +", and now remaining time is : " + remainingTime);
        }
        return remainingTime;
    }

    // Placeholder method for checking if a client is suspicious (implement your logic here)
    private boolean isSuspiciousClient(String clientId) {
        return false;
    }

    // Log rate limit events and monitor for potential abuse or attacks
    private void logRateLimitEvent(String clientId, boolean allowed) {
        LOGGER.info("Rate limit for client " + clientId + ": allowed=" + allowed);
        // Consider sending logs to a centralized monitoring system
    }


   /* public static void main(String[] args) throws InterruptedException {
        // Expire entries after 5 seconds
        LeakyBucketRateLimiter rateLimiter = new LeakyBucketRateLimiter(5000);

        // Add clients with different configurations
        // 5 requests per second, refill every second
        rateLimiter.addClient("client1", 5, 1000);
        // 2 requests per second, refill every 2 seconds
        rateLimiter.addClient("client2", 2, 2000);

        // Test successful requests within rate limits
        System.out.println("Testing allowed requests:");
        for (int i = 0; i < 3; i++) {
            try {
                rateLimiter.allowRequest("client1");
                System.out.println("Request allowed for client1");
            } catch (Exception e) {
                System.out.println("Request denied for client1: " + e.getMessage());
            }
            try {
                rateLimiter.allowRequest("client2");
                System.out.println("Request allowed for client2");
            } catch (Exception e) {
                System.out.println("Request denied for client2: " + e.getMessage());
            }
            //Wait 500 milliseconds between requests
            Thread.sleep(500);
        }

        // Test rate limit violations
        System.out.println("\nTesting rate limit violations:");
        for (int i = 0; i < 5; i++) {
            try {
                rateLimiter.allowRequest("client1");
                System.out.println("Request allowed for client1");
            } catch (Exception e) {
                System.out.println("Request denied for client1: " + e.getMessage());
            }
        }

        // Test expiration of entries
        System.out.println("\nTesting entry expiration:");
        Thread.sleep(6000);  // Wait 6 seconds for entries to expire
        try {
            rateLimiter.allowRequest("client1");
            System.out.println("Request allowed for client1 (after expiration)");
        } catch (Exception e) {
            System.out.println("Request denied for client1 (after expiration): " + e.getMessage());
        }
    }*/

    public static void main(String[] args) {
        // Create a rate limiter with an expiration time of 1 minute
        LeakyBucketRateLimiter rateLimiter = new LeakyBucketRateLimiter(60000);

        // Add clients with initial configurations
        rateLimiter.addClient("client1", 5, 1000); // 5 requests per second with a refill time of 1 second
        rateLimiter.addClient("client2", 10, 500); // 10 requests per second with a refill time of 500 milliseconds

        // Test allowing requests for client1
        try {
            for (int i = 0; i < 10; i++) {
                boolean allowed = rateLimiter.allowRequest("client1");
                System.out.println("Request " + (i + 1) + " for client1 allowed: " + allowed);
                if (!allowed) {
                    // Additional action if request is not allowed (e.g., notify user, log)
                    System.out.println("Rate limit exceeded for client1");
                }
                Thread.sleep(50); // Simulate some delay between requests
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test allowing requests for client2
        try {
            for (int i = 0; i < 15; i++) {
                boolean allowed = rateLimiter.allowRequest("client2");
                System.out.println("Request " + (i + 1) + " for client2 allowed: " + allowed);
                if (!allowed) {
                    // Additional action if request is not allowed (e.g., notify user, log)
                    System.out.println("Rate limit exceeded for client2");
                }
                Thread.sleep(100); // Simulate some delay between requests
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
