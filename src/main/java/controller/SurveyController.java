package controller;

import entity.Survey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SurveyController {

    @RequestMapping(method = RequestMethod.GET, value = "/survey")
    public String showTestForm(Model model) {
        model.addAttribute("survey", new Survey());
        List<Integer> tmp = new ArrayList<>();
        tmp.add(-2);
        tmp.add(-1);
        tmp.add(0);
        tmp.add(1);
        tmp.add(2);

        model.addAttribute("testItem", tmp);
        return "survey";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/survey")
    public String parseTest(@ModelAttribute("SpringWeb")Survey survey, ModelMap model) {
        model.addAttribute("survey", survey);

        return "surveyRes";
    }
}
