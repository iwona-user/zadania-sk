package com.capgemini.idolata;

/**
 * @author idolata
 *
 */
public class Program {

    //TODO wartość "" jest zbędna
    private String programName = "";
    private int programNumber;
    private int spinSpeed;
    private int defoultTime;

    // TODO konstruktor powienien zawierać wszystkie pola - w tym defaultTime
    // (opcjonalnie) TODO możesz pokuśić się o stworzenie Buildera wewnątrz tej klasy
    public Program(String programName, int programNumber, int spinSpeed) {
        this.programName = programName;
        this.programNumber = programNumber;
        this.spinSpeed = spinSpeed;
    }

    //TODO dodaj gettery - bez setterów!
}
