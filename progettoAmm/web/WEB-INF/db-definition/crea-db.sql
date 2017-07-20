/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sam
 * Created: 31-mag-2017
 */
--ammdb -nome:ammdb password:ammdb

CREATE TABLE Utente(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(256),
    cognome VARCHAR(256),
    dataNascita DATE,
    frase VARCHAR(10000),
    email VARCHAR(256),
    urlFoto VARCHAR(512),
    password VARCHAR(256)
);

CREATE TABLE Gruppi(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(256),
    urlIcona VARCHAR(256),
    fondatore VARCHAR(256)
);
CREATE TABLE Post(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    id_autore INTEGER,
    id_gruppi INTEGER,
    text VARCHAR(30000),
    urlFoto VARCHAR(256),
    linkPost VARCHAR(256),
    destinazione INTEGER,
    FOREIGN KEY (id_autore) REFERENCES Utente(id),
    FOREIGN KEY (id_gruppi) REFERENCES Gruppi(id)
);


CREATE TABLE Iscrizione(
    id_utente INTEGER,
    id_gruppi INTEGER,
    PRIMARY KEY(id_utente,id_gruppi),
    FOREIGN KEY (id_utente) REFERENCES Utente(id),
    FOREIGN KEY (id_gruppi) REFERENCES Gruppi(id)
);

/*Pino*/
INSERT INTO Utente (id, nome, cognome, dataNascita, frase, email, urlFoto, password)
VALUES (default, 
        'Pino',
        'Scalas', 
        '05/12/1991', 
        'faccio ridere',
        'pino@gmail.com',
        'http://immagini.quotidiano.net/?url=http://p1014p.quotidiano.net:80/polopoly_fs/1.2587451.1476280032!/httpImage/image.jpg_gen/derivatives/wide_680/image.jpg&h=350&w=606',
        '123');
/*Luca*/
INSERT INTO Utente (id, nome, cognome, dataNascita, frase, email, urlFoto, password)
VALUES (default, 
        'Luca',
        'Corongiu', 
        '05/12/1991', 
        'lavoro a colorado',
        'lucaCorongiu@gmail.com',
        'http://static.televisionando.it/televisionando/fotogallery/1200X0/96685/i-comici-luca-e-paolo.jpg',
        '123');

/*Trump*/
INSERT INTO Utente (id, nome, cognome, dataNascita, frase, email, urlFoto, password)
VALUES (default, 
        'Trump',
        'Lecca', 
        '2/6/1859', 
        'ogni tanto faccio il politico',
        'trumpauLecca@tiscali.com',
        'https://images.kurier.at/46-70842816.jpg/620x930nocrop/139.066.898',
        '123');
/*Enzo*/
INSERT INTO Utente (id, nome, cognome, dataNascita, frase, email, urlFoto, password)
VALUES (default, 
        'Enzo',
        'Ferrari', 
        '10/2/1920', 
        'brum brum',
        'EnzoFerrari@Ferrari.com',
        'http://www.emiliaromagna.programmafly.it/keyportal/uploads/enzo-ferrari-alla-guida-dell-alfa.jpg',
        '123');


/*Gruppi*/
INSERT INTO Gruppi (id, nome, urlIcona, fondatore)
VALUES (default, 
        'Mongolfieristi',
        'progettoM3\web\img\icon\32px\group.png', 
        '1');
INSERT INTO Gruppi (id, nome, urlIcona, fondatore)
VALUES (default, 
        'Rock',
        'progettoM3\web\img\icon\32px\group.png', 
        '3');
INSERT INTO Gruppi (id, nome, urlIcona, fondatore)
VALUES (default, 
        'Musicisti',
        'progettoM3\web\img\icon\32px\group.png', 
        '2');

