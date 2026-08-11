import java.net.ServerSocket
import java.net.Socket
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

def puerto = 9999
println "Servidor esperando en el puerto $puerto..."

// 1. Crear el ServerSocket
ServerSocket servidor = new ServerSocket(puerto)

// 2. Aceptar una conexión (se bloquea hasta que alguien conecte)
Socket cliente = servidor.accept()
println "Cliente conectado desde ${cliente.inetAddress.hostAddress}"

// 3. Preparar flujos para leer y escribir
BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()))
PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)

// 4. Leer lo que envía el cliente
String mensajeCliente = entrada.readLine()
println "El cliente dice: $mensajeCliente"

// 5. Responder
salida.println "Hola cliente, recibí tu mensaje: $mensajeCliente"

// 6. Cerrar todo (importante para liberar recursos)
cliente.close()
servidor.close()
println "Servidor terminado."