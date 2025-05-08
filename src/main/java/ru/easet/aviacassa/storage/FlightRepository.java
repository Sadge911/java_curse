package ru.easet.aviacassa.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.easet.aviacassa.model.Flight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для загрузки/сохранения списка рейсов в JSON-файл.
 */
public class FlightRepository {
    private static final Path STORAGE = Paths.get("flights.json");
    private final ObjectMapper mapper;

    public FlightRepository() {
        this.mapper = new ObjectMapper();
        // Регистрируем модуль для java.time
        mapper.registerModule(new JavaTimeModule());
        // Пишем даты в ISO-формате, а не в виде массива чисел
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public List<Flight> load() {
        try {
            if (Files.exists(STORAGE)) {
                return mapper.readValue(
                        Files.newInputStream(STORAGE),
                        new TypeReference<List<Flight>>() {}
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void save(List<Flight> flights) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(STORAGE.toFile(), flights);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
