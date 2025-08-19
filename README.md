# 💱 Conversor de Monedas - Alura Challenge

![Java](https://img.shields.io/badge/Java-11+-orange.svg)
![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)
![Status](https://img.shields.io/badge/Status-Completo-green.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

## 📋 Índice

- [Descripción del Proyecto](#-descripción-del-proyecto)
- [Estado del Proyecto](#-estado-del-proyecto)
- [Funcionalidades](#-funcionalidades)
- [Demostración](#-demostración)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Instalación y Uso](#-instalación-y-uso)

## 📖 Descripción del Proyecto

Este proyecto es un **Conversor de Monedas** desarrollado en Java como parte del Challenge ONE - Oracle Next Education en colaboración con Alura. La aplicación consume la API de ExchangeRate-API para obtener tasas de cambio actualizadas en tiempo real y permite a los usuarios convertir entre diferentes monedas latinoamericanas.

## 🚀 Estado del Proyecto

✅ **PROYECTO COMPLETADO** - Todas las funcionalidades implementadas y funcionando correctamente.

## ⚡ Funcionalidades

- ✅ Conversión en tiempo real entre 6 monedas diferentes
- ✅ Interfaz de consola intuitiva con menú de opciones
- ✅ Historial de conversiones con marca de tiempo
- ✅ Manejo de errores y validación de entrada
- ✅ Consumo de API REST con HttpClient
- ✅ Parseo de JSON con Gson
- ✅ Configuración segura de API Key

### 💰 Monedas Soportadas

- **USD** - Dólar estadounidense
- **ARS** - Peso argentino  
- **BRL** - Real brasileño
- **COP** - Peso colombiano
- **CLP** - Peso chileno
- **BOB** - Boliviano boliviano

## 🎥 Demostración

### Menú Principal

```txt
**************************************************
Sea bienvenido/a al Conversor de Moneda =]

1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileño
4) Real brasileño =>> Dólar
5) Dólar =>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Ver historial de conversiones
8) Salir
Elija una opción válida:
**************************************************
```

### Ejemplo de Conversión

```txt
Ingresa el valor que deseas convertir de Dólar estadounidense a Peso argentino: 25
Consultando tasas de cambio...

El valor de 25.00 [Dólar estadounidense] corresponde al valor final de =>>> 32472.50 [Peso argentino]
```

### Historial de Conversiones

```txt
--- HISTORIAL DE CONVERSIONES ---
1. 25.00 USD = 32472.50 ARS (Tasa: 1298.9000) [19/08/2025 10:30:15]
2. 250.00 BRL = 46.25 USD (Tasa: 0.1850) [19/08/2025 10:32:22]
--- FIN DEL HISTORIAL ---
```

## 🛠 Tecnologías Utilizadas

- **Java 11+** - Lenguaje de programación principal
- **Maven** - Gestión de dependencias y construcción del proyecto
- **Gson 2.10.1** - Serialización/deserialización de JSON
- **HttpClient** - Cliente HTTP nativo de Java para consumo de API
- **ExchangeRate-API** - API REST para obtener tasas de cambio actualizadas

## 💻 Instalación y Uso

### Prerrequisitos

- Java JDK 11 o superior
- Maven 3.6 o superior
- Conexión a Internet

### Pasos de Instalación

1. **Clonar el repositorio**

   ```bash
   git clone https://github.com/tu-usuario/alura-moneyexchange.git
   cd alura-moneyexchange
   ```

2. **Compilar el proyecto**

   ```bash
   mvn clean compile
   ```

3. **Ejecutar la aplicación**

   ```bash
   mvn exec:java -Dexec.mainClass="com.alura.moneyexchange.Main"
   ```

   O alternativamente:

   ```bash
   mvn clean package
   java -jar target/moneyexchange-1.0.0.jar
   ```

### Como Usar la Aplicación

1. **Seleccionar una opción** del menú (1-8)
2. **Ingresar la cantidad** que desea convertir
3. **Ver el resultado** de la conversión
4. **Consultar el historial** con la opción 7
5. **Salir** con la opción 8

## 📁 Estructura del Proyecto

```bash
src/
├── main/
│   ├── java/com/alura/moneyexchange/
│   │   ├── Main.java                   # Clase principal
│   │   ├── Conversor.java              # Interfaz de usuario y menú
│   │   ├── CurrencyConverter.java      # Lógica de conversión
│   │   ├── ExchangeRateApiClient.java  # Cliente API
│   │   ├── ExchangeRateResponse.java   # Modelo de respuesta API
│   │   ├── ConversionResult.java       # Modelo de resultado
│   │   └── Currency.java               # Enum de monedas
│   └── resources/
│       └── config.properties           # Configuración (API Key)
├── pom.xml                             # Configuración Maven
├── .gitignore                          # Archivos ignorados por Git
└── README.md                           # Documentación del proyecto
```

> Desarrollado como parte del **Challenge ONE - Oracle Next Education** en colaboración con **Alura**.