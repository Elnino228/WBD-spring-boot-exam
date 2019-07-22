package com.codegym.springbootexam.controller;

import com.codegym.springbootexam.model.City;
import com.codegym.springbootexam.model.Nation;
import com.codegym.springbootexam.service.CityService;
import com.codegym.springbootexam.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/admin/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private NationService nationService;

    @ModelAttribute("nations")
    public Iterable<Nation> nations(){
        Iterable<Nation> nations=nationService.findAll();
        return nationService.findAll();
    }

    @GetMapping("")
    public ModelAndView listCities(@PageableDefault(size = 10) Pageable pageable){
        Page<City> cities=cityService.findAll(pageable);
        ModelAndView modelAndView=new ModelAndView("/city/list");
        modelAndView.addObject("cities",cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/city/create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            return "/city/create";
        }
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message","New city is created successfully");
        return "redirect:/admin/cities";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCity(@PathVariable("id") Long id){
        City city=cityService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/city/detail");
        modelAndView.addObject("city",city);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id){
        City city=cityService.findById(id);
        if (city!=null){
            ModelAndView modelAndView=new ModelAndView("/city/delete");
            modelAndView.addObject("city",city);
            return modelAndView;
        } else {
            ModelAndView modelAndView=new ModelAndView("/city/error404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCity(@ModelAttribute("city")City city){
        cityService.remove(city.getId());
        return "redirect:/admin/cities";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        City city=cityService.findById(id);
        if (city!=null){
            ModelAndView modelAndView=new ModelAndView("/city/edit");
            modelAndView.addObject("city",city);
            return modelAndView;
        } else {
            ModelAndView modelAndView=new ModelAndView("/city/error404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String editCity(@Validated @ModelAttribute("city") City city,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            return "/city/edit";
        }
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message","City is updated successfully");
        return "redirect:/admin/cities";
    }

}
