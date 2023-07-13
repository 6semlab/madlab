import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    private lateinit var start: Button
    private lateinit var stop: Button
    private lateinit var reset: Button
    private lateinit var counter: TextView
    var count : Int=0
    val timer = mycounter(1000000000,1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start=findViewById(R.id.startbtn)
        stop=findViewById(R.id.stopbtn)
        reset=findViewById(R.id.resetbtn)
        counter=findViewById(R.id.counterval)

        start.setOnClickListener {
            timer.start()
            start.isEnabled=false
        }
        stop.setOnClickListener {
            timer.cancel()
            start.isEnabled=true
        }
        reset.setOnClickListener {
            count=0
            start.isEnabled=true
            counter.text = (count).toString()
        }

    }
    inner class mycounter (x:Long,y:Long):CountDownTimer(x,y) {
        override fun onTick(millisUntilFinished: Long) {
            count++;
            counter.setText(count.toString())

        }

        override fun onFinish() {
            count=0
            counter.text = "Finished"

        }
    }
}
