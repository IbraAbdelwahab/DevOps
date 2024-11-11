package com.moviehouse.movieservice.services;

import com.moviehouse.movieservice.exception.BadCredentialsException;
import com.moviehouse.movieservice.models.Movie;
import com.moviehouse.movieservice.repos.MovieRepository;
import io.jsonwebtoken.MalformedJwtException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.test.web.servlet.MockMvc;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class MovieServiceTest {
    @Mock
    private MovieRepository movieRepository;
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
            private MovieService movieService;


    Movie movie1 = new Movie(1, "Title1", "Language1", "Overview1", "2024-01-01", "BackdropPath1",
            100, 7.5f, true, "MovieTitle1", "PosterPath1", 80, false, new long[]{1, 2, 3});
    Movie movie2 = new Movie(2, "Title2", "Language2", "Overview2", "2024-02-01", "BackdropPath2",
            150, 8.0f, false, "MovieTitle2", "PosterPath2", 90, true, new long[]{4, 5, 6});
    Movie[] movies1 = {movie1,movie2};
    List<Movie> movies = new ArrayList<>();
    Page<Movie> pagedResponse = new PageImpl(movies);

    Optional<Movie> opMovie = Optional.ofNullable(movie1);

    Pageable pageable = PageRequest.of(1,5, Sort.by("popularity").descending());



    @Test
    void fetchPopular() {
       Mockito.when(movieRepository.findAll(pageable)).thenReturn(pagedResponse);

       Page<Movie> x = movieRepository.findAll(pageable);

       Assertions.assertEquals(pagedResponse,x);

    }

    @Test
    void fetchMovie() {
        Mockito.when(movieRepository.findById(1L)).thenReturn(opMovie);

        Optional<Movie> x = movieRepository.findById(1L);

        Assertions.assertEquals(opMovie,x);


    }
    @Test
    void tokenValid_Fail() throws BadCredentialsException {
        String x = "invalid";
        Exception e = new MalformedJwtException("invalid");
        Exception exception = assertThrows(MalformedJwtException.class, () -> {
            movieService.tokenIsValid(x);
        });
    }
    @Test
    void tokenValid_Success() throws BadCredentialsException{
        String x = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb29uZXlAZ21haWwuY29tIiwiZXhwIjoxOTIyOTc4ODQ0fQ.A2fF5Jsgcn0Qr5mHeKtBm_IwNnEp4-xKlsMsnF7KeUo";
        assertTrue(movieService.tokenIsValid(x));
    }

    @Test
    void genKey() {

        Assertions.assertInstanceOf(SecretKey.class,movieService.genKey());

    }
}