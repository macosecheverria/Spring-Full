package com.in28minutes.springboot.myfirstwebapp.login;

// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.ui.ModelMap;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    // private Logger logger = LoggerFactory.getLogger(getClass());

    // @GetMapping("/login")
    // public String login(@RequestParam String name, ModelMap model) {
    // model.put("name", name);

    // logger.info("Request params is {}", name);
    // logger.debug("Wan this printed at debug", name);
    // logger.warn("Wan this printed at debug", name);

    // return "login";
    // }

    @Autowired
    private AuthenticationServices services;

    @GetMapping("/login")
    private String login() {
        return "login";
    }

    @PostMapping("/login")
    public String welcomeLogin(@RequestParam String name, @RequestParam String password, ModelMap model) {

        if (services.authenticate(name, password)) {
            model.put("name", name);
            model.put("password", password);
            model.put("errorMessage", "");
            return "welcome";
        }

        model.put("errorMessage", "Invalid Credential");

        return "login";
    }
}
