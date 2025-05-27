public class Main {
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "C", 4);
        g.ajouterArc("A", "D", 7);
        g.ajouterArc("B", "E", 9);
        g.ajouterArc("C", "B", 1);
        g.ajouterArc("C", "F", 6);
        g.ajouterArc("D", "C", 2);
        g.ajouterArc("D", "F", 3);
        g.ajouterArc("E", "G", 5);
        g.ajouterArc("F", "E", 1);
        g.ajouterArc("F", "G", 7);

        System.out.println(g);

        Graphe g2 = new GrapheListe();

        g2.ajouterNoeud("A");
        g2.ajouterNoeud("B");
        g2.ajouterNoeud("C");
        g2.ajouterArc("A", "B", 5);
        g2.ajouterArc("B", "C", 3);
        g2.ajouterArc("A", "C", 10);

        BellmanFord bf = new BellmanFord();
        Valeurs res = bf.resoudre(g2, "A");

        System.out.println(res.toString());
    }
    }
}
