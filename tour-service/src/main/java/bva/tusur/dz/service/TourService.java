package bva.tusur.dz.service;

import bva.tusur.dz.model.dto.TourDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Сервис для работы с турами
 */
public interface TourService {

    /**
     * Получить все актуальные туры
     *
     * @return ...
     */
    List<TourDto> getCurrentTours();


    /**
     * Получить туры по фильтру
     *
     * @return ...
     */
    List<TourDto> getToursByFilter(
            String country,
            String city,
            String cost,
            String dateFrom,
            String dateTo
    );

    /**
     * ...
     * @param tour ...
     */
    void addNewTour(TourDto tour);
}
