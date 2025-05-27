public class TestBellmanFord {

    public static void testResoudre() {
        Graphe g = new GrapheListe();
        g.ajouterNoeud("A");
        g.ajouterNoeud("B");
        g.ajouterNoeud("C");
        g.ajouterArc("A", "B", 5);
        g.ajouterArc("B", "C", 3);
        g.ajouterArc("A", "C", 10);

        BellmanFord bf = new BellmanFord();
        Valeurs valeurs = bf.resoudre(g, "A");

        assert valeurs.getValeur("A") == 0 : "Distance A incorrecte";
        assert valeurs.getValeur("B") == 5 : "Distance B incorrecte";
        assert valeurs.getValeur("C") == 8 : "Distance C incorrecte"; // car A->B->C = 5 + 3 = 8

        assert valeurs.getParent("B").equals("A") : "Parent B incorrect";
        assert valeurs.getParent("C").equals("B") : "Parent C incorrect";

        System.out.println("Test BellmanFord réussi.");
    }

    public static void main(String[] args) {
        testResoudre();
    }
}
