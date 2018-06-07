package controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entity.PersonalData;
import prediction.Chart;
import prediction.Predict;
import prediction.PredictionResult;
import service.TrainigDataDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: rework controller
@Controller
public class MainController {

    @Autowired
    private TrainigDataDaoImpl service;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String welcome(Model model) {
        return "welcome2";
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

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test() {

        return "testGraph";
    }
//    This case works 2
//    public String test(ModelMap model) {
//        TrainigDataDaoImpl service = new TrainigDataDaoImpl();
//        List<PersonalData> all = service.getAll();
//        model.put("list", all);
//        return "trainingData";
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/test2")
    public String test2(ModelMap model){
        String str = "0.49788,0.48246,-0.05921,0.96082,0.12600,0.31287,-0.57545,-0.58331,-0.91699,-0.00665,-0.21712,-1.18084";

        List<PredictionResult> predictionResult = Predict.getPrediction(str);

//      GRAPH
//      Data for graph;
        Gson gsonObj = new Gson();
        Map<Object,Object> map = null;
        List<Chart> charts = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

            int j = 0;
            for (Double d : predictionResult.get(i).getRawProbability()) {
                map = new HashMap<Object,Object>();
                map.put("label", "CL" + Integer.toString(j));
                map.put("y", d);
                list.add(map);
                j++;
            }

            Chart chart = new Chart();
            chart.setContainer("chartContainer"+i);
            chart.setDatapoints(gsonObj.toJson(list));
            chart.setTitle(predictionResult.get(i).getDrug());

            charts.add(chart);
        }

        model.addAttribute("charts", charts);

        return "prediction2";
    }
}
