package com.samseng.vehicles.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.samseng.vehicles.model.CompanyType;
import com.samseng.vehicles.repository.CompanyTypeJpaRepository;
import com.samseng.vehicles.services.CompanyTypeService;

@Controller
public class CompanyTypeController {
	static Logger log = Logger.getLogger(CompanyTypeController.class.getName());
	
	@Autowired
	CompanyTypeService service;
	
	@GetMapping("/companytype")
    public String findAll(Model model) {
		log.info("company type controller");
		List <CompanyType> companies = service.findAll();
		model.addAttribute("companies", companies);
		
		return "companytype";
	}
	
	@GetMapping("/companytype/add")
    public String add(CompanyType companyType,Model model) {
		log.info("company type controller");
		model.addAttribute("companyType", companyType);
        return "companytypeAdd";
        
    }
	
	@GetMapping("/companytype/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model) {
         
        return add(service.findOne(id), model);
    }
     
    @GetMapping("/companytype/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
         
        service.toggleDelete(id);
         
        return "redirect:/companytype";
    }
// 
    @PostMapping("/companytype/save")
    public String save(@Valid CompanyType post, BindingResult result,Model model) {
         
        if(result.hasErrors()) {
            return add(post, model);
        }
         
        service.save(post);
         
        return "companytypeAdd";
    }
	
	
//	@GetMapping("/ajax/companyFind")
//    public String ajaxCompanyFind(@RequestParam("filter") String filter,Model model) {
//		log.info("company find controller. Filter " + filter);
//		List <CompanyType> companies = repo.findFirst50ByDescriptionLikeOrderByDescription("%"+filter+"%");
//		model.addAttribute("companies", companies);
//		
//		return "companytype :: result";
//	}
}
