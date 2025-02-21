package com.sample.data.country.service;

import com.sample.data.country.mapper.sampledb.CountryMapper;
import com.sample.data.country.model.Country;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryMapper mapper;

    public List<Country> list() {
        return mapper.list();
    }

    public Optional<Country> getById(Integer id) {
        return list().stream().filter(country -> country.getId() == id.intValue()).findFirst();
    }

    public Country insertCountry(Country country) {
        mapper.insertCountry(country);
        return country;
    }

    public Country updateCountry(int id, Country country) {
        Optional<Country> countryOpt = getById(id);
        if (countryOpt.isPresent()) {
            country.setId(id);
            mapper.updateCountry(country);
            return getById(country.getId()).get();
        } else {
            throw new NotFoundException("Country not found");
        }
    }

    public void deleteCountry(int id) {
        Optional<Country> countryOpt = getById(id);
        if (countryOpt.isPresent()) {
            mapper.deleteCountry(countryOpt.get().getId(), "admin");
        } else {
            throw new NotFoundException("Country not found");
        }
    }
}