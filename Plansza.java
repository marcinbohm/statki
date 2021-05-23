public class Plansza {

    private String imię, nazwisko;
    boolean[][] plansza;

    public String getImię(){
        return this.imię;
    }

    public String getNazwisko(){
        return this.nazwisko;
    }

    Plansza(String imię, String nazwisko, int x, int y){
        plansza = new boolean[x][y];
        this.imię = imię;
        this.nazwisko = nazwisko;
    }

    public boolean putJednomasztowiec(int x, int y){
        return plansza[x][y] = true;
    }

    public boolean[] putDwumasztowiec(int x, int y, int z, int w){
        boolean[] wspolrzedne = new boolean[2];

        boolean wspol1, wspol2;

        if(y+1<w || y-1>w || x+1<z || x-1>z){
            System.out.println("Podane współrzędne nie są obok siebie!");
        } else{
            plansza[x][y] = true;
            plansza[z][w] = true;
            wspolrzedne[0] = plansza[x][y];
            wspolrzedne[1] = plansza[z][w];

        }

        return wspolrzedne;
    }

    public boolean shot(int x, int y){
        boolean result;
        if(plansza[x][y]){
            System.out.println("Trafiony");
            plansza[x][y] = false;
            result = plansza[x][y];
        } else {
            System.out.println("Pudło");
            plansza[x][y] = true;
            result = plansza[x][y];
        }
        return result;
    }

    public static void main(String[] args) {

        Plansza player1 = new Plansza("Marcin","Bohm",5,5);

        player1.putJednomasztowiec(1,1);
        player1.putDwumasztowiec(1,2,2,4);
        player1.shot(1,2);

        System.out.println("Plansza gracza: "+player1.getImię()+" "+player1.getNazwisko());
        for(int i=0;i< player1.plansza.length;i++){
            for(int j=0;j<player1.plansza.length;j++){
                System.out.print(" |"+player1.plansza[i][j]+"| ");
            }
            System.out.println();
        }
    }
}
