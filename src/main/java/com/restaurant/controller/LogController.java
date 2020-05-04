package com.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
	
		Logger logger = LoggerFactory.getLogger(LogController.class);
		 
	    @RequestMapping("/api")
	    public String index() {
	        logger.trace("A TRACE Message");
	        logger.debug("A DEBUG Message");
	        logger.info("An INFO Message");
	        logger.warn("A WARN Message");
	        logger.error("An ERROR Message");
	 
	        return "Check out the Logs to see the output...";
	    }

}
