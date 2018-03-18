package com.samseng.vehicles.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.samseng.vehicles.model.BriefingQuestions;
import com.samseng.vehicles.repository.BriefingQuestionsJpaRepository;
import com.samseng.vehicles.services.BriefingQuestionsService;
import com.samseng.vehicles.services.BriefingService;
import com.samseng.vehicles.services.EventObserverJob;
import com.samseng.vehicles.sse.EventInfo;

@Controller
public class BriefingQuestionsController {
	
	//https://datatables.net/examples/ajax/null_data_source.html
	//https://datatables.net/examples/ajax/custom_data_flat.html
	
	static Logger log = Logger.getLogger(BriefingQuestionsController.class.getName());
	
	
	private static final String ENTITY_TYPE ="briefingQuestions";
	private static final String ROOT_NAME = "briefingquestions";
	
	
	@Value ("${briefingQuestions.titleEdit:titleEdit}")
	private String TITLE_EDIT;
	
	@Value ("${briefingQuestions.titleCreate:titleCreate}")
	private String TITLE_CREATE;
	
	
	private static final String TEMPLATE_ADD = ROOT_NAME+"Add";
	
	private static final String ENTITY_RECORDS ="entityRecords";
	
	private static final String D = "/";
	private static final String ROOT_MAPPING=D+ROOT_NAME;
	private static final String ROOT_MAPPING_AJAX=ROOT_MAPPING+D+"ajax";
	
	private static final String TABLE_MAPPING=ROOT_MAPPING+D+"table";
	
	private static final String ADD_RECORD_MAPPING=ROOT_MAPPING+D+"add";
	private static final String ADD_RECORD_AJAX_MAPPING = ROOT_MAPPING_AJAX+D+"add";
	
	private static final String DELETE_RECORD_MAPPING=ROOT_MAPPING+D+"delete";
	private static final String DELETE_RECORD_MAPPING_ID=DELETE_RECORD_MAPPING+D+"{id}";
	
	private static final String SAVE_RECORD_AJAX_MAPPING =ROOT_MAPPING_AJAX+D+"save";
	
	private static final String EDIT_RECORD_MAPPING=ROOT_MAPPING+D+"edit"+D+"{id}";
	private static final String EDIT_RECORD_AJAX_MAPPING_ID = ROOT_MAPPING_AJAX+D+"edit"+D+"{id}";

	private static final String POPUP = " :: form (mode='popup')";

	private static final String TEMPLATE_ADD_POPUP = TEMPLATE_ADD + POPUP;
	
	
	
	@Autowired
	BriefingQuestionsService service;
	
	@Autowired
	BriefingService briefingService;
	
	@Autowired
	EventObserverJob eventService;
	
	@GetMapping(TABLE_MAPPING)
	@ResponseBody
	public List <BriefingQuestions> dataTable(){
		return service.findAll();
	}
	
	@GetMapping(ROOT_MAPPING)
    public String findAll(Model model) {
		log.info(ROOT_NAME +" type controller");
		List <BriefingQuestions> companies = service.findAll();
		model.addAttribute(ENTITY_RECORDS, companies);
		model.addAttribute("rootName", ROOT_NAME);
		
		return ROOT_NAME;
	}
	
	@GetMapping(ADD_RECORD_MAPPING)
    public String add(BriefingQuestions entity,Model model) {
		
		log.info(ROOT_NAME + " type controller");
		model.addAttribute(ENTITY_TYPE, entity);
		model.addAttribute("rootName", ROOT_NAME);
	
		if (entity.getId() == null)
			model.addAttribute("title", TITLE_CREATE);
		else
			model.addAttribute("title", TITLE_EDIT);
        return TEMPLATE_ADD;
        
    }
	
	@GetMapping(EDIT_RECORD_MAPPING)
    public String edit(@PathVariable("id") Integer id,Model model) {
         
        return add(service.findOne(id), model);
    }
     
    @GetMapping(DELETE_RECORD_MAPPING_ID)
    public String delete(@PathVariable("id") Integer id, Model model) {
         
        service.toggleDelete(id);
         
        return "redirect:/"+ROOT_NAME;
    }
// 
    @PostMapping(DELETE_RECORD_MAPPING)
    public String save(@Valid BriefingQuestions post, BindingResult result,Model model) {
         
        if(result.hasErrors()) {
            return add(post, model);
        }
         
        service.save(post);
         
        return "redirect:/"+ROOT_NAME;
    }
    
    @PostMapping(SAVE_RECORD_AJAX_MAPPING)
    public String ajaxSave(@Valid BriefingQuestions post, BindingResult result,Model model) {
        
    	EventInfo ei;
    	
        if(result.hasErrors()) {
        	ei = new EventInfo(EventObserverJob.NotifyTypes.danger.toString(), "Check the input. Something is wrong.");
        	eventService.notify(ei);
        	add(post, model);
        	//return "briefingquestionsAdd :: form (mode='popup')";
        } else {
         
        service.save(post);
        
        add(new BriefingQuestions(), model);
        ei = new EventInfo(EventObserverJob.NotifyTypes.info.toString(), "Information added succesfully to the database");
        eventService.notify(ei);
        
    }
        model.addAttribute("rootName", ROOT_NAME);
        
        return TEMPLATE_ADD_POPUP;
    }
	
	@GetMapping(EDIT_RECORD_AJAX_MAPPING_ID)
	public String ajaxCompanyFind(@PathVariable("id") Integer id, Model model) {
		log.info("AJAX find  " + EDIT_RECORD_AJAX_MAPPING_ID);
		add(service.findOne(id), model);
		model.addAttribute("rootName", ROOT_NAME);
		model.addAttribute("title", TITLE_EDIT);
		model.addAttribute("allBriefings", briefingService.findAllNotDeleted());
		return TEMPLATE_ADD_POPUP;
	}
	
	@GetMapping(ADD_RECORD_AJAX_MAPPING)
    public String ajaxAdd(BriefingQuestions entity,Model model) {
		log.info("ajax "+ROOT_NAME+" type controller");
		model.addAttribute(ENTITY_TYPE, entity);
		model.addAttribute("rootName", ROOT_NAME);
		model.addAttribute("allBriefings", briefingService.findAllNotDeleted());
		if (entity.getId() == null)
			model.addAttribute("title", TITLE_CREATE);
		else
			model.addAttribute("title", TITLE_EDIT);
        return TEMPLATE_ADD_POPUP;   
    }
    
}
