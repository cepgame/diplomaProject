package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import survey.Survey;
import entity.PersonalData;
import service.TrainigDataDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

// TODO: rework controller
@Controller
public class MainController {

    @Autowired
    private TrainigDataDaoImpl service;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String welcome(Model model) {
        return "welcomePage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/inputData")
    public String inputData() {
        return "inputData";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/trainingData")
    public ModelAndView trainingData() {

//        TrainigDataDaoImpl service = new TrainigDataDaoImpl();

        List<PersonalData> all = service.getAll();

        ModelAndView model = new ModelAndView("trainingData");
        model.addObject("list", all);

        return model;
    }
//    This case works 2
//    public String test(ModelMap model) {
//        TrainigDataDaoImpl service = new TrainigDataDaoImpl();
//        List<PersonalData> all = service.getAll();
//        model.put("list", all);
//        return "trainingData";
//    }

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
        return "test";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/survey")
    public String parseTest(@ModelAttribute("SpringWeb")Survey survey, ModelMap model) {
        model.addAttribute("survey", survey);

        return "testRes";
    }
}
