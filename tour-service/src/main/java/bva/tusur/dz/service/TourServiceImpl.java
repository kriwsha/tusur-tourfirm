package bva.tusur.dz.service;

import bva.tusur.dz.dto.TourDto;
import bva.tusur.dz.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    private final Repository repo;

    @Autowired
    public TourServiceImpl(Repository repo) {
        this.repo = repo;
    }

    @Override
    public List<TourDto> getCurrentTours() {
        return repo.getAvailableTours();
    }
}
