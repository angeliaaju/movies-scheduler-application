package com.movie.aggregator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie.aggregator.domain.Movie;
import com.movie.aggregator.domain.Movies;

/**
 * @author Angelia Aju Mathai
 */

@Repository
public interface MovieRepository extends CrudRepository<Movies, Long> {
}
