package com.movie.aggregator.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.movie.aggregator.domain.Movies;
import com.movie.aggregator.jsontopojo.Result;

/**
 * @author Angelia Aju Mathai
 */

public class MoviesItemProcessor implements ItemProcessor<Result, Movies> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoviesItemProcessor.class);

    @Autowired
    private ResultToMovie resultToMovie;

    private static int movieNo = 1;

    @Override
    public Movies process(Result result) throws Exception {

        //LOGGER.info("Converting Result to Movie. Number# {}",movieNo);
        movieNo++;

        Movies movies = resultToMovie.convert(result);
        return movies;

    }
}
