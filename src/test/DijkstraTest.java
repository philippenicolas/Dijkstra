package test;

import main.Graph;
import main.Tableaudijkstra;
import main.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class DijkstraTest {
    private Vertex lille = new Vertex("Lille");
    private Vertex paris = new Vertex("Paris");
    private Vertex reims = new Vertex("Reims");
    private Vertex nancy = new Vertex("Nancy");
    private Vertex lyon = new Vertex("Lyon");
    private Vertex marseille = new Vertex("Marseille");
    private Vertex lemans = new Vertex("Le Mans");
    private Vertex nantes = new Vertex("Nantes");
    private Vertex bordeaux = new Vertex("Bordeaux");
    private Vertex toulouse = new Vertex("Toulouse");
    private Vertex clermont = new Vertex("Clermont Ferrant");
    private Vertex montpellier = new Vertex("Montpellier");

    @Before
    public void setup() {
        lille.connectTo(reims, 206);
        lille.connectTo(paris, 222);
        lille.connectTo(nancy, 418);

        reims.connectTo(paris, 144);
        reims.connectTo(nancy, 245);
        reims.connectTo(lyon, 489);

        paris.connectTo(lyon, 465);
        paris.connectTo(lemans, 208);
        paris.connectTo(clermont, 423);

        lyon.connectTo(clermont, 166);
        lyon.connectTo(marseille, 313);
        lyon.connectTo(montpellier, 304);

        lemans.connectTo(nantes, 189);
        lemans.connectTo(bordeaux, 443);

        nantes.connectTo(bordeaux, 347);

        bordeaux.connectTo(toulouse, 243);

        toulouse.connectTo(montpellier, 245);

        montpellier.connectTo(marseille, 169);
        montpellier.connectTo(toulouse, 245);

        marseille.connectTo(montpellier, 169);

        clermont.connectTo(lyon, 166);
        clermont.connectTo(montpellier, 333);
        clermont.connectTo(marseille, 474);
    }

    @Test
    public void initialisaionDijkstra() {
        Graph graph= new Graph(paris, lyon,lille, reims, lemans,montpellier, marseille, nantes, toulouse, nancy, bordeaux);

        ArrayList<Integer> distances = new ArrayList() {{ add(0); add(465); add(1000000);add(1000000);add(208);
            add(1000000);add(1000000);add(1000000);add(1000000);add(1000000);add(1000000); }};

        Tableaudijkstra dijkstra= new Tableaudijkstra( graph, "Paris") ;
        assertEquals(dijkstra.getDistances(), distances);
    }

    @Test
    public void rechminimum() {
        Graph graph= new Graph(paris, lyon,lille, reims, lemans,montpellier, marseille, nantes, toulouse, nancy, bordeaux);

        Tableaudijkstra dijkstra= new Tableaudijkstra( graph, "Paris") ;
        assertEquals(dijkstra.plusprochenoeudnonparcouru(), 4);
    }


    @Test
    public void etapeDijkstratest() {
        Graph graph= new Graph(paris, lyon,lille, reims, lemans,montpellier, marseille, nantes, toulouse, nancy, bordeaux);

        ArrayList<Integer> distances = new ArrayList() {{ add(0); add(465); add(1000000);add(1000000);add(208);
            add(1000000);add(1000000);add(397);add(1000000);add(1000000);add(651); }};

        Tableaudijkstra dijkstra= new Tableaudijkstra( graph, "Paris") ;
        dijkstra.etapeDijkstra();
        assertEquals(dijkstra.getDistances(), distances);
    }



}
