package com.iteco.mqsender.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class MainController {

    @RequestMapping(path="/", method=GET)
    @ResponseBody
    public String homeGet() {
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
        responseBuilder.append("<body>\n");
        responseBuilder.append("<input id='txt' type='text' size='100' />\n");
        responseBuilder.append("<br />\n");
        responseBuilder.append("<button type='submit' onclick='userAction()'>");
        responseBuilder.append("send");
        responseBuilder.append("</button>\n");
        responseBuilder.append("</body>\n");
        responseBuilder.append("</html>");
        return responseBuilder.toString();
    }

}
