# 🚀 CryptoPortfolio API

Una API REST profesional para la gestión de activos de criptomonedas, desarrollada íntegramente en un sprint de **75 minutos a full código**.

## ⏱️ Challenge Mode: On
Este proyecto es el resultado de un reto de desarrollo ultra-rápido, construido bajo presión manteniendo una arquitectura limpia y escalable.
* **Desarrollo Relámpago:** De la idea al despliegue en solo 75 minutos.
* **Clean Architecture:** Separación clara de responsabilidades (Controller, Service, Repository).
* **Domain Safety:** Implementación de **DTOs** para evitar la exposición de entidades.

---

## 🛠️ Stack Tecnológico
* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA**: Persistencia de datos eficiente.
* **H2 Database**: Base de datos en memoria (volátil) para desarrollo rápido.
* **Lombok**: Uso de `@Builder`, `records` y `@Service` para minimizar código repetitivo.
* **Jakarta Validation**: Asegurando la integridad de las entradas.

---

## 🏗️ Estructura del Proyecto
El flujo de datos sigue el estándar de industria para aplicaciones Spring Boot:
`Web/Controller` → `Service` → `Mapper` → `Repository` → `Entity (H2 DB)`



---

## 🚀 Instalación y Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone <url-del-repo>