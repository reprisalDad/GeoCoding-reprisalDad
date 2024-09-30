package com.robomech.geocoding.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.robomech.geocoding.model.Response;
import com.robomech.geocoding.model.ResponseWeather;

@RestController
public class Geocoder {

    private static final Object API_KEY ="your API key";
    
        @GetMapping("/getLocation")
        public Response getGeoDetails(@RequestParam(name = "address", required = false) String address){
            if (address == null) {
                address = "Vikram Nagar Lucknow";  // Set default address
            }
            UriComponents uri=UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("maps.googleapis.com")
            .path("/maps/api/geocode/json")
            .queryParam("key", API_KEY)
            .queryParam("address",address)
            .build();
            System.out.println(uri.toUriString());
            ResponseEntity<Response> response = new RestTemplate().getForEntity(uri.toUriString()

        , Response.class);
        return response.getBody();
    }
    @GetMapping("/getWeather")
    public ResponseWeather getWeather(@RequestParam String address)
    {
        UriComponents uri=UriComponentsBuilder.newInstance()
        .scheme("https")
        .host("maps.googleapis.com")
        .path("/maps/api/geocode/json")
        .queryParam("key", API_KEY)
        .queryParam("address",address)
        .build();

        ResponseEntity<Response> response = new RestTemplate().getForEntity(uri.toUriString()

        , Response.class);

        Response coordinates=response.getBody();
        double lat=coordinates.getResult()[0].getGeometry().getLocation().getLat();
        double lon=coordinates.getResult()[0].getGeometry().getLocation().getLng();

        ResponseEntity<ResponseWeather> weather=new RestTemplate().getForEntity("http://localhost:8080/getWeather/lat="+lat+"&lon="+lon, ResponseWeather.class);

        return weather.getBody();

    }
}

