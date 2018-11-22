package poe.fr.banque;

public class BanqueException extends Exception {

	private static final long serialVersionUID = 1L;

	public BanqueException() {
		this("Exception Banque vide!");
	}

	public BanqueException(String pArg0) {
		super(pArg0);
	}

	public BanqueException(Throwable pArg0) {
		super(pArg0);
	}

	public BanqueException(String pArg0, Throwable pArg1) {
		super(pArg0, pArg1);
	}

	public BanqueException(String pArg0, Throwable pArg1, boolean pArg2, boolean pArg3) {
		super(pArg0, pArg1, pArg2, pArg3);
	}

}
