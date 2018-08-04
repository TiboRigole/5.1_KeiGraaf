import java.util.Iterator;
import java.util.LinkedList;

public class Node {

    //attributen
    private int aantalKnikkers;
    private int aantalNaarElkeBuur;
    private LinkedList<Node> buren;




    //constuctor
    public Node(int startKnikkers){
        aantalKnikkers = startKnikkers;
        aantalNaarElkeBuur = 0;
        buren = new LinkedList<Node>();
    }




    //getters en setters (niet allemaal, indien nodig)

    public void voegBuurToe(Node buur){
        buren.add(buur);    //geen diepe kopie!
    }

    public void setBuur(Node node) {
        buren.add(node);
    }

    public int getAantalKnikkers(){
        return aantalKnikkers;
    };

    public void setAantalNaarElkeBuur() {
        if(aantalKnikkers>= buren.size() ){
            aantalNaarElkeBuur = aantalKnikkers/buren.size();
            aantalKnikkers = aantalKnikkers - ( aantalNaarElkeBuur*buren.size());
        }
        else{
            //dus als het aantal buren groter is
            aantalNaarElkeBuur = 0;
        }
    }

    //voegt het aantal knikkers toe bij elk van zn buren
    public void execute() {

        for(int i=0; i<buren.size(); i++){
            buren.get(i).voegKnikkersToe(aantalNaarElkeBuur);
        }
    }


    //andere methoden
    public void voegKnikkersToe(int aantalToeTeVoegen){
        aantalKnikkers = aantalKnikkers + aantalToeTeVoegen;
    }


}
