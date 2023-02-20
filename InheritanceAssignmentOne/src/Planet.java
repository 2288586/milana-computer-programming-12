import java.util.ArrayList;
import java.util.List;

public class Planet {
    private int orbitTime;
    private ArrayList<Moon> moons;
    private String designation;

    public Planet() {
        this(0, "");
    }

    public Planet(int orbitTime, String designation) {
        this.orbitTime = orbitTime;
        this.designation = designation;

        moons = new ArrayList<>();
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getOrbitTime() {
        return orbitTime;
    }

    public void setOrbitTime(int orbitTime) {
        this.orbitTime = orbitTime;
    }

    public void addMoon(Moon moon) {
        moons.add(moon);
    }

    public List<Moon> getMoons() {
        return moons;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Planet) {
            Planet otherPlanet = (Planet) object;

            if (this.designation.equals(otherPlanet.designation)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return designation;
    }
}