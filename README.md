# QR Code Generator

The QR Code Generator project is a Spring Boot application designed to create QR codes dynamically based on user input. It serves as a practical exercise in learning web development with Spring Boot, handling HTTP requests, and processing images in Java.

## Project Overview:
The QR Code Generator application allows users to generate QR codes by sending HTTP requests with the desired data and parameters.

Users can:
- Generate QR codes from input text.
- Specify various parameters such as size and format.
- Retrieve QR codes in different file formats.

## Key Features:
- **Spring Boot Framework**: The project leverages the Spring Boot framework to handle web requests and responses.
- **QR Code Generation**: Uses the ZXing library to generate QR codes.
- **Parameter Handling**: Accepts HTTP request parameters to customize the QR code output.
- **HTTP Responses**: Understands and uses HTTP status codes and content types to serve files appropriately.

## Technologies Used:
- **Java**: The core programming language used for implementing the application logic.
- **Spring Boot**: A framework for building web applications and handling HTTP requests.
- **ZXing Library**: A library for generating QR codes.
- **Maven**: For dependency management and building the project.

## How to Run:
To run the QR Code Generator application locally:

1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE (such as IntelliJ IDEA or Eclipse).
3. Build and run the project using Maven or your IDE's tools.

### Access the application:
- Use a tool like `curl` or a web browser to send HTTP requests to the application.
- Example: `http://localhost:8080/qrcode?contents=HelloWorld&size=300&type=png&correction=l`
- The application will respond with the generated QR code image.

## Endpoints:
- **Endpoint**: `/qrcode`
- **Parameters**:
  - `contents`: The text to encode in the QR code.
  - `size` (optional) : The size of the QR code (e.g., `300x300`).
  - `type` (optional) : The format of the output file (e.g., `png`, `jpg`).
  - `correction` (optional) : The error correction level of the QR code. Acceptable values are `L` (low), `M` (medium), `Q` (quartile), and `H` (high). The default value is `L`. Higher error correction levels allow the QR code to be readable even if it is partially damaged or obscured, but they reduce the amount of data that can be stored.
- **Endpoint**: `/health`

## Sample Requests:
```bash
GET http://localhost:8080/qrcode?contents=HelloWorld&size=300&type=png&correction=l
GET http://localhost:8080/health
