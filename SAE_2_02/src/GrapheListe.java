import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    private List<String> noeuds;
    private List<Arcs> adjacence;

    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    public GrapheListe(String nomFichier) {
        dico = new Arcs();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parties = ligne.split("\t");
                if (parties.length == 3) {
                    String origine = parties[0];
                    String destination = parties[1];
                    double cout = Double.parseDouble(parties[2]);

                    this.ajouterArc(origine, destination, cout);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    private int getIndice(String n) {
        return noeuds.indexOf(n);
    }

    public List<String> listeNoeuds() {
        return noeuds;
    }

    public List<Arc> suivants(String n) {
        int i = getIndice(n);
        if (i != -1) {
            return adjacence.get(i).getArcs();
        }
        return new ArrayList<>();
    }

    public void ajouterNoeud(String nomNoeud) {
        if (!noeuds.contains(nomNoeud)) {
            noeuds.add(nomNoeud);
            // Ici on ajoute une nouvelle liste vide d'arcs pour ce noeud
            adjacence.add(new ArrayList<Arc>());
        }
    }


    public void ajouterArc(String depart, String destination, double cout) {
        if (!noeuds.contains(depart)) {
            noeuds.add(depart);
            adjacence.add(new Arcs());
        }
        if (!noeuds.contains(destination)) {
            noeuds.add(destination);
            adjacence.add(new Arcs());
        }

        int indexDepart = getIndice(depart);
        adjacence.get(indexDepart).ajouterArc(new Arc(destination, cout));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < noeuds.size(); i++) {
            sb.append(noeuds.get(i)).append(" -> ");
            for (Arc a : adjacence.get(i).getArcs()) {
                sb.append(a.toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
