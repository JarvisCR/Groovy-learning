class Producto {
    def nombre
    def precio
}

def producto = new Producto(nombre: "Laptop", precio: 1200)

println("Precio de $producto.nombre: $producto.precio")