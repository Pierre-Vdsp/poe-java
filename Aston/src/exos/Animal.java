package exos;

public enum Animal {

	KANGOUROU ("kangourou", false),
	TIGRE("tigre", false),
	CHIEN("chien", true),
	SERPENT("serpent", false, "tropical"),
	CHAT("chat", true) ;

    private final String environnement;
    private final String nom;
    private final boolean domestique;

    Animal(String nom, boolean domestique)
    { this(nom, domestique, null); }

    Animal(String nom, boolean domestique, String environnement)
    {
        this.nom = nom;
        this.domestique = domestique;
        this.environnement = environnement;
    }

    public String getNom(){ return this.nom; }
    public String getEnvironnement(){ return this.environnement; }
    public boolean isDomestique(){ return this.domestique; }
}
