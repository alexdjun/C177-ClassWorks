DROP DATABASE IF EXISTS MovieCatalogue;
CREATE DATABASE MovieCatalogue;

USE moviecatalogue;

CREATE TABLE Genre (
    GenreID INT PRIMARY KEY AUTO_INCREMENT,
    GenreName VARCHAR(30) NOT NULL
);

CREATE TABLE Rating (
    RatingID INT PRIMARY KEY AUTO_INCREMENT,
    RaitingName VARCHAR(5) NOT NULL
);

CREATE TABLE Directo (
    DirectoID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    Birthdate DATE NULL
);

CREATE TABLE Actor (
    ActorID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    Birthdate DATE NULL
);

CREATE TABLE Movie (
    MovieID INT PRIMARY KEY AUTO_INCREMENT,
    GenreId INT NOT NULL,
    DirectoID INT NULL,
    RatingID INT NULL,
    Title VARCHAR(128) NOT NULL,
    ReleaseDate DATE NULL,
    FOREIGN KEY (GenreID)
        REFERENCES Genre (GenreId),
    FOREIGN KEY (DirectoID)
        REFERENCES Directo (DirectoID),
    FOREIGN KEY (RatingID)
        REFERENCES Rating (RatingID)
);

CREATE TABLE CastMembers (
    CastMemberID INT PRIMARY KEY AUTO_INCREMENT,
    ActorID INT NOT NULL,
    MovieID INT NOT NULL,
    Role VARCHAR(50) NOT NULL,
    FOREIGN KEY (ActorID)
        REFERENCES Actor (ActorID),
    FOREIGN KEY (MovieID)
        REFERENCES Movie (MovieID)
);