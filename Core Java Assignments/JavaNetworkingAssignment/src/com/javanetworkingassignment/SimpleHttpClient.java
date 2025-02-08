package com.javanetworkingassignment;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class SimpleHttpClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://www.example.com"; // Replace with the URL you want to connect to

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET() // Or .POST(), .PUT(), .DELETE(), etc. as needed
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code: " + response.statusCode());

        // Print headers (optional, but good practice)
        System.out.println("\nHeaders:");
        response.headers().map().forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\nBody:");
        System.out.println(response.body());
    }
}
