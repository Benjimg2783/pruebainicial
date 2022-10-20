import java.io.File

fun main(){
    /*println("Introduce el nombre de usuario")
    var usuario= readln()
    while (usuario.isEmpty()){
        println("El nombre de usuario no puede estar vacio, vuelva a intentarlo")
        usuario= readln()
    }
    println("Introduce la contraseña")
    var contrasenya= readln()
    while (usuario.isEmpty()){
        println("La contraseña no puede estar vacia, vuelva a intentarlo")
        contrasenya= readln()
    }
    println("Introduce el servidor")
    var server= readln()
    while (server.isEmpty()){
        println("El servidor no puede estar vacio, vuelva a intentarlo")
        server= readln()
    }
    println("Introduce el puerto")
    var port= readln()
    while (port.isEmpty()){
        println("El puerto no puede estar vacio, vuelva a intentarlo")
        port= readln()
    }*/
    val newProperties=Propiedades("usuario","hola123","localhost","0")
    val file= File(System.getProperty("user.dir")+System.getProperty("file.separator")+"resources"+
            System.getProperty("file.separator")+"configuracion.conf")
    if (!file.exists()) file.createNewFile()
    newProperties.writeFile(file)
    println(newProperties.readFile(file))
    println("¿Desea modificar algún campo? y/n" )
    var respuesta = readln()
    while(respuesta!="y"&&respuesta!="n"){
        println("respuesta incorrecta, debes introducir y/n")
        respuesta= readln()
    }
    if (respuesta=="y"){
        println("¿Qué campo desea modificar? user/password/server/port")
        var campo = readln()
        while (campo!="user" && campo!="password" && campo!="server" && campo!="port"){
            println("El campo introducido no existe, vuelve a intentarlo. Introduce user/password/server/port")
            campo = readln()
        }
        println("Introduce un nuevo valor para dicho campo")
        var newVal= readln()
        while (newVal.isEmpty()){
            println("El valor del campo no puede estar vacío, vuelve a intentarlo")
            newVal= readln()
        }
        newProperties.introducirValorClave(campo,newVal)
        println("Campo modificado")
    }
    newProperties.writeFile(file)

}