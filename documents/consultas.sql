RF1- 

SELECT consumos.habitaciones_numeroHabitacion, sum(consumos.costo)  

FROM consumos INNER JOIN habitaciones  

ON consumos.habitaciones_numeroHabitacion = habitaciones.numeroHabitacion  

WHERE consumos.fecha > (SELECT CURRENT_DATE-365 from dual)  

GROUP BY consumos.habitaciones_numeroHabitacion  

ORDER BY consumos.habitaciones_numeroHabitacion; 

 

RF2 - 

Toca hacer una consulta por cada tipo de servicio, luego en la lógica del programa se comparan los resultados. 

 

SELECT consumos.gimnasios_idtiposervicio, COUNT(consumos.gimnasios_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.gimnasios_idtiposervicio; 

  

SELECT consumos.salones_idtiposervicio, COUNT(consumos.salones_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.salones_idtiposervicio; 

  

SELECT consumos.prestamos_idtiposervicio, COUNT(consumos.prestamos_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.prestamos_idtiposervicio; 

  

SELECT consumos.supermercados_idtiposervicio, COUNT(consumos.supermercados_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.supermercados_idtiposervicio; 

  

SELECT consumos.piscinas_idtiposervicio, COUNT(consumos.piscinas_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.piscinas_idtiposervicio; 

  

SELECT consumos.tiendas_idtiposervicio, COUNT(consumos.tiendas_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.tiendas_idtiposervicio; 

  

SELECT consumos.internet_idtiposervicio, COUNT(consumos.internet_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.internet_idtiposervicio; 

  

SELECT consumos.bares_idtiposervicio, COUNT(consumos.bares_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.bares_idtiposervicio; 

  

SELECT consumos.lavanderias_idtiposervicio, COUNT(consumos.lavanderias_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.lavanderias_idtiposervicio; 

  

SELECT consumos.restaurantes_idtiposervicio, COUNT(consumos.restaurantes_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.restaurantes_idtiposervicio; 

  

SELECT consumos.spas_idtiposervicio, COUNT(consumos.spas_idtiposervicio) AS num_consumos 

FROM CONSUMOS 

WHERE consumos.fecha > :inicio AND consumos.fecha < :fin 

GROUP BY consumos.spas_idtiposervicio; 

 

RF3- 

Toca obtener la cantidad total de reservas satisfactorias, es decir la cantidad total de habitaciones ocupadas, y la cantidad por habitación de reservas satisfactorias en el ultimo año, luego se hace el cociente y se pone en porcentaje en la lógica del programa. 

Para obtener la cantidad total: 

SELECT COUNT(reservashoteles.numreserva) as cantidad_total  

FROM reservashoteles  

WHERE reservatomada = 1 AND reservashoteles.fechasalida >(SELECT CURRENT_DATE-365 from dual); 

 

Para obtener la cantidad de cada habitación: 

SELECT habitaciones_numerohabitacion, COUNT(reservashoteles.numreserva) as cantidad_total  

FROM reservashoteles  

WHERE reservashoteles.reservatomada = 1 AND reservashoteles.fechasalida >(SELECT CURRENT_DATE-365 from dual) 

GROUP BY habitaciones_numerohabitacion  

ORDER BY habitaciones_numerohabitacion; 

 

RF4- 

Filtro “precio se encuentra en un cierto rango”: 

SELECT *  

FROM :servicio  

WHERE costoreserva > :inicial AND costoreserva < :fin; 

 

Filtro “fecha de consumo está en un rango de tiempo”: 

SELECT * 

FROM consumos 

WHERE fecha> :inicial AND fecha < :final; 

 

Filtro “servicios que son de un cierto tipo o de una cierta categoría”: 

SELECT *  

FROM :servicio; 

 

RF5- 

SELECT u.id, u.nombre, s.fecha 

FROM Usuarios u 

INNER JOIN ReservaServicios s ON u. habitaciones_numerohabitacion  

= s. habitaciones_numerohabitacion 

WHERE u.id = ID_DEL_USUARIO 

    AND s.Fecha >= 'FECHA_DE_INICIO' -- Reemplaza con la fecha de inicio deseada (por ejemplo, '2023-01-01') 

    AND s.Fecha <= 'FECHA_DE_FIN' -- Reemplaza con la fecha de fin deseada (por ejemplo, '2023-12-31') 

ORDER BY s.fecha; 

 

RF6- 

mayor cantidad de habitaciones ocupadas: 

SELECT TOP 1 fechaentrada AS Fecha, COUNT(*) AS Total_Habitaciones_Ocupadas  

FROM reservashoteles GROUP BY fechaentrada  

ORDER BY Total_Habitaciones_Ocupadas DESC LIMIT 1; 

Mayores ingresos 
SELECT TOP 1 fecha AS Fecha, SUM(costo) AS Total_Ingresos  

FROM consumos  

GROUP BY fecha  

ORDER BY Total_Ingresos DESC LIMIT 1; 

Menor demanda 

SELECT TOP 1 fechaentrada AS Fecha, COUNT(*) AS Total_Habitaciones_Ocupadas FROM reservashoteles  

GROUP BY fechaentrada  

ORDER BY Total_Habitaciones_Ocupadas ASC 

 

RF7- 

SELECT u.nombre AS NombreCliente, u.pk AS IdentificacionCliente 

FROM usuarios u 

LEFT JOIN reservasServicios rs ON u.pk = rs.habitaciones_numeroHabitacion 

LEFT JOIN consumos c ON rs.habitaciones_numeroHabitacion = c.habitaciones_numeroHabitacion 

WHERE  

    (DATEDIFF(CURRENT_DATE, rs.fecha) >= 14 

        OR EXISTS ( 

            SELECT SUM(costo) 

            FROM consumos 

            WHERE  

                habitaciones_numeroHabitacion = u.pk 

                AND fecha BETWEEN DATE_SUB(CURRENT_DATE, INTERVAL 1 YEAR) AND CURRENT_DATE 

            GROUP BY habitaciones_numeroHabitacion 

            HAVING SUM(costo) > 15000000 

        ) 

    ) 

GROUP BY u.pk 

RF8- 

SELECT rs.idTipoServicio, COUNT(*) AS VecesSolicitado, AVG(cast(DATEDIFF(CURRENT_DATE, rs.fecha) AS SIGNED) / 7) AS FrecuenciaSemanal 

FROM reservasServicios rs 

WHERE rs.fecha BETWEEN DATE_SUB(CURRENT_DATE, INTERVAL 1 YEAR) AND CURRENT_DATE 

GROUP BY rs.idTipoServicio 

HAVING FrecuenciaSemanal < 3 

 

RF9- 

SELECT u.nombre AS NombreCliente, u.correo AS CorreoCliente, rs.fecha AS FechaReserva, COUNT(rs.numReserva) AS VecesConsumido 

FROM Usuario u 

JOIN ReservaServicios rs ON u.id = rs.idUsuario  

WHERE rs.idservicio= idtiposervicio 

AND rs.fecha BETWEEN 'FechaInicio' AND 'FechaFin'  

GROUP BY u.id, rs.fecha  

ORDER BY  NombreCliente ASC, VecesConsumido DESC 

 

RF10- 

SELECT u.id AS IDCliente, u.nombre AS NombreCliente, rs.fecha AS FechaReserva, COUNT(rs.numReserva) AS VecesConsumido 

FROM Usuario u 

CROSS JOIN ReservaServicios rs 

WHERE u.id NOT IN ( 

    SELECT u.id 

    FROM Usuario u 

    JOIN ReservaServicios rs ON u.id = rs.idUsuario 

    WHERE rs.idservicio= idtiposervicio 

        AND rs.fecha BETWEEN 'FechaInicio' AND 'FechaFin' 

) 

AND rs.fecha BETWEEN 'FechaInicio' AND 'FechaFin' 

GROUP BY u.id, u.nombre, u.correo, rs.fecha  

ORDER BY NombreCliente ASC, FechaReserva DESC 

  

RF11- 

SELECT  

    YEAR(rs.fecha) AS Anio, 

    ROUND(DATEDIFF(rs.fecha, DATEADD(DD, -3, rs.fecha))/7, 0) AS NumeroSemana, 

    rs.servicio AS ServicioMasConsumido, 

    rs.habitaciones_numeroHabitacion AS HabitacionMasSolicitada, 

    ( 

        SELECT TOP 1 servicio  

        FROM ReservaServicios  

        WHERE rs.fecha BETWEEN fechaInicio AND fechaFin  

        GROUP BY servicio  

        ORDER BY COUNT(*) ASC 

    ) AS ServicioMenosConsumido, 

    ( 

        SELECT TOP 1 habitaciones_numeroHabitacion  

        FROM ReservaServicios  

        WHERE rs.fecha BETWEEN fechaInicio AND fechaFin  

        GROUP BY habitaciones_numeroHabitacion  

        ORDER BY COUNT(*) ASC 

    ) AS HabitacionMenosSolicitada 

FROM ReservaServicios rs 

GROUP BY YEAR(rs.fecha), ROUND(DATEDIFF(rs.fecha, DATEADD(DD, -3, rs.fecha))/7, 0), rs.servicio, rs.habitaciones_numeroHabitacion 

ORDER BY YEAR(rs.fecha), NumeroSemana; 

 

RF12- 

SELECT u.* 

FROM usuarios u 

WHERE  

    -- Clientes que realizan estancias al menos una vez por trimestre 

    EXISTS ( 

        SELECT * 

        FROM reservaservicios rs 

        WHERE rs.habitaciones_numeroHabitacion = u.habitaciones_numeroHabitacion 

        GROUP BY YEAR(rs.fecha), QUARTER(rs.fecha) 

        HAVING COUNT(DISTINCT rs.fecha) >= 1 

    ) 

    OR 

    -- Clientes que consumen al menos un servicio costoso 

    EXISTS ( 

        SELECT * 

        FROM consumo c 

        WHERE c.habitaciones_numeroHabitacion = u.habitaciones_numeroHabitacion 

        AND c.costo > 300000 

    ) 

    OR 

    -- Clientes que en cada estancia consumen servicios de SPA o salones de reuniones con duración mayor a 4 horas 

    EXISTS ( 

        SELECT * 

        FROM reservaservicios rs 

        JOIN consumo c ON rs.habitaciones_numeroHabitacion = c.habitaciones_numeroHabitacion 

        WHERE rs.habitaciones_numeroHabitacion = u.habitaciones_numeroHabitacion 

        AND (rs.spas_idTipoServicio IS NOT NULL OR rs.salones_idTipoServicio IS NOT NULL) 

        AND c.fecha BETWEEN rs.fecha AND DATE_ADD(rs.fecha, INTERVAL 4 HOUR) 

    ); 