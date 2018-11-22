package poe.tp.wow;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import poe.tp.wow.characters.Characters;

public class Team<T extends Characters> {

	private List<Characters> characters = new ArrayList<Characters>();

	public void checkCharactersDeath() {
		for (int i = 0; i < this.characters.size(); i++) {
			if (this.characters.get(i).getHealthPoints() == 0) {
				System.out.println(this.characters.remove(i).getName() + " dieded!");
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void createTeamOf(String characterType) {
		this.characters = new ArrayList<Characters>();

		try {
			for (int i = 0; i < 6; i++) {
				Class<Characters> clazz = (Class<Characters>) Class.forName("poe.tp.wow.characters." + characterType);
				Constructor<Characters> constructor = clazz.getConstructor();
				Characters instance = constructor.newInstance();
				this.characters.add(instance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Characters> getCharacters() {
		return this.characters;
	}

	public static void setEnnemies(List<Characters> listCharacters, List<Characters> listEnnemies) {
		int rand = 0;
		if (listCharacters.size() > 0 && listEnnemies.size() > 0) {
			for (Characters c : listCharacters) {
				rand = new Random().nextInt(listEnnemies.size());
				c.setEnnemy(listEnnemies.get(rand));
				listEnnemies.get(rand).setEnnemy(c);
			}
		}
	}
}
