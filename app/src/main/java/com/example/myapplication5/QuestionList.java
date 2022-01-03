package com.example.myapplication5;

class QuestionList {
    String arrayQuNu;
    String arrayQu;
    String arrayO1;
    String arrayO2;
    String arrayO3;
    String arrayO4;
    int arrayAns;

    public QuestionList() {
    }

    public QuestionList(String arrayQuNu, String arrayQu, String arrayO1, String arrayO2, String arrayO3, String arrayO4, String arrayAns) {
        this.arrayQuNu = arrayQuNu;
        this.arrayQu = arrayQu;
        this.arrayO1 = arrayO1;
        this.arrayO2 = arrayO2;
        this.arrayO3 = arrayO3;
        this.arrayO4 = arrayO4;
        this.arrayAns = Integer.parseInt(arrayAns);
    }

    public String getArrayQuNu() {
        return arrayQuNu;
    }

    public void setArrayQuNu(String arrayQuNu) {
        this.arrayQuNu = arrayQuNu;
    }

    public String getArrayQu() {
        return arrayQu;
    }

    public void setArrayQu(String arrayQu) {
        this.arrayQu = arrayQu;
    }

    public String getArrayO1() {
        return arrayO1;
    }

    public void setArrayO1(String arrayO1) {
        this.arrayO1 = arrayO1;
    }

    public String getArrayO2() {
        return arrayO2;
    }

    public void setArrayO2(String arrayO2) {
        this.arrayO2 = arrayO2;
    }

    public String getArrayO3() {
        return arrayO3;
    }

    public void setArrayO3(String arrayO3) {
        this.arrayO3 = arrayO3;
    }

    public String getArrayO4() {
        return arrayO4;
    }

    public void setArrayO4(String arrayO4) {
        this.arrayO4 = arrayO4;
    }

    public int getArrayAns() {
        return arrayAns;
    }

    public void setArrayAns(int arrayAns) {
        this.arrayAns = arrayAns;
    }

    public QuestionList(String arrayQu, String arrayO1, String arrayO2, String arrayO3, String arrayO4, int arrayAns) {
        this.arrayQu = arrayQu;
        this.arrayO1 = arrayO1;
        this.arrayO2 = arrayO2;
        this.arrayO3 = arrayO3;
        this.arrayO4 = arrayO4;
        this.arrayAns = arrayAns;
    }
}
