public class MainDijkstra {

    public static void main(String[] args) {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterNoeud("A");
        graphe.ajouterNoeud("B");
        graphe.ajouterNoeud("C");
        graphe.ajouterNoeud("D");

        graphe.ajouterArc("A", "B", 1);
        graphe.ajouterArc("A", "C", 4);
        graphe.ajouterArc("B", "C", 2);
        graphe.ajouterArc("B", "D", 5);
        graphe.ajouterArc("C", "D", 1);

        Dijkstra dijkstra = new Dijkstra();
        Valeurs resultats = dijkstra.resoudre(graphe, "A");

        for (String noeud : graphe.getNoeuds()) {
            System.out.println("Distance de A à " + noeud + " : " + resultats.distance.get(noeud));
            System.out.print("Chemin : ");
            printChemin(resultats, noeud);
            System.out.println();
        }
    }

    public static void printChemin(Valeurs vals, String noeud) {
        if (vals.parent.get(noeud) != null) {
            printChemin(vals, vals.parent.get(noeud));
        }
        System.out.print(noeud + " ");
    }
}
