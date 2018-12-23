package org.pk.opennlp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *   Author: purnimakamath
 */
@RestController
@RequestMapping(path="/ff")
@CrossOrigin(origins = "*")
public class Controller {

	@Autowired
	Test_Text_analyser analyser;

	@Bean(initMethod = "init")
	public Test_Text_analyser getAnalyser(){
		return new Test_Text_analyser();
	}

	@GetMapping(path = "analyse")
	public String analyse(@RequestParam(name="start") String text){

		long sTime = System.currentTimeMillis();
		String ret = analyser.findSentiment(text);
		System.out.println((System.currentTimeMillis() - sTime)/1000);
		return ret;

	}
}
