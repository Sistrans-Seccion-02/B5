import string

import random

def random_word(length):
    
    word = ''
    for i in range(length):
        word += random.choice(letters)
    return word

num_reserva_servicios = []
for i in range(1,20000):
    num_reserva_servicios.append(i)

for num in num_reserva_servicios:
    entrada = str(random.randint(1,31))+"-"+str(random.randint(1,12))+"-"+str(random.randint(2018,2023))
    print("INSERT INTO RESERVASSERVICIOS (NUMRESERVA,FECHA,ATENDIDA,HABITACIONES_NUMEROHABITACION,LAVANDERIAS_IDTIPOSERVICIO,BARES_IDTIPOSERVICIO,SPAS_IDTIPOSERVICIO,GIMNASIOS_IDTIPOSERVICIO,SALONES_IDTIPOSERVICIO,RESTAURANTES_IDTIPOSERVICIO,PISCINAS_IDTIPOSERVICIO) VALUES ("+str(num)+",'"+entrada+"',"+str(random.randint(0,1))+","+str(random.randint(1,1000))+","+str(random.randint(14,24))+","+str(random.randint(1,10))+","+str(random.randint(62,70))+","+str(random.randint(10,13))+","+str(random.randint(42,52))+","+str(random.randint(32,42))+","+str(random.randint(24,27))+");")
