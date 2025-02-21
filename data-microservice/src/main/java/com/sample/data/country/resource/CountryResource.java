package com.sample.data.country.resource;

import com.sample.data.country.model.Country;
import com.sample.data.country.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Tag(name = "[Data] Country", description = "Country REST Service(s)")
@RestController
@RequestMapping("/data/country")
public class CountryResource {

    @Autowired
    private CountryService service;

    @Operation(summary = "List Country")
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<Country> list() {
        return service.list();
    }

    @Operation(summary = "Lookup Country By Id")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public java.util.Optional<Country> getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @Operation(summary = "Insert Country")
    @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public Country insertCountry(Country country) {
        return service.insertCountry(country);
    }

    @Operation(summary = "Update Country")
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Country updateCountry(@PathVariable("id") java.lang.Integer id, Country country) {
        return service.updateCountry(id, country);
    }

    @Operation(summary = "Delete Country")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteCountry(@PathVariable("id") java.lang.Integer id) {
        service.deleteCountry(id);
    }


}
