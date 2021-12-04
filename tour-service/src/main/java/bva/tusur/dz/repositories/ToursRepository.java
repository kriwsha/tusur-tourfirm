package bva.tusur.dz.repositories;

import bva.tusur.dz.model.dto.TourDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ToursRepository {

    @Qualifier("DSLContext")
    private DSLContext jooq;

    @Autowired
    public ToursRepository(DSLContext dlsContext) {
        this.jooq = dlsContext;
    }

    public List<TourDto> getAvailableTours() {
        // TODO: 04.12.2021 for test
        return Collections.singletonList(
                new TourDto("Russia", "Moscow", "1000", "10.12-12.12"));
    }
}
