CREATE TABLE IF NOT EXISTS carpark_details(
   carpark_number         VARCHAR(10) NOT NULL PRIMARY KEY,
   address                VARCHAR(100) NOT NULL,
   x_coord                NUMERIC(10,4) NOT NULL,
   y_coord                NUMERIC(10,4) NOT NULL,
   carpark_type           VARCHAR(50) NOT NULL,
   type_of_parking_system VARCHAR(30) NOT NULL,
   short_term_parking     VARCHAR(20) NOT NULL,
   free_parking           VARCHAR(30) NOT NULL,
   night_parking          VARCHAR(5) NOT NULL,
   carpark_decks          INTEGER  NOT NULL,
   gantry_height          NUMERIC(4,2) NOT NULL,
   carpark_basement       VARCHAR(1) NOT NULL
);


CREATE TABLE IF NOT EXISTS carpark_availability(
   carpark_number         VARCHAR(10) NOT NULL,
   lot_type               VARCHAR(5) NOT NULL,
   total_lots             INTEGER NOT NULL,
   lots_available         INTEGER NOT NULL,
   update_datetime        TIMESTAMPTZ NOT NULL,
   PRIMARY KEY(carpark_number, lot_type)
);