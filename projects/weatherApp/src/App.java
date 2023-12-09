import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

// https://www.visualcrossing.com/account
public class App {
    private static final String API_KEY = "";
    private static final String CITY_NAME = "Örnsköldsvik";

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) {
        try {
            String encodedCityName = URLEncoder.encode(CITY_NAME, StandardCharsets.UTF_8);
            String encodedApiKey = URLEncoder.encode(API_KEY, StandardCharsets.UTF_8);

            String apiUrl = String.format(
                    "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s?unitGroup=metric&key=%s&contentType=json",
                    encodedCityName, encodedApiKey);

            String jsonResponse = getWeatherData(apiUrl);
            if (jsonResponse != null) {
                parseAndDisplayWeather(jsonResponse);
            } else {
                System.out.println("Failed to fetch weather data.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getWeatherData(String apiUrl) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    private static void parseAndDisplayWeather(String jsonResponse) {
        JSONObject json = new JSONObject(jsonResponse);

        String cityName = json.optString("address", "N/A");
        JSONObject currentConditions = json.optJSONObject("currentConditions");

        if (currentConditions != null) {
            double temperature = currentConditions.optDouble("temp", Double.NaN);
            double humidity = currentConditions.optDouble("humidity", Double.NaN);
            double precipProb = currentConditions.optDouble("precipprob", Double.NaN);
            double windSpeed = currentConditions.optDouble("windspeed", Double.NaN);
            String conditions = currentConditions.optString("conditions", "N/A");

            System.out.println("Weather in " + cityName);
            System.out.println("Temperature: " + temperature + " °C");
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Precipitation Probability: " + precipProb + "%");
            System.out.println("Wind Speed: " + windSpeed + " m/s");
            System.out.println("Conditions: " + conditions);
        } else {
            System.out.println("Failed to fetch current weather data.");
        }
    }
}
