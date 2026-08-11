import java.net.Socket
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

def servidorIP = "127.0.0.1"  // localhost
def puerto = 9999

println "Conectando al servidor en $servidorIP:$puerto..."

// 1. Crear el socket y conectar
Socket cliente = new Socket(servidorIP, puerto)

// 2. Preparar flujos
BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()))
PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)

// 3. Enviar un mensaje
salida.println "Hola servidor, soy el cliente"

// 4. Leer la respuesta del servidor
String respuesta = entrada.readLine()
println "El servidor responde: $respuesta"

// 5. Cerrar
cliente.close()
println "Cliente terminado."