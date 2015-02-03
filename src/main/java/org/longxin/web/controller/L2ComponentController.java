package org.longxin.web.controller;

import org.longxin.domains.L1Component;
import org.longxin.domains.L2Component;
import org.longxin.domains.L2ComponentParameter;
import org.longxin.domains.L3Component;
import org.longxin.service.L2ComponentParameterService;
import org.longxin.service.L2ComponentService;
import org.longxin.service.L3ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/l2component")
@SessionAttributes("l2component")
public class L2ComponentController
{

	@Autowired
	L2ComponentParameterService l2ComponentParameterService;
	
	@Autowired
	L2ComponentService l2ComponentService;
	
	@Autowired
	L3ComponentService l3ComponentService;

	@RequestMapping(value = "/view/{l2id}", method = RequestMethod.GET)
	public String viewL2Component(@PathVariable int l2id, Model model)
	{
		L2Component component = l2ComponentService.getL2ComponentByID(l2id);
		model.addAttribute("component", component);
		model.addAttribute("parameters", l2ComponentParameterService.getL2Paramters(component));
		model.addAttribute("parameter", new L2ComponentParameter());
		model.addAttribute("l3components", l2ComponentService.getL3ComponentsByL2(component));
		return "/l2/view";
	}
	
	@RequestMapping(value = "/diagram/{componentId}", method = RequestMethod.GET)
	public String showDiagram(@PathVariable int componentId, Model model)
	{
		L2Component component = l2ComponentService.getL2ComponentByID(componentId);
		model.addAttribute("component", component);
		return "/l2component/diagram";
	}
	
	@RequestMapping(value = "/update/{l2id}", method = RequestMethod.POST)
	public String viewModule(@ModelAttribute("l2Component") L2Component l2component)
	{
		l2ComponentService.updateL2Component(l2component);
		return "/l1/view";
	}
	
	@RequestMapping(value = "/view/{l2id}/add/parameter", method = RequestMethod.POST)
	public @ResponseBody ModelMap  addComponentParameter(@PathVariable int l2id, @RequestBody L2ComponentParameter json)
	{
		L2Component component = l2ComponentService.getL2ComponentByID(l2id);
		json.setL2Component(component);
		l2ComponentParameterService.addParameter(json);
		return new ModelMap("success", 1);
	}
	
	@RequestMapping(value = "/delete/parameter/{parameterid}", method = RequestMethod.POST)
	public @ResponseBody ModelMap  deleteComponentParameter(@PathVariable int parameterid)
	{
		l2ComponentParameterService.deleteParameter(parameterid);
		return new ModelMap("success", 1);
	}
	
	@RequestMapping(value = "/update/parameter", method = RequestMethod.POST)
	public @ResponseBody ModelMap  updateComponentParameter(@ModelAttribute("l2ComponentParameter") L2ComponentParameter l2componentParameter)
	{
		l2ComponentParameterService.updateParameter(l2componentParameter);
		return new ModelMap("success", 1);
	}
	
	@RequestMapping(value = "/view/{l2Id}/add/component", method = RequestMethod.POST)
	public String addL2Componment(@PathVariable int l2Id , L3Component l3Component)
	{
		l3Component.setL2Component(l2ComponentService.getL2ComponentByID(l2Id));
		l3ComponentService.addL3Component(l3Component);
		return "/l2/view";
	}
	
	@RequestMapping(value = "/delete/component/{l3Id}", method = RequestMethod.POST)
	public String deleteL2Componment(@PathVariable int l3Id)
	{
		l3ComponentService.deleteL3Component(l3Id);
		return "/l2/view";
	}

}
