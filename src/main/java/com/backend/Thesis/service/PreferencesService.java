package com.backend.Thesis.service;

import com.backend.Thesis.entity.Preferences;

import java.util.List;

public interface PreferencesService {
    List<Preferences> getAllPreferences();

    Preferences savePreferences(Preferences preferences);

    Preferences getPreferencesByIdStudent(long userId);

    Preferences updatePreferences(Preferences preferences, long userId);

    void deletePreferencesById(long id);
}
