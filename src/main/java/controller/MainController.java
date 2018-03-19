package controller;

import survey.Survey;
import entity.PersonalData;
import service.TrainigDataDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

// TODO: rework controller
@Controller
public class MainController {

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

        TrainigDataDaoImpl service = new TrainigDataDaoImpl();

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
    public String showTestForm() {
        return "test";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/survey")
    public String parseTest(@ModelAttribute("SpringWeb")Survey survey, ModelMap model) {
        model.addAttribute("testField", survey.getField());

        return "testRes";
    }
}
