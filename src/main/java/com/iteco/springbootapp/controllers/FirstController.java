package com.iteco.springbootapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    @RequestMapping("/")
    @ResponseBody
    public String getString() {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!DOCTYPE html>\n");
        responseBuilder.append("<html>\n");
        responseBuilder.append("<head>\n");
        responseBuilder.append("<script>\n");
        responseBuilder.append("const userAction = async () => {\n" +
                "  const response = await fetch('http://localhost:8080/', {\n" +
                "    method: 'POST',\n" +
                "    body: document.getElementById('txt').value, \n" +
                "  });\n" +
                "}\n");
        responseBuilder.append("</script>\n");
        responseBuilder.append("</head>\n");
        responseBuilder.append("<input id='txt' type='text' size='100' />\n");
        responseBuilder.append("<br />\n");
        responseBuilder.append("<button type='submit' onclick='userAction()'>");
        responseBuilder.append("send");
        responseBuilder.append("</button>\n");
        responseBuilder.append("</html>");
        return responseBuilder.toString();
    }
}
