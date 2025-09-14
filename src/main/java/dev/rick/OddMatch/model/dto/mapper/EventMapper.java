package dev.rick.OddMatch.model.dto.mapper;

import dev.rick.OddMatch.model.Event;
import dev.rick.OddMatch.model.dto.request.EventRequest;
import dev.rick.OddMatch.model.dto.response.EventResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EventMapper {

    public Event toEvent(EventRequest request){
        return Event
                .builder()
                .name(request.name())
                .sports(request.sports())
                .time(request.localDateTime())
                .build();
    }

    public EventResponse toResponse(Event event){
        return EventResponse
                .builder()
                .id(event.getId())
                .name(event.getName())
                .sports(event.getSports())
                .localDateTime(event.getTime())
                .build();
    }

}
