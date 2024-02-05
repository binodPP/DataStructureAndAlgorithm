package com.systemdesign.ratelimiting;

public class RateLimitConfig {
    private long maxRequestsPerSecond;
    private long refillTimeInMillis;
    private long lastRequestTime;

    public RateLimitConfig(long maxRequestsPerSecond, long refillTimeInMillis) {
        this.maxRequestsPerSecond = maxRequestsPerSecond;
        this.refillTimeInMillis = refillTimeInMillis;
        this.lastRequestTime = 0;
    }

    public void update(long maxRequestsPerSecond, long refillTimeInMillis){
        this.maxRequestsPerSecond = maxRequestsPerSecond;
        this.refillTimeInMillis = refillTimeInMillis;
    }

    public long getMaxRequestsPerSecond() {
        return maxRequestsPerSecond;
    }

    public void setMaxRequestsPerSecond(long maxRequestsPerSecond) {
        this.maxRequestsPerSecond = maxRequestsPerSecond;
    }

    public long getRefillTimeInMillis() {
        return refillTimeInMillis;
    }

    public void setRefillTimeInMillis(long refillTimeInMillis) {
        this.refillTimeInMillis = refillTimeInMillis;
    }

    public long getLastRequestTime() {
        return lastRequestTime;
    }

    public void setLastRequestTime(long lastRequestTime) {
        this.lastRequestTime = lastRequestTime;
    }
}
