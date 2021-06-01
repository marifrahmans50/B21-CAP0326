package com.example.infosungai.ui.camera

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.infosungai.classifier.Classifier
import com.example.infosungai.R
import com.wonderkiln.camerakit.*
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : AppCompatActivity() {

    private var classifier: Classifier? = null

    private val MODEL_PATH = "model.tflite"
    private val QUANT = true
    private val LABEL_PATH = "labels.txt"
    private val IMAGE_SIZE = 224

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        initCameraView()
        initTensorFlowAndLoadModel()

        btnDetectObject.setOnClickListener { cameraView.captureImage() }
    }

    private fun initCameraView() {
        cameraView.addCameraKitListener(object : CameraKitEventListener {
            override fun onEvent(cameraKitEvent: CameraKitEvent) {

            }

            override fun onError(cameraKitError: CameraKitError) {

            }

            override fun onImage(cameraKitImage: CameraKitImage) {

                var bitmap = cameraKitImage.bitmap
                bitmap = Bitmap.createScaledBitmap(bitmap, IMAGE_SIZE, IMAGE_SIZE, false)
                imageViewResult.setImageBitmap(bitmap)

                val results = classifier?.recognizeImage(bitmap)

                var item = ""
                results?.forEach {
                    item += it.title + ": " + String.format("(%.1f%%) ", it.confidence ?: 0f * 100.0f) + "\n"
                }
                textViewResult.text = item

            }

            override fun onVideo(cameraKitVideo: CameraKitVideo) {

            }
        })
    }

    private fun initTensorFlowAndLoadModel() {

        Handler().post {
            try {
                classifier = TensorFlowImageClassifier.create(
                        assets,
                        MODEL_PATH,
                        LABEL_PATH,
                        IMAGE_SIZE,
                        QUANT
                )
                makeButtonVisible()
            } catch (e: Exception) {
                throw RuntimeException("Error initializing TensorFlow!", e)
            }
        }
    }

    private fun makeButtonVisible() {
        runOnUiThread { btnDetectObject.visibility = View.VISIBLE }
    }

    override fun onResume() {
        super.onResume()
        cameraView.start()
    }

    override fun onPause() {
        cameraView.stop()
        super.onPause()
    }
}
