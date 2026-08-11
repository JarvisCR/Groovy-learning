import java.net.ServerSocket
import java.net.Socket
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

def puerto = 8888

// 1. Crear el ServerSocket
ServerSocket servidor = new ServerSocket(puerto)

// 2. Aceptar una conexión (se bloquea hasta que alguien conecte)
println("Esperando en el puerto: $puerto");
Socket cliente = servidor.accept()
println "Cliente conectado desde ${cliente.inetAddress.hostAddress}"

// 3. Preparar flujos para leer y escribir
BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()))
PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)

// 4. Leer lo que envía el cliente
String client_name = entrada.readLine()
println "El cliente dice: $client_name"

// 5. Responder
salida.println "Hola $client_name, bienvenido al servidor Groovy"

// 6. Cerrar todo (importante para liberar recursos)
cliente.close()
servidor.close()
println "Servidor terminado."