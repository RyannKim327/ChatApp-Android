package a

import android.app.Activity
import android.os.Bundle
import android.content.SharedPreferences
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView

class a : Activity() {
	lateinit var prefs: SharedPreferences
	var PREF: String = "mpop.revii.chatapp.PREFERENCES"

	var USERNAME: String = "mpop.revii.chatapp.USERNAME"
	var PASSWORD: String = "mpop.revii.chatapp.PASSWORD"

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		prefs = getSharedPreferences(PREF, MODE_PRIVATE)

		if(prefs.getString(USERNAME, "") == "" || prefs.getString(PASSWORD, "") == ""){
			loginpanel()
		}else{
			chatapp_start()
		}
	}
	fun loginpanel(){
		val base = LinearLayout(this)
		val username = EditText(this)
		val password = EditText(this)
		val login = Button(this)

		base.orientation = LinearLayout.VERTICAL
		base.gravity = Gravity.CENTER

		username.setSingleLine()
		password.setSingleLine()

		password.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD

		username.hint = "Username"
		password.hint = "Password"
		login.text = "Login or Register"

		base.addView(username)
		base.addView(password)
		base.addView(login)

		setContentView(base)
	}
	fun chatapp_start(){
		val base = LinearLayout(this)
		val chats = ListView(this)
		setContentView(base)
	}
}