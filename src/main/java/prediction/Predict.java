package prediction;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public strictfp class Predict {

    static String modelPath = "/home/Jasow/diplom/diplomaProject/";
    //static String modelPath = "D:\\diplomaProject\\";

    /***
     * Predict drug usage for all drugs from list
     *
     * @param inputStr is input String from web form
     * @return List of PredictionResult class contains probability for different classification problems
     */
    public static strictfp List<PredictionResult> getPrediction(String inputStr) {
//        String drugsStr = "alcohol,amphetamin,amyl,benzodiazepine,caffein,canabis,chocolate,cocain,crack,ecstasy,heroin,ketamin,legal_highs,lsd,methadone,mushrooms,nicotine,semer,vsa";
        // TODO: use drugs enum
        // TODO: пагинация и кликхоус, use doker for database
        String drugsStr = "alcohol,amphetamin,amyl,benzodiazepine,caffein";
        String[] drugs = drugsStr.split(",");

        // Get the prediction for all drugs from list
        List<PredictionResult> predictionResult = new ArrayList<>();
        for (int i = 0; i < drugs.length ; i++) {
            // Get raw probability
            INDArray predict = predict(drugs[i], inputStr);

            // Tranform result INDArray to List
            List<Double> tmp = new ArrayList<>();
            for (int j = 0; j < predict.length(); j++) {
                tmp.add(predict.getDouble(j));
            }

            predictionResult.add(new PredictionResult(drugs[i], tmp));
        }

        return predictionResult;
    }

    private static INDArray predict(String drug, String inputStr) {
        INDArray prediction = null;

        try {
            // Get the features array
            String[] strArrData = inputStr.split(",");

            // TODO: use Spring validator!
            if (strArrData.length != 12) {
                throw new Exception("Count of features not equal to 12!");
            }

            // Parse input string to double array
            // Nd4j.create have only constructor with double[] and float[]
            double[] arrData = new double[strArrData.length];
            for (int i = 0; i < strArrData.length; i++) {
                arrData[i] = Double.parseDouble(strArrData[i]);
            }
            INDArray data = Nd4j.create(arrData);

            // Load model
            //  TODO: check if the model is exists else create it with PredictTrain.
            File modelFile = new File(modelPath + drug + ".net");
            MultiLayerNetwork model = ModelSerializer.restoreMultiLayerNetwork(modelFile);

            prediction = model.output(data);

        } catch (Exception e) {
            e.getMessage();
        }

        return prediction;
    }
}
