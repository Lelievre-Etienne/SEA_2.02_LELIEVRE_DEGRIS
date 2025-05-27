import java.util.List;

public class TestGraphe {
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();

        g.ajouterArc("X", "Y", 2.5);
        g.ajouterArc("X", "Z", 1.5);

        assert g.listeNoeuds().contains("X");
        assert g.listeNoeuds().contains("Y");
        assert g.listeNoeuds().contains("Z");

        List<Arc> arcs = g.suivants("X");
        assert arcs.size() == 2;
        assert arcs.get(0).getDest().equals("Y");
        assert arcs.get(0).getCout() == 2.5;
        assert arcs.get(1).getDest().equals("Z");

        System.out.println("Test Graphe :");
        System.out.println(g);
    }
}
