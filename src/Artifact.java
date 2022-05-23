public class Artifact {
    int ordinal;
    String culture;
    int century;

    public Artifact (int ordinal){
        this.ordinal = ordinal;
    }

    public Artifact (int ordinal, String culture){
        this.ordinal = ordinal;
        this.culture = culture;
    }
    public Artifact (int ordinal, String culture, int century){
        this.ordinal = ordinal;
        this.culture = culture;
        this.century = century;
    }
    public static void main (String[] args){

        Artifact Object1 = new Artifact(212121);
        Artifact Object2 = new Artifact(212121, "Aztecs");
        Artifact Object3 = new Artifact(212121,"Aztecs", 12);
    }
}
