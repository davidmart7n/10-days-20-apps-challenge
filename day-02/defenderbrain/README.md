# 🧠 Defender Brain

The decision-making engine of the security ecosystem. This Spring Boot microservice receives log data from distributed scanners and determines the threat level of each request based on a centralized rule engine.

## ✨ Features

* **Centralized Security Logic:** Decouples log parsing from decision making.
* **Data Validation:** Uses Jakarta Validation to ensure data integrity (Regex for IPs, HTTP range for status codes).
* **IP Blacklisting:** Instant detection of known malicious actors.
* **Heuristic Analysis:** Detects automated attack tools (e.g., SqlMap) by inspecting User-Agents.
* **Scalable API:** Built with a RESTful approach to handle requests from multiple `nio-async-defender` instances.

## 📡 API Reference

### Analyze Log Entry
Determines if a specific log entry represents a threat.

* **URL:** `/api/security-analyze`
* **Method:** `POST`
* **Payload (JSON):**
    ```json
    {
      "ip": "185.220.101.12",
      "path": "/admin/login",
      "agent": "Mozilla/5.0...",
      "statusCode": 200
    }
    ```
* **Response:** `BLOCK` | `OK`
* **Validation Rules:** * `ip`: Must follow a valid IPv4 format.
    * `statusCode`: Must be between 100 and 599.
    * All fields are mandatory.



## 🛠️ Tech Stack

* **Java 17/21**
* **Spring Boot 3.x (Spring Web & Validation)**
* **Maven**

## 🏗️ Core Components

* **`AnalyzerController`**: The entry point that evaluates incoming `LogEntryDTO` objects against current security policies.
* **`LogEntryDTO`**: A Java Record with Jakarta constraints for high-speed, validated data transfer.

## 🚀 Getting Started

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/davidmart7n/defender-brain.git](https://github.com/davidmart7n/defender-brain.git)
    cd defender-brain
    ```

2.  **Build the project:**
    ```bash
    mvn clean install
    ```

3.  **Run the application:**
    * Open the project in your IDE.
    * Locate `DefenderBrainApplication.java`.
    * **Run the class** to start the server on `http://localhost:8084`.

4.  **Testing the service:**
    You can manually test the engine using cURL:
    ```bash
    curl -X POST http://localhost:8084/api/security-analyze \
    -H "Content-Type: application/json" \
    -d '{"ip":"91.241.19.84", "path":"/", "agent":"SqlMap", "statusCode":200}'
    ```
