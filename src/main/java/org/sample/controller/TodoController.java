package org.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.sample.dao.TodoDao;
import org.sample.model.Todo;
import org.sample.constants.ApiConstants.TodoConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "Todo")
@Transactional
public class TodoController {

	@Autowired
	TodoDao todoDao;

	@RequestMapping(value = TodoConst.LIST, method = RequestMethod.GET)
	public ModelAndView listTodos() {
		return new ModelAndView("TodoList", "todos", todoDao.list());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getTodo(@PathVariable("id") Integer id) {
		Todo todo = todoDao.read(id);
		
		return new ModelAndView("TodoUpdate", "todo", todo);
	}
	
	@RequestMapping(value= "/update", method = RequestMethod.POST)
	public ModelAndView updateTodo(@ModelAttribute Todo todo){
		todoDao.update(todo);
		return redirectToHomePage();
	}

	@RequestMapping(value = TodoConst.ADD, method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("TodoCreate", "todo", new Todo());
	}

	@RequestMapping(value = TodoConst.ADD, method = RequestMethod.POST)
	public ModelAndView addTodo(@ModelAttribute Todo todo,
			HttpServletRequest req) {
		todoDao.create(todo);
		return redirectToHomePage();
	}

	@RequestMapping(value = TodoConst.DELETE, method = RequestMethod.GET)
	public ModelAndView deleteTodo(@PathVariable("id") Integer id) {
		todoDao.delete(id);
		return redirectToHomePage();

	}

	private ModelAndView redirectToHomePage() {
		return new ModelAndView("redirect:/Todo/TodoManagement");
	}

	@RequestMapping(value = "/TodoManagement")
	private String redirect() {
		return "TodoManagement";
	}
}
