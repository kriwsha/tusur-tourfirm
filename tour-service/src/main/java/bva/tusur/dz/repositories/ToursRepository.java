package bva.tusur.dz.repositories;

import bva.tusur.dz.jooq.generated.tables.Cities;
import bva.tusur.dz.jooq.generated.tables.Countries;
import bva.tusur.dz.jooq.generated.tables.Hotels;
import bva.tusur.dz.jooq.generated.tables.Tours;
import bva.tusur.dz.model.dto.TourDto;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record5;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class ToursRepository {

    private static final String COUNTRY_NAME_ALIAS = "country_name";
    private static final String CITY_NAME_ALIAS = "city_name";
    private static final String PRICE_ALIAS = "price";
    private static final String START_DATE_ALIAS = "start";
    private static final String END_DATE_ALIAS = "end";

    @Qualifier("DSLContext")
    private final DSLContext jooq;

    private static final Tours TOURS = Tours.TOURS;
    private static final Hotels HOTELS = Hotels.HOTELS;
    private static final Cities CITIES = Cities.CITIES;
    private static final Countries COUNTRIES = Countries.COUNTRIES;

    @Autowired
    public ToursRepository(DSLContext dlsContext) {
        this.jooq = dlsContext;
    }

    /**
     * Getting all available tours.
     * @return list of tours.
     */
    public List<TourDto> getAvailableTours() {
        return getToursByFilter(null, null, null, null, null, null);
    }

    /**
     * Getting tours by filters.
     * @return list of tours.
     */
    public List<TourDto> getToursByFilter(
            String country,
            String city,
            Integer costFrom,
            Integer costTo,
            LocalDate dateFrom,
            LocalDate dateTo
    ) {
        Result<Record5<String, String, String, LocalDate, LocalDate>> records = jooq.select(
                        COUNTRIES.NAME.as(COUNTRY_NAME_ALIAS),
                        CITIES.NAME.as(CITY_NAME_ALIAS),
                        TOURS.PRICE.cast(String.class).as(PRICE_ALIAS),
                        TOURS.START_DATE.as(START_DATE_ALIAS),
                        TOURS.END_DATE.as(END_DATE_ALIAS))
                .from(TOURS)
                .innerJoin(HOTELS).on(TOURS.HOTEL_ID.eq(HOTELS.HOTEL_ID))
                .innerJoin(CITIES).on(CITIES.CITY_ID.eq(HOTELS.CITY_ID))
                .innerJoin(COUNTRIES).on(COUNTRIES.COUNTRY_CODE.eq(CITIES.COUNTY_CODE))
                .where(prepareConditions(
                        country, city, costFrom, costTo, dateFrom, dateTo))
                .fetch();

        return parseResultToDto(records);
    }

    /**
     * Insert new tour.
     * @param tour ...
     */
    public void createTour(TourDto tour) {
        jooq.insertInto(TOURS)
                .values(tour);
    }

    /**
     * Remove tour.
     * @param tour ...
     */
    public void removeTour(TourDto tour) {
        jooq.deleteFrom(TOURS)
                .where(TOURS.TOUR_ID.eq(tour.getId()));
    }

    /**
     * Update tour.
     * @param tour ...
     */
    public void updateTour(TourDto tour) {
        Map<Object, Object> map = new HashMap<>();
        jooq.update(TOURS)
                .set(map)
                .where(TOURS.TOUR_ID.eq(tour.getId()));
    }

    private List<TourDto> parseResultToDto(Result<Record5<String, String, String, LocalDate, LocalDate>> records) {
        List<TourDto> tours = new ArrayList<>();
        for (Record record : records) {
            String dates = String.format("%s - %s",
                    record.get(START_DATE_ALIAS),
                    record.get(END_DATE_ALIAS));
            tours.add(
                    new TourDto(
                            Optional.ofNullable(record.get(TOURS.TOUR_ID)).orElse(0),
                            Optional.ofNullable(record.get(COUNTRY_NAME_ALIAS)).orElse("unknown").toString(),
                            Optional.ofNullable(record.get(CITY_NAME_ALIAS)).orElse("unknown").toString(),
                            Optional.ofNullable(record.get(PRICE_ALIAS)).orElse("unknown").toString(),
                            dates
                    ));
        }
        return tours;
    }

    private Collection<Condition> prepareConditions(
            String country,
            String city,
            Integer costFrom,
            Integer costTo,
            LocalDate dateFrom,
            LocalDate dateTo
    ) {
        List<Condition> conditions = new ArrayList<>();
        if (StringUtils.hasLength(country)) {
            conditions.add(COUNTRIES.NAME.eq(COUNTRY_NAME_ALIAS));
        }
        if (StringUtils.hasLength(city)) {
            conditions.add(CITIES.NAME.eq(city));
        }
        if (Objects.nonNull(costFrom)) {
            conditions.add(TOURS.PRICE.greaterOrEqual(costFrom));
        }
        if (Objects.nonNull(costTo)) {
            conditions.add(TOURS.PRICE.greaterOrEqual(costTo));
        }
        if (Objects.nonNull(dateFrom)) {
            conditions.add(TOURS.START_DATE.greaterOrEqual(dateFrom));
        }
        if (Objects.nonNull(dateTo)) {
            conditions.add(TOURS.END_DATE.greaterOrEqual(dateTo));
        }
        return conditions;
    }
}
