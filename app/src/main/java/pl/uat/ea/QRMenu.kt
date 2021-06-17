package pl.uat.ea

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.CompoundBarcodeView
import kotlinx.android.synthetic.main.fragment_q_r_menu.*


class QRMenu : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_q_r_menu)

        startScanButton.setOnClickListener {
            val intentIntegrator = IntentIntegrator(this)
            intentIntegrator.setBeepEnabled(false)
            intentIntegrator.setCameraId(0)
            intentIntegrator.setPrompt("Scan your QRcode")
            intentIntegrator.setBarcodeImageEnabled(false)
            intentIntegrator.setOrientationLocked(false)
            intentIntegrator.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    //Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                    scannedTextView.text = result.contents

                    val resultLC = result.toString().toLowerCase()
                    if(result.contents.startsWith("http://") ||
                            result.contents.startsWith("https://") ||
                            resultLC.startsWith("www."))
                    {
                        //Toast.makeText(this, "Opening browser ", Toast.LENGTH_LONG).show()
                        val intent = Intent(this@QRMenu, WebView::class.java)
                        intent.putExtra("URL", result.contents)
                        startActivity(intent)
                    }
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}
