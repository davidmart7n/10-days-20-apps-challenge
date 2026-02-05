package io.github.davidmart7n.defender.model;

import java.time.Instant;
import java.util.List;

public record ThreatReport(
    Instant createdAt,
    List<LogEntry> dangerousLogs
) {}
