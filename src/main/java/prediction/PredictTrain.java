package prediction;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.api.storage.StatsStorage;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.ui.api.UIServer;
import org.deeplearning4j.ui.stats.StatsListener;
import org.deeplearning4j.ui.storage.FileStatsStorage;
import org.deeplearning4j.ui.storage.InMemoryStatsStorage;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.util.Iterator;

public strictfp class PredictTrain {

    private static Logger log = LoggerFactory.getLogger(PredictTrain.class);

    public static void main(String[] args) {
        trainAndSaveModel(Drugs.alcohol.toString());
    }

    private static void trainAndSaveModel(String fileName) {
        try{
            // Get the dataset using the record reader. CSVRecordReader handles loading/parsing
            int numLinesToSkip = 0;
            char delimiter = ',';
            RecordReader recordReader = new CSVRecordReader(numLinesToSkip,delimiter);

            StringBuilder filePath = new StringBuilder("/src/main/resources/" + fileName + ".data");
            recordReader.initialize(new FileSplit(new File(System.getProperty("user.dir") + filePath)));

            // The RecordReaderDataSetIterator handles conversion to DataSet objects, ready for use in neural network
            int numClasses = 7;     // Number of classes in dataset. In the test dataset we have 7 classes (0..6)
            int batchSize = 1885;    //
            int labelIndex = 12;

            DataSetIterator iterator = new RecordReaderDataSetIterator(recordReader, batchSize, labelIndex, numClasses);
            // Contain all data in batch
            DataSet allData = iterator.next();
            // Shuffle rows
            allData.shuffle();

            SplitTestAndTrain testAndTrain = allData.splitTestAndTrain(0.5);
            DataSet test = testAndTrain.getTest();
            DataSet train = testAndTrain.getTest();

            final int numInputs = 12;
            long seed = 123456;
            double learningRate = 0.0005;
            int iterations = 1;
            int numEpochs = 100;

            // Create and configure the NN model
            log.info("Build model...");
            MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                    .seed(seed)
                    .biasInit(1)
                    .regularization(true).l2(1e-14)
                    .iterations(iterations)
                    .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                    .learningRate(learningRate)
                    .updater(Updater.NESTEROVS)
                    .weightInit(WeightInit.XAVIER)
                    .activation(Activation.RELU)
                    .list()
                    .layer(0, new DenseLayer.Builder()
                            .nIn(numInputs)
                            .nOut(numInputs)
                            .build())
                    .layer(1, new DenseLayer.Builder()
                            .nIn(numInputs)
                            .nOut(numInputs)
                            .build())
                    .layer(2, new DenseLayer.Builder()
                            .nIn(numInputs)
                            .nOut(numInputs)
                            .build())
                    .layer(3, new DenseLayer.Builder()
                            .nIn(numInputs)
                            .nOut(numInputs)
                            .build())
                    .layer(4, new OutputLayer.Builder()
                            .nIn(numInputs)
                            .nOut(7)
                            .activation(Activation.SOFTMAX)
                            .build())
                    .pretrain(false).backprop(true)
                    .build();

            // Run the model
            MultiLayerNetwork model = new MultiLayerNetwork(conf);

            model.init();

            // Start the ui web-server
            UIServer uiServer = UIServer.getInstance();
//            StatsStorage statsStorage = new InMemoryStatsStorage();
            StatsStorage statsStorage = new FileStatsStorage(new File("f"));
            uiServer.attach(statsStorage);
            model.setListeners(new StatsListener(statsStorage));

            // Fit the model with the train data
            Iterator<DataSet> trainIter = train.iterator();
            for ( int n = 0; n < numEpochs; n++)
            {
                while(trainIter.hasNext())
                {
                    model.fit(trainIter.next());
                }
                trainIter = train.iterator();
            }
            String modelName = fileName + ".net";

            // Save model to file
            ModelSerializer.writeModel(model,modelName,true);
//            ModelSerializer.writeModel(model, System);

            // Evaluate model
            evalModel(model, test);

        } catch (Exception e) {
            System.err.println("Exception : " + e.getMessage());
        }
    }

    private static void evalModel(MultiLayerNetwork model, DataSet testData) {
        // Evaluate the model on the test set
        System.err.println("Evaluate model....");
        Evaluation eval = new Evaluation(7);
        INDArray output = model.output(testData.getFeatureMatrix());
        eval.eval(testData.getLabels(), output);

        Iterator<DataSet> testIter = testData.iterator();
        while(testIter.hasNext()){
            DataSet tmp = testIter.next();
            // Array of parameters wothout label(class)
            INDArray features = tmp.getFeatureMatrix();
            INDArray lables = tmp.getLabels();
            INDArray predicted = model.output(features,false);
            System.err.println(predicted);

            eval.eval(lables, predicted);
        }

        System.err.println("Finish...");
        // Print the evaluation statistics
        System.err.println(eval.stats());

        // Some shit... again
        System.exit(0);
    }
}
