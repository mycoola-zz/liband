package com.libandexample.courses.udemy.Kotlin.getsunset

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.libandexample.R
import kotlinx.android.synthetic.main.activity_main_getsunset.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class GetSunSetMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_getsunset)
    }


    @SuppressLint("OnClick")
    protected fun GetSunset(view: View) {

        val city = etCityName.text.toString()
        val url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" + city + "%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys"
        MyAsyncTask().execute(url)
    }

    inner class MyAsyncTask : AsyncTask<String, String, String>() {

        override fun onPreExecute() {
            //Before task started
        }

        override fun doInBackground(vararg p0: String?): String {
            try {

                val url = URL(p0[0])

                val urlConnect = url.openConnection() as HttpURLConnection
                urlConnect.connectTimeout = 7000

                val inString = ConvertStreamToString(urlConnect.inputStream)
                //Cannot access to ui
                publishProgress(inString)
            } catch (ex: Exception) {
            }


            return " "

        }

        override fun onProgressUpdate(vararg values: String?) {
            try {
                val json = JSONObject(values[0])
                val query = json.getJSONObject("query")
                val results = query.getJSONObject("results")
                val channel = results.getJSONObject("channel")
                val astronomy = channel.getJSONObject("astronomy")
                val sunrise = astronomy.getString("sunrise")
                tvSunSetTime.text = " Sunrise time is " + sunrise


            } catch (ex: Exception) {
            }
        }

        override fun onPostExecute(result: String?) {

            //after task done
        }


    }


    fun ConvertStreamToString(inputStream: InputStream): String {

        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        var line: String
        var AllString = ""

        try {
            do {
                line = bufferReader.readLine()
                if (line != null) {
                    AllString += line
                }
            } while (line != null)
            inputStream.close()
        } catch (ex: Exception) {
        }



        return AllString
    }


}
