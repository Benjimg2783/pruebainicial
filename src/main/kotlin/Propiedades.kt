import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.FileReader
import java.util.*
import kotlin.IllegalArgumentException

class Propiedades(
    user:String,
    password:String,
    server:String,
    port:String
) {
    val prop= Properties()
    var user=user
        set(value) {
            if(user.isEmpty()) throw IllegalArgumentException()
            if(user.isBlank()) throw IllegalArgumentException()
            field = value
        }
    init {
        this.user=user
        prop.setProperty("user",this.user)
    }
    var password=password
        set(value) {
            if(password.isEmpty()) throw IllegalArgumentException()
            if(password.isBlank()) throw IllegalArgumentException()
            var nuevoValor=""
            for (char in value){
                nuevoValor += Char( char.code + 3)
            }
            field = nuevoValor
        }
    init {
        this.password=password
        prop.setProperty("password",this.password)
    }
    var server=server
        set(value) {
            if(server.isEmpty()) throw IllegalArgumentException()
            if(server.isBlank()) throw IllegalArgumentException()
            field = value
        }
    init {
        this.server=server
        prop.setProperty("server",this.server)
    }
    var port=port
        set(value) {
            if(port.isEmpty()) throw IllegalArgumentException()
            if(port.isBlank()) throw IllegalArgumentException()
            field = value
        }
    init {
        this.port=port
        prop.setProperty("port",this.port)
    }


    val ruta=System.getProperty("user.dir")+System.getProperty("file.separator")+"resources"+
            System.getProperty("file.separator")+"configuracion.conf"
    fun introducirValorClave(key:String,newVal:String){
        if (key=="password"){
            println("dime la notraseña actual")
            val contrasenya = readln()
            var contrasenyaCifrada=""
            for (char in contrasenya){
                contrasenyaCifrada += Char( char.code + 3)
            }
            if (contrasenyaCifrada==prop.getProperty("password")){
                var nuevoValor=""
                for (char in newVal){
                    nuevoValor += Char( char.code + 3)
                }
                prop.setProperty("password",nuevoValor)
            } else println("La contraseña es incorrecta")
            }

        else prop.setProperty(key,newVal)
    }
    fun writeFile(file: File){
        prop.store(FileOutputStream(file),"")
    }
    fun readFile(file: File):String{
        prop.load(FileReader(file))
        val user=prop.getProperty("user")
        val password=prop.getProperty("password")
        val server=prop.getProperty("server")
        val port=prop.getProperty("port")
        return "user: $user \npassword:$password\nserver:$server\nport: $port"
    }
    }