package co.simplon.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.crud.model.Foo;

import org.springframework.http.HttpStatus;

@Controller
@RequestMapping("/foos")
class FooController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Foo> findAll() {
		List<Foo> myList = new ArrayList<Foo>();
		
		myList.add(new Foo(1L,"truc"));
		myList.add(new Foo(2L,"bidule"));
		myList.add(new Foo(3L,"machin"));
	    return myList;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
		public String create(@RequestBody Foo resource) {
			String myResource = "mon objet Foo" + resource.toString();
			System.out.println("mon objet Foo" + resource.toString());
	    return myResource;
	}
	
	
	
	
	
	
}