package com.movie.aggregator.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.movie.aggregator.domain.Movies;

import java.util.List;

/**
 * @author Angelia Aju Mathai
 */

public class MoviesItemWriter implements ItemWriter<Movies> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoviesItemWriter.class);

    private static int movieNo = 1;

    @Override
    public void write(List<? extends Movies> items) throws Exception {

        LOGGER.info("Writing Movies with size {}", items.size() );

        items.forEach(movie-> {
            LOGGER.info("{}. {} - Released on {}", movieNo, movie.getTitle(), movie.getReleaseDate());
            movieNo++;
        });
    }

}
