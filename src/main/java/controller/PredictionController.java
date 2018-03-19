package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import prediction.Predict;
import prediction.PredictionResult;

import java.util.List;

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
        model.addAttribute("result", predictionResult);

        return "prediction";
    }
}
