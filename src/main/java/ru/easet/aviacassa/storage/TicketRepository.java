package ru.easet.aviacassa.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.easet.aviacassa.model.FlightTicket;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для загрузки/сохранения проданных билетов в JSON-файл.
 */
public class TicketRepository {
    private static final Path STORAGE = Paths.get("tickets.json");
    private final ObjectMapper mapper;

    public TicketRepository() {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public List<FlightTicket> load() {
        try {
            if (Files.exists(STORAGE)) {
                return mapper.readValue(
                        Files.newInputStream(STORAGE),
                        new TypeReference<List<FlightTicket>>() {}
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void save(List<FlightTicket> tickets) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(STORAGE.toFile(), tickets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}