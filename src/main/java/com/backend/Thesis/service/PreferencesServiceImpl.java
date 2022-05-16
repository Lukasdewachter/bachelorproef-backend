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
        Preferences pref = preferencesRepository.findByIdStudent(preferences.getIdStudent());
        if(pref == null){
            if(preferences.getSubmitted() == null){
                preferences.setSubmitted(false);
            }
            return preferencesRepository.save(preferences);
        } else {
            return null;
        }
    }

    @Override
    public Preferences getPreferencesByIdStudent(long userId) {
        return preferencesRepository.findByIdStudent(userId);
    }

    @Override
    public Preferences updatePreferences(Preferences preferences, long userId) {
        Preferences existingPreferences = preferencesRepository.findByIdStudent(userId);

        if (Objects.nonNull(preferences.getFirstChoice()) && !"".equals(preferences.getFirstChoice())) {
            existingPreferences.setFirstChoice(preferences.getFirstChoice());
        }

        if (Objects.nonNull(preferences.getSecondChoice()) && !"".equals(preferences.getSecondChoice())) {
            existingPreferences.setSecondChoice(preferences.getSecondChoice());
        }

        if (Objects.nonNull(preferences.getThirdChoice()) && !"".equals(preferences.getThirdChoice())) {
            existingPreferences.setThirdChoice(preferences.getThirdChoice());
        }

        if (Objects.nonNull(preferences.getSubmitted()) && !"".equals(preferences.getSubmitted())) {
            existingPreferences.setSubmitted(preferences.getSubmitted());
        }

        return preferencesRepository.save(existingPreferences);
    }

    @Override
    public void deletePreferencesById(long id) {
        preferencesRepository.deleteById(id);
    }
}
