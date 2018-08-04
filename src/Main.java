import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*Graaf graaf = new Graaf();
        HashMap<Integer,Staat> staten = new HashMap<Integer,Staat>();

        graaf.voegNodeToe(new Node(5));
        graaf.voegNodeToe(new Node(3));
        graaf.voegNodeToe(new Node(2));

        graaf.setBuren(1,2);//1 is buur van 2 en omgekeerd
        graaf.setBuren(2,3);
        graaf.setBuren(1,3);//lijkt ook*/

        //dit zou de input verwerking moeten zijn

        //telkens volgende
        /*Staat s = graaf.getStaat(); //hierin wordt een niewe staat gemaakt, dus geen kopies van elkaar met crossrefs

        //beginsituatie
        staten.put(0,s);
        graaf.execute();

        //na 1x
        staten.put(1,s);
        graaf.execute();



        //na 2x
        s = graaf.getStaat();
        int zelfde = checkIfAlAanwezig(s,staten);
        staten.put(2,s);
        graaf.execute();

        //na 3x
        s = graaf.getStaat();
        zelfde = checkIfAlAanwezig(s,staten);
        staten.put(3,s); //Deze zou hetzelfde moeten zijn als de 2e staat, dus die op plek 1
        graaf.execute();

        s = graaf.getStaat();
        zelfde = checkIfAlAanwezig(s,staten);


        s = graaf.getStaat();
        zelfde = checkIfAlAanwezig(s,staten);
        graaf.getStaat();
        staten.put(4,s);

        //eig is 1 iteratie
        //execute: staten.execute
        //s = graaf.getStaat
        //int zelfde = checkIfAlAanwezig(s,staten)
        //staten.put()

        System.out.println("einde");*/

        /*alles hierboven moet nog weg, dit was tijdelijk om te debuggen*/

        Scanner sc = new Scanner(System.in);

        int aantalTestGevallen = Integer.parseInt(sc.nextLine());

        int aantalKnopen = 0;
        int aantalVertices =0;

        for(int testGeval = 0; testGeval<aantalTestGevallen; testGeval++){

            Graaf graaf = new Graaf();


            aantalKnopen = Integer.parseInt(sc.nextLine());

            //overlopen met aantal knopen en hun aantal knikkers
            for(int i=0; i<aantalKnopen; i++){

                graaf.voegNodeToe(new Node(Integer.parseInt(sc.nextLine())));

            }

            aantalVertices = Integer.parseInt(sc.nextLine());

            for(int i=0 ; i<aantalVertices; i++){

                //inlezen van 2 4
                String line = sc.nextLine();
                String[] liner = line.split(" ");
                int eersteBuur = Integer.parseInt(liner[0]);
                int tweedeBuur = Integer.parseInt(liner[1]);
                graaf.setBuren(eersteBuur,tweedeBuur);


            }//einde van de input


            //verwerking

            int teller = 1;
            int found = -1;
            Staat staat = graaf.getStaat();
            HashMap<Integer,Staat> staten = new HashMap<Integer,Staat>();

            staten.put(0,staat);

            while(found == -1){

                graaf.execute();
                staat = graaf.getStaat();

                found = checkIfAlAanwezig(staat, staten);

                staten.put(teller, staat);

                teller++;
            }

            //we zitten altijd 1tje te ver, dus
            teller = teller-1;

            //System.out.println("teller: "+teller);
            //System.out.println("herkend op: "+found);
            System.out.println(teller-found);















        }








    }

    private static int checkIfAlAanwezig(Staat checkStaat, HashMap<Integer,Staat> staten) {
        //als niet aanwezig, returnt -1,
        //als wel aanwezig, returnt de key van deze waarde, dusja
        Staat andereStaat;
        for(int i=0; i<staten.size(); i++){

            andereStaat = staten.get(i);

            if(checkStaat.equals(andereStaat)){
                return i;
            }

        }

        //als der dus geen gelijke is
        return -1;
    }
}
