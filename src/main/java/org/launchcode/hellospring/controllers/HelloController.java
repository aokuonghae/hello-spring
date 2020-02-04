package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring";
    }

    //Handles request of form /hello?name=LaunchCode
//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
//    @ResponseBody
//    public String helloQuerry(@RequestParam String name){
//        return "Hello, "+name+"!";
//    }
    @RequestMapping (value="hello", method=RequestMethod.POST)
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String language){
        switch (language) {
            case "French":
                return "Bonjour, " + name + "!";
            case "Spanish":
                return "Hola," + name + "!";
            case "German":
                return "Guten tag," + name + "!";
            case "Russian":
                return "Privet," + name + "!";
            case "Arab":
                return "Salam alaikum," + name + "!";
            default:
                return "Hello," + name + "!";
        }
    }
    @RequestMapping(value="hello/{name}")
    @ResponseBody
    public String helloUrl(@PathVariable String name){
        return "hello"+name;
    }
    @GetMapping("hello")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form method='post'>" + //submit a request to /hello
                "<input type='text' name='name' />" +
                "<select name='language' id='language-select'>\n" +
                "    <option value='French'>French</option>\n" +
                "    <option value='Spanish'>Spanish</option>\n" +
                "    <option value='German'>German</option>\n" +
                "    <option value='Russian'>Russian</option>\n" +
                "    <option value='Arab'>Arab</option>\n" +
                "    <option value='English'>English</option>\n" +
                "</select>" +
                "<input type='submit' value='Greet me!'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
