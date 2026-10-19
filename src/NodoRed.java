public class NodoRed {

    private String identifier ;
    private int maxConections;
    private int activeConections = 0;
    static int counter = 0;




    public NodoRed (String identifier, int maxConections , int activeConections){
        boolean identifierOk = setIdentifier(identifier);
        boolean maxConectionsOk = setMaxConections(maxConections);
        boolean activeConectionsOk = setActiveConections(activeConections);
        if(identifierOk && maxConectionsOk && activeConectionsOk){
            counter = counter +1 ;
        }else{
            System.out.println("El objeto no se ha creado correctamente");
        }
    }

    private boolean setIdentifier(String identifier) {
        if(identifier != null && !identifier.trim().isEmpty()){
            this.identifier = identifier;
            return true;
        }
        return false;
    }

    private boolean setMaxConections(int maxConections){
        if(maxConections > 0){
            this.maxConections = maxConections;
            return true;
        }
        return false;
    }

    public boolean setActiveConections(int activeConections) {

        if(activeConections <= maxConections && activeConections >= 0 ){
            System.out.println("Numero de conexiones modificado");
            this.activeConections = activeConections;
            return true;
        }

        if(activeConections > maxConections){
            System.out.println("Error ese numero excede el numero maximo de conexiones que es: " + getMaxConections());
        }

        if (activeConections < 0 ){
            System.out.println("Error no se pueden ingresar numeros negativos");
        }

        return false;
    }


    public String getIdentifier() {
        return identifier;
    }

    public int getMaxConections() {
        return maxConections;
    }

    public int getActiveConections() {
        return activeConections;
    }

    public static int getCounter() {
        return counter;
    }



    public void connect(){
        if(activeConections < maxConections){
            activeConections = activeConections +1;
            System.out.println("Se ha anadido una conexion con exito, el numero de conexiones es: " + activeConections);
        }
        if(activeConections == maxConections){
            System.out.println("No se puede anadir una conexion mas, capacidad llena");
        }
    }

    public void disconnect(){
        if(activeConections == 0){
            System.out.println("No se puede desconectar ya que no hay nada conectado");
        }
        if(activeConections > 0){
            activeConections = activeConections -1 ;
            System.out.println("Se ha desconectado una conexion con extio, numero de conexiones restantes: " + activeConections);
        }
    }

    public void showCounter(){
        System.out.println("Hay: " +  counter + " objetos");
    }


    public void showContador(){
        System.out.println("----DATOS DEL NODO" + identifier + "----");
        System.out.println("El numero maximo de conexiones permitido es: " + getMaxConections());
        System.out.println("El numero de conexiones activas es: " + getActiveConections());
        System.out.println("Este objeto es el numero: " + counter);
        System.out.println("------------------------------------------");
    }




}
