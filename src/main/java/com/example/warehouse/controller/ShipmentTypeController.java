package com.example.warehouse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.warehouse.model.ShipmentType;
import com.example.warehouse.service.interfaces.ShipmentTypeService;

@Controller 
@RequestMapping("/shipmentType")
public class ShipmentTypeController {
   @Autowired 
   private ShipmentTypeService service;
	@GetMapping("/register")
	public String show_register(Model m)
	{
		System.out.println("hi");
		m.addAttribute("ship", new ShipmentType());;
		return "shipmentTypeRegister";
	}
	@PostMapping("/save")
	public String shipSave(@ModelAttribute ShipmentType s,Model m)
	{
		int id=service.ShipmentTypeSave(s);
		m.addAttribute("msg", id+"successfully saved");
		m.addAttribute("ship",new ShipmentType() );
		return "shipmentTypeRegister";
	}
	
	@GetMapping("/getAll")
	public String  ShipGetAll(Model m)
	{
		List<ShipmentType> l=service.ShipmentTypeGetAll();
		m.addAttribute("list", l);
	    return "ShipmentData";
	}
	
	@GetMapping("/edit/{id}")
	public String Shipedit(@PathVariable int id,Model m)
	{   String page=null;
		Optional<ShipmentType> s=service.ShipmentTypeGetByID(id);
		if(s.isPresent())
		{
			m.addAttribute("ship",s); 
			page="ShipmentUpdate";	
		}
		else
		{
			page="redirect:../getAll";
		}
				return page;
				
	}
	@PostMapping("/update")
	public String Shipupdate(@ModelAttribute ShipmentType s,RedirectAttributes r)
	{
		service.ShipmentTypeSave(s);
		r.addFlashAttribute("msg", s.getId()+"successfully udated");
		return "redirect:./getAll";
		
	}
	@GetMapping("/delete/{id}")
	public String Shipupdate(@PathVariable int id,RedirectAttributes r)
	{
		Optional<ShipmentType> s=service.ShipmentTypeGetByID(id);
		if(s.isPresent())
		{
			r.addFlashAttribute("msg", id+"sucessfully deleted");
			service.ShipmentTypeDelete(id);
		}
		else
		{
			r.addFlashAttribute("msg", id+"not there");
		}
		return "redirect:http://localhost:8080/shipmentType/getAll";
	}
}
