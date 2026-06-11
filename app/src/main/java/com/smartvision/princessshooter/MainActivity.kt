package com.example.petulanganpermen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowFileAccess = true
            allowContentAccess = true
            loadWithOverviewMode = true
            useWideViewPort = true
            @Suppress("DEPRECATION")
            allowUniversalAccessFromFileURLs = true
        }
        webView.setBackgroundColor(0xFFFFB3D1.toInt())
        webView.visibility = View.INVISIBLE
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                webView.visibility = View.VISIBLE
            }
        }
        webView.loadUrl("file:///android_asset/game.html")
    }
}
