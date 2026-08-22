import com.sun.net.httpserver.HttpServer
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpExchange
import java.net.InetSocketAddress
import java.util.concurrent.Executors

// Puerto donde escuchará
def port = 8080

// Crear el servidor
def server = HttpServer.create(new InetSocketAddress(port), 0)

// Definir rutas y sus manejadores
server.createContext('/', { HttpExchange exchange ->
    def response = "Hola desde el puerto $port!"
    exchange.sendResponseHeaders(200, response.length())
    exchange.responseBody.write(response.bytes)
    exchange.responseBody.close()
} as HttpHandler)

server.createContext('/saludo', { HttpExchange exchange ->
    def response = "¡Hola mundo!"
    exchange.sendResponseHeaders(200, response.length())
    exchange.responseBody.write(response.bytes)
    exchange.responseBody.close()
} as HttpHandler)

server.createContext('/saludo/', { HttpExchange exchange ->
    // Extraer el nombre de la URL: /saludo/Ana
    def path = exchange.requestURI.path
    def nombre = path.replace('/saludo/', '')
    if (nombre) {
        def response = "¡Hola $nombre!"
        exchange.sendResponseHeaders(200, response.length())
        exchange.responseBody.write(response.bytes)
    } else {
        exchange.sendResponseHeaders(400, 0) // Bad Request
    }
    exchange.responseBody.close()
} as HttpHandler)

// Configurar y arrancar
server.setExecutor(Executors.newCachedThreadPool())
server.start()

println "Servidor corriendo en http://localhost:$port"
println "Presiona Enter para detener..."
System.in.read()
server.stop(0)
println "Servidor detenido"