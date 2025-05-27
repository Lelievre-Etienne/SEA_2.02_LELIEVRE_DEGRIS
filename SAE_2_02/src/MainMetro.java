

public class MainMetro {
    public static void main(String[] args) {
        Graphe graphe = LireReseau.lire("metro.txt");

        String[][] trajets = {
                {"1", "20"},
                {"5", "14"},
                {"12", "33"},
                {"2", "17"},
                {"9", "28"}
        };

        for (String[] trajet : trajets) {
            String depart = trajet[0];
            String arrivee = trajet[1];

            long start1 = System.nanoTime();
            List<String> cheminBellman = BellmanFord.resoudre(graphe, depart, arrivee);
            long tempsBellman = System.nanoTime() - start1;

            long start2 = System.nanoTime();
            List<String> cheminDijkstra = Dijkstra.resoudre(graphe, depart, arrivee);
            long tempsDijkstra = System.nanoTime() - start2;

            System.out.println("Départ : " + depart + ", Arrivée : " + arrivee);
            System.out.println("Chemin Bellman-Ford : " + cheminBellman);
            System.out.println("Temps Bellman-Ford : " + (tempsBellman / 1_000_000.0) + " ms");
            System.out.println("Chemin Dijkstra : " + cheminDijkstra);
            System.out.println("Temps Dijkstra : " + (tempsDijkstra / 1_000_000.0) + " ms\n");

            List<String> cheminBellman2 = BellmanFord.resoudre2(graphe, depart, arrivee);
            List<String> cheminDijkstra2 = Dijkstra.resoudre2(graphe, depart, arrivee);

        }
    }
}
