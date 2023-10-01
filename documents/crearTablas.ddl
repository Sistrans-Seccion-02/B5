-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-10-01 13:22:32 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE bares (
    idtiposervicio   INTEGER NOT NULL,
    estilo           VARCHAR2(200) NOT NULL,
    aforo            INTEGER NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE consumos (
    id                            INTEGER NOT NULL,
    costo                         INTEGER NOT NULL,
    gimnasio_idtiposervicio       INTEGER,
    salon_idtiposervicio          INTEGER,
    prestamos_idtiposervicio      INTEGER,
    supermercado_idtiposervicio   INTEGER,
    piscina_idtiposervicio        INTEGER,
    tienda_idtiposervicio         INTEGER,
    internet_idtiposervicio       INTEGER,
    bares_idtiposervicio          INTEGER,
    lavanderias_idtiposervicio    INTEGER,
    restaurante_idtiposervicio    INTEGER,
    spas_idtiposervicio           INTEGER,
    habitaciones_numerohabitacion INTEGER NOT NULL,
    reservasservicios_numreserva  INTEGER,
    cargadohabitacion             NUMBER NOT NULL
);

ALTER TABLE consumos ADD CONSTRAINT consumo_pk PRIMARY KEY ( id );

CREATE TABLE elementosextras (
    nombreelemento                VARCHAR2(200) NOT NULL,
    habitaciones_numerohabitacion INTEGER NOT NULL
);

ALTER TABLE elementosextras ADD CONSTRAINT elementosextras_pk PRIMARY KEY ( nombreelemento );

CREATE TABLE gimnasios (
    idtiposervicio   INTEGER NOT NULL,
    aforo            INTEGER NOT NULL,
    nummaquinas      INTEGER NOT NULL,
    horario          VARCHAR2(200) NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE habitaciones (
    numerohabitacion INTEGER NOT NULL,
    tipohabitacion   VARCHAR2(200) NOT NULL,
    disponible       NUMBER NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( numerohabitacion );

CREATE TABLE hoteles (
    nombre VARCHAR2(200) NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( nombre );

CREATE TABLE lavanderias (
    idtiposervicio   INTEGER NOT NULL,
    aforo            INTEGER NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE lavanderias ADD CONSTRAINT lavanderias_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE piscinas (
    idtiposervicio   INTEGER NOT NULL,
    aforo            INTEGER NOT NULL,
    profundidad      FLOAT NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscina_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE prestamosutensilios (
    idtiposervicio INTEGER NOT NULL,
    nombre         VARCHAR2(200) NOT NULL,
    retornado      NUMBER NOT NULL,
    hoteles_nombre VARCHAR2(200) NOT NULL
);

ALTER TABLE prestamosutensilios ADD CONSTRAINT prestamoutensilios_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE productos (
    idproducto                 INTEGER NOT NULL,
    nombre                     VARCHAR2(4000) NOT NULL,
    costo                      INTEGER NOT NULL,
    aplicaincluido             NUMBER NOT NULL,
    lavanderias_idtiposervicio INTEGER,
    restaurante_idtiposervicio INTEGER,
    tienda_idtiposervicio      INTEGER,
    bares_idtiposervicio       INTEGER
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( idproducto );

CREATE TABLE productossupermercado (
    supermercado_idtiposervicio INTEGER NOT NULL,
    productos_idproducto        INTEGER NOT NULL
);

ALTER TABLE productossupermercado ADD CONSTRAINT productossupermercado_pk PRIMARY KEY ( supermercado_idtiposervicio,
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
    promociones_nombreplan        VARCHAR2(200),
    hoteles_nombre                VARCHAR2(200) NOT NULL,
    habitaciones_numerohabitacion INTEGER NOT NULL
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
    gimnasio_idtiposervicio       INTEGER,
    salon_idtiposervicio          INTEGER,
    restaurante_idtiposervicio    INTEGER,
    piscina_idtiposervicio        INTEGER
);

ALTER TABLE reservasservicios ADD CONSTRAINT reservasservicios_pk PRIMARY KEY ( numreserva );

CREATE TABLE restaurantes (
    idtiposervicio   INTEGER NOT NULL,
    aforo            INTEGER NOT NULL,
    estilo           VARCHAR2(200) NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurante_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE salones (
    idtiposervicio   INTEGER NOT NULL,
    aforo            INTEGER NOT NULL,
    equipo           VARCHAR2(200) NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL,
    aplicacompartido NUMBER NOT NULL
);

ALTER TABLE salones ADD CONSTRAINT salon_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE serviciosinternet (
    idtiposervicio   INTEGER NOT NULL,
    aforo            INTEGER NOT NULL,
    incluido         NUMBER NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE serviciosinternet ADD CONSTRAINT internet_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE spas (
    idtiposervicio   INTEGER NOT NULL,
    duracion         INTEGER NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE supermercados (
    idtiposervicio   INTEGER NOT NULL,
    nombre           VARCHAR2(200) NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE supermercados ADD CONSTRAINT supermercado_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE tiendas (
    idtiposervicio   INTEGER NOT NULL,
    nombre           VARCHAR2(200) NOT NULL,
    aplicacompartido NUMBER NOT NULL,
    hoteles_nombre   VARCHAR2(200) NOT NULL
);

ALTER TABLE tiendas ADD CONSTRAINT tienda_pk PRIMARY KEY ( idtiposervicio );

CREATE TABLE usuarios (
    id                            INTEGER NOT NULL,
    tipoid                        VARCHAR2(200) NOT NULL,
    nombre                        VARCHAR2(200) NOT NULL,
    tipousuario                   VARCHAR2(200) NOT NULL,
    correo                        VARCHAR2(200) NOT NULL,
    habitaciones_numerohabitacion INTEGER
);

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( id );

ALTER TABLE bares
    ADD CONSTRAINT bares_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_bares_fk FOREIGN KEY ( bares_idtiposervicio )
        REFERENCES bares ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_gimnasio_fk FOREIGN KEY ( gimnasio_idtiposervicio )
        REFERENCES gimnasios ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_habitaciones_fk FOREIGN KEY ( habitaciones_numerohabitacion )
        REFERENCES habitaciones ( numerohabitacion );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_internet_fk FOREIGN KEY ( internet_idtiposervicio )
        REFERENCES serviciosinternet ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_lavanderias_fk FOREIGN KEY ( lavanderias_idtiposervicio )
        REFERENCES lavanderias ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_piscina_fk FOREIGN KEY ( piscina_idtiposervicio )
        REFERENCES piscinas ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_prestamoutensilios_fk FOREIGN KEY ( prestamos_idtiposervicio )
        REFERENCES prestamosutensilios ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_reservasservicios_fk FOREIGN KEY ( reservasservicios_numreserva )
        REFERENCES reservasservicios ( numreserva );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_restaurante_fk FOREIGN KEY ( restaurante_idtiposervicio )
        REFERENCES restaurantes ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_salon_fk FOREIGN KEY ( salon_idtiposervicio )
        REFERENCES salones ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_spas_fk FOREIGN KEY ( spas_idtiposervicio )
        REFERENCES spas ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_supermercado_fk FOREIGN KEY ( supermercado_idtiposervicio )
        REFERENCES supermercados ( idtiposervicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumo_tienda_fk FOREIGN KEY ( tienda_idtiposervicio )
        REFERENCES tiendas ( idtiposervicio );

ALTER TABLE elementosextras
    ADD CONSTRAINT elementos_habitaciones_fk FOREIGN KEY ( habitaciones_numerohabitacion )
        REFERENCES habitaciones ( numerohabitacion );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasio_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE serviciosinternet
    ADD CONSTRAINT internet_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE lavanderias
    ADD CONSTRAINT lavanderias_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE piscinas
    ADD CONSTRAINT piscina_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE prestamosutensilios
    ADD CONSTRAINT prestamoutensilios_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE productos
    ADD CONSTRAINT productos_bares_fk FOREIGN KEY ( bares_idtiposervicio )
        REFERENCES bares ( idtiposervicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_lavanderias_fk FOREIGN KEY ( lavanderias_idtiposervicio )
        REFERENCES lavanderias ( idtiposervicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_restaurante_fk FOREIGN KEY ( restaurante_idtiposervicio )
        REFERENCES restaurantes ( idtiposervicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_tienda_fk FOREIGN KEY ( tienda_idtiposervicio )
        REFERENCES tiendas ( idtiposervicio );

ALTER TABLE productossupermercado
    ADD CONSTRAINT productossup_productos_fk FOREIGN KEY ( productos_idproducto )
        REFERENCES productos ( idproducto );

ALTER TABLE productossupermercado
    ADD CONSTRAINT productossup_supermercado_fk FOREIGN KEY ( supermercado_idtiposervicio )
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
    ADD CONSTRAINT reservasserv_gimnasio_fk FOREIGN KEY ( gimnasio_idtiposervicio )
        REFERENCES gimnasios ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_habitaciones_fk FOREIGN KEY ( habitaciones_numerohabitacion )
        REFERENCES habitaciones ( numerohabitacion );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_lavanderias_fk FOREIGN KEY ( lavanderias_idtiposervicio )
        REFERENCES lavanderias ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_piscina_fk FOREIGN KEY ( piscina_idtiposervicio )
        REFERENCES piscinas ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_restaurante_fk FOREIGN KEY ( restaurante_idtiposervicio )
        REFERENCES restaurantes ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_salon_fk FOREIGN KEY ( salon_idtiposervicio )
        REFERENCES salones ( idtiposervicio );

ALTER TABLE reservasservicios
    ADD CONSTRAINT reservasserv_spas_fk FOREIGN KEY ( spas_idtiposervicio )
        REFERENCES spas ( idtiposervicio );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurante_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE salones
    ADD CONSTRAINT salon_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE spas
    ADD CONSTRAINT spas_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE supermercados
    ADD CONSTRAINT supermercado_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE tiendas
    ADD CONSTRAINT tienda_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_habitaciones_fk FOREIGN KEY ( habitaciones_numerohabitacion )
        REFERENCES habitaciones ( numerohabitacion );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            21
-- CREATE INDEX                             0
-- ALTER TABLE                             64
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
