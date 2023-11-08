#hoteles
import string

import random

#lsita de cosas echas:

#tiposDeHabitacion
#Habitaciones
#Hoteles
#promociones
#elementosTipoDeHabitacion
#elementos extra
#tipos de usuario
#usuarios
#bares
#gimansio
#lavanderia
#piscinas
#prestamoUtensilios
#restaurantes
#salidas
#salones
#serviciosInternet
#spas
#supermercados
#tiendas
#productos
#productosSupermercado
#reservasHoteles
#reservasServicios
#consumos

#Lista de cosas no ehchas:




















def random_word(length):
    
    word = ''
    for i in range(length):
        word += random.choice(letters)
    return word

num_reserva = []
for i in range(1,1000):
    num_reserva.append(i)

num_reserva_servicios = []
for i in range(1,20000):
    num_reserva_servicios.append(i)

# Generate a random integer between 0 and 9
random_number = random.randint(0, 9)

# Print the random number
print(random_number)

tipo_habitacion = ["sencilla", "doble", "triple", "suite"]
letters = string.ascii_lowercase
planes = ["todo_incluido", "continental", "desayuno", "sin_alimentacion"]
nombre_elemento = []
usuarios = ["administrador", "cliente", "recepcionista", "gerente"]
ids = ["pasaporte,cedula,tarjeta_de_identidad"]

#tipos de habitacion
for tipos in tipo_habitacion:
    print("INSERT INTO TIPOSHABITACIONES (TIPOHABITACION) VALUES ('"+tipos+"');")


#lista de elementos que se peuden encontrar en una habitacion
for i in range(1,10):
    nombre_elemento.append(random_word(random.randint(5, 10)))



#hoteles
print("INSERT INTO HOTELES (NOMBRE) VALUES ("+"'Hotel de los Andes'"+");")


#habitaciones
for i in range(1,1000):
        print("INSERT INTO HABITACIONES (NUMEROHABITACION,TIPOHABITACION) VALUES ("+str(i)+",'"+tipo_habitacion[random.randint(0, 3)]+"');")

#planes
for plan in planes:
    d_alojamiento = random.uniform(0, 1.0)
    d_comida = random.uniform(0, 1.0)
    d_servicios = random.uniform(0, 1.0)
    costo = random.uniform(100000, 1000000)
    dias_min_estadia = random.randint(1, 14)
    print("INSERT INTO PROMOCIONES (NOMBREPLAN,DESCUENTOALOJAMIENTO,DESCUENTOCOMIDA,DESCUENTOSERVICIOS,COSTO,DIASMINIMAESTADIA) VALUES ('"+plan+"',"+str(d_alojamiento)+","+str(d_comida)+","+str(d_servicios)+","+str(costo)+","+str(dias_min_estadia)+");")

#elementos extra
for ele in nombre_elemento:
    print("INSERT INTO ELEMENTOSEXTRAS (NOMBREELEMENTO) VALUES ('"+ele+"');")

#elementos de tipo de habitacion
for habitacion in tipo_habitacion:
    for i in range(random.randint(1, 3)):
        print("INSERT INTO ELEMENTOSTIPOSHABITACIONES (TIPOHABITACION,NOMBREELEMENTO) VALUES ('"+habitacion+"','"+nombre_elemento[random.randint(0, len(nombre_elemento)-1)]+"');")

#tipo de usuario
for users in usuarios:
    print("INSERT INTO TIPOSUSUARIOS (TIPOUSUARIO) VALUES ('"+users+"');")

#usuarios
for i in range(1,5000):
    print("INSERT INTO USUARIOS (ID,TIPOID,NOMBRE,TIPOUSUARIO,CORREO,HABITACIONES_NUMEROHABITACION) VALUES ("+str(i)+",'"+ids[random.randint(0,len(ids)-1)]+"','"+random_word(random.randint(5, 10))+"','"+usuarios[random.randint(0,len(usuarios)-1)]+"','"+random_word(random.randint(5, 10))+"',"+str(random.randint(1,1000))+");")

#bares
for i in range(1,10):
    print("INSERT INTO BARES (IDTIPOSERVICIO,ESTILO,AFORO,APLICACOMPARTIDO,HOTELES_NOMBRE,COSTORESERVA) VALUES ("+str(i)+",'"+random_word(random.randint(5, 10))+"',"+str(random.randint(20,200))+","+str(random.randint(0,1))+",'Hotel de los Andes',"+str(random.uniform(20000.0,120000.0))+");")

