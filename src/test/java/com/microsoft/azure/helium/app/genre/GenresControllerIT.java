package com.microsoft.azure.helium.app.genre;

import static com.microsoft.azure.helium.app.genre.GenresUtils.getGenresTestCases;
import static org.junit.Assert.assertNotNull;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.microsoft.azure.helium.Application;

import com.microsoft.azure.helium.app.movie.Movie;
import com.microsoft.azure.helium.app.movie.MoviesUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GenresControllerIT
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class GenresControllerIT {

    @Autowired
    private GenresController controller;

    @Autowired
    private GenresRepository repository;



    @Test
    public void genresEndpointShouldReturnAllGenres() {
        // Arrange
        List<String> genreList = getGenresTestCases();
        List<Genre> expected = GenresUtils.getGenresFromStrings(genreList);
        repository.saveAll(expected);

        // Act
        List<Genre> actual = controller.getAllGenres().getBody();

        // Assert
        assertNotNull(actual);
        assertThat(actual, hasSize(expected.size()));
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

}
