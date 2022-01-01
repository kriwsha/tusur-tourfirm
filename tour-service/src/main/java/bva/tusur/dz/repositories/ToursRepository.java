package bva.tusur.dz.repositories;

import bva.tusur.dz.jooq.generated.tables.Cities;
import bva.tusur.dz.jooq.generated.tables.Countries;
import bva.tusur.dz.jooq.generated.tables.Hotels;
import bva.tusur.dz.jooq.generated.tables.Tours;
import bva.tusur.dz.model.dto.TourDto;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record5;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ToursRepository {

    @Qualifier("DSLContext")
    private DSLContext jooq;

    private static final Tours TOURS = Tours.TOURS;
    private static final Hotels HOTELS = Hotels.HOTELS;
    private static final Cities CITIES = Cities.CITIES;
    private static final Countries COUNTRIES = Countries.COUNTRIES;

    @Autowired
    public ToursRepository(DSLContext dlsContext) {
        this.jooq = dlsContext;
    }

    public List<TourDto> getAvailableTours() {
        String countryName = "country_name";
        String cityName = "city_name";
        String price = "price";
        String start = "start";
        String end = "end";

        Result<Record5<String, String, String, LocalDate, LocalDate>> records = jooq.select(
                        COUNTRIES.NAME.as(countryName),
                        CITIES.NAME.as(cityName),
                        TOURS.PRICE.cast(String.class).as(price),
                        TOURS.START_DATE.as(start),
                        TOURS.END_DATE.as(end))
                .from(TOURS)
                .innerJoin(HOTELS).on(TOURS.HOTEL_ID.eq(HOTELS.HOTEL_ID))
                .innerJoin(CITIES).on(CITIES.CITY_ID.eq(HOTELS.CITY_ID))
                .innerJoin(COUNTRIES).on(COUNTRIES.COUNTRY_CODE.eq(CITIES.COUNTY_CODE))
                .fetch();

        List<TourDto> tours = new ArrayList<>();
        for (Record record : records) {
            String dates = String.format("%s - %s",
                    record.get(start),
                    record.get(end));
            tours.add(
                    new TourDto(
                            Objects.requireNonNull(record.get(countryName)).toString(),
                            Objects.requireNonNull(record.get(cityName)).toString(),
                            Objects.requireNonNull(record.get(price)).toString(),
                            dates
                    ));
        }
        return tours;
    }
}
