package com.capgemini.idolata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author idolata
 *
 */

//TODO klasa WahingMashine zawiera tylko metody które są wspólne dla wszystkich pralek!
public abstract class WashingMachine {

    // TODO nie 'programName' i nie 'programNumber' tylko jedno pole 'Program currentProgram'
    private String programName;
    private int programNumber;
    // TODO default time należy do pragramu, po zmianie na Program currentProgram to pole również można usunąć
    private int defaultTime;
    private double temp;
    private boolean unitTemp = true; // if true the temperature is set in Celsius
    private int spinSpeed = 0;

    // TODO przenieść do pralki która ma wagę
    private int maximumCapacity;

    final protected List<Program> listPrograms = new ArrayList<>(15);

    // TODO powinno być od 0 ;)
    // TODO czy domyślny dostep jest tu własciwy??
    List<Program> sublistProgramList = listPrograms.subList(1, 10);

    public WashingMachine() {
        // TODO ja zrobiłam to na szybko w konstruktorze, może blok inicjalizacyjny byłby lepszy? do przemyslenia
        listPrograms.add(new Program("Delikatne", 1, 500));
        listPrograms.add(new Program("Bawełna", 2, 500));
        listPrograms.add(new Program("Syntetyczne", 3, 500));
        listPrograms.add(new Program("Mieszane", 4, 500));
        listPrograms.add(new Program("Bawełna", 5, 500));
        listPrograms.add(new Program("Pranie wstępne", 6, 500));
        listPrograms.add(new Program("Dodatkowe płukanie/wirowanie", 7, 500));
        listPrograms.add(new Program("Odpompowanie lub wypompowanie", 8, 500));
        listPrograms.add(new Program("Pranie codzienne", 9, 500));
        listPrograms.add(new Program("Pranie intensywne/odplamianie", 10, 500));
        listPrograms.add(new Program("Ciemne kolory", 11, 500));
        listPrograms.add(new Program("Jeansy", 12, 500));
        listPrograms.add(new Program("Jasne kolory", 13, 500));
        listPrograms.add(new Program("Wełna/pranie ręczne", 14, 500));
        listPrograms.add(new Program("Szybkie pranie", 15, 500));
    }

    // TODO zmiena następuję tylko o 1 program, więc parametr jest zbędny, gdy podano program większy niż 10 (15)
    //  walidacja nie wyświetla wiadomosci tylko zmiena program z 10 (15) na 1
    void setProgram(int paramNumber) {
        if (paramNumber > sublistProgramList.size()) {
            System.out.println("Numer programu jest poza zakresem 1-10");
        } else if (paramNumber < sublistProgramList.get(0).getProgramNumber()) {
            System.out.println("Number programu jest poza zakresem 1-10");
        } else {
            this.programNumber = paramNumber;
        }
    } // end method

    int getProgram() {
        return programNumber;
    } // end method


    //TODO po co FOR??
    void nextProgram(int paramNext) {
        for (int i = 1; i <= Math.round(programNumber + paramNext / 10); i++) {
            if (programNumber + paramNext > 10) {
                programNumber = programNumber + paramNext - 10;
            } else {
                programNumber = programNumber + paramNext;
            }
        }
    }

    // TODO typ void, currentProgram -> zamiana na this.programNumber
    // TODO po co FOR?
    Program previousProgram(int pramPrevious) {
        int currentProgram;
        for (int i = 1; i <= Math.round((programNumber - pramPrevious) / 10); i++) {
            if (programNumber - pramPrevious < -10) {
                int difference = programNumber - pramPrevious;
                currentProgram = 10 - difference;
            } else {
                currentProgram = spinSpeed - pramPrevious;
            }
        }
    }

    //TODO zmiana warunku w IF!!!
    void changeUnit(boolean unitTemp) {
        if (unitTemp = true) {
            this.temp = ((5 / 9) * temp) - 160 / 9;
            System.out.println("Temperatura:" + temp + "\u00B0");
        } else {
            this.temp = ((9 / 5) * temp) + 32;
            System.out.println("Temperatura:" + temp + "F");
        }
    }


    //TODO zmiana warunku w IF!!!
    void setTemp(double paramTemp) {
        if (unitTemp = true) {
            if (paramTemp >= 0 && paramTemp <= 90) {
                this.temp = Math.round(2 * paramTemp) / 2.0;
                System.out.println("Temperatura:" + temp + "\u00B0");
            } else {
                System.out.println("Tempeatura poza zakresem");
            }
        } else {
            if (paramTemp >= 32 && paramTemp <= 194) {
                this.temp = Math.rint(paramTemp);
                System.out.println("Temperatura:" + temp + "F");
            } else {
                System.out.println("Temperatura poza zakresem");
            }
        }
    }

