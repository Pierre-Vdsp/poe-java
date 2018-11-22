package poe.tp.aspirator;

public class Aspi {

	private int x, y, sizeX, sizeY;

	private char dir;

	public Aspi(char pSizeX, char pSizeY, char pX, char pY, char pDir) {
		this(Integer.valueOf(pSizeX), Integer.valueOf(pSizeY), Integer.valueOf(pX), Integer.valueOf(pY), pDir);
	}

	public Aspi(int pSizeX, int pSizeY, int pX, int pY, char pDir) {
		this.setX(pX);
		this.setY(pY);
		this.setDir(pDir);
		this.setSizeX(pSizeX);
		this.setSizeY(pSizeY);
	}

	public void afficher() {
		String desc = this.getX() + " ";
		if ((this.getSizeY() - this.getY()) >= 0) {
			desc += (this.getSizeY() - this.getY());
		} else {
			desc += (this.getSizeY() - this.getY()) * -1;
		}
		desc += " " + this.getDir();
		System.out.println(desc);
	}

	public void charCommand(char cmd) {
		switch (cmd) {
		case 'D':

			switch (this.getDir()) {
			case 'N':
				this.setDir('E');
				break;
			case 'W':
				this.setDir('N');
				break;
			case 'E':
				this.setDir('S');
				break;
			case 'S':
				this.setDir('W');
				break;
			}
			break;
		case 'G':

			switch (this.getDir()) {
			case 'N':
				this.setDir('W');
				break;
			case 'W':
				this.setDir('S');
				break;
			case 'E':
				this.setDir('N');
				break;
			case 'S':
				this.setDir('E');
				break;
			}
			break;

		case 'A':
			switch (this.getDir()) {
			case 'N':
				this.setY(this.getY() - 1);
				break;
			case 'W':
				this.setX(this.getX() - 1);
				break;
			case 'E':
				this.setX(this.getX() + 1);
				break;
			case 'S':
				this.setY(this.getY() + 1);
				break;
			}
			break;
		}
	}

	public int getSizeX() {
		return this.sizeX;
	}

	public void setSizeX(int pSizeX) {
		this.sizeX = pSizeX;
	}

	public int getSizeY() {
		return this.sizeY;
	}

	public void setSizeY(int pSizeY) {
		this.sizeY = pSizeY;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int pX) {
		if (pX > 0) {
			this.x = this.getSizeX() > pX ? pX : pX - this.getSizeX();
		} else {
			this.x = (this.getX() + pX) > 0 ? pX : 0;
		}
	}

	public int getY() {
		return this.y;
	}

	public void setY(int pY) {
		if (pY < 0) {
			this.y = this.getSizeY() > pY ? pY : pY - this.getSizeY();
		} else {
			this.y = (this.getY() + pY) > 0 ? pY : 0;
		}
	}

	public char getDir() {
		return this.dir;
	}

	public void setDir(char pDir) {
		this.dir = pDir;
	}
}
