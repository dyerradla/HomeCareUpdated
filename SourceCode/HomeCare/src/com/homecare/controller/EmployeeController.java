package com.homecare.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homecare.bo.IEmployeeInfoBO;
import com.homecare.command.EmployeeInfoForm;
import com.homecare.domain.EmployeeInfo;
import com.homecare.utility.DateUtility;

@Controller
public class EmployeeController extends BaseFormController{
	private Log logger = LogFactory.getLog(EmployeeController.class);
	@Autowired
	private IEmployeeInfoBO employeeInfoBO;
	
	@InitBinder
	public void initBinder(final WebDataBinder binder){
		final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/getSelectedEmployeeInfo")
	public ModelAndView getSelectedEmployeeInfo(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		employeeInfoForm.getEmployeeInfo().setLastName(employeeInfoForm.getSelectedEmployeeLastName());
		EmployeeInfo empInfo = employeeInfoBO.getEmployeeInfo(employeeInfoForm.getEmployeeInfo());
		ModelAndView modelAndView = new ModelAndView("employeeInfo");
		modelAndView.addObject("yesNoList", referenceData().get("yesNoList"));
		employeeInfoForm.setEmployeeInfo(empInfo);
		return modelAndView;
	}
	
	@RequestMapping("/sendEmail")
	public ModelAndView sendEmail(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		String employeeId = httpServletRequest.getParameter("employeeId");
		if(null != employeeId && !StringUtils.isEmpty(employeeId)){
			employeeInfoBO.sendEmail(new Long(employeeId));
		}
		ModelAndView modelAndView = new ModelAndView("employeeReminders");
		return modelAndView;
	}
	
	@RequestMapping("/deleteEmployeeInfo")
	public ModelAndView deleteEmployeeInfo(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		String employeeId = httpServletRequest.getParameter("employeeId");
		ModelAndView modelAndView = new ModelAndView("employeeList");
		List<EmployeeInfo> employeeList = employeeInfoBO.deleteEmployeeInfo(new Long(employeeId));
		modelAndView.addObject("employeeList", employeeList);
		return modelAndView;
	}
	
	@RequestMapping("/getAllEmployees")
	public ModelAndView getAllEmployees(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		EmployeeInfo employeeInfo = employeeInfoForm.getEmployeeInfo();
		employeeInfo.setFirstName(employeeInfoForm.getSelectedEmployeeFirstName());
		employeeInfo.setLastName(employeeInfoForm.getSelectedEmployeeLastName());
		employeeInfo.setStatus(employeeInfoForm.getSelectedStatus());
		List<EmployeeInfo> employeeList = employeeInfoBO.getAllEmployees(employeeInfo);
		ModelAndView modelAndView = new ModelAndView("employeeList");
		modelAndView.addObject("employeeList", employeeList);
		return modelAndView;
	}
	
	@RequestMapping("/loadEmployeeInfo")
	public ModelAndView getEmployeeInfo(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		String employeeId = httpServletRequest.getParameter("employeeId");
		String newEmployee = httpServletRequest.getParameter("newEmployee");
		EmployeeInfo employeeInfo = employeeInfoForm.getEmployeeInfo();
		ModelAndView modelAndView = new ModelAndView("employeeInfo");
		if(null == newEmployee && (null != employeeId && !"".equalsIgnoreCase(employeeId))){
			employeeInfo.setEmployeeId(new Long(employeeId));
			employeeInfo = employeeInfoBO.getEmployeeInfo(employeeInfoForm.getEmployeeInfo());
			employeeInfoForm.setEmployeeInfo(employeeInfo);
		}else{
			employeeInfoForm.setEmployeeInfo(new EmployeeInfo());
		}
		modelAndView.addObject("yesNoList", referenceData().get("yesNoList"));
		
		return modelAndView;
	}
	
	@RequestMapping("/saveEmployeeInfo")
	public ModelAndView saveData(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest) throws Exception{
		EmployeeInfo employeeInfo = employeeInfoForm.getEmployeeInfo();
		List<String> errorList = validateEmployeeData(employeeInfo);
		ModelAndView modelAndView = new ModelAndView("employeeInfo"); 
		modelAndView.addObject("yesNoList", referenceData().get("yesNoList"));
		if(errorList.isEmpty()){
			employeeInfo.setCreateUserId("Dummy User");
			employeeInfoBO.updateEmployeeInfo(employeeInfo);
			employeeInfoForm.setEmployeeSaved("Y");
		}else{
			modelAndView.addObject("errorList",errorList);
		}
		
		return modelAndView;
	}
	
	private List<String> validateEmployeeData(EmployeeInfo employeeInfo){
		List<String> errorList = new ArrayList<String>();
		Properties properties = new Properties();
		try {
		    properties.load(this.getClass().getResourceAsStream("/application.properties"));
		} catch (IOException e) {
			logger.error("Properties File not found");
		}
		
		if(!DateUtility.isDateNullOrBeforeCurrentDate(employeeInfo.getEmploymentDate())){
			errorList.add(properties.getProperty("EMPLOYEMENT_DATE_AFTER_CURRENTDATE_ERROR"));
		}
		
		if(!DateUtility.isDateNullOrBeforeCurrentDate(employeeInfo.getInitialCompetencyEvaluation())){
			errorList.add(properties.getProperty("INITIAL_COMPETENCY_AFTER_CURRENTDATE_ERROR"));
		}
		
		if(!DateUtility.compareDates(employeeInfo.getInitialCompetencyEvaluation(), employeeInfo.getEmploymentDate())){
			errorList.add(properties.getProperty("INITIAL_COMPETENCY_AFTER_EMPLOYMENT_DATE_ERROR"));
		}
		
		if(!DateUtility.isDateNullOrBeforeCurrentDate(employeeInfo.getOngoinCompetencyEvaluation())){
			errorList.add(properties.getProperty("ONGOING_COMPETENCY_AFTER_CURRENTDATE_ERROR"));
		}
		
		if(!DateUtility.isDateNullOrBeforeCurrentDate(employeeInfo.getAnnualEvaluation())){
			errorList.add(properties.getProperty("ANNUAL_EVALUATION_AFTER_CURRENTDATE_ERROR"));
		}
		return errorList;
	}
	
	
	@RequestMapping("/getReminders")
	public ModelAndView getReminders(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		Map<String,EmployeeInfo> employeeRemindersMap = employeeInfoBO.getAllReminders();
		ModelAndView modelAndView = new ModelAndView("employeeReminders"); 
		modelAndView.addObject("employeeReminders", employeeRemindersMap);
		return modelAndView;
	}
	
	@RequestMapping("/getRemindersByEmployee")
	public ModelAndView getRemindersByEmployee(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		Map<String,EmployeeInfo> employeeRemindersMap = employeeInfoBO.getRemindersByEmployee(new Long(httpServletRequest.getParameter("employeeId")));
		ModelAndView modelAndView = new ModelAndView("employeeReminders"); 
		modelAndView.addObject("employeeReminders", employeeRemindersMap);
		return modelAndView;
	}

	@RequestMapping("/emailAllReminders")
	public ModelAndView emailAllReminders(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		employeeInfoBO.generatePDFAndEmailForAllActiveEmployees();
		return getReminders(employeeInfoForm, httpServletRequest);
	}
}

