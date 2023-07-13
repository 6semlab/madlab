//Permissions in manifest file
//<uses-permission android:name="android.permission.WRITE_CONTACTS"/>
//<uses-permission android:name="android.permission.READ_CONTACTS"/>
//<uses-permission android:name="android.permission.CALL_PHONE"/>


import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView

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
    private lateinit var star: TextView
    private lateinit var hash: TextView
    private lateinit var call: TextView
    private lateinit var clear: TextView
    private lateinit var number: TextView
    private lateinit var save: TextView
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
        call=findViewById(R.id.call)
        number=findViewById(R.id.number)
        save=findViewById(R.id.save)
        star=findViewById(R.id.star)
        hash=findViewById(R.id.hash)
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
        star.setOnClickListener {
            onPressed("*")
        }
        hash.setOnClickListener {
            onPressed("/")
        }
        clear.setOnClickListener {
            number.text= number.text.toString().substring(0, number.text.length - 1);
        }
        call.setOnClickListener {
            var intent=Intent(Intent.ACTION_DIAL)
            var info= Uri.parse("tel: "+number.text)
            intent.data=info
            startActivity(intent)
        }
        save.setOnClickListener {
            var intent=Intent(ContactsContract.Intents.Insert.ACTION)
            intent.type=ContactsContract.RawContacts.CONTENT_TYPE
            intent.putExtra(ContactsContract.Intents.Insert.PHONE,number.text)
            startActivity(intent)
        }
    }
    fun onPressed(str:String){
        number.append(str)
    }
}
