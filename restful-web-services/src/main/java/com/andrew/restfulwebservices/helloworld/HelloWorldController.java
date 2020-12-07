package com.andrew.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {
	
//	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")	
//	 Esta anotación la podemos simplificar con: 
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		//Aunque se creeria que en el navegador se mostrara el resultado del metodo "toString"
		//en realidad se convierte en Json el resultado del "getter" por esto es importante 
		//que este se encuentre definido (getMessage)
 
		return new HelloWorldBean("Hello World Bean!");
		
//		throw new RuntimeException("Some error has happened! Contact support at 123");
// De esta forma podemos generar un error que se captura en el frontend en la parte del error
// del subscribe:
		/*
		 * this.mDtService.runHelloWorldService()
		 * .subscribe(resp=>this.message=resp.message,
		 * mError=>console.log(mError.error.message) );
		 */
	}

	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean("Hello World "+name);
	}
	
}
