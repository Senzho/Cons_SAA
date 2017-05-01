package LogicaNegocio;

public class Asesor {
    private String numeropersonal;
    private String idioma;

    public Asesor(String numeropersonal, String idioma) {
        this.numeropersonal = numeropersonal;
        this.idioma = idioma;
    }

    public String getNumeropersonal() {
        return numeropersonal;
    }
    public String getIdioma() {
        return idioma;
    }
}
