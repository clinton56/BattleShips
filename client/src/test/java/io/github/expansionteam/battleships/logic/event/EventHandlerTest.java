package io.github.expansionteam.battleships.logic.event;

import io.github.expansionteam.battleships.common.events.GenerateShipsEvent;
import io.github.expansionteam.battleships.common.events.ShootPositionEvent;
import io.github.expansionteam.battleships.common.events.StartGameEvent;
import io.github.expansionteam.battleships.common.events.data.PositionData;
import org.testng.annotations.Test;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EventHandlerTest {

    @Test
    public void handleStartGameEvent() {
        // Given
        EventProcessor eventProcessorMock = mock(EventProcessor.class);
        EventHandler eventHandler = new EventHandler(eventProcessorMock);

        // When
        eventHandler.handleEvent(new StartGameEvent());

        // Then
        verify(eventProcessorMock).processEvent(isA(StartGameEvent.class));
    }

    @Test
    public void handleGenerateShipsEvent() {
        // Given
        EventProcessor eventProcessorMock = mock(EventProcessor.class);
        EventHandler eventHandler = new EventHandler(eventProcessorMock);

        // When
        eventHandler.handleEvent(new GenerateShipsEvent());

        // Then
        verify(eventProcessorMock).processEvent(isA(GenerateShipsEvent.class));
    }

    @Test
    public void handleShootPositionEvent() {
        // Given
        EventProcessor eventProcessorMock = mock(EventProcessor.class);
        EventHandler eventHandler = new EventHandler(eventProcessorMock);

        // When
        PositionData position = PositionData.of(1, 1);
        eventHandler.handleEvent(new ShootPositionEvent(position));

        // Then
        verify(eventProcessorMock).processEvent(isA(ShootPositionEvent.class));
    }

}
