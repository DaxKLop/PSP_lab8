package by.hvalinskii.controller;

public class Card {
    private int card_id;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    private String first_name;
    private String last_name;
    private String born_date;
    private String height;
    private String weight;

    public Card() {
    }

    public Card(int card_id, String first_name, String last_name, String born_date, String height, String weight) {
        this.card_id = card_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.born_date = born_date;
        this.height = height;
        this.weight = weight;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getBorn_date() {
        return born_date;
    }

    public void setBorn_date(String born_date) {
        this.born_date = born_date;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
