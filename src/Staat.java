import java.util.LinkedList;

public class Staat {


    //attributen
    private LinkedList<Integer> aantalKnikkers;

    //constuctor
    public Staat(){
        aantalKnikkers = new LinkedList<Integer>();
    }

    //getters en setters (niet allemaal, indien nodig)
    public void voegAantalKnikkersToe(int aantalk){
        aantalKnikkers.add(aantalk);
    }





    //andere methoden

    public boolean equals(Staat andereStaat){
        //System.out.println("zelfgemaakte equals ");

        for(int i=0; i<aantalKnikkers.size(); i++){

            if(aantalKnikkers.get(i) != andereStaat.aantalKnikkers.get(i)){return false;}
        }

        //als we hier graken dan zijn alle knikkerwaarden gelijk
        return true;
    }


}
