import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Graaf{

    //attributen
    private LinkedList<Node> nodes;




    //constuctor
    public Graaf(){
        nodes = new LinkedList<Node>();
    }



    //getters en setters (niet allemaal, indien nodig)
    public void voegNodeToe(Node n){
        nodes.add(n);
    }




    //andere methoden

    public void setBuren(int buurId1, int buurId2){
        //als dit 1 is, dan hebben we eig de buur op plek 0 nodig
        buurId1 = buurId1 -1;
        buurId2 = buurId2 -1;

        nodes.get(buurId1).setBuur(nodes.get(buurId2));
        nodes.get(buurId2).setBuur(nodes.get(buurId1));
    }


    public Staat getStaat(){
        Staat s = new Staat();

        //efficient itereren doorheen een linkedlist
        //gaat sneller met een iterator
        Iterator iterator = nodes.iterator();
        while (iterator.hasNext()){
            Node n = (Node) iterator.next();    //echt wel niet zeker alst juist is

            s.voegAantalKnikkersToe(n.getAantalKnikkers());
        }

        return s;
    }


    public void execute() {

        //bepaal het aantal knikkers dat naar elke buur moet gaan

        //itereren over de verschillende nodes
        //dit blokje code komt gwn er op neer dat we voor
        //elke node gaan instellen hoeveel hij er weg zal doen
        for(int i=0 ; i<nodes.size(); i++){
            nodes.get(i).setAantalNaarElkeBuur();//en date de waarde van het aantal knikkers ook op


        }

        //nogmaals itereren, maar nu het effectief uitvoeren
        for(int i=0; i<nodes.size(); i++){
            nodes.get(i).execute();;
        }

    }



}
