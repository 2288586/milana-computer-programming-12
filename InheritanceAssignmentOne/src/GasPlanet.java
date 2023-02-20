import java.awt.Color;

public class GasPlanet extends Planet {
    private boolean hasRings;
    private Color color;

    public GasPlanet(int orbitTime, String designation, boolean hasRings, Color color) {
        super(orbitTime, designation);

        this.hasRings = hasRings;
        this.color = color;
    }

    public boolean isHasRings() {
        return hasRings;
    }

    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return getDesignation();
    }
}