package com.codegym.controller.aoi;

import com.codegym.model.Country;
import com.codegym.model.Province;
import com.codegym.service.CountryService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/provinces")
public class ProvinceApi {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CountryService countryService;

    @GetMapping
    public Iterable<Province> getListProvince() {

        Iterable<Province> provinces = provinceService.findAll();

        return provinces;
    }

    @GetMapping("/{id}")
    public Province createId(@PathVariable Long id) {

        Province province = provinceService.findById(id).get();

        return province;
    }

    @PostMapping("/create")
    public Province create(@RequestBody Province province) {
        Country country = countryService.save(province.getCountry());

        province.setCountry(country);
        Province province1 = provinceService.save(province);

        return province1;
    }

    @PostMapping("/update")
    public Province update(@RequestBody Province province) {

        Province province1 = provinceService.save(province);

        return province;
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {

        provinceService.remove(id);

        Optional<Province> province = provinceService.findById(id);

        if (province.isPresent()) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }
}
