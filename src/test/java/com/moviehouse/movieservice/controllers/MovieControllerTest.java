package com.moviehouse.movieservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviehouse.movieservice.models.Movie;
import com.moviehouse.movieservice.services.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MovieController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MovieService movieService;

    @Autowired
    private ObjectMapper objectMapper;





    Movie movie1 = new Movie(1, "Title1", "Language1", "Overview1", "2024-01-01", "BackdropPath1",
            100, 7.5f, true, "MovieTitle1", "PosterPath1", 80, false, new long[]{1, 2, 3});
    Movie movie2 = new Movie(2, "Title2", "Language2", "Overview2", "2024-02-01", "BackdropPath2",
            150, 8.0f, false, "MovieTitle2", "PosterPath2", 90, true, new long[]{4, 5, 6});
    Movie[] movies1 = {movie1,movie2};
    List<Movie> movies = new ArrayList<>();
    Page<Movie> pagedResponse = new PageImpl(movies);
    @Test
    void getPopular() throws Exception {
        Mockito.when(movieService.fetchPopular(1)).thenReturn(pagedResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/popular/1").header("Authorization","valid").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getMovie() throws Exception {
        Mockito.when(movieService.fetchMovie(1)).thenReturn(Optional.ofNullable(movie1));

       mockMvc.perform(MockMvcRequestBuilders.get("/api/1").header("Authorization","valid").contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }


}