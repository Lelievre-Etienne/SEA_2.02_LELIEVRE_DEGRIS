public class BellmanFord {

    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();

        // Initialisation
        for (String noeud : g.getNoeuds()) {
            valeurs.setValeur(noeud, Double.MAX_VALUE);
            valeurs.setParent(noeud, null);
        }
        valeurs.setValeur(depart, 0);

        boolean modif = true;
        while (modif) {
            modif = false;
            for (String X : g.getNoeuds()) {
                for (String N : g.getAdjacents(X)) {
                    double cout = g.getCoutArc(X, N);
                    double nouvelleValeur = valeurs.getValeur(X) + cout;
                    if (nouvelleValeur < valeurs.getValeur(N)) {
                        valeurs.setValeur(N, nouvelleValeur);
                        valeurs.setParent(N, X);
                        modif = true;
                    }
                }
            }
        }
        return valeurs;
    }
}
