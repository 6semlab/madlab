---------------------------------------------
myxml.xml

<?xml version="1.0" encoding="UTF-8" ?>
<data>
    <city> Mumbai</city>
    <lat>345</lat>
    <long>45</long>
    <temp>28</temp>
    <humid>21</humid>
</data>

----------------------------------------------
myjson.json

{
  "city" : "Bangalore",
  "lat" : "120",
  "long" : "35",
  "temp" : "30",
  "humid" : "21"
}

--------------------------------------------



import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {

    private lateinit var parsexmlbtn : Button
    private lateinit var parsejsonbtn : Button
    private lateinit var cityname : TextView
    private lateinit var latitude : TextView
    private lateinit var longitude : TextView
    private lateinit var temp : TextView
    private lateinit var humidity : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityname = findViewById(R.id.city)
        latitude = findViewById(R.id.latitude)
        longitude = findViewById(R.id.longitude)
        temp = findViewById(R.id.temp)
        humidity = findViewById(R.id.humidity)

        parsexmlbtn=findViewById(R.id.parse_xml)
        parsejsonbtn=findViewById(R.id.parse_json)

        parsejsonbtn.setOnClickListener{ parsejson() }
        parsexmlbtn.setOnClickListener { parsexml() }

    }

    private fun parsexml() {
        val input = assets.open("myxml.xml")
        val docbuild = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        val doc = docbuild.parse(input)

        cityname.text=doc.getElementsByTagName("city_name").item(0).firstChild.nodeValue
        longitude.text=doc.getElementsByTagName("longitude").item(0).firstChild.nodeValue
        latitude.text=doc.getElementsByTagName("latitude").item(0).firstChild.nodeValue
        temp.text=doc.getElementsByTagName("temp").item(0).firstChild.nodeValue
        humidity.text=doc.getElementsByTagName("humidity").item(0).firstChild.nodeValue

    }

    private fun parsejson() {
        val obj = JSONObject(jparse())

        cityname.text=obj.getString("city_name")
        longitude.text=obj.getString("longitude")
        latitude.text=obj.getString("latitude")
        temp.text=obj.getString("temp")
        humidity.text=obj.getString("humidity")


    }

    private fun jparse() : String
    {
        val json : String
        try {
            val input = assets.open("myjson.json")
            val size= input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            val charset : Charset = Charsets.UTF_8
            json = String(buffer,charset)

        }
        catch (ex: IOException)
        {
            return ""
        }
        return json
    }
}
