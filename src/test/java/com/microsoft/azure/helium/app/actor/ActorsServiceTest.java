package com.microsoft.azure.helium.app.actor;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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
 * ActorsServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class ActorsServiceTest {

    @Mock
    private ActorsRepository repository;

    @InjectMocks
    private ActorsService service;

    @Test
    public void shouldReturnListOfAllActors() throws Exception {
        // Arrange
        List<Actor> expected = Arrays.asList(mock(Actor.class));
        when(repository.findAll()).thenReturn(expected);

        // Act
        List<Actor> actual = service.getAllActors(Optional.empty());

        // Assert
        verify(repository, times(1)).findAll();
        assertNotNull(actual);
        assertThat(actual, hasSize(expected.size()));
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void shouldReturnListofActorsWhenQueryingValue() throws Exception {
        // Arrange
        List<Actor> expected = Arrays.asList(mock(Actor.class));
        when(repository.findByTextSearchContaining(anyString())).thenReturn(expected);

        // Act
        List<Actor> actual = service.getAllActors(Optional.of(UUID.randomUUID().toString()));

        // Assert
        verify(repository, times(1)).findByTextSearchContaining(anyString());
        assertNotNull(actual);
        assertThat(actual, hasSize(expected.size()));
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenGettingActorWithNullActorId() {
        String actorId = null;
        service.getActor(actorId);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenGettingActorWithEmptyActorId() {
        String actorId = "";
        service.getActor(actorId);
    }

    @Test
    public void shouldReturnEmptyOptionalWhenNotFindingActor() throws Exception {
        // Arrange
        Actor expected = mock(Actor.class);
        when(repository.findByActorId(anyString())).thenReturn(expected);

        // Act
        Optional<Actor> actual = service.getActor(UUID.randomUUID().toString());

        // Assert
        verify(repository, times(1)).findByActorId(anyString());
        assertNotNull(actual);
    }

    @Test
    public void shouldReturnActorInOptionalWhenFindingActor() throws Exception {
        // Arrange
        Actor expected = mock(Actor.class);
        when(repository.findByActorId(anyString())).thenReturn(expected);

        // Act
        Optional<Actor> actual = service.getActor(UUID.randomUUID().toString());

        // Assert
        verify(repository, times(1)).findByActorId(anyString());
        assertNotNull(actual);
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

}