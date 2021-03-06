package org.focusns.web.console;

import java.util.Properties;

import org.focusns.model.console.User;
import org.focusns.service.auth.AuthenticationException;
import org.focusns.web.helper.PropertyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    private Properties application;

    @RequestMapping("/login")
    public void login(User user, WebRequest webRequest) {
        String username = PropertyHelper.getConsoleUsername(application);
        String password = PropertyHelper.getConsolePassword(application);
        if(user.getUsername().equals(username)
                && user.getPassword().equals(password)) {
            //
            webRequest.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        } else {
            throw new AuthenticationException("Username or Password miss matched!");
        }
    }

    @RequestMapping("/logout")
    public String logout(WebRequest webRequest) {
        //
        webRequest.removeAttribute("user", WebRequest.SCOPE_SESSION);
        //
        return "redirect:/console";
    }

}