    double getTemp() {
        return temp;
    }


    // TODO co zwracasz? zmiana na void
    //TODO zmiana warunku w IF!!!
    double tempUp(double tempUp) {
        if (unitTemp = true) {
            if (temp + tempUp >= 0 && temp + tempUp <= 90) {
                this.temp = Math.round((temp + tempUp) * 2) / 2.0;
                System.out.println("Current temp:" + temp + "\u00B0");
            } else {
                System.out.println("Tempeatura poza zakresem");
            }
        } else {
            if (temp + tempUp >= 32 && temp + tempUp <= 194) {
                this.temp = Math.rint(temp + tempUp);
                System.out.println("Current temp:" + temp + "F");
            } else {
                System.out.println("Temperatura poza zakresem");
            }
        }

    }


    // TODO co po typ zwracany?
    double tempDown(double tempDown) {
        if (unitTemp = true) {
            if (temp - tempDown >= 0 && temp - tempDown <= 90) {
                this.temp = Math.round((temp - tempDown) * 2) / 2.0;
                System.out.println("Current temp:" + temp + "\u00B0");
            } else {
                System.out.println("Tempeatura poza zakresem");
            }
        } else {
            if (temp - tempDown >= 32 && temp - tempDown <= 194) {
                this.temp = Math.rint(temp - tempDown);
                System.out.println("Current temp:" + temp + "F");
            } else {
                System.out.println("Temperatura poza zakresem");
            }
        }
    }

    void setV(int paramV) {
        if (paramV >= 0 && paramV <= 1000) {
            spinSpeed = (int) ((Math.rint(paramV / 100)) * 100);  // with an accuracy of 100
        } else {
            System.out.println("Prędkość wirowania poza zakresem 1-1000");
        }
    }

    int getV() {
        return spinSpeed;
    }

    // TODO currentSpeed istnieje tylko wewnątrz IF
    // TODO odwołaj się do this.spinSpeed zamiast currentSpeed
    // TODO po co FOR?
    // TODO  parametr jest zbędny, zmieniasz wartość zawsze o 100
    int upV(int paramUpV) {
        for (int i = 1; i <= Math.round(spinSpeed + paramUpV / 1000); i++) {
            if ((spinSpeed + paramUpV) > 1000) {
                int currentSpeed = spinSpeed + paramUpV - 10;
            } else {
                currentSpeed = spinSpeed + paramUpV;
            }
        }
    }

    // TODO po co typ zwracany?
    // TODO currentSpeed istnieje tylko wewnątrz IF
    // TODO odwołaj się do spinSpeed zamiast currentSpeed
    // TODO po co FOR?
    // TODO  parametr jest zbędny, zmieniasz wartość zawsze o 100
    int downV(int paramDownV) {
        for (int i = 1; i <= Math.round((spinSpeed - paramDownV) / 10); i++) {
            if ((spinSpeed + paramDownV) < -10) {
                int differenceSpin = spinSpeed - paramDownV;
                int currentSpeed = 100 - differenceSpin;
            } else {
                currentSpeed = spinSpeed - paramUpV;
            }
        }
    }

    // TODO jaki program?? do czego się odwołujesz??
    // TODO popraw warunek IF
    // TODO Washmashine nie jest klasą statyczną aby jej tak używać, zamiast tego dla wszystkich wartości użyj this.X
    void showStatus() {
        if (unitTemp = true) {
            System.out.println("Numer programu:" + program.programNumber + " " + programname + " Temperatura:" + temp + "\u00B0 "
                    + "Prędkość wirowania:" + spinSpeed + " Czas prania:" + duration + "Szacowany czas prania:" + Washmashine.estimatedTime);
        } else {
            System.out.println("Numer programu:" + program.programNumber + " " + programname + " Temperatura:" + temp + "F"
                    + " Prędkość wirowania:" + spinSpeed + " Czas prania:" + duration + "Szacowany czas prania:" + Washmashine.estimatedTime);
        }
    }

    int estimatedTime(double weight) {
        int estimatedTime = (int) (defaultTime * weight / maximumCapacity);
        return estimatedTime;
    }

    // TODO po co typ zwracany?
    int delayStart(int paramDelayStart) {
        // TODO skąd to duration?? powinno być this.currentProgram.getDefoultTime
        int endWashing = duration + paramDelayStart;
        System.out.println("Pranie skończy się za:" + endWashing + "minut.");
    }

} // end class
