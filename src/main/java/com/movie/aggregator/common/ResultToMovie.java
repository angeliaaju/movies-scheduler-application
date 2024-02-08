package com.movie.aggregator.common;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.movie.aggregator.domain.Movies;

import com.movie.aggregator.jsontopojo.Result;

/**
 * @author Angelia Aju Mathai
 */

@Component
public class ResultToMovie implements Converter<Result, Movies> {

    @Override
    public Movies convert(Result source) {
        Movies mov=null;
		try {
			mov = new Movies(source.getPosterPath(), source.getAdult(),
			                        source.getOverview(), source.getReleaseDate(),
			                        source.getId(), source.getOriginalTitle(),
			                        source.getOriginalLanguage(),
			                        source.getTitle(), source.getBackdropPath(),
			                        source.getPopularity(),source.getVoteCount(),
			                        source.getVideo(), source.getVoteAverage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return mov;
    }
}
