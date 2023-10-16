-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-10-16 15:05:57 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE bares (
    idtiposervicio   INTEGER NOT NULL,
    estilo           VARCHAR2(200) NOT NULL,
    aforo            INTEGER NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL,
    costoreserva     FLOAT NOT NULL
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE consumos (
    id                            INTEGER NOT NULL,
    costo                         INTEGER NOT NULL,
    cargadohabitacion             NUMBER NOT NULL,
    fecha                         DATE NOT NULL,
    gimnasios_idtiposervicio      INTEGER,
    salones_idtiposervicio        INTEGER,
    prestamos_idtiposervicio      INTEGER,
    supermercados_idtiposervicio  INTEGER,
    piscinas_idtiposervicio       INTEGER,
    tiendas_idtiposervicio        INTEGER,
    internet_idtiposervicio       INTEGER,
    bares_idtiposervicio          INTEGER,
    lavanderias_idtiposervicio    INTEGER,
    restaurantes_idtiposervicio   INTEGER,
    spas_idtiposervicio           INTEGER,
    habitaciones_numerohabitacion INTEGER NOT NULL
);

ALTER TABLE consumos ADD CONSTRAINT consumos_pk PRIMARY KEY ( id );

CREATE TABLE elementosextras (
    nombreelemento VARCHAR2(200) NOT NULL
);

ALTER TABLE elementosextras ADD CONSTRAINT elementosextras_pk PRIMARY KEY ( nombreelemento );

CREATE TABLE elementostiposhabitaciones (
    tipohabitacion VARCHAR2(200) NOT NULL,
    nombreelemento VARCHAR2(200) NOT NULL
);

ALTER TABLE elementostiposhabitaciones ADD CONSTRAINT elementostiposhabitaciones_pk PRIMARY KEY ( tipohabitacion,
                                                                                                  nombreelemento );

CREATE TABLE gimnasios (
    idtiposervicio   INTEGER NOT NULL,
    aforo            INTEGER NOT NULL,
    nummaquinas      INTEGER NOT NULL,
    horario          VARCHAR2(200) NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL,
    costoreserva     FLOAT NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE habitaciones (
    numerohabitacion INTEGER NOT NULL,
    tipohabitacion   VARCHAR2(200) NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( numerohabitacion );

CREATE TABLE hoteles (
    nombre VARCHAR2(200) NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( nombre );

CREATE TABLE lavanderias (
    idtiposervicio   INTEGER NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL,
    aforo            INTEGER NOT NULL,
    costoreserva     FLOAT NOT NULL
);

ALTER TABLE lavanderias ADD CONSTRAINT lavanderias_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE piscinas (
    idtiposervicio   INTEGER NOT NULL,
    aforo            INTEGER NOT NULL,
    profundidad      FLOAT NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL,
    costoreserva     FLOAT NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE prestamosutensilios (
    idtiposervicio INTEGER NOT NULL,
    nombre         VARCHAR2(200) NOT NULL,
    retornado      NUMBER NOT NULL,
    hoteles_nombre VARCHAR2(200) NOT NULL
);

ALTER TABLE prestamosutensilios ADD CONSTRAINT prestamosutensilios_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE productos (
    idproducto                  INTEGER NOT NULL,
    nombre                      VARCHAR2(4000) NOT NULL,
    costo                       INTEGER NOT NULL,
    aplicaincluido              NUMBER NOT NULL,
    lavanderias_idtiposervicio  INTEGER,
    restaurantes_idtiposervicio INTEGER,
    tiendas_idtiposervicio      INTEGER,
    bares_idtiposervicio        INTEGER
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( idproducto );

CREATE TABLE productossupermercado (
    supermercados_idtiposervicio INTEGER NOT NULL,
    productos_idproducto         INTEGER NOT NULL
);

ALTER TABLE productossupermercado ADD CONSTRAINT productossupermercado_pk PRIMARY KEY ( supermercados_idtiposervicio,
                                                                                        productos_idproducto );

CREATE TABLE promociones (
    nombreplan           VARCHAR2(200) NOT NULL,
    descuentoalojamiento FLOAT NOT NULL,
    descuentocomida      FLOAT NOT NULL,
    descuentoservicios   FLOAT NOT NULL,
    costo                FLOAT NOT NULL,
    diasminimaestadia    INTEGER NOT NULL
);

ALTER TABLE promociones ADD CONSTRAINT promociones_pk PRIMARY KEY ( nombreplan );

CREATE TABLE reservashoteles (
    numreserva                    INTEGER NOT NULL,
    fechaentrada                  DATE NOT NULL,
    fechasalida                   DATE NOT NULL,
    pago                          NUMBER NOT NULL,
    reservatomada                 NUMBER NOT NULL,
    hoteles_nombre                VARCHAR2(200) NOT NULL,
    habitaciones_numerohabitacion INTEGER NOT NULL,
    promociones_nombreplan        VARCHAR2(200)
);

ALTER TABLE reservashoteles ADD CONSTRAINT reservashoteles_pk PRIMARY KEY ( numreserva );

CREATE TABLE reservasservicios (
    numreserva                    INTEGER NOT NULL,
    fecha                         DATE NOT NULL,
    atendida                      NUMBER NOT NULL,
    habitaciones_numerohabitacion INTEGER NOT NULL,
    lavanderias_idtiposervicio    INTEGER,
    bares_idtiposervicio          INTEGER,
    spas_idtiposervicio           INTEGER,
    gimnasios_idtiposervicio      INTEGER,
    salones_idtiposervicio        INTEGER,
    restaurantes_idtiposervicio   INTEGER,
    piscinas_idtiposervicio       INTEGER
);

ALTER TABLE reservasservicios ADD CONSTRAINT reservasservicios_pk PRIMARY KEY ( numreserva );

CREATE TABLE restaurantes (
    idtiposervicio   INTEGER NOT NULL,
    aforo            INTEGER NOT NULL,
    estilo           VARCHAR2(200) NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL,
    costoreserva     FLOAT NOT NULL
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurantes_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE salidas (
    numreserva  INTEGER NOT NULL,
    cuentatotal FLOAT NOT NULL
);

ALTER TABLE salidas ADD CONSTRAINT salidas_pk PRIMARY KEY ( numreserva );

CREATE TABLE salones (
    idtiposervicio   INTEGER NOT NULL,
    aforo            INTEGER NOT NULL,
    equipo           VARCHAR2(200) NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    costoreserva     FLOAT NOT NULL
);

ALTER TABLE salones ADD CONSTRAINT salones_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE serviciosinternet (
    idtiposervicio   INTEGER NOT NULL,
    incluido         NUMBER NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE serviciosinternet ADD CONSTRAINT serviciosinternet_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE spas (
    idtiposervicio   INTEGER NOT NULL,
    duracion         INTEGER NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL,
    aforo            INTEGER NOT NULL,
    costoreserva     FLOAT NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE supermercados (
    idtiposervicio   INTEGER NOT NULL,
    nombre           VARCHAR2(200) NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE supermercados ADD CONSTRAINT supermercados_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE tiendas (
    idtiposervicio   INTEGER NOT NULL,
    nombre           VARCHAR2(200) NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE tiposhabitaciones (
    tipohabitacion VARCHAR2(200) NOT NULL
);

ALTER TABLE tiposhabitaciones ADD CONSTRAINT tiposhabitaciones_pk PRIMARY KEY ( tipohabitacion );

CREATE TABLE tiposusuarios (
    tipousuario VARCHAR2(200) NOT NULL
);

ALTER TABLE tiposusuarios ADD CONSTRAINT tiposusuarios_pk PRIMARY KEY ( tipousuario );

CREATE TABLE usuarios (
    id                            INTEGER NOT NULL,
    tipoid                        VARCHAR2(200) NOT NULL,
    nombre                        VARCHAR2(200) NOT NULL,
    tipousuario                   VARCHAR2(200) NOT NULL,
    correo                        VARCHAR2(200) NOT NULL,
    habitaciones_numerohabitacion INTEGER
);

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( id,
                                                              tipoid );

ALTER TABLE bares
    ADD CONSTRAINT bares_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_bares_fk FOREIGN KEY ( bares_idtiposervicio )
        REFERENCES bares ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_gimnasios_fk FOREIGN KEY ( gimnasios_idtiposervicio )
        REFERENCES gimnasios ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_habitaciones_fk FOREIGN KEY ( habitaciones_numerohabitacion )
        REFERENCES habitaciones ( numerohabitacion );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_lavanderias_fk FOREIGN KEY ( lavanderias_idtiposervicio )
        REFERENCES lavanderias ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_piscinas_fk FOREIGN KEY ( piscinas_idtiposervicio )
        REFERENCES piscinas ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_prestamos_fk FOREIGN KEY ( prestamos_idtiposervicio )
        REFERENCES prestamosutensilios ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_restaurantes_fk FOREIGN KEY ( restaurantes_idtiposervicio )
        REFERENCES restaurantes ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_salones_fk FOREIGN KEY ( salones_idtiposervicio )
        REFERENCES salones ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_serviciosinternet_fk FOREIGN KEY ( internet_idtiposervicio )
        REFERENCES serviciosinternet ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_spas_fk FOREIGN KEY ( spas_idtiposervicio )
        REFERENCES spas ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_supermercados_fk FOREIGN KEY ( supermercados_idtiposervicio )
        REFERENCES supermercados ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_tiendas_fk FOREIGN KEY ( tiendas_idtiposervicio )
        REFERENCES tiendas ( idtiposervicio );

ALTER TABLE elementostiposhabitaciones
    ADD CONSTRAINT elementostiposhab_elementos_fk FOREIGN KEY ( nombreelemento )
        REFERENCES elementosextras ( nombreelemento );

ALTER TABLE elementostiposhabitaciones
    ADD CONSTRAINT elementostiposhab_tiposhab_fk FOREIGN KEY ( tipohabitacion )
        REFERENCES tiposhabitaciones ( tipohabitacion );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_tiposhab_fk FOREIGN KEY ( tipohabitacion )
        REFERENCES tiposhabitaciones ( tipohabitacion );

ALTER TABLE lavanderias
    ADD CONSTRAINT lavanderias_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE prestamosutensilios
    ADD CONSTRAINT prestamosutensilios_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE productos
    ADD CONSTRAINT productos_bares_fk FOREIGN KEY ( bares_idtiposervicio )
        REFERENCES bares ( idtiposervicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_lavanderias_fk FOREIGN KEY ( lavanderias_idtiposervicio )
        REFERENCES lavanderias ( idtiposervicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_restaurantes_fk FOREIGN KEY ( restaurantes_idtiposervicio )
        REFERENCES restaurantes ( idtiposervicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_tiendas_fk FOREIGN KEY ( tiendas_idtiposervicio )
        REFERENCES tiendas ( idtiposervicio );

ALTER TABLE productossupermercado
    ADD CONSTRAINT productossup_productos_fk FOREIGN KEY ( productos_idproducto )
        REFERENCES productos ( idproducto );

ALTER TABLE productossupermercado
    ADD CONSTRAINT productossup_supermercados_fk FOREIGN KEY ( supermercados_idtiposervicio )
        REFERENCES supermercados ( idtiposervicio );

ALTER TABLE reservashoteles
    ADD CONSTRAINT reservashot_habitaciones_fk FOREIGN KEY ( habitaciones_numerohabitacion )
        REFERENCES habitaciones ( numerohabitacion );

ALTER TABLE reservashoteles
    ADD CONSTRAINT reservashot_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE reservashoteles
    ADD CONSTRAINT reservashot_promociones_fk FOREIGN KEY ( promociones_nombreplan )
        REFERENCES promociones ( nombreplan );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_bares_fk FOREIGN KEY ( bares_idtiposervicio )
        REFERENCES bares ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_gimnasios_fk FOREIGN KEY ( gimnasios_idtiposervicio )
        REFERENCES gimnasios ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_habitaciones_fk FOREIGN KEY ( habitaciones_numerohabitacion )
        REFERENCES habitaciones ( numerohabitacion );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_lavanderias_fk FOREIGN KEY ( lavanderias_idtiposervicio )
        REFERENCES lavanderias ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_piscinas_fk FOREIGN KEY ( piscinas_idtiposervicio )
        REFERENCES piscinas ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_restaurantes_fk FOREIGN KEY ( restaurantes_idtiposervicio )
        REFERENCES restaurantes ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_salones_fk FOREIGN KEY ( salones_idtiposervicio )
        REFERENCES salones ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_spas_fk FOREIGN KEY ( spas_idtiposervicio )
        REFERENCES spas ( idtiposervicio );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE salidas
    ADD CONSTRAINT salidas_reservashoteles_fk FOREIGN KEY ( numreserva )
        REFERENCES reservashoteles ( numreserva );

ALTER TABLE salones
    ADD CONSTRAINT salones_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE serviciosinternet
    ADD CONSTRAINT serviciosinternet_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE spas
    ADD CONSTRAINT spas_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE supermercados
    ADD CONSTRAINT supermercados_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_habitaciones_fk FOREIGN KEY ( habitaciones_numerohabitacion )
        REFERENCES habitaciones ( numerohabitacion );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_tiposusuarios_fk FOREIGN KEY ( tipousuario )
        REFERENCES tiposusuarios ( tipousuario );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            25
-- CREATE INDEX                             0
-- ALTER TABLE                             71
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
