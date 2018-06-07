package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import prediction.Chart;
import prediction.Predict;
import prediction.PredictionResult;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PredictionController {
    @RequestMapping(method = RequestMethod.GET, value = "/getPrediction")
    public String prediction() {
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getPrediction")
    public String getPrediction(@RequestParam String inputStr, ModelMap model) {
        List<PredictionResult> predictionResult = Predict.getPrediction(inputStr);

//      TODO: save input data in DB
//        model.addAttribute("result", predictionResult);
//
//      GRAPH
//      Data for graphhart;
        Gson gsonObj = new Gson();
        Map<Object,Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
        List<Chart> charts = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            System.err.println(predictionResult.get(0).getRawProbability());
            System.err.println(predictionResult.get(1).getRawProbability());

            List<Double> probability = predictionResult.get(i).getRawProbability();
            for(int j = 0; j < probability.size(); j++) {
                map = new HashMap<Object, Object>();
                map.put("label", "CL" + Integer.toString(j));
                map.put("y", probability.get(i));
                list.add(map);
            }

//            for (Double d : predictionResult.get(i).getRawProbability()) {
//                map = new HashMap<Object,Object>();
//                map.put("label", "CL" + Integer.toString(j));
//                map.put("y", d);
//                list.add(map);
//                j++;
//            }

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
