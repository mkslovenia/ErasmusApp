package pl.uat.ea

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.fragment_web_view.*


class WebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_web_view);

        val urlAddress=intent.getStringExtra("URL")

        if (urlAddress != null) {
            webViewSetup(urlAddress)
        }
    }

    private fun webViewSetup(URL: String){
        wb_webView.webViewClient = WebViewClient()

        wb_webView.apply{
            loadUrl(URL)
            settings.javaScriptEnabled = true
        }
    }
}