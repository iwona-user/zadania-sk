package com.capgemini.idolata.common;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.idolata.techbackground.LimitedQueue;
import com.capgemini.idolata.techbackground.Program;
import com.capgemini.idolata.techbackground.WashingHistory;

public abstract class Washmachine {

    protected Program currentProgram;
    protected double temp = 0;
    protected boolean unitTemp = true; // if true the temperature is set in Celsius
    protected int spinSpeed;

    public List<Program> listPrograms = new ArrayList<>(15);
    int a = 0;
    int b = 10;
    List<Program> sublistProgramList = listPrograms.subList(a, b);
    protected LimitedQueue<WashingHistory> programHistoryQueue = new LimitedQueue<>(30);


    public Washmachine() {

        listPrograms.add(new Program("Delikatne", 1, 500, 1));
        listPrograms.add(new Program("Bawełna", 2, 500, 1));
        listPrograms.add(new Program("Syntetyczne", 3, 500, 1));
        listPrograms.add(new Program("Mieszane", 4, 500, 1));
        listPrograms.add(new Program("Bawełna", 5, 500, 1));
        listPrograms.add(new Program("Pranie wstępne", 6, 500, 1));
        listPrograms.add(new Program("Dodatkowe płukanie/wirowanie", 7, 500, 1));
        listPrograms.add(new Program("Odpompowanie lub wypompowanie", 8, 500, 1));
        listPrograms.add(new Program("Pranie codzienne", 9, 500, 1));
        listPrograms.add(new Program("Pranie intensywne/odplamianie", 10, 500, 1));
        listPrograms.add(new Program("Ciemne kolory", 11, 500, 1));
        listPrograms.add(new Program("Jeansy", 12, 500, 1));
        listPrograms.add(new Program("Jasne kolory", 13, 500, 1));
        listPrograms.add(new Program("Wełna/pranie ręczne", 14, 500, 1));
        listPrograms.add(new Program("Szybkie pranie", 15, 500, 1));
    }


    public void setProgram(int paramNumber) {
        if (paramNumber > sublistProgramList.size()) {
            currentProgram = sublistProgramList.get(0);
        } else if (paramNumber < sublistProgramList.get(0).getProgramNumber()) {
            currentProgram = sublistProgramList.get(9);
        } else {
            currentProgram = sublistProgramList.get(paramNumber - 1);
        }
    }

    public int getProgram() {
        return currentProgram.getProgramNumber();
    }

    public void nextProgram() {
        if (currentProgram.getProgramNumber() == 10) {
            currentProgram = sublistProgramList.get(0);
        } else {
            currentProgram = sublistProgramList.get(currentProgram.getProgramNumber() + 1);
        }
    }


    public void previusProgram() {

        if (currentProgram.getProgramNumber() == 1) {
            currentProgram = sublistProgramList.get(9);
        } else {
            currentProgram = sublistProgramList.get(currentProgram.getProgramNumber() - 2);
        }
    }

    public void changeUnit(boolean unitTemp) {
        if (unitTemp) {
            this.temp = Math.round(2 * ((5 / 9.0) * temp) - 160 / 9.0) / 2.0;
            System.out.println("Temperatura:" + temp + "\u00B0");
        } else {
            this.temp = Math.rint(((9 / 5.0) * temp) + 32);
            System.out.println("Temperatura:" + temp + "F");
        }
    }

    public void setTemp(double paramTemp) {
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


    public double getTemp() {
        return temp;
    }


    public void tempUp() {
        if (unitTemp) {
            try {
                if (temp >= 0 && temp <= 89.5) {
                    this.temp = Math.round((temp + 0.5) * 2) / 2.0;
                    System.out.println("Aktualna temperatura:" + temp + "\u00B0");
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Pr�ba przekroczenia dopuszczalnego zakresu");
            }

        } else {
            try {
                if (temp >= 32 && temp <= 193) {
                    this.temp = Math.rint(temp + 1);
                    System.out.println("Aktualna temperatura:" + temp + "F");
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Pr�ba przekroczenia dopuszczalnego zakresu");
            }
        }
    }

    public void tempDown() {
        if (unitTemp) {
            try {
                if (temp >= 0.5 && temp <= 90) {
                    this.temp = Math.round((temp - 0.5) * 2) / 2.0;
                    System.out.println("Aktualna temperatura:" + temp + "\u00B0");
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Pr�ba przekroczenia dopuszczalnego zakresu");
            }

        } else {
            try {
                if (temp >= 33 && temp <= 194) {
                    this.temp = Math.rint(temp - 1);
                    System.out.println("Aktualna temperatura:" + temp + "F");
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Pr�ba przekroczenia dopuszczalnego zakresu");
            }
        }
    }


    public void setV(int paramV) {
        if (currentProgram.getProgramNumber() == 1) {
            if (paramV >= 0 && paramV <= 500) {
                spinSpeed = (int) ((Math.rint(paramV / 100.0)) * 100);  // with an accuracy of 100
            } else {
                System.out.println("Prędkość wirowania poza zakresem 1-500");
            }
        } else {
            if (paramV >= 0 && paramV <= 1000) {
                spinSpeed = (int) ((Math.rint(paramV / 100.0)) * 100);  // with an accuracy of 100
            } else {
                System.out.println("Prędkość wirowania poza zakresem 1-1000");
            }
        }
    }


    public int getV() {
        return spinSpeed;
    }


    public void upV() {
        if (currentProgram.getProgramNumber() == 1) {
            if (spinSpeed == 500) {
                spinSpeed = 0;
            } else {
                this.spinSpeed = spinSpeed + 100;
            }
        } else {
            if (spinSpeed == 1000) {
                this.spinSpeed = 0;
            } else {
                this.spinSpeed = spinSpeed + 100;
            }
        }
    }


    public void downV() {
        if (spinSpeed == 0) {
            this.spinSpeed = 1000;
        } else {
            this.spinSpeed = spinSpeed - 100;
        }
    }


    public void showStatus() {
        if (unitTemp) {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "\u00B0 "
                    + "Pr�dko�� wirowania:" + this.spinSpeed + " Domy�lny czas prania:" + currentProgram.getDefoultTime());
        } else {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "F"
                    + " Pr�dko�� wirowania:" + this.spinSpeed + " Domy�lny czas prania:" + currentProgram.getDefoultTime());
        }
    }


    public void delayStart(int paramDelayStart) {
        int endWashing = this.currentProgram.getDefoultTime() + paramDelayStart;
        System.out.println("Pranie sko�czy si� za: " + endWashing + "minut.");

    }


    public void Start() {
        programHistoryQueue.add(new WashingHistory(currentProgram, temp, spinSpeed));
    }


} // end of class
