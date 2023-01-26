package com.bookmyshow.controller;

import com.bookmyshow.BaseTest;
import com.bookmyshow.dto.OfferDTO;
import com.bookmyshow.dto.TheatreDTO;
import com.bookmyshow.security.SecurityConfig;
import com.bookmyshow.service.OfferService;
import com.bookmyshow.util.BookingUtil;
import com.bookmyshow.util.TheatreDataDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ActiveProfiles;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
public class OfferControllerTest extends BaseTest {
    @Value(value = "${local.server.port}")
    private int port;

    @MockBean
    private OfferService offerService;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private SecurityConfig securityConfig;

    @MockBean
    UserDetailsService userDetailsService;

    @MockBean
    PasswordEncoder passwordEncoder;
    @MockBean
    SecurityFilterChain filterChain;

    @SpyBean
    private OfferController offerController;

    @Test
    public void testGetOffers() {
        String urlTemplate = BookingUtil.getBaseUrl("/api/v1/platforOffers", port)
                .queryParam("city", "Bangalore")
                .queryParam("theatreName", "PVR").toUriString();

        List<OfferDTO> response = TheatreDataDTO.getOffers().stream()
                .filter(offer -> "Bangalore".equalsIgnoreCase(offer.getCity()))
                .toList();
        when(offerService.getOffers(any(), any())).thenReturn(response);
        verify(offerController, times(0)).getOffers(any(), any());
        RequestEntity<List<OfferDTO>> requestEntity = new RequestEntity<>(HttpMethod.GET, URI.create(urlTemplate));
        ResponseEntity<List<OfferDTO>> actualResponse = testRestTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<List<OfferDTO>>() {
                });
        assertTrue(actualResponse.getStatusCode().is2xxSuccessful());
        assertEquals(1, actualResponse.getBody().size());
        assertEquals("Bangalore", actualResponse.getBody().get(0).getCity());

    }
    @Test
    public void addOffer() throws CloneNotSupportedException {

        String urlTemplate = BookingUtil.getBaseUrl("/api/v1/platforOffers/add", port).toUriString();
        List<OfferDTO> offerDTO = TheatreDataDTO.getOffers();
        doNothing().when(offerService).addOffers(any());
        when(offerController.addOffers(any())).thenReturn(new ResponseEntity<>("Successfully Added", HttpStatus.CREATED));
        RequestEntity<List<OfferDTO>> requestEntity =
                new RequestEntity<>(offerDTO, HttpMethod.POST, URI.create(urlTemplate));
        ResponseEntity<String> response = testRestTemplate.exchange(requestEntity, String.class);

        String actual = response.getBody();
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(offerService, times(1)).addOffers(any());
        Assertions.assertEquals("Successfully Added", actual);
    }

}
