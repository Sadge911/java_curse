package ru.easet.aviacassa.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс экипажа.
 */
public class Crew {
    private String pilot;
    private String coPilot;
    private List<String> attendants;

    /**
     * @param pilot     имя пилота
     * @param coPilot   имя второго пилота
     * @param attendants список стюардесс/стюардов
     */
    public Crew(String pilot, String coPilot, List<String> attendants) {
        this.pilot = pilot;
        this.coPilot = coPilot;
        this.attendants = new ArrayList<>(attendants);
    }

    public String getPilot() { return pilot; }
    public String getCoPilot() { return coPilot; }
    public List<String> getAttendants() { return Collections.unmodifiableList(attendants); }
}