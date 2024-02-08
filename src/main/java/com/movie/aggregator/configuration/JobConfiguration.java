package com.movie.aggregator.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.movie.aggregator.common.JobCompletionNotificationListener;
import com.movie.aggregator.common.MoviesItemProcessor;
import com.movie.aggregator.common.RestMovieReader;
import com.movie.aggregator.domain.Movies;
import com.movie.aggregator.jsontopojo.Result;
import com.movie.aggregator.repository.MovieRepository;

/**
 * @author Angelia Aju Mathai
 */

@Configuration
public class JobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MovieRepository movieRepository;

    @Bean
    ItemReader<Result> restMovieReader(Environment env, RestTemplate restTemplate) {
        return new RestMovieReader(env.getProperty("REST_API_URL_WITH_KEY"), restTemplate);
    }

    @Bean
    ItemProcessor<Result, Movies> moviesItemProcessor() {
        return new MoviesItemProcessor();
    }

    @Bean
    RepositoryItemWriter<Movies> movieRepositoryItemWriter(){

        RepositoryItemWriter<Movies> repositoryItemWriter = new RepositoryItemWriter<>();
        repositoryItemWriter.setRepository(movieRepository);
        repositoryItemWriter.setMethodName("save");
        return repositoryItemWriter;

    }

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionNotificationListener();
    }

    @Bean
    public Step step1(ItemReader<Result> restMovieReader,
                        ItemProcessor<Result, Movies> moviesItemProcessor,
                        RepositoryItemWriter<Movies> movieRepositoryItemWriter) throws Exception {
        return stepBuilderFactory.get("step1")
                .<Result, Movies>chunk(10)
                .reader(restMovieReader)
                .processor(moviesItemProcessor)
                .writer(movieRepositoryItemWriter)
                .build();
    }

    @Bean
    public Job job(Step step1) throws Exception {
        return jobBuilderFactory.get("job")
                .start(step1)
                .listener(listener())
                .build();
    }


}
