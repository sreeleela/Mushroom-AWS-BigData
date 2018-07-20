import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.ml.feature.{StringIndexer, RFormula}
import org.apache.spark.ml.classification.RandomForestClassifier
import org.apache.spark.ml.feature.Binarizer
import org.apache.spark.sql.functions._
import org.apache.log4j.LogManager

object MySimpleApp {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SimpleApplication")

    val spark = SparkSession.builder().config(conf).getOrCreate()

    val log = LogManager.getRootLogger
    log.info("Start")
    if (args.length < 1) {
      log.error("Missing argument")
      return
    }
    val inputFile = args(0)
    val outputFileModel = args(1)
    val outputFileCM = args(2)

      val manualSchema = new StructType(Array(
      new StructField("Classification", StringType, true),
      new StructField("cap_shape", StringType, true),
      new StructField("cap_surface", StringType, true),
      new StructField("cap_color", StringType, true),
      new StructField("bruises", StringType, true),
      new StructField("odor", StringType, true),
      new StructField("gill_attachment", StringType, true),
      new StructField("gill_spacing", StringType, true),
      new StructField("gill_size", StringType, true),
      new StructField("gill_color", StringType, true),
      new StructField("stalk_shape", StringType, true),
      new StructField("stalk_root", StringType, true),
      new StructField("stalk_surface_above_ring", StringType, true),
      new StructField("stalk_surface_below_ring", StringType, true),
      new StructField("stalk_color_above_ring", StringType, true),
      new StructField("stalk_color_below_ring", StringType, true),
      new StructField("veil_type", StringType, true),
      new StructField("veil_color", StringType, true),
      new StructField("ring_number", StringType, true),
      new StructField("ring_type", StringType, true),
      new StructField("spore_print_color", StringType, true),
      new StructField("population", StringType, true),
      new StructField("habitat", StringType, true)
    ))
    val data = spark.read.format("csv").schema(manualSchema).option("header","true").option("inferSchema","true").load(inputFile)
    data.show()

    val indexer1 = new StringIndexer().setInputCol("cap_shape").setOutputCol("cap_shapeIndex").setHandleInvalid("skip").fit(data).transform(data)
    val indexer2 = new StringIndexer().setInputCol("cap_surface").setOutputCol("cap_surfaceIndex").setHandleInvalid("skip").fit(indexer1).transform(indexer1)
    val indexer3 = new StringIndexer().setInputCol("cap_color").setOutputCol("cap_colorIndex").setHandleInvalid("skip").fit(indexer2).transform(indexer2)
    val indexer4 = new StringIndexer().setInputCol("bruises").setOutputCol("bruisesIndex").setHandleInvalid("skip").fit(indexer3).transform(indexer3)
    val indexer5 = new StringIndexer().setInputCol("odor").setOutputCol("odorIndex").setHandleInvalid("skip").fit(indexer4).transform(indexer4)
    val indexer6 = new StringIndexer().setInputCol("gill_attachment").setOutputCol("gill_attachmentIndex").setHandleInvalid("skip").fit(indexer5).transform(indexer5)
    val indexer7 = new StringIndexer().setInputCol("gill_spacing").setOutputCol("gill_spacingIndex").setHandleInvalid("skip").fit(indexer6).transform(indexer6)
    val indexer8 = new StringIndexer().setInputCol("gill_size").setOutputCol("gill_sizeIndex").setHandleInvalid("skip").fit(indexer7).transform(indexer7)
    val indexer9 = new StringIndexer().setInputCol("gill_color").setOutputCol("gill_colorIndex").setHandleInvalid("skip").fit(indexer8).transform(indexer8)
    val indexer10 = new StringIndexer().setInputCol("stalk_shape").setOutputCol("stalk_shapeIndex").setHandleInvalid("skip").fit(indexer9).transform(indexer9)
    val indexer11 = new StringIndexer().setInputCol("stalk_root").setOutputCol("stalk_rootIndex").setHandleInvalid("skip").fit(indexer10).transform(indexer10)
    val indexer12 = new StringIndexer().setInputCol("stalk_surface_above_ring").setOutputCol("stalk_surface_above_ringIndex").setHandleInvalid("skip").fit(indexer11).transform(indexer11)
    val indexer13 = new StringIndexer().setInputCol("stalk_surface_below_ring").setOutputCol("stalk_surface_below_ringIndex").setHandleInvalid("skip").fit(indexer12).transform(indexer12)
    val indexer14 = new StringIndexer().setInputCol("stalk_color_above_ring").setOutputCol("stalk_color_above_ringIndex").setHandleInvalid("skip").fit(indexer13).transform(indexer13)
    val indexer15 = new StringIndexer().setInputCol("stalk_color_below_ring").setOutputCol("stalk_color_below_ringIndex").setHandleInvalid("skip").fit(indexer14).transform(indexer14)
    val indexer16 = new StringIndexer().setInputCol("veil_type").setOutputCol("veil_typeIndex").setHandleInvalid("skip").fit(indexer15).transform(indexer15)
    val indexer17 = new StringIndexer().setInputCol("veil_color").setOutputCol("veil_colorIndex").setHandleInvalid("skip").fit(indexer16).transform(indexer16)
    val indexer18 = new StringIndexer().setInputCol("ring_number").setOutputCol("ring_numberIndex").setHandleInvalid("skip").fit(indexer17).transform(indexer17)
    val indexer19 = new StringIndexer().setInputCol("ring_type").setOutputCol("ring_typeIndex").setHandleInvalid("skip").fit(indexer18).transform(indexer18)
    val indexer20 = new StringIndexer().setInputCol("spore_print_color").setOutputCol("spore_print_colorIndex").setHandleInvalid("skip").fit(indexer19).transform(indexer19)
    val indexer21 = new StringIndexer().setInputCol("population").setOutputCol("populationIndex").setHandleInvalid("skip").fit(indexer20).transform(indexer20)
    val finaldata = new StringIndexer().setInputCol("habitat").setOutputCol("habitatIndex").setHandleInvalid("skip").fit(indexer21).transform(indexer21)

