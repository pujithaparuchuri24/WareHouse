package com.example.warehouse.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.warehouse.model.OrderMethod;
import com.example.warehouse.service.interfaces.OrderMethodService;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {
	@Autowired
	private OrderMethodService service;
	@GetMapping("/register")
	public String orderRegister(Map m)
	{
		m.put("order", new OrderMethod());
		return "OrderRegister";
	}
	@PostMapping("/save")
	public String OrderSave(Map m,@ModelAttribute OrderMethod o)
	{
		int id=service.OrderSave(o);
		m.put("msg", id+"successfully saved");
		m.put("order", new OrderMethod());
		return "OrderRegister";
	}
	@GetMapping("/getall")
	public String ordergetAll(Map m)
	{
		List<OrderMethod> list=service.getAll();
		m.put("list", list);
		return "OrderData";
	}
	@GetMapping("/edit/{id}")
	public String orderEdit(@PathVariable int id,RedirectAttributes r,Map m)
	{
		Optional<OrderMethod> o=service.getById(id);
		String page=null;
		if(o.isPresent())
		{
			m.put("order", o.get());
			page="Orderupdate";
		}
		else
		{
			r.addFlashAttribute("msg",id+"not there");
			page="redirect:http://localhost:8080/ordermethod/getall";
		}
		return page;	
		}
	@PostMapping("/update")
	public String update(@ModelAttribute OrderMethod o,RedirectAttributes r)
	{
		int id=service.OrderSave(o);
		r.addFlashAttribute("msg", id+"successfully updated");
		return "redirect:./getall";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,RedirectAttributes r)
	{
		Optional<OrderMethod> o=service.getById(id);
		if(o.isPresent())
		{
			service.orderDelete(id);
			r.addFlashAttribute("msg",id+"successfully deleted" );
		}
		else
		{
			r.addFlashAttribute("msg", id+"id is not there");
		}
		return "redirect:../getall";
	}

}
