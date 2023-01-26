package com.bookmyshow.controller;

import com.bookmyshow.BaseTest;
import com.bookmyshow.dto.TheatreDTO;
import com.bookmyshow.security.SecurityConfig;
import com.bookmyshow.service.TheatreService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
public class TheatreConrollerTest extends BaseTest {
    @Value(value = "${local.server.port}")
    private int port;
    @MockBean
    private TheatreService theatreService;

    @MockBean
    private SecurityConfig securityConfig;

    @MockBean
    UserDetailsService userDetailsService;
    @MockBean
    PasswordEncoder passwordEncoder;
    @MockBean
    SecurityFilterChain filterChain;
    @SpyBean
    private TheatreController theatreController;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void test() throws CloneNotSupportedException {
        String urlTemplate = BookingUtil.getBaseUrl("/api/v1/theatre/", port)
                .queryParam("movieName", "Veerayya")
                .queryParam("city", "Bangalore")
                .queryParam("date", "2023-01-15").toUriString();
        List<TheatreDTO> listDto = TheatreDataDTO.getTheatres();
        when(theatreService.getTheatres(any(), any(), any())).thenReturn(listDto);
        RequestEntity<List<TheatreDTO>> requestEntity =
                new RequestEntity<>(HttpMethod.GET, URI.create(urlTemplate));
        ResponseEntity<List<TheatreDTO>> listResponseEntity = testRestTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<List<TheatreDTO>>() {
                });

        int actual = listResponseEntity.getBody().size();
        Assertions.assertTrue(listResponseEntity.getStatusCode().is2xxSuccessful());
        verify(theatreService, times(1)).getTheatres(any(), any(), any());
        Assertions.assertEquals(2, actual);
    }

    @Test
    public void addTheatre() throws CloneNotSupportedException {

        String urlTemplate = BookingUtil.getBaseUrl("/api/v1/theatre/create", port).toUriString();
        TheatreDTO theatreDTO = TheatreDataDTO.getTheatres().get(0);
        doNothing().when(theatreService).addOrUpdateTheatre(any());
        when(theatreController.addTheatre(any())).thenReturn(new ResponseEntity<>("Successfully Added", HttpStatus.CREATED));
        RequestEntity<TheatreDTO> requestEntity =
                new RequestEntity<>(theatreDTO, HttpMethod.POST, URI.create(urlTemplate));
        ResponseEntity<String> response = testRestTemplate.exchange(requestEntity, String.class);

        String actual = response.getBody();
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(theatreService, times(0)).addOrUpdateTheatre(any());
        Assertions.assertEquals("Successfully Added", actual);
    }

}
