package com.codegym.controller;

import com.codegym.model.Country;
import com.codegym.model.Province;
import com.codegym.service.CountryService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ModelAndView listProvinces() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/province/list");
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        Iterable<Country> countries = countryService.findAll();
        modelAndView.addObject("province", countryService.findAll());
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("success", null);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id) {
        Optional<Province> province = provinceService.findById(id);

        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            Iterable<Country> countries = countryService.findAll();
            modelAndView.addObject("countries", countries);
            modelAndView.addObject("province", province.get());
            modelAndView.addObject("success", null);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }


    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
    public ModelAndView save(@Validated @ModelAttribute("province") Province province, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        provinceService.save(province);
        modelAndView.setViewName("/province/create");
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView updateProvice(@PathVariable Long id,@Validated @ModelAttribute("province") Province province, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/province/edit");

        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("script", true);
        }
        else {
            try {
                provinceService.save(province);

                modelAndView.addObject("province", province);
                modelAndView.addObject("success", "province updated successfully");
            } catch (Exception e) {
                e.printStackTrace();
                modelAndView.addObject("error", "Invalid data, please contact system administrator");
            }
        }

        return modelAndView;
    }

}
