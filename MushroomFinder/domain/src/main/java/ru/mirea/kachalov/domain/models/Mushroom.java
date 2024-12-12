package ru.mirea.kachalov.domain.models;

public class Mushroom {

    private String name;
    private String commonname;
    private String agent;
    private String[] distribution;
    private String img;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonname() {
        return commonname;
    }

    public void setCommonname(String commonname) {
        this.commonname = commonname;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String[] getDistribution() {
        return distribution;
    }

    public void setDistribution(String[] distribution) {
        this.distribution = distribution;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Mushroom{" +
                ", name='" + name + '\'' +
                '}';
    }

}