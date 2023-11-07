import string

import random

def random_word(length):
    
    word = ''
    for i in range(length):
        word += random.choice(letters)
    return word

#consumos
for i in range(30000):
    entrada = str(random.randint(1,31))+"-"+str(random.randint(1,12))+"-"+str(random.randint(2018,2023))
    print("INSERT INTO CONSUMOS (ID,COSTO,CARGADOHABITACION,FECHA,GIMNASIOS_IDTIPOSERVICIO,SALONES_IDTIPOSERVICIO,PRESTAMOS_IDTIPOSERVICIO,SUPERMERCADOS_IDTIPOSERVICIO,PISCINAS_IDTIPOSERVICIO,TIENDAS_IDTIPOSERVICIO,INTERNET_IDTIPOSERVICIO,BARES_IDTIPOSERVICIO,LAVANDERIAS_IDTIPOSERVICIO,RESTAURANTES_IDTIPOSERVICIO,SPAS_IDTIPOSERVICIO,HABITACIONES_NUMEROHABITACION) VALUES ("+str(i)+","+str(random.uniform(20000.0,120000.0))+","+str(random.randint(0,1))+",'"+entrada+"',"+str(random.randint(10,13))+","+str(random.randint(42,52))+","+str(random.randint(28,32))+","+str(random.randint(70,80))+","+str(random.randint(24,27))+","+str(random.randint(80,100))+","+str(random.randint(52,62))+","+str(random.randint(1,10))+","+str(random.randint(14,24))+","+str(random.randint(32,42))+","+str(random.randint(62,70))+","+str(random.randint(1,1000))+");")
