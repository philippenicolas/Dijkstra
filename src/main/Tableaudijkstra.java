package main;

import java.util.ArrayList;
import java.util.List;


public class Tableaudijkstra {
    private List<Vertex> noeuds = new ArrayList<Vertex>();
    private List<Boolean> dejaparcouru= new ArrayList<Boolean>();

    private List<Integer> distances= new ArrayList<Integer>();

    public List<Integer> getDistances() {
        return distances;
    }

    public Tableaudijkstra(Graph graph, String depart) {
        noeuds=graph.getVertices();
        int i;
        int positiondepart=1000000;
        for(i=0;i<noeuds.size();i++) {
            if (noeuds.get(i).getName().equals(depart)){
                dejaparcouru.add(true);
                distances.add(0);
                positiondepart=i;
            }
            else{
                dejaparcouru.add(false);
                distances.add(1000000);
            }
        }
        int k;
        int j;
        List<Edge> voisinsdéparts= noeuds.get(positiondepart).getEdges();
        for( k=0;k<(voisinsdéparts.size());k++){
            Edge voisindepart = (voisinsdéparts).get(k);

            for(j=0;j<noeuds.size();j++) {
                if (noeuds.get(j).equals(voisindepart.getTarget())){
                     distances.set(j, voisindepart.getDistance());

                }
            }

        }
    }

    public int plusprochenoeudnonparcouru () {
        int i;
        int minimum= 10000000;
        int position=0;
        for (i=0;i<noeuds.size();i++){
            if(!(dejaparcouru.get(i))&&((distances.get(i))<minimum)){
                position=i;
                minimum=distances.get(i);

            }

        }
     return position;
    }

    public void etapeDijkstra() {
        int position =this.plusprochenoeudnonparcouru();
        int i;
        int j;
        List<Edge> voisinsminimums= noeuds.get(position).getEdges();
        for( i=0;i<(voisinsminimums.size());i++){
            Edge voisinminimum = (voisinsminimums).get(i);

            for(j=0;j<noeuds.size();j++) {
                if (noeuds.get(j).equals(voisinminimum.getTarget())){
                    distances.set(j, distances.get(position)+voisinminimum.getDistance());

                }
            }

        }
      dejaparcouru.set(position,true);

    }
    public void algoDijkstra() {
        int i;
        for (i=0;i<noeuds.size();i++){
            this.etapeDijkstra();




        }
    }


    public int distancefinale(String arrivee) {
        int i;
        int positionarrivee= 1000000;
        for(i=0;i<noeuds.size();i++) {
            if (noeuds.get(i).getName().equals(arrivee)){

                positionarrivee=i;
            }
        }
        if (positionarrivee== 1000000) {
            return 1000000;
        }
        else{
            return distances.get(positionarrivee);
        }
    }
}
