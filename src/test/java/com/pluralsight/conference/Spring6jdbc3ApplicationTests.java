package com.pluralsight.conference;

import com.pluralsight.conference.model.Speaker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class Spring6jdbc3ApplicationTests {

    @Test
    public void testCreateSpeaker() {
        RestTemplate restTemplate = new RestTemplate();
        Speaker speaker = new Speaker();
        speaker.setName("Shraddha Keni");
        restTemplate.put("http://localhost:8080/", speaker);
    }

    @Test
    void testGetSpeakers() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Speaker>> speakersResponse = restTemplate.exchange(
                "http://localhost:8080/", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Speaker>>() {
                });

        assertTrue(speakersResponse.getBody() != null, "Body is null");

        List<Speaker> speakers = speakersResponse.getBody();

        for (Speaker speaker : speakers) {
            System.out.println("Speaker name: " + speaker.getName());
        }
    }

    @Test
    public void testGetSpeaker() {
        RestTemplate restTemplate = new RestTemplate();
        Speaker speaker = restTemplate.getForObject("http://localhost:8080/speaker/{id}", Speaker.class, 1);
        speaker.setName("Prathamesh D Keni");
        restTemplate.put("http://localhost:8080/speaker", speaker);
        System.out.println("Name: " + speaker.getName());
    }
}
