package bva.tusur.dz.repositories;

import bva.tusur.dz.dto.TourDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Repository {

    @Qualifier("DSLContext")
    private DSLContext jooq;

    @Autowired
    public Repository(DSLContext dlsContext) {
        this.jooq = dlsContext;
    }

    public List<TourDto> getAvailableTours() {
        throw new UnsupportedOperationException("not implemented");
    }
}
