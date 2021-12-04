package bva.tusur.dz.service.impl;

import bva.tusur.dz.model.dto.TourDto;
import bva.tusur.dz.repositories.ToursRepository;
import bva.tusur.dz.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с турами
 */
@Service
public class TourServiceImpl implements TourService {

    private final ToursRepository repo;

    @Autowired
    public TourServiceImpl(ToursRepository repo) {
        this.repo = repo;
    }

    /**
     * Получить все актуальные туры
     *
     * @return ...
     */
    @Override
    public List<TourDto> getCurrentTours() {
        return repo.getAvailableTours();
    }
}