#Gimansio
for i in range(10,14):
    print("INSERT INTO GIMNASIOS (IDTIPOSERVICIO,AFORO,NUMMAQUINAS,HORARIO,APLICACOMPARTIDO,HOTELES_NOMBRE,COSTORESERVA) VALUES ("+str(i)+","+str(random.randint(100,500))+","+str(random.randint(100,800))+",'6am-8pm',"+str(random.randint(0,1))+",'Hotel de los Andes',"+str(random.uniform(20000.0,120000.0))+");")

#lavanderia
for i in range(14,24):
    print("INSERT INTO LAVANDERIAS (IDTIPOSERVICIO,APLICACOMPARTIDO,HOTELES_NOMBRE,AFORO,COSTORESERVA) VALUES ("+str(i)+","+str(random.randint(0,1))+",'Hotel de los Andes',"+str(random.randint(10,30))+","+str(random.uniform(20000.0,120000.0))+");")

#piscinas
for i in range(24,28):
    print("INSERT INTO PISCINAS (IDTIPOSERVICIO,AFORO,PROFUNDIDAD,APLICACOMPARTIDO,HOTELES_NOMBRE,COSTORESERVA) VALUES ("+str(i)+","+str(random.randint(10,40))+","+str(random.uniform(1.0,4.0))+","+str(random.randint(0,1))+",'Hotel de los Andes',"+str(random.uniform(20000.0,120000.0))+");")

#prestamoUtensilios
for i in range(28,32):
    print("INSERT INTO PRESTAMOSUTENSILIOS (IDTIPOSERVICIO,NOMBRE,RETORNADO,HOTELES_NOMBRE) VALUES ("+str(i)+",'"+random_word(random.randint(5, 10))+"',"+str(random.randint(0,1))+",'Hotel de los Andes'"+");")

#restaurantes
for i in range(32,42):
    print("INSERT INTO RESTAURANTES (IDTIPOSERVICIO,ESTILO,AFORO,APLICACOMPARTIDO,HOTELES_NOMBRE,COSTORESERVA) VALUES ("+str(i)+",'"+random_word(random.randint(5, 10))+"',"+str(random.randint(20,200))+","+str(random.randint(0,1))+",'Hotel de los Andes',"+str(random.uniform(20000.0,120000.0))+");")

#salidas
for num in num_reserva:
    print("INSERT INTO SALIDAS (NUMRESERVA,CUENTATOTAL) VALUES ("+str(num)+","+str(random.uniform(400000.0,8000000.0))+");")

#salones
for i in range(42,52):
    print("INSERT INTO SALONES (IDTIPOSERVICIO,EQUIPO,AFORO,APLICACOMPARTIDO,HOTELES_NOMBRE,COSTORESERVA) VALUES ("+str(i)+",'"+random_word(random.randint(5, 10))+"',"+str(random.randint(20,200))+","+str(random.randint(0,1))+",'Hotel de los Andes',"+str(random.uniform(20000.0,120000.0))+");")

#serviciosInternet
for i in range(52,62):
    print("INSERT INTO SERVICIOSINTERNET (IDTIPOSERVICIO,INCLUIDO,APLICACOMPARTIDO,HOTELES_NOMBRE) VALUES ("+str(i)+","+str(random.randint(0,1))+","+str(random.randint(0,1))+",'Hotel de los Andes'"+");")

#spas
for i in range(62,70):
    print("INSERT INTO SPAS (IDTIPOSERVICIO,DURACION,AFORO,APLICACOMPARTIDO,HOTELES_NOMBRE,COSTORESERVA) VALUES ("+str(i)+","+str(random.randint(20,120))+","+str(random.randint(20,200))+","+str(random.randint(0,1))+",'Hotel de los Andes',"+str(random.uniform(20000.0,120000.0))+");")

#supermercados
for i in range(70,80):
    print("INSERT INTO SUPERMERCADOS (IDTIPOSERVICIO,NOMBRE,APLICACOMPARTIDO,HOTELES_NOMBRE) VALUES ("+str(i)+",'"+random_word(random.randint(5, 10))+"',"+str(random.randint(0,1))+",'Hotel de los Andes'"+");")

#tiendas
for i in range(80,100):
    print("INSERT INTO TIENDAS (IDTIPOSERVICIO,NOMBRE,APLICACOMPARTIDO,HOTELES_NOMBRE) VALUES ("+str(i)+",'"+random_word(random.randint(5, 10))+"',"+str(random.randint(0,1))+",'Hotel de los Andes'"+");")

