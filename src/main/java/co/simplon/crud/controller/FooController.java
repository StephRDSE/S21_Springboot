package co.simplon.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

		myList.add(new Foo(1L, "truc"));
		myList.add(new Foo(2L, "bidule"));
		myList.add(new Foo(3L, "machin"));
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Foo read(@PathVariable("id") Long id) {
		return new Foo(id, "fake read");
	}

	@RequestMapping("/test/cookie")
	@ResponseBody
	public String setCookie(HttpServletResponse response) {
		response.addCookie(new Cookie("foo", "bar"));
		return "new cookie has been set" + response.toString();
	}

	@RequestMapping("/test/lecture")
	@ResponseBody
	public String handle(@CookieValue(value = "foo") String cookie) {
		return " voici mon cookie " + cookie;
	}

	@RequestMapping(value = "/test/param", method = RequestMethod.GET) // called with http://localhost:8090/foos/test/param?id=2
	@ResponseBody
	public String param(@RequestParam(value="id", defaultValue="0") int id) {
		return "param with id= " + id;
	}

	@RequestMapping(value = "/test/param2", method = RequestMethod.GET) // called with http://localhost:8090/foos/test/param2?truc=toto&bidule=machin
	@ResponseBody
	public String param(@RequestParam Map<String, String> queryMap) {
		return "param with multiple parameters= " + queryMap.toString();
	}

}