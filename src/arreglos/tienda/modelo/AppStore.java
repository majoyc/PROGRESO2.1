package arreglos.tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego juegos[];
    private int indice;

    public AppStore(){
        juegos = new Juego [MAX];
        indice = -1;
        cargarDatos();
    }
    public void cargarDatos(){
        juegos[++indice] = new Juego("Fifa2026", "Deportes",  15,  45,  50);
        juegos[++indice] = new Juego("Roblox", "Accion",  23,  59,  50);
    }
    public Juego[] getJuegos() {
        return juegos;
    }

    public void agregarJuego(Juego j){ //en vez del set()
        if(j != null && indice < MAX -1){
            juegos[++indice] = j;
        }
    }
    public Juego buscarJuego(String nombre){
        for(int i = 0; i < MAX; i++){
            if(juegos[1].getNombre().equalsIgnoreCase(nombre)){
                return juegos[i];
            }
        }
        return null;
    }
    public boolean comprar(String nombre, int cantidad){
        Juego j1 = buscarJuego(nombre);
        if(j1 != null){
            return j1.comprar(cantidad);
        }
        return false;
    }
    public double vender(String nombre, int cantidad){
        Juego j1 = buscarJuego(nombre);
        if(j1 != null){
            if (j1.vender(cantidad)){
                return cantidad * j1.getPrecio();
            }
        }
        return 0;
    }
    public String sacarJuegos(){
        String juegoS = "";
        for(int i = 0; 1 < indice; i++){
            juegoS += juegos[i];
            juegoS += "\n";
        }
        return !juegoS.trim().isBlank()?juegoS:"No hay juegos a mostrar";
    }
}
