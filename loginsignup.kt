MainActivity.kt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Matcher
import java.util.regex.Pattern
class MainActivity : AppCompatActivity() {

    lateinit var uname:EditText
    lateinit var pwd:EditText
    lateinit var signup:Button
    val re="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#\$%^&*]{8,}$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        uname=findViewById(R.id.username)
        pwd=findViewById(R.id.pwd)
        signup=findViewById(R.id.signup)
        signup.setOnClickListener {
            fetch()
        }

    }
    private fun fetch(){
        var username=uname.text.toString()
        var password=pwd.text.toString()
        if(validate(password)){
            val intent:Intent= Intent(this,loginActivity::class.java)
            val bundle=Bundle()
            bundle.putString("username",username)
            bundle.putString("password",password)
            Toast.makeText(this,"Signup Successful",Toast.LENGTH_SHORT).show()
            intent.putExtras(bundle)
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"Invalid Format",Toast.LENGTH_SHORT).show()
        }
    }
    private fun validate(input:String):Boolean{
        val pattern:Pattern= Pattern.compile(re)
        val matcher:Matcher=pattern.matcher(input)
        return matcher.matches()

    }
}


loginActivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class loginActivity : AppCompatActivity() {
    lateinit var luname: EditText
    lateinit var lpwd: EditText
    lateinit var login: Button
    var count:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        luname=findViewById(R.id.lusername)
        lpwd=findViewById(R.id.lpwd)
        login=findViewById(R.id.login)
        val bundle: Bundle? =intent.extras
        val suname:String?=bundle?.getString("username")
        val spwd:String?=bundle?.getString("password")
        login.setOnClickListener {
            logging(suname,spwd)
        }

    }
    private fun logging(suname:String?,spwd:String?){
        val lu=luname.text.toString()
        val lp=lpwd.text.toString()
        if(lu==suname && lp==spwd){
            val intent:Intent= Intent(this,successlogin::class.java)
            startActivity(intent)
        }
        else{
            count++;
            if(count==3){
                login.isEnabled=false
                Toast.makeText(this,"Attempts Over",Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(this,"Wrong details",Toast.LENGTH_LONG).show()
            }
        }
    }
}
