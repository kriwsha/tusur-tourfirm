package bva.tusur.dz.service;

import bva.tusur.dz.dto.TourDto;

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
}
