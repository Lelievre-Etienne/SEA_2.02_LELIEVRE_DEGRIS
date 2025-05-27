public class Arc {
    private String dest;
    private double cout;
    private String ligne;

    public Arc(String dest, double cout) {
        this.dest = dest;
        this.cout = cout;
        this.ligne = ligne;
    }


    public String getDest() {
        return dest;
    }

    public double getCout() {
        return cout;
    }

    public String getLigne() {
        return ligne;
    }

    public String toString() {
        return dest + "(" + cout + ")";
    }
}