    val examFormula = new RFormula().setFormula("Classification ~ cap_shapeIndex+cap_surfaceIndex+cap_colorIndex+bruisesIndex+odorIndex+gill_attachmentIndex+gill_spacingIndex+gill_sizeIndex+gill_colorIndex+stalk_shapeIndex+stalk_rootIndex+stalk_surface_above_ringIndex+stalk_surface_below_ringIndex+stalk_color_above_ringIndex+stalk_color_below_ringIndex+veil_typeIndex+veil_colorIndex+ring_numberIndex+ring_typeIndex+spore_print_colorIndex+populationIndex+habitatIndex")
    val fittedRF = examFormula.fit(finaldata)
    val preparedDF = fittedRF.transform(finaldata)

    val splits = preparedDF.randomSplit(Array(0.7, 0.3))
    val (trainingData, testData) = (splits(0), splits(1))

    val rf = new RandomForestClassifier().setLabelCol("label").setFeaturesCol("features").setFeatureSubsetStrategy("auto")//.setMaxBins(30).setMaxDepth(10).setNumTrees(10).setSeed(4305).setImpurity("gini").setFeatureSubsetStrategy("auto")
    val model = rf.fit(trainingData)
    model.write.overwrite().save(outputFileModel)

    print(model.toDebugString)

    var predictions = model.transform(testData)
    //predictions.toDF().show(900)

    val binarizer: Binarizer = new Binarizer().
      setInputCol("prediction").
      setOutputCol("binarized_prediction").
      setThreshold(0.5)
    val predictionBinary = binarizer.transform(predictions)
    //predictionBinary.select("label","features","prediction","binarized_prediction").show
    val wrongPredictions = predictionBinary.where(expr("label != binarized_prediction"))
    //wrongPredictions.select("label","features","prediction","binarized_prediction").show

    val countErrors = wrongPredictions.groupBy("label").agg(count("prediction").alias("Errors"))
    countErrors.show()
    var fp = 0.0
    var fn = 0.0
    var checkfp = countErrors.select("Errors").where("label = 1.0")
    if(!(checkfp.head(1).isEmpty)){fp = countErrors.select("Errors").where("label = 1.0").head().getLong(0)}
    if((checkfp.head(1).isEmpty)){fp = 0}
    var checkfn = countErrors.select("Errors").where("label = 0.0")
    if(!(checkfn.head(1).isEmpty)){fn = countErrors.select("Errors").where("label = 0.0").head().getLong(0)}
    if((checkfn.head(1).isEmpty)){fn = 0}
    println("False Positive(fp): "+fp)
    println("False Negative(fn): "+fn)

    val correctPredictions = predictionBinary.where(expr("label == binarized_prediction"))
    val countCorrectPredictions = correctPredictions.groupBy("label").agg(count("prediction").alias("Correct"))
    countCorrectPredictions.show()
    var tp = 0.0
    var tn = 0.0
    var checktp = countCorrectPredictions.select("Correct").where("label = 0.0")
    if(!(checktp.head(1).isEmpty)){tp = countCorrectPredictions.select("Correct").where("label = 0.0").head().getLong(0)}
    if((checktp.head(1).isEmpty)){tp = 0}
    var checktn = countCorrectPredictions.select("Correct").where("label = 1.0")
    if(!(checktn.head(1).isEmpty)){tn = countCorrectPredictions.select("Correct").where("label = 1.0").head().getLong(0)}
    if((checktn.head(1).isEmpty)){tn = 0}
    println("True Positive(tp): "+tp)
    println("True Negative(tn): "+tn)

    val confusionMatrix = spark.sparkContext.parallelize(Seq((tp,fp),(fn,tn)))
    val cm = spark.createDataFrame(confusionMatrix).toDF("y_is_0","y_is_1")
    cm.write.mode("overwrite").save(outputFileCM)
    cm.show
    log.info("End")

  }
}