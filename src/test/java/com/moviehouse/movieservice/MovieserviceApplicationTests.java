package com.moviehouse.movieservice;

import com.moviehouse.movieservice.controllers.MovieController;
import com.moviehouse.movieservice.models.Movie;
import com.moviehouse.movieservice.exception.BadCredentialsException;
import com.moviehouse.movieservice.services.MovieService;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@SpringBootTest
public class MovieserviceApplicationTests {





	Movie movie1 = new Movie(1, "Title1", "Language1", "Overview1", "2024-01-01", "BackdropPath1",
			100, 7.5f, true, "MovieTitle1", "PosterPath1", 80, false, new long[]{1, 2, 3});

	Movie movie2 = new Movie(2, "Title2", "Language2", "Overview2", "2024-02-01", "BackdropPath2",
			150, 8.0f, false, "MovieTitle2", "PosterPath2", 90, true, new long[]{4, 5, 6});

	Movie movie3 = new Movie(3, "Title3", "Language3", "Overview3", "2024-03-01", "BackdropPath3",
			120, 7.8f, true, "MovieTitle3", "PosterPath3", 85, false, new long[]{7, 8, 9});


}
