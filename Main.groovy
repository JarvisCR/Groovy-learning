// VARIABLES
// Groovy - sin tipo (dinámico)
def nombre = "Ana"
def edad = 30
def lista = [1, 2, 3]  // ArrayList automáticamente

// Groovy - con tipo (estático, como Java)
String apellido = "Pérez"
int anio = 2026










// CONDICIONALES
def nota = 85
if (nota >= 60) {
    println "Aprobado"
} else {
    println "Reprobado"
}

// Bonus: operador ternario igual
def resultado = (nota >= 60) ? "Aprobado" : "Reprobado"











// BUCLES
// Bucle for clásico (como Java)
for (int i = 0; i < 5; i++) {
    println i
}

// Bucle for mejorado (como Java)
def numeros = [10, 20, 30, 40]
for (num in numeros) {
    println num
}

// ESTILO GROOVY (funcional) - MUCHO MÁS CONCISO
numeros.each { println it }  // "it" es el elemento actual

// Con índice
numeros.eachWithIndex { num, idx -> println "Posición $idx: $num" }










// CLASES
// En Java necesitarías ~30 líneas (atributos + getters + setters + constructores)
// En Groovy:
class Persona {
    String nombre
    int edad
    // ¡Eso es todo! Groovy genera getters, setters, constructor por defecto y toString automáticamente
}

// Uso:
def p = new Persona(nombre: "Carlos", edad: 25)  // Constructor con mapas
println p.nombre  // llama a getNombre()
p.edad = 26       // llama a setEdad()
println p         // llama a toString() automático