import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var input_text: EditText
    private lateinit var speak : Button
    private lateinit var texttospeech : TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        speak = findViewById(R.id.speak)
        input_text = findViewById(R.id.input_text)
        texttospeech = TextToSpeech(this,this)
        speak.setOnClickListener { converttospeech() }
    }

    override fun onInit(status: Int)
    {
        if(status==TextToSpeech.SUCCESS)
        {
            val result = texttospeech.setLanguage(Locale.US)
        }
        else
            Log.e("TTS","Failed")
    }

    private fun converttospeech()
    {
        val text = input_text.text.toString()
        texttospeech.speak(text,TextToSpeech.QUEUE_FLUSH,null," ")
    }

}