#productos
for i in range(1,1000):
    print("INSERT INTO PRODUCTOS (IDPRODUCTO,NOMBRE,COSTO,APLICAINCLUIDO,LAVANDERIAS_IDTIPOSERVICIO,RESTAURANTES_IDTIPOSERVICIO,TIENDAS_IDTIPOSERVICIO,BARES_IDTIPOSERVICIO) VALUES ("+str(i)+",'"+random_word(random.randint(5, 10))+"',"+str(random.uniform(20000.0,120000.0))+","+str(random.randint(0,1))+","+str(random.randint(14,24))+","+str(random.randint(32,42))+","+str(random.randint(80,100))+","+str(random.randint(1,10))+");")

#productosSupermercado
for i in range(1,1000):
    print("INSERT INTO PRODUCTOSSUPERMERCADO (PRODUCTOS_IDPRODUCTO,SUPERMERCADOS_IDTIPOSERVICIO) VALUES ("+str(random.randint(1,1000))+","+str(random.randint(70,80))+");")

#reservasHoteles
for num in num_reserva:
    entrada = str(random.randint(1,31))+"-"+str(random.randint(1,12))+"-"+str(random.randint(2018,2023))
    salida = str(random.randint(1,31))+"-"+str(random.randint(1,12))+"-"+str(random.randint(2018,2023))
    print("INSERT INTO RESERVASHOTELES (NUMRESERVA,FECHAENTRADA,FECHASALIDA,PAGO,RESERVATOMADA,HOTELES_NOMBRE,HABITACIONES_NUMEROHABITACION,PROMOCIONES_NOMBREPLAN) VALUES ("+str(num)+",'"+entrada+"','"+salida+"',"+str(random.randint(0,1))+","+str(random.randint(0,1))+",'Hotel de los Andes',"+str(random.randint(1,1000))+",'"+planes[random.randint(0,len(planes)-1)]+"');")

#reservasServicios
for num in num_reserva_servicios:
    entrada = str(random.randint(1,31))+"-"+str(random.randint(1,12))+"-"+str(random.randint(2018,2023))
    print("INSERT INTO RESERVASSERVICIOS (NUMRESERVA,FECHA,ATENDIDA,HABITACIONES_NUMEROHABITACION,LAVANDERIAS_IDTIPOSERVICIO,BARES_IDTIPOSERVICIO,SPAS_IDTIPOSERVICIO,GIMNASIOS_IDTIPOSERVICIO,SALONES_IDTIPOSERVICIO,RESTAURANTES_IDTIPOSERVICIO,PISCINAS_IDTIPOSERVICIO) VALUES ("+str(num)+",'"+entrada+"',"+str(random.randint(0,1))+","+str(random.randint(1,1000))+","+str(random.randint(14,24))+","+str(random.randint(1,10))+","+str(random.randint(62,70))+","+str(random.randint(10,13))+","+str(random.randint(42,52))+","+str(random.randint(32,42))+","+str(random.randint(24,27))+");")

#consumos
for i in range(30000):
    entrada = str(random.randint(1,31))+"-"+str(random.randint(1,12))+"-"+str(random.randint(2018,2023))
    print("INSERT INTO CONSUMOS (ID,COSTO,CARGADOHABITACION,FECHA,GIMNASIOS_IDTIPOSERVICIO,SALONES_IDTIPOSERVICIO,PRESTAMOS_IDTIPOSERVICIO,SUPERMERCADOS_IDTIPOSERVICIO,PISCINAS_IDTIPOSERVICIO,TIENDAS_IDTIPOSERVICIO,INTERNET_IDTIPOSERVICIO,BARES_IDTIPOSERVICIO,LAVANDERIAS_IDTIPOSERVICIO,RESTAURANTES_IDTIPOSERVICIO,SPAS_IDTIPOSERVICIO,HABITACIONES_NUMEROHABITACION) VALUES ("+str(i)+","+str(random.uniform(20000.0,120000.0))+","+str(random.randint(0,1))+",'"+entrada+"',"+str(random.randint(10,13))+","+str(random.randint(42,52))+","+str(random.randint(28,32))+","+str(random.randint(70,80))+","+str(random.randint(24,27))+","+str(random.randint(80,100))+","+str(random.randint(52,62))+","+str(random.randint(1,10))+","+str(random.randint(14,24))+","+str(random.randint(32,42))+","+str(random.randint(62,70))+","+str(random.randint(1,1000))+");")
