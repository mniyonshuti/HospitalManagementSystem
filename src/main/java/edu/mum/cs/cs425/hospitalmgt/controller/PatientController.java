package edu.mum.cs.cs425.hospitalmgt.controller;

import edu.mum.cs.cs425.hospitalmgt.model.Patient;
import edu.mum.cs.cs425.hospitalmgt.servirce.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(value = {"/hcmc/patient/new"})
    public String displayNewPatientForm(Model model){
        model.addAttribute("patient", new Patient());
        return "patient/new";
    }

    @PostMapping(value = {"/hcmc/patient/new"})
    public String addNewPatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return  "patient/new";
        }
        patient = patientService.savePatient(patient);
        System.out.println(patient.toString());
        return "redirect:/hcmc/home";
    }

    @RequestMapping(value = {"/hcmc/patient/list"})
    public ModelAndView getAllPatients(@RequestParam(defaultValue = "0") int pageno){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageCurrent", pageno);
        modelAndView.addObject("flashback", "/hcmc/patient/list");
        modelAndView.addObject( "patients" , patientService.listPatients());
        modelAndView.setViewName("patient/list");
        return modelAndView;
    }

    @GetMapping(value = {"/hcmc/patient/old"})
    public ModelAndView greaterThan65(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("eldery", patientService.patientGrt65());
        modelAndView.setViewName("patient/old");
        return modelAndView;
    }

    @GetMapping(value = {"/hcmc/patient/search"})
    public ModelAndView searchPatients(@RequestParam("search") String search){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("results", patientService.searchPatient(search,search,search,search,search));
        modelAndView.setViewName("patient/search");
        return modelAndView;
    }

}
