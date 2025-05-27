import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/*Entrées :
G un graphe orienté avec une pondération positive des arcs
(coût ou poids)
A un sommet (départ) de G
Début
Q <- {} // utilisation d'une liste de noeuds à traiter
Pour chaque sommet v de G faire
v.valeur <- Infini
v.parent <- Indéfini
Q <- Q U {v} // ajouter le sommet v à la liste Q
Fin Pour
A.valeur <- 0
Tant que Q est un ensemble non vide faire
u <- un sommet de Q telle que u.valeur est minimal
// enlever le sommet u de la liste Q
Q <- Q \ {u}
Pour chaque sommet v de Q tel que l'arc (u,v) existe faire
d <- u.valeur + poids(u,v)
Si d < v.valeur
// le chemin est plus interessant
Alors v.valeur <- d
v.parent <- u
Fin Si
Fin Pour
Fin Tant que
Fin */
public class Dijkstra {

    public Valeurs resoudre(GrapheListe g, String depart) {
        Valeurs resultats = new Valeurs();

        Set<String> Q = new HashSet<>();

        for (String noeud : g.getNoeuds()) {
            resultats.distance.put(noeud, Double.POSITIVE_INFINITY);
            resultats.parent.put(noeud, null);
            Q.add(noeud);
        }

        resultats.distance.put(depart, 0.0);

        while (!Q.isEmpty()) {
            String u = null;
            double minDistance = Double.POSITIVE_INFINITY;
            for (String noeud : Q) {
                double dist = resultats.distance.get(noeud);
                if (dist < minDistance) {
                    minDistance = dist;
                    u = noeud;
                }
            }

            if (u == null) {
                break;
            }

            Q.remove(u);

            ArrayList<GrapheListe.Arc> voisins = g.getVoisins(u);
            for (GrapheListe.Arc arc : voisins) {
                String v = arc.destination;
                if (Q.contains(v)) {
                    double d = resultats.distance.get(u) + arc.poids;
                    if (d < resultats.distance.get(v)) {
                        resultats.distance.put(v, d);
                        resultats.parent.put(v, u);
                    }
                }
            }

            for (Arc arc : graphe.suivants(u)) {
                String v = arc.getDestination();
                int coutArc = arc.getCout();
                if (!lignePrecedente.equals("") && !arc.getLigne().equals(lignePrecedente)) {
                    coutArc += 10; // pénalité de changement
                }
        }

        return resultats;
    }
}
