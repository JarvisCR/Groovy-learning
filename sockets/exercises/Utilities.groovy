import java.util.Scanner

class Utilities {
    static def InputGroovy(String msg) {
        def scanner = new Scanner(System.in)
        print msg
        return scanner.nextLine()
    }
    
    // Puedes agregar más funciones aquí
    static def imprimirLinea(String msg) {
        println "=" * 50
        println msg
        println "=" * 50
    }
}