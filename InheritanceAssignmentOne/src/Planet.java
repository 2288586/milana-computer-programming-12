import java.util.ArrayList;

public class Planet {
    private int orbitTime;
    private ArrayList<Moon> moons;
    private String designation;

    public Planet() {
        this.orbitTime = 0;
        this.designation = "";

        moons = new ArrayList<>();
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

    public ArrayList<Moon> getMoons() {
        return moons;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Planet) {
            Planet otherPlanet = (Planet) object;

            if (this.designation.equals(otherPlanet.getDesignation())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Planet{orbitTime=" + orbitTime + ", moons=" + moons + ", designation='" + designation + "'}";
    }
}