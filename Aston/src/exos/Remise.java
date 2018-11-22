package exos;

import java.math.BigDecimal;

public enum Remise {

	COURANTE(new BigDecimal("0.05")){
		@Override
		public String toString() { return "Remise 5%" ;}
	},
	FIDELITE(new BigDecimal("0.07")){
		@Override
		public String toString() { return "Remise fidélité 7%" ;}
	},
	EXCEPTIONNELLE(new BigDecimal("0.10")){
		@Override
		public String toString() { return "Remise exceptionnelle 10%" ;}
	};
	
	private BigDecimal taux ;
	
    Remise(BigDecimal taux)
    {
        this.taux= taux;
    }

	public BigDecimal getTaux() {
		return taux;
	}
	
	public BigDecimal calculer(BigDecimal valeur) {
		return valeur.multiply(taux);
	}
}
