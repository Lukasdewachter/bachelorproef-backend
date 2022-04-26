package com.backend.Thesis.service;

import com.backend.Thesis.entity.Preferences;
import com.backend.Thesis.repository.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PreferencesServiceImpl implements PreferencesService {
    @Autowired
    private PreferencesRepository preferencesRepository;

    @Override
    public List<Preferences> getAllPreferences() {
        return (List<Preferences>) preferencesRepository.findAll();
    }

    @Override
    public Preferences savePreferences(Preferences preferences) {
        return preferencesRepository.save(preferences);
    }

    @Override
    public Preferences getPreferencesById(long id) {
        return preferencesRepository.findById(id).get();
    }

    @Override
    public Preferences updatePreferences(Preferences preferences, long id) {
        Preferences existingPreferences = preferencesRepository.findById(id).get();

        if (Objects.nonNull(preferences.getFirstChoice()) && !"".equals(preferences.getFirstChoice())) {
            existingPreferences.setFirstChoice(preferences.getFirstChoice());
        }

        if (Objects.nonNull(preferences.getSecondChoice()) && !"".equals(preferences.getSecondChoice())) {
            existingPreferences.setSecondChoice(preferences.getSecondChoice());
        }

        if (Objects.nonNull(preferences.getThirdChoice()) && !"".equals(preferences.getThirdChoice())) {
            existingPreferences.setThirdChoice(preferences.getThirdChoice());
        }

        return preferencesRepository.save(existingPreferences);
    }

    @Override
    public void deletePreferencesById(long id) {
        preferencesRepository.deleteById(id);
    }
}
