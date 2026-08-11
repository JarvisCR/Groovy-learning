def numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

// 1. Filtrar pares
def pares = numeros.findAll { it % 2 == 0 }
println pares  // [2, 4, 6, 8, 10]

// 2. Transformar: cuadrados
def cuadrados = numeros.collect { it * it }
println cuadrados  // [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]

// 3. Buscar el primer múltiplo de 3
def primero = numeros.find { it % 3 == 0 }
println primero  // 3

// 4. Sumar todos
def total = numeros.sum()
println total  // 55

// 5. Agrupar por par/impar
def agrupados = numeros.groupBy { it % 2 == 0 ? "par" : "impar" }
println agrupados  // [impar:[1,3,5,7,9], par:[2,4,6,8,10]]

// 6. Encadenar operaciones (estilo funcional puro)
def resultado = numeros
    .findAll { it % 2 == 0 }      // pares
    .collect { it * 10 }          // multiplicar por 10
    .sum()                        // sumar todo
println resultado  // 300 (porque 20+40+60+80+100 = 300)