
package com.swcguild.contactlistmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
 @Controller
 @RequestMapping("/login")
public class LoginController {
    
     @RequestMapping(method=RequestMethod.GET)
     public void showLoginForm(){
     
     }
   
   
    
}
