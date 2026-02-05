package io.github.davidmart7n.defender.model;

import java.time.Instant;

public record LogEntry (
    String id, 
    Instant timestamp, 
    String ipAdress, 
    String method, 
    String path,    
    int statusCode,
    String userAgent,   
    String rawLine  
) {}