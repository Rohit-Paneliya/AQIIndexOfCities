package com.example.letsstart.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.letsstart.databinding.ActivityMainBinding
import com.example.letsstart.ui.adapters.CityListAdapter
import com.example.letsstart.util.AppConstants.getAQIColorBasedOnIndex
import com.example.letsstart.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

//    private val TAG = "-----------MainActivity"
//    private lateinit var webSocketListener: WebSocketListener
//    private val okHttpClient = OkHttpClient()
//    private var webSocket: WebSocket? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //Livedata observer
        mainViewModel.viewState.observe(this) {
            binding.citiesWithAQIRecyclerview.apply {
                val aqiListWithCities = it.getAQIColorBasedOnIndex()
                adapter = CityListAdapter(aqiListWithCities)
                setHasFixedSize(true)
            }
        }

        //Call for AQI Info for cities.
        mainViewModel.getAllCitiesWithAQIInfo()

//        initWebSocket()
    }

    /*private fun initWebSocket() {
        webSocketListener = WebSocketListener(mainViewModel)

        mainViewModel.socketStatus.observe(this) {
            val status = if (it) "Connected" else "Disconnected"
            Log.d(TAG, "socketStatus: $status")
        }

        var text = ""
        mainViewModel.messages.observe(this) {
            text += "${if (it.first) "You: " else "Other: "} ${it.second}\n"

            Log.d(TAG, "socketMessage: $text")
        }

        findViewById<Button>(R.id.connectButton).setOnClickListener {
            webSocket = okHttpClient.newWebSocket(createRequest(), webSocketListener)
        }

        findViewById<Button>(R.id.disconnectButton).setOnClickListener {
            webSocket?.close(1000, "Canceled manually.")
        }

        findViewById<Button>(R.id.sendMessageButton).setOnClickListener {
            webSocket?.send("Hello")
            mainViewModel.addMessage(Pair(true, "Hello"))
        }
    }

    private fun createRequest(): Request {
        val websocketURL = "wss://city-ws.herokuapp.com/"

        return Request.Builder()
            .url(websocketURL)
            .build()
    }

    override fun onDestroy() {
        super.onDestroy()
        okHttpClient.dispatcher.executorService.shutdown()
    }*/
}