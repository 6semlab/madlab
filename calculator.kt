//gradle dependency
//implementation 'net.objecthunter:exp4j:0.4.8'

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.*
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView
    private lateinit var four: TextView
    private lateinit var five: TextView
    private lateinit var six: TextView
    private lateinit var seven: TextView
    private lateinit var eight: TextView
    private lateinit var nine: TextView
    private lateinit var zero: TextView

    private lateinit var plus: TextView
    private lateinit var minus: TextView
    private lateinit var star: TextView
    private lateinit var slash: TextView
    private lateinit var equals: TextView
    private lateinit var clear: TextView
    private lateinit var result: TextView
    private lateinit var exp: TextView
    private lateinit var dot: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one=findViewById(R.id.one)
        two=findViewById(R.id.two)
        three=findViewById(R.id.three)
        four=findViewById(R.id.four)
        five=findViewById(R.id.five)
        six=findViewById(R.id.six)
        seven=findViewById(R.id.seven)
        eight=findViewById(R.id.eight)
        nine=findViewById(R.id.nine)
        zero=findViewById(R.id.zero)
        equals=findViewById(R.id.equals)
        result=findViewById(R.id.result)
        exp=findViewById(R.id.textView)
        plus=findViewById(R.id.plus)
        minus=findViewById(R.id.minus)
        star=findViewById(R.id.star)
        slash=findViewById(R.id.slash)
        dot=findViewById(R.id.dot)
        clear=findViewById(R.id.clear)

        one.setOnClickListener {
            onPressed("1")
        }
        two.setOnClickListener {
            onPressed("2")
        }
        three.setOnClickListener {
            onPressed("3")
        }
        four.setOnClickListener {
            onPressed("4")
        }
        five.setOnClickListener {
            onPressed("5")
        }
        six.setOnClickListener {
            onPressed("6")
        }
        seven.setOnClickListener {
            onPressed("7")
        }
        eight.setOnClickListener {
            onPressed("8")
        }
        nine.setOnClickListener {
            onPressed("9")
        }
        zero.setOnClickListener {
            onPressed("0")
        }
        plus.setOnClickListener {
            onPressed("+")
        }
        minus.setOnClickListener {
            onPressed("-")
        }
        star.setOnClickListener {
            onPressed("*")
        }
        slash.setOnClickListener {
            onPressed("/")
        }
        dot.setOnClickListener {
            onPressed(".")
        }
        clear.setOnClickListener {
            result.text=""
            exp.text=""

        }
        equals.setOnClickListener {
            try{
                val t=exp.text.toString()
                val e= ExpressionBuilder(t).build()
                val res=e.evaluate().toDouble()
                result.text=res.toString()
            }
            catch (e:Exception){
                result.text="Error"
            }
        }
    }
    fun onPressed(str : String){
        exp.append(str)
    }
}
