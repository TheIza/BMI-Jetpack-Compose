

# BMI Jetpack Compose

Aplicación Android desarrollada con **Kotlin** y **Jetpack Compose** para calcular el **índice de masa corporal (BMI)** a partir del peso y la altura del usuario.

## Imagen
<img width="385" height="768" alt="image" src="https://github.com/user-attachments/assets/080beae6-f9da-43c4-8eec-86f95b68f6de" />

## Características

- Introducción del nombre del usuario.
- Selección del peso mediante botones `+` y `-`.
- Selección de la altura mediante un `Slider`.
- Cálculo automático del BMI.
- Resultado mostrado con dos decimales.
- Interfaz diseñada completamente con **Jetpack Compose**.
- Diseño oscuro con detalles en azul/cian.

## Tecnologías utilizadas

- **Kotlin**
- **Android Studio**
- **Jetpack Compose**
- **Material 3**

## Funcionamiento

Para calcular el BMI se utiliza la siguiente fórmula:

```text
BMI = peso / altura²
```

La altura introducida en centímetros se convierte primero a metros antes de realizar el cálculo.

Por ejemplo:

```text
Peso: 70 kg
Altura: 1.75 m

BMI = 70 / (1.75 × 1.75)
BMI = 22.86
```

## Interfaz

La aplicación cuenta con:

- Campo para introducir el nombre.
- Controles para modificar el peso.
- Slider para seleccionar la altura.
- Botón para realizar el cálculo.
- Resultado final del BMI.

## Estructura principal

El proyecto está organizado como una aplicación Android utilizando Jetpack Compose. La pantalla principal contiene la lógica de la interfaz y el cálculo del BMI.

```text
BMIJetPackCompose
│
├── app
│   └── src
│       └── main
│           └── java
│               └── org.insbaixcamp.bmijetpackcompose
│                   └── MainActivity.kt
│
├── gradle
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

## Instalación

1. Clonar el repositorio:

```bash
git clone https://github.com/TheIza/BMI-Jetpack-Compose.git
```

2. Abrir el proyecto con **Android Studio**.

3. Esperar a que Gradle termine de sincronizar el proyecto.

4. Ejecutar la aplicación en un emulador o dispositivo Android.

## Objetivo

Este proyecto forma parte del aprendizaje de desarrollo de aplicaciones Android con **Kotlin y Jetpack Compose**, practicando conceptos como:

- Estados en Compose.
- `TextField`.
- `Button`.
- `Slider`.
- `Text`.
- Composables.
- Gestión de variables mediante `remember`.
- Cálculos dentro de una interfaz Android.

## Autor

**TheIza**

Repositorio: https://github.com/TheIza/BMI-Jetpack-Compose
