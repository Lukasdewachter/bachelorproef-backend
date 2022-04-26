package com.backend.Thesis.service;

import com.backend.Thesis.entity.Preferences;

import java.util.List;

public interface PreferencesService {
    List<Preferences> getAllPreferences();

    Preferences savePreferences(Preferences preferences);

    Preferences getPreferencesById(long id);

    Preferences updatePreferences(Preferences preferences, long id);

    void deletePreferencesById(long id);

}
