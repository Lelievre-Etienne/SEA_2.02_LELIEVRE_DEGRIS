import java.io.*;
import java.util.*;

public class LireReseaux {
    public static Graphe lire(String fichier) throws IOException {
        GrapheListe graphe = new GrapheListe();
        Map<String, String> stations = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String ligne;
        boolean lectureConnexions = false;

        while ((ligne = br.readLine()) != null) {
            if (ligne.startsWith("%")) continue;
            if (ligne.startsWith("%% Connexions:")) {
                lectureConnexions = true;
                continue;
            }

            if (!lectureConnexions) {
                // Partie des stations
                String[] parts = ligne.split(":");
                String idStation = parts[0];
                stations.put(idStation, idStation); // ou stocke nom pour affichage si besoin
            } else {
                // Partie des connexions
                String[] parts = ligne.split(":");
                String depart = parts[0];
                String arrivee = parts[1];
                int cout = Integer.parseInt(parts[2]);
                String numLigne = parts[3];

                // Ajout bidirectionnel
                graphe.ajouterArc(depart, new Arc(arrivee, cout, numLigne));
                graphe.ajouterArc(arrivee, new Arc(depart, cout, numLigne));
            }
        }

        br.close();
        return graphe;
    }
}
