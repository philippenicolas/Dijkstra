package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Graph {


    private List<Vertex> vertices = new ArrayList<Vertex>();

    public Graph(Vertex... vertices) {
        this.vertices.addAll(Arrays.asList(vertices));
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public int getDistance(String from, String to) {
        int result=0;
        boolean distance_existe= false;
        int i;
        for(i=0;i<vertices.size();i++) {
           if (vertices.get(i).getName().equals(from)){
              distance_existe=true;
              result=(vertices.get(i)).getDistanceVertex(to);
           }

       }
       if (!distance_existe){
           return  1000000;
       }
        else return result ;

    }


    public int getDistancebyDijkstra(String paris, String lyon) {
        if (vertices.size()<1){
            return 1000000;
        }
        else{
            Tableaudijkstra  tab = new Tableaudijkstra( this,paris);
            tab.algoDijkstra();
            return tab.distancefinale( lyon);
        }
    }


}
