package Domain;

import java.util.Objects;

public class Eveniment extends Entity {

    private String name, date, duration, startingTime;

    public Eveniment(String id, String name, String date, String duration, String startingTime) {
        super(id);
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.startingTime = startingTime;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Eveniment eveniment = (Eveniment) o;
        return this.getId().equals(eveniment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, date, duration, startingTime);
    }

    @Override
    public String toString() {
        return "Eveniment{" +
                ", id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", duration='" + duration + '\'' +
                ", startingTime='" + startingTime + '\'' +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }



}
