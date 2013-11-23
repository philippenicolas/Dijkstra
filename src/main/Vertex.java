package main;

import java.util.ArrayList;
import java.util.List;


public class Vertex {

    private String name;



    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    private List<Edge> edges = new ArrayList<Edge>();

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void connectTo(Vertex target, int distance) {
        edges.add(new Edge(target, distance));
    }

    public int getDistanceVertex (String target) {
        int result=0;
        boolean target_existe= false;
        int i;
        for(i=0;i<edges.size();i++) {
            if (((edges.get(i)).getTarget()).getName().equals(target)){
                target_existe=true;
                result=(edges.get(i)).getDistance();
            }

        }
        if (target_existe){
            return  result;
        }
        else return 1000000;
    }

}
