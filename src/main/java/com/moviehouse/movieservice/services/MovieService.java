package com.moviehouse.movieservice.services;

import com.moviehouse.movieservice.exception.BadCredentialsException;
import com.moviehouse.movieservice.models.Movie;
import com.moviehouse.movieservice.repos.MovieRepository;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Optional;

@Service
public class MovieService {

    public final MovieRepository movieRepository;

    private final String secret_key = "bXlzZWNyZXRrZXlteXNlY3JldGtleW15c2VjcmV0a2V5bXlzZWNyZXRrZXk=";

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

   public Page<Movie> fetchPopular(int page){


        Pageable pageable = PageRequest.of(page,5,Sort.by("popularity").descending());
        Page<Movie> list = movieRepository.findAll(pageable);

        return list;

   }

   public Optional<Movie> fetchMovie(long id){
        return movieRepository.findById(id);
   }

//   public void pushMovies(Movie[] movies){
//       for (Movie movie : movies) {
//           movieRepository.save(movie);
//       }
//   }


   public boolean tokenIsValid(String token)  {

      Jwts.parser().verifyWith(genKey()).build().parseSignedClaims(token);

      return true;

   }

    public SecretKey genKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secret_key);
        return Keys.hmacShaKeyFor(keyBytes);
    }



}
