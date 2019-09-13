package com.microsoft.azure.helium.app.movie;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * MoviesServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class MoviesServiceTest {

    @Mock
    private MoviesRepository repository;

    @InjectMocks
    private MoviesService service;

    @Test
    public void shouldReturnListOfAllMovies() throws Exception {
        // Arrange
        List<Movie> expected = Arrays.asList(mock(Movie.class));
        when(repository.findAll()).thenReturn(expected);

        // Act
        List<Movie> actual = service.getAllMovies(Optional.empty());

        // Assert
        verify(repository, times(1)).findAll();
        assertNotNull(actual);
        assertThat(actual, hasSize(expected.size()));
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void shouldReturnListofMoviesWhenQueryingValue() throws Exception {
        // Arrange
        List<Movie> expected = Arrays.asList(mock(Movie.class));
        when(repository.findByTextSearchContaining(anyString())).thenReturn(expected);

        // Act
        List<Movie> actual = service.getAllMovies(Optional.of(UUID.randomUUID().toString()));

        // Assert
        verify(repository, times(1)).findByTextSearchContaining(anyString());
        assertNotNull(actual);
        assertThat(actual, hasSize(expected.size()));
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenGettingMovieWithNullMovieId() {
        String movieId = null;

        service.getMovie(movieId);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenGettingMovieWithEmptyMovieId() {
        String movieId = "";

        service.getMovie(movieId);
    }

    @Test
    public void shouldReturnEmptyOptionalWhenNotFindingMovie() throws Exception {
        // Arrange
        Movie expected = mock(Movie.class);
        when(repository.findByMovieId(anyString())).thenReturn(expected);

        // Act
        Optional<Movie> actual = service.getMovie(UUID.randomUUID().toString());

        // Assert
        verify(repository, times(1)).findByMovieId(anyString());
        assertNotNull(actual);
    }

    @Test
    public void shouldReturnMovieInOptionalWhenFindingMovie() throws Exception {
        // Arrange
        Movie expected = mock(Movie.class);
        when(repository.findByMovieId(anyString())).thenReturn(expected);

        // Act
        Optional<Movie> actual = service.getMovie(UUID.randomUUID().toString());

        // Assert
        verify(repository, times(1)).findByMovieId(anyString());
        assertNotNull(actual);
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

}