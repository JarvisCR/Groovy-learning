def nombres = ["Ana", "Luis", "María", "Carlos", "Sofía"]

def nombres_largos = nombres.findAll { it.size() > 4}

println(nombres_largos)